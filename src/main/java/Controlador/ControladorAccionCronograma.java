package Controlador;

import DTO.TerrenoDTO;
import VistaRegistro.RegistroCronograma;
import VistaTerreno.VistaTablaCronograma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorAccionCronograma implements ActionListener{
    private final VistaTablaCronograma controlCronograma;
    private RegistroCronograma nuevoRegistro;
    
    int id;
    private final List<TerrenoDTO> idActivos;

    public ControladorAccionCronograma(VistaTablaCronograma controlCronograma1, int id1, List<TerrenoDTO> idActivos1) {
        this.controlCronograma = controlCronograma1;
        this.id = id1;
        this.idActivos = idActivos1;
        
        controlCronograma.ListarActividad.addActionListener(this);
        controlCronograma.Registrar.addActionListener(this);
        controlCronograma.Eliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nuevoRegistro = new RegistroCronograma();
        ControladorRegistroCronograma registrar;
        
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
                for (int i = 0; i < idActivos.size(); i++) {
                    System.out.println(idActivos.get(i).getHectarea());                    
                }
                break;
            case "ELIMINAR":
                System.out.println("eliminado X");
                break;
        }
    }
    
    
    
}
