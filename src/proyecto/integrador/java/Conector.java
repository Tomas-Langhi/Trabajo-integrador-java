/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.integrador.java;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conector {
     
    String url = "/home/nico/NetBeansProjects/Trabajo-integrador-java/base-de-prueva.db";
    Connection connect;
     
    public void connect(){
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            if (connect!=null) {
                System.out.println("Conectado");
            }
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
        }
    }
    public void close(){
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveAlumno(Alumno alumno){
        try {
            PreparedStatement st = connect.prepareStatement("insert into alumnos (nombre, apellidos) values (?,?)");
            st.setString(1, alumno.getNombre());
            st.setString(2, alumno.getApellidos());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    
}