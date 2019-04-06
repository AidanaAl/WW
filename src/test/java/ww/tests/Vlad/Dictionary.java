package ww.tests.Vlad;

import java.io.FileNotFoundException;

public class Dictionary {

    public static void doesFileExist(String path) {
        String word = "";
        for (int i = 0; i < 3 ; i++) {
            if(path.contains("Apple")){
                word = "Apple";
            } else if(path.contains("Table")){
                word = "Table";
            } else if(path.contains("Orange")){
                word = "Orange";
            }
        }

        switch (word) {
            case "Apple":
                System.out.println("Meaning 1: Apple - " + "A fruit. An apple is a sweet, edible fruit produced by an apple tree (Malus pumila)");
                System.out.println("Meaning 2: Apple - " + "A tech firm. Apple Inc. is an American multinational technology company headquartered in Cupertino, California, that designs, develops, and sells consumer electronics, computer software, and online services.");
                break;
            case "Table":
                System.out.println("Meaning 1: Table - " + "An object. Table (furniture), an item of furniture with a flat top and one or more legs.");
                System.out.println("Meaning 2: Table - " + "Contains rows and columns when used in context of computers. The Table object exposes the attributes of a single Microsoft SQL Server table.");
                break;
            case "Orange":
                System.out.println("Meaning 1: Orange - " + "A fruit. The orange is the fruit of the citrus species Citrus × sinensis in the family Rutaceae.");
                break;
            default:
                try {
                    throw new FileNotFoundException("The file does not exist, please try different Query from second Table and Column");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

        }
        }
    }
