/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.integrador.java;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author nico
 */
public class Conexion {
    private final int PUERTO = 9991; //Puerto para la conexión
    private final String HOST = "localhost"; //Host para la conexión
    protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    protected ServerSocket ss; //Socket del servidor
    protected Socket cs; //Socket del cliente
    protected DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida

    public Conexion(String tipo) throws IOException //Constructor
    {
        if(tipo.equalsIgnoreCase("servidor"))
        {
            ss = new ServerSocket(PUERTO);//Se crea el socket para el servidor en puerto 1234
            cs = new Socket(); //Socket para el cliente
        }
        else
        {
            cs = new Socket(HOST, PUERTO); //Socket para el cliente en localhost en puerto 1234
        }
    }
}
