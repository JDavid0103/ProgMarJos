package biblioteca;

public class Libro {
//    Atributos de la clase libro.
    private String autor;
    private String titulo;
    private int ejemplaresVendidos;
    private Libro secuela;
    private Libro precuela;

//    Constructores.
    public Libro (String autor, String titulo) {
        setAutor(autor);
        setTitulo(titulo);
    }

//    Setters y Getters.

    private void setAutor(String autor) {
        if (autor == null) {
            this.autor = "";
        } else {
            this.autor = autor;
        }
    }

    private void setTitulo(String titulo) {
        if (titulo == null) {
            this.titulo = "";
        } else {
            this.titulo = titulo;
        }
    }

//    Métodos
    public String obtenerInformacion() {
        String info;

        return info;
    }

    public void registrarVenta(int unidades) {
        if (unidades < 1) {
            System.out.println("[ERROR] El número de unidades especificado no es válido.");
        } else {
            this.ejemplaresVendidos += unidades;
        }
    }

    public String obtenerTituloPrecuela () {
        String titulo;

        return titulo;
    }

    public String obtenerTituloSecuela () {
        String titulo;

        return titulo;
    }

    public void mostrarResumenSaga () {

    }

    public void anadirSecuela (Libro secuela) {

    }

    public void anadirPrecuela (Libro precuela) {

    }

    public Libro[] obtenerSaga() {
        Libro[] saga = new Libro[1];

        return saga;
    }



}
