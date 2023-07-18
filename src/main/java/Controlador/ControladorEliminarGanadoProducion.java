package Controlador;

import DTO.ProductoGanadoDTO;
import JDBC.ProductoGanadoJDBC;
import VistaGanado.VistaEliminarProducto;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControladorEliminarGanadoProducion implements ActionListener{
    private final VistaEliminarProducto eliminar;

    private ProductoGanadoDTO ProductoEliminado;
    private ProductoGanadoJDBC eliminarProducto;
    
    public ControladorEliminarGanadoProducion(VistaEliminarProducto eliminar3) {
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

    //Acciones
    @Override
    public void actionPerformed(ActionEvent e) {
        
        eliminarProducto = new ProductoGanadoJDBC();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "ELIMINAR":
                String id = eliminar.ListaID.getSelectedItem().toString();
                
                if(isNumeric(id) == true){
                    int idGanado = Integer.parseInt(id);
                    ProductoEliminado = new ProductoGanadoDTO(idGanado);
                    try {
                        eliminarProducto.eliminar(ProductoEliminado);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar el numero\n"+
                                                                   "   ID PRODUCTO a eliminar");
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
    

