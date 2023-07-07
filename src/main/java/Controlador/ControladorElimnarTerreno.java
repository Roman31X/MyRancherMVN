package Controlador;

import DTO.TerrenoDTO;
import JDBC.TerrenoJDBC;
import VistaTerreno.VistaEliminarTerreno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorElimnarTerreno implements ActionListener{
    private final VistaEliminarTerreno eliminarTerreno;
    private final List<Integer> idTerreno;

    public ControladorElimnarTerreno(VistaEliminarTerreno eliminarTerreno2, List<Integer> idTerreno2) {
        this.eliminarTerreno = eliminarTerreno2;
        this.idTerreno = idTerreno2;
        
        eliminarTerreno.Eliminar.addActionListener(this);
        eliminarTerreno.Regresar.addActionListener(this);
    }

    public void Mostrar(){
        eliminarTerreno.setVisible(true);
        
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
        TerrenoDTO terrenoEliminado;
        TerrenoJDBC insertarTerreno = new TerrenoJDBC();
        
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
                    JOptionPane.showMessageDialog(null,"Debe seleccionar el numero de ID\n"+
                                                                   " de la tabla de sus Terrenos");
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
