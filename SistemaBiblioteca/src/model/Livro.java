package model;


public class Livro {

    private int LivroId;
    private String Nome;
    private String Editora;
    private String Escritor;
    private String DataLancamento;
    private String Situacao;
    private int SituacaoId;


    public int getLivroId() {
        return LivroId;
    }
    public String getSituacao() {
        return Situacao;
    }
    public void setSituacao(String situacao) {
        this.Situacao = situacao;
    }
    public int getSituacaoId() {
        return SituacaoId;
    }
    public void setSituacaoId(int situacaoId) {
        this.SituacaoId = situacaoId;
    }
    public void setLivroId(int livroId) {
        LivroId = livroId;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public String getEditora() {
        return Editora;
    }
    public void setEditora(String editora) {
        Editora = editora;
    }
    public String getEscritor() {
        return Escritor;
    }
    public void setEscritor(String escritor) {
        Escritor = escritor;
    }
    public String getDataLancamento() {
        return DataLancamento;
    }
    public void setDataLancamento(String dataLancamento) {
        DataLancamento = dataLancamento;
    }

    
    
}
