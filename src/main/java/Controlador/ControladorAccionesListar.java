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
        String accion = e.getActionCommand();
        nuevoTerreno = new RegistroTerreno();
        eliminarTerreno = new VistaEliminarTerreno();
        modificarTerreno = new VistaModificarTerreno();
        
        ControladorRegistroTerreno registrar;
        ControladorModificarTerreno modificar;
        ControladorElimnarTerreno eliminar;
        
        switch(accion){
            case "REGISTRAR":
                registrar = new ControladorRegistroTerreno(nuevoTerreno,id);
                registrar.Mostrar();
                break;
            case "MODIFICAR":
                for (TerrenoDTO lista : idTerreno) {
                    modificarTerreno.IDBOX.addItem(Integer.toString(lista.getIdterreno()));
                }
                modificar = new ControladorModificarTerreno(modificarTerreno,idTerreno);
                modificar.Mostrar();
                break;
            case "ELIMINAR":
                for (TerrenoDTO lista : idTerreno) {
                    eliminarTerreno.ListaID.addItem(Integer.toString(lista.getIdterreno()));
                    System.out.println("lista = " + lista.getIdterreno());
                }
                eliminar = new ControladorElimnarTerreno(eliminarTerreno,idTerreno);
                
                eliminar.Mostrar();
                break;
        }
    }
}
