package view;

import java.util.*;
import java.util.List;
import java.util.Scanner;

import controller.LivroController;
import model.Livro;

public class LivroView {

    public void insert()
    {
        try {
            Scanner teclado = new Scanner(System.in);
            Livro livro = new Livro();
            LivroController livroController = new LivroController();
    
            System.out.println("Inserir Livro");
            System.out.println("Nome: ");
            livro.setNome(teclado.nextLine());
            System.out.println("Data Lancamento: ");
            livro.setDataLancamento(teclado.nextLine());
            System.out.println("Editora: ");
            livro.setEditora(teclado.nextLine());
            System.out.println("Escritor: ");
            livro.setEscritor(teclado.nextLine());
    
            livroController.Insert(livro);            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buscaLivros()
    {
        LivroController usuarioController = new LivroController();
        System.out.println("****************************************");
        System.out.println("Lista de Livros");

        for (Livro x : usuarioController.BuscaLivros()) {

            System.out.println("**_____________________________________**");
            System.out.println(" ");
            System.out.println("Nome: " + x.getNome());
            System.out.println("Data Lancamento: " + x.getDataLancamento());
            System.out.println("Editora: "+x.getEditora());
            System.out.println("Escritor: "+x.getEscritor());
            System.out.println("Situacao do Livro: "+x.getSituacao());

        }
    }

    public void buscaLivroPorNome()
    {
        Scanner teclado = new Scanner(System.in);
        LivroController livroController = new LivroController();
        System.out.println("****************************************");
        System.out.println("Qual livro deseja buscar? ");
        String filtro = teclado.nextLine();

        for (Livro x : livroController.BuscaLivros(filtro)) {

            System.out.println("**_____________________________________**");
            System.out.println(" ");
            System.out.println("Nome: " + x.getNome());
            System.out.println("Data Lancamento: " + x.getDataLancamento());
            System.out.println("Editora: "+x.getEditora());
            System.out.println("Escritor: "+x.getEscritor());
            System.out.println("Situacao do Livro: "+x.getSituacao());

        }
    }
    public void buscaLivroPorId()
    {
        Scanner teclado = new Scanner(System.in);
        LivroController livroController = new LivroController();
        System.out.println("****************************************");
        System.out.println("Qual livro deseja buscar? ");
        int filtro = Integer.parseInt(teclado.nextLine());

        for (Livro x : livroController.BuscaLivrosPorId(filtro)) {

            System.out.println("**_____________________________________**");
            System.out.println(" ");
            System.out.println("Nome: " + x.getNome());
            System.out.println("Data Lancamento: " + x.getDataLancamento());
            System.out.println("Editora: "+x.getEditora());
            System.out.println("Escritor: "+x.getEscritor());
            System.out.println("Situacao do Livro: "+x.getSituacao());

        }
    }
    
    public void EditarLivro()
    {
        try {
            Scanner teclado = new Scanner(System.in);
            Livro livro = new Livro();
            LivroController livroController = new LivroController();
            System.out.println("****************************************");
            System.out.println("Qual livro deseja buscar? ");
            String filtro = teclado.nextLine();

            livro = livroController.BuscaLivros(filtro).get(0);
            
            System.out.println("Inserir Livro");
            System.out.println("Nome: ");
            livro.setNome(teclado.nextLine());
            System.out.println("Data Lancamento: ");
            livro.setDataLancamento(teclado.nextLine());
            System.out.println("Editora: ");
            livro.setEditora(teclado.nextLine());
            System.out.println("Escritor: ");
            livro.setEscritor(teclado.nextLine());
    
            livroController.EditarLivro(livro);            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
