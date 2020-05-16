package client.list;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import manager.list.ReadStoreData;
import manager.list.GameProduct;
import manager.list.WriteStoreData;
import utilities.AlertBox;
import utilities.AlertBox2;
import utilities.SpellCheck;

public class OpenStore
{
        private static Stage window;
        private static TableView<GameProduct> table;
        private static ObservableList<GameProduct> products = FXCollections.observableArrayList();


        public static void display(String manag, String client)
        {
            window = new Stage();

            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Log In");
            window.setMinWidth(200);
            window.setMinHeight(300);

            TableColumn<GameProduct, String> nameCol = new TableColumn<>("NAME");
            nameCol.setMinWidth(200);
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

            TableColumn<GameProduct, String> genCol = new TableColumn<>("GENRE");
            genCol.setMinWidth(200);
            genCol.setCellValueFactory(new PropertyValueFactory<>("genre"));

            TableColumn<GameProduct, Double> priceCol = new TableColumn<>("PRICE");
            priceCol.setMinWidth(100);
            priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));


            Button closeButton = new Button("Close Window");
            closeButton.setOnAction(e-> window.close());

            Button buyButton = new Button("Buy product");
            buyButton.setOnAction(e -> {
                boolean ans = ConfirmBox.display("Buy product", "Are you sure you want to buy this product?");
                if(ans){
                    String game = table.getSelectionModel().getSelectedItems().get(0).getName();
                    WriteManagerMessage.send(manag, client, game);
                }

            });

            table = new TableView<>();
            table.setItems(getGames("M-" + manag));
            table.getColumns().addAll(nameCol,genCol,priceCol);

            HBox hBox = new HBox();
            hBox.setPadding(new Insets(15, 15, 15, 15));
            hBox.setSpacing(10);
            hBox.getChildren().addAll(buyButton);

            VBox vBox = new VBox();
            vBox.setPadding(new Insets(10,10,10,10));
            vBox.getChildren().addAll(closeButton, table, hBox);

            Scene scene = new Scene(vBox);

            window.setScene(scene);
            window.showAndWait();
        }

        public static ObservableList<GameProduct> getGames(String fileName)
        {
            products = ReadStoreData.getData(fileName);
            return products;
        }
}
