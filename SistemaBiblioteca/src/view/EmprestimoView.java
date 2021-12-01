package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.EmprestimoController;
import controller.LivroController;
import controller.UsuarioController;
import model.Livro;
import model.Usuario;

public class EmprestimoView {

    public void GerarEmprestimo()
    {
        Scanner teclado = new Scanner(System.in);
        String filtroUsu = "";
        String filtroLiv = "";

        System.out.println("Gerar Emprestimo");
        System.out.println("**************************************************");
        System.out.println("Digite o CPF que ira pegar o livro emprestado: ");
        filtroUsu = teclado.nextLine();
        System.out.println("Digite o livro emprestado: ");
        filtroLiv = teclado.nextLine();

        List<Usuario> usu = new ArrayList<Usuario>();
        usu = new UsuarioController().buscarUsuarios(filtroUsu);
        
        List<Livro> liv = new ArrayList<Livro>();
        liv = new LivroController().BuscaLivros(filtroLiv);

        new EmprestimoController().GerarEmprestimo(usu.get(0), liv.get(0));
    }

    public void GerarDevolucao()
    {
        Scanner teclado = new Scanner(System.in);
        String filtroLiv = "";

        System.out.println("Gerar Devolucao");
        System.out.println("**************************************************");
        System.out.println("Digite o livro que foi emprestado: ");
        filtroLiv = teclado.nextLine();

        List<Livro> liv = new ArrayList<Livro>();
        liv = new LivroController().BuscaLivros(filtroLiv);

        new EmprestimoController().GerarDevolucao(liv.get(0));
    }
    
}
