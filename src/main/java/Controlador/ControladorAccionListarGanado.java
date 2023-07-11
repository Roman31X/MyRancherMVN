package Controlador;

import DTO.GanadoDTO;
import VistaGanado.VistaEliminarGanado;
import VistaGanado.VistaListarGanado;
import VistaGanado.VistaModificarGanado;
import java.awt.event.*;
import java.util.List;

public class ControladorAccionListarGanado implements ActionListener{
    private final VistaListarGanado controlGanado;
    private VistaEliminarGanado controlEliminar;
    int id;
    private List<GanadoDTO> idActivos;
    
    private VistaModificarGanado vistaModificar;
    ControladorModificarGanado controlModificar;
    ControladorEliminarGanado controlBorrar;

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
                break;
        }
    }
}
