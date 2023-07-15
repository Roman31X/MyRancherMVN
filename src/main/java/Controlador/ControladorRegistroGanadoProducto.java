package Controlador;

import DTO.ProductoGanadoDTO;
import JDBC.ProductoGanadoJDBC;
import VistaRegistro.RegistroProductoGanado;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

public class ControladorRegistroGanadoProducto implements ActionListener{
    private final RegistroProductoGanado agregarProducto;
    private final int id;

    public ControladorRegistroGanadoProducto(RegistroProductoGanado agregarProducto1, int id1) {
        this.agregarProducto = agregarProducto1;
        this.id = id1;
        
        agregarProducto.Registrar.addActionListener(this);
        agregarProducto.Limpiar.addActionListener(this);
        agregarProducto.Regresar.addActionListener(this);
        
    }
    
    public void Mostrar(){
        agregarProducto.setVisible(true);
    }
    
    public boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ProductoGanadoDTO productoNuevo;
        ProductoGanadoJDBC insertarProducto = new ProductoGanadoJDBC();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "REGISTRAR":
                String producto = agregarProducto.Producto.getText();
                String mes = agregarProducto.Mes.getSelectedItem().toString();
                String ganancia = agregarProducto.Ganancia.getText();
                
                String [] nuevoProducto = {producto,ganancia};
                List datos = Arrays.asList(nuevoProducto);
                
                if(datos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos");
                    return;
                }
                if(mes.equals("-Seleccion-")){
                    JOptionPane.showMessageDialog(null,"Debe seleccionar un MES");
                    return;
                }
                
                if(isNumeric(ganancia) == true){
                    
                }else{
                    JOptionPane.showMessageDialog(null,"En el campo GANANCIA solo esta permitio\n"+
                                                                   "ingresa numeros enteros[1] y decimales [1.5]");
                    return;
                }
                
                productoNuevo = new ProductoGanadoDTO(id,producto,mes,ganancia);
            
                try {
                    insertarProducto.insertar(productoNuevo);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                agregarProducto.setVisible(false);
                break;

            case "LIMPIAR":
                agregarProducto.Producto.setText("");
                agregarProducto.Mes.setSelectedIndex(0);
                agregarProducto.Ganancia.setText("");
                break;
            case "CERRAR":
                agregarProducto.setVisible(false);
                break;
        }
    }
}
