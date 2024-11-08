package org.example.gestor;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;
import java.time.LocalTime;

public class GestorCorreo {
    TextArea mostrarRecibidos;
    public GestorCorreo(TextArea mostrarRecibidos) {
        this.mostrarRecibidos = mostrarRecibidos;
    }


    public void mostrarRecibidos(){

        // Declaración de la variable para la conexión a la base de datos
        Connection con;

        // Credenciales para la conexión a la base de datos
        String usuario = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/GestorCorreos";

        try {
            // Establecimiento de la conexión con la base de datos utilizando las credenciales y la URL
            con = DriverManager.getConnection(url, usuario, password);

            // Creación de un objeto Statement para ejecutar consultas SQL
            Statement st = con.createStatement();

            // Declaración del objeto ResultSet que contendrá los resultados de la consulta
            ResultSet rs;

            String consulta = "SELECT * FROM emails";

            // Ejecución de la consulta SQL y obtención de los resultados en el ResultSet
            rs = st.executeQuery(consulta);


            // Iterar sobre el ResultSet y mostrar los resultados en el TextArea
            while (rs.next()) {
                int id = rs.getInt("Id");
                String origen = rs.getString("Origen");
                String destino = rs.getString("Destino");
                String asunto = rs.getString("Asunto");
                String mensaje = rs.getString("Mensaje");


                // Añadir la información de cada reserva al TextArea
                mostrarRecibidos.appendText("ID:\t"+id + "\n"+"Origen:\t"+ origen + "\n"+"Destino:\t"+ destino + "\n"+"Asunto:\t" + asunto + "\t\n"+"Mensaje:\t"+ mensaje+ "\n");
            }

            con.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
    public void mostrarEliminados(){

// Declaración de la variable para la conexión a la base de datos
        Connection con;

        // Credenciales para la conexión a la base de datos
        String usuario = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/GestorCorreos";

        try {
            // Establecimiento de la conexión con la base de datos utilizando las credenciales y la URL
            con = DriverManager.getConnection(url, usuario, password);

            // Creación de un objeto Statement para ejecutar consultas SQL
            Statement st = con.createStatement();

            // Declaración del objeto ResultSet que contendrá los resultados de la consulta
            ResultSet rs;

            String consulta = "SELECT * FROM eliminados";

            // Ejecución de la consulta SQL y obtención de los resultados en el ResultSet
            rs = st.executeQuery(consulta);

            // Encabezados para las columnas en el TextArea
            //mostrarRecibidos.setText("\n"+"\n"+"\n"+"\n"+"\n");

            // Iterar sobre el ResultSet y mostrar los resultados en el TextArea
            while (rs.next()) {
                int id = rs.getInt("Id");
                String origen = rs.getString("Origen");
                String destino = rs.getString("Destino");
                String asunto = rs.getString("Asunto");
                String mensaje = rs.getString("Mensaje");


                // Añadir la información de cada reserva al TextArea
                mostrarRecibidos.appendText("ID:\t"+id + "\n"+"Origen:\t"+ origen + "\n"+"Destino:\t"+ destino + "\n"+"Asunto:\t" + asunto + "\t\n"+"Mensaje:\t"+ mensaje+"\n");
            }

            con.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }


    public void anadirCorreo(TextField origen,TextField destino,TextField asunto,TextField mensaje) {

        String orig = origen.getText();
        String Dest = destino.getText();
        String asun = asunto.getText();
        String mens = mensaje.getText();

        Connection con1;


        String usuario1 = "root";
        String password1 = "1234";
        String url1 = "jdbc:mysql://localhost:3306/GestorCorreos";

        try {

            con1 = DriverManager.getConnection(url1, usuario1, password1);


            String insertVehicle = "INSERT INTO emails (Origen, Destino, Asunto, Mensaje) VALUES (?,?,?,?)";
            PreparedStatement stmtInsert = con1.prepareStatement(insertVehicle);
            stmtInsert.setString(1, orig);
            stmtInsert.setString(2, Dest);
            stmtInsert.setString(3, asun);
            stmtInsert.setString(4, mens);
            stmtInsert.executeUpdate();



        } catch (SQLException e1) {
            e1.printStackTrace();
            // Handle specific SQL errors and provide appropriate messages
            //mensaje.setText("Error al registrar y actualizar: " + e1.getMessage());
        }
    }

    boolean eliminados;
    public void eliminarCorreo(Button recibido,Button elimin, TextField origenEliminar, Label mensElimi, TextArea mortrarEliminar,boolean eliminados){

            // Declaración de la variable para la conexión a la base de datos
            Connection con;

            // Credenciales para la conexión a la base de datos
            String usuario = "root";
            String password = "1234";
            String url = "jdbc:mysql://localhost:3306/GestorCorreos";

            if (eliminados==false){
                try {
                    // Establecimiento de la conexión con la base de datos utilizando las credenciales y la URL
                    con = DriverManager.getConnection(url, usuario, password);
                    // Creación de un objeto Statement para ejecutar consultas SQL
                    Statement st = con.createStatement();
                    // Declaración del objeto ResultSet que contendrá los resultados de la consulta
                    ResultSet rs;
                    String consulta = "SELECT Id FROM emails WHERE Origen='" + origenEliminar.getText() + "'";

                    // Ejecución de la consulta SQL y obtención de los resultados en el ResultSet
                    rs = st.executeQuery(consulta);
                    int id_OBT = 0;
                    // Iterar sobre el ResultSet y obtener el id del email
                    while (rs.next()) {
                        id_OBT = rs.getInt("Id");
                    }



                        // Creación de un objeto Statement para ejecutar consultas SQL
                        Statement st1 = con.createStatement();
                        // Declaración del objeto ResultSet que contendrá los resultados de la consulta
                        ResultSet rs1;
                        String consulta2 = "SELECT Origen, Destino, Asunto, Mensaje from emails WHERE Id="+id_OBT;

                        // Ejecución de la consulta SQL y obtención de los resultados en el ResultSet
                        rs1 = st1.executeQuery(consulta2);


                        String origen="hola";
                        String destino="";
                        String asunto="";
                        String mensaje="";
                        // Iterar sobre el ResultSet y añadir los resultados
                        while (rs1.next()) {
                            System.out.println(origen);
                            origen = rs.getString("Origen");
                            destino = rs.getString("Destino");
                            asunto = rs.getString("Asunto");
                            mensaje = rs.getString("Mensaje");
                        }
                        System.out.println(origen);
                        String insertVehicle = "INSERT INTO eliminados (Origen, Destino, Asunto, Mensaje) VALUES (?,?,?,?)";
                        PreparedStatement stmtInsert = con.prepareStatement(insertVehicle);
                        stmtInsert.setString(1,origen);
                        stmtInsert.setString(2, destino);
                        stmtInsert.setString(3,asunto);
                        stmtInsert.setString(4,mensaje);
                        stmtInsert.executeUpdate();

                        // Eliminar el correo de la tabla Email
                        String deleteVehiculo = "DELETE FROM emails WHERE Id = " + id_OBT;
                        PreparedStatement stmtDelete = con.prepareStatement(deleteVehiculo);
                        stmtDelete.executeUpdate();


                    // Cerrar la conexión
                    con.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                mensElimi.setText("Correo eliminado correctamente");
            }else if(eliminados==true) {
                try {
                    // Establecimiento de la conexión con la base de datos utilizando las credenciales y la URL
                    con = DriverManager.getConnection(url, usuario, password);
                    // Creación de un objeto Statement para ejecutar consultas SQL
                    Statement st = con.createStatement();
                    // Declaración del objeto ResultSet que contendrá los resultados de la consulta
                    ResultSet rs;
                    String consulta = "SELECT Id FROM eliminados WHERE Origen='" + origenEliminar.getText() + "'";

                    // Ejecución de la consulta SQL y obtención de los resultados en el ResultSet
                    rs = st.executeQuery(consulta);
                    int id_OBT = 0;
                    // Iterar sobre el ResultSet y obtener el id del vehículo
                    while (rs.next()) {
                        id_OBT = rs.getInt("Id");
                    }

                    if (id_OBT != 0) {

                        // Eliminar el Correo de la tabla eliminados
                        String deleteVehiculo = "DELETE * FROM eliminados WHERE Id = " + id_OBT;
                        PreparedStatement stmtDelete = con.prepareStatement(deleteVehiculo);
                        stmtDelete.executeUpdate();
                    }

                    // Cerrar la conexión
                    con.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                mensElimi.setText("Correo eliminado correctamente");


            }
    }

    public boolean eliminados(TextField origenEliminar,TextArea mortrarEliminar){

        boolean eliminados=true;

        // Declaración de la variable para la conexión a la base de datos
        Connection con;

        // Credenciales para la conexión a la base de datos
        String usuario = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/GestorCorreos";

        try {
            // Establecimiento de la conexión con la base de datos utilizando las credenciales y la URL
            con = DriverManager.getConnection(url, usuario, password);

            // Creación de un objeto Statement para ejecutar consultas SQL
            Statement st = con.createStatement();

            // Declaración del objeto ResultSet que contendrá los resultados de la consulta
            ResultSet rs;

            String consulta = "SELECT * FROM eliminados  WHERE Origen='" + origenEliminar.getText() + "'";

            // Ejecución de la consulta SQL y obtención de los resultados en el ResultSet
            rs = st.executeQuery(consulta);

            // Encabezados para las columnas en el TextArea
            //mostrarRecibidos.setText("\n"+"\n"+"\n"+"\n"+"\n");

            // Iterar sobre el ResultSet y mostrar los resultados en el TextArea
            while (rs.next()) {
                int id = rs.getInt("Id");
                String origen = rs.getString("Origen");
                String destino = rs.getString("Destino");
                String asunto = rs.getString("Asunto");
                String mensaje = rs.getString("Mensaje");


                // Añadir la información de cada reserva al TextArea
                mortrarEliminar.appendText("ID:\t"+id + "\n"+"Origen:\t"+ origen + "\n"+"Destino:\t"+ destino + "\n"+"Asunto:\t" + asunto + "\t\n"+"Mensaje:\t"+ mensaje+"\n");
            }

            con.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return eliminados;
    }

    public void emails(TextField origenEliminar,TextArea mortrarEliminar){
        eliminados=false;

        // Declaración de la variable para la conexión a la base de datos
        Connection con;

        // Credenciales para la conexión a la base de datos
        String usuario = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/GestorCorreos";

        try {
            // Establecimiento de la conexión con la base de datos utilizando las credenciales y la URL
            con = DriverManager.getConnection(url, usuario, password);

            // Creación de un objeto Statement para ejecutar consultas SQL
            Statement st = con.createStatement();

            // Declaración del objeto ResultSet que contendrá los resultados de la consulta
            ResultSet rs;

            String consulta = "SELECT * FROM emails  WHERE Origen='" + origenEliminar.getText() + "'";

            // Ejecución de la consulta SQL y obtención de los resultados en el ResultSet
            rs = st.executeQuery(consulta);

            // Encabezados para las columnas en el TextArea
            //mostrarRecibidos.setText("\n"+"\n"+"\n"+"\n"+"\n");

            // Iterar sobre el ResultSet y mostrar los resultados en el TextArea
            while (rs.next()) {
                int id = rs.getInt("Id");
                String origen = rs.getString("Origen");
                String destino = rs.getString("Destino");
                String asunto = rs.getString("Asunto");
                String mensaje = rs.getString("Mensaje");


                // Añadir la información de cada reserva al TextArea
                mortrarEliminar.appendText("ID:\t"+id + "\n"+"Origen:\t"+ origen + "\n"+"Destino:\t"+ destino + "\n"+"Asunto:\t" + asunto + "\t\n"+"Mensaje:\t"+ mensaje+"\n");
            }

            con.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }


}
