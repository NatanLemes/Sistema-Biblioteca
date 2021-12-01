package controller;

import java.util.ArrayList;
import java.util.List;

import dao.LivroDAO;
import model.Livro;

public class LivroController {

    public void Insert(Livro livro)
    {
        try {
            LivroDAO livroDAO = new LivroDAO();
            livroDAO.Insert(livro);
        } catch (Exception e) {
            System.out.println("Erro na controller");
        }
    }

    public List<Livro> BuscaLivros()
    {
        List<Livro> livros = new ArrayList<Livro>();
        try {
            livros =  new LivroDAO().BuscaLivros();
        } catch (Exception e) {
            System.out.println("Erro na controller");
        }
        return livros;
    }
    
    public List<Livro> BuscaLivros(String nome)
    {
        List<Livro> livros = new ArrayList<Livro>();
        try {
            livros =  new LivroDAO().BuscaLivros(nome);
        } catch (Exception e) {
            System.out.println("Erro na controller");
        }
        return livros;
    }
}
