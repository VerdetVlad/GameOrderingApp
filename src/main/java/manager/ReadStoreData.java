package manager;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.file.Files;



public class ReadStoreData {


    public static ObservableList<GameProduct> getData(String path)
    {
        try {
            return get(path);
        }
        catch (Exception e)
        {
            return null;
        }
    }




    private static ObservableList<GameProduct> get(String name) throws Exception
    {

        ObservableList<GameProduct> games = FXCollections.observableArrayList();
        final File storeFile = new File(System.getProperty("user.dir") +
                                        "\\Stores\\" + name + ".txt");

        storeFile.getParentFile().mkdirs();
        storeFile.createNewFile();


        BufferedReader readFile = new BufferedReader(new FileReader(storeFile));
        String line =  readFile.readLine();
        while(line != null)
        {
            GameProduct aux = makeGame(line);
            games.add(aux);
            line = readFile.readLine();
        }
        readFile.close();

        return games;
    }


    public static GameProduct makeGame(String line)
    {
        GameProduct game = new GameProduct();
        String[] aux=null;
        int i;

        aux = line.split(",");
        game.setName(aux[0]);

        game.setGenre(aux[1]);

        game.setPrice(Double.parseDouble(aux[2]));


        return game;
    }

}
