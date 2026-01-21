package datos;

import java.awt.event.ItemListener;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Empresa implements Serializable {
    private String nombre;
    private String cif;
    private int telefono;

    public Empresa(String nombre, String cif, int telefono) {
        this.nombre = nombre;
        this.cif = cif;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Cif: " + cif + ", Telefono: " + telefono);
    }
}
