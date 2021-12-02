package controller;

import java.util.ArrayList;
import java.util.List;

import dao.LivroDAO;
import model.Livro;

public class LivroController {

    public int Insert(Livro livro)
    {
        try {
            LivroDAO livroDAO = new LivroDAO();
            return livroDAO.Insert(livro);
        } catch (Exception e) {
            System.out.println("Erro na controller");
            return -1;
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

    public int EditarLivro(Livro livro)
    {
        try {
            if (livro.getSituacaoId()!= 1)
                return -1;
            else
                return new LivroDAO().EditarLivro(livro);
        } catch (Exception e) {
            System.out.println("Erro na controller");
            return -1;
        }
    }
}
