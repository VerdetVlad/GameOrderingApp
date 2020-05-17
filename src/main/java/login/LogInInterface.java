package login;


import utilities.AlertBox;
import utilities.AlertBox2;

import javafx.stage.*;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.io.File;

public class LogInInterface {

    private static TextField nameImput;
    private static PasswordField pasImput;
    private static String returnValue;

    public static String display()
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
        pasImput = new PasswordField();
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
                returnValue=null;


            }
            else
            if((f.getName()).charAt(0) == 'C')
            {
                AlertBox.display("Success", "Logged In as CLIENT");
                returnValue=f.getName();
                window.close();

            }
            else
            {
                AlertBox.display("Success", "Logged In as MANAGER");
                returnValue=f.getName();
                window.close();
            }

        });

        Button closeButton = new Button("Close");
        GridPane.setConstraints(closeButton,0,4);
        closeButton.setOnAction(e -> closeProgram(window));
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram(window);
        });

        grid.getChildren().addAll(nameImput,nameLabel,
                pasImput,pasLabel,
                loginButton,closeButton);

        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.showAndWait();

        return returnValue;

    }

    public static void closeProgram(Stage window)
    {
        if(!(AlertBox2.display("Leaving","Are you sure"))) return;
        returnValue="ZZZ";
        window.close();
    }




}
