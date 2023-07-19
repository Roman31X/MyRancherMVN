package Controlador;

import DTO.AlmacenAlimentoDTO;
import JDBC.AlmacenAlimentoJDBC;
import VistaAlmacen.VistaEliminarAlimento;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControladorEliminarAlimento implements ActionListener{
    private final VistaEliminarAlimento eliminar;

    AlmacenAlimentoDTO alimentoEliminado;
    AlmacenAlimentoJDBC eliminarAlimento;
    
    public ControladorEliminarAlimento(VistaEliminarAlimento eliminar3) {
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        eliminarAlimento = new AlmacenAlimentoJDBC();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "ELIMINAR":
                String id = eliminar.ListaID.getSelectedItem().toString();
                
                if(isNumeric(id) == true){
                    int idAlimento = Integer.parseInt(id);
                    alimentoEliminado = new AlmacenAlimentoDTO(idAlimento);
                    try {
                        eliminarAlimento.eliminar(alimentoEliminado);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar el numero\n"+
                                                                   "   ID ALMACEN ALIMENTO\n"+
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
