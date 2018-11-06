/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dto.MascotaDTO;
import dto.PropietarioDTO;
import dto.TratamientoDTO;
import dto.TratamientoMascotaDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author OMAR MONTES
 */
public interface INegocio {

    public List<PropietarioDTO> propietarioListar();

    public PropietarioDTO propietarioInfo(int idPropietario);

    public boolean propietarioRegistrar(String documento, String nombre, String direccion);

    public boolean propietarioEditar(int idPropietario, String documento, String nombre, String direccion);

    public boolean propietarioEliminar(int idPropietario);

    public List<MascotaDTO> mascotaListar();

    public List<MascotaDTO> mascotaListarPropietario(int idPropietario);

    public MascotaDTO mascotaInfo(int idMascota);

    public boolean mascotaRegistrar(int idPropietario, String nombre, String raza);

    public boolean mascotaEditar(int idMascota, String nombre, String raza);

    public boolean mascotaEliminar(int idMascota);

    public List<TratamientoDTO> tratamientoListar();

    public TratamientoDTO tratamientoInfo(int idTratamiento);

    public boolean tratamientoRegistrar(String nombre);

    public boolean tratamientoEditar(int idTratamiento, String nombre);

    public boolean tratamientoEliminar(int idTratamiento);

    public List<TratamientoMascotaDTO> tratamientoMascotaListar();

    public List<TratamientoMascotaDTO> tratamientoMascotaListar(int idMascota);

    public TratamientoMascotaDTO tratamientoMascotaInfo(int idTratamientoMascota);

    public boolean tratamientoMascotaRegistrar(int idMascota, int idTratamiento, Date fecha);

    public boolean tratamientoMascotaEditar(int idTratamientoMascota, Date fecha);

    public boolean tratamientoMascotaEliminar(int idTratamientoMascota);

}
