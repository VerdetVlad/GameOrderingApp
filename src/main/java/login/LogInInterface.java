package login;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import register.AlertBox;

import javafx.stage.*;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.io.File;

public class LogInInterface {

    private static TextField nameImput, pasImput;
    private static int returnValue;

    public static int display()
    {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Log In");
        window.setMinWidth(200);
        window.setMinHeight(300);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(8);
        grid.setHgap(10);


        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);
        nameImput = new TextField();
        nameImput.setPromptText("username");
        GridPane.setConstraints(nameImput,1,0);


        Label pasLabel = new Label("Password:");
        GridPane.setConstraints(pasLabel,0,1);
        pasImput = new TextField();
        pasImput.setPromptText("password");
        GridPane.setConstraints(pasImput,1,1);



        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton,2,4);
        loginButton.setOnAction(e ->
        {
            File f =CheckData.verifyData(nameImput.getText(), pasImput.getText());

            if(f == null)
            {
                AlertBox.display("Alert","Nu such account.Try again.");
                returnValue=0;


            }
            else
            if((f.getName()).charAt(0) == 'C')
            {
                AlertBox.display("Success", "Logged In as CLIENT");
                returnValue=1;
                window.close();

            }
            else
            {
                AlertBox.display("Success", "Logged In as MANAGER");
                returnValue=2;
                window.close();
            }

        });

        Button closeButton = new Button("Close");
        GridPane.setConstraints(closeButton,0,4);
        closeButton.setOnAction(e -> window.close());

        grid.getChildren().addAll(nameImput,nameLabel,
                pasImput,pasLabel,

                loginButton,closeButton);

        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.showAndWait();

        return returnValue;

    }



}
