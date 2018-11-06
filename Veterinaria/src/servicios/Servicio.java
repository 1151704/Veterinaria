/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dto.MascotaDTO;
import dto.PropietarioDTO;
import dto.TratamientoDTO;
import dto.TratamientoMascotaDTO;
import facade.INegocio;
import java.util.Date;
import java.util.List;
import negocio.Negocio;

/**
 *
 * @author OMAR MONTES
 */
public class Servicio {

    private final INegocio negocio;

    public Servicio() {
        this.negocio = new Negocio();
    }

    public List<PropietarioDTO> propietarioListar() {
        return this.negocio.propietarioListar();
    }

    public PropietarioDTO propietarioInfo(int idPropietario) {
        return this.negocio.propietarioInfo(idPropietario);
    }

    public boolean propietarioRegistrar(String documento, String nombre, String direccion) {
        return this.negocio.propietarioRegistrar(documento, nombre, direccion);
    }

    public boolean propietarioEditar(int idPropietario, String documento, String nombre, String direccion) {
        return this.negocio.propietarioEditar(idPropietario, documento, nombre, direccion);
    }

    public boolean propietarioEliminar(int idPropietario) {
        return this.negocio.propietarioEliminar(idPropietario);
    }

    public List<MascotaDTO> mascotaListar() {
        return this.negocio.mascotaListar();
    }

    public List<MascotaDTO> mascotaListarPropietario(int idPropietario) {
        return this.negocio.mascotaListarPropietario(idPropietario);
    }

    public MascotaDTO mascotaInfo(int idMascota) {
        return this.negocio.mascotaInfo(idMascota);
    }

    public boolean mascotaRegistrar(int idPropietario, String nombre, String raza) {
        return this.negocio.mascotaRegistrar(idPropietario, nombre, raza);
    }

    public boolean mascotaEditar(int idMascota, String nombre, String raza) {
        return this.negocio.mascotaEditar(idMascota, nombre, raza);
    }

    public boolean mascotaEliminar(int idMascota) {
        return this.negocio.mascotaEliminar(idMascota);
    }

    public List<TratamientoDTO> tratamientoListar() {
        return this.negocio.tratamientoListar();
    }

    public TratamientoDTO tratamientoInfo(int idTratamiento) {
        return this.negocio.tratamientoInfo(idTratamiento);
    }

    public boolean tratamientoRegistrar(String nombre) {
        return this.negocio.tratamientoRegistrar(nombre);
    }

    public boolean tratamientoEditar(int idTratamiento, String nombre) {
        return this.negocio.tratamientoEditar(idTratamiento, nombre);
    }

    public boolean tratamientoEliminar(int idTratamiento) {
        return this.negocio.tratamientoEliminar(idTratamiento);
    }

    public List<TratamientoMascotaDTO> tratamientoMascotaListar() {
        return this.negocio.tratamientoMascotaListar();
    }

    public List<TratamientoMascotaDTO> tratamientoMascotaListar(int idMascota) {
        return this.negocio.tratamientoMascotaListar(idMascota);
    }

    public TratamientoMascotaDTO tratamientoMascotaInfo(int idTratamientoMascota) {
        return this.negocio.tratamientoMascotaInfo(idTratamientoMascota);
    }

    public boolean tratamientoMascotaRegistrar(int idMascota, int idTratamiento, Date fecha) {
        return this.negocio.tratamientoMascotaRegistrar(idMascota, idTratamiento, fecha);
    }

    public boolean tratamientoMascotaEditar(int idTratamientoMascota, Date fecha) {
        return this.negocio.tratamientoMascotaEditar(idTratamientoMascota, fecha);
    }

    public boolean tratamientoMascotaEliminar(int idTratamientoMascota) {
        return this.negocio.tratamientoMascotaEliminar(idTratamientoMascota);
    }

}
