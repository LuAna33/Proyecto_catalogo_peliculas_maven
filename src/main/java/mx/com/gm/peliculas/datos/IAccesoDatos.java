package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosExcepciones;
import mx.com.gm.peliculas.excepciones.EscrituraDatosExcepciones;
import mx.com.gm.peliculas.excepciones.LecturaDatosExcepciones;

import java.util.List;

public interface IAccesoDatos {


     boolean existe() throws AccesoDatosExcepciones;

     List<Pelicula> listar() throws LecturaDatosExcepciones;

     void escribir(Pelicula pelicula, boolean anexar) throws EscrituraDatosExcepciones;

     String buscar(String buscar) throws LecturaDatosExcepciones;

     void crear() throws AccesoDatosExcepciones;

     void borrar() throws AccesoDatosExcepciones;

}
