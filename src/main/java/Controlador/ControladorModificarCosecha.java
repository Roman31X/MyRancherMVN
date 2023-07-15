package Controlador;

import DTO.*;
import VistaAlmacen.VistaModificarCosecha;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorModificarCosecha implements ActionListener{
    private VistaModificarCosecha modificar;
    private int id;
    private List<AlmacenCosechaDTO> listaCosecha;
    private List<TerrenoDTO> listaTerreno;
    
    private String seleccion;
    private String seleccion2;
    private String hoy;
    private int numero;
    private int numero2;
    private int numero3;

    public ControladorModificarCosecha(VistaModificarCosecha modificar2, int id2, List<AlmacenCosechaDTO> listaCosecha2, List<TerrenoDTO> listaTerreno2) {
        this.modificar = modificar2;
        this.id = id2;
        this.listaCosecha = listaCosecha2;
        this.listaTerreno = listaTerreno2;
        
        modificar.IDForraje.addActionListener(this);
        modificar.IDterreno.addActionListener(this);
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
        
        Date fechaHoy = new Date();
        SimpleDateFormat nuevaFecha = new SimpleDateFormat("dd/MM/yyyy");
        hoy = nuevaFecha.format(fechaHoy);
        
        String accion = e.getActionCommand();
        switch(accion){
            case "comboBox":
                seleccion = modificar.IDForraje.getSelectedItem().toString();
                if(isNumeric(seleccion) == true){
                    numero = Integer.parseInt(seleccion);
                    
                    for (AlmacenCosechaDTO lista : listaCosecha) {
                        if(lista.getIdalmacenCosecha() == numero){
                            modificar.Cosecha.setText(lista.getProducto());
                            modificar.Peso.setText(lista.getPeso());
                            modificar.Hectarea.setText(lista.getDimension());
                            modificar.Fecha.setText(lista.getFecha());
                        }                        
                    }
                }else{
                    modificar.Cosecha.setText("");
                    modificar.Peso.setText("");
                    modificar.Hectarea.setText("");
                    modificar.Fecha.setText(hoy);
                }
                
                break;
            case "comboBoxChanged":
                seleccion2 = modificar.IDterreno.getSelectedItem().toString();
                if(isNumeric(seleccion2) == true){
                    numero2 = Integer.parseInt(seleccion2);
                    for (TerrenoDTO lista : listaTerreno) {
                        if(lista.getIdterreno() == numero2){
                            modificar.Hectarea.setText(lista.getHectarea());
                        }
                    }
                }else{
                    modificar.Hectarea.setText("");
                }
                break;
            case "MODIFICAR":
                String idcosecha = modificar.IDForraje.getSelectedItem().toString();
                String cosecha = modificar.Cosecha.getText();
                String peso = modificar.Peso.getText();
                String hectarea = modificar.Hectarea.getText();
                String fecha = modificar.Fecha.getText();
                
                String [] nuevoProduccion = {cosecha,peso,hectarea,cosecha,fecha};
                List datos = Arrays.asList(nuevoProduccion);
                
                if(datos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos");
                    return;
                }
                
                if(isNumeric(idcosecha) == true){
                    if(isNumeric(seleccion2) == true){
                        if(Decimal(peso) == true){
                            System.out.println("Modificado :" + numero+"||"+numero2+"||"+id+"||"+cosecha+"||"+peso+"||"+hectarea+"||"+fecha);
                        }else{
                            JOptionPane.showMessageDialog(null,"En el campo de peso solo esta permitido ingresar\n"+
                                                                           "numeros enteros [1000] y decimales [1000.0]");
                            return;
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Debe seleccionar un\n"+
                                                                       "    ID TERRENO");
                        return;
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar un\n"+
                                                                   " ID ALMACEN COSECHA");
                    return;
                }                
                modificar.setVisible(false);
                break;
            case "LIMPIAR":
                modificar.IDForraje.setSelectedIndex(0);
                modificar.IDterreno.setSelectedIndex(0);
                modificar.Cosecha.setText("");
                modificar.Peso.setText("");
                modificar.Hectarea.setText("");
                modificar.Fecha.setText(hoy);
                break;
            case "CERRAR":
                modificar.setVisible(false);
                break;
        }
    }
    
    
}
