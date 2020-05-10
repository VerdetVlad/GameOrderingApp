package manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import register.AlertBox;
import register.AlertBox2;

import javafx.geometry.Pos;
import javafx.scene.layout.*;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;

import javafx.application.Application;

public class GamesListInterface extends Application{

    private static Stage window;
    private static TableView<GameProduct> table;
    private  TextField addName, addPrice;
    private static ChoiceBox<String> addGenre = new ChoiceBox<>();

    public static void main(String[] args){
        launch(args);

    }

    @Override
    public void start(Stage primaryStage)/* throws Exception*/
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


        //Data imput //////
        addName = new TextField();
        addName.setPromptText("Name");

        addGenre.getItems().addAll("Action", "Adventure",
                                    "Horror","Puzzle",
                                    "Shooter","Strategy");
        addGenre.setValue("Action");

        addPrice = new TextField();
        addPrice.setPromptText("Price");




        Button addButton = new Button("Add Game");
        addButton.setOnAction(e -> addButtonClick());



        Button delButton = new Button("Delete Game");
        delButton.setOnAction(e -> delButtonClick());


        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15,15,15,15));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(addName,addGenre,addPrice,addButton,delButton);




        table = new TableView<>();
        table.setItems(getGames());
        table.getColumns().addAll(nameCol,genCol,priceCol);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(table,hBox);


        Scene scene = new Scene(vBox);

        window.setScene(scene);
        window.showAndWait();


    }

    public static ObservableList<GameProduct> getGames()
    {
        ObservableList <GameProduct> product = FXCollections.observableArrayList();

        product.add(new GameProduct("God_Of_War","action",24.54));
        product.add(new GameProduct("Ceva","comedy",32.12));
        product.add(new GameProduct("AltCeva","puzzle",12.12));
        product.add(new GameProduct("GTA","action",5.60));

        return product;
    }


    public void addButtonClick()
    {
        GameProduct game = new GameProduct();

        game.setName(addName.getText());
        game.setGenre(addGenre.getValue());
        game.setPrice(Double.parseDouble(addPrice.getText()));

        table.getItems().add(game);

        addName.clear();
        addGenre.setValue("Action");
        addPrice.clear();
    }

    public void delButtonClick()
    {

        if(!(AlertBox2.display("Warning","Are you sure?"))) return;

        ObservableList <GameProduct> selectedProd, allProd;
        allProd = table.getItems();
        selectedProd = table.getSelectionModel().getSelectedItems();
        selectedProd.forEach(allProd::remove);
    }




}