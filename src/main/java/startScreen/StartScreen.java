package startScreen;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
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


        HBox layout = new HBox();
        layout.setPadding(new Insets(15,15,15,15));
        layout.setSpacing(10);
        layout.getChildren().addAll(loginButton,registerButton);
        layout.setAlignment(Pos.CENTER);
        mainScene = new Scene(layout,400,400);

        registerButton.setOnAction(e -> RegisterInterface.display());
        loginButton.setOnAction(e -> {

            String res = LogInInterface.display();

            if(res.charAt(0)=='C')
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
