package Controlador;

import DTO.AlmacenAlimentoDTO;
import VistaAlmacen.VistaAlmacenListarAlimento;
import VistaAlmacen.VistaEliminarAlimento;
import VistaAlmacen.VistaModificarAlimento;
import VistaRegistro.RegistroAlimento;
import java.awt.event.*;
import java.util.List;

public class ControladorAccionAlmacenAlimento implements ActionListener{
    private final VistaAlmacenListarAlimento controlAlimento;
    private int id;
    private List<AlmacenAlimentoDTO> listaAlimento;
    private RegistroAlimento registro;
    private VistaModificarAlimento modificar;
    private VistaEliminarAlimento vistaEliminar;
    
    private ControladorRegistroAlimento accionRegistrar;
    private ControladorModificarAlimento accionModificar;
    private ControladorEliminarAlimento accionEliminar;
    
    public ControladorAccionAlmacenAlimento(VistaAlmacenListarAlimento controlAlimento1, int id1, List<AlmacenAlimentoDTO> listaAlimento1) {
        this.controlAlimento = controlAlimento1;
        this.id = id1;
        this.listaAlimento = listaAlimento1;
        
        controlAlimento.Agregar.addActionListener(this);
        controlAlimento.Modificado.addActionListener(this);
        controlAlimento.Eliminar.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        registro = new RegistroAlimento();
        modificar = new VistaModificarAlimento();
        vistaEliminar = new VistaEliminarAlimento();
        
        String accion = e.getActionCommand();
        switch(accion){
            case "AGREGAR":
                accionRegistrar = new ControladorRegistroAlimento(registro,id);
                accionRegistrar.Mostrar();
                break;
            case "MODIFICAR":
                for (AlmacenAlimentoDTO Lista : listaAlimento) {
                    modificar.listaID.addItem(String.valueOf(Lista.getIdalmacenAlimento()));
                }
                accionModificar = new ControladorModificarAlimento(modificar,id,listaAlimento);
                accionModificar.Mostrar();
                break;
            case "ELIMINAR":
                for (AlmacenAlimentoDTO Lista : listaAlimento) {
                    vistaEliminar.ListaID.addItem(String.valueOf(Lista.getIdalmacenAlimento()));
                }
                accionEliminar = new ControladorEliminarAlimento(vistaEliminar);
                accionEliminar.Mostrar();
                break;
                
        }
    }
}
