package mx.com.gm.peliculas.servicio;

import mx.com.gm.peliculas.datos.AccesoDatosPersonasImpl;
import mx.com.gm.peliculas.datos.IAccesoDatosPersonas;
import mx.com.gm.peliculas.excepciones.AccesoDatosExcepciones;
import mx.com.gm.peliculas.excepciones.LecturaDatosExcepciones;
import mx.com.gm.peliculas.personas.Socio;

public class SociosImpl implements ISocios {

    private final IAccesoDatosPersonas datos;

    public SociosImpl(){
       this.datos = new AccesoDatosPersonasImpl("listadosocios.txt");
    }

    @Override
    public void agregarSocio(String nombre, String clave) {

            Socio socio = new Socio(nombre, clave);
            boolean anexar = false;
            try {
                anexar = datos.existe();
                datos.escribir(socio, anexar);
            } catch (AccesoDatosExcepciones accesoDatosExcepciones) {
                accesoDatosExcepciones.printStackTrace();
                System.out.println("Se ha producido un error. No ha sido posible agregar el nuevo socio");
            }
    }

    @Override
    public void listarSocios() {
        try {
            var socios = datos.listar();
            for (var socio: socios){
                System.out.println("Socio: " + socio);
            }
        } catch (LecturaDatosExcepciones lecturaDatosExcepciones) {
            lecturaDatosExcepciones.printStackTrace();
            System.out.println("Se ha producido un error. No ha sido posible Listar los socios");
        }
    }

    @Override
    public void buscarSocio(String buscar) {
        String resultado = null;
        try {
            resultado = datos.buscar(buscar);

        } catch (LecturaDatosExcepciones lecturaDatosExcepciones) {
            lecturaDatosExcepciones.printStackTrace();
            System.out.println("Se ha producido un error. No es posible buscar el socio solicitado.");
        }
        System.out.println("Resultado: " + resultado);
    }


    @Override
    public void iniciarListaSocios() {
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
            System.out.println("Se ha producido un error. No es posible iniciar el listado de Socios");
        }
    }
    }
