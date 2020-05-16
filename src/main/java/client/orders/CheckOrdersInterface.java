package client.orders;

import client.list.Stores;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import client.orders.ReadOrder;
import javafx.util.Callback;
import manager.list.GameProduct;
import manager.list.WriteStoreData;
import utilities.AlertBox2;
import utilities.AlertBox;


import java.awt.event.ActionEvent;

public class CheckOrdersInterface {
    private static Stage window;
    private static TableView<Order> table;
    private static ObservableList<Order> products = FXCollections.observableArrayList();

    public static void display(String fileName) {
        window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Log In");
        window.setMinWidth(200);
        window.setMinHeight(300);

        Button closeButton = new Button("Close Window");
        closeButton.setOnAction(e -> window.close());


        TableColumn<Order, String> nameCol = new TableColumn<>("Manager NAME");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nameManager"));

        TableColumn<Order, String> gameCol = new TableColumn<>("GAME");
        gameCol.setMinWidth(200);
        gameCol.setCellValueFactory(new PropertyValueFactory<>("game"));

        TableColumn<Order, String> statusCol = new TableColumn<>("STATUS");
        statusCol.setMinWidth(200);
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));


        table = new TableView<>();
        table.setItems(getGames(fileName));
        table.getColumns().addAll(nameCol, gameCol, statusCol);

        addButtonToTable(fileName);


        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.getChildren().addAll(closeButton, table);

        Scene scene = new Scene(vBox);

        window.setScene(scene);
        window.showAndWait();
    }

    public static ObservableList<Order> getGames(String fileName) {
        products = ReadOrder.getData(fileName);
        return products;
    }


    private static void addButtonToTable(String fileName) {
        TableColumn<Order, Void> colBtn = new TableColumn("Button Column");

        Callback<TableColumn<Order, Void>, TableCell<Order, Void>> cellFactory = new Callback<TableColumn<Order, Void>, TableCell<Order, Void>>() {
            @Override
            public TableCell<Order, Void> call(final TableColumn<Order, Void> param) {
                final TableCell<Order, Void> cell = new TableCell<Order, Void>() {

                    private final Button btn = new Button("Delivered");

                    {
                        btn.setOnAction(e -> {

                            boolean ans = AlertBox2.display("Warning", "Are you sure?");
                            if(!ans) return;

                            Order a = getTableView().getItems().get(getIndex());
                            a.setStatus("Delivered");

                            AlertBox.display("OK",a.getGame() + " has been delivered succesfully");


                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        table.getColumns().add(colBtn);

    }

}