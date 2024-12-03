//mensagem de teste

//@author pkmelo7

//Conecta o Sistema com o banco de dados

package com.mycompany.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory 
{
    private String usuario = "root";
    private String senha = "root";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "synapse";
    
    //Método que obtem a conexão e conversa com o banco de dados
    public Connection obtemConexao ()
    {
        try
        {
            Connection c = DriverManager.getConnection
            (
                    "jdbc:mysql://" + host + ":" + porta + "/" + 
                            bd + "?serverTimezone=UTC",
                            usuario, senha
            );
                return c;
        }
        catch(Exception e) {
        e.printStackTrace();
        return null;
        }
    }
}
