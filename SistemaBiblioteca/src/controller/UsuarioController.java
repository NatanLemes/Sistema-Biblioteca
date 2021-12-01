package controller;

import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioController {

    public void insert(Usuario usuario)
    {
        try {
            UsuarioDAO usuDao = new UsuarioDAO();
            usuDao.Insert(usuario);
        } catch (Exception e) {
            System.out.println("Erro na controller");
        }
    }
    
    public List<Usuario> buscarUsuarios()
    {
        List<Usuario> lstUsuarios = new ArrayList<Usuario>();

        try {
           UsuarioDAO usuarioDAO = new UsuarioDAO();

           lstUsuarios = usuarioDAO.buscaUsuarios();

        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Erro na controller");
        }
        return lstUsuarios;
    }

    public List<Usuario> buscarUsuarios(String CPF)
    {
        List<Usuario> lstUsuarios = new ArrayList<Usuario>();

        try {
           UsuarioDAO usuarioDAO = new UsuarioDAO();

           lstUsuarios = usuarioDAO.buscaUsuarios(CPF);

        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Erro na controller");
        }
        return lstUsuarios;
    }


    public int LogarSistema(String CPF, String senha)
    {
        int retorno=0;
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            retorno = usuarioDAO.LogarSistema(CPF, senha);
            
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Erro na controller");
        }
        return retorno;
    }

    public int EditarUsuario(Usuario usuario)
    {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (usuario.getUsuarioid() == 0 || usuario == null)
            {
                System.out.println("Usuario invalido");
                return -1;
            }
            else
            {
                if(usuarioDAO.EditarUsuario(usuario)==1)
                    return 1;
                else
                    return -1;
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Erro na controller");
            return -1;
        }
    }
}
