package Controlador;

import DTO.AlmacenForrajeDTO;
import DTO.TerrenoDTO;
import JDBC.AlmacenForrajeJDBC;
import Modelo.CalculoForraje;
import VistaAlmacen.VistaModificarForraje;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControladorModificarForraje implements ActionListener{
    private VistaModificarForraje modificar;
    private int id;
    private List<AlmacenForrajeDTO> listaForraje;
    private List<TerrenoDTO> listaTerreno;

    private String seleccionID;
    private String seleccionIDT;
    private int datoId;
    private int datoIdT;
    private String resultado;
    
    public ControladorModificarForraje(VistaModificarForraje modificar2, int id2, List<AlmacenForrajeDTO> listaForraje2, List<TerrenoDTO> listaTerreno2) {
        this.modificar = modificar2;
        this.id = id2;
        this.listaForraje = listaForraje2;
        this.listaTerreno = listaTerreno2;
        
        modificar.IDForraje.addActionListener(this);
        modificar.IDterreno.addActionListener(this);
        modificar.Calcular.addActionListener(this);
        modificar.Modificar.addActionListener(this);
        modificar.Limpiar.addActionListener(this);
        modificar.Cerrar.addActionListener(this);
        
    }
    
    public void Mostrar(){
        modificar.setVisible(true);
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
        
        AlmacenForrajeDTO forrajeActualizado;
        AlmacenForrajeJDBC actualizarForraje = new AlmacenForrajeJDBC();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "comboBoxChanged":
                seleccionID = modificar.IDForraje.getSelectedItem().toString();
                if(isNumeric(seleccionID) == true){
                    datoId = Integer.parseInt(seleccionID);
                    for (AlmacenForrajeDTO lista : listaForraje) {
                        if(lista.getIdalmacenforraje() == datoId){
                            modificar.IDterreno.setSelectedIndex(lista.getIdterreno());
                            modificar.Forraje.setText(lista.getForraje());
                            modificar.MuestraUno.setText(lista.getMuestra1());
                            modificar.MuestraDos.setText(lista.getMuestra2());
                            modificar.Hectarea.setText(lista.getDimencion());
                            modificar.Producion.setText(lista.getPesogenerado());
                            break;
                        }
                    }
                }else{
                    modificar.IDterreno.setSelectedIndex(0);
                    modificar.Forraje.setText("");
                    modificar.MuestraUno.setText("");
                    modificar.MuestraDos.setText("");
                    modificar.Hectarea.setText("");
                    modificar.Producion.setText("");
                }
                break;
            case "comboBox":
                seleccionIDT = modificar.IDterreno.getSelectedItem().toString();
                if(isNumeric(seleccionIDT) == true){
                    datoIdT = Integer.parseInt(modificar.IDterreno.getSelectedItem().toString());
                    for (TerrenoDTO lista : listaTerreno) {
                        if(lista.getIdterreno() == datoIdT){
                            modificar.Hectarea.setText(lista.getHectarea());
                            break;
                        }
                    }
                }else{
                    modificar.Hectarea.setText("");
                }
                break;
            case "CALCULAR":
                String muestra1 = modificar.MuestraUno.getText();
                String muestra2 = modificar.MuestraDos.getText();
                String hectarea = modificar.Hectarea.getText();
                
                if(Decimal(muestra1) == true){
                    if(Decimal(muestra2) == true){
                        if(Decimal(hectarea) == true){
                            double recuperaMuestra1 = Double.parseDouble(modificar.MuestraUno.getText());
                            double recuperaMuestra2 = Double.parseDouble(modificar.MuestraDos.getText());
                            double recuperaHectarea = Double.parseDouble(modificar.Hectarea.getText());
                            calculo = new CalculoForraje(recuperaMuestra1,recuperaMuestra2,recuperaHectarea);
                            resultado = String.valueOf(calculo.TotalForraje());
                            modificar.Producion.setText(resultado);
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
            case "MODIFICAR":
                String forraje = modificar.Forraje.getText();
                String muestraUNO = modificar.MuestraUno.getText();
                String muestraDOS = modificar.MuestraDos.getText();
                String hectareas = modificar.Hectarea.getText();
                String producion = modificar.Producion.getText();
                
                String [] usuario = {forraje,muestraUNO,muestraDOS,hectareas,producion};
                List datos = Arrays.asList(usuario);
                
                if(datos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos");
                    return;
                }
                
                //System.out.println("datos = " + seleccionID+seleccionIDT+id+forraje+muestraUNO+muestraDOS+hectareas+producion);
                forrajeActualizado = new AlmacenForrajeDTO(datoId,datoIdT,id,forraje,muestraUNO,muestraDOS,hectareas,producion);
                try {
                    actualizarForraje.actualizar(forrajeActualizado);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                modificar.setVisible(false);
                break;
            case "LIMPIAR":
                modificar.IDForraje.setSelectedIndex(0);
                modificar.IDterreno.setSelectedIndex(0);
                modificar.Forraje.setText("");
                modificar.MuestraUno.setText("");
                modificar.MuestraDos.setText("");
                modificar.Hectarea.setText("");
                modificar.Producion.setText("");
                break;
            case "CERRAR":
                modificar.setVisible(false);
                break;
        }
    }
}
