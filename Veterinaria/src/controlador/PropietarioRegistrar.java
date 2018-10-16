/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.PropietarioDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import vista.PropietarioFormularioRegistrar;

/**
 *
 * @author OMAR MONTES
 */
public class PropietarioRegistrar implements ActionListener {

    private PropietarioFormularioRegistrar vista;
    private PropietarioControl control;

    public PropietarioRegistrar(PropietarioControl control) {
        this.control = control;
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

            if (!control.propietario_registrar(Propietario_nuevo)) {
                limpiarFormulario();
            }
        } catch (Exception e) {
            control.mostrarMensaje(control.getVista(), "Datos incorrectos");
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

}
