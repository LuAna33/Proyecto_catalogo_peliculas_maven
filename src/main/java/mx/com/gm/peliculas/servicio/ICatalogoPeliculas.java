package mx.com.gm.peliculas.servicio;

public interface ICatalogoPeliculas {

    void agregarPelicula(String nombrePelicula);
    void listarPeliculas();
    void buscarPeliculas(String buscar);
    void iniciarCatalogoPeliculas();
}
