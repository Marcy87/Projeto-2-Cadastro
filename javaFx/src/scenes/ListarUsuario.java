package scenes;

import db.SQLite;
import entities.Usuario;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableView;

public class ListarUsuario extends Application {
    @Override
    public void start(Stage listarUsuario) throws Exception {

        //Declaração da TableView
        TableView tableUsuario = new TableView();

        //Declaração das Colunas da minha TableView
        TableColumn<Usuario, String> tcNome = new TableColumn<>("Nome");
        TableColumn<Usuario, String> tcEmail = new TableColumn<>("Email");

        //Nome das Celulas de Controle ADICIONANDO
        tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        //Vinculo entre TableView e a TableColumn
        tableUsuario.getColumns().add(tcNome);
        tableUsuario.getColumns().add(tcEmail);

        SQLite dbUsuario = new SQLite();
        for (Usuario cad1 : dbUsuario.getUsuarios()){
            tableUsuario.getItems().add(cad1);
        }

        Scene scene = new Scene(tableUsuario);
        listarUsuario.setScene(scene);
        listarUsuario.show();
    }

    public static void begin(){
        launch();
    }
}
