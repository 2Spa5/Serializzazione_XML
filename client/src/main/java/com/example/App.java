package com.example;

import java.io.BufferedReader;
//import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class App {
    public static void main(String[] args) {
        Socket s = null;
        try {

            s = new Socket("localhost", 3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String st = "";
            XmlMapper xmlMapper = new XmlMapper();

            System.out.println(st);

            while (true) {
                st = in.readLine();
                Classe c = xmlMapper.readValue(st, Classe.class);
                System.out.println(c.toString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            if(s != null)
            s.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
