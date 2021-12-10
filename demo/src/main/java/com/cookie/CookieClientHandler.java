package com.cookie;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class CookieClientHandler implements Runnable {

    private final Socket clientSocket;
    private final String filepath;

    public CookieClientHandler(Socket clientSocket, String filepath){
        this.clientSocket = clientSocket;
        this.filepath = filepath;
    }

    public void run(){
        try(
            // input from client
            InputStream is = clientSocket.getInputStream();
            DataInputStream dis = new DataInputStream(new BufferedInputStream(is));

            //output to client
            OutputStream os = clientSocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(os)); )
        {
            
            String msg = "";  
            msg = dis.readUTF();
            while(!msg.equals("close")) {
                
                if (msg.equals("get-cookie")){
                    Cookie newCookie = new Cookie();
                    System.out.println("User sent: "+ msg);
                    dos.writeUTF(newCookie.openCookie(filepath));
                    dos.flush();
                } 
                
                else{
                    System.out.println("Client sent invalid command!");
                }   

                msg = dis.readUTF();
            }

            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
       
    
    
}
