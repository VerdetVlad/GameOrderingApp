package manager.list;

public class GameProduct {

    private String name, genre;
    private double price;

    public GameProduct()
    {
        this.name = "";
        this.genre = "";
        this.price = 0;
    }

    public GameProduct(String name, String genre, double price)
    {
        this.name = name;
        this.genre = genre;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
