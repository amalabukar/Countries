package com.company;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileWriter;


public class Main {

    public static void main(String[] args) throws Exception {
        HashMap<String, ArrayList<Countries>> countries = new HashMap<>();
        ArrayList<Countries> nation = new ArrayList<>();

        File f = new File("countries");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Countries c = new Countries(columns[1], columns[0]);
            nation.add(c);


            if (countries.containsKey(c.name.substring(0, 1))) {

                ArrayList<Countries> a = countries.get(c.name.substring(0, 1));
                a.add(c);
            } else {
                ArrayList<Countries> a = new ArrayList<>();
                a.add(c);
                countries.put(c.name.substring(0, 1), a);

            }

            Scanner consoleScanner = new Scanner(System.in);
            System.out.println("Enter the first letter of the country");
            String input = consoleScanner.nextLine();
            if (input.length() > 1) {
                throw new Exception("Please enter the first letter");
            }

            ArrayList<Countries> a = countries.get(input.toLowerCase());
            File n = new File(input + "_Countries.txt");
            FileWriter fw = new FileWriter(n);
            for (Countries t : a) {
                fw.append(t.name + "\n");
            }
            fw.close();

        }


        // write your code here
    }
}
