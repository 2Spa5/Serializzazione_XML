package com.example;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        Alunno a1 = new Alunno("Mario", "Rossi");
        Alunno a2 = new Alunno("Paolo", "Bianchi");
        Alunno a3 = new Alunno("Laura", "Verdi");
        Alunno a4 = new Alunno("Patrizia", "Blu");

        Classe c1 = new Classe(5, "AIA", "04-TC");

        c1.insertNewAlunno(a1);
        c1.insertNewAlunno(a2);
        c1.insertNewAlunno(a3);
        c1.insertNewAlunno(a4);

        XmlMapper xmlMapper = new XmlMapper();
        
        ServerSocket server = null;
        try {

            server = new ServerSocket(3000);
            while (true) {
                Socket s = server.accept();
                System.out.println("Server avviato");
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                out.writeBytes(xmlMapper.writeValueAsString(c1) + "\n");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            server.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.exit(1);
    }
}
