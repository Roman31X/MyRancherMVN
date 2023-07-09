package Controlador;

import DTO.*;
import VistaRegistro.RegistroCronograma;
import VistaTerreno.*;
import java.awt.event.*;
import java.util.List;

public class ControladorAccionCronograma implements ActionListener{
    private final VistaTablaCronograma controlCronograma;
    private RegistroCronograma nuevoRegistro;
    private VistaModificarCronograma modificarCronograma;
    private VistaEliminarCronograma eliminarCronograma;
    
    int id;
    private final List<TerrenoDTO> idActivos;
    private final List<CronogramaDTO> ActivosCronograma;

    public ControladorAccionCronograma(VistaTablaCronograma controlCronograma1, int id1, List<TerrenoDTO> idActivos1,List<CronogramaDTO> ActivosCronograma1) {
        this.controlCronograma = controlCronograma1;
        this.id = id1;
        this.idActivos = idActivos1;
        this.ActivosCronograma = ActivosCronograma1;
        
        controlCronograma.ListarActividad.addActionListener(this);
        controlCronograma.Registrar.addActionListener(this);
        controlCronograma.Eliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nuevoRegistro = new RegistroCronograma();
        modificarCronograma = new VistaModificarCronograma ();
        eliminarCronograma = new VistaEliminarCronograma();
        
        ControladorRegistroCronograma registrar;
        ControladorModificarCronograma modificar;
        ControladorEliminarCronograma eliminar;
        
        String accion = e.getActionCommand();
        switch(accion){
            case "REGISTRAR":
                for (TerrenoDTO primero : idActivos) {
                    nuevoRegistro.boxID.addItem(Integer.toString(primero.getIdterreno()));
                }
                registrar = new ControladorRegistroCronograma(nuevoRegistro,id,idActivos);
                registrar.Mostrar();
                break;
            case "MODIFICAR":
                for (CronogramaDTO segundo : ActivosCronograma) {
                    modificarCronograma.boxID.addItem(Integer.toString(segundo.getIdcronograma()));
                }
                modificar = new ControladorModificarCronograma(modificarCronograma,id,ActivosCronograma);
                modificar.Mostrar();
                break;
            case "ELIMINAR":
                for (CronogramaDTO segundo : ActivosCronograma) {
                    eliminarCronograma.ListaID.addItem(Integer.toString(segundo.getIdcronograma()));
                }
                eliminar = new ControladorEliminarCronograma(eliminarCronograma);
                eliminar.Mostrar();
                break;
        }
    }
    
    
    
}
