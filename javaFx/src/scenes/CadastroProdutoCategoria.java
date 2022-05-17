package scenes;

import db.SQLite;
import entities.ProdutoCategoria;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class CadastroProdutoCategoria extends Application{
    @Override
    public void start(Stage stageProdutoCategoria) throws Exception {

        //Definição das propriedades

        //Codigo
        Label lbCodigo = new Label("codigo");
        TextField tfCodigo = new TextField();
        HBox hbCodigo = new HBox(tfCodigo);

        //Nome
        Label lbNome = new Label("Nome");
        TextField tfNome = new TextField();
        HBox hbNome = new HBox(tfNome);

        //Margem de Lucro
        Label lbMargemLucro = new Label("margemLucro");
        TextField tfMargemLucro = new TextField();
        HBox hbMargemLucro = new HBox(tfMargemLucro);

        //Botão Confirmar
        Button btnConfirmar = new Button("Confirmar");
        //Botão Listar
        Button btnListar = new Button("Listar");
        //Botão Atualizar
        Button btnAtualizar = new Button("Atualizar");
        //Botão Eliminar
        Button btnEliminar = new Button("Eliminar");

        Alert alertConfirmar = new Alert(Alert.AlertType.INFORMATION, "Produto Categoria Cadastrado");
        Alert alertAtualizar = new Alert(Alert.AlertType.INFORMATION, "Produto Categoria Atualizado");
        Alert alertEliminar = new Alert(Alert.AlertType.INFORMATION, "Produto Categoria Eliminado");

        //Mostrar na Tela//Mostrar na Tela
        TilePane tpMostra = new TilePane();

        tpMostra.getChildren().add(lbCodigo);
        tpMostra.getChildren().add(hbCodigo);

        tpMostra.getChildren().add(lbNome);
        tpMostra.getChildren().add(hbNome);

        tpMostra.getChildren().add(lbMargemLucro);
        tpMostra.getChildren().add(hbMargemLucro);

        tpMostra.getChildren().add(btnConfirmar);
        tpMostra.getChildren().add(btnListar);
        tpMostra.getChildren().add(btnAtualizar);
        tpMostra.getChildren().add(btnEliminar);

        //EVENTO APÓS TER APERTADO O BOTÃO CONFIRMAR
        EventHandler<ActionEvent> eventoConfirmar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ProdutoCategoria produtoCategoria = new ProdutoCategoria();
                produtoCategoria.setCodigo(tfCodigo.getText());
                produtoCategoria.setNome(tfNome.getText());
                produtoCategoria.setMargemlucro(tfMargemLucro.getText());

                //Vai abrir uma nova janela com "show"
                alertConfirmar.show();

                //Ação para gravar no banco de dados
                try {
                    SQLite dbProdutoCategoria = new SQLite();
                    dbProdutoCategoria.insertProdutoCategoria(produtoCategoria);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                //Após confirmar, o TextField vai ser limpo
                tfCodigo.clear();
                tfNome.clear();
                tfMargemLucro.clear();
            }
        };

        //EVENTO APÓS TER APERTADO O BOTÃO LISTAR
        EventHandler<ActionEvent> eventoListar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ListarProdutoCategoria listarProdutoCategoria = new ListarProdutoCategoria();
                try {

                    listarProdutoCategoria.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        //EVENTO APÓS TER APERTADO O BOTÃO ATUALIZAR
        EventHandler<ActionEvent> eventoAtualizar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ProdutoCategoria produtoCategoria = new ProdutoCategoria();
                produtoCategoria.setCodigo(tfCodigo.getText());
                produtoCategoria.setNome(tfNome.getText());
                produtoCategoria.setMargemlucro(tfMargemLucro.getText());

                //Vai abrir uma nova janela com "show"
                alertAtualizar.show();

                //Ação para gravar no banco de dados
                try {
                    SQLite dbProdutoCategoria = new SQLite();
                    dbProdutoCategoria.updateProdutoCategoria(produtoCategoria);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                //Após confirmar, o TextField vai ser limpo
                tfCodigo.clear();
                tfNome.clear();
                tfMargemLucro.clear();
            }
        };

        //EVENTO APÓS TER APERTADO O BOTÃO ELIMINAR
        EventHandler<ActionEvent> eventoEliminar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ProdutoCategoria produtoCategoria = new ProdutoCategoria();
                produtoCategoria.setCodigo(tfCodigo.getText());
                produtoCategoria.setNome(tfNome.getText());
                produtoCategoria.setMargemlucro(tfMargemLucro.getText());

                //Vai abrir uma nova janela com "show"
                alertEliminar.show();

                //Ação para gravar no banco de dados
                try {
                    SQLite dbProdutoCategoria = new SQLite();
                    dbProdutoCategoria.eliminarProdutoCategoria(produtoCategoria);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                //Após confirmar, o TextField vai ser limpo
                tfCodigo.clear();
                tfNome.clear();
                tfMargemLucro.clear();
            }
        };

        btnConfirmar.setOnAction(eventoConfirmar);
        btnListar.setOnAction(eventoListar);
        btnAtualizar.setOnAction(eventoAtualizar);
        btnEliminar.setOnAction(eventoEliminar);

        Scene scene = new Scene(tpMostra, 350, 150);
        stageProdutoCategoria.setScene(scene);

        stageProdutoCategoria.setTitle("Produto Categoria");
        stageProdutoCategoria.show();

    }

    public void begin() {
        launch();
    }
}
