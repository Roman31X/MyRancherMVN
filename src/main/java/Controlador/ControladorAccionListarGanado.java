package Controlador;

import DTO.GanadoDTO;
import VistaGanado.VistaListarGanado;
import VistaGanado.VistaModificarGanado;
import java.awt.event.*;
import java.util.List;

public class ControladorAccionListarGanado implements ActionListener{
    private VistaListarGanado controlGanado;
    int id;
    private List<GanadoDTO> idActivos;
    
    private VistaModificarGanado vistaModificar;
    ControladorModificarGanado controlModificar;

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
                break;
            case "FILTRAR":
                break;
        }
    }
}
