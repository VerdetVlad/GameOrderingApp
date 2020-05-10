package manager;

import register.AlertBox;



import com.sun.javafx.font.freetype.HBGlyphLayout;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;


import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.BufferedReader;

public class ManagerMainMenu {

    private static Scene scene;
    private static Button closeButton, listButton, ordersButton;

    public static Scene getMenu(String fileName)
    {


        listButton =  new Button("See Game List");
        ordersButton = new Button("See Orders");
        closeButton = new Button("Close");


        HBox layout = new HBox();
        layout.setPadding(new Insets(15,15,15,15));
        layout.setSpacing(10);
        layout.getChildren().addAll(closeButton, listButton,ordersButton);
        layout.setAlignment(Pos.CENTER);

        //HBox layaout2 = new HBox();

        scene = new Scene(layout,400,400);

        closeButton.setOnAction(e -> {

        });

        listButton.setOnAction(e -> {
            GamesListInterface.display(fileName);

        });

        ordersButton.setOnAction(e -> {
            AlertBox.display("ORDERS","ORDERS");

        });



        return scene;



    }
}