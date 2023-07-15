package Controlador;

import DTO.*;
import JDBC.AlmacenCosechaJDBC;
import VistaRegistro.RegistroCosecha;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;

public class ControladorRegistroCosecha implements ActionListener{
    private final RegistroCosecha registrar;
    private final int id;
    private final List<TerrenoDTO> listaTerreno;
    
    private String seleccion;
    private String hoy;
    private int numero;

    public ControladorRegistroCosecha(RegistroCosecha registrar1, int id1, List<TerrenoDTO> listaTerreno1) {
        this.registrar = registrar1;
        this.id = id1;
        this.listaTerreno = listaTerreno1;
        
        registrar.IDterreno.addActionListener(this);
        registrar.Registrar.addActionListener(this);
        registrar.Limpiar.addActionListener(this);
        registrar.Cerrar.addActionListener(this);
        
    }
    
    public void Mostrar(){
        registrar.setVisible(true);
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
        
        Date fechaHoy = new Date();
        SimpleDateFormat nuevaFecha = new SimpleDateFormat("dd/MM/yyyy");
        hoy = nuevaFecha.format(fechaHoy);
        
        AlmacenCosechaDTO nuevaCosecha;
        AlmacenCosechaJDBC regristroCosecha = new AlmacenCosechaJDBC();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "comboBoxChanged":
                seleccion = registrar.IDterreno.getSelectedItem().toString();
                if(isNumeric(seleccion) == true){
                    numero = Integer.parseInt(seleccion);
                    for (TerrenoDTO datos : listaTerreno) {
                        if(datos.getIdterreno() == numero){
                            registrar.Hectarea.setText(datos.getHectarea());
                            registrar.Fecha.setText(hoy);
                            break;
                        }
                    }
                }else{
                    registrar.Cosecha.setText("");
                    registrar.Peso.setText("");
                    registrar.Hectarea.setText("");
                    registrar.Fecha.setText(hoy);
                break;
                }
                break;
            case "REGISTRAR":
                String cosecha = registrar.Cosecha.getText();
                String peso = registrar.Peso.getText();
                String hectarea = registrar.Hectarea.getText();
                String fecha = registrar.Fecha.getText();
                
                String [] nuevoProduccion = {cosecha,peso,hectarea,cosecha,fecha};
                List datos = Arrays.asList(nuevoProduccion);
                
                if(datos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos");
                    return;
                }
                
                if(isNumeric(seleccion) == true){ 
                    if(Decimal(peso) == true){                    
                        nuevaCosecha = new AlmacenCosechaDTO(numero,id,cosecha,peso,hectarea,fecha);
                        try {
                            regristroCosecha.insertar(nuevaCosecha);
                        } catch (SQLException ex) {
                            ex.printStackTrace(System.out);
                        }  
                    }else{
                        JOptionPane.showMessageDialog(null,"En el campo PESO solo esta permitido ingresar\n"+
                                                                       "numeros enteros [1000.0] y decimales [1500.0]");
                        return;
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar un\n"+
                                                                       "    ID TERRENO");
                        return;
                }
                registrar.setVisible(false);
                break;
            case "LIMPIAR":
                registrar.IDterreno.setSelectedIndex(0);
                registrar.Cosecha.setText("");
                registrar.Peso.setText("");
                registrar.Hectarea.setText("");
                registrar.Fecha.setText(hoy);
                break;
            case "CERRAR":
                registrar.setVisible(false);
                break;
        }
    }
}
