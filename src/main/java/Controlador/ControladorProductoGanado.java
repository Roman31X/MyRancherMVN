package Controlador;

import DTO.ProductoGanadoDTO;
import VistaGanado.*;
import VistaRegistro.RegistroProductoGanado;
import java.awt.event.*;
import java.util.List;
import org.jfree.data.category.DefaultCategoryDataset;

public class ControladorProductoGanado implements ActionListener{
    private final VistaProduccionGanado controlProducto;
    int id;
    private List<ProductoGanadoDTO> listaProducto;
    
    private RegistroProductoGanado agregarProducto;
    private VistaModificarProducto modificcarProducto;
    private VistaEliminarProducto eliminarProducto;
    
    private ControladorRegistroGanadoProducto accionRegistrar;
    private ControladorModificarProductoGanado accionModificar;
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
                for (ProductoGanadoDTO lista : listaProducto) {
                    modificcarProducto.IDProducto.addItem(String.valueOf(lista.getIdproduccionGanado()));
                }
                accionModificar = new ControladorModificarProductoGanado(modificcarProducto,id,listaProducto);
                accionModificar.Mostrar();
                break;
            case "ELIMINAR":
                for (ProductoGanadoDTO lista : listaProducto) {
                    eliminarProducto.ListaID.addItem(String.valueOf(lista.getIdproduccionGanado()));
                }
                accionEliminar = new ControladorEliminarGanadoProducion(eliminarProducto);
                accionEliminar.Mostrar();
                break;
            case "GRAFICAR":
                DefaultCategoryDataset datos = new DefaultCategoryDataset();
                
                
                break;
        }
    }
}
