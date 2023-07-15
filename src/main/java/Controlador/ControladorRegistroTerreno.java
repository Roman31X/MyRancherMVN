package Controlador;

import DTO.TerrenoDTO;
import JDBC.TerrenoJDBC;
import VistaRegistro.RegistroTerreno;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorRegistroTerreno implements ActionListener{
    private final RegistroTerreno nuevoTerreno;
    private final int id;

    public ControladorRegistroTerreno(RegistroTerreno nuevoTerreno1, int id1) {
        this.nuevoTerreno = nuevoTerreno1;
        this.id = id1;
        
        nuevoTerreno.Agregar.addActionListener(this);
        nuevoTerreno.Limpiar.addActionListener(this);
        nuevoTerreno.Cerrar.addActionListener(this);
    }
    
    public void Mostrar(){
        nuevoTerreno.setVisible(true);
    }
    
    public boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    
    //Acciones
    @Override
    public void actionPerformed(ActionEvent e) {
        
        TerrenoDTO terrenoNuevo;
        TerrenoJDBC insertarTerreno = new TerrenoJDBC();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "AGREGAR":
                String propietario = nuevoTerreno.Propietario.getText();
                String ubicacion = nuevoTerreno.Ubicacion.getText();
                String hectarea = nuevoTerreno.Hectarea.getText();
                String estado = nuevoTerreno.Estado.getSelectedItem().toString();
                
                String [] nuevoUsuario = {propietario,ubicacion,hectarea};
                List datos = Arrays.asList(nuevoUsuario);
                
                if(datos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos");
                    return;
                }
                
                if(isNumeric(hectarea) == true){
                    if(estado.equals("-Seleccione-")){
                        JOptionPane.showMessageDialog(null,"Selecciones una opcion de Estado");
                        return;
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"En el campo hectrea solo esta permitio\n"+
                                                                   "ingresa numeros enteros[1] y decimales [1.5]");
                    return;
                }
                
                double dimension = Double.parseDouble(hectarea)*10000;
                hectarea = String.valueOf(dimension);
                
                terrenoNuevo = new TerrenoDTO(id,propietario,ubicacion,hectarea,estado);
                try {
                    insertarTerreno.insertar(terrenoNuevo);
                    JOptionPane.showMessageDialog(null,"Su terreno a sido regitrado\n"+
                                                                   "            Exitosamente");
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                nuevoTerreno.setVisible(false);
                break;
            case "LIMPIAR":
                nuevoTerreno.Propietario.setText("");
                nuevoTerreno.Ubicacion.setText("");
                nuevoTerreno.Hectarea.setText("");
                nuevoTerreno.Estado.setSelectedIndex(0);
                break;
            case "CERRAR":
                nuevoTerreno.setVisible(false);
                break;
        }
    }    
}
