package entities;

public class Pessoa {

    private String nome;
    private String sobreNome;
    private String idade;
    private String cpf;

    public Pessoa(String nome, String sobreNome, String idade){
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.idade = idade;
    }

    public Pessoa(String nome, String sobreNome, String idade, String cpf){
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public Pessoa(){

    }

    //Método de acesso get e set

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return this.sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getIdade() {
        return this.idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
