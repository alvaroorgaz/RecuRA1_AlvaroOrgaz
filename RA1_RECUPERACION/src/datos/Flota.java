package datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Flota implements Serializable {

    private Empresa empresa;
    private ArrayList<Vehiculo> vehiculos;


    public Flota( Empresa empresa) {
        this.empresa = empresa;
        this.vehiculos = new ArrayList<>();

    }


    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }


    public void añadirVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);

    }

    public void darBajaVehiculo(int matriculaBaja) {
        for (Vehiculo v : vehiculos) {
            if (v.getMatricula().equals(String.valueOf(matriculaBaja))) {
                v.setDisponible(false);
                System.out.println("Vehiculo con matrícula " + matriculaBaja + " dado de baja.");
                break;
            }
        }
    }
}



