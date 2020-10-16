package mx.com.gm.peliculas.servicio;

public interface ISocios {

    void agregarSocio(String nombre, String clave);
    void listarSocios();
    void buscarSocio(String buscar);
    void iniciarListaSocios();
}
