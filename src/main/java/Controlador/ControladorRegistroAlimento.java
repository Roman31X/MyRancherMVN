package Controlador;

import DTO.AlmacenAlimentoDTO;
import JDBC.AlmacenAlimentoJDBC;
import Modelo.CalculoSacos;
import VistaRegistro.RegistroAlimento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControladorRegistroAlimento implements ActionListener{
    private RegistroAlimento registro;
    private int id;

    private String hoy;
    String peso;
    String cantidad;
    
    public ControladorRegistroAlimento(RegistroAlimento registro1, int id1) {
        this.registro = registro1;
        this.id = id1;
        
        registro.Calcular.addActionListener(this);
        registro.Registrar.addActionListener(this);
        registro.Limpiar.addActionListener(this);
        registro.Cerrar.addActionListener(this);
    }
    
    public void Mostrar(){
        registro.setVisible(true);
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
        
        AlmacenAlimentoDTO nuevaAlimento;
        AlmacenAlimentoJDBC regristroAlimento = new AlmacenAlimentoJDBC();
        
        Date fechaHoy = new Date();
        SimpleDateFormat nuevaFecha = new SimpleDateFormat("dd/MM/yyyy");
        hoy = nuevaFecha.format(fechaHoy);
        registro.fecha.setText(hoy);
        CalculoSacos nuevoCalculo;
        
        String accion = e.getActionCommand();
        switch(accion){
            case "CALCULAR":
                peso = registro.peso.getText();
                cantidad = registro.cantidad.getText();
                if(Decimal(peso) == true){
                    if(Entero(cantidad) == true){
                            double nuevopeso = Double.parseDouble(peso);
                            int nuevaCantidad = Integer.parseInt(cantidad);
                            nuevoCalculo = new CalculoSacos(nuevopeso,nuevaCantidad);
                            registro.pesototal.setText(nuevoCalculo.Total());
                            
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
                break;
            case "AGREGAR":
                String tipo = registro.tipo.getText();
                String pesoSaco = registro.peso.getText();
                String cantidadSaco = registro.cantidad.getText();
                String pesoTotal = registro.pesototal.getText();
                String fecha = registro.fecha.getText();
                
                String [] alimento = {tipo,pesoSaco,cantidadSaco,pesoTotal,fecha};
                List datos = Arrays.asList(alimento);
                
                if(datos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos");
                    return;
                }
                
                if(Decimal(pesoSaco) == true){
                    if(Entero(cantidadSaco) == true){
                        if(Decimal(pesoTotal) == true){                            
                            nuevaAlimento = new AlmacenAlimentoDTO(id,tipo,pesoSaco,cantidadSaco,pesoTotal,fecha);
                            try {
                                regristroAlimento.insertar(nuevaAlimento);
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
                registro.setVisible(false);
                break;
            case "LIMPIAR":
                registro.tipo.setText("");
                registro.peso.setText("");
                registro.cantidad.setText("");
                registro.pesototal.setText("");
                registro.fecha.setText(hoy);
                break;
            case "CERRAR":
                registro.setVisible(false);
                break;
        }
    }
}
