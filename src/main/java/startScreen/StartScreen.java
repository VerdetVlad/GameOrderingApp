package startScreen;

import register.RegisterInterface;
import login.LogInInterface;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

        registerButton.setOnAction(e -> RegisterInterface.display());
        loginButton.setOnAction(e -> LogInInterface.display());



        window.setScene(mainScene);
        window.show();



    }


}
