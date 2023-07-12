package Controlador;

import DTO.ProductoGanadoDTO;
import VistaGanado.VistaEliminarProducto;
import VistaGanado.VistaModificarProducto;
import VistaGanado.VistaProduccionGanado;
import VistaRegistro.RegistroProductoGanado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorProductoGanado implements ActionListener{
    private final VistaProduccionGanado controlProducto;
    int id;
    private List<ProductoGanadoDTO> listaProducto;
    
    private RegistroProductoGanado agregarProducto;
    private VistaModificarProducto modificcarProducto;
    private VistaEliminarProducto eliminarProducto;
    
    private ControladorRegistroGanadoProducto accionRegistrar;
    private ControladorEliminarGanadoProducion accionEliminar;
    

    public ControladorProductoGanado(VistaProduccionGanado controlProducto1, int id1, List<ProductoGanadoDTO> listaProducto1) {
        this.controlProducto = controlProducto1;
        this.id = id1;
        this.listaProducto = listaProducto1;
        
        controlProducto.Agregar.addActionListener(this);
        controlProducto.Modificar.addActionListener(this);
        controlProducto.Eliminar.addActionListener(this);
        controlProducto.Graficar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        agregarProducto = new RegistroProductoGanado();
        modificcarProducto = new VistaModificarProducto();
        eliminarProducto = new VistaEliminarProducto();
        
        
        String accion = e.getActionCommand();
        System.out.println("accion = " + accion);
        switch(accion){
            case "AGREGAR":
                accionRegistrar = new ControladorRegistroGanadoProducto(agregarProducto,id);
                accionRegistrar.Mostrar();
                break;
            case "MODIFICAR":
                
                break;
            case "ELIMINAR":
                for (ProductoGanadoDTO lista : listaProducto) {
                    eliminarProducto.ListaID.addItem(String.valueOf(lista.getIdproduccionGanado()));
                }
                accionEliminar = new ControladorEliminarGanadoProducion(eliminarProducto);
                accionEliminar.Mostrar();
                break;
            case "GRAFICAR":
                break;
        }
    }
}
