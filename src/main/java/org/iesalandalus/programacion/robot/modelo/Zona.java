package org.iesalandalus.programacion.robot.modelo;

import org.w3c.dom.ls.LSOutput;

import javax.naming.OperationNotSupportedException;

public record Zona(int ancho, int alto) {
    public static final int ANCHO_MINIMO = 10;
    public static final int ANCHO_MAXIMO = 100;
    public static final int ALTO_MINIMO = 10;
    public static final int ALTO_MAXIMO = 100;


    public Zona() {
         this(ANCHO_MINIMO,ALTO_MINIMO);
    }

    public Zona {
        validarAncho(ancho);
        validarAlto(alto);
    }

    private void validarAncho(int ancho){

            if (ancho < ANCHO_MINIMO) {
                throw new IllegalArgumentException("Ancho no válido.");
            } else if (ancho > ANCHO_MAXIMO) {
                throw new IllegalArgumentException("Ancho no válido.");
            }
    }



    private void validarAlto(int alto) throws IllegalArgumentException{

            if (alto < ALTO_MINIMO){
                throw new IllegalArgumentException("Alto no válido.");
            } else if (alto > ALTO_MAXIMO) {
                throw new IllegalArgumentException("Alto no válido.");
            }
    }

    public Coordenada getCentro() {
        int centroX = ancho / 2;
        int centroY = alto / 2;
        return new Coordenada(centroX, centroY);

    }

    public boolean pertenece(Coordenada coordenada) {
        if (coordenada == null) {
            throw new NullPointerException("La coordenada no puede ser nula.");
        }
        return perteneceX(coordenada.x()) && perteneceY(coordenada.y());
    }


    public boolean perteneceX(int x) {
        return x >= 0 && x < ancho;
    }

    public boolean perteneceY(int y) {
        return y >= 0 && y < alto;
    }


}
