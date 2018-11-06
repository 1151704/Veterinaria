/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

/**
 *
 * @author OMAR MONTES
 */
public class Servicios {

    private static Servicios instance;

    private Servicio servicio;

    private Servicios() {
        servicio = new Servicio();
    }

    public static Servicios getInstance() {

        if (instance == null) {
            instance = new Servicios();
        }

        return instance;
    }

    public Servicio getServicio() {
        return servicio;
    }

}
