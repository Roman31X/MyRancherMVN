package Controlador;

import DTO.*;
import JDBC.*;
import MySql.Conexion;
import VistaGanado.*;
import VistaPaneles.GestionGanado;
import VistaRegistro.RegistroGanado;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class ControladorGestionGanado implements ActionListener{
    //Atributos
    private final GestionGanado controlGanado;
    private RegistroGanado registroGanado;
    private VistaListarGanado ganado;
    private VistaProduccionGanado productoGanado;
    private int id;
    private String hoy;
    
    DefaultTableModel model;
    DefaultTableModel model1;
    
    String[] objeto;
    String[] objeto1;
    
    //Datos conexion
    GanadoJDBC todoGanado;
    List<GanadoDTO> listaGanado;
    ProductoGanadoJDBC todoProducto;
    List<ProductoGanadoDTO> listaProducto;
    
    //Enviar datos modificar
    private List<GanadoDTO> idGanado;
    private GanadoDTO datosActivos;
    
    private ControladorPanelesMenuPrincipal principalInterfaz; 
    private ControladorRegistroGanado controlRegistro;
    private ControladorAccionListarGanado modificarGanado;
        
    //Constructor
    public ControladorGestionGanado(GestionGanado controlGanado3,int id3) {
        this.controlGanado = controlGanado3;
        this.id = id3;
        
        controlGanado.RegistroGanado.addActionListener(this);
        controlGanado.ListarGanado.addActionListener(this);
        controlGanado.ProduccionGanado.addActionListener(this);
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
    
    //Accion
    @Override
    public void actionPerformed(ActionEvent e) {
        registroGanado = new RegistroGanado();
        ganado = new VistaListarGanado();
        productoGanado = new VistaProduccionGanado();
        
        //Dato almacenado
        idGanado = new ArrayList<>();
        
        Connection conexion = null;
        
        try{
        conexion = Conexion.getConnection();
        if(conexion.getAutoCommit()){
            conexion.setAutoCommit(false);
        }
        todoGanado = new GanadoJDBC();
        listaGanado  = todoGanado.seleccionar();
        todoProducto = new ProductoGanadoJDBC();
        listaProducto = todoProducto.seleccionar();
        
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
                        datosActivos = new GanadoDTO(lista.getIdGanado(),lista.getIdPersona(),lista.getFechaNacimiento(),lista.getEdad(),lista.getRaza(),lista.getSexo(),lista.getTipoGanado(),lista.getNumeroCrias());
                        idGanado.add(datosActivos);
                    }
                }
                modificarGanado = new ControladorAccionListarGanado(ganado,id,idGanado);
                break;
            case "PRODUCCION GANADO":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlGanado.PanelGanado, productoGanado.PanelProduccion);
                model1 = (DefaultTableModel) productoGanado.TablaProduccion.getModel();
                objeto1 = new String[4];
                for (ProductoGanadoDTO lista : listaProducto) {
                    if(lista.getIdPersona() == id){
                        objeto1[0] = String.valueOf(lista.getIdproduccionGanado());
                        objeto1[1] = lista.getProducto();
                        objeto1[2] = lista.getMes();
                        objeto1[3] = lista.getGanancia();
                        model1.addRow(objeto1);
                    }
                }
                break;
        }
    }
}
