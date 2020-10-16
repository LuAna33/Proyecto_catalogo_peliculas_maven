package mx.com.gm.peliculas.personas;

public class Persona {
    private String nombre;
    private String clave;
    private String linea;

    public Persona(String nombre, String clave){
       this.nombre = nombre;
       this.clave = clave;
    }

    public Persona(String linea) {
     this.linea = linea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getClave()
    {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }
}
