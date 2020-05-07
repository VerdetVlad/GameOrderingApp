package register;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.stage.*;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class Register  {


    public static void display()
    {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Registration");
        window.setMinWidth(200);
        window.setMinHeight(300);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(8);
        grid.setHgap(10);


        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);
        TextField nameImput = new TextField();
        nameImput.setPromptText("username");
        GridPane.setConstraints(nameImput,1,0);


        Label pasLabel = new Label("Password:");
        GridPane.setConstraints(pasLabel,0,1);
        TextField pasImput = new TextField();
        pasImput.setPromptText("password");
        GridPane.setConstraints(pasImput,1,1);

        Button regButton = new Button("Register");
        GridPane.setConstraints(regButton,2,3);
        regButton.setOnAction(e ->
        {
            AlertBox.display();
        });
        Button closeButton = new Button("Close");
        GridPane.setConstraints(closeButton,0,3);
        closeButton.setOnAction(e -> window.close());

        grid.getChildren().addAll(nameImput,nameLabel,pasImput,pasLabel,regButton,closeButton);

        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.showAndWait();
    }


}
