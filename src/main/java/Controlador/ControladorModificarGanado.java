package Controlador;

import DTO.GanadoDTO;
import JDBC.GanadoJDBC;
import VistaGanado.VistaModificarGanado;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ControladorModificarGanado implements ActionListener{
    private VistaModificarGanado vistaModificar;
    private int id;
    private List<GanadoDTO> idActivos;
    private String seleccionID;
    private int idregistrado;
    
    public ControladorModificarGanado(VistaModificarGanado vistaModificar1, int id1, List<GanadoDTO> idActivos1) {
        this.vistaModificar = vistaModificar1;
        this.id = id1;
        this.idActivos = idActivos1;
        
        vistaModificar.IDGanado.addActionListener(this);
        vistaModificar.Modificar.addActionListener(this);
        vistaModificar.Limpiar.addActionListener(this);
        vistaModificar.Regresar.addActionListener(this);
    }
    
    public void Mostrar(){
        vistaModificar.setVisible(true);
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
        GanadoDTO ganadoModifiado;
        GanadoJDBC modificadoGanado = new GanadoJDBC();
        
        String accion = e.getActionCommand();
        
        switch(accion){
            case "comboBoxChanged":
                seleccionID = vistaModificar.IDGanado.getSelectedItem().toString();
                if(isNumeric(seleccionID) == true){
                    idregistrado = Integer.parseInt(seleccionID);
                    for (GanadoDTO lista : idActivos) {
                        if(lista.getIdGanado() == idregistrado){
                            vistaModificar.FechaNacimineto.setText(lista.getFechaNacimiento());
                            vistaModificar.edad.setText(lista.getEdad());
                            vistaModificar.Raza.setText(lista.getRaza());
                            if(lista.getSexo().equals("Macho")){
                                vistaModificar.Sexo.setSelectedIndex(1);
                            }else{
                                vistaModificar.Sexo.setSelectedIndex(2);
                            }
                            if(lista.getTipoGanado().equals("Lechero")){
                                vistaModificar.Tipo.setSelectedIndex(1);
                            }else{
                                vistaModificar.Tipo.setSelectedIndex(2);
                            }
                            vistaModificar.Ncrias.setText(lista.getNumeroCrias());
                            break;
                        }
                    }
                }else{
                    vistaModificar.FechaNacimineto.setText("");
                    vistaModificar.edad.setText("");
                    vistaModificar.Raza.setText("");
                    vistaModificar.Sexo.setSelectedIndex(0);
                    vistaModificar.Tipo.setSelectedIndex(0);
                    vistaModificar.Ncrias.setText("");
                }
                break;
            case "MODIFICAR":
                String fecha = vistaModificar.FechaNacimineto.getText();
                String edad = vistaModificar.edad.getText();
                String raza = vistaModificar.Raza.getText();
                String sexo = vistaModificar.Sexo.getSelectedItem().toString();
                String tipo = vistaModificar.Tipo.getSelectedItem().toString();
                String numeroCrias = vistaModificar.Ncrias.getText();
                
                String [] nuevoGanado = {fecha,edad,raza,numeroCrias};
                List datos = Arrays.asList(nuevoGanado);
                
                if(isNumeric(seleccionID) == true){
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar un\n"+
                                                                   " ID REGISTRO GANADO");
                    return;
                }
                
                if(datos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos");
                    return;
                }
                
                if(Decimal(edad) == true){
                    if(isNumeric(numeroCrias) == true){
                        if(sexo.equals("-Seleccione-") || tipo.equals("-Seleccione-")){
                        JOptionPane.showMessageDialog(null,"Selecciones una opcion del comboBox\n"+
                                                                       "         de TIPO Y SEXO");
                        return;
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"En el campo Numero de Crias solo esta permitio\n"+
                                                                       "            ingresa numeros enteros[1]");
                        return;
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"En el campo Edad solo esta permitio\n"+
                                                                   "ingresa numeros enteros[1] y decimales [1.5]");
                    return;
                }
                
                ganadoModifiado = new GanadoDTO(idregistrado,id,fecha,edad,raza,sexo,tipo,numeroCrias);
            
                try {
                    modificadoGanado.actualizar(ganadoModifiado);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                
                vistaModificar.setVisible(false);
                break;

            case "LIMPIAR":
                vistaModificar.IDGanado.setSelectedIndex(0);
                vistaModificar.FechaNacimineto.setText("");
                vistaModificar.edad.setText("");
                vistaModificar.Raza.setText("");
                vistaModificar.Sexo.setSelectedIndex(0);
                vistaModificar.Tipo.setSelectedIndex(0);
                vistaModificar.Ncrias.setText("");
                break;
            case "CERRAR":
                vistaModificar.setVisible(false);
                break;
        }
    }
}
