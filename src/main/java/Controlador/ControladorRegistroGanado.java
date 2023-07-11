package Controlador;

import DTO.GanadoDTO;
import JDBC.GanadoJDBC;
import VistaRegistro.RegistroGanado;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;

public class ControladorRegistroGanado implements ActionListener{
    private RegistroGanado registroGanado; 
    int id;
    String hoy;

    public ControladorRegistroGanado(RegistroGanado registroGanado1, int id1) {
        this.registroGanado = registroGanado1;
        this.id = id1;
        
        registroGanado.Registrar.addActionListener(this);
        registroGanado.Limpiar.addActionListener(this);
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
    public boolean Entero(String cadena) {

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
        java.util.Date fechaHoy = new java.util.Date();
        SimpleDateFormat nuevaFecha = new SimpleDateFormat("dd/MM/yyyy");
        
        GanadoDTO ganadoNuevo;
        GanadoJDBC insertarGanado = new GanadoJDBC();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "REGISTRAR":
                String fecha = registroGanado.FechaNacimineto.getText();
                String edad = registroGanado.edad.getText();
                String raza = registroGanado.Raza.getText();
                String sexo = registroGanado.Sexo.getSelectedItem().toString();
                String tipo = registroGanado.Tipo.getSelectedItem().toString();
                String numeroCrias = registroGanado.Ncrias.getText();
                
                String [] nuevoGanado = {fecha,edad,raza,numeroCrias};
                List datos = Arrays.asList(nuevoGanado);
                
                if(datos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos");
                    return;
                }
                
                if(isNumeric(edad) == true){
                    if(Entero(numeroCrias) == true){
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
                
                //System.out.println("ganado: "+id+"||"+fecha+"||"+edad+"||"+raza+"||"+sexo+"||"+tipo+"||"+numeroCrias);
                
                ganadoNuevo = new GanadoDTO(id,fecha,edad,raza,sexo,tipo,numeroCrias);
            
                try {
                    insertarGanado.insertar(ganadoNuevo);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                
                JOptionPane.showMessageDialog(null,"Se a Registrado exitosamente una \n"+
                                                               "  nueva especie a su Ganado ");
                hoy = nuevaFecha.format(fechaHoy);
                registroGanado.FechaNacimineto.setText(hoy);
                registroGanado.edad.setText("");
                registroGanado.Raza.setText("");
                registroGanado.Sexo.setSelectedIndex(0);
                registroGanado.Tipo.setSelectedIndex(0);
                registroGanado.Ncrias.setText("");
                break;

            case "LIMPIAR":
                hoy = nuevaFecha.format(fechaHoy);
                registroGanado.FechaNacimineto.setText(hoy);
                registroGanado.edad.setText("");
                registroGanado.Raza.setText("");
                registroGanado.Sexo.setSelectedIndex(0);
                registroGanado.Tipo.setSelectedIndex(0);
                registroGanado.Ncrias.setText("");
                break;
        }
    }
}
