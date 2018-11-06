/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.interfaces.Crud;
import conexion.Conexion;
import dto.PropietarioDTO;
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
public class PropietarioDAO implements Crud<PropietarioDTO> {

    private static final String SQL_TABLE = "propietario",
            SQL_INSERT = "INSERT INTO " + SQL_TABLE + " (cedula, nombre, direccion) VALUES (?,?,?)",
            SQL_UPDATE = "UPDATE " + SQL_TABLE + " SET nombre=?, direccion=? WHERE id = ?",
            SQL_DELETE = "DELETE FROM " + SQL_TABLE + " WHERE id = ?",
            SQL_SELECT = "SELECT * FROM " + SQL_TABLE + " WHERE id = ?",
            SQL_SELECT_ALL = "SELECT * FROM " + SQL_TABLE,
            SQL_AUTO_INCREMENT = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = ? AND TABLE_NAME = '" + SQL_TABLE + "'";

    private static final Conexion CON = Conexion.getInstance();

    @Override
    public boolean create(PropietarioDTO o) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_INSERT);

            ps.setString(1, o.getCedula());
            ps.setString(2, o.getNombre());
            ps.setString(3, o.getDireccion());
            if (ps.executeUpdate() > 0) {
                return (true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropietarioDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (false);
    }

    @Override
    public PropietarioDTO read(Object key) {

        PreparedStatement ps;
        ResultSet rs;
        PropietarioDTO item = null;

        try {
            ps = CON.getCnn().prepareStatement(SQL_SELECT);

            rs = ps.executeQuery();

            while (rs.next()) {

                item = new PropietarioDTO(rs.getInt("id"), rs.getString("cedula"), rs.getString("nombre"), rs.getString("direccion"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PropietarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (item);
    }

    @Override
    public List<PropietarioDTO> readAll() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<PropietarioDTO> listado = new ArrayList();

        try {
            ps = CON.getCnn().prepareStatement(SQL_SELECT_ALL);

            rs = ps.executeQuery();

            PropietarioDTO item;

            while (rs.next()) {

                item = new PropietarioDTO(rs.getInt("id"), rs.getString("cedula"), rs.getString("nombre"), rs.getString("direccion"));

                listado.add(item);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PropietarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (listado);
    }

    @Override
    public boolean update(PropietarioDTO o) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_UPDATE);

            ps.setString(1, o.getNombre());
            ps.setString(2, o.getDireccion());
            ps.setInt(3, o.getId());

            if (ps.executeUpdate() > 0) {
                return (true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropietarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PropietarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PropietarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (id);
    }

}
