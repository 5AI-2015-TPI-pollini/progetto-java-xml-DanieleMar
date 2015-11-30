/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlwheater;

/**
 *
 * @author danieleeasy
 */


import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
public class connection {


    private String place;
    public connection(String s) throws MalformedURLException, IOException
    {
            place=s;
            URL url = new URL("http://www.google.com/maps/api/geocode/xml?address=" + place);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
            PrintWriter out = new PrintWriter(new FileWriter("Luogo.xml"));
            String output;
            while ((output = in.readLine()) != null)
                out.println(output);
            in.close();
            out.close();
    }
    
}

