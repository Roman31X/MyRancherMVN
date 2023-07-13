package Controlador;

import DTO.AlmacenForrajeDTO;
import VistaAlmacen.VistaAlmacenListaForraje;
import java.awt.event.*;
import java.util.*;

public class ControladorAccionAlmacenForraje implements ActionListener{
    private VistaAlmacenListaForraje controlForraje;
    private int id;
    private List<AlmacenForrajeDTO> listaForraje;

    public ControladorAccionAlmacenForraje(VistaAlmacenListaForraje controlForraje1, int id1, List<AlmacenForrajeDTO> listaForraje1) {
        this.controlForraje = controlForraje1;
        this.id = id1;
        this.listaForraje = listaForraje1;
        
        controlForraje.Agregar.addActionListener(this);
        controlForraje.Modificar.addActionListener(this);
        controlForraje.Eliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        switch(accion){
            case "REGISTRAR":
                break;
            case "MODIFICAR":
                break;
            case "ELIMINAR":
                break;
        }            
    }
}
