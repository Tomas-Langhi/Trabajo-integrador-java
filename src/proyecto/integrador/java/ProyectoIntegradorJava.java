/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.integrador.java;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Tomas Langhi 
 */
public class ProyectoIntegradorJava {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws IOException, SQLException {
        // TODO code application logic here
        
        Alumno al = new Alumno("nicolas", "steffolani");
        al.save();
        
    }

}
