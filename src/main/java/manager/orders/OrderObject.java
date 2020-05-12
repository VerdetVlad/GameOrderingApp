package manager.orders;

public class OrderObject {
    private String user, game,status;


    public OrderObject()
    {
        this.user = "";
        this.game = "";
        this.status="";
    }

    public OrderObject(String name, String genre, String status)
    {
        this.user = name;
        this.game = genre;
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String name) {
        this.user = name;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String genre) {
        this.game = genre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
