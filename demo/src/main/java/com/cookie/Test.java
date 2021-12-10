package com.cookie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    
    
    
    public static void main(String[] args) throws FileNotFoundException {
        List<String> cookieList = new ArrayList<>();
        File file = new File("G:\\My Drive\\NUSISS\\Day 4\\Day-4\\cookie_file.txt");
        Scanner myReader = new Scanner(file);
        if (file.exists()){
            System.out.println("Reading file: " + file.getName());
        }
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            cookieList.add(data);
        }           

        

        int max = cookieList.size()-1;
        int rndChoice = (int) (Math.random()*(max+1));
        String choice = cookieList.get(rndChoice);
        System.out.println(choice);

        myReader.close();
       
    }
}
