package com.cookie;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.print.DocFlavor.URL;

public class Test2 {
    public static void main(String[] args) {

        String[] argz = {"<localhost>:<12345>"};
        String input = argz[0];
        input = input.replaceAll("[<>]", "");
        String[] inputs = input.split(":");
        Integer port = Integer.parseInt(inputs[1]);
        System.out.println(port);
        // ClassLoader loader = Test2.class.getClassLoader();
        // InputStream in = loader.getResourceAsStream("com/cookie/cookie_file.txt");
        // Scanner scanner = new Scanner(in);
        
        // List<String> cookieList = new ArrayList<>();
        // while (scanner.hasNextLine()) {
        //     String data = scanner.nextLine();
        //     cookieList.add(data);
        // }           
    
        
    
        // int max = cookieList.size()-1;
        // int rndChoice = (int) (Math.random()*(max+1));
        // String choice = cookieList.get(rndChoice);
        // System.out.println(choice);

        // scanner.close();
    
    }
   
}  

