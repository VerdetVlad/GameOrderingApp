package utilities;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.stage.*;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class AlertBox2 {

    private static boolean retValue;

    public static boolean display(String title, String message)
    {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(200);
        window.setMinHeight(100);


        Button noButton = new Button("NO");
        Button yesButton = new Button("YES");


        noButton.setOnAction(e ->
        {
           retValue =false;
           window.close();

        });

        yesButton.setOnAction(e ->
        {
            retValue =true;
            window.close();

        });

        Label mes = new Label(message);

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15,15,15,15));
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(yesButton,noButton);


        VBox layout = new VBox();
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(mes,hBox);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return retValue;
    }


}
