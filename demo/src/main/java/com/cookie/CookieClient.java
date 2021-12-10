package com.cookie;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class CookieClient{

    public static void main(String[] args) throws IOException {
        Integer port = Integer.parseInt(args[0]);

        Socket socket = new Socket("localhost", port);
        System.out.println("CookieClient connected to server at port " + 12345);
        try(
            // input from server
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(new BufferedInputStream(is));

            // output to server
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(os));

            // input from console
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
            ){
            
            String msg = "";
            msg = br.readLine();
            while(!msg.equals("exit")){
        
                if(msg.equals("get-cookie")){
                    System.out.println("User's message: "+ msg);
                    dos.writeUTF(msg);
                    dos.flush();
                    System.out.println("User's message sent: "+ msg);
                }

                String cookieReceived = dis.readUTF();
                String message = cookieReceived.replaceAll("cookie-text", "");
                System.out.println(message);

                msg = br.readLine();
            }
            
        }

        
        
    }
    

    
}