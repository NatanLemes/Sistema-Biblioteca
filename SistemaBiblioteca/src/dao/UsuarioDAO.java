package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import jdbc.ConnectionFactory;
import model.Usuario;

public class UsuarioDAO {
    
    public int Insert(Usuario usuario)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        String query = "EXEC SP_CADASTRA_USUARIO @NOME = ? , ";
        query += " @CPF= ?, ";      
        query += "@DATA_NASCIMENTO= ?,    ";    
        query += " @DDD_CEL=  ?,       "; 
        query += " @CELULAR= ?,     ";   
        query += " @DDD_TEL= ?,     ";  
        query += "@TELEFONE= ?,    ";   
        query += "@EMAIL= ?,      "; 
        query += "@ENDERECO= ?,  ";      
        query += "@NUMERO = ?,  ";      
        query += " @BAIRRO = ?,  ";      
        query += "@CIDADE = ?,     ";   
        query += " @ESTADO  = ?,  ";      
        query += "@CEP = ?,        ";
        query += "@COMPLEMENTO = ?,   ";                   
        query += " @PRIVILEGIOID = ?";


        String validacaoCPF = "select	count(1) as qtd";
        validacaoCPF += " from	Usuario u ";
        validacaoCPF += " where u.CPF = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        int qtdCpf = 0;

        try {

           conn  = ConnectionFactory.getConnection();
           stmt = conn.prepareStatement(query);
           stmt.setString(1, usuario.getNome());
           stmt.setString(2, usuario.getCpf());
           stmt.setString(3, usuario.getDataNascimento());
           stmt.setString(4, "");
           stmt.setString(5, usuario.getCelular());
           stmt.setString(6, "");
           stmt.setString(7, usuario.getTelefone());
           stmt.setString(8, "");
           stmt.setString(9, usuario.getEndereco());
           stmt.setString(10, usuario.getNumero());
           stmt.setString(11, usuario.getBairro());
           stmt.setString(12, usuario.getCidade());
           stmt.setString(13, usuario.getEstado());
           stmt.setString(14, usuario.getCep());
           stmt.setString(15, usuario.getComplemento());
           stmt.setString(16, Integer.toString(usuario.getPrivilegioid()));

           ps = conn.prepareStatement(validacaoCPF);
           ps.setString(1, usuario.getCpf());
           rs = ps.executeQuery();
           while(rs.next())
                qtdCpf = Integer.parseInt(rs.getString("qtd"));

           System.out.println(qtdCpf);
           
           if(qtdCpf<=0)
           {
               stmt.executeUpdate();
               System.out.println("Aluno inserido no banco com sucesso!!");
               return 1;
           }
           
           else
           {
               System.out.println("CPF ja existe");
                return -2;
           }

        } catch (SQLException e)
        {
            e.printStackTrace();
            return -1;
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }finally
        {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }



    public List<Usuario> buscaUsuarios()
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "select	u.usuarioid, u.nome, convert(varchar, u.dataNascimento, 103) as dataNascimento, Telefone, Celular, Endereco, Complemento, Numero, cep, Bairro, cidade,Estado, CPF, p.nome as privilegio, s.Nome as status, u.statusid ";
        query += " from	Usuario u ";
        query += " inner	join Privilegio p on p.privilegioid = u.privilegioid ";
        query += " inner	join Status s on s.statusid = u.statusid where u.privilegioid <> 1 and u.statusid <> 2";

        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {

            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement(query);

            rs = stmt.executeQuery();
            while(rs.next())
            {
                Usuario usuario = new Usuario();
                usuario.setNome(rs.getString("nome"));
                usuario.setDataNascimento(rs.getString("dataNascimento"));
                usuario.setTelefone(rs.getString("Telefone"));
                usuario.setCelular(rs.getString("Celular"));
                usuario.setEndereco(rs.getString("Endereco"));
                usuario.setComplemento(rs.getString("Complemento"));
                usuario.setNumero(rs.getString("Numero"));
                usuario.setCep(rs.getString("Cep"));
                usuario.setBairro(rs.getString("Bairro"));
                usuario.setCidade(rs.getString("Cidade"));
                usuario.setEstado(rs.getString("Estado"));
                usuario.setCpf(rs.getString("CPF"));
                usuario.setPrivilegio(rs.getString("privilegio"));
                usuario.setStatus(rs.getString("status"));
                usuario.setUsuarioid(Integer.parseInt(rs.getString("usuarioid")));
                usuario.setPrivilegioid(Integer.parseInt(rs.getString("statusid")));

                usuarios.add(usuario);
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

        return usuarios;
    }

    public List<Usuario> buscaUsuarios(String CPF)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "select	u.usuarioid, u.nome, convert(varchar, u.dataNascimento, 103) as dataNascimento, Telefone, Celular, Endereco, Complemento, Numero, cep, Bairro, cidade,Estado, CPF, p.nome as privilegio, s.Nome as status, u.statusid ";
        query += " from	Usuario u ";
        query += " inner	join Privilegio p on p.privilegioid = u.privilegioid ";
        query += " inner	join Status s on s.statusid = u.statusid where u.privilegioid <> 1 and u.statusid <> 2 ";
        query += " and    u.CPF like '%"+CPF+"%' ";

        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {

            // System.out.println(query);
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement(query);

            rs = stmt.executeQuery();
            while(rs.next())
            {
                Usuario usuario = new Usuario();
                usuario.setNome(rs.getString("nome"));
                usuario.setDataNascimento(rs.getString("dataNascimento"));
                usuario.setTelefone(rs.getString("Telefone"));
                usuario.setCelular(rs.getString("Celular"));
                usuario.setEndereco(rs.getString("Endereco"));
                usuario.setComplemento(rs.getString("Complemento"));
                usuario.setNumero(rs.getString("Numero"));
                usuario.setCep(rs.getString("Cep"));
                usuario.setBairro(rs.getString("Bairro"));
                usuario.setCidade(rs.getString("Cidade"));
                usuario.setEstado(rs.getString("Estado"));
                usuario.setCpf(rs.getString("CPF"));
                usuario.setPrivilegio(rs.getString("privilegio"));
                usuario.setStatus(rs.getString("status"));
                usuario.setUsuarioid(Integer.parseInt(rs.getString("usuarioid")));
                usuario.setStatusid(Integer.parseInt(rs.getString("statusid")));

                usuarios.add(usuario);
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

        return usuarios;
    }

    public int LogarSistema(String CPF, String senha)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "select	u.usuarioid ";
        query += " from	Usuario u ";
        query += " where u.statusid <> 2 ";
        query += " and    (u.CPF = '"+CPF+"' and PWDCOMPARE('"+senha+"',senha)=1)";
        // System.out.println(query);
        // List<Usuario> usuarios = new ArrayList<Usuario>();
        int idUsuario=0;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                idUsuario = Integer.parseInt(rs.getString("usuarioid"));
            }
            // System.out.println("USUARIOID >>>>"+idUsuario);
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
        return idUsuario;
    }


    public int EditarUsuario(Usuario usuario)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        String query = "EXEC SP_ATUALIZA_USUARIOS @USUARIOID = ?, @NOME = ? , ";
        query += " @CPF= ?, ";      
        query += "@DATA_NASCIMENTO= ?,    ";    
        query += " @DDD_CEL=  ?,       "; 
        query += " @CELULAR= ?,     ";   
        query += " @DDD_TEL= ?,     ";  
        query += "@TELEFONE= ?,    ";   
        // query += "@EMAIL= ?,      "; 
        query += "@ENDERECO= ?,  ";      
        query += "@NUMERO = ?,  ";      
        query += " @BAIRRO = ?,  ";      
        query += "@CIDADE = ?,     ";   
        query += " @ESTADO  = ?,  ";      
        query += "@CEP = ?,        ";
        query += "@COMPLEMENTO = ?,  ";                   
        query += "@FOTO = NULL  ";                   

        String validacaoCPF = "select	count(1) as qtd";
        validacaoCPF += " from	Usuario u ";
        validacaoCPF += " where u.CPF ='"+ usuario.getCpf() +"' and u.usuarioid <> "+Integer.toString(usuario.getUsuarioid());
        PreparedStatement ps = null;
        ResultSet rs = null;
        int qtdCpf = 0;

        try {

           conn  = ConnectionFactory.getConnection();
           stmt = conn.prepareStatement(query);
           stmt.setString(1, Integer.toString(usuario.getUsuarioid()));
           stmt.setString(2, usuario.getNome());
           stmt.setString(3, usuario.getCpf());
           stmt.setString(4, usuario.getDataNascimento());
           stmt.setString(5, "");
           stmt.setString(6, usuario.getCelular());
           stmt.setString(7, "");
           stmt.setString(8, usuario.getTelefone());
           stmt.setString(9, usuario.getEndereco());
           stmt.setString(10, usuario.getNumero());
           stmt.setString(11, usuario.getBairro());
           stmt.setString(12, usuario.getCidade());
           stmt.setString(13, usuario.getEstado());
           stmt.setString(14, usuario.getCep());
           stmt.setString(15, usuario.getComplemento());

           ps = conn.prepareStatement(validacaoCPF);
        //    ps.setString(1, usuario.getCpf());
        //    ps.setString(2, Integer.toString(usuario.getUsuarioid()));
           rs = ps.executeQuery();
           while(rs.next())
                qtdCpf = Integer.parseInt(rs.getString("qtd"));

           System.out.println(qtdCpf);
           
           if(qtdCpf<=0)
           {
               stmt.executeUpdate();
               System.out.println("Usuario atualizado com sucesso!!");
               return 1;
           }
           
           else
           {
               System.out.println("CPF ja existe em outro cadastro.");
                return -1;
           }
            
        }catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int DeletarUsuario(int usuarioId)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        String query="";
        try {
            query =" update usuario set statusid = 2 where    usuarioid = "+ Integer.toString(usuarioId);

            conn  = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("Usuario deletado com sucesso!!");
            return 1;
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
            return -1;
        }catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return -1;
        }
    }
}
