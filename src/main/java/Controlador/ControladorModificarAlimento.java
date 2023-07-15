package Controlador;

import DTO.AlmacenAlimentoDTO;
import JDBC.AlmacenAlimentoJDBC;
import Modelo.CalculoSacos;
import VistaAlmacen.VistaModificarAlimento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorModificarAlimento implements ActionListener{
    private final VistaModificarAlimento modificar;
    private int id;
    private List<AlmacenAlimentoDTO> listaAlmacen;
    
    String hoy;
    String peso;
    String cantidad;
    String seleccion;
    int datoId;
    
    public ControladorModificarAlimento(VistaModificarAlimento modificar2, int id2, List<AlmacenAlimentoDTO> listaAlmacen2) {
        this.modificar = modificar2;
        this.id = id2;
        this.listaAlmacen = listaAlmacen2;
        
        modificar.listaID.addActionListener(this);
        modificar.Calcular.addActionListener(this);
        modificar.Modificar.addActionListener(this);
        modificar.Limpiar.addActionListener(this);
        modificar.Cerrar.addActionListener(this);
    }

    public void Mostrar(){
        modificar.setVisible(true);
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
    public boolean Decimal(String cadena) {

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
        
        AlmacenAlimentoDTO alimentoModificado;
        AlmacenAlimentoJDBC modificarAlimento = new AlmacenAlimentoJDBC();
        
        Date fechaHoy = new Date();
        SimpleDateFormat nuevaFecha = new SimpleDateFormat("dd/MM/yyyy");
        hoy = nuevaFecha.format(fechaHoy);
        modificar.fecha.setText(hoy);
        CalculoSacos nuevoCalculo;
        
        String accion = e.getActionCommand();
        System.out.println("accion = " + accion);
        switch(accion){
            case "comboBoxChanged":
                seleccion = modificar.listaID.getSelectedItem().toString();
                if(Entero(seleccion) == true){
                    datoId = Integer.parseInt(seleccion);
                    for (AlmacenAlimentoDTO lista : listaAlmacen) {
                        if (lista.getIdalmacenAlimento() == datoId){
                            modificar.tipo.setText(lista.getTipoalimento());
                            modificar.peso.setText(lista.getPesoSaco());
                            modificar.cantidad.setText(lista.getCantidadSaco());
                            modificar.pesototal.setText(lista.getPesoTotal());
                            modificar.fecha.setText(lista.getFechaEntrega());
                        }
                    }
                }else{
                    modificar.tipo.setText("");
                    modificar.peso.setText("");
                    modificar.cantidad.setText("");
                    modificar.pesototal.setText("");
                    modificar.fecha.setText("");
                }
                break;
            case "CALCULAR":
                peso = modificar.peso.getText();
                cantidad = modificar.cantidad.getText();
                if(Decimal(peso) == true){
                    if(Entero(cantidad) == true){
                            double nuevopeso = Double.parseDouble(peso);
                            int nuevaCantidad = Integer.parseInt(cantidad);
                            nuevoCalculo = new CalculoSacos(nuevopeso,nuevaCantidad);
                            modificar.pesototal.setText(nuevoCalculo.Total());
                            
                    }else{
                        JOptionPane.showMessageDialog(null,"   En el campo Cantidad solo esta \n"+
                                                                       "permitido ingresar numeros enteros [1]");
                            
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"En el campo PESO solo esta permitido ingresar\n"+
                                                                   "numeros enteros [1000.0] y decimales [1500.0]");
                       
                }
                break;
            case "MODIFICAR":
                String idseleccion = modificar.listaID.getSelectedItem().toString();
                String tipo = modificar.tipo.getText();
                String pesoSaco = modificar.peso.getText();
                String cantidadSaco = modificar.cantidad.getText();
                String pesoTotal = modificar.pesototal.getText();
                String fecha = modificar.fecha.getText();
                
                String [] alimento = {tipo,pesoSaco,cantidadSaco,pesoTotal,fecha};
                List datos = Arrays.asList(alimento);
                
                if(datos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos");
                    return;
                }
                if(Entero(idseleccion) == true){
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Debe de seleccionar un\n"+
                                                                   " ID ALMACEN ALIMENTO");
                        return;
                }
                if(Decimal(pesoSaco) == true){
                    if(Entero(cantidadSaco) == true){
                        if(Decimal(pesoTotal) == true){
                                alimentoModificado = new AlmacenAlimentoDTO(datoId,id,tipo,pesoSaco,cantidadSaco,pesoTotal,fecha);
                            try {
                                modificarAlimento.actualizar(alimentoModificado);
                            } catch (SQLException ex) {
                                ex.printStackTrace(System.out);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"En el campo PESO TOTAL solo esta permitido ingresar\n"+
                                                                           " numeros enteros [1000] y numeros decimales[1000.0]");
                        return;
                        }
                            
                    }else{
                        JOptionPane.showMessageDialog(null,"   En el campo Cantidad solo esta \n"+
                                                                       "permitido ingresar numeros enteros [1]");
                            return;
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"En el campo PESO solo esta permitido ingresar\n"+
                                                                   "numeros enteros [1000.0] y decimales [1500.0]");
                        return;
                }
                modificar.setVisible(false);
                break;
            case "LIMPIAR":
                modificar.listaID.setSelectedIndex(0);
                modificar.tipo.setText("");
                modificar.peso.setText("");
                modificar.cantidad.setText("");
                modificar.pesototal.setText("");
                modificar.fecha.setText(hoy);
                break;
            case "CERRAR":
                modificar.setVisible(true);
                break;
        }
    }
}
