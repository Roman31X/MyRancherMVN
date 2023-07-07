package Controlador;

import DTO.TerrenoDTO;
import VistaRegistro.RegistroCronograma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorRegistroCronograma implements ActionListener{
    private final RegistroCronograma nuevoRegistro;
    
    int id;
    int numero;
    String hoy;
    private final List<TerrenoDTO> idActivos;

    public ControladorRegistroCronograma(RegistroCronograma nuevoRegistro2, int id2, List<TerrenoDTO> idActivos2) {
        this.nuevoRegistro = nuevoRegistro2;
        this.id = id2;
        this.idActivos = idActivos2;
        nuevoRegistro.boxID.addActionListener(this);
        nuevoRegistro.Agregar.addActionListener(this);
        nuevoRegistro.Limpiar.addActionListener(this);
        nuevoRegistro.Regresar.addActionListener(this);
    }
    
    public void Mostrar(){
        nuevoRegistro.setVisible(true);
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
        String nuevoId;
        String accion = e.getActionCommand();
        switch(accion){
            case "comboBoxChanged":
                nuevoId = nuevoRegistro.boxID.getSelectedItem().toString();
                System.out.println("accion = " + nuevoId);
                
                if(isNumeric(nuevoId) == true){
                    numero = Integer.parseInt(nuevoId);
                    Date fechaHoy = new Date();
                    SimpleDateFormat nuevaFecha = new SimpleDateFormat("dd/MM/yyyy");
                    hoy = nuevaFecha.format(fechaHoy);
                    for (TerrenoDTO datos : idActivos) {
                        if(datos.getIdterreno() == numero){
                            nuevoRegistro.Propietario.setText(datos.getPropietario());
                            nuevoRegistro.Ubicacion.setText(datos.getUbicacion());
                            nuevoRegistro.Hectarea.setText(datos.getHectarea());
                            nuevoRegistro.fecha.setText(hoy);
                        }
                    }
                }else{
                    nuevoRegistro.Propietario.setText("");
                    nuevoRegistro.Ubicacion.setText("");
                    nuevoRegistro.Hectarea.setText("");
                    nuevoRegistro.fecha.setText("");
                }
                break;
            case "AGREGAR":
                nuevoId = nuevoRegistro.boxID.getSelectedItem().toString();
                String propietario = nuevoRegistro.Propietario.getText();
                String ubicacion = nuevoRegistro.Ubicacion.getText();
                String hectarea = nuevoRegistro.Hectarea.getText();
                String fecha = nuevoRegistro.fecha.getText();
                String actividad = nuevoRegistro.Actividad.getText();
                String tipoCultivo = nuevoRegistro.TipoCultivo.getText();
                String estadoActividad = nuevoRegistro.estadoActividad.getSelectedItem().toString();
                
                String [] nuevoUsuario = {propietario,ubicacion,hectarea,fecha,actividad,tipoCultivo,estadoActividad};
                List datos = Arrays.asList(nuevoUsuario);
                
                if(datos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos");
                    return;
                }
                
                if(isNumeric(nuevoId) == true){
                    if(estadoActividad.equals("-Seleccion-")){
                        JOptionPane.showMessageDialog(null,"Selecciones una opcion de\n"+
                                                                       "     ESTADO DE ACTIVIDAD ");
                        return;
                    }else{
                        System.out.println("DATOS : [" + numero+" : "+id+" : "+propietario+" : "+ubicacion+" : "+hectarea+" : "+fecha+" : "+actividad+" : "+tipoCultivo+" : "+estadoActividad);
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar el numero de\n"+
                                                                   "        ID TERRENO");
                    return;
                }
                nuevoRegistro.setVisible(false);
                break;
            case "LIMPIAR":
                nuevoRegistro.boxID.setSelectedIndex(0);
                nuevoRegistro.Actividad.setText("");
                nuevoRegistro.TipoCultivo.setText("");
                nuevoRegistro.estadoActividad.setSelectedIndex(0);
                break;
            case "REGRESAR":
                nuevoRegistro.setVisible(false);
                break;
        }
    }
}
