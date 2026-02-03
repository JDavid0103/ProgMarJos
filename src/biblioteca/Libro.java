package biblioteca;

import java.util.Arrays;

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

    public String getTitulo() {
        return titulo;
    }

    public int getEjemplaresVendidos() {
        return ejemplaresVendidos;
    }

    //    Métodos

//    Este metodo se encarga de mirar cuántos libros hay dentro de la saga.
    private int numLibrosSaga() {
        int numLibros = 1;
        Libro precuelaActual = this.precuela;
        Libro secuelaActual = this.secuela;
        while (precuelaActual != null) {
            numLibros++;
            precuelaActual = precuelaActual.precuela;
        }
        while (secuelaActual != null) {
            numLibros++;
            secuelaActual = secuelaActual.secuela;
        }
        return numLibros;
    }

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

    public String obtenerTituloPrecuela() {
        String titulo;
            if (this.precuela == null) {
                titulo = "<NINGUNA>";
            } else {
                titulo = this.precuela.getTitulo();
            }
        return titulo;
    }

    public String obtenerTituloSecuela() {
        String titulo;
        if (this.secuela == null) {
            titulo = "<NINGUNA>";
        } else {
            titulo = this.secuela.getTitulo();
        }
        return titulo;
    }

    public void mostrarResumenSaga() {

    }

    public void anadirSecuela(Libro secuela) {
        this.secuela = secuela;
        secuela.anadirPrecuela(this);
    }

    public void anadirPrecuela(Libro precuela) {
        this.precuela = precuela;
        precuela.anadirSecuela(this);
    }

    public Libro[] obtenerSaga() {
        Libro[] saga = new Libro[this.numLibrosSaga()];
        Libro primerLibroSaga = this;

        while (primerLibroSaga.precuela != null) {
            primerLibroSaga = primerLibroSaga.precuela;
        }

        for (int i = 0; i < saga.length; i++) {
            saga[i] = primerLibroSaga;
            primerLibroSaga = primerLibroSaga.secuela;
        }

        return saga;
    }
}