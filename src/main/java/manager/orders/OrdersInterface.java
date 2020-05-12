package manager.orders;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import manager.list.GameProduct;
import manager.list.ReadStoreData;
import manager.list.WriteStoreData;
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
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("user"));

        TableColumn<OrderObject, String> genCol = new TableColumn<>("GAME");
        genCol.setMinWidth(200);
        genCol.setCellValueFactory(new PropertyValueFactory<>("game"));






        Button closeButton = new Button("Close Window");
        closeButton.setOnAction(e-> window.close());

        Button addButton = new Button("Add Game");
        addButton.setOnAction(e -> addButtonClick(fileName));

        Button delButton = new Button("Delete Game");
        delButton.setOnAction(e -> delButtonClick(fileName));


        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15,15,15,15));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(addButton,delButton);




        table = new TableView<>();
        table.setItems(getOrders(fileName));
        table.getColumns().addAll(nameCol,genCol);

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
       /* GameProduct game = new GameProduct();

        if(SpellCheck.basicCheck(addName.getText()))
        {
            addName.clear();
            addGenre.setValue("Action");
            addPrice.clear();
            return;
        }
        game.setName(addName.getText());




        game.setGenre(addGenre.getValue());

        try
        {
            if(SpellCheck.tooManyDecimals(Double.parseDouble(addPrice.getText())))
            {
                AlertBox.display("Error","Price has too many decimals");
                addName.clear();
                addGenre.setValue("Action");
                addPrice.clear();
                return;
            }
            game.setPrice(Double.parseDouble(addPrice.getText()));
        }
        catch (Exception e)
        {
            AlertBox.display("Error","Bad Price Imput");
            addName.clear();
            addGenre.setValue("Action");
            addPrice.clear();
            return;
        }

        table.getItems().add(game);

        addName.clear();
        addGenre.setValue("Action");
        addPrice.clear();

        WriteStoreData.writeData(products,fileName);*/
    }

    public static void delButtonClick(String fileName)
    {

       /* if(!(AlertBox2.display("Warning","Are you sure?"))) return;

        ObservableList <GameProduct> selectedProd, allProd;
        allProd = table.getItems();
        selectedProd = table.getSelectionModel().getSelectedItems();
        selectedProd.forEach(allProd::remove);

        WriteStoreData.writeData(products,fileName);*/
    }




}