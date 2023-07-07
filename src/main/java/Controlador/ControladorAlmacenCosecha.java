package Controlador;

import VistaAlmacen.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAlmacenCosecha implements ActionListener{
    //Atributos
    VistaAlmacenCosecha controlCosecha;
    VistaAlmacenListaCosecha panelCosecha;
    VistaAlmacenListaForraje panelForraje;
    ControladorPanelesMenuPrincipal principalInterfaz;
    //Constructor
    public ControladorAlmacenCosecha(VistaAlmacenCosecha controlCosecha3) {
        this.controlCosecha = controlCosecha3;
        controlCosecha.ListarForraje.addActionListener(this);
        controlCosecha.ListarCosecha.addActionListener(this);
    }
    
    //Accion
    @Override
    public void actionPerformed(ActionEvent e) {
        //Atributos
        String accion = e.getActionCommand();
        panelForraje = new VistaAlmacenListaForraje();
        panelCosecha = new VistaAlmacenListaCosecha();
        
        switch(accion){
            case "LISTAR FORRAJE":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlCosecha.PanelListaCosecha,panelForraje.PanelForraje);
                break;
            case "LISTAR COSECHA":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlCosecha.PanelListaCosecha,panelCosecha.PanelCosecha);
                break;
        }        
    }
}
