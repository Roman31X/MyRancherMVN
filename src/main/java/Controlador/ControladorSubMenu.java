package Controlador;

import VistaPaneles.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorSubMenu implements ActionListener{
    
    private final GestionMenu controlMenu;
    private GestionTerreno controlTerreno;
    private GestionAlmacen controlAlmacen;
    private GestionGanado controlGanado;
    private ControladorPanelesMenuPrincipal principalInterfaz;
    private int id;
    
    ControladorGestionTerreno terreno;
    ControladorGestionAlmacen almacen;
    ControladorGestionGanado ganado;
    
    public ControladorSubMenu(GestionMenu controlMenu4, int id2) {
        this.controlMenu = controlMenu4;
        this.id = id2;
        controlMenu.Terreno.addActionListener(this);
        controlMenu.Almacen.addActionListener(this);
        controlMenu.Ganado.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        controlTerreno = new GestionTerreno();
        controlAlmacen = new GestionAlmacen();
        controlGanado = new GestionGanado();
        
        //Stributos
        String accion = e.getActionCommand();
        switch(accion){
            case "Gestion Terreno":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlMenu.PanelMenu, controlTerreno.PanelTerreno);
                terreno = new ControladorGestionTerreno(controlTerreno,id);
                break;
            case "Gestion Almacen":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlMenu.PanelMenu, controlAlmacen.PanelGestionAlmacen);
                almacen = new ControladorGestionAlmacen(controlAlmacen,id);
                break;
            case "Gestion Ganado":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlMenu.PanelMenu, controlGanado.PanelGestionGanado);
                ganado = new ControladorGestionGanado(controlGanado,id);
                break;
        }
    }
    
}
