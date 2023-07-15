package Controlador;

import DTO.CronogramaDTO;
import JDBC.CronogramaJDBC;
import VistaTerreno.VistaEliminarCronograma;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControladorEliminarCronograma implements ActionListener{
    private final VistaEliminarCronograma eliminarCronograma;
    
    private CronogramaDTO idElimar;
    private CronogramaJDBC eliminar;

    public ControladorEliminarCronograma(VistaEliminarCronograma eliminarCronograma3) {
        this.eliminarCronograma = eliminarCronograma3;
        
        eliminarCronograma.Eliminar.addActionListener(this);
        eliminarCronograma.Regresar.addActionListener(this);
    }
    
    public void Mostrar(){
        eliminarCronograma.setVisible(true);
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
        
        eliminar = new CronogramaJDBC();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "ELIMINAR":
                
                String id = eliminarCronograma.ListaID.getSelectedItem().toString();
                
                if(isNumeric(id) == true){
                    int numero = Integer.parseInt(eliminarCronograma.ListaID.getSelectedItem().toString());
                    idElimar = new CronogramaDTO(numero);
                    try {
                        eliminar.eliminar(idElimar);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar el numero\n"+
                                                                   " ID CRONOGRAMA a eliminar");
                    return;
                }
                eliminarCronograma.setVisible(false);
                break;
            case "REGRESAR":
                eliminarCronograma.setVisible(false);
                break;
        }
    }
    
}
