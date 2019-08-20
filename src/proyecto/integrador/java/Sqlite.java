/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.integrador.java;
import java.sql.*;

public class Sqlite {
     Connection c=null;
     Statement sentencia=null;
     String nombreTabla;
     String Nombre,Apellidos,Nota;
     int ID;
     
    public void conectar(){
   
    try{
        Class.forName("org.sqlite.JDBC");
        c=DriverManager.getConnection("jdbc:sqlite:test.db");
        System.out.println("Exito al conectar con base de datos");
    }catch(ClassNotFoundException | SQLException e){
        System.out.println("Error al conectar con base de datos");
    }

    }
    public void crearTabla(String nombreTabla) throws SQLException{
        this.nombreTabla=nombreTabla;
        try{
            sentencia=c.createStatement();
            String sql="CREATE TABLE "+nombreTabla+" "+
                    "(ID INT PRIMARY KEY NOT NULL,"+
                    " Nombre TEXT NOT NULL,"+
                    " Apellidos TEXT NOT NULL,"+
                    " Nota TEXT NOT NULL)";
            sentencia.execute(sql);
            sentencia.close();
            c.close();
            System.out.println("Exito al crear la tabla");
        }catch(SQLException e){
            System.out.println("Error al crear la tabla o que ya estaba creada");
        }
    }
    
    public void insertaDatos(int ID,String Nombre,String Apellidos,String Nota)throws SQLException{
        this.ID=ID;
        this.Nombre=Nombre;
        this.Apellidos=Apellidos;
        this.Nota=Nota;
        String sqlInsert="INSERT INTO "+nombreTabla+"(ID, Nombre, Apellidos, Nota) "+
                "VALUES("+ID+",'"+Nombre+"','"+Apellidos+"','"+Nota+"');";
        
        try {
            conectar();
            sentencia=c.createStatement();
            sentencia.executeUpdate(sqlInsert);
            sentencia.close();
            c.close();
            System.out.println("Datos insertados");
        }catch(SQLException e){
            System.out.println("Error al insertar datos en la tabla");
        }
    }
    
     public void consultaDatos(String nombreTabla)throws SQLException{
        conectar();
        sentencia = c.createStatement();
        String consultaSql="SELECT * FROM "+nombreTabla+";";
        try{
            ResultSet rs;
            rs = sentencia.executeQuery(consultaSql);
            while(rs.next()){
                int ID = rs.getInt("ID");
                String Nombre = rs.getString("Nombre");
                String Apellidos = rs.getString("Apellidos");
                String Nota = rs.getString("Nota");
                System.out.println("Id : "+ID+" Nombre : "+Nombre+" Apellidos : "+Apellidos+" Nota : "+Nota);
            }
            rs.close();
            sentencia.close();
            c.close();
        }catch(SQLException e){
            System.out.println("Fallo al recuperar datos");}
        
        
    }
    
     public void ActualizarDatos(String nombreTabla, int ID, String Nota) throws SQLException{
        this.nombreTabla=nombreTabla;
        this.Nota=Nota;
        this.ID=ID;
        conectar();
        sentencia=c.createStatement();
        String actualizaSql="UPDATE "+nombreTabla+" SET Nota='"+Nota+"' WHERE ID="+ID;
        try {
            sentencia.executeUpdate(actualizaSql);
            c.commit();
        }catch(SQLException e){System.out.println("error actualizando registro");}
        sentencia.close();
        c.close();
    }
     
     public void BorrarDatos(String nombreTabla, int ID) throws SQLException{
        this.nombreTabla=nombreTabla;
        this.ID=ID;
        
        try{
            conectar();
            sentencia=c.createStatement();
            String sql="DELETE FROM "+nombreTabla+" WHERE ID="+ID;
            sentencia.executeUpdate(sql);
        }catch(SQLException e){
            System.out.print("error al borrar datos");
        }
        sentencia.close();
        c.close();
    }
     
}