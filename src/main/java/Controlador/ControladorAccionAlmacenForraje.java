package Controlador;

import DTO.AlmacenForrajeDTO;
import DTO.TerrenoDTO;
import VistaAlmacen.*;
import VistaRegistro.RegistroForraje;
import java.awt.event.*;
import java.util.*;

public class ControladorAccionAlmacenForraje implements ActionListener{
    private VistaAlmacenListaForraje controlForraje;
    private RegistroForraje controlRegistro;
    private VistaEliminarForraje controlforraje;
    private int id;
    private List<AlmacenForrajeDTO> listaForraje;
    private List<TerrenoDTO> listaTerreno;

    private ControladorRegistroForraje accionRegistrar;
    private ControladorEliminarForraje accioneliminar;
    
    public ControladorAccionAlmacenForraje(VistaAlmacenListaForraje controlForraje1, int id1, List<AlmacenForrajeDTO> listaForraje1,List<TerrenoDTO> listaTerreno1) {
        this.controlForraje = controlForraje1;
        this.id = id1;
        this.listaForraje = listaForraje1;
        this.listaTerreno = listaTerreno1;
        
        controlForraje.Agregar.addActionListener(this);
        controlForraje.Modificar.addActionListener(this);
        controlForraje.Eliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controlRegistro = new RegistroForraje();
        controlforraje = new VistaEliminarForraje();
                
        String accion = e.getActionCommand();
        switch(accion){
            case "REGISTRAR":
                for (TerrenoDTO lista : listaTerreno) {
                    controlRegistro.IDterreno.addItem(String.valueOf(lista.getIdterreno()));
                }
                accionRegistrar = new ControladorRegistroForraje(controlRegistro,id,listaTerreno);
                accionRegistrar.Mostrar();
                break;
            case "MODIFICAR":
                break;
            case "ELIMINAR":
                for (AlmacenForrajeDTO lista : listaForraje) {
                    controlforraje.ListaID.addItem(String.valueOf(lista.getIdalmacenforraje()));
                }
                accioneliminar = new ControladorEliminarForraje(controlforraje);
                accioneliminar.Mostrar();
                break;
        }            
    }
}
