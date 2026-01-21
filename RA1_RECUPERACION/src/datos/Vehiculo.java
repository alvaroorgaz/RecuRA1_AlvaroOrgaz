package datos;

import java.io.Serializable;
import java.time.LocalDate;

public class Vehiculo implements Serializable {
    private int matricula;
    private String marca;
    private String modelo;
    private int añoMatriculacion;
    private int kilometraje;
    private boolean disponible;
    public Vehiculo(int matricula, String marca, String modelo, int añoMatriculacion, int kilometraje) {

        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
        this.añoMatriculacion = añoMatriculacion;
        this.disponible = true;
    }

    public Vehiculo() {
    }

    public String getMatricula() {
        return String.valueOf(matricula);
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAñoMatriculacion() {
        return String.valueOf(añoMatriculacion);
    }

    public void setAñoMatriculacion(int añoMatriculacion) {
        this.añoMatriculacion = añoMatriculacion;
    }

    public String getKilometraje() {
        return String.valueOf(kilometraje);
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void mostrarInfo() {
        System.out.println("Matricula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo + ", AñoMatriculacion: " + añoMatriculacion + ", Kilometraje: " + kilometraje);
    }

    public boolean getDisponible() {
        return disponible;
    }
}
