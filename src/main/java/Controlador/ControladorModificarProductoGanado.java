package Controlador;

import DTO.ProductoGanadoDTO;
import JDBC.ProductoGanadoJDBC;
import VistaGanado.VistaModificarProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControladorModificarProductoGanado implements ActionListener{
    private VistaModificarProducto controlModificar;
    private int id;
    private List<ProductoGanadoDTO> listaProducto;

    private String selecionID;
    private int seleccionId;
        
    public ControladorModificarProductoGanado(VistaModificarProducto controlModificar2, int id2, List<ProductoGanadoDTO> listaProducto2) {
        this.controlModificar = controlModificar2;
        this.id = id2;
        this.listaProducto = listaProducto2;
        
        controlModificar.IDProducto.addActionListener(this);
        controlModificar.Modificar.addActionListener(this);
        controlModificar.Limpiar.addActionListener(this);
        controlModificar.Regresar.addActionListener(this);
    }
    
    public void Mostrar(){
        controlModificar.setVisible(true);
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
    public boolean Entero(String cadena) {

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
        
        ProductoGanadoDTO productoActualizado;
        ProductoGanadoJDBC actualizarProducto = new ProductoGanadoJDBC();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "comboBoxChanged":
                selecionID = controlModificar.IDProducto.getSelectedItem().toString();
                if(isNumeric(selecionID) == true){
                    seleccionId = Integer.parseInt(selecionID);
                    for (ProductoGanadoDTO lista : listaProducto) {
                        if(lista.getIdproduccionGanado() == seleccionId){
                            controlModificar.Producto.setText(lista.getProducto());
                            switch(lista.getMes()){
                                case "Enero":controlModificar.Mes.setSelectedIndex(1);break;
                                case "Febrero":controlModificar.Mes.setSelectedIndex(2);break;
                                case "Marzo":controlModificar.Mes.setSelectedIndex(3);break;
                                case "Abril":controlModificar.Mes.setSelectedIndex(4);break;
                                case "Mayo":controlModificar.Mes.setSelectedIndex(5);break;
                                case "Junio":controlModificar.Mes.setSelectedIndex(6);break;
                                case "Julio":controlModificar.Mes.setSelectedIndex(7);break;
                                case "Agosto":controlModificar.Mes.setSelectedIndex(8);break;
                                case "Setiembre":controlModificar.Mes.setSelectedIndex(9);break;
                                case "Octubre":controlModificar.Mes.setSelectedIndex(10);break;
                                case "Noviembre":controlModificar.Mes.setSelectedIndex(11);break;
                                case "Diciembre":controlModificar.Mes.setSelectedIndex(12);break;
                            }
                            controlModificar.Ganancia.setText(lista.getGanancia());
                            break;
                        }
                    }
                }else{
                    controlModificar.Producto.setText("");
                    controlModificar.Mes.setSelectedIndex(0);
                    controlModificar.Ganancia.setText("");
                }
                break;
            case "MODIFICAR":
                String producto = controlModificar.Producto.getText();
                String mes = controlModificar.Mes.getSelectedItem().toString();
                String ganancia = controlModificar.Ganancia.getText();
                
                String [] actual = {producto,ganancia};
                List datos = Arrays.asList(actual);
                
                if(datos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos");
                    return;
                }
                
                if(Entero(selecionID) == true){
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar un\n"+
                                                                   "   ID TERRENO");
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
                productoActualizado = new ProductoGanadoDTO(seleccionId,id,producto,mes,ganancia);
                try {
                    actualizarProducto.actualizar(productoActualizado);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                controlModificar.setVisible(false);
                break;

            case "LIMPIAR":
                controlModificar.IDProducto.setSelectedIndex(0);
                controlModificar.Producto.setText("");
                controlModificar.Mes.setSelectedIndex(0);
                controlModificar.Ganancia.setText("");
                break;
            case "CERRAR":
                controlModificar.setVisible(false);
                break;
        }
    }
    
    
}
