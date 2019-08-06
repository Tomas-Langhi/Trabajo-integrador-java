/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.integrador.java;

import java.io.IOException;

/**
 *
 * @author nico
 */
public class ClienteMain {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Cliente client = new Cliente();
        client.startClient();
    }
    
}
