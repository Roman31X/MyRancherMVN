package Controlador;

import DTO.*;
import VistaAlmacen.VistaAlmacenListaCosecha;
import VistaAlmacen.VistaEliminarCosecha;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorAccionAlmacenCosecha implements ActionListener{
    private VistaAlmacenListaCosecha controlCosecha;
    
    private VistaEliminarCosecha eliminar;
    
    private int id;
    private List<TerrenoDTO> listaTerreno;
    private List<AlmacenCosechaDTO> listaCosecha;
    
    ControladorEliminarCosecha accionEliminar;

    public ControladorAccionAlmacenCosecha(VistaAlmacenListaCosecha controlCosecha2, int id2, List<TerrenoDTO> listaTerreno2,List<AlmacenCosechaDTO> listaCosecha2) {
        this.controlCosecha = controlCosecha2;
        this.id = id2;
        this.listaTerreno = listaTerreno2;
        this.listaCosecha = listaCosecha2;
        
        controlCosecha.Agregar.addActionListener(this);
        controlCosecha.Modificar.addActionListener(this);
        controlCosecha.Eliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        eliminar = new VistaEliminarCosecha();
        
        String accion = e.getActionCommand();
        System.out.println("accion = " + accion);
        switch(accion){
            case "AGREGAR":
                break;
            case "MODIFICAR":
                break;
            case "ELIMINAR":
                for (AlmacenCosechaDTO lista : listaCosecha) {
                    eliminar.ListaID.addItem(String.valueOf(lista.getIdalmacenCosecha()));
                }
                accionEliminar = new ControladorEliminarCosecha(eliminar);
                accionEliminar.Mostrar();
                break;
        }
    }
}
