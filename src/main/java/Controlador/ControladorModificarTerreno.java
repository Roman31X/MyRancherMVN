package Controlador;

import DTO.TerrenoDTO;
import VistaTerreno.VistaModificarTerreno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorModificarTerreno implements ActionListener{
    private final VistaModificarTerreno modificarTerreno;
    private final List<TerrenoDTO> idTerreno;
    double hectarea;
    int datoId;
    String llenarCampos;

    public ControladorModificarTerreno(VistaModificarTerreno modificarTerreno2, List<TerrenoDTO> idTerreno2) {
        this.modificarTerreno = modificarTerreno2;
        this.idTerreno = idTerreno2;
        
        modificarTerreno.IDBOX.addActionListener(this);
        modificarTerreno.Actualizar.addActionListener(this);
        modificarTerreno.Limpiar.addActionListener(this);
        modificarTerreno.Cerrar.addActionListener(this);
    }
    
    public void Mostrar(){
        modificarTerreno.setVisible(true);
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
        String accion = e.getActionCommand();
        System.out.println("accion = " + accion);
        switch(accion){
            case "comboBoxChanged":
                llenarCampos = modificarTerreno.IDBOX.getSelectedItem().toString();
                
                if(isNumeric(llenarCampos) == true){
                    datoId = Integer.parseInt(llenarCampos);
                    for (TerrenoDTO lista : idTerreno) {
                        if (lista.getIdterreno() == datoId){
                            modificarTerreno.Propietario.setText(lista.getPropietario());
                            modificarTerreno.Ubicacion.setText(lista.getUbicacion());
                            hectarea = Double.parseDouble(lista.getHectarea())/10000;
                            modificarTerreno.Hectarea.setText(String.valueOf(hectarea));
                            if(lista.getEstadoTerreno().equals("Activo")){
                                modificarTerreno.Estado.setSelectedIndex(1);
                            }else{
                                modificarTerreno.Estado.setSelectedIndex(2);
                            }
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar el numero de ID\n"+
                                                                   " de la tabla de sus Terrenos");
                    modificarTerreno.Propietario.setText("");
                    modificarTerreno.Ubicacion.setText("");
                    modificarTerreno.Hectarea.setText("");
                }
                break;
            case "ACTUALIZAR":
                System.out.println("Actualizado XD");
                break;
            case "LIMPIAR":
                modificarTerreno.IDBOX.setSelectedIndex(0);
                modificarTerreno.Propietario.setText("");
                modificarTerreno.Ubicacion.setText("");
                modificarTerreno.Hectarea.setText("");
                modificarTerreno.Estado.setSelectedIndex(0);
                break;
            case "CERRAR":
                modificarTerreno.setVisible(false);
                break;
        }        
    }
    
    
}
