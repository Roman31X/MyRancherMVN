package Controlador;

import VistaAlmacen.*;
import VistaPaneles.GestionAlmacen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorGestionAlmacen implements ActionListener{
    private final GestionAlmacen controlAlmacen;
    private VistaAlmacenCosecha controlCosecha;
    private VistaAlmacenAlimento controlAlimento;
    int id;
    
    private ControladorPanelesMenuPrincipal principalInterfaz;
    private ControladorAlmacenCosecha cosecha;
    private ControladorAlmacenAlimento alimento;

    public ControladorGestionAlmacen(GestionAlmacen controlAlmacen2,int id2) {
        this.controlAlmacen = controlAlmacen2;
        this.id = id2;
        controlAlmacen.AlmacenCosecha.addActionListener(this);
        controlAlmacen.AlmacenGanado.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        controlCosecha = new VistaAlmacenCosecha();
        controlAlimento =  new VistaAlmacenAlimento();
        
        //Atributos
        String accion = e.getActionCommand();
        switch(accion){
            case "ALMACEN COSECHA":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlAlmacen.PanelAlmacen,controlCosecha.PanelCosecha );
                cosecha = new ControladorAlmacenCosecha(controlCosecha,id);
                break;
            case "ALMACEN GANADO":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlAlmacen.PanelAlmacen,controlAlimento.PanelAlimento);
                alimento = new ControladorAlmacenAlimento(controlAlimento,id);
                break;                
        }
    }
}
