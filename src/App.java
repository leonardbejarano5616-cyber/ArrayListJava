import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import modelos.Producto;

public class App {
    public static void main(String[] args) {

        ArrayList<Producto> inventario = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // Agregar productos iniciales
        inventario.add(new Producto("Camiseta",   35000, 50));
        inventario.add(new Producto("Pantalon",   89000, 30));
        inventario.add(new Producto("Zapatos",   150000, 20));
        inventario.add(new Producto("Medias",      8000, 100));
        inventario.add(new Producto("Chaqueta",  220000, 15));

        int opcion;

        do {
            System.out.println("\n=== INVENTARIO ===");
            System.out.println("1. Ver todos los productos");
            System.out.println("2. Agregar producto");
            System.out.println("3. Buscar producto por nombre");
            System.out.println("4. Eliminar producto por nombre");
            System.out.println("5. Producto mas caro y mas barato");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("\nTotal: " + inventario.size() + " productos");
                    for (int i = 0; i < inventario.size(); i++) {
                        System.out.println((i+1) + ". " + inventario.get(i));
                    }
                    break;

                case 2:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    System.out.print("Stock: ");
                    int stock = sc.nextInt();
                    sc.nextLine();
                    inventario.add(new Producto(nombre, precio, stock));
                    System.out.println("Producto agregado.");
                    break;

                case 3:
                    System.out.print("Nombre a buscar: ");
                    String buscar = sc.nextLine().toLowerCase();
                    boolean encontrado = false;
                    for (Producto p : inventario) {
                        if (p.getNombre().toLowerCase().contains(buscar)) {
                            System.out.println("Encontrado: " + p);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) System.out.println("No se encontro ningún producto.");
                    break;

                case 4:
                    System.out.print("Nombre a eliminar: ");
                    String eliminar = sc.nextLine().toLowerCase();
                    Producto aEliminar = null;
                    for (Producto p : inventario) {
                        if (p.getNombre().toLowerCase().equals(eliminar)) {
                            aEliminar = p;
                            break;
                        }
                    }
                    if (aEliminar != null) {
                        inventario.remove(aEliminar);
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 5:
                    if (inventario.isEmpty()) {
                        System.out.println("Lista vacia.");
                        break;
                    }
                    Producto caro   = inventario.get(0);
                    Producto barato = inventario.get(0);
                    for (Producto p : inventario) {
                        if (p.getPrecio() > caro.getPrecio())   caro   = p;
                        if (p.getPrecio() < barato.getPrecio()) barato = p;
                    }
                    System.out.println("Mas caro:   " + caro);
                    System.out.println("Mas barato: " + barato);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}