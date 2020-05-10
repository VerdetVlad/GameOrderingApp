package manager;

import register.AlertBox;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.BufferedReader;

public class ManagerMainMenu {

    private static Scene scene;
    private static Button listButton, ordersButton;

    public static Scene getMenu()
    {


        listButton =  new Button("See Game List");
        ordersButton = new Button("See Orders");


        VBox layout = new VBox(20);
        layout.getChildren().addAll(listButton,ordersButton);
        layout.setAlignment(Pos.CENTER);
        scene = new Scene(layout,400,400);


        listButton.setOnAction(e -> {
            AlertBox.display("MENU","MENU");

        });

        ordersButton.setOnAction(e -> {
            AlertBox.display("ORDERS","ORDERS");

        });



        return scene;



    }
}
