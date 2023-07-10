package Controlador;

import DTO.GanadoDTO;
import JDBC.GanadoJDBC;
import MySql.Conexion;
import VistaGanado.*;
import VistaPaneles.GestionGanado;
import VistaRegistro.RegistroGanado;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ControladorGestionGanado implements ActionListener{
    //Atributos
    GestionGanado controlGanado;
    RegistroGanado registroGanado;
    VistaListarGanado ganado;
    VistaProduccionGanado productoGanado;
    int id;
    String hoy;
    
    DefaultTableModel model;
    
    String[] objeto;
    
    private GanadoJDBC todoGanado;
    private List<GanadoDTO> listaGanado;
    
    ControladorPanelesMenuPrincipal principalInterfaz;    
    //Constructor
    public ControladorGestionGanado(GestionGanado controlGanado3,int id3) {
        this.controlGanado = controlGanado3;
        this.id = id3;
        
        controlGanado.RegistroGanado.addActionListener(this);
        controlGanado.ListarGanado.addActionListener(this);
        controlGanado.ProduccionGanado.addActionListener(this);
    }
    
    //Accion

    @Override
    public void actionPerformed(ActionEvent e) {
        registroGanado = new RegistroGanado();
        ganado = new VistaListarGanado();
        productoGanado = new VistaProduccionGanado();
        
        ControladorRegistroGanado controlRegistro;
        Connection conexion = null;
        
        try{
        conexion = Conexion.getConnection();
        if(conexion.getAutoCommit()){
            conexion.setAutoCommit(false);
        }
        todoGanado = new GanadoJDBC();
        listaGanado  = todoGanado.seleccionar();
        conexion.commit();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Sucedio un error al rollback");
            try {
                conexion.rollback();
            } catch (SQLException exx) {
                exx.printStackTrace(System.out);
            }
        }
        
        
        String accion = e.getActionCommand();
        switch(accion){
            case "REGISTRO GANADO":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlGanado.PanelGanado, registroGanado.PanelRegistroGanado);
                java.util.Date fechaHoy = new java.util.Date();
                SimpleDateFormat nuevaFecha = new SimpleDateFormat("dd/MM/yyyy");
                hoy = nuevaFecha.format(fechaHoy);
                registroGanado.FechaNacimineto.setText(hoy);
                controlRegistro = new ControladorRegistroGanado(registroGanado,id);
                break;
            case "LISTAR GANADO":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlGanado.PanelGanado, ganado.PanelListaGanado);
                model = (DefaultTableModel) ganado.Tablaganado.getModel();
                objeto = new String[7];
                for (GanadoDTO lista : listaGanado) {
                    if(lista.getIdPersona() == id){
                        objeto[0] = String.valueOf(lista.getIdGanado());
                        objeto[1] = lista.getFechaNacimiento();
                        objeto[2] = lista.getEdad()+" años";
                        objeto[3] = lista.getRaza();
                        objeto[4] = lista.getSexo();
                        objeto[5] = lista.getTipoGanado();
                        objeto[6] = lista.getNumeroCrias();
                        model.addRow(objeto);
                    }
                }
                
                
                break;
            case "PRODUCCION GANADO":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlGanado.PanelGanado, productoGanado.PanelProduccion);
                break;
        }
    }
}
