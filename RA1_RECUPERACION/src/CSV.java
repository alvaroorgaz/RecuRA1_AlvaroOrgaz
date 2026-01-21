import datos.Empresa;
import datos.Vehiculo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class CSV {


    public static void generarCSV(List<Vehiculo> listaVehiculos) {
        System.out.println("Generando archivo CSV...");

        // try-with-resources: asegura el cierre del escritor y fuerza codificación UTF-8
        try (BufferedWriter writer = Files.newBufferedWriter(
                Paths.get("listaVehiculos.csv"), StandardCharsets.UTF_8)) {

            // Encabezados del CSV
            writer.append("Matricula,Marca,Modelo,AñoMatriculacion,Kilometraje,Disponible").append('\n');

            // Escribir cada movimiento como una línea en el CSV
            for (Vehiculo lis : listaVehiculos) {
                writer.append('"').append(csvEscape(lis.getMatricula())).append('"').append(',');
                writer.append('"').append(csvEscape(lis.getMarca())).append('"').append(',');
                writer.append('"').append(csvEscape(lis.getModelo())).append('"').append(',');
                writer.append('"').append(csvEscape(lis.getAñoMatriculacion())).append('"').append(',');
                writer.append('"').append(csvEscape(lis.getKilometraje())).append('"').append(',');
                writer.append(String.valueOf(lis.getDisponible())).append(',');

                writer.append("\"\"").append('\n');
            }

            System.out.println("Archivo CSV generado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo CSV: " + e.getMessage());
        }
    }

    private static String getMatricula() {
        return null;
    }


    private static String csvEscape(String s) {
        if (s == null) return "";
        return s.replace("\"", "\"\"");

    }
}