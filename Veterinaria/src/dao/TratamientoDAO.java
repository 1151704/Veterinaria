/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.PropietarioDTO;
import dto.TratamientoDTO;
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
public class TratamientoDAO implements Crud<TratamientoDTO>{

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TratamientoDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(TratamientoDTO o) {
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
