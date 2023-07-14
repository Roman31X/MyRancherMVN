package Controlador;

import DTO.CronogramaDTO;
import JDBC.CronogramaJDBC;
import VistaTerreno.VistaModificarCronograma;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

public class ControladorModificarCronograma implements ActionListener{
    private final VistaModificarCronograma controlModificar;
    private final int id;
    private final List<CronogramaDTO> ActivosCronograma;
    
    private String nuevoId;
    private int datoId;
    private double hectarea;
    private int idTerreno;
    
    CronogramaDTO cronogramaModifiado;
    CronogramaJDBC modificadoCronograma;

    public ControladorModificarCronograma(VistaModificarCronograma controlModificar2, int id2, List<CronogramaDTO> ActivosCronograma2) {
        this.controlModificar = controlModificar2;
        this.id = id2;
        this.ActivosCronograma = ActivosCronograma2;
        
        controlModificar.boxID.addActionListener(this);
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
        
        modificadoCronograma = new CronogramaJDBC();
        
        String accion = e.getActionCommand();
        
        
        switch(accion){
            case "comboBoxChanged":
                nuevoId = controlModificar.boxID.getSelectedItem().toString();
                
                if(isNumeric(nuevoId) == true){
                    datoId = Integer.parseInt(nuevoId);
                    for (CronogramaDTO lista : ActivosCronograma) {
                        if(lista.getIdcronograma() == datoId){
                            idTerreno = lista.getIdterreno();
                            controlModificar.Propietario.setText(lista.getPropietario());
                            controlModificar.Ubicacion.setText(lista.getUbicacion());
                            hectarea = Double.parseDouble(lista.getHectarea())/10000;
                            controlModificar.Hectarea.setText(String.valueOf(hectarea));
                            controlModificar.fecha.setText(lista.getFechactividad());
                            controlModificar.Actividad.setText(lista.getActividad());
                            controlModificar.TipoCultivo.setText(lista.getCultivo());
                            if(lista.getEstadoCronograma().equals("Realizado")){
                                controlModificar.estadoActividad.setSelectedIndex(1);
                            }else{
                                controlModificar.estadoActividad.setSelectedIndex(2);
                            }
                        }
                    }
                }else{
                    controlModificar.Propietario.setText("");
                    controlModificar.Ubicacion.setText("");
                    controlModificar.Hectarea.setText("");
                    controlModificar.fecha.setText("");
                    controlModificar.Actividad.setText("");
                    controlModificar.TipoCultivo.setText("");
                    controlModificar.estadoActividad.setSelectedIndex(0);
                }
                break;
            case "MODIFICAR":
                nuevoId = controlModificar.boxID.getSelectedItem().toString();
                String propietario = controlModificar.Propietario.getText();
                String ubicacion = controlModificar.Ubicacion.getText();
                String nuevaHectarea = controlModificar.Hectarea.getText();
                String fecha = controlModificar.fecha.getText();
                String actividad = controlModificar.Actividad.getText();
                String tipoCultivo = controlModificar.TipoCultivo.getText();
                String estadoActividad = controlModificar.estadoActividad.getSelectedItem().toString();
                
                String [] nuevoUsuario = {propietario,ubicacion,nuevaHectarea,fecha,actividad,tipoCultivo,estadoActividad};
                List datos = Arrays.asList(nuevoUsuario);
                if(isNumeric(nuevoId) == true){
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar un\n"+
                                                                   "   ID TERRENO");
                    return;
                }
                
                if(datos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos");
                    return;
                }
                
                if(Decimal(nuevaHectarea) == true){
                    if(estadoActividad.equals("-Seleccion-")){
                        JOptionPane.showMessageDialog(null,"Selecciones una opcion de Estado\n"+
                                                                       "        de Actividad");
                        return;
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"En el campo hectrea solo esta permitio\n"+
                                                                   "ingresa numeros enteros[1] y decimales [1.0]");
                    return;
                }
                
                double dimension = Double.parseDouble(nuevaHectarea)*10000;
                nuevaHectarea = String.valueOf(dimension);
                
                cronogramaModifiado = new CronogramaDTO(datoId,idTerreno,id,propietario,ubicacion,nuevaHectarea,fecha,actividad,tipoCultivo,estadoActividad);
                try {
                    modificadoCronograma.actualizar(cronogramaModifiado);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                controlModificar.setVisible(false);
                break;

            case "LIMPIAR":
                controlModificar.boxID.setSelectedIndex(0);
                controlModificar.Propietario.setText("");
                controlModificar.Ubicacion.setText("");
                controlModificar.Hectarea.setText("");
                controlModificar.fecha.setText("");
                controlModificar.Actividad.setText("");
                controlModificar.TipoCultivo.setText("");
                controlModificar.estadoActividad.setSelectedIndex(0);
                break;
            case "CERRAR":
                controlModificar.setVisible(false);
                break;
        }
    }
}
