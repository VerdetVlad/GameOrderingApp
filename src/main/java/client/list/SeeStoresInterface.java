package client.list;

import client.orders.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;

import javafx.scene.layout.*;

import javafx.scene.Scene;
import javafx.stage.Stage;


public class SeeStoresInterface {

    private static Stage window;
    private static TableView<Stores> table;


    public static void display(String fileName) {
        window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Log In");
        window.setMinWidth(200);
        window.setMinHeight(300);

        TableColumn<Stores, String> nameCol = new TableColumn<>("NAME");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));


        Button closeButton = new Button("Close Window");
        closeButton.setOnAction(e -> window.close());

        Button clickButton = new Button("Open shop");
        clickButton.setOnAction(e -> clickButtonClick(fileName));


       /* table.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                       @Override
                                       public void handle(MouseEvent click) {

                                           if (click.getClickCount() == 2) {
                                               //Use ListView's getSelected Item
                                               Stores a = table.getSelectionModel()
                                                       .getSelectedItem();
                                               OpenStore.display(a.getName(),fileName);
                                               //use this to do whatever you want to. Open Link etc.
                                           }
                                       }
                                   });*/



        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(clickButton);


        table = new TableView<>();
        table.setItems(getGames());
        table.getColumns().addAll(nameCol);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.getChildren().addAll(closeButton, table, hBox);

        Scene scene = new Scene(vBox);

        window.setScene(scene);
        window.showAndWait();
    }

    public static ObservableList<Stores> getGames() {

        return ReadStores.getData();
    }

    public static void clickButtonClick(String fileName)
    {
        Stores a = table.getSelectionModel().getSelectedItems().get(0);
        OpenStore.display(a.getName(),fileName);
    }
}
