package org.example.gestor;

public class Correo {
    private String origen;
    private String destno;
    private String asunto;
    private String mensaje;

    public Correo(String origen, String destno, String asunto, String mensaje) {
        this.origen = origen;
        this.destno = destno;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public String elOrigen(){
        return origen;
    }

    @Override
    public String toString() {
        return "Correo{" +
                "origen='" + origen + '\'' +
                ", destno='" + destno + '\'' +
                ", asunto='" + asunto + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
