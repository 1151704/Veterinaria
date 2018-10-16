/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import dao.PropietarioDAO;
import dto.PropietarioDTO;

/**
 *
 * @author OMAR MONTES
 */
public class Principal {
    
    public static void main(String[] args) {
        
        PropietarioDAO propietario = new PropietarioDAO();
        
        propietario.create(new PropietarioDTO("123456", "omar", "cmacmmac"));
        propietario.create(new PropietarioDTO("123457", "juan", "1i2390a"));
        propietario.create(new PropietarioDTO("123458", "alvaro", "cnawdij921"));
        
        
        
    }
    
}
