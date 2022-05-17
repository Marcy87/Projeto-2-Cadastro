package db;

import entities.Usuario;
import entities.Pessoa;
import entities.Produto;
import entities.ProdutoCategoria;
import scenes.CadastroUsuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLite {

    private Connection conn;
    private Statement stm;

    //Conexão ao Banco de dados
    public SQLite() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:usuario.db");
        this.stm = this.conn.createStatement();
    }


    //PESSOAS

    //Método responsavél por inserir os dados na tabela pessoa
    public void insertPessoa(Pessoa pessoa) {
        try {
            if (!this.checkPessoa(pessoa)) {
                this.stm = this.conn.createStatement();
                String cmdSQL = "insert into pessoa(nome, sobreNome, idade, cpf) values ('" + pessoa.getNome() + "','" + pessoa.getSobreNome() + "', '" + pessoa.getIdade() + "', '" + pessoa.getCpf() + "')";
                this.stm.executeUpdate(cmdSQL);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Método para recuperar os dados da tabela Pessoa
    public List<Pessoa> getPessoa() {
        List<Pessoa> listaPessoa = new ArrayList<>();
        ResultSet resultSet;

        try {
            resultSet = this.stm.executeQuery("select * from pessoa");

            while (resultSet.next()) {
                listaPessoa.add(new Pessoa(resultSet.getString("nome"), resultSet.getString("sobreNome"), resultSet.getString("idade"), resultSet.getString("cpf")));
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPessoa;
    }

    //Método para verificar se o CPF está registrado no banco de dados
    private boolean checkPessoa(Pessoa pessoa) {
        List<Pessoa> listaPessoa = new ArrayList<>();
        try {
            ResultSet resultSet;
            resultSet = this.stm.executeQuery("select * from pessoa where CPF = '" + pessoa.getCpf() + "' ");

            while (resultSet.next()) {
                listaPessoa.add(new Pessoa(resultSet.getString("nome"), resultSet.getString("sobreNome"), resultSet.getString("idade"), resultSet.getString("cpf")));
            }

            if (listaPessoa.size() >= 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //Método para atualizar dados de uma pessoa
    public void updatePessoa(Pessoa pessoa) {
        try {
            if (this.checkPessoa(pessoa)) {
                this.stm = this.conn.createStatement();
                String cmdUpdate = "update " +
                        "   pessoa " +
                        "set " +
                        "   nome = '" + pessoa.getNome() + "', " +
                        "   sobreNome = '" + pessoa.getSobreNome() + "', " +
                        "   idade = '" + pessoa.getIdade() + "' " +
                        "where " +
                        "   cpf = '" + pessoa.getCpf() + "'";
                this.stm.executeUpdate(cmdUpdate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Eliminar objeto pessoa dentro do banco de dados
    public void eliminarPessoa(Pessoa pessoa) {
        try {
            this.stm = this.conn.createStatement();
            String cmdDelete = "delete from pessoa where CPF = '" + pessoa.getCpf() + "'";
            this.stm.executeUpdate(cmdDelete);  //executar o comando

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //PRODUTOS

    //Método responsavél por inserir os dados na tabela Produto
    public void insertProduto(Produto produto) {
        try {
            if (!this.checkProduto(produto)) {    //se o código de barra do produto não é cadastrado então inserir na lista
                this.stm = this.conn.createStatement();
                String cmdSQL = "insert into produtos(codBarra, nomeProduto, preco) values ('" + produto.getCodBarra() + "','" + produto.getNomeProduto() + "', '" + produto.getPreco() + "')";
                this.stm.executeUpdate(cmdSQL);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Método para recuperar os dados da tabela Produto
    public List<Produto> getProduto() {

        List<Produto> listaProduto = new ArrayList<>();
        ResultSet resultSet;

        try {
            resultSet = this.stm.executeQuery("select codBarra, nomeProduto, preco from produtos order by nomeProduto asc");

            while (resultSet.next()) {
                listaProduto.add(new Produto(resultSet.getString("codBarra"), resultSet.getString("nomeProduto"), resultSet.getString("preco")));
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaProduto;
    }

    //Método para verificar se o código Barra está registrado no banco de dados
    private boolean checkProduto(Produto produto) {
        List<Produto> listaProduto = new ArrayList<>();
        try {
            ResultSet resultSet;
            resultSet = this.stm.executeQuery("select * from produtos where codBarra = '" + produto.getCodBarra() + "' ");

            while (resultSet.next()) {
                listaProduto.add(new Produto(resultSet.getString("codBarra"), resultSet.getString("nomeProduto"), resultSet.getString("preco")));
            }

            if (listaProduto.size() >= 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //Método para atualizar dados de um Produto
    public void updateProduto(Produto produto) {
        try {
            if (this.checkProduto(produto)) {
                this.stm = this.conn.createStatement();
                String cmdUpdate = "update " +
                        "   produtos " +
                        "set " +
                        "   nomeProduto = '" + produto.getNomeProduto() + "', " +
                        "   preco = '" + produto.getPreco() + "' " +
                        "where " +
                        "   codBarra = '" + produto.getCodBarra() + "'";
                this.stm.executeUpdate(cmdUpdate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Eliminar objeto Produto dentro do banco de dados
    public void eliminarProduto(Produto produto) {
        try {
            this.stm = this.conn.createStatement();
            String cmdDelete = "delete from produtos where codBarra = '" + produto.getCodBarra() + "'";
            this.stm.executeUpdate(cmdDelete);  //executar o comando

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //PRODUTO CATEGORIA

    //Método responsavél por inserir os dados na tabela Produto Categoria
    public void insertProdutoCategoria(ProdutoCategoria produtoCategoria) {
        try {
            if (!this.checkProdutoCategoria(produtoCategoria)) {    //se o código de barra do produto não é cadastrado então inserir na lista
                this.stm = this.conn.createStatement();
                String cmdSQL = "insert into produtoCategoria(codigo, nome, margemLucro) values ('" + produtoCategoria.getCodigo() + "','" + produtoCategoria.getNome() + "', '" + produtoCategoria.getMargemlucro() + "')";
                this.stm.executeUpdate(cmdSQL);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Método para recuperar os dados da tabela Produto Categoria
    public List<ProdutoCategoria> getProdutoCategoria() {

        List<ProdutoCategoria> listaProdutoCategoria = new ArrayList<>();
        ResultSet resultSet;

        try {
            resultSet = this.stm.executeQuery("select codigo, nome, margemLucro from produtoCategoria order by nome asc");

            while (resultSet.next()) {
                listaProdutoCategoria.add(new ProdutoCategoria(resultSet.getString("codigo"), resultSet.getString("nome"), resultSet.getString("margemLucro")));
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaProdutoCategoria;
    }

    //Método para verificar se o código está registrado no banco de dados
    private boolean checkProdutoCategoria(ProdutoCategoria produtoCategoria) {
        List<ProdutoCategoria> listaProdutoCategoria = new ArrayList<>();
        try {
            ResultSet resultSet;
            resultSet = this.stm.executeQuery("select * from produtoCategoria where codigo = '" + produtoCategoria.getCodigo() + "' ");

            while (resultSet.next()) {
                listaProdutoCategoria.add(new ProdutoCategoria(resultSet.getString("codigo"), resultSet.getString("nome"), resultSet.getString("margemLucro")));
            }

            if (listaProdutoCategoria.size() >= 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //Método para atualizar dados de um Produto Categoria
    public void updateProdutoCategoria(ProdutoCategoria produtoCategoria) {
        try {
            if (this.checkProdutoCategoria(produtoCategoria)) {
                this.stm = this.conn.createStatement();
                String cmdUpdate = "update " +
                        "   produtoCategoria " +
                        "set " +
                        "   nome = '" + produtoCategoria.getNome() + "', " +
                        "   margemLucro = '" + produtoCategoria.getMargemlucro() + "' " +
                        "where " +
                        "   codigo = '" + produtoCategoria.getCodigo() + "'";
                this.stm.executeUpdate(cmdUpdate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Eliminar objeto Produto Categoria dentro do banco de dados
    public void eliminarProdutoCategoria(ProdutoCategoria produtoCategoria) {
        try {
            this.stm = this.conn.createStatement();
            String cmdDelete = "delete from produtoCategoria where codigo = '" + produtoCategoria.getCodigo() + "'";
            this.stm.executeUpdate(cmdDelete);  //executar o comando

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // USUÁRIOS

    //Método responsavél por inserir cadastro de usuário
    public void insertUsuario(Usuario usuario) {
        try {
            if (!this.checkUsuario(usuario)) {
                this.stm = this.conn.createStatement();
                String SQLInsertUsuario = "insert into usuario (Nome, Email, Senha) values ('" + usuario.getNome() + "', '" + usuario.getEmail() + "', '" + usuario.getSenha() + "')";
                this.stm.executeUpdate(SQLInsertUsuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Método para recuperar os dados da tabela Usuário
    public List<Usuario> getUsuarios() {

        List<Usuario> listaUsuario = new ArrayList<>();
        ResultSet resultSetUsuario;

        try {
            resultSetUsuario = this.stm.executeQuery("select nome, email from usuario order by nome asc");

            while (resultSetUsuario.next()) {
                listaUsuario.add(new Usuario(resultSetUsuario.getString("Nome"), resultSetUsuario.getString("Email")));
            }

            resultSetUsuario.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaUsuario;
    }

    //Método para verificar se o código está registrado no banco de dados
    private boolean checkUsuario(Usuario usuario) {
        List<Usuario> listarUsuario = new ArrayList<>();
        try {
            ResultSet resultSet;
            resultSet = this.stm.executeQuery("select * from usuario where senha = '" + usuario.getSenha() + "' ");

            while (resultSet.next()) {
                listarUsuario.add(new Usuario(resultSet.getString("Nome"), resultSet.getString("Email")));
            }

            if (listarUsuario.size() >= 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //Método para atualizar dados de um Produto Categoria
    public void updateUsuario(Usuario usuario) {
        try {
            if (this.checkUsuario(usuario)) {
                this.stm = this.conn.createStatement();
                String cmdUpdate = "update " +
                        "   usuario " +
                        "set " +
                        "   Nome = '" + usuario.getNome() + "', " +
                        "   Email = '" + usuario.getEmail() + "' " +
                        "where " +
                        "   Senha = '" + usuario.getSenha() + "'";
                this.stm.executeUpdate(cmdUpdate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Eliminar objeto Produto Categoria dentro do banco de dados
    public void eliminarUsuario(Usuario usuario) {
        try {
            this.stm = this.conn.createStatement();
            String cmdDelete = "delete from usuario where senha = '" + usuario.getSenha() + "'";
            this.stm.executeUpdate(cmdDelete);  //executar o comando

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}