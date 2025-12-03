package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.Coordenada;
import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Orientacion;
import org.iesalandalus.programacion.robot.modelo.Robot;
import org.iesalandalus.programacion.robot.modelo.RobotExcepcion;
import org.iesalandalus.programacion.robot.modelo.Zona;
import org.iesalandalus.programacion.robot.vista.Consola;

public class Main {

    public static void main(String[] args) {
        ControladorRobot controladorRobot = null;
        int opcion;

        do {
            Consola.mostrarMenuPrincipal();
            opcion = Consola.elegirOpcion();

            switch (opcion) {
                case 1 -> controladorRobot = new ControladorRobot(new Robot());
                case 2 -> {
                    Zona zona = Consola.elegirZona();
                    controladorRobot = new ControladorRobot(new Robot(zona));
                }
                case 3 -> {
                    Zona zona = Consola.elegirZona();
                    Consola.mostrarMenuOrientacion();
                    Orientacion orientacion = Consola.elegirOrientacion();
                    controladorRobot = new ControladorRobot(new Robot(zona, orientacion));
                }
                case 4 -> {
                    Zona zona = Consola.elegirZona();
                    Consola.mostrarMenuOrientacion();
                    Orientacion orientacion = Consola.elegirOrientacion();
                    Coordenada coordenada = Consola.elegirCoordenada();
                    controladorRobot = new ControladorRobot(new Robot(zona, orientacion, coordenada));
                }
                case 5 -> ejecutarComando(controladorRobot);
                default -> {
                }
            }

            Consola.mostrarRobot(controladorRobot);
        } while (opcion != 0);

        Consola.despedirse();
    }

    private static void ejecutarComando(ControladorRobot controladorRobot) {
        if (controladorRobot == null) {
            System.out.println("Debes crear un robot antes de ejecutar un comando.");
            return;
        }

        char comando = Consola.elegirComando();
        try {
            controladorRobot.ejecutar(comando);
        } catch (RobotExcepcion e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}