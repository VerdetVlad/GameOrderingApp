package manager.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import utilities.AlertBox;
import utilities.AlertBox2;

import javafx.scene.layout.*;

import javafx.scene.Scene;
import javafx.stage.Stage;

import utilities.SpellCheck;


public class GamesListInterface {

    private static Stage window;
    private static TableView<GameProduct> table;
    private static TextField addName, addPrice;
    private static ObservableList <GameProduct> products = FXCollections.observableArrayList();


    public static void display(String fileName)
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

        ChoiceBox<String> addGenre = new ChoiceBox<>();
        addGenre.getItems().removeAll();
        addGenre.getItems().addAll("Action", "Adventure",
                                    "Horror","Puzzle","Racing",
                                    "Shooter","Strategy");
        addGenre.setValue("Action");

        addPrice = new TextField();
        addPrice.setPromptText("Price");


        Button closeButton = new Button("Close Window");
        closeButton.setOnAction(e-> window.close());

        Button addButton = new Button("Add Game");
        addButton.setOnAction(e -> addButtonClick(fileName,addGenre));



        Button delButton = new Button("Delete Game");
        delButton.setOnAction(e -> delButtonClick(fileName));


        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15,15,15,15));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(addName,addGenre,addPrice,addButton,delButton);




        table = new TableView<>();
        table.setItems(getGames(fileName));
        table.getColumns().addAll(nameCol,genCol,priceCol);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(closeButton,table,hBox);


        Scene scene = new Scene(vBox);

        window.setScene(scene);
        window.showAndWait();


    }

    public static ObservableList<GameProduct> getGames(String fileName)
    {


        products = ReadStoreData.getData(fileName);


        return products;
    }


    public static void addButtonClick(String fileName,ChoiceBox<String> addGenre)
    {
        GameProduct game = new GameProduct();

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

        WriteStoreData.writeData(table.getItems(),fileName);
    }

    public static void delButtonClick(String fileName)
    {

        if(!(AlertBox2.display("Warning","Are you sure?"))) return;

        ObservableList <GameProduct> selectedProd, allProd;
        allProd = table.getItems();
        selectedProd = table.getSelectionModel().getSelectedItems();
        selectedProd.forEach(allProd::remove);

        WriteStoreData.writeData(table.getItems(),fileName);
    }




}