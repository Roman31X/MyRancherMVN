package Controlador;

import DTO.ProduccionDTO;
import JDBC.ProduccionJDBC;
import VistaTerreno.VistaEliminarProduccion;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControladorEliminarProduccion implements ActionListener{
    VistaEliminarProduccion vistaEliminar;
    
    ProduccionDTO eliminar;
    ProduccionJDBC accionEliminar;

    public ControladorEliminarProduccion(VistaEliminarProduccion vistaEliminar1) {
        this.vistaEliminar = vistaEliminar1;
        
        vistaEliminar.Eliminar.addActionListener(this);
        vistaEliminar.Regresar.addActionListener(this);
    }
    
    public void Mostrar(){
        vistaEliminar.setVisible(true);
    }

    public boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        accionEliminar = new ProduccionJDBC();
        switch(accion){
            case "ELIMINAR":
                String id = vistaEliminar.ListaID.getSelectedItem().toString();
                if(isNumeric(id) == true){
                    int idTerreno = Integer.parseInt(id);
                    eliminar = new ProduccionDTO(idTerreno);
                    try {
                        accionEliminar.eliminar(eliminar);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar el numero\n"+
                                                                   " IDPRODUCCION a eliminar");
                    return;
                }
                vistaEliminar.setVisible(false);
                break;
            case "REGRESAR":
                vistaEliminar.setVisible(false);
                break;
        }
    }
    
}
