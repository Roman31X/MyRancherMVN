package Controlador;

import VistaAlmacen.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAlmacenAlimento implements ActionListener{
    //Atributos
    VistaAlmacenAlimento controlAlimento;
    VistaAlmacenListarAlimento alimento;
    VistaAlmacenAlimentoCalculo calculo;
    
    ControladorPanelesMenuPrincipal principalInterfaz;
    //Constructor

    public ControladorAlmacenAlimento(VistaAlmacenAlimento controlAlimento3) {
        this.controlAlimento = controlAlimento3;
        controlAlimento.ListarAlimento.addActionListener(this);
        controlAlimento.CalcularAlimento.addActionListener(this);
    }

    //Accion
    @Override
    public void actionPerformed(ActionEvent e) {
        //Atributos
        String accion = e.getActionCommand();
        alimento = new VistaAlmacenListarAlimento();
        calculo = new VistaAlmacenAlimentoCalculo();
        switch(accion){
            case "LISTAR ALIMENTO":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlAlimento.PanelLista,alimento.PanelListaAlimento);
                break;
            case "CALCULAR CONSUMO":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlAlimento.PanelLista,calculo.PanelCalculoAlimento);
                break;
        }
    }
}
