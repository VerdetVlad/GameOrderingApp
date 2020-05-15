package manager.orders;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;

import utilities.AlertBox;
import utilities.AlertBox2;

import javafx.scene.layout.*;

import javafx.scene.Scene;
import javafx.stage.Stage;

import utilities.SpellCheck;


public class OrdersInterface {

    private static Stage window;
    private static TableView<OrderObject> table;
    private static ObservableList <OrderObject> products = FXCollections.observableArrayList();


    public static void display(String fileName)
    {


        window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Log In");
        window.setMinWidth(200);
        window.setMinHeight(300);

        TableColumn<OrderObject, String> nameCol = new TableColumn<>("BUYER");
        nameCol.setMinWidth(150);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("user"));

        TableColumn<OrderObject, String> genCol = new TableColumn<>("GAME");
        genCol.setMinWidth(150);
        genCol.setCellValueFactory(new PropertyValueFactory<>("game"));

        TableColumn<OrderObject, String> statCol = new TableColumn<>("STATUS");
        statCol.setMinWidth(150);
        statCol.setCellValueFactory(new PropertyValueFactory<>("status"));





        Button closeButton = new Button("Close Window");
        closeButton.setOnAction(e-> window.close());

        Button addButton = new Button(" Answer order ");
        addButton.setOnAction(e ->
        {
           addButtonClick(fileName);
        });

        Button delButton = new Button(" Reject order ");
        delButton.setOnAction(e -> delButtonClick(fileName));


        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15,15,15,15));
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(addButton,delButton);




        table = new TableView<>();
        table.setItems(getOrders(fileName));
        table.getColumns().addAll(nameCol,genCol,statCol);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(closeButton,table,hBox);
        Scene scene = new Scene(vBox);

        window.setScene(scene);
        window.showAndWait();


    }

    public static ObservableList<OrderObject> getOrders(String fileName)
    {


        products = ReadOrder.getData(fileName);


        return products;
    }


    public static void addButtonClick(String fileName)
    {



        ObservableList <OrderObject> selectedProd, allProd;
        allProd = table.getItems();
        selectedProd = table.getSelectionModel().getSelectedItems();

        if(selectedProd.size()==0) return;

        int n;
        if( (n = AnswerOrder.display()) == -1) return;

        OrderObject a = selectedProd.get(0);

        if(!a.getStatus().equals("Pending"))
        {
            AlertBox.display("Error","Item status already set");
            return;
        }


        a.setStatus("Answered - " + n);

        selectedProd.forEach(allProd::remove);
        table.getItems().add(a);

        WriteManagerOrders.writeData(table.getItems(),fileName);

        WriteClientMessage.send(a,fileName);


    }

    public static void delButtonClick(String fileName)
    {


        ObservableList <OrderObject> selectedProd, allProd;
        allProd = table.getItems();
        selectedProd = table.getSelectionModel().getSelectedItems();

        if(selectedProd.size()==0) return;
        if(!AlertBox2.display("Warning","Are you sure?")) return;

        OrderObject a = selectedProd.get(0);

        if(!a.getStatus().equals("Pending"))
        {
            AlertBox.display("Error","Item status already set");
            return;
        }

        a.setStatus("Rejected");

        selectedProd.forEach(allProd::remove);
        table.getItems().add(a);

        WriteManagerOrders.writeData(table.getItems(),fileName);

        WriteClientMessage.send(a,fileName);
    }




}