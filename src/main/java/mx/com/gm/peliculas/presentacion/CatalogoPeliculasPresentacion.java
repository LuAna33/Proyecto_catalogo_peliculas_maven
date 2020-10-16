package mx.com.gm.peliculas.presentacion;

import mx.com.gm.peliculas.servicio.CatalogoPeliculasImpl;
import mx.com.gm.peliculas.servicio.ICatalogoPeliculas;
import mx.com.gm.peliculas.servicio.ISocios;
import mx.com.gm.peliculas.servicio.SociosImpl;

import java.util.Scanner;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        var opcion = -1;
        Scanner scanner = new Scanner(System.in);
        ISocios socio = new SociosImpl();
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while (opcion != 0) {
            System.out.println("\n"
                    + "BIENVENIDO A TU CATALOGO DE PELICULAS \n"
                    + "SELECCIONA UNA OPCION \n"
                    + " 1.INICIAR LISTADO DE SOCIOS \n"
                    + " 2.AGREGAR SOCIO \n"
                    + " 3.LISTAR SOCIOS \n"
                    + " 4.BUSCAR SOCIO \n"
                    + " 5.INICIAR CATALOGO DE PELICULAS \n"
                    + " 6.AGREGAR PELICULA \n"
                    + " 7.LISTAR PELICULAS \n"
                    + " 8.BUSCAR PELICULA \n"
                    + " 0. SALIR\n");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Ha seleccionado Reiniciar el listado de Socios");
                    socio.iniciarListaSocios();
                    break;
                case 2:
                    System.out.println("Ha seleccionado Agregar un Socio");
                    System.out.println("Ingresar nombre");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingresar Clave");
                    String clave = scanner.nextLine();
                    socio.agregarSocio(nombre, clave );
                    break;
                case 3:
                    System.out.println("Ha seleccionado Listar Socios");
                    socio.listarSocios();
                    break;
                case 4:
                    System.out.println("Ha seleccionado Buscar un Socio");
                    System.out.println("Ingrese el nombre del socio a buscar");
                    var buscar = scanner.nextLine();
                    socio.buscarSocio(buscar);
                    break;
                case 5:
                        System.out.println("Ha seleccionado Reiniciar el Catalogo");
                        catalogo.iniciarCatalogoPeliculas();
                        break;
                case 6:
                        System.out.println("Ha seleccionado Agregar Pelicula");
                        String nombrePelicula = scanner.nextLine();
                        catalogo.agregarPelicula(nombrePelicula);
                        break;
                case 7:
                        System.out.println("Ha seleccionado Listar Peliculas");
                        catalogo.listarPeliculas();
                        break;
                case 8:
                        System.out.println("Ha seleccionado Buscar pelicula");
                        System.out.println("Ingrese el nombre de la pelicula a buscar");
                        var buscarP = scanner.nextLine();
                        catalogo.buscarPeliculas(buscarP);
                        break;
                case 0:
                        System.out.println("GRACIAS POR TU VISITA. ¡HASTA PRONTO!");
                        break;
                default:
                        System.out.println("Vuelva a intentarlo.La opcion ingresada no es correcta. ");
                        break;
                }
            }
        }

    }
