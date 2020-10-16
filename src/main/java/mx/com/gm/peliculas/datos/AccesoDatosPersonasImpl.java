package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.excepciones.AccesoDatosExcepciones;
import mx.com.gm.peliculas.excepciones.EscrituraDatosExcepciones;
import mx.com.gm.peliculas.excepciones.LecturaDatosExcepciones;
import mx.com.gm.peliculas.personas.Socio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosPersonasImpl implements IAccesoDatosPersonas {
    private String archivoDatosSocios;

    public AccesoDatosPersonasImpl(String archivoDatosSocios) {
        this.archivoDatosSocios = archivoDatosSocios;
    }

    @Override
    public boolean existe() throws AccesoDatosExcepciones {
        File archivo = new File(archivoDatosSocios);
        return archivo.exists();
    }

    @Override
    public void escribir(Socio socio, boolean anexar) throws EscrituraDatosExcepciones {
        File archivo = new File(archivoDatosSocios);
        try {
            PrintWriter salida = new PrintWriter (new FileWriter(archivo, anexar));
            salida.println(socio.toString());
            salida.close();
            System.out.println("Ha ingresado el nombre del Socio: " + socio);
        } catch (IOException e) {
            e.printStackTrace();
            throw new EscrituraDatosExcepciones("Se produjo un error al escribir el socio:" + e.getMessage());
        }
    }


    @Override
    public void crear() throws AccesoDatosExcepciones {
        File archivo = new File(archivoDatosSocios);
        PrintWriter salida = null;
        try {
            salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado un nuevo Socio");
        } catch (IOException e) {
            e.printStackTrace();
            throw new AccesoDatosExcepciones("Se produjo una excepcion crear el archivo: " + e.getMessage());
        }
    }

    @Override
    public void borrar() throws AccesoDatosExcepciones {
        File archivo = new File(archivoDatosSocios);
        if (archivo.exists()){
            archivo.delete();
            //System.out.println("El archivo ha sido borrado");
        }
    }

    @Override
    public String buscar(String buscar) throws LecturaDatosExcepciones {
        File archivo = new File(archivoDatosSocios);
        String resultado = null;
        BufferedReader entrada = null;
        try {
            entrada = new BufferedReader(new FileReader(archivo));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String linea = null;
        try {
            linea = entrada.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int indice = 1;

        while (linea != resultado) {
            if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                return "El Socio: " + ". Se ubica en el numero de indice: " + indice;
            }
            try {
                linea = entrada.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            indice++;
        }
        try {
            entrada.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }




    @Override
    public List<Socio> listar() throws LecturaDatosExcepciones {
        File archivo = new File(archivoDatosSocios);
        List<Socio> socios = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                Socio socio = new Socio(linea);
                socios.add(socio);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException a) {
            a.printStackTrace();
            throw new LecturaDatosExcepciones("Se produjo un error al listar los socios:" + a.getMessage());
        } catch (IOException a) {
            a.printStackTrace();
            throw new LecturaDatosExcepciones("Se produjo un error al listar los socios:" + a.getMessage());
        }
        return socios;
    }
}
