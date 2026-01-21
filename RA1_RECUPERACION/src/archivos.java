import datos.Flota;

import java.io.*;

public class archivos {
    private static final String FILE_NAME = "flota.dat";
    public static Flota cargarFlota() {
        Flota flota = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            flota = (Flota) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar la flota: " + e.getMessage());
        }
        return flota;
    }


    public static void guardarCuenta(Flota flota) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(flota);
        } catch (IOException e) {
            System.out.println("Error al guardar la empresa: " + e.getMessage());
        }
    }
}
