package scenes;

import db.SQLite;
import entities.Pessoa;
import entities.ProdutoCategoria;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.sql.SQLException;

public class ListarProdutoCategoria extends Application {
    @Override
    public void start(Stage listarProdutoCategoria) throws Exception {

        //Declaração da Table View
        TableView tableProdutoCategoria = new TableView<>();

        //Declaração das Colunas da minha TableView
        TableColumn<ProdutoCategoria, String> tcCodigo = new TableColumn<>("codigo");
        TableColumn<ProdutoCategoria, String> tcNome = new TableColumn<>("nome");
        TableColumn<ProdutoCategoria, String> tcMargemLucro = new TableColumn<>("margemLucro");

        //Nome das Celulas de Controle ADICIONANDO
        tcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcMargemLucro.setCellValueFactory(new PropertyValueFactory<>("margemLucro"));

        //Vinculo entre TableView e a TableColumn
        tableProdutoCategoria.getColumns().add(tcCodigo);
        tableProdutoCategoria.getColumns().add(tcNome);
        tableProdutoCategoria.getColumns().add(tcMargemLucro);

        SQLite dbProdutoCategoria = new SQLite();
        for (ProdutoCategoria prodCat : dbProdutoCategoria.getProdutoCategoria()){
            tableProdutoCategoria.getItems().add(prodCat);
        }

        Scene scene = new Scene(tableProdutoCategoria);
        listarProdutoCategoria.setScene(scene);
        listarProdutoCategoria.show();
    }

    public static void begin() {
        launch();
    }
}
