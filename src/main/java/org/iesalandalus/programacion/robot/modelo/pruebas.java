package org.iesalandalus.programacion.robot.modelo;

public class pruebas {

    public static void main(String[] args) {
            Zona zona = new Zona(60, 60);
            System.out.println(zona.getCentro());

            Coordenada coordenada1 = new Coordenada(20,40);
        System.out.println("La coordenada 1 es: " + zona.pertenece(coordenada1));
        System.out.println(zona.getCentro());

    }

}

