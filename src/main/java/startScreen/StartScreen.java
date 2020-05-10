package startScreen;

import com.sun.org.apache.xpath.internal.SourceTree;
import register.AlertBox;

import register.RegisterInterface;
import login.LogInInterface;
import manager.ManagerMainMenu;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import javafx.application.Application;

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
        loginButton.setOnAction(e -> {

            int res = LogInInterface.display();

            if(res == 1)
            {
                System.out.println("Client");
            }
            else
            {
                window.setScene(ManagerMainMenu.getMenu());
            }


        });



        window.setScene(mainScene);
        window.show();



    }


}
