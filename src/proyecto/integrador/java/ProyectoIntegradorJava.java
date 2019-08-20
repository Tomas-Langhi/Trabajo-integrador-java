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

        Sqlite  miBaseDb=new Sqlite();
        miBaseDb.conectar();
        miBaseDb.crearTabla("alumno");
        miBaseDb.insertaDatos(17, "Jose", "Ojeda","Bien");
        miBaseDb.insertaDatos(18, "Juan", "Martin","Bien");
        miBaseDb.consultaDatos("alumno");
        miBaseDb.ActualizarDatos("alumno", 18, "Notable");
        miBaseDb.consultaDatos("alumno");
        miBaseDb.BorrarDatos("alumno", 17);
        miBaseDb.consultaDatos("alumno");
    }

}
