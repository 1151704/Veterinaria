/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author OMAR MONTES
 */
public class TratamientoMascotaDTO {

    private int id;
    private MascotaDTO mascota;
    private TratamientoDTO tratamiento;
    private Date fecha;

    public TratamientoMascotaDTO() {
    }

    public TratamientoMascotaDTO(int id) {
        this.id = id;
    }

    public TratamientoMascotaDTO(MascotaDTO mascota, TratamientoDTO tratamiento, Date fecha) {
        this.mascota = mascota;
        this.tratamiento = tratamiento;
        this.fecha = fecha;
    }

    public TratamientoMascotaDTO(int id, MascotaDTO mascota, TratamientoDTO tratamiento, Date fecha) {
        this.id = id;
        this.mascota = mascota;
        this.tratamiento = tratamiento;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MascotaDTO getMascota() {
        return mascota;
    }

    public void setMascota(MascotaDTO mascota) {
        this.mascota = mascota;
    }

    public TratamientoDTO getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(TratamientoDTO tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
