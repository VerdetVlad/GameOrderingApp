package startScreen;

import register.Register;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import register.Register;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class StartScreen extends Application {

    Stage window;
    Button loginButton, registerButton;
    Scene mainScene, regScene;

    public static void main(String[] args){
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("Game Ordering Application");

        loginButton =  new Button("Log In");
        registerButton = new Button("Register");


        VBox layout = new VBox(20);
        layout.getChildren().addAll(loginButton,registerButton);
        layout.setAlignment(Pos.CENTER);
        mainScene = new Scene(layout,400,400);
        registerButton.setOnAction(e -> Register.display());







        window.setScene(mainScene);
        window.show();





    }


}
