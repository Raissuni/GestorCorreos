/*
package org.example.examenjunio;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class Apuntes {

    // Declaración de la variable para la conexión a la base de datos
        Connection con;

        // Credenciales para la conexión a la base de datos
        String usuario = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/GestorEstacionamiento";

        try {
        // Establecimiento de la conexión con la base de datos utilizando las credenciales y la URL
        con = DriverManager.getConnection(url, usuario, password);

        // Creación de un objeto Statement para ejecutar consultas SQL
        Statement st = con.createStatement();

        // Declaración del objeto ResultSet que contendrá los resultados de la consulta
        ResultSet rs;

        String consulta = "SELECT numero FROM Espacios WHERE libre=true and nivel=\'"+ComboPlanta.getValue()+"\'";

        // Ejecución de la consulta SQL y obtención de los resultados en el ResultSet
        rs = st.executeQuery(consulta);

        // Creación de una lista observable para almacenar los números de Espacios
        ArrayList<Integer> EspacioDisponibles = new ArrayList<>();

        // Iterar sobre el ResultSet y añadir los resultados a la lista observable
        while (rs.next()) {
            EspacioDisponibles.add(rs.getInt("numero"));
        }

        ObservableList<Integer> observableList = FXCollections.observableArrayList(EspacioDisponibles);
        Combo1.setItems(observableList);
        // Cierre de la conexión
        con.close();
    } catch (
    SQLException e1) {
        e1.printStackTrace();
    }

}

AQUI INSERTAMOS, RECUPERAMOS UN DATO Y ACTUALOZAMOS

@FXML
    private void registrarParking() {

        String matri = matricula.getText();
        int planta = Integer.parseInt(ComboPlanta.getValue());
        int numPar = Combo1.getValue();
        LocalTime llegada = LocalTime.now();
        LocalTime salida = LocalTime.of(00, 00);

        Connection con1;


        String usuario1 = "root";
        String password1 = "1234";
        String url1 = "jdbc:mysql://localhost:3306/GestorEstacionamiento";

        try {

            con1 = DriverManager.getConnection(url1, usuario1, password1);


            String insertVehicle = "INSERT INTO Vehiculos (matricula, hora_llegada, hora_salida) VALUES (?,?,?)";
            PreparedStatement stmtInsert = con1.prepareStatement(insertVehicle);
            stmtInsert.setString(1, matri);
            stmtInsert.setTime(2, Time.valueOf(llegada));
            stmtInsert.setTime(3, Time.valueOf(salida));
            stmtInsert.executeUpdate();

            // A nos conectamos a la bd para recuperar el id del vehiculo
            // Creación de un objeto Statement para ejecutar consultas SQL
            Statement st = con1.createStatement();
            // Declaración del objeto ResultSet que contendrá los resultados de la consulta
            ResultSet rs;
            String consulta = "SELECT id from vehiculos";
            // Ejecución de la consulta SQL y obtención de los resultados en el ResultSet
            rs = st.executeQuery(consulta);
            int id_OBT=0;
            // Iterar sobre el ResultSet y añadir los resultados a la lista observable
            while (rs.next()) {
                 id_OBT=rs.getInt("id");
            }
            //hasta aqui
            String updateEspacio = "UPDATE Espacios SET libre = false, vehiculo_id=" + id_OBT +" WHERE numero = ? AND nivel = ?";
            PreparedStatement stmtUpdate = con1.prepareStatement(updateEspacio);
            stmtUpdate.setInt(1, numPar);
            stmtUpdate.setInt(2, planta);
            stmtUpdate.executeUpdate();

            con1.close();
            mostrarParking();
            //mensaje.setText("Registro y actualización exitosos");

        } catch (SQLException e1) {
            e1.printStackTrace();
            // Handle specific SQL errors and provide appropriate messages
            //mensaje.setText("Error al registrar y actualizar: " + e1.getMessage());
        }
    }
*/