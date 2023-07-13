package Controlador;

import DTO.ProductoGanadoDTO;
import VistaGanado.*;
import VistaRegistro.RegistroProductoGanado;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ControladorProductoGanado implements ActionListener{
    private final VistaProduccionGanado controlProducto;
    int id;
    private List<ProductoGanadoDTO> listaProducto;
    private double ganancia;
    private int numeros;
    
    private RegistroProductoGanado agregarProducto;
    private VistaModificarProducto modificcarProducto;
    private VistaEliminarProducto eliminarProducto;
    
    private ControladorRegistroGanadoProducto accionRegistrar;
    private ControladorModificarProductoGanado accionModificar;
    private ControladorEliminarGanadoProducion accionEliminar;
    private ControladorPanelesMenuPrincipal principalInterfaz; 

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
        
        DefaultCategoryDataset barras;
        
        String accion = e.getActionCommand();
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
                System.out.println("PTMR");
                
                
                barras = new DefaultCategoryDataset();
                for (ProductoGanadoDTO lista : listaProducto) {
                    barras.addValue(lista.getIdproduccionGanado() , lista.getProducto(), lista.getMes());
                }
                JFreeChart grafico = ChartFactory.createBarChart(
                                    "TABLA DE GANCIAS POR PRODUCTO",//nombre de la grafica
                                    "Meses",//nombre de las barras columnas
                                    "Montos de Ganancia",//nombre de la numeración
                                    barras,//datos de la grafica
                                    PlotOrientation.VERTICAL,//orientacion de la grafica
                                    false,//leyenda de barras individuales
                                    true, //herramientas
                                    false// url de la grafica
                );
                ChartPanel panel = new ChartPanel(grafico);
                panel.setMouseWheelEnabled(true);
                panel.setPreferredSize(new Dimension(200, 150));
                //Designamos medinate los objetos donde se mostrara la grafica
                controlProducto.jPanel1.setLayout(new BorderLayout());
                controlProducto.jPanel1.add(panel, BorderLayout.NORTH);
                
                break;
        }
    }
}
