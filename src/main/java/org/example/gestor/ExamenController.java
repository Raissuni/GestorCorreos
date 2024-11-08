package org.example.gestor;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;

public class ExamenController {
    public Button botonRecibidos;
    public Button botonEliminados;
    public TextArea mostrarRecibidos;
    public TextField origen;
    public TextField destino;
    public TextField asunto;
    public TextField mensaje;
    public TextField origenEliminar;

    public Button aceptar;
    public Label mensElimi;
    public TextArea mortrarEliminar;
    public Button recibido;
    public Button elimin;
    public ComboBox carpeta;
    public Button salir;
    @FXML
    private Label welcomeText;


    @FXML
    public void salir() {
        System.exit(0);
    }
    @FXML
    public void initialize() {

        //carpeta.getItems().addAll("emails","eliminados");
    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void mostrarCoreosRecibidos() {
        GestorCorreo gc =new GestorCorreo(mostrarRecibidos);
        gc.mostrarRecibidos();
    }
    @FXML
    private void mostrarCoreosEliminados() {
        GestorCorreo gc =new GestorCorreo(mostrarRecibidos);
        gc.mostrarEliminados();
    }

    @FXML
    private void anadirCorreos() {
        GestorCorreo gc =new GestorCorreo(mostrarRecibidos);
        gc.anadirCorreo(origen,destino,asunto,mensaje);
    }

    @FXML
    private void eliminarCorreos() {
        GestorCorreo gc =new GestorCorreo(mostrarRecibidos);
        gc.eliminarCorreo(recibido,elimin,origenEliminar,mensElimi,mortrarEliminar, gc.eliminados);
    }


    @FXML
    private void email() {
        GestorCorreo gc =new GestorCorreo(mostrarRecibidos);
        gc.emails(origenEliminar,mortrarEliminar);
    }

    @FXML
    private void eliminados() {
        GestorCorreo gc =new GestorCorreo(mostrarRecibidos);
        gc.eliminados(origenEliminar,mortrarEliminar);
    }

}