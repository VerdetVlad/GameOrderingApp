package register;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.stage.*;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class RegisterInterface {

    private static TextField nameImput, pasImput;
    private static CheckBox clientBox, managerBox;

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
        nameImput = new TextField();
        nameImput.setPromptText("username");
        GridPane.setConstraints(nameImput,1,0);


        Label pasLabel = new Label("Password:");
        GridPane.setConstraints(pasLabel,0,1);
        pasImput = new TextField();
        pasImput.setPromptText("password");
        GridPane.setConstraints(pasImput,1,1);


        Label typeLabel = new Label("Account Type:");
        GridPane.setConstraints(typeLabel,0,3);
        clientBox = new CheckBox("Client");
        GridPane.setConstraints(clientBox,1,3);
        managerBox = new CheckBox("Store Manager");
        GridPane.setConstraints(managerBox,1,4);




        Button regButton = new Button("Register");
        GridPane.setConstraints(regButton,2,5);
        regButton.setOnAction(e ->
        {
            MakeAccount.create(nameImput.getText(), pasImput.getText(),
                    clientBox.isSelected());
            AlertBox.display("Confirmation","Account created");
            window.close();
        });
        Button closeButton = new Button("Close");
        GridPane.setConstraints(closeButton,0,5);
        closeButton.setOnAction(e -> window.close());

        grid.getChildren().addAll(nameImput,nameLabel,
                pasImput,pasLabel,
                typeLabel,clientBox,managerBox,
                regButton,closeButton);

        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.showAndWait();
    }


}
