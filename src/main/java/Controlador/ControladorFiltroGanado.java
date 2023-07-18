package Controlador;

import DTO.GanadoDTO;
import VistaGanado.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ControladorFiltroGanado implements ActionListener{
    private final VistaListarGanado controlGanado;
    private final VistaFiltroGanado filtro;
    private List<GanadoDTO> idActivos;
    
    DefaultTableModel model;
    String[] objeto;
    
    public ControladorFiltroGanado(VistaListarGanado controlGanado3, VistaFiltroGanado filtro3,List<GanadoDTO> idActivos3) {
        this.controlGanado = controlGanado3;
        this.filtro = filtro3;
        this.idActivos = idActivos3;
        
        filtro.Filtrar.addActionListener(this);
        filtro.Regresar.addActionListener(this);
    }

    public void Mostrar(){
        filtro.setVisible(true);
    }
    
    public boolean Años(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
    
    //Acciones
    @Override
    public void actionPerformed(ActionEvent e) {
        
        model = (DefaultTableModel) controlGanado.Tablaganado.getModel();
        for (int i = 0; i < controlGanado.Tablaganado.getRowCount(); i++) {
            model.removeRow(i);
            i-=1;
        }
        objeto = new String[7];
        model = (DefaultTableModel) controlGanado.Tablaganado.getModel();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "FILTRAR":
                String sexo = filtro.ListaSexo.getSelectedItem().toString();
                String tipo = filtro.ListaTipo.getSelectedItem().toString();
                
                if(sexo.equals("-Seleccionar-") || tipo.equals("-Seleccionar-")){
                    JOptionPane.showMessageDialog(null,"Debe seleccionar una opcion del comboBOX\n"+
                                                                   "       SEXO y una opcion del TIPO");
                    return;
                }else{
                    if(sexo.equals("Macho") && tipo.equals("Lechero")){
                        for (GanadoDTO lista : idActivos) {
                            if(lista.getSexo().equals("Macho") && lista.getTipoGanado().equals("Lechero")){
                                objeto[0] = String.valueOf(lista.getIdGanado());
                                objeto[1] = lista.getFechaNacimiento();
                                if(Años(lista.getEdad()) == true){
                                    objeto[2] = lista.getEdad()+" años";
                                }else{
                                    objeto[2] = lista.getEdad()+" meses";
                                }
                                objeto[3] = lista.getRaza();
                                objeto[4] = lista.getSexo();
                                objeto[5] = lista.getTipoGanado();
                                objeto[6] = lista.getNumeroCrias();
                                model.addRow(objeto);
                            }
                        }
                    }else{
                        if(sexo.equals("Hembra") && tipo.equals("Lechero")){
                            for (GanadoDTO lista : idActivos) {
                            if(lista.getSexo().equals("Hembra") && lista.getTipoGanado().equals("Lechero")){
                                objeto[0] = String.valueOf(lista.getIdGanado());
                                objeto[1] = lista.getFechaNacimiento();
                                if(Años(lista.getEdad()) == true){
                                    objeto[2] = lista.getEdad()+" años";
                                }else{
                                    objeto[2] = lista.getEdad()+" meses";
                                }
                                objeto[3] = lista.getRaza();
                                objeto[4] = lista.getSexo();
                                objeto[5] = lista.getTipoGanado();
                                objeto[6] = lista.getNumeroCrias();
                                model.addRow(objeto);
                            }
                        }
                        }
                    }
                    if(sexo.equals("Macho") && tipo.equals("Engorde")){
                        for (GanadoDTO lista : idActivos) {
                            if(lista.getSexo().equals("Macho") && lista.getTipoGanado().equals("Engorde")){
                                objeto[0] = String.valueOf(lista.getIdGanado());
                                objeto[1] = lista.getFechaNacimiento();
                                if(Años(lista.getEdad()) == true){
                                    objeto[2] = lista.getEdad()+" años";
                                }else{
                                    objeto[2] = lista.getEdad()+" meses";
                                }
                                objeto[3] = lista.getRaza();
                                objeto[4] = lista.getSexo();
                                objeto[5] = lista.getTipoGanado();
                                objeto[6] = lista.getNumeroCrias();
                                model.addRow(objeto);
                            }
                        }
                    }else{
                        if(sexo.equals("Hembra") && tipo.equals("Engorde")){
                            for (GanadoDTO lista : idActivos) {
                            if(lista.getSexo().equals("Hembra") && lista.getTipoGanado().equals("Engorde")){
                                objeto[0] = String.valueOf(lista.getIdGanado());
                                objeto[1] = lista.getFechaNacimiento();
                                if(Años(lista.getEdad()) == true){
                                    objeto[2] = lista.getEdad()+" años";
                                }else{
                                    objeto[2] = lista.getEdad()+" meses";
                                }
                                objeto[3] = lista.getRaza();
                                objeto[4] = lista.getSexo();
                                objeto[5] = lista.getTipoGanado();
                                objeto[6] = lista.getNumeroCrias();
                                model.addRow(objeto);
                            }
                        }
                        }
                    }
                }
                filtro.setVisible(false);
                break;
            case "REGRESAR":
                filtro.setVisible(false);
                break;
        }
    }
}
