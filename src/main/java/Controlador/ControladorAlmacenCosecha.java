package Controlador;

import DTO.*;
import JDBC.*;
import MySql.Conexion;
import VistaAlmacen.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class ControladorAlmacenCosecha implements ActionListener{
    //Atributos
    private final VistaAlmacenCosecha controlCosecha;
    private VistaAlmacenListaCosecha panelCosecha;
    private VistaAlmacenListaForraje panelForraje;
    private int id;
    
    private ControladorPanelesMenuPrincipal principalInterfaz;
    private ControladorAccionAlmacenForraje accionForraje;
    private ControladorAccionAlmacenCosecha accionCosecha;
    
    //TABLA
    DefaultTableModel model;
    DefaultTableModel model2;
    
    String[] objeto;
    String[] objeto2;
    
    //DATOS REGISTRO
    private List<TerrenoDTO> idTerreno;
    private TerrenoDTO datosActivos;    
    private AlmacenForrajeDTO activoForraje;
    private List<AlmacenForrajeDTO> usuarioForraje;
    private AlmacenCosechaDTO activoCosecha;
    private List<AlmacenCosechaDTO> usuarioCosecha;
    
    private TerrenoJDBC terreno;
    private List<TerrenoDTO> listaTerreno;
    private AlmacenForrajeJDBC forraje;
    private List<AlmacenForrajeDTO> listaForraje;
    private AlmacenCosechaJDBC cosecha;
    private List<AlmacenCosechaDTO> listaCosecha;
    
    public ControladorAlmacenCosecha(VistaAlmacenCosecha controlCosecha3,int id3) {
        this.controlCosecha = controlCosecha3;
        this.id = id3;
        
        controlCosecha.ListarForraje.addActionListener(this);
        controlCosecha.ListarCosecha.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        panelForraje = new VistaAlmacenListaForraje();
        panelCosecha = new VistaAlmacenListaCosecha();
        
        model = new DefaultTableModel(); 
        model2 = new DefaultTableModel();
        
        Connection conexion = null;
        try {
        conexion = Conexion.getConnection();
        if(conexion.getAutoCommit()){
            conexion.setAutoCommit(false);
        }
        
        terreno = new TerrenoJDBC();
        listaTerreno  = terreno.seleccionar();
        forraje = new AlmacenForrajeJDBC();
        listaForraje = forraje.seleccionar();
        cosecha = new AlmacenCosechaJDBC();
        listaCosecha = cosecha.seleccionar();
        
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
        
        usuarioForraje = new ArrayList<>();
        idTerreno = new ArrayList<>();
        usuarioCosecha = new ArrayList<>();
        
        //Seleccion Terreno Usuario
        for (TerrenoDTO lista : listaTerreno) {
            if(lista.getIdPersona() == id){
                datosActivos = new TerrenoDTO(lista.getIdterreno(),lista.getIdPersona(),lista.getPropietario(),lista.getUbicacion(),lista.getHectarea());
                idTerreno.add(datosActivos);
            }
        }
        
        switch(accion){
            case "LISTAR FORRAJE":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlCosecha.PanelListaCosecha,panelForraje.PanelForraje);
                model = (DefaultTableModel) panelForraje.TablaForraje.getModel();
                objeto = new String[7];
                for (AlmacenForrajeDTO lista : listaForraje) {
                    if(lista.getIdPersona() == id){
                        objeto[0] = Integer.toString(lista.getIdalmacenforraje());
                        objeto[1] = Integer.toString(lista.getIdterreno());
                        objeto[2] = lista.getForraje();
                        objeto[3] = lista.getMuestra1();
                        objeto[4] = lista.getMuestra2();
                        objeto[5] = lista.getDimencion();
                        objeto[6] = lista.getPesogenerado();
                        model.addRow(objeto);
                        activoForraje = new AlmacenForrajeDTO(lista.getIdalmacenforraje(),lista.getIdterreno(),lista.getIdPersona(),lista.getForraje(),lista.getMuestra1(),lista.getMuestra2(),lista.getDimencion(),lista.getPesogenerado());
                        usuarioForraje.add(activoForraje);
                    }
                }
                accionForraje = new ControladorAccionAlmacenForraje(panelForraje,id,usuarioForraje,idTerreno);
                break;
            case "LISTAR COSECHA":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlCosecha.PanelListaCosecha,panelCosecha.PanelCosecha);
                model2 = (DefaultTableModel) panelCosecha.TablaCosecha.getModel();
                objeto2 = new String[6];
                for (AlmacenCosechaDTO lista : listaCosecha) {
                    if(lista.getIdPersona() == id){
                        objeto2[0] = Integer.toString(lista.getIdalmacenCosecha());
                        objeto2[1] = Integer.toString(lista.getIdterreno());
                        objeto2[2] = lista.getProducto();
                        objeto2[3] = lista.getPeso();
                        objeto2[4] = lista.getDimension();
                        objeto2[5] = lista.getFecha();
                        model2.addRow(objeto2);
                        activoCosecha = new AlmacenCosechaDTO(lista.getIdalmacenCosecha(),lista.getIdterreno(),lista.getIdPersona(),lista.getProducto(),lista.getPeso(),lista.getDimension(),lista.getFecha());
                        usuarioCosecha.add(activoCosecha);
                    }
                }
                accionCosecha = new ControladorAccionAlmacenCosecha(panelCosecha,id,idTerreno,usuarioCosecha);
                break;
        }        
    }
}
