/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.interfaces.Crud;
import conexion.Conexion;
import dto.TratamientoDTO;
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
public class TratamientoDAO implements Crud<TratamientoDTO> {

    private static final String SQL_TABLE = "tratamiento",
            SQL_INSERT = "INSERT INTO " + SQL_TABLE + " (descripcion) VALUES (?)",
            SQL_UPDATE = "UPDATE " + SQL_TABLE + " SET descripcion=? WHERE id = ?",
            SQL_DELETE = "DELETE FROM " + SQL_TABLE + " WHERE id = ?",
            SQL_SELECT = "SELECT * FROM " + SQL_TABLE + " WHERE id = ?",
            SQL_SELECT_ALL = "SELECT * FROM " + SQL_TABLE,
            SQL_AUTO_INCREMENT = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = ? AND TABLE_NAME = '" + SQL_TABLE + "'";

    private static final Conexion CON = Conexion.getInstance();

    @Override
    public boolean create(TratamientoDTO o) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_INSERT);

            ps.setString(1, o.getDescripcion());
            if (ps.executeUpdate() > 0) {
                return (true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TratamientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (false);
    }

    @Override
    public TratamientoDTO read(Object key) {
        PreparedStatement ps;
        ResultSet rs;

        TratamientoDTO item = null;

        try {
            ps = CON.getCnn().prepareStatement(SQL_SELECT);

            rs = ps.executeQuery();

            while (rs.next()) {

                item = new TratamientoDTO(rs.getInt(1), rs.getString(2));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (item);
    }

    @Override
    public List<TratamientoDTO> readAll() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<TratamientoDTO> listado = new ArrayList();

        try {
            ps = CON.getCnn().prepareStatement(SQL_SELECT_ALL);

            rs = ps.executeQuery();

            TratamientoDTO item;

            while (rs.next()) {

                item = new TratamientoDTO(rs.getInt(1), rs.getString(2));

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
    public boolean update(TratamientoDTO o) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_UPDATE);

            ps.setString(1, o.getDescripcion());
            ps.setInt(2, o.getId());

            if (ps.executeUpdate() > 0) {
                return (true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TratamientoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TratamientoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TratamientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (id);
    }

}
