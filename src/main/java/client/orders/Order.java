package client.orders;

import javafx.beans.property.SimpleStringProperty;

import java.awt.*;

public class Order
{
    private String nameManager;
    private String game;
    private String status;


    public Order()
    {
        this.nameManager = "";
        this.game = "";
        this.status = "";


    }

    public Order(String nameManager, String game, String status)
    {
        this.nameManager = nameManager;
        this.game = game;
        this.status = status;
    }

    public String getNameManager() {
        return nameManager;
    }

    public void setNameManager(String nameManager) {
        this.nameManager = nameManager;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {

        this.status =status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "nameManager='" + nameManager + '\'' +
                ", game='" + game + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
