package entities;

public class ProdutoCategoria {

    private String codigo;
    private String nome;
    private String margemlucro;

    //Método Construtor
    public ProdutoCategoria(String codigo, String nome, String margemLucro){
        this.codigo = codigo;
        this.nome = nome;
        this.margemlucro = margemLucro;
    }

    public ProdutoCategoria(){

    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMargemlucro() {
        return this.margemlucro;
    }

    public void setMargemlucro(String margemlucro) {
        this.margemlucro = margemlucro;
    }
}
