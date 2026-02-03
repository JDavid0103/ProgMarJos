package biblioteca;

public class PruebaBiblioteca {
  public static void main(String[] args) {
    System.out.println("=== CASO 1 ===");
    Libro libro1 = new Libro("J. K. Rowling", "Harry Potter y la piedra filosofal");
    System.out.println(libro1.obtenerInformacion());

    System.out.println("=== CASO 2 ===");
    libro1.registrarVenta(10000);
    System.out.println(libro1.obtenerInformacion());

    System.out.println("=== CASO 3 ===");
    Libro libro2 = new Libro("J. K. Rowling", "Harry Potter y la cámara secreta");
    libro2.registrarVenta(20000);
    System.out.println(libro2.obtenerInformacion());

    System.out.println("=== CASO 4 ===");
    System.out.println(libro1.obtenerTituloPrecuela());
    System.out.println(libro1.obtenerTituloSecuela());
    System.out.println(libro2.obtenerTituloPrecuela());
    System.out.println(libro2.obtenerTituloSecuela());
    libro1.mostrarResumenSaga();

    System.out.println("=== CASO 5 ===");
    libro1.anadirSecuela(libro2);

    System.out.println(libro1.obtenerTituloPrecuela());
    System.out.println(libro1.obtenerTituloSecuela());
    System.out.println(libro2.obtenerTituloPrecuela());
    System.out.println(libro2.obtenerTituloSecuela());

//    System.out.println("=== CASO 6 ===");
//    libro1.mostrarResumenSaga();
//
//    System.out.println("=== CASO 7 ===");
//    libro2.mostrarResumenSaga();
//
//    System.out.println("=== CASO 8 ===");
//    Libro[] saga = libro2.obtenerSaga();
//    for (int i = 0; i < saga.length; i++) {
//      System.out.println("El libro " + (i + 1) + " de la saga es: " + saga[i].obtenerInformacion());
//    }
//
//    System.out.println("=== CASO 9 ===");
//    Libro libro3 = new Libro("J. K. Rowling", "Harry Potter y El prisionero de Azkaban");
//    libro3.registrarVenta(50000);
//    libro3.mostrarResumenSaga();
//
//    System.out.println("=== CASO 10 ===");
//    libro2.anadirSecuela(libro3);
//    libro3.mostrarResumenSaga();
//
//    System.out.println("=== CASO 11 ===");
//    libro1.mostrarResumenSaga();
//    libro2.mostrarResumenSaga();
//
//    System.out.println("=== CASO 12 ===");
//    Libro[] sagaNueva = libro2.obtenerSaga();
//    for (int i = 0; i < sagaNueva.length; i++) {
//      System.out.println("El libro " + (i + 1) + " de la saga es: " + sagaNueva[i].obtenerInformacion());
//    }
  }
}