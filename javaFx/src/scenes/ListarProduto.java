package scenes;

import db.SQLite;
import entities.Produto;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.SQLException;


public class ListarProduto extends Application {

    @Override
    public void start(Stage listarProduto) throws SQLException, ClassNotFoundException {

        //Declaração da Table View
        TableView tableProduto = new TableView();

        //Declaração das Colunas da minha TableView
        TableColumn<Produto, String> tcCodBarra = new TableColumn<>("codBarra");
        TableColumn<Produto, String> tcNomeProduto = new TableColumn<>("nomeProduto");
        TableColumn<Produto, String> tcPreco = new TableColumn<>("preco");

        //Nome das Celulas de Controle ADICIONANDO
        tcCodBarra.setCellValueFactory(new PropertyValueFactory<>("codBarra"));
        tcNomeProduto.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        tcPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));

        //Vinculo entre TableView e a TableColumn
        tableProduto.getColumns().add(tcCodBarra);
        tableProduto.getColumns().add(tcNomeProduto);
        tableProduto.getColumns().add(tcPreco);

        SQLite dbProduto = new SQLite();
        for (Produto prod1 : dbProduto.getProduto()) {
            tableProduto.getItems().add(prod1);
        }

        Scene scene = new Scene(tableProduto);
        listarProduto.setScene(scene);
        listarProduto.show();
    }

    public static void begin() {
        launch();
    }
}
