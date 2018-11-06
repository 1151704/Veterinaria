/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dao.MascotaDAO;
import dao.PropietarioDAO;
import dao.TratamientoDAO;
import dao.TratamientoMascotaDAO;
import java.sql.SQLException;

/**
 *
 * @author OMAR MONTES
 */
public class Factory {

    public PropietarioDAO getPropietario() throws SQLException {
        return new PropietarioDAO();
    }

    public MascotaDAO getMascota() throws SQLException {
        return new MascotaDAO();
    }

    public TratamientoDAO getTratamiento() throws SQLException {
        return new TratamientoDAO();
    }

    public TratamientoMascotaDAO getTratamientoMascota() throws SQLException {
        return new TratamientoMascotaDAO();
    }

}
