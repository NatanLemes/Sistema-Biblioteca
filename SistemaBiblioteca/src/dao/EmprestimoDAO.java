package dao;

import java.sql.*;

import jdbc.ConnectionFactory;

public class EmprestimoDAO{

    public void GerarEmprestimo(int usuarioId, int livroId)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        String query = "EXEC SP_GERA_EMPRESTIMO @LIVROID = ? , @USUARIOID = ?";

        try {

            conn  = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, livroId);
            stmt.setInt(2, usuarioId);
            
 
            stmt.executeUpdate();
            System.out.println("Emprestimo gerado com sucesso!!");
 
         } catch (SQLException e)
         {
             e.printStackTrace();
         }
         catch (Exception e) {
             e.printStackTrace();
         }finally
         {
             ConnectionFactory.closeConnection(conn, stmt);
         }
    }

    public void GerarDevolucao(int livroId)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        String query = "EXEC SP_DEVOLVE_LIVRO @LIVROID = ?";

        try {

            conn  = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, livroId);
 
            stmt.executeUpdate();
            System.out.println("Devolução Realizada com sucesso!!");
 
         } catch (SQLException e)
         {
             e.printStackTrace();
         }
         catch (Exception e) {
             e.printStackTrace();
         }finally
         {
             ConnectionFactory.closeConnection(conn, stmt);
         }
    }
}