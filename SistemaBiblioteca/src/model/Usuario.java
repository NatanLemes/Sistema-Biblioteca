package model;


public class Usuario {

    private int usuarioid;
    private String nome;
    private String dataNascimento;
    private String telefone;
    private String celular;
    private String endereco;
    private String numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String cpf;
    private String privilegio;
    private String status;
    private int privilegioid;
    private int statusid;

    public int getUsuarioid() {
        return usuarioid;
    }
    public int getPrivilegioid() {
        return privilegioid;
    }
    public void setPrivilegioid(int privilegioid) {
        this.privilegioid = privilegioid;
    }
    public int getStatusid() {
        return statusid;
    }
    public void setStatusid(int statusid) {
        this.statusid = statusid;
    }
    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getPrivilegio() {
        return privilegio;
    }
    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }



}
