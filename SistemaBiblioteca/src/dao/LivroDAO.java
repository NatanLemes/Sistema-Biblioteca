package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.Livro;

public class LivroDAO {
    
    public void Insert(Livro livro)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        String query = "EXEC SP_CADASTRA_LIVRO @NOME = ? ,";      
        query += "@EDITORA  = ? ,";   
        query += "@ESCRITOR = ? ,";     
        query += "@DATA_LANCAMENTO  = ? ";    
      
        try {

           conn  = ConnectionFactory.getConnection();
           stmt = conn.prepareStatement(query);
           stmt.setString(1, livro.getNome());
           stmt.setString(2, livro.getEditora());
           stmt.setString(3, livro.getEscritor());
           stmt.setString(4, livro.getDataLancamento());

           
           stmt.executeUpdate();
           System.out.println("Livro inserido no banco com sucesso!!");

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


    public List<Livro> BuscaLivros()
    {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = "select	l.nome, convert(varchar,l.datalancamento,103) datalancamento, l.editora, l.escritor, s.nome as situacao, LivroId ";
        query += " from	Livro l ";
        query += " inner	join situacao s on s.situacaoid = l.situacaoid ";
       

        List<Livro> livros = new ArrayList<Livro>();

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement(query);

            rs = stmt.executeQuery();
            while(rs.next())
            {
                Livro livro = new Livro();
                livro.setNome(rs.getString("nome"));
                livro.setDataLancamento(rs.getString("datalancamento"));
                livro.setEditora(rs.getString("editora"));
                livro.setEscritor(rs.getString("escritor"));
                livro.setSituacao(rs.getString("situacao"));
                livro.setLivroId(Integer.parseInt(rs.getString("LivroId")));

                livros.add(livro);
            }
            
        }catch (SQLException e)
        {
            e.printStackTrace();
        }catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        finally
        {
            ConnectionFactory.closeConnection(conn, stmt);
        }

        return livros;
    }

    public List<Livro> BuscaLivros(String nome)
    {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        String query = "select	l.nome, convert(varchar,l.datalancamento,103) datalancamento, l.editora, l.escritor, s.nome as situacao, LivroId, l.situacaoid ";
        query += " from	Livro l ";
        query += " inner	join situacao s on s.situacaoid = l.situacaoid ";
        query+= " where  l.nome like '%"+nome+"%' collate latin1_general_ci_ai ";            

        List<Livro> livros = new ArrayList<Livro>();

        try {

            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement(query);
            // stmt.setString(1, nome);

            // System.out.println(query);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                Livro livro = new Livro();
                livro.setNome(rs.getString("nome"));
                livro.setDataLancamento(rs.getString("datalancamento"));
                livro.setEditora(rs.getString("editora"));
                livro.setEscritor(rs.getString("escritor"));
                livro.setSituacao(rs.getString("situacao"));
                livro.setLivroId(Integer.parseInt(rs.getString("LivroId")));
                livro.setSituacaoId(Integer.parseInt(rs.getString("situacaoid")));

                livros.add(livro);
            }
            
        }catch (SQLException e)
        {
            e.printStackTrace();
        }catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        finally
        {
            ConnectionFactory.closeConnection(conn, stmt);
        }

        return livros;
    }
}
