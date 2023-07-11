package Controlador;

import DTO.GanadoDTO;
import VistaGanado.VistaEliminarGanado;
import VistaGanado.VistaFiltroGanado;
import VistaGanado.VistaListarGanado;
import VistaGanado.VistaModificarGanado;
import java.awt.event.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ControladorAccionListarGanado implements ActionListener{
    private final VistaListarGanado controlGanado;
    private VistaEliminarGanado controlEliminar;
    private VistaFiltroGanado filtro;
    int id;
    private List<GanadoDTO> idActivos;
    
    private VistaModificarGanado vistaModificar;
    ControladorModificarGanado controlModificar;
    ControladorEliminarGanado controlBorrar;
    ControladorFiltroGanado filtrarGanado;

    public ControladorAccionListarGanado(VistaListarGanado controlGanado2, int id2,List<GanadoDTO> idActivos2) {
        this.controlGanado = controlGanado2;
        this.id = id2;
        this.idActivos = idActivos2;
        
        controlGanado.Modificar.addActionListener(this);
        controlGanado.Eliminar.addActionListener(this);
        controlGanado.Filtrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        vistaModificar = new VistaModificarGanado();
        controlEliminar = new VistaEliminarGanado();
        filtro = new VistaFiltroGanado();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "MODIFICAR":
                for (GanadoDTO lista : idActivos) {
                    vistaModificar.IDGanado.addItem(String.valueOf(lista.getIdGanado()));
                }
                controlModificar = new ControladorModificarGanado(vistaModificar,id,idActivos);
                controlModificar.Mostrar();
                break;
            case "ELIMINAR":
                for (GanadoDTO lista : idActivos) {
                    controlEliminar.ListaID.addItem(String.valueOf(lista.getIdGanado()));
                }
                controlBorrar = new ControladorEliminarGanado(controlEliminar);
                controlBorrar.Mostrar();
                break;
            case "FILTRAR":
                filtrarGanado = new ControladorFiltroGanado(controlGanado,filtro,idActivos);
                filtrarGanado.Mostrar();
                break;
        }
    }
}
