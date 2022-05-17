package scenes;

import db.SQLite;
import entities.Pessoa;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.sql.SQLException;

public class ListarPessoa extends Application {
    @Override
    public void start(Stage listarPessoa) throws SQLException, ClassNotFoundException {

        //Declaração da Table View
        TableView tablePessoa = new TableView();

        //Declaração das Colunas da minha TableView
        TableColumn<Pessoa, String> tcNome = new TableColumn<>("nome");
        TableColumn<Pessoa, String> tcSobreNome = new TableColumn<>("sobreNome");
        TableColumn<Pessoa, String> tcIdade = new TableColumn<>("idade");
        TableColumn<Pessoa, String> tcCpf = new TableColumn<>("cpf");

        //Nome das Celulas de Controle ADICIONANDO
        tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcSobreNome.setCellValueFactory(new PropertyValueFactory<>("sobreNome"));
        tcIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        tcCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        //Vinculo entre TableView e a TableColumn
        tablePessoa.getColumns().add(tcNome);
        tablePessoa.getColumns().add(tcSobreNome);
        tablePessoa.getColumns().add(tcIdade);
        tablePessoa.getColumns().add(tcCpf);

        SQLite dbPessoa = new SQLite();
        for (Pessoa pessoa : dbPessoa.getPessoa()) {
            tablePessoa.getItems().add(pessoa);
        }

        Scene scene = new Scene(tablePessoa);
        listarPessoa.setScene(scene);
        listarPessoa.show();
    }

    public static void begin() {
        launch();
    }
}
