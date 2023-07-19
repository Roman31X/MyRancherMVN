package Controlador;

import DTO.AlmacenForrajeDTO;
import JDBC.AlmacenForrajeJDBC;
import VistaAlmacen.VistaEliminarForraje;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControladorEliminarForraje implements ActionListener{
    private final VistaEliminarForraje eliminar;
    
    private AlmacenForrajeDTO forrajeEliminado;
    private AlmacenForrajeJDBC eliminarForraje;

    public ControladorEliminarForraje(VistaEliminarForraje eliminar) {
        this.eliminar = eliminar;
        
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        eliminarForraje = new AlmacenForrajeJDBC();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "ELIMINAR":
                String id = eliminar.ListaID.getSelectedItem().toString();
                
                if(isNumeric(id) == true){
                    int idTerreno = Integer.parseInt(id);
                    forrajeEliminado = new AlmacenForrajeDTO(idTerreno);
                    try {
                        eliminarForraje.eliminar(forrajeEliminado);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar el numero\n"+
                                                                   "   ID ALMACEN FORRAJE\n"+
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
