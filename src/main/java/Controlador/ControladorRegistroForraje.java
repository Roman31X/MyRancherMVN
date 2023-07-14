package Controlador;

import DTO.AlmacenForrajeDTO;
import DTO.TerrenoDTO;
import JDBC.AlmacenForrajeJDBC;
import Modelo.CalculoForraje;
import VistaRegistro.RegistroForraje;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

public class ControladorRegistroForraje implements ActionListener{
    private final RegistroForraje registro;
    int id;
    List<TerrenoDTO> listaTerreno;
    
    private String seleccion;
    private String resultado;
    private int numero;

    public ControladorRegistroForraje(RegistroForraje registro1, int id1, List<TerrenoDTO> listaTerreno1) {
        this.registro = registro1;
        this.id = id1;
        this.listaTerreno = listaTerreno1;
        
        registro.IDterreno.addActionListener(this);
        registro.Calcular.addActionListener(this);
        registro.Registrar.addActionListener(this);
        registro.Limpiar.addActionListener(this);
        registro.Cerrar.addActionListener(this);
    }
    
    public void Mostrar(){
        registro.setVisible(true);
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
        CalculoForraje calculo;
        
        AlmacenForrajeDTO forrajeNuevo;
        AlmacenForrajeJDBC insertarForraje = new AlmacenForrajeJDBC();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "comboBoxChanged":
                seleccion = registro.IDterreno.getSelectedItem().toString();
                if(isNumeric(seleccion) == true){
                    numero = Integer.parseInt(registro.IDterreno.getSelectedItem().toString());
                    for (TerrenoDTO lista : listaTerreno) {
                        if(lista.getIdterreno() == numero){
                            registro.Hectarea.setText(lista.getHectarea());
                        }
                    }
                }else{
                    registro.Hectarea.setText("");
                }
                break;
            case "CALCULAR":
                String muestra1 = registro.MuestraUno.getText();
                String muestra2 = registro.MuestraDos.getText();
                String hectarea = registro.Hectarea.getText();
                
                if(Decimal(muestra1) == true){
                    if(Decimal(muestra2) == true){
                        if(Decimal(hectarea) == true){
                            double recuperaMuestra1 = Double.parseDouble(registro.MuestraUno.getText());
                            double recuperaMuestra2 = Double.parseDouble(registro.MuestraDos.getText());
                            double recuperaHectarea = Double.parseDouble(registro.Hectarea.getText());
                            calculo = new CalculoForraje(recuperaMuestra1,recuperaMuestra2,recuperaHectarea);
                            resultado = String.valueOf(calculo.TotalForraje());
                            registro.Producion.setText(resultado);
                        }else{
                            JOptionPane.showMessageDialog(null,"Debe el campo de HECTAREA solo esta pemitido\n"+
                                                                           "    mumeros enteros [1] y decimales [1.5]");
                            
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Debe el campo de MUESTRA 2 solo esta pemitido\n"+
                                                                       "    mumeros enteros [1] y decimales [1.5]");
                        
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Debe el campo de MUESTRA 1 solo esta pemitido\n"+
                                                                   "    mumeros enteros [1] y decimales [1.5]");
                   
                }
                break;
            case "AGREGAR":
                String forraje = registro.Forraje.getText();
                String dato1 = registro.MuestraUno.getText();
                String dato2 = registro.MuestraDos.getText();
                String dimencion = registro.Hectarea.getText();
                String producto = registro.Producion.getText();
                
                String [] usuario = {forraje,dato1,dato2,dimencion,producto};
                List datos = Arrays.asList(usuario);
                
                if(datos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos");
                    return;
                }
                
                forrajeNuevo = new AlmacenForrajeDTO(numero,id,forraje,dato1,dato2,dimencion,producto);
                try {
                    insertarForraje.insertar(forrajeNuevo);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                registro.setVisible(false);
                break;
            case "LIMPIAR":
                registro.IDterreno.setSelectedIndex(0);
                registro.Forraje.setText("");
                registro.MuestraUno.setText("");
                registro.MuestraDos.setText("");
                registro.Hectarea.setText("");
                registro.Producion.setText("");
                break;
            case "CERRAR":
                registro.setVisible(false);
                break;
        }
    }
}
