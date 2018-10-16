/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.MascotaDTO;
import interfaces.Crud;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OMAR MONTES
 */
public class MascotaDAO implements Crud<MascotaDTO> {

    private static final String SQL_TABLE = "mascota",
            SQL_INSERT = "INSERT INTO " + SQL_TABLE + " (nombre, raza, id_propietario) VALUES (?,?,?)",
            SQL_UPDATE = "UPDATE " + SQL_TABLE + " SET nombre=?, raza=? WHERE id = ?",
            SQL_DELETE = "DELETE FROM " + SQL_TABLE + " WHERE id = ?",
            SQL_SELECT = "SELECT * FROM " + SQL_TABLE + " WHERE id = ?",
            SQL_SELECT_ALL = "SELECT * FROM " + SQL_TABLE,
            SQL_AUTO_INCREMENT = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = ? AND TABLE_NAME = '" + SQL_TABLE + "'";

    private static final Conexion CON = Conexion.getInstance();

    @Override
    public boolean create(MascotaDTO o) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_INSERT);

            ps.setString(1, o.getNombre());
            ps.setString(2, o.getRaza());
            if (o.getPropietario() != null) {
                ps.setInt(3, o.getPropietario().getId());
            } else {
                ps.setString(3, null);
            }
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
    public MascotaDTO read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MascotaDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(MascotaDTO o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int auto_increment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
