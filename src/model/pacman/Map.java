package model.pacman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {
    private ArrayList<Character> map;

    public ArrayList<Character> getMap() {
        return map;
    }

    public Map(String mapPath) {
        map = new ArrayList<Character>();
        try {
            File myObj = new File(mapPath);
            System.out.println(myObj.getAbsolutePath());
            Scanner mapReader = new Scanner(myObj);
            while (mapReader.hasNextLine()) {
                String data = mapReader.nextLine();
                for(int i=0;i<19;i++)
                    map.add(data.charAt(i));
            }
            mapReader.close();
        } catch (FileNotFoundException e) {
            System.out.println();
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
