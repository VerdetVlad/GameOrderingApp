package client.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;

import javafx.scene.layout.*;

import javafx.scene.Scene;
import javafx.stage.Stage;


public class SeeStoresInterface {

    private static Stage window;
    private static TableView<Stores> table;
    private static ObservableList<Stores> products = FXCollections.observableArrayList();


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
        products = ReadStores.getData();
        return products;
    }

    public static void clickButtonClick(String fileName)
    {
        Stores a = table.getSelectionModel().getSelectedItems().get(0);
        OpenStore.display(a.getName(),fileName);
    }
}
