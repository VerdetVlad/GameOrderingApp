package manager;

import manager.list.GamesListInterface;
import manager.orders.OrdersInterface;
import utilities.AlertBox;


import javafx.geometry.Insets;
import javafx.scene.layout.HBox;


import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import utilities.AlertBox2;

public class ManagerMainMenu {

    private static Scene scene;
    private static Button closeButton, listButton, ordersButton;

    public static Scene getMenu(Stage window, Scene startScene, String fileName)
    {


        listButton =  new Button("See Game List");
        ordersButton = new Button("See Orders");
        closeButton = new Button("Log out");


        HBox layout = new HBox();
        layout.setPadding(new Insets(15,15,15,15));
        layout.setSpacing(10);
        layout.getChildren().addAll(listButton,ordersButton);
        layout.setAlignment(Pos.CENTER);


        VBox layout2 = new VBox();
        layout2.setAlignment(Pos.CENTER);
        layout2.getChildren().addAll(layout,closeButton);

        scene = new Scene(layout2,400,400);

        closeButton.setOnAction(e -> {
            if(!(AlertBox2.display("","Are you sure you want to log out?")))return;
            window.setScene(startScene);
        });

        listButton.setOnAction(e -> {
            GamesListInterface.display(fileName);

        });

        ordersButton.setOnAction(e -> {
            OrdersInterface.display(fileName);
        });



        return scene;



    }
}