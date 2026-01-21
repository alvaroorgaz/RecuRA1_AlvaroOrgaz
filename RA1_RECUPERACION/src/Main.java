import datos.Empresa;
import datos.Flota;
import datos.Vehiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Carga la cuenta desde archivo (si existe); si no, crea una nueva pidiendo los datos
        Flota flota = archivos.cargarFlota();

        if (flota == null) {

            System.out.println("Ingresa los datos de la empresa: ");
            System.out.println("Nombre de la empresa: ");
            String nombre = scanner.nextLine();
            System.out.println("CIF de la empresa: ");
            String cif = scanner.nextLine();
            System.out.println("Teléfono de la empresa: ");
            int telefono = Integer.parseInt(scanner.nextLine());

            Empresa empresa = new Empresa(nombre, cif, telefono);

            System.out.println("No se encontró una flota . Introduce un vehiculo para crear la flota.");
            System.out.print("Ingrese la matricula del vehiculo: ");
            int matricula = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese la marca  del vehiculo: ");
            String marca = scanner.nextLine();
            System.out.print("Ingrese el modelo del vehiculo: ");
            String modelo = scanner.nextLine();
            System.out.print("Ingrese el año del vehiculo: ");
            int añoMatriculacion = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese el kilometraje del vehiculo: ");
            int kilometraje = Integer.parseInt(scanner.nextLine());

            Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo, añoMatriculacion, kilometraje);
            flota = new Flota(empresa);
            flota.añadirVehiculo(vehiculo);

        }

        int opcion;
        // Bucle principal del menú; se repite hasta elegir la opción de salida (7)
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Añadir vehiculo");
            System.out.println("2. Dar de baja vehiculo ");
            System.out.println("3. Listar vehiculos ");
            System.out.println("4. Exportar vehiculos a CSV");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            // Validación de entrada: aseguramos que sea un número entero
            while (!scanner.hasNextInt()) {
                System.out.print("Entrada no válida. Seleccione una opción numérica: ");
                scanner.next();
            }
            opcion = scanner.nextInt();

            // Procesa la opción seleccionada
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la matricula del vehiculo: ");
                    int matricula = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese la marca  del vehiculo: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese el modelo del vehiculo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese el año del vehiculo: ");
                    int añoMatriculacion = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese el kilometraje del vehiculo: ");
                    int kilometraje = Integer.parseInt(scanner.nextLine());
                    Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo, añoMatriculacion, kilometraje);
                    flota.añadirVehiculo(vehiculo);
                    System.out.println("Vehiculo añadido.");
                    break;

                case 2:
                    // Retirar dinero: valida que se introduzca un número
                    System.out.print("Ingrese la matricula del vehiculo para dar de baja: ");

                    int matriculaBaja = Integer.parseInt(scanner.nextLine());
                    flota.darBajaVehiculo(matriculaBaja);

                    break;
                case 3:

                    ArrayList<Vehiculo> listaVehiculos = flota.getVehiculos();
                    System.out.println("Lista de vehiculos:");
                    for (Vehiculo v : listaVehiculos) {
                        v.mostrarInfo();
                    }
                    break;
                case 4:
                    // Exporta movimientos a CSV (archivo movimientos.csv)
                    CSV.generarCSV(flota.getVehiculos());
                    break;

                case 5:
                    // Guarda la cuenta en archivo binario y sale
                    archivos.guardarCuenta(flota);
                    System.out.println("Cuenta guardada. Saliendo...");
                    break;
                default:
                    // Opción fuera de rango
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5); // condición de salida

        // Cierra el scanner al finalizar
        scanner.close();
    }
}