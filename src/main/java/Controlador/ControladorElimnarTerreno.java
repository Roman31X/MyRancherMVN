package Controlador;

import DTO.TerrenoDTO;
import JDBC.TerrenoJDBC;
import VistaTerreno.VistaEliminarTerreno;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControladorElimnarTerreno implements ActionListener{
    private final VistaEliminarTerreno eliminarTerreno;
    
    private TerrenoDTO terrenoEliminado;
    private TerrenoJDBC insertarTerreno;

    public ControladorElimnarTerreno(VistaEliminarTerreno eliminarTerreno2) {
        this.eliminarTerreno = eliminarTerreno2;
        
        eliminarTerreno.Eliminar.addActionListener(this);
        eliminarTerreno.Regresar.addActionListener(this);
    }

    public void Mostrar(){
        eliminarTerreno.setVisible(true);
        
    }
    
    //Verifica si es Entero
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
        insertarTerreno = new TerrenoJDBC();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "ELIMINAR":
                String id = eliminarTerreno.ListaID.getSelectedItem().toString();
                
                if(isNumeric(id) == true){
                    int idTerreno = Integer.parseInt(id);
                    terrenoEliminado = new TerrenoDTO(idTerreno);
                    try {
                        insertarTerreno.eliminar(terrenoEliminado);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar el numero\n"+
                                                                   "   ID TERRENO a eliminar");
                    return;
                }
                eliminarTerreno.setVisible(false);
                break;
            case "REGRESAR":
                eliminarTerreno.setVisible(false);
                break;
        }
    }
}
