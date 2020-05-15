import java.util.Objects;

//not a test itself
//used by ReadOrderTest
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderObject that = (OrderObject) o;
        return Objects.equals(getUser(), that.getUser()) &&
                Objects.equals(getGame(), that.getGame()) &&
                Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getGame(), getStatus());
    }
}
