package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Robot {
    private Coordenada coordenada;
    private Zona zona;
    private Orientacion orientacion;


    public Robot() {
        zona = new Zona();
        orientacion = Orientacion.NORTE;
        coordenada = zona.getCentro();
    }

    public Robot(Zona zona) {
        setZona(zona);
        coordenada = zona.getCentro();
        orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona, Orientacion orientacion) {
        setZona(zona);
        setOrientacion(orientacion);
        coordenada = zona.getCentro();
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        setZona(zona);
        setOrientacion(orientacion);
        setCoordenada(coordenada);
    }

    public Robot(Robot robot) {
        Objects.requireNonNull(robot, "El robot no puede ser nulo.");
        this.zona = robot.zona;
        this.coordenada = robot.coordenada;
        this.orientacion = robot.orientacion;

    }

    public Zona getZona() {
        return zona;
    }

    private void setZona(Zona zona) {
        Objects.requireNonNull(zona, "La zona no puede ser nula.");
        this.zona = zona;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    private void setOrientacion(Orientacion orientacion) {
        Objects.requireNonNull(orientacion, "La orientación no puede ser nula.");
        this.orientacion = orientacion;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    private void setCoordenada(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        if (!zona.pertenece(coordenada)){
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
        this.coordenada = coordenada;
    }

    public void avanzar() throws RobotExcepcion {
        try {
            switch (orientacion) {
                case NORTE -> setCoordenada(new Coordenada(coordenada.x(), coordenada.y() + 1));
                case SUR -> setCoordenada(new Coordenada(coordenada.x(), coordenada.y() - 1));
                case ESTE -> setCoordenada(new Coordenada(coordenada.x() + 1, coordenada.y()));
                case OESTE -> setCoordenada(new Coordenada(coordenada.x() - 1, coordenada.y()));
                case NORESTE -> setCoordenada(new Coordenada(coordenada.x() + 1, coordenada.y() + 1));
                case SURESTE -> setCoordenada(new Coordenada(coordenada.x() + 1, coordenada.y() - 1));
                case NOROESTE -> setCoordenada(new Coordenada(coordenada.x() - 1, coordenada.y() + 1));
                case SUROESTE -> setCoordenada(new Coordenada(coordenada.x() - 1, coordenada.y() - 1));
            }
        } catch (IllegalArgumentException e) {
            throw new RobotExcepcion("No se puede avanzar, ya que se sale de la zona.");
        }
    }

    public void girarALaDerecha() {
        switch (orientacion) {
            case NORTE -> orientacion = Orientacion.NORESTE;
            case SUR -> orientacion = Orientacion.SUROESTE;
            case ESTE -> orientacion = Orientacion.SURESTE;
            case OESTE -> orientacion = Orientacion.NOROESTE;
            case NORESTE -> orientacion = Orientacion.ESTE;
            case SURESTE -> orientacion = Orientacion.SUR;
            case SUROESTE -> orientacion = Orientacion.OESTE;
            case NOROESTE -> orientacion = Orientacion.NORTE;
        }
    }

    public void girarALaIzquierda() {
        switch (orientacion) {
            case NORTE -> orientacion = Orientacion.NOROESTE;
            case NOROESTE -> orientacion = Orientacion.OESTE;
            case OESTE -> orientacion = Orientacion.SUROESTE;
            case SUROESTE -> orientacion = Orientacion.SUR;
            case SUR -> orientacion = Orientacion.SURESTE;
            case SURESTE -> orientacion = Orientacion.ESTE;
            case ESTE -> orientacion = Orientacion.NORESTE;
            case NORESTE -> orientacion = Orientacion.NORTE;

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(coordenada, robot.coordenada) && Objects.equals(zona, robot.zona) && orientacion == robot.orientacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordenada, zona, orientacion);
    }

    @Override
    public String toString() {
        return String.format("[coordenada=%s, zona=%s, orientacion=%s]", coordenada, zona, orientacion);
    }

}