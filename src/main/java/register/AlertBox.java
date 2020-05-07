package register;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.stage.*;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class AlertBox {


    public static void display()
    {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Confirmation");
        window.setMinWidth(200);
        window.setMinHeight(100);


        Button closeButton = new Button("OK");
        closeButton.setOnAction(e -> window.close());

        Label mes = new Label("The account has been made");

        VBox layout = new VBox();
        layout.getChildren().addAll(mes,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }


}
