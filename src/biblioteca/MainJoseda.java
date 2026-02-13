package biblioteca;

public class MainJoseda {
  public static void main(String[] args) {
    Libro libro1 = new Libro("J. K. Rowling", "Harry Potter y la piedra filosofal");
    Libro libro2 = new Libro("J. K. Rowling", "Harry Potter y la cámara secreta");
    Libro libro3 = new Libro("J. K. Rowling", "Harry Potter y El prisionero de Azkaban");
    Libro libro4 = new Libro("J. K. Rowling", "Harry Potter y El nuevo libro A");

    libro1.anadirSiguienteEnSaga(libro2);
    libro2.anadirSiguienteEnSaga(libro3);
    libro3.anadirSiguienteEnSaga(libro4);

    libro1.registrarVenta(10000);
    libro2.registrarVenta(20000);
    libro3.registrarVenta(50000);

    System.out.println("\n=== SAGA de Harry Potter ===");
    Libro[] saga = libro1.mostrarLibrosSiguientes();
    for (int i = 0; i < saga.length; i++) {
      System.out.println("Libro nº" + (i + 1) + " siguiente del libro 1: " + saga[i].obtenerInformacion());
    }

    Libro libro1saga2 = new Libro("José David", "Mario y sus aventuras");
    Libro libro2saga2 = new Libro("José David", "Hugo y sus aventuras");
    Libro libro3saga2 = new Libro("José David", "Alberto y sus aventuras");
    Libro libro4saga2 = new Libro("José David", "Manu y sus aventuras");

    libro1saga2.anadirSiguienteEnSaga(libro2saga2);
    libro2saga2.anadirSiguienteEnSaga(libro3saga2);
    libro3saga2.anadirSiguienteEnSaga(libro4saga2);

    libro2saga2.registrarVenta(10000);
    libro4saga2.registrarVenta(26000);

    System.out.println("\n=== SAGA de José David ===");
    Libro[] saga2 = libro1saga2.mostrarLibrosSiguientes();
    for (int i = 0; i < saga2.length; i++) {
      System.out.println("Libro nº" + (i + 1) + " siguiente del libro 1: " + saga2[i].obtenerInformacion());
    }

    obtenerSagaMasVendida(libro1, libro1saga2);
  }

  public static void obtenerSagaMasVendida(Libro libro1, Libro libro2) {
    if (libro1 != null && libro2 != null) {
      Libro[] sagaA = libro1.obtenerSaga(), sagaB = libro2.obtenerSaga();
      int totalVentasSagaA = 0, totalVentasSagaB = 0;

      for (Libro libro: sagaA) {
        totalVentasSagaA += libro.getEjemplaresVendidos();
      }

      for (Libro libro: sagaB) {
        totalVentasSagaB += libro.getEjemplaresVendidos();
      }

      if (totalVentasSagaA > totalVentasSagaB) {
        System.out.println("\n- La saga de '"+libro1.getTitulo()+"' tiene mas número de ejemplares vendidos ("
          +totalVentasSagaA+" vs "+totalVentasSagaB+")."
        );
      } else if (totalVentasSagaA < totalVentasSagaB) {
        System.out.println("\n- La saga de '"+libro2.getTitulo()+"' tiene mas número de ejemplares vendidos ("
          +totalVentasSagaB+" vs "+totalVentasSagaA+")."
        );
      } else {
        System.out.println("\n- Las 2 sagas tienen el mismo número de ejemplares vendidos ("+totalVentasSagaA+").");
      }
    }
  }
}