package GestionableConcesionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Concesionario.*;
import EntradaSalida.MyInput;

public class GestionSeccion  {

        private ArrayList<Seccion> secciones = new ArrayList<>();


        public void agregarSeccion() {
            System.out.println("Nombre de la sección:");
            String idSeccion = MyInput.readString();
            System.out.println("Descripción de la sección:");
            String descripcion = MyInput.readString();

            if (existeSeccion(idSeccion)) {
                System.out.println("Ya existe una sección con el ID: " + idSeccion);
            } else {
                secciones.add(new Seccion(idSeccion, descripcion));
                System.out.println("Sección añadida exitosamente.");
            }
        }


        public void mostrarSecciones() {
            if (secciones.isEmpty()) {
                System.out.println("No hay secciones disponibles.");
                return;
            }

            for (Seccion seccion : secciones) {
                System.out.println("ID de la sección: " + seccion.getIdSeccion() +
                        ", Descripción: " + seccion.getDescripcion());
            }
        }


        public void bajaSeccion() {
            System.out.println("Introduce el ID de la sección a eliminar:");
            String idSeccion = MyInput.readString();

            if (!existeSeccion(idSeccion)) {
                System.out.println("No existe una sección con el ID: " + idSeccion);
                return;
            }

            if (cochesEnSeccion(idSeccion)) {
                System.out.println("No se puede eliminar la sección porque contiene coches.");
                return;
            }

            secciones.removeIf(seccion -> seccion.getIdSeccion().equals(idSeccion));
            System.out.println("Sección eliminada exitosamente.");
        }


        private boolean existeSeccion(String idSeccion) {
            for (Seccion seccion : secciones) {
                if (seccion.getIdSeccion().equals(idSeccion)) {
                    return true;
                }
            }
            return false;
        }


        private boolean cochesEnSeccion(String idSeccion) {
            // Assume coches is managed elsewhere, for example:
            ArrayList<Coches> coches = Concesionario.getGestionCoches().getCoches();

            for (Coches coche : coches) {
                if (coche.getIdSeccion().equals(idSeccion)) {
                    return true;
                }
            }
            return false;
        }
        public ArrayList<Seccion> getSecciones() {
            return secciones;
        }




    }
