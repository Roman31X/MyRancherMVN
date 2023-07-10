package Controlador;

import DTO.ProduccionDTO;
import DTO.TerrenoDTO;
import JDBC.ProduccionJDBC;
import VistaRegistro.RegistroProduccion;
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

public class ControladorRegistroProduccion implements ActionListener{
    private RegistroProduccion controlRegistro;
    private int id;
    private List<TerrenoDTO> idTerreno;
    private String[] calculo;
    
    private String seleccion;
    private String hoy;
    private int numero;

    public ControladorRegistroProduccion(RegistroProduccion controlRegistro2, int id2, List<TerrenoDTO> idTerreno2,String[] calculo2) {
        this.controlRegistro = controlRegistro2;
        this.id = id2;
        this.idTerreno = idTerreno2;
        this.calculo = calculo2;
        
        controlRegistro.IDBOX.addActionListener(this);
        controlRegistro.Agregar.addActionListener(this);
        controlRegistro.Limpiar.addActionListener(this);
        controlRegistro.Cerrar.addActionListener(this);
    }
    
    public void Mostrar(){
        controlRegistro.setVisible(true);
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
        
        ProduccionDTO nuevaProduccion;
        ProduccionJDBC regristroProduccion = new ProduccionJDBC();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "comboBoxChanged":
                seleccion = controlRegistro.IDBOX.getSelectedItem().toString();
                if(isNumeric(seleccion) == true){
                    numero = Integer.parseInt(controlRegistro.IDBOX.getSelectedItem().toString());
                    Date fechaHoy = new Date();
                    SimpleDateFormat nuevaFecha = new SimpleDateFormat("dd/MM/yyyy");
                    hoy = nuevaFecha.format(fechaHoy);
                    
                    for (TerrenoDTO datos : idTerreno) {
                        if(datos.getIdterreno() == numero){
                            controlRegistro.Propietario.setText(datos.getPropietario());
                            controlRegistro.Ubicacion.setText(datos.getUbicacion());
                            controlRegistro.Hectarea.setText(datos.getHectarea());
                            controlRegistro.PesoTotalCosecha.setText(calculo[0]);
                            controlRegistro.PrecioxKilo.setText(calculo[1]);
                            controlRegistro.Ganancia.setText(calculo[2]);
                            controlRegistro.Fecha.setText(hoy);
                        }
                    }
                }else{
                    controlRegistro.Propietario.setText("");
                    controlRegistro.Ubicacion.setText("");
                    controlRegistro.Hectarea.setText("");
                    controlRegistro.PesoTotalCosecha.setText("");
                    controlRegistro.PrecioxKilo.setText("");
                    controlRegistro.Ganancia.setText("");
                    controlRegistro.Fecha.setText("");
                }
                break;
            case "REGISTRAR":
                seleccion = controlRegistro.IDBOX.getSelectedItem().toString();
                String propietario = controlRegistro.Propietario.getText();
                String ubicacion = controlRegistro.Ubicacion.getText();
                String hectarea = controlRegistro.Hectarea.getText();
                String cosecha = controlRegistro.Cultivo.getText();
                String pesoCosecha = controlRegistro.PesoTotalCosecha.getText();
                String precio = controlRegistro.PrecioxKilo.getText();
                String ganancia = controlRegistro.Ganancia.getText();
                String fecha = controlRegistro.Fecha.getText();
                
                String [] nuevoProduccion = {propietario,ubicacion,hectarea,cosecha,pesoCosecha,precio,ganancia,fecha};
                List datos = Arrays.asList(nuevoProduccion);
                
                if(datos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos");
                    return;
                }
                
                if(isNumeric(seleccion) == true){
                    nuevaProduccion = new ProduccionDTO(numero,id,propietario,ubicacion,hectarea,cosecha,pesoCosecha,precio,ganancia,fecha);
                    try {
                        regristroProduccion.insertar(nuevaProduccion);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar el numero de\n"+
                                                                   "        ID TERRENO");
                    return;
                }
                controlRegistro.setVisible(false);
                break;
            case "LIMPIAR":
                controlRegistro.IDBOX.setSelectedIndex(0);
                controlRegistro.Propietario.setText("");
                controlRegistro.Ubicacion.setText("");
                controlRegistro.Hectarea.setText("");
                controlRegistro.Cultivo.setText("");
                controlRegistro.PesoTotalCosecha.setText("");
                controlRegistro.PrecioxKilo.setText("");
                controlRegistro.Ganancia.setText("");
                controlRegistro.Fecha.setText("");
                break;
            case "CERRAR":
                controlRegistro.setVisible(false);
                break;
            
        }
    }
}
