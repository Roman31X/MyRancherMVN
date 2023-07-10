package Controlador;

import DTO.CronogramaDTO;
import DTO.ProduccionDTO;
import DTO.TerrenoDTO;
import JDBC.CronogramaJDBC;
import JDBC.ProduccionJDBC;
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
    
    
    private final int id;
    DefaultTableModel model;
    DefaultTableModel modeldos;
    DefaultTableModel modeltres;
    
    String[] objeto;
    String[] objetodos;
    String[] objetotres;
    
    //Listar
    private List<TerrenoDTO> idTerreno;
    private TerrenoDTO datosActivos;
    
    //Cronograma
    private List<TerrenoDTO> idActivos;
    private List<CronogramaDTO> idActivosCronograma;
    private CronogramaDTO informacionCronograma;
    
    //Produccion
    private List<ProduccionDTO> idActivosProduccion;
    private ProduccionDTO informacionProduccion;
    
    //Conexion
    private TerrenoJDBC terreno;
    private List<TerrenoDTO> listaTerreno;
    private CronogramaJDBC cronogramaTerreno;
    private List<CronogramaDTO> listaCronograma;
    private ProduccionJDBC produccio;
    private List<ProduccionDTO> listaProduccion;
    
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
        
        ControladorAccionesListar ListarTerreno;
        ControladorAccionCronograma accionCronograma;        
        ControladorAccionProduccion accionProduccion;
        
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
        produccio = new ProduccionJDBC();
        listaProduccion = produccio.seleccionar();
        
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
        
        
        idTerreno = new ArrayList<>();
        idActivos = new ArrayList<>();
        idActivosCronograma = new ArrayList<>();
        idActivosProduccion = new ArrayList<>();
        
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
                        
                        datosActivos = new TerrenoDTO(lista.getIdterreno(),lista.getIdPersona(),lista.getPropietario(),lista.getUbicacion(),lista.getHectarea(),lista.getEstadoTerreno());
                        
                        idTerreno.add(datosActivos);
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
                        datosActivos = new TerrenoDTO(lista.getIdterreno(),lista.getIdPersona(),lista.getPropietario(),lista.getUbicacion(),lista.getHectarea());
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
                            informacionCronograma = new CronogramaDTO(lista.getIdcronograma(),lista.getIdterreno(),lista.getIdPersona(),lista.getPropietario(),lista.getUbicacion(),lista.getHectarea(),lista.getFechactividad(),lista.getActividad(),lista.getCultivo(),lista.getEstadoCronograma());
                            idActivosCronograma.add(informacionCronograma);
                    }
                }
                
                accionCronograma = new ControladorAccionCronograma(controlCronograma,id,idActivos,idActivosCronograma);
                
                break;
            case "Produccion":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlTerreno.PanelGestion,controlProduccion.panelProduccion );
                modeltres = (DefaultTableModel) controlProduccion.TablaCosecha.getModel();
                objetotres = new String[10];
                for(ProduccionDTO lista : listaProduccion){
                    if(lista.getIdPersona() == id){
                        objetotres[0] = Integer.toString(lista.getIdregistrocosecha());
                        objetotres[1] = Integer.toString(lista.getIdterreno());
                        objetotres[2] = lista.getPropietario();
                        objetotres[3] = lista.getUbicacion();
                        objetotres[4] = lista.getHectarea();
                        objetotres[5] = lista.getCosecha();
                        objetotres[6] = lista.getPesocosecha();
                        objetotres[7] = lista.getPrecio();
                        objetotres[8] = lista.getGanacia();
                        objetotres[9] = lista.getFechaincriccion();
                        modeltres.addRow(objetotres);
                        informacionProduccion = new ProduccionDTO(lista.getIdregistrocosecha(),lista.getIdterreno(),lista.getIdPersona(),lista.getPropietario(),lista.getUbicacion(),lista.getHectarea(),lista.getCosecha(),lista.getPesocosecha(),lista.getPrecio(),lista.getGanacia(),lista.getFechaincriccion());
                        idActivosProduccion.add( informacionProduccion);
                    }
                }
                for(TerrenoDTO lista : listaTerreno){
                    if(lista.getIdPersona() == id){                        
                        datosActivos = new TerrenoDTO(lista.getIdterreno(),lista.getIdPersona(),lista.getPropietario(),lista.getUbicacion(),lista.getHectarea());
                        idTerreno.add(datosActivos);
                        
                    }
                }
                accionProduccion = new ControladorAccionProduccion(controlProduccion,id,idActivosProduccion,idTerreno);
                break;
        }
    }
    
    
}
