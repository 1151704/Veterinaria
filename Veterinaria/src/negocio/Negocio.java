/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dto.MascotaDTO;
import dto.PropietarioDTO;
import dto.TratamientoDTO;
import dto.TratamientoMascotaDTO;
import facade.INegocio;
import factory.Factory;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author OMAR MONTES
 */
public class Negocio implements INegocio {

    private final Factory factory;

    public Negocio() {
        this.factory = new Factory();
    }

    @Override
    public List<PropietarioDTO> propietarioListar() {

        try {
            return factory.getPropietario().readAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public PropietarioDTO propietarioInfo(int idPropietario) {
        try {
            return factory.getPropietario().read(idPropietario);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean propietarioRegistrar(String documento, String nombre, String direccion) {
        try {
            return factory.getPropietario().create(new PropietarioDTO(nombre, nombre, direccion));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean propietarioEditar(int idPropietario, String documento, String nombre, String direccion) {
        try {
            return factory.getPropietario().update(new PropietarioDTO(idPropietario, nombre, nombre, direccion));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean propietarioEliminar(int idPropietario) {

        try {
            return factory.getPropietario().delete(idPropietario);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<MascotaDTO> mascotaListar() {

        try {
            return factory.getMascota().readAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<MascotaDTO> mascotaListarPropietario(int idPropietario) {

        try {
            return factory.getMascota().readAllByOwner(idPropietario);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public MascotaDTO mascotaInfo(int idMascota) {

        try {
            return factory.getMascota().read(idMascota);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean mascotaRegistrar(int idPropietario, String nombre, String raza) {

        try {
            return factory.getMascota().create(new MascotaDTO(nombre, raza, new PropietarioDTO(idPropietario)));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean mascotaEditar(int idMascota, String nombre, String raza) {
        try {

            return factory.getMascota().update(new MascotaDTO(idMascota, nombre, raza, null));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean mascotaEliminar(int idMascota) {
        try {

            return factory.getMascota().delete(idMascota);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<TratamientoDTO> tratamientoListar() {

        try {

            return factory.getTratamiento().readAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TratamientoDTO tratamientoInfo(int idTratamiento) {

        try {

            return factory.getTratamiento().read(idTratamiento);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean tratamientoRegistrar(String nombre) {

        try {

            return factory.getTratamiento().create(new TratamientoDTO(0, nombre));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean tratamientoEditar(int idTratamiento, String nombre) {

        try {

            return factory.getTratamiento().update(new TratamientoDTO(idTratamiento, nombre));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean tratamientoEliminar(int idTratamiento) {

        try {

            return factory.getTratamiento().delete(idTratamiento);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<TratamientoMascotaDTO> tratamientoMascotaListar() {

        try {

            return factory.getTratamientoMascota().readAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<TratamientoMascotaDTO> tratamientoMascotaListar(int idMascota) {

        try {

            return factory.getTratamientoMascota().readByMascota(idMascota);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TratamientoMascotaDTO tratamientoMascotaInfo(int idTratamientoMascota) {
        try {

            return factory.getTratamientoMascota().read(idTratamientoMascota);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean tratamientoMascotaRegistrar(int idMascota, int idTratamiento, Date fecha) {

        try {

            return factory.getTratamientoMascota().create(new TratamientoMascotaDTO(new MascotaDTO(idMascota), new TratamientoDTO(idTratamiento), fecha));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean tratamientoMascotaEditar(int idTratamientoMascota, Date fecha) {
        try {

            return factory.getTratamientoMascota().update(new TratamientoMascotaDTO(idTratamientoMascota, null, null, fecha));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean tratamientoMascotaEliminar(int idTratamientoMascota) {
        try {

            return factory.getTratamientoMascota().delete(idTratamientoMascota);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
