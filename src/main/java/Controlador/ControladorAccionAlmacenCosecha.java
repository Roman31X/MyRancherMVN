package Controlador;

import DTO.*;
import VistaAlmacen.*;
import VistaRegistro.RegistroCosecha;
import java.awt.event.*;
import java.util.List;

public class ControladorAccionAlmacenCosecha implements ActionListener{
    private VistaAlmacenListaCosecha controlCosecha;
    private RegistroCosecha registro;
    private VistaModificarCosecha modificar;
    private VistaEliminarCosecha eliminar;
    
    private int id;
    private List<TerrenoDTO> listaTerreno;
    private List<AlmacenCosechaDTO> listaCosecha;
    
    ControladorRegistroCosecha accionRegistrar;
    ControladorModificarCosecha accionModificar;
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

    //Acciones
    @Override
    public void actionPerformed(ActionEvent e) {
        
        registro = new RegistroCosecha();
        modificar = new VistaModificarCosecha();
        eliminar = new VistaEliminarCosecha();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "AGREGAR":
                for (TerrenoDTO lista : listaTerreno) {
                    registro.IDterreno.addItem(String.valueOf(lista.getIdterreno()));
                }
                accionRegistrar = new ControladorRegistroCosecha(registro,id,listaTerreno);
                accionRegistrar.Mostrar();
                break;
            case "MODIFICAR":
                for (TerrenoDTO lista : listaTerreno) {
                    modificar.IDterreno.addItem(String.valueOf(lista.getIdterreno()));
                }
                
                for (AlmacenCosechaDTO lista : listaCosecha) {
                    modificar.IDForraje.addItem(String.valueOf(lista.getIdalmacenCosecha()));
                }
                accionModificar = new ControladorModificarCosecha(modificar,id,listaCosecha,listaTerreno);
                accionModificar.Mostrar();
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
