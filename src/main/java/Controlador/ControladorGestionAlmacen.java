package Controlador;

import VistaAlmacen.*;
import VistaPaneles.GestionAlmacen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorGestionAlmacen implements ActionListener{
    //Atributos
    GestionAlmacen controlAlmacen;
    VistaAlmacenCosecha controlCosecha;
    VistaAlmacenAlimento controlAlimento;
    
    ControladorPanelesMenuPrincipal principalInterfaz;
    //Constructor

    public ControladorGestionAlmacen(GestionAlmacen controlAlmacen2) {
        this.controlAlmacen = controlAlmacen2;
        controlAlmacen.AlmacenCosecha.addActionListener(this);
        controlAlmacen.AlmacenGanado.addActionListener(this);
    }
    
    //Accion

    @Override
    public void actionPerformed(ActionEvent e) {
        //Atributos
        String accion = e.getActionCommand();
        controlCosecha = new VistaAlmacenCosecha();
        controlAlimento =  new VistaAlmacenAlimento();
        switch(accion){
            case "ALMACEN COSECHA":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlAlmacen.PanelAlmacen,controlCosecha.PanelCosecha );
                ControladorAlmacenCosecha cosecha = new ControladorAlmacenCosecha(controlCosecha);
                break;
            case "ALMACEN GANADO":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlAlmacen.PanelAlmacen,controlAlimento.PanelAlimento);
                ControladorAlmacenAlimento alimento = new ControladorAlmacenAlimento(controlAlimento);
                break;                
        }
    }
}
