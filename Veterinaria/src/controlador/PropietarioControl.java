/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.PropietarioDAO;
import dto.PropietarioDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.PropietarioFormularioRegistrar;

/**
 *
 * @author OMAR MONTES
 */
public class PropietarioControl implements ActionListener {
    
    private PropietarioDAO modelo;
    private PropietarioFormularioRegistrar vista;

    public PropietarioControl(PropietarioDAO modelo) {
        this.modelo = modelo;
        this.vista = new PropietarioFormularioRegistrar();
        init();
    }

    private void init() {

        vista.setVisible(true);
        vista.btnRegistrar.addActionListener(this);

    }

    private void limpiarFormulario() {
        vista.txtDocumento.setText(null);
        vista.txtNombre.setText(null);
        vista.txtDireccion.setText(null);
    }

    public PropietarioFormularioRegistrar getVista() {
        return vista;
    }

    private void Propietario_registrar() {
        try {

            PropietarioDTO Propietario_nuevo = new PropietarioDTO(
                    vista.txtDocumento.getText(),
                    vista.txtNombre.getText(),
                    vista.txtDireccion.getText());

            if (!Propietario_registrar(Propietario_nuevo)) {
                limpiarFormulario();
            }
        } catch (Exception e) {
            mostrarMensaje(getVista(), "Datos incorrectos");
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        try {

            if (event.getActionCommand().contentEquals("action-Propietario_registrar")) {
                Propietario_registrar();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    boolean propietario_registrar(PropietarioDTO Propietario_nuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void mostrarMensaje(PropietarioFormularioRegistrar vista, String datos_incorrectos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean Propietario_registrar(PropietarioDTO Propietario_nuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
