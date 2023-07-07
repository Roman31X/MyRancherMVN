package Controlador;

import VistaGanado.*;
import VistaPaneles.GestionGanado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorGestionGanado implements ActionListener{
    //Atributos
    GestionGanado controlGanado;
    VistaRegistroGanado registroGanado;
    VistaListarGanado ganado;
    VistaProduccionGanado productoGanado;
    
    ControladorPanelesMenuPrincipal principalInterfaz;    
    //Constructor
    public ControladorGestionGanado(GestionGanado controlGanado3) {
        this.controlGanado = controlGanado3;
        controlGanado.RegistroGanado.addActionListener(this);
        controlGanado.ListarGanado.addActionListener(this);
        controlGanado.ProduccionGanado.addActionListener(this);
    }
    
    //Accion

    @Override
    public void actionPerformed(ActionEvent e) {
        //Atributo
        String accion = e.getActionCommand();
        registroGanado = new VistaRegistroGanado();
        ganado = new VistaListarGanado();
        productoGanado = new VistaProduccionGanado();
        switch(accion){
            case "REGISTRO GANADO":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlGanado.PanelGanado, registroGanado.PanelRegistroGanado);
                break;
            case "LISTAR GANADO":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlGanado.PanelGanado, ganado.PanelListaGanado);
                break;
            case "PRODUCCION GANADO":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlGanado.PanelGanado, productoGanado.PanelProduccion);
                break;
        }
    }
}
