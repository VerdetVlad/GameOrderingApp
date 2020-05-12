package manager.orders;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.stage.*;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import utilities.AlertBox;
import utilities.SpellCheck;


public class AnswerOrder {

    private static int retValue;



    public static int display()
    {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Response");
        window.setMinWidth(200);
        window.setMinHeight(100);



        Button noButton = new Button("Close");
        Button yesButton = new Button("Respond");
        TextField time = new TextField();


        noButton.setOnAction(e ->
        {
            retValue =-1;
            window.close();

        });

        yesButton.setOnAction(e ->
        {
            retValue = checkValue(time.getText());
            if(retValue == -1) return;

            window.close();

        });

        Label mes = new Label("Delivery time(days): ");

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15,15,15,15));
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(yesButton,noButton);


        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(15,15,15,15));
        hBox2.setSpacing(10);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(mes,time);






        VBox layout = new VBox();
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(hBox2,hBox);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return retValue;
    }

    private static int checkValue(String text)
    {
        if(SpellCheck.isEmpty(text)){
            AlertBox.display("Error","You must add a value for time.");
            return -1;
        }


        int val;
        try {
            val = Integer.parseInt(text);
        }
        catch (NumberFormatException e)
        {
            AlertBox.display("Error","Value must contain only numbers.");
            val=-1;
        }

        if(SpellCheck.tooLong(text,5))
        {
            AlertBox.display("Error","No delivery takes that long...");
            return -1;
        }

        return val;
    }

}
