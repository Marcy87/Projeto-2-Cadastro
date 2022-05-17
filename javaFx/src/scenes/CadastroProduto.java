package scenes;

import db.SQLite;
import entities.Produto;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class CadastroProduto extends Application {
    @Override
    public void start(Stage stageProduto){

        //Definição das Propriedades

        //Código Barra
        Label lbCodBarra = new Label("Código Barra:");
        TextField tfCodBarra = new TextField();
        HBox hbCodBarra = new HBox(tfCodBarra);

        //Nome Produto
        Label lbNomeProd = new Label("Nome Produto:");
        TextField tfNomeProd = new TextField();
        HBox hbNomeProd = new HBox(tfNomeProd);

        //Preço
        Label lbPreco = new Label("Preço:");
        TextField tfPreco = new TextField();
        HBox hbPreco = new HBox(tfPreco);


        //Botão Confirmar
        Button btnConfirmar = new Button("Confirmar");
        //Botão Listar
        Button btnListar =  new Button("Listar");
        //Botão Atualizar
        Button btnAtualizar =  new Button("Atualizar");
        //Botão Eliminar
        Button btnEliminar =  new Button("Eliminar");


        Alert alertConfirmar = new Alert(Alert.AlertType.INFORMATION, "Produto Cadastrado");
        Alert alertAtualizar = new Alert(Alert.AlertType.INFORMATION, "Produto Atualizado");
        Alert alertEliminar = new Alert(Alert.AlertType.INFORMATION, "Produto Eliminado");


        //Mostrar na Tela
        TilePane tpMostra = new TilePane();

        tpMostra.getChildren().add(lbCodBarra);
        tpMostra.getChildren().add(hbCodBarra);

        tpMostra.getChildren().add(lbNomeProd);
        tpMostra.getChildren().add(hbNomeProd);

        tpMostra.getChildren().add(lbPreco);
        tpMostra.getChildren().add(hbPreco);

        tpMostra.getChildren().add(btnConfirmar);
        tpMostra.getChildren().add(btnListar);
        tpMostra.getChildren().add(btnAtualizar);
        tpMostra.getChildren().add(btnEliminar);

        //EVENTO APÓS TER APERTADO O BOTÃO CONFIRMAR
        EventHandler<ActionEvent> eventoConfirmar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Produto novoProduto = new Produto();
                novoProduto.setCodBarra(tfCodBarra.getText());
                novoProduto.setNomeProduto(tfNomeProd.getText());
                novoProduto.setPreco(tfPreco.getText());

                //Vai abrir uma nova janela com "show"
                alertConfirmar.show();

                //Ação para gravar no banco de dados
                try{
                    SQLite dbProduto = new SQLite();
                    dbProduto.insertProduto(novoProduto);

                }catch (SQLException e){
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                //Após confirmar, o TextField vai ser limpo
                tfCodBarra.clear();
                tfNomeProd.clear();
                tfPreco.clear();

            }
        };


        //EVENTO APÓS TER APERTADO O BOTÃO LISTAR
        EventHandler<ActionEvent> eventoListar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ListarProduto listarProduto = new ListarProduto();
                try {
                    listarProduto.start(new Stage());

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        //EVENTO APÓS TER APERTADO O BOTÃO ATUALIZAR
        EventHandler<ActionEvent> eventoAtualizar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Produto novoProduto = new Produto();
                novoProduto.setCodBarra(tfCodBarra.getText());
                novoProduto.setNomeProduto(tfNomeProd.getText());
                novoProduto.setPreco(tfPreco.getText());

                //Vai abrir uma nova janela com "show"
                alertAtualizar.show();

                //Ação para gravar no banco de dados
                try{
                    SQLite dbProduto = new SQLite();
                    dbProduto.updateProduto(novoProduto);

                }catch (SQLException e){
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                //Após confirmar, o TextField vai ser limpo
                tfCodBarra.clear();
                tfNomeProd.clear();
                tfPreco.clear();

            }
        };

        //EVENTO APÓS TER APERTADO O BOTÃO ELIMINAR
        EventHandler<ActionEvent> eventoEliminar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Produto novoProduto = new Produto();
                novoProduto.setCodBarra(tfCodBarra.getText());
                novoProduto.setNomeProduto(tfNomeProd.getText());
                novoProduto.setPreco(tfPreco.getText());

                //Vai abrir uma nova janela com "show"
                alertAtualizar.show();

                //Ação para gravar no banco de dados
                try{
                    SQLite dbProduto = new SQLite();
                    dbProduto.eliminarProduto(novoProduto);

                }catch (SQLException e){
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                //Após confirmar, o TextField vai ser limpo
                tfCodBarra.clear();
                tfNomeProd.clear();
                tfPreco.clear();

            }
        };


        btnConfirmar.setOnAction(eventoConfirmar);
        btnListar.setOnAction(eventoListar);
        btnAtualizar.setOnAction(eventoAtualizar);
        btnEliminar.setOnAction(eventoEliminar);

        //Mostrar Scena
        Scene scena = new Scene(tpMostra, 350, 150);
        stageProduto.setScene(scena);

        stageProduto.setTitle("Produto");    //Coloca um Título na tela.
        stageProduto.show();      //este "show" é para exibir a tela.

    }

    public void begin(){
        launch();
    }
}
