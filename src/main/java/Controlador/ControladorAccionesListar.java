package Controlador;

import DTO.TerrenoDTO;
import VistaRegistro.RegistroTerreno;
import VistaTerreno.*;
import java.awt.event.*;
import java.util.List;

public class ControladorAccionesListar implements ActionListener{
    private final VistaTablaTerreno listaTerreno;
    private RegistroTerreno nuevoTerreno;
    private VistaEliminarTerreno eliminarTerreno;
    private VistaModificarTerreno modificarTerreno;
    
    private final List<TerrenoDTO> idTerreno;
    private int id;

    private ControladorRegistroTerreno registrar;
    private ControladorModificarTerreno modificar;
    private ControladorElimnarTerreno eliminar;
        
    public ControladorAccionesListar(VistaTablaTerreno listaTerreno2, int id2,List<TerrenoDTO> idTerreno2 ) {
        this.listaTerreno = listaTerreno2;
        this.idTerreno = idTerreno2;
        this.id = id2;
        
        listaTerreno.Registrar.addActionListener(this);
        listaTerreno.Modificar.addActionListener(this);
        listaTerreno.Eliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        nuevoTerreno = new RegistroTerreno();
        eliminarTerreno = new VistaEliminarTerreno();
        modificarTerreno = new VistaModificarTerreno();
        
        String accion = e.getActionCommand();        
        switch(accion){
            case "REGISTRAR":
                registrar = new ControladorRegistroTerreno(nuevoTerreno,id);
                registrar.Mostrar();
                break;
            case "MODIFICAR":
                for (TerrenoDTO lista : idTerreno) {
                    modificarTerreno.IDBOX.addItem(Integer.toString(lista.getIdterreno()));
                }
                modificar = new ControladorModificarTerreno(modificarTerreno,id,idTerreno);
                modificar.Mostrar();
                break;
            case "ELIMINAR":
                for (TerrenoDTO lista : idTerreno) {
                    eliminarTerreno.ListaID.addItem(Integer.toString(lista.getIdterreno()));
                }
                eliminar = new ControladorElimnarTerreno(eliminarTerreno);
                eliminar.Mostrar();
                break;
        }
    }
}
