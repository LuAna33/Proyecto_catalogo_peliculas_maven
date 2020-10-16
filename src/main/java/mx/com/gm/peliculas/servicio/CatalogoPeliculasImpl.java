package mx.com.gm.peliculas.servicio;

import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.datos.IAccesoDatos;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosExcepciones;
import mx.com.gm.peliculas.excepciones.LecturaDatosExcepciones;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl(){
        this.datos = new AccesoDatosImpl("catalogoPelis.txt");
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe();
            datos.escribir(pelicula, anexar);
        } catch (AccesoDatosExcepciones accesoDatosExcepciones) {
            accesoDatosExcepciones.printStackTrace();
            System.out.println("Se ha producido un error. No ha sido posible agregar la Pelicula");
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = datos.listar();
            for (var pelicula: peliculas){
                System.out.println("Pelicula: " + pelicula);
            }
        } catch (LecturaDatosExcepciones lecturaDatosExcepciones) {
            lecturaDatosExcepciones.printStackTrace();
            System.out.println("Se ha producido un error. No ha sido posible Listar");
        }
    }

    @Override
    public void buscarPeliculas(String buscar) {
        String resultado = null;
        try {
            resultado = datos.buscar(buscar);

        } catch (LecturaDatosExcepciones lecturaDatosExcepciones) {
            lecturaDatosExcepciones.printStackTrace();
            System.out.println("Se ha producido un error. No es posible buscar la pelicula");
        }
        System.out.println("Resultado: " + resultado);

    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.existe()) {
                datos.borrar();
                datos.crear();
            }
            else{
                datos.crear();
            }
        } catch (AccesoDatosExcepciones accesoDatosExcepciones) {
            accesoDatosExcepciones.printStackTrace();
            System.out.println("Se ha producido un error. No es posible iniciar el catalogo");
        }
    }
}
