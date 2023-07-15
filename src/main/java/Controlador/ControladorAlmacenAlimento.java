package Controlador;

import DTO.AlmacenAlimentoDTO;
import JDBC.AlmacenAlimentoJDBC;
import MySql.Conexion;
import VistaAlmacen.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ControladorAlmacenAlimento implements ActionListener{
    //Atributos
    private final VistaAlmacenAlimento controlAlimento;
    private VistaAlmacenListarAlimento alimento;
    private VistaAlmacenAlimentoCalculo calculo;
    private int id;
    
    private ControladorPanelesMenuPrincipal principalInterfaz;
    private ControladorAccionAlmacenAlimento accionControlAlimento;
    
    //TABLA
    DefaultTableModel model;
    
    String[] objeto;
    
    //LISTAR
    private AlmacenAlimentoDTO activoAlimento;
    private List<AlmacenAlimentoDTO> usuarioAlimento;
    
    //conexion
    private AlmacenAlimentoJDBC almacenAlimento;
    private List<AlmacenAlimentoDTO> listaAlimento;
    
    //Constructor
    public ControladorAlmacenAlimento(VistaAlmacenAlimento controlAlimento3,int id3) {
        this.controlAlimento = controlAlimento3;
        this.id = id3;
        
        controlAlimento.ListarAlimento.addActionListener(this);
        controlAlimento.CalcularAlimento.addActionListener(this);
    }

    //Accion
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Connection conexion = null;
        try {
        conexion = Conexion.getConnection();
        if(conexion.getAutoCommit()){
            conexion.setAutoCommit(false);
        }
        
        almacenAlimento = new AlmacenAlimentoJDBC();
        listaAlimento  = almacenAlimento.seleccionar();
        
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
        
        usuarioAlimento = new ArrayList<>();
        
        //Atributos
        String accion = e.getActionCommand();
        alimento = new VistaAlmacenListarAlimento();
        calculo = new VistaAlmacenAlimentoCalculo();
        switch(accion){
            case "LISTAR ALIMENTO":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlAlimento.PanelLista,alimento.PanelListaAlimento);
                model = (DefaultTableModel) alimento.TablaALimento.getModel();
                objeto = new String[6];
                for (AlmacenAlimentoDTO lista : listaAlimento) {
                    if(lista.getIdPersona() == id){
                        objeto[0] = Integer.toString(lista.getIdalmacenAlimento());
                        objeto[1] = lista.getTipoalimento();
                        objeto[2] = lista.getPesoSaco();
                        objeto[3] = lista.getCantidadSaco();
                        objeto[4] = lista.getPesoTotal();
                        objeto[5] = lista.getFechaEntrega();
                        model.addRow(objeto);
                        activoAlimento = new AlmacenAlimentoDTO(lista.getIdalmacenAlimento(),lista.getIdPersona(),lista.getTipoalimento(),lista.getPesoSaco(),lista.getCantidadSaco(),lista.getPesoTotal(),lista.getFechaEntrega());
                        usuarioAlimento.add(activoAlimento); 
                    }
                }
                accionControlAlimento = new ControladorAccionAlmacenAlimento(alimento,id,usuarioAlimento);
                break;
            case "CALCULAR CONSUMO":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlAlimento.PanelLista,calculo.PanelCalculoAlimento);
                
                break;
        }
    }
}
