package scenes;

import db.SQLite;
import entities.Pessoa;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class CadastroPessoa extends Application {
    @Override
    public void start(Stage stagePessoa) throws Exception {

        //Definição das propriedades

        //Nome
        Label lbNome = new Label("Nome");
        TextField tfNome = new TextField();
        HBox hbNome = new HBox(tfNome);

        //SobreNome
        Label lbSobreNome = new Label("Sobrenome");
        TextField tfSobreNome = new TextField();
        HBox hbSobreNome = new HBox(tfSobreNome);

        //Idade
        Label lbIdade = new Label("idade");
        TextField tfIdade = new TextField();
        HBox hbIdade = new HBox(tfIdade);

        //CPF
        Label lbCpf = new Label("cpf");
        TextField tfCpf = new TextField();
        HBox hbCpf = new HBox(tfCpf);

        //Botão Confirmar
        Button btnConfirmar = new Button("Confirmar");
        //Botão Listar
        Button btnListar = new Button("Listar");
        //Botão Atualizar
        Button btnAtualizar = new Button("Atualizar");
        //Botão Eliminar
        Button btnEliminar = new Button("Eliminar");

        Alert alertConfirmar = new Alert(Alert.AlertType.INFORMATION, "Pessoa Cadastrado");
        Alert alertAtualizar = new Alert(Alert.AlertType.INFORMATION, "Pessoa Atualizada");
        Alert alertEliminar = new Alert(Alert.AlertType.INFORMATION, "Pessoa Eliminada");

        //Mostrar na Tela//Mostrar na Tela
        TilePane tpMostra = new TilePane();

        tpMostra.getChildren().add(lbNome);
        tpMostra.getChildren().add(hbNome);

        tpMostra.getChildren().add(lbSobreNome);
        tpMostra.getChildren().add(hbSobreNome);

        tpMostra.getChildren().add(lbIdade);
        tpMostra.getChildren().add(hbIdade);

        tpMostra.getChildren().add(lbCpf);
        tpMostra.getChildren().add(hbCpf);

        tpMostra.getChildren().add(btnConfirmar);
        tpMostra.getChildren().add(btnListar);
        tpMostra.getChildren().add(btnAtualizar);
        tpMostra.getChildren().add(btnEliminar);

        //EVENTO APÓS TER APERTADO O BOTÃO CONFIRMAR
        EventHandler<ActionEvent> eventoConfirmar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Pessoa pessoa = new Pessoa();
                pessoa.setNome(tfNome.getText());
                pessoa.setSobreNome(tfSobreNome.getText());
                pessoa.setIdade(tfIdade.getText());
                pessoa.setCpf(tfCpf.getText());

                //Vai abrir uma nova janela com "show"
                alertConfirmar.show();

                //Ação para gravar no banco de dados
                try {
                    SQLite dbPessoa = new SQLite();
                    dbPessoa.insertPessoa(pessoa);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                //Após confirmar, o TextField vai ser limpo
                tfNome.clear();
                tfSobreNome.clear();
                tfIdade.clear();
                tfCpf.clear();
            }
        };

        //EVENTO APÓS TER APERTADO O BOTÃO LISTAR
        EventHandler<ActionEvent> eventoListar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                ListarPessoa listarPessoa = new ListarPessoa();
                try {

                    listarPessoa.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        //EVENTO APÓS TER APERTADO O BOTÃO ATUALIZAR
        EventHandler<ActionEvent> eventoAtualizar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Pessoa pessoa = new Pessoa();
                pessoa.setNome(tfNome.getText());
                pessoa.setSobreNome(tfSobreNome.getText());
                pessoa.setIdade(tfIdade.getText());
                pessoa.setCpf(tfCpf.getText());

                try {
                    SQLite dbPessoaAtualizada = new SQLite();
                    dbPessoaAtualizada.updatePessoa(pessoa);

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                //Vai abrir uma nova janela com "show"
                alertAtualizar.show();

                //Após confirmar, o TextField vai ser limpo
                tfNome.clear();
                tfSobreNome.clear();
                tfIdade.clear();
                tfCpf.clear();
            }
        };

        //EVENTO APÓS TER APERTADO O BOTÃO ELIMINAR
        EventHandler<ActionEvent> eventoEliminar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Pessoa pessoa = new Pessoa();
                pessoa.setNome(tfNome.getText());
                pessoa.setSobreNome(tfSobreNome.getText());
                pessoa.setIdade(tfIdade.getText());
                pessoa.setCpf(tfCpf.getText());

                try {
                    SQLite dbPessoaAtualizada = new SQLite();
                    dbPessoaAtualizada.eliminarPessoa(pessoa);

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                //Vai abrir uma nova janela com "show"
                alertEliminar.show();

                //Após confirmar, o TextField vai ser limpo
                tfNome.clear();
                tfSobreNome.clear();
                tfIdade.clear();
                tfCpf.clear();
            }
        };

        btnConfirmar.setOnAction(eventoConfirmar);
        btnListar.setOnAction(eventoListar);
        btnAtualizar.setOnAction(eventoAtualizar);
        btnEliminar.setOnAction(eventoEliminar);

        //Mostrar Scena
        Scene scena = new Scene(tpMostra, 350, 200);
        stagePessoa.setScene(scena);

        stagePessoa.setTitle("Pessoa");    //Coloca um Título na tela.
        stagePessoa.show();      //este "show" é para exibir a tela.
    }

    public void begin() {
        launch();
    }
}







