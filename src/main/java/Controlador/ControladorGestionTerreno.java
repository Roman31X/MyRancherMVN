package Controlador;

import DTO.CronogramaDTO;
import DTO.TerrenoDTO;
import JDBC.CronogramaJDBC;
import JDBC.TerrenoJDBC;
import MySql.Conexion;
import VistaPaneles.GestionTerreno;
import VistaTerreno.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class ControladorGestionTerreno implements ActionListener{
    //Atributos
    private final GestionTerreno controlTerreno;
    private ControladorPanelesMenuPrincipal principalInterfaz;
    private VistaTablaTerreno controlVista;
    private VistaTablaCronograma controlCronograma;
    private VistaTablaProduccion controlProduccion;
    
    
    private int id;
    DefaultTableModel model;
    DefaultTableModel modeldos;
    String[] objeto;
    String[] objetodos;
    //private List<Integer> idTerreno;
    private TerrenoDTO datosActivos;
    List<TerrenoDTO> idActivos;
    
    TerrenoJDBC terreno;
    List<TerrenoDTO> listaTerreno;
    CronogramaJDBC cronogramaTerreno;
    List<CronogramaDTO> listaCronograma;
    
    //Constructor
    public ControladorGestionTerreno(GestionTerreno controlTerreno2,int id2) {
        this.controlTerreno = controlTerreno2;
        this.id = id2;
        controlTerreno.ListarTerreno.addActionListener(this);
        controlTerreno.Cronograma.addActionListener(this);
        controlTerreno.Produccion.addActionListener(this);
    }
    
    //Accion
    @Override
    public void actionPerformed(ActionEvent e) {
        //Atribbutos
        controlVista = new VistaTablaTerreno();
        controlCronograma = new VistaTablaCronograma();
        controlProduccion = new VistaTablaProduccion();
        
        ControladorAccionCronograma accionCronograma;
        ControladorAccionesListar ListarTerreno;
        
        model = new DefaultTableModel();  
        modeldos = new DefaultTableModel(); 
        Connection conexion = null;
        try {
        conexion = Conexion.getConnection();
        if(conexion.getAutoCommit()){
            conexion.setAutoCommit(false);
        }
        terreno = new TerrenoJDBC();
        listaTerreno  = terreno.seleccionar();
        cronogramaTerreno = new CronogramaJDBC();
        listaCronograma  = cronogramaTerreno.seleccionar();
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
        
        
        //idTerreno = new ArrayList<Integer>();
        idActivos = new ArrayList<>();
        String accion = e.getActionCommand();
        //Accion
        switch(accion){
            case "Listar Terreno":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlTerreno.PanelGestion,controlVista.PanelPropietario );
                model = (DefaultTableModel) controlVista.TablaTerrenoUsuario.getModel();
                objeto = new String[5];
                for(TerrenoDTO lista : listaTerreno){
                    if(lista.getIdPersona() == id){
                        objeto[0] = Integer.toString(lista.getIdterreno());
                        objeto[1] = lista.getPropietario();
                        objeto[2] = lista.getUbicacion();
                        objeto[3] = lista.getHectarea();
                        objeto[4] = lista.getEstadoTerreno();
                        model.addRow(objeto);
                        idTerreno.add(lista.getIdterreno());
                    }
                }
                ListarTerreno = new ControladorAccionesListar(controlVista,id,idTerreno);
                break;
            case "Cronograma de Trabajo":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlTerreno.PanelGestion,controlCronograma.panelCronograma );
                model = (DefaultTableModel) controlCronograma.TablaTerrenoActivo.getModel();
                objeto = new String[5];
                for(TerrenoDTO lista : listaTerreno){
                    if(lista.getIdPersona() == id){
                        if(lista.getEstadoTerreno().equals("Activo")){
                        objeto[0] = Integer.toString(lista.getIdterreno());
                        objeto[1] = lista.getPropietario();
                        objeto[2] = lista.getUbicacion();
                        objeto[3] = lista.getHectarea();
                        objeto[4] = lista.getEstadoTerreno();
                        model.addRow(objeto);
                        int idTerreno = lista.getIdterreno();
                        int idUsuario = lista.getIdPersona();
                        String propietario = lista.getPropietario();
                        String ubicacion = lista.getUbicacion();
                        String hectarea = lista.getHectarea();
                        datosActivos = new TerrenoDTO(idTerreno,idUsuario,propietario,ubicacion,hectarea);
                        idActivos.add(datosActivos);
                        }
                    }
                }
                modeldos = (DefaultTableModel) controlCronograma.TablaCronograma.getModel();
                objetodos = new String[9];
                for(CronogramaDTO lista : listaCronograma){
                    if(lista.getIdPersona() == id){
                            objetodos[0] = Integer.toString(lista.getIdcronograma());
                            objetodos[1] = Integer.toString(lista.getIdterreno());
                            objetodos[2] = lista.getPropietario();
                            objetodos[3] = lista.getUbicacion();
                            objetodos[4] = lista.getHectarea();
                            objetodos[5] = lista.getFechactividad();
                            objetodos[6] = lista.getActividad();
                            objetodos[7] = lista.getCultivo();
                            objetodos[8] = lista.getEstadoCronograma();
                            modeldos.addRow(objetodos);
                    }
                }
                
                accionCronograma = new ControladorAccionCronograma(controlCronograma,id,idActivos);
                
                break;
            case "Produccion":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlTerreno.PanelGestion,controlProduccion.panelProduccion );
                
                
                break;
        }
    }
    
    
}
