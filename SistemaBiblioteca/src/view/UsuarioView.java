package view;

import java.util.Scanner;

import controller.UsuarioController;
import model.Usuario;

public class UsuarioView {

    public void insert()
    {
        try {
            Scanner teclado = new Scanner(System.in);
            Usuario usuario = new Usuario();
            UsuarioController usuarioController = new UsuarioController();

            System.out.println("Inserir Usuario");
            System.out.println("Nome: ");
            usuario.setNome(teclado.nextLine());
            System.out.println("Data Nascimento: ");
            usuario.setDataNascimento(teclado.nextLine());
            System.out.println("Telefone: ");
            usuario.setTelefone(teclado.nextLine());
            System.out.println("Celular: ");
            usuario.setCelular(teclado.nextLine());
            System.out.println("Endereco: ");
            usuario.setEndereco(teclado.nextLine());
            System.out.println("Numero: ");
            usuario.setNumero(teclado.nextLine());
            System.out.println("Complemento: ");
            usuario.setComplemento(teclado.nextLine());
            System.out.println("Cep: ");
            usuario.setCep(teclado.nextLine());
            System.out.println("Bairro: ");
            usuario.setBairro(teclado.nextLine());
            System.out.println("Cidade: ");
            usuario.setCidade(teclado.nextLine());
            System.out.println("Estado: ");
            usuario.setEstado(teclado.nextLine());
            System.out.println("Cpf: ");
            usuario.setCpf(teclado.nextLine());

            usuarioController.insert(usuario);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void buscarUsuarios()
    {
        UsuarioController usuarioController = new UsuarioController();
        System.out.println("****************************************");
        System.out.println("Lista de Usuarios");

        for (Usuario x : usuarioController.buscarUsuarios()) {

            System.out.println("**_____________________________________**");
            System.out.println(" ");
            System.out.println("Nome: " + x.getNome());
            System.out.println("Data Nascimento: " + x.getDataNascimento());
            System.out.println("Telefone: "+x.getTelefone());
            System.out.println("Celular: "+x.getCelular());
            System.out.println("Endereco: "+x.getEndereco());
            System.out.println("Numero: "+x.getNumero());
            System.out.println("Complemento: "+x.getComplemento());
            System.out.println("Cep: "+x.getCep());
            System.out.println("Bairro: "+x.getBairro());
            System.out.println("Cidade: "+x.getCidade());
            System.out.println("Estado: "+x.getEstado());
            System.out.println("Cpf: "+x.getCpf());
            System.out.println("Status do cadastro: "+x.getStatus());
            System.out.println("Privilegio do Usuario: "+x.getPrivilegio());

        }

    }

    public void buscarUsuarioPorCpf()
    {
        Scanner teclado = new Scanner(System.in);
        UsuarioController usuarioController = new UsuarioController();
        System.out.println("****************************************");
        System.out.println("Digite o usuario que sera buscado: ");
        String filtro = teclado.nextLine();

        for (Usuario x : usuarioController.buscarUsuarios(filtro)) {
            System.out.println("**_____________________________________**");
            System.out.println(" ");
            System.out.println("Nome: " + x.getNome());
            System.out.println("Data Nascimento: " + x.getDataNascimento());
            System.out.println("Telefone: "+x.getTelefone());
            System.out.println("Celular: "+x.getCelular());
            System.out.println("Endereco: "+x.getEndereco());
            System.out.println("Numero: "+x.getNumero());
            System.out.println("Complemento: "+x.getComplemento());
            System.out.println("Cep: "+x.getCep());
            System.out.println("Bairro: "+x.getBairro());
            System.out.println("Cidade: "+x.getCidade());
            System.out.println("Estado: "+x.getEstado());
            System.out.println("Cpf: "+x.getCpf());
            System.out.println("Status do cadastro: "+x.getStatus());
            System.out.println("Privilegio do Usuario: "+x.getPrivilegio());

        }
    }

    public void LogarSistema()
    {
        Scanner teclado = new Scanner(System.in);
        UsuarioController usuarioController = new UsuarioController();
        System.out.println("****************************************");
        System.out.println("Digite o login");
        String cpf = teclado.nextLine();
        
        System.out.println("Digite a senha");
        String senha = teclado.nextLine();

        int result = usuarioController.LogarSistema(cpf, senha);
        if (result>0)
        {
            System.out.println("Usuario Logado!");
            // System.out.println(result);
        }
        else 
            System.out.println("Erro no login");
    }
}
