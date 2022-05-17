package scenes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class EscolherOpcao extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {


        //Definição das propriedades

        Label lbEscolhe = new Label("Escolhe uma Opção:");
        HBox hbEscolhe = new HBox(lbEscolhe);

        //Cadastro Pessoa
        Button btnCadastroPessoa = new Button("Cadastro Pessoa");
        HBox hbCadastroPessoa = new HBox(btnCadastroPessoa);

        //Cadastro Produto
        Button btnCadastroProduto = new Button("Cadastro Produto");
        HBox hbCadastroProduto = new HBox(btnCadastroProduto);

        //Cadastro Produto Categoria
        Button btnCadastroProdutoCategoria = new Button("Cadastro Produto Categoria");
        HBox hbCadastroProdutoCategoria = new HBox(btnCadastroProdutoCategoria);

        //Cadastro Usuário
        Button btnCadastroUsuario = new Button("Cadastro Usuario");
        HBox hbCadastroUsuario = new HBox(btnCadastroUsuario);

        //Mostrar na Tela//Mostrar na Tela
        TilePane tpMostra = new TilePane();

        tpMostra.getChildren().add(lbEscolhe);
        tpMostra.getChildren().add(hbEscolhe);
        tpMostra.getChildren().add(btnCadastroPessoa);
        tpMostra.getChildren().add(hbCadastroPessoa);
        tpMostra.getChildren().add(btnCadastroProduto);
        tpMostra.getChildren().add(hbCadastroProduto);
        tpMostra.getChildren().add(btnCadastroProdutoCategoria);
        tpMostra.getChildren().add(hbCadastroProdutoCategoria);
        tpMostra.getChildren().add(btnCadastroUsuario);
        tpMostra.getChildren().add(hbCadastroUsuario);


        //EVENTO APÓS TER APERTADO O BOTÃO CADASTRO PESSOA
        EventHandler<ActionEvent> eventoCadastroPessoa = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CadastroPessoa cadastroPessoa = new CadastroPessoa();
                try {
                    cadastroPessoa.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        //EVENTO APÓS TER APERTADO O BOTÃO CADASTRO PRODUTO
        EventHandler<ActionEvent> eventoCadastroProduto = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CadastroProduto cadastroProduto = new CadastroProduto();
                try {
                    cadastroProduto.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        //EVENTO APÓS TER APERTADO O BOTÃO CADASTRO PRODUTO CATEGORIA
        EventHandler<ActionEvent> eventoCadastroProdutoCategoria = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CadastroProdutoCategoria cadastroProdutoCategoria = new CadastroProdutoCategoria();
                try {
                    cadastroProdutoCategoria.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        //EVENTO APÓS TER APERTADO O BOTÃO CADASTRO USUÁRIO
        EventHandler<ActionEvent> eventoCadastroUsuario = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CadastroUsuario cadastroUsuario = new CadastroUsuario();
                try {
                    cadastroUsuario.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        btnCadastroPessoa.setOnAction(eventoCadastroPessoa);
        btnCadastroProduto.setOnAction(eventoCadastroProduto);
        btnCadastroProdutoCategoria.setOnAction(eventoCadastroProdutoCategoria);
        btnCadastroUsuario.setOnAction(eventoCadastroUsuario);


        //Mostrar Scena
        Scene scena = new Scene(tpMostra, 350, 150);
        primaryStage.setScene(scena);

        primaryStage.setTitle("Cadastro");    //Coloca um Título na tela.
        primaryStage.show();      //este "show" é para exibir a tela.
    }

    public void begin() {
        launch();
    }
}










