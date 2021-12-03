package controller;


import dao.EmprestimoDAO;
import model.Livro;
import model.Usuario;

public class EmprestimoController {

    public int GerarEmprestimo(Usuario usu, Livro livro)
    {
        try {

            if(livro.getSituacaoId()!= 1)
            {
                System.out.println("Livro indisponivel para Emprestimo");
                return -1;
            }else if(!usu.getStatus().equals("Ativo")){
                System.out.println("Usuario impedido de gerar emprestimo");
            }else if(livro.equals(null) || livro.getLivroId()==0)
            {
                System.out.println("Livro informado não encontrado");
                return 0;
            }else if(usu.equals(null) || usu.getUsuarioid() == 0)
            {
                System.out.println("Usuario informado não localizado");
                return 0;
            }else{
                new EmprestimoDAO().GerarEmprestimo(usu.getUsuarioid(), livro.getLivroId());
            }

        } catch (Exception e) {
            System.out.println("Erro na controller");
        }
        return 1;
    }

    public int GerarDevolucao(Livro livro)
    {
        try {

            if(livro.getSituacaoId()!= 2)
            {
                System.out.println("Livro nao consta em emprestimo corrente");
                return -1;
            }else if(livro.equals(null) || livro.getLivroId()==0)
            {
                System.out.println("Livro informado não encontrado");
                return 0;
            }else{
                new EmprestimoDAO().GerarDevolucao(livro.getLivroId());
            }

        } catch (Exception e) {
            System.out.println("Erro na controller");
        }
        return 1;
    }
    
}
