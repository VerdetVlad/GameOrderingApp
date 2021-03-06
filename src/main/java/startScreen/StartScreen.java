package startScreen;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import register.RegisterInterface;
import login.LogInInterface;
import manager.ManagerMainMenu;
import client.ClientMainMenu;

import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import javafx.application.Application;

public class StartScreen extends Application {

    private static Stage window;
    private static Button loginButton, registerButton,closeButton;
    private static Scene mainScene, regScene;

    public static void main(String[] args){
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("Game Ordering Application ");

        loginButton =  new Button("Log In");
        registerButton = new Button("Register");
        closeButton = new Button("Exit");


        Label goa = new Label("Welcome to GOA");
        Label goa2 = new Label("The Game Ordering Application");

        HBox layout = new HBox();
        layout.setPadding(new Insets(15,15,15,15));
        layout.setSpacing(10);
        layout.getChildren().addAll(loginButton,registerButton);
        layout.setAlignment(Pos.CENTER);


        VBox layout2 = new VBox();
        layout2.setPadding(new Insets(15,15,15,15));
        layout2.setSpacing(10);
        layout2.getChildren().addAll(goa,goa2,layout,closeButton);
        layout2.setAlignment(Pos.CENTER);

        mainScene = new Scene(layout2,400,400);

        registerButton.setOnAction(e -> RegisterInterface.display());
        loginButton.setOnAction(e -> {

            String res;
            res = LogInInterface.display();

            if(res.charAt(0)=='C')
            {
                window.setScene(ClientMainMenu.getMenu(window, mainScene, res));
            }
            else if (res.charAt(0)=='M')
            {
                window.setScene(ManagerMainMenu.getMenu(window, mainScene, res));
            }
        });

        closeButton.setOnAction(e -> window.close());

        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        window.setScene(mainScene);
        window.show();


    }



}
