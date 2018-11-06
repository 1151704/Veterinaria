/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.interfaces.Crud;
import conexion.Conexion;
import dto.MascotaDTO;
import dto.TratamientoDTO;
import dto.TratamientoMascotaDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OMAR MONTES
 */
public class TratamientoMascotaDAO implements Crud<TratamientoMascotaDTO> {

    private static final String SQL_TABLE = "tratxmascota",
            SQL_INSERT = "INSERT INTO " + SQL_TABLE + " (id_mascota, id_tratamiento) VALUES (?)",
            SQL_UPDATE = "UPDATE " + SQL_TABLE + " SET id_mascota=?, id_tratamiento WHERE id = ?",
            SQL_DELETE = "DELETE FROM " + SQL_TABLE + " WHERE id = ?",
            SQL_SELECT = "SELECT * FROM " + SQL_TABLE + " tm JOIN mascota m ON m.id = tm.id_mascota JOIN tratamiento t ON t.id = tm.id_tratamiento WHERE tm.id = ?",
            SQL_SELECT_ALL = "SELECT * FROM " + SQL_TABLE + " tm JOIN mascota m ON m.id = tm.id_mascota JOIN tratamiento t ON t.id_tratamiento = tm.id ",
            SQL_SELECT_ALL_BY_MASCOTA = "SELECT * FROM " + SQL_TABLE + " tm JOIN mascota m ON m.id = tm.id_mascota JOIN tratamiento t ON t.id_tratamiento = tm.id WHERE td.id_mascota = ? ",
            SQL_AUTO_INCREMENT = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = ? AND TABLE_NAME = '" + SQL_TABLE + "'";

    private static final Conexion CON = Conexion.getInstance();

    @Override
    public boolean create(TratamientoMascotaDTO o) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_INSERT);

            ps.setInt(1, o.getMascota().getId());
            ps.setInt(2, o.getTratamiento().getId());
            if (ps.executeUpdate() > 0) {
                return (true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TratamientoMascotaDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (false);
    }

    @Override
    public TratamientoMascotaDTO read(Object key) {
        PreparedStatement ps;
        ResultSet rs;
        TratamientoMascotaDTO item = null;

        try {
            ps = CON.getCnn().prepareStatement(SQL_SELECT);

            rs = ps.executeQuery();

            TratamientoDTO tratamiento;
            MascotaDTO mascota;

            while (rs.next()) {

                tratamiento = new TratamientoDTO(rs.getInt("t.id"), "t.descripcion");
                mascota = new MascotaDTO(rs.getInt("m.id"), rs.getString("m.nombre"), rs.getString("m.raza"), null);

                item = new TratamientoMascotaDTO(rs.getInt("tm.id"), mascota, tratamiento, rs.getDate("tm.fecha"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (item);
    }

    @Override
    public List<TratamientoMascotaDTO> readAll() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<TratamientoMascotaDTO> listado = new ArrayList();

        try {
            ps = CON.getCnn().prepareStatement(SQL_SELECT_ALL);

            rs = ps.executeQuery();

            TratamientoDTO tratamiento;
            MascotaDTO mascota;
            TratamientoMascotaDTO item;

            while (rs.next()) {

                tratamiento = new TratamientoDTO(rs.getInt("t.id"), "t.descripcion");
                mascota = new MascotaDTO(rs.getInt("m.id"), rs.getString("m.nombre"), rs.getString("m.raza"), null);

                item = new TratamientoMascotaDTO(rs.getInt("tm.id"), mascota, tratamiento, rs.getDate("tm.fecha"));

                listado.add(item);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (listado);
    }
    
    public List<TratamientoMascotaDTO> readByMascota(int idMascota) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<TratamientoMascotaDTO> listado = new ArrayList();

        try {
            ps = CON.getCnn().prepareStatement(SQL_SELECT_ALL_BY_MASCOTA);

            ps.setInt(1, idMascota);
            
            rs = ps.executeQuery();

            TratamientoDTO tratamiento;
            MascotaDTO mascota;
            TratamientoMascotaDTO item;

            while (rs.next()) {

                tratamiento = new TratamientoDTO(rs.getInt("t.id"), "t.descripcion");
                mascota = new MascotaDTO(rs.getInt("m.id"), rs.getString("m.nombre"), rs.getString("m.raza"), null);

                item = new TratamientoMascotaDTO(rs.getInt("tm.id"), mascota, tratamiento, rs.getDate("tm.fecha"));

                listado.add(item);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (listado);
    }

    @Override
    public boolean update(TratamientoMascotaDTO o) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_UPDATE);

            ps.setDate(1, new java.sql.Date(o.getFecha().getTime()));
            ps.setInt(2, o.getId());

            if (ps.executeUpdate() > 0) {
                return (true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (false);
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_DELETE);

            ps.setInt(1, (Integer) key);

            if (ps.executeUpdate() > 0) {
                return (true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (false);
    }

    @Override
    public int auto_increment() {
        PreparedStatement ps;
        ResultSet rs;
        int id = 0;
        try {
            ps = CON.getCnn().prepareStatement(SQL_AUTO_INCREMENT);

            ps.setString(1, Conexion.getDb());

            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (id);
    }

}
