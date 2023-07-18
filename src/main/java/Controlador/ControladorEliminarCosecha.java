package Controlador;

import DTO.AlmacenCosechaDTO;
import JDBC.AlmacenCosechaJDBC;
import VistaAlmacen.VistaEliminarCosecha;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControladorEliminarCosecha implements ActionListener{
    private final VistaEliminarCosecha eliminar;
    
    private AlmacenCosechaDTO cosechaEliminado;
    private AlmacenCosechaJDBC eliminarCosecha;
    
    public ControladorEliminarCosecha(VistaEliminarCosecha eliminar3) {
        this.eliminar = eliminar3;
        
        eliminar.Eliminar.addActionListener(this);
        eliminar.Regresar.addActionListener(this);
        
    }
    
    public void Mostrar(){
        eliminar.setVisible(true);
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
    
    //Accion
    @Override
    public void actionPerformed(ActionEvent e) {
        
        eliminarCosecha = new AlmacenCosechaJDBC();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "ELIMINAR":
                String id = eliminar.ListaID.getSelectedItem().toString();
                
                if(isNumeric(id) == true){
                    int idCosecha = Integer.parseInt(id);
                    cosechaEliminado = new AlmacenCosechaDTO(idCosecha);
                    try {
                        eliminarCosecha.eliminar(cosechaEliminado);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar el numero\n"+
                                                                   "   ID ALMACEN COSECHA\n"+
                                                                   "        a eliminar");
                    return;
                }
                eliminar.setVisible(false);
                break;
            case "REGRESAR":
                eliminar.setVisible(false);
                break;
        }
    }
}
