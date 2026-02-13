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
        info = "El libro "+this.titulo+" es de "+this.autor+" y ha vendido un total de: "+this.ejemplaresVendidos+" ejemplares";
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
        String titulo = "La precuela de "+this.titulo+" es: ";
            if (this.precuela == null) {
                titulo += "<NINGUNA>";
            } else {
                titulo += this.precuela.getTitulo();
            }
        return titulo;
    }

    public String obtenerTituloSecuela() {
        String titulo = "La secuela de "+this.titulo+" es: ";
        if (this.secuela == null) {
            titulo += "<NINGUNA>";
        } else {
            titulo += this.secuela.getTitulo();
        }
        return titulo;
    }

    public void mostrarResumenSaga() {
        int numLibro = 0, totalVentas = 0;
        Libro[] saga = this.obtenerSaga();
        for (int i = 0; i < saga.length; i++) {
            if (saga[i] == this) {
                numLibro = i+1;
            }
            totalVentas += saga[i].getEjemplaresVendidos();
        }
        System.out.println("El libro "+this.titulo+" es el libro número "+numLibro+" de una saga que tiene un total de "+saga.length+" libros. Entre todos ellos han vendido un total de "+totalVentas+" ejemplares.");
    }

    public void anadirSecuela(Libro secuela) {
        this.secuela = secuela;
        secuela.precuela = this;
    }

    public void anadirPrecuela(Libro precuela) {
        this.precuela = precuela;
        precuela.secuela = this;
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

    public void anadirSiguienteEnSaga(Libro nuevo) {
        if (nuevo != null) {
            if (this.secuela != null) {
                this.secuela.anadirPrecuela(nuevo);
            }
            this.anadirSecuela(nuevo);
        } else {
            System.out.println("\n- El nuevo libro a añadir no puede ser null.");
        }
    }

    public Libro[] mostrarLibrosSiguientes() {
        Libro[] res = null;

        if (this.secuela != null) {
            Libro libroActual = this;

            //  Cuento el número de libros totales.
            int libros = 0;
            while (libroActual.secuela != null) {
                libros++;
                libroActual = libroActual.secuela;
            }

            //  Relleno el array de libros con los libros correspondientes.
            libroActual = this;
            res = new Libro[libros];
            for (int i = 0; i < res.length; i++) {
                res[i] = libroActual.secuela;
                libroActual = libroActual.secuela;
            }
        }

        return res;
    }
}