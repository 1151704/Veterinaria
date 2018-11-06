/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.interfaces.Crud;
import conexion.Conexion;
import dto.MascotaDTO;
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
public class MascotaDAO implements Crud<MascotaDTO> {
    
    private static final String SQL_TABLE = "mascota",
            SQL_INSERT = "INSERT INTO " + SQL_TABLE + " (nombre, raza, id_propietario) VALUES (?,?,?)",
            SQL_UPDATE = "UPDATE " + SQL_TABLE + " SET nombre=?, raza=? WHERE id = ?",
            SQL_DELETE = "DELETE FROM " + SQL_TABLE + " WHERE id = ?",
            SQL_SELECT = "SELECT * FROM " + SQL_TABLE + " m JOIN propietario p ON p.id = m.id_propietario WHERE m.id = ? ORDER BY m.raza, m.nombre",
            SQL_SELECT_OWNER = "SELECT * FROM " + SQL_TABLE + " m JOIN propietario p ON p.id = m.id_propietario WHERE m.id_propietario = ? ORDER BY m.raza, m.nombre ",
            SQL_SELECT_ALL = "SELECT * FROM " + SQL_TABLE + " m JOIN propietario p ON p.id = m.id_propietario ORDER BY m.raza, m.nombre",
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
        PreparedStatement ps;
        ResultSet rs;
        MascotaDTO item = null;
        
        try {
            ps = CON.getCnn().prepareStatement(SQL_SELECT);
            
            ps.setInt(1, (Integer) key);
            
            rs = ps.executeQuery();
            
            PropietarioDTO propietario;
            
            while (rs.next()) {
                
                propietario = new PropietarioDTO(rs.getInt("p.id"), rs.getString("p.cedula"), rs.getString("p.nombre"), rs.getString("p.direccion"));
                item = new MascotaDTO(rs.getInt("m.id"), rs.getString("m.nombre"), rs.getString("m.raza"), propietario);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (item);
    }
    
    @Override
    public List<MascotaDTO> readAll() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<MascotaDTO> listado = new ArrayList();
        
        try {
            ps = CON.getCnn().prepareStatement(SQL_SELECT_ALL);
            
            rs = ps.executeQuery();
            
            PropietarioDTO propietario;
            MascotaDTO item;
            
            while (rs.next()) {
                
                propietario = new PropietarioDTO(rs.getInt("p.id"), rs.getString("p.cedula"), rs.getString("p.nombre"), rs.getString("p.direccion"));
                item = new MascotaDTO(rs.getInt("m.id"), rs.getString("m.nombre"), rs.getString("m.raza"), propietario);
                
                listado.add(item);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (listado);
    }
    
    public List<MascotaDTO> readAllByOwner(Object key) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<MascotaDTO> listado = new ArrayList();
        
        try {
            ps = CON.getCnn().prepareStatement(SQL_SELECT_OWNER);
            
            if (key instanceof Integer) {
                ps.setInt(1, (Integer) key);
            }
            if (key instanceof PropietarioDTO) {
                ps.setInt(1, ((PropietarioDTO) key).getId());
            }
            
            rs = ps.executeQuery();
            
            PropietarioDTO propietario;
            MascotaDTO mascota;
            
            while (rs.next()) {
                
                propietario = new PropietarioDTO(rs.getInt("p.id"), rs.getString("p.cedula"), rs.getString("p.nombre"), rs.getString("p.direccion"));
                mascota = new MascotaDTO(rs.getInt("m.id"), rs.getString("m.nombre"), rs.getString("m.raza"), propietario);
                
                listado.add(mascota);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (listado);
    }
    
    @Override
    public boolean update(MascotaDTO o) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_UPDATE);
            
            ps.setString(1, o.getNombre());
            ps.setString(2, o.getRaza());
            ps.setInt(3, o.getId());
            
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
