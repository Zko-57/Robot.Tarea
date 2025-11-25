package org.iesalandalus.programacion.robot.modelo;

public class ControladorRobot {


    private Robot robot;


    public ControladorRobot(Robot robot)  {
        if (robot == null){
            throw new NullPointerException("El robot no puede ser nulo.");
        }
        this.robot = new Robot();
    }


    public Robot getRobot(){
        return new Robot();
    }


    public void ejecutar(char comando) throws RobotExcepcion {
            switch (comando) {
                case 'A':
                    robot.avanzar();
                    break;
                case 'a':
                    robot.avanzar();
                    break;

                case 'D':
                    robot.girarALaDerecha();
                    break;
                case 'd':
                    robot.girarALaDerecha();
                    break;

                case 'I':
                    robot.girarALaIzquierda();
                    break;
                case 'i':
                    robot.girarALaIzquierda();
                    break;
                default:
                    throw new RobotExcepcion("Comando desconocido.");
            }
    }
}
