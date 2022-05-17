package scenes;

import db.SQLite;
import entities.Usuario;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.sql.SQLException;


public class CadastroUsuario extends Application{

    public void start(Stage stage){

        //Definição das propriedades

        //Nome
        Label lbNome = new Label("Nome:");  //Mostra a escrita Nome
        TextField tfNome = new TextField();     //Permite de escrever nome do usuário
        HBox hbNome = new HBox(tfNome);         //Coloco "tfNome" como parametro no hbox para escrever dentro do box

        //E-mail
        Label lbEmail = new Label("E-mail:");
        TextField tfEmail = new TextField();
        HBox hbEmail = new HBox(tfEmail);

        //Senha
        Label lbSenha = new Label("Senha:");
        PasswordField tfSenha = new PasswordField();
        HBox hbSenha = new HBox(tfSenha);


        //Botão Confirmar
        Button btnConfirmar = new Button("Confirmar");
        //Botão Listar
        Button btnListar = new Button("Listar");
        //Botão Atualizar
        Button btnAtualizar = new Button("Atualizar");
        //Botão Eliminar
        Button btnEliminar = new Button("Eliminar");


        Alert alertConfirmar = new Alert(Alert.AlertType.INFORMATION, "Usuário Confirmado");
        Alert alertAtualizar = new Alert(Alert.AlertType.INFORMATION, "Usuário Atualizado");
        Alert alertEliminar = new Alert(Alert.AlertType.INFORMATION, "Usuário Eliminado");


        //Mostrar na Tela
        TilePane tpMostra = new TilePane();

        tpMostra.getChildren().add(lbNome);        //Mostra a escrita "nome" na tela
        tpMostra.getChildren().add(hbNome);        //Mostra um box na tela para escrever o nome do usuário

        tpMostra.getChildren().add(lbEmail);       //Mostra a escrita "E-mail" na tela
        tpMostra.getChildren().add(hbEmail);       //Mostra um box na tela para escrever a e-mail do usuário

        tpMostra.getChildren().add(lbSenha);       //Mostra a escrita "Senha" na tela
        tpMostra.getChildren().add(hbSenha);       //Mostra um box na tela para escrever a senha do usuário

        tpMostra.getChildren().add(btnConfirmar);  //Mostra o botão confirmar na tela
        tpMostra.getChildren().add(btnListar);     //Mostra o botão listar na tela
        tpMostra.getChildren().add(btnAtualizar);
        tpMostra.getChildren().add(btnEliminar);


        //EVENTO APÓS TER APERTADO O BOTÃO CONFIRMAR
        EventHandler<ActionEvent> eventoConfirmar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Usuario novoCadastro = new Usuario();
                novoCadastro.setNome(tfNome.getText());
                novoCadastro.setEmail(tfEmail.getText());
                novoCadastro.setSenha(tfSenha.getText());

                //Vai abrir uma nova janela com "show"
                alertConfirmar.show();

                //Ação para gravar no banco de dados
                try {
                    SQLite dbUsuarios = new SQLite();
                    dbUsuarios.insertUsuario(novoCadastro);

                }catch (SQLException e){
                    e.printStackTrace();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                //Após confirmar, o TextField vai ser limpo
                tfNome.clear();
                tfEmail.clear();
                tfSenha.clear();
            }
        };


        //EVENTO APÓS TER APERTADO O BOTÃO LISTAR
        EventHandler<ActionEvent> eventoListar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ListarUsuario cadastroListar = new ListarUsuario();
                try {
                    cadastroListar.start(new Stage());
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        };


        //EVENTO APÓS TER APERTADO O BOTÃO ATUALIZAR
        EventHandler<ActionEvent> eventoAtualizar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Usuario novoCadastro = new Usuario();
                novoCadastro.setNome(tfNome.getText());
                novoCadastro.setEmail(tfEmail.getText());
                novoCadastro.setSenha(tfSenha.getText());

                //Vai abrir uma nova janela com "show"
                alertAtualizar.show();

                //Ação para gravar no banco de dados
                try {
                    SQLite dbUsuarios = new SQLite();
                    dbUsuarios.updateUsuario(novoCadastro);

                }catch (SQLException e){
                    e.printStackTrace();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                //Após confirmar, o TextField vai ser limpo
                tfNome.clear();
                tfEmail.clear();
                tfSenha.clear();
            }
        };

        //EVENTO APÓS TER APERTADO O BOTÃO ELIMINAR
        EventHandler<ActionEvent> eventoEliminar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Usuario novoCadastro = new Usuario();
                novoCadastro.setNome(tfNome.getText());
                novoCadastro.setEmail(tfEmail.getText());
                novoCadastro.setSenha(tfSenha.getText());

                //Vai abrir uma nova janela com "show"
                alertEliminar.show();

                //Ação para gravar no banco de dados
                try {
                    SQLite dbUsuarios = new SQLite();
                    dbUsuarios.eliminarUsuario(novoCadastro);

                }catch (SQLException e){
                    e.printStackTrace();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                //Após confirmar, o TextField vai ser limpo
                tfNome.clear();
                tfEmail.clear();
                tfSenha.clear();
            }
        };

        btnConfirmar.setOnAction(eventoConfirmar);
        btnListar.setOnAction(eventoListar);
        btnAtualizar.setOnAction(eventoAtualizar);
        btnEliminar.setOnAction(eventoEliminar);


        //Mostrar Scena
        Scene scena = new Scene(tpMostra, 350, 150);
        stage.setScene(scena);

        stage.setTitle("Usuário");    //Coloca um Título na tela.
        stage.show();      //este "show" é para exibir a tela.

    }

    public void begin(){
        launch();
    }
}
