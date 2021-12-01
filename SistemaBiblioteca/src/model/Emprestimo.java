package model;

public class Emprestimo {
    
    private int Emprestimo;
    private String DataRetirada;
    private String DataDevolucao;
    private int Prazo;
    private int LivroId;
    private int UsuarioId;

    
    public int getEmprestimo() {
        return Emprestimo;
    }
    public void setEmprestimo(int emprestimo) {
        Emprestimo = emprestimo;
    }
    public String getDataRetirada() {
        return DataRetirada;
    }
    public void setDataRetirada(String dataRetirada) {
        DataRetirada = dataRetirada;
    }
    public String getDataDevolucao() {
        return DataDevolucao;
    }
    public void setDataDevolucao(String dataDevolucao) {
        DataDevolucao = dataDevolucao;
    }
    public int getPrazo() {
        return Prazo;
    }
    public void setPrazo(int prazo) {
        Prazo = prazo;
    }
    public int getLivroId() {
        return LivroId;
    }
    public void setLivroId(int livroId) {
        LivroId = livroId;
    }
    public int getUsuarioId() {
        return UsuarioId;
    }
    public void setUsuarioId(int usuarioId) {
        UsuarioId = usuarioId;
    }

    

}
