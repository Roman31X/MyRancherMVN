package Controlador;

import VistaRegistro.RegistroTerreno;
import VistaTerreno.VistaEliminarTerreno;
import VistaTerreno.VistaTablaTerreno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorAccionesListar implements ActionListener{
    private final VistaTablaTerreno listaTerreno;
    private RegistroTerreno nuevoTerreno;
    private VistaEliminarTerreno eliminarTerreno;
    
    //private final List<Integer> idTerreno;
    private int id;

    public ControladorAccionesListar(VistaTablaTerreno listaTerreno2, int id2,List<Integer> idTerreno2 ) {
        this.listaTerreno = listaTerreno2;
        this.idTerreno = idTerreno2;
        this.id = id2;
        
        listaTerreno.Registrar.addActionListener(this);
        listaTerreno.Eliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        nuevoTerreno = new RegistroTerreno();
        eliminarTerreno = new VistaEliminarTerreno();
        ControladorRegistroTerreno registrar;
        
        switch(accion){
            case "REGISTRAR":
                registrar = new ControladorRegistroTerreno(nuevoTerreno,id);
                registrar.Mostrar();
                break;
            case "MODIFICAR":
                
                break;
            case "ELIMINAR":
                ControladorElimnarTerreno eliminar = new ControladorElimnarTerreno(eliminarTerreno,idTerreno);
                for (int i = 0; i < idTerreno.size(); i++) {
                    eliminarTerreno.ListaID.addItem(Integer.toString(idTerreno.get(i)));
                }
                eliminar.Mostrar();
                break;
        }
    }
}
