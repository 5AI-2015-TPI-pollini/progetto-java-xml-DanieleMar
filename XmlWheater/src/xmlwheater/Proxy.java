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
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Proxy {

    private String nome;
    private String password;

    Proxy() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Proxy(final String nome, final String password) {
        this.nome = nome;
        this.password = password;
        System.setProperty("proxySet", "true");
        System.setProperty("http.proxyHost", "192.168.0.1");
        System.setProperty("http.proxyPort", "8080");
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                
                return new PasswordAuthentication(nome,password.toCharArray());
            }
        });
    }
    private static class ProxyAuthenticator extends Authenticator {

        public ProxyAuthenticator(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }



    private String userName, password;

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password.toCharArray());
    }
    
    }
}

