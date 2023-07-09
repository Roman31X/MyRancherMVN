package Controlador;

import DTO.TerrenoDTO;
import JDBC.TerrenoJDBC;
import VistaTerreno.VistaModificarTerreno;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

public class ControladorModificarTerreno implements ActionListener{
    private final VistaModificarTerreno modificarTerreno;
    private final List<TerrenoDTO> idTerreno;
    private final int id;
    double hectarea;
    int datoId;
    String llenarCampos;

    public ControladorModificarTerreno(VistaModificarTerreno modificarTerreno2,int id2, List<TerrenoDTO> idTerreno2) {
        this.modificarTerreno = modificarTerreno2;
        this.id = id2;
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
        TerrenoDTO terroActualizado;
        TerrenoJDBC actualizarTerreno = new TerrenoJDBC();
        
        String accion = e.getActionCommand();
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
                    modificarTerreno.Propietario.setText("");
                    modificarTerreno.Ubicacion.setText("");
                    modificarTerreno.Hectarea.setText("");
                }
                break;
            case "ACTUALIZAR":
                String propietario = modificarTerreno.Propietario.getText();
                String ubicacion = modificarTerreno.Ubicacion.getText();
                String nuevaHectarea = modificarTerreno.Hectarea.getText();
                String estado = modificarTerreno.Estado.getSelectedItem().toString();
                
                String [] nuevoUsuario = {propietario,ubicacion,nuevaHectarea};
                List datos = Arrays.asList(nuevoUsuario);
                
                if(isNumeric(llenarCampos) == true){
                    
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
                    if(estado.equals("-Seleccione-")){
                        JOptionPane.showMessageDialog(null,"Selecciones una opcion de Estado");
                        return;
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"En el campo hectrea solo esta permitio\n"+
                                                                   "ingresa numeros enteros[1] y decimales [1.0]");
                    return;
                }
                
                double dimension = Double.parseDouble(nuevaHectarea)*10000;
                nuevaHectarea = String.valueOf(dimension);
                
                terroActualizado = new TerrenoDTO(datoId,id,propietario,ubicacion,nuevaHectarea,estado);
                try {
                    actualizarTerreno.actualizar(terroActualizado);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                modificarTerreno.setVisible(false);
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
