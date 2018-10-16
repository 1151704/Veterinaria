/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author OMAR MONTES
 */
public class PropietarioDTO {

    private int id;
    private String cedula, nombre, direccion;

    public PropietarioDTO(int id, String cedula, String nombre, String direccion) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public PropietarioDTO(int id) {
        this.id = id;
    }

    public PropietarioDTO() {
    }

    public PropietarioDTO(String cedula, String nombre, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }

}
