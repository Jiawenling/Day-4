package com.cookie;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cookie {

    public String openCookie(String filepath) throws FileNotFoundException{
        List<String> cookieList = new ArrayList<>();

        ClassLoader loader = Test2.class.getClassLoader();
        InputStream in = loader.getResourceAsStream("com/cookie/"+filepath);
        // File file = new File(filepath);
        Scanner myReader = new Scanner(in);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            cookieList.add(data);
        }           

        

        int max = cookieList.size()-1;
        int rndChoice = (int) (Math.random()*(max+1));
        String choice = cookieList.get(rndChoice);
        System.out.println(choice);

        myReader.close();
        return choice;
        

    }

}




