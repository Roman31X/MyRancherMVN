package Controlador;

import DTO.GanadoDTO;
import JDBC.GanadoJDBC;
import VistaGanado.VistaEliminarGanado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControladorEliminarGanado implements ActionListener{
    private final VistaEliminarGanado eliminar;
    
    GanadoDTO GanadoEliminado;
    GanadoJDBC eliminarGanado;

    public ControladorEliminarGanado(VistaEliminarGanado eliminar2) {
        this.eliminar = eliminar2;
        
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
        
        eliminarGanado = new GanadoJDBC();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "ELIMINAR":
                String id = eliminar.ListaID.getSelectedItem().toString();
                
                if(isNumeric(id) == true){
                    int idTerreno = Integer.parseInt(id);
                    GanadoEliminado = new GanadoDTO(idTerreno);
                    try {
                        eliminarGanado.eliminar(GanadoEliminado);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar el numero\n"+
                                                                   "   ID GANADO a eliminar");
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
