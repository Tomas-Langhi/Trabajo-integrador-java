/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.integrador.java;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author nico
 */
public class Cliente extends Conexion{
    public Cliente() throws IOException{super("cliente");} //Se usa el constructor para cliente de Conexion

    public void startClient() //Método para iniciar el cliente
    {
        try
        {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());

            //Se enviarán dos mensajes
            for (int i = 0; i < 2; i++)
            {
                //Se escribe en el servidor usando su flujo de datos
                salidaServidor.writeUTF("Este es el mensaje número " + (i+1) + "\n");
            }

            cs.close();//Fin de la conexión

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
