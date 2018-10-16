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
public class MascotaDTO {

    private int id;
    private String nombre, raza;
    private PropietarioDTO propietario;

    public MascotaDTO() {
    }

    public MascotaDTO(int id) {
        this.id = id;
    }

    public MascotaDTO(String nombre, String raza, PropietarioDTO propietario) {
        this.nombre = nombre;
        this.raza = raza;
        this.propietario = propietario;
    }

    public MascotaDTO(int id, String nombre, String raza, PropietarioDTO propietario) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.propietario = propietario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public PropietarioDTO getPropietario() {
        return propietario;
    }

    public void setPropietario(PropietarioDTO propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", nombre=" + nombre + ", raza=" + raza + ", propietario=" + propietario + '}';
    }

}
