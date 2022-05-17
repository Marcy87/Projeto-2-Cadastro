package entities;

public class Usuario {
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public Usuario(){

    }


    //Método de acesso get e set

    //Nome
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //E-mail
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Senha
    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
