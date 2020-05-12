package manager.orders;

public class OrderObject {
    private String user, game;


    public OrderObject()
    {
        this.user = "";
        this.game = "";
    }

    public OrderObject(String name, String genre, double price)
    {
        this.user = name;
        this.game = genre;
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

}
