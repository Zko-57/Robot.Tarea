package org.iesalandalus.programacion.robot.modelo;

public class pruebas {

    public static void main(String[] args) {
            Zona zona = new Zona(60, 60);
            System.out.println(zona.getCentro());

            Coordenada coordenada1 = new Coordenada(20,40);
        System.out.println("La coordenada 1 es: " + zona.pertenece(coordenada1));
        System.out.println(zona.getCentro());

        System.out.println();

        System.out.println("Robot 1");
        Robot robot1 = new Robot(new Zona(60, 60), Orientacion.ESTE, zona.getCentro());
        System.out.println("Estas son las caracteristicas de Robot 1: ");
        System.out.println(robot1);
        System.out.println();
        System.out.println("Robot 1 avanza hacia el norte");

        try {
            robot1.avanzar();
        } catch (RobotExcepcion e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        System.out.println(robot1);

        System.out.println();

        robot1.girarALaDerecha();

        System.out.println();

        System.out.println(robot1);
    }

}

