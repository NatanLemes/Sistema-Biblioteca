package jdbc;

import java.sql.Connection;
import jdbc.ConnectionFactory;

public class TesteBanco {
    public static void main(String[] args) {
        try{
            Connection banco = ConnectionFactory.getConnection();
            System.out.println("Conexao ok");
        }
        catch(Exception e)
        {
            System.err.println("Erro de conexao<<>>");
            System.out.println(e);
        }
        
    }

}