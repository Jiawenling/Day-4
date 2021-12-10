package com.cookie;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CookieServer {
    
    public static void main(String[] args) throws IOException {
        int portNumber = Integer.parseInt(args[0]);
        ServerSocket serverSocket= new ServerSocket(portNumber);
        Socket socket = serverSocket.accept();
        System.out.println("CookieServer listening at port "+portNumber);
        String filepath = args[1];
       
      

        try(
            // input from client
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(new BufferedInputStream(is));

            //output to client
            OutputStream os = socket.getOutputStream();
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

            socket.close();
            serverSocket.close();
        }
    }
}

