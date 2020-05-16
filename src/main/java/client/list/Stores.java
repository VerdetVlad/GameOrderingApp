package client.list;

public class Stores
{
    private String name;

    public Stores()
    {
        this.name = "";
    }

    public Stores (String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

