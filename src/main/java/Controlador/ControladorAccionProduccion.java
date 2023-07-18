package Controlador;

import DTO.*;
import Modelo.ProduccionCosecha;
import VistaRegistro.RegistroProduccion;
import VistaTerreno.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JOptionPane;

public class ControladorAccionProduccion implements ActionListener{
    private final VistaTablaProduccion controlProduccion;
    private VistaEliminarProduccion VistaEliminar;
    private RegistroProduccion vistalRegistro;
    int id;
    List<ProduccionDTO> listaIDProduccion;
    private List<TerrenoDTO> idTerreno;
    
    double pesoTotal = 0, presioKilo = 0;
    ProduccionCosecha resultado;
    String[] datosCalculo;
    ControladorRegistroProduccion agregarProduccion;
    ControladorEliminarProduccion eliminaProduccion;    
    
    public ControladorAccionProduccion(VistaTablaProduccion controlProduccion1, int id1,List<ProduccionDTO> listaIDProduccion1,List<TerrenoDTO> idTerreno1) {
        this.controlProduccion = controlProduccion1;
        this.id = id1;
        this.listaIDProduccion = listaIDProduccion1;
        this.idTerreno = idTerreno1;
        
        controlProduccion.Calcular.addActionListener(this);
        controlProduccion.Eliminar.addActionListener(this);
        controlProduccion.Registrar.addActionListener(this);
        controlProduccion.Limpiar.addActionListener(this);
    }

    public boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
    
    //Acciones
    @Override
    public void actionPerformed(ActionEvent e) {
        
        VistaEliminar = new VistaEliminarProduccion();
        vistalRegistro = new RegistroProduccion();
        
        datosCalculo = new String[3];
        
        String accion = e.getActionCommand();
        switch(accion){
            case "CALCULAR":
                String dato1 = controlProduccion.PesoTotal.getText();
                String dato2 = controlProduccion.PesoKilo.getText();
                
                String [] datos = {dato1,dato2};
                List campos = Arrays.asList(datos);
                if(campos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos\n"+
                                                                   "  a excepción del campo Gancia");
                    return;
                }
                
                if(isNumeric(dato1) == true){
                    if(isNumeric(dato2) == true){
                        pesoTotal = Double.parseDouble(controlProduccion.PesoTotal.getText());
                        presioKilo = Double.parseDouble(controlProduccion.PesoKilo.getText());

                        resultado = new ProduccionCosecha(pesoTotal,presioKilo);
                        controlProduccion.Ganancia.setText(resultado.GananciaTotal());
                        
                    }else{
                       JOptionPane.showMessageDialog(null,"En el campo Precio x Kilo debe ingresar\n"+
                                                                      "numeros enteros[1] y decimales [1.5]");
                        return; 
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"En el campo Peso Total debe ingresar\n"+
                                                                   "numeros enteros[1] y decimales [1.5]");
                    return;
                }
                break;
            case "LIMPIAR":
                controlProduccion.PesoTotal.setText("");
                controlProduccion.PesoKilo.setText("");
                controlProduccion.Ganancia.setText("");
                break;
            case "REGISTRAR":
                for(TerrenoDTO lista : idTerreno){
                    vistalRegistro.IDBOX.addItem(Integer.toString(lista.getIdterreno()));
                }
                datosCalculo[0] = String.valueOf(controlProduccion.PesoTotal.getText());
                datosCalculo[1] = String.valueOf(controlProduccion.PesoKilo.getText());
                datosCalculo[2] = String.valueOf(controlProduccion.Ganancia.getText());
                List resultado = Arrays.asList(datosCalculo);
                    if(resultado.contains("")){
                        JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos\n"+
                                                                       "    de calculo de COSECHA");
                        return;
                    }
                agregarProduccion = new ControladorRegistroProduccion(vistalRegistro,id,idTerreno,datosCalculo);
                agregarProduccion.Mostrar();
                break;
            case "ELIMINAR":
                for (ProduccionDTO lista : listaIDProduccion) {
                    VistaEliminar.ListaID.addItem(Integer.toString(lista.getIdregistrocosecha()));
                }
                eliminaProduccion = new ControladorEliminarProduccion (VistaEliminar);
                eliminaProduccion.Mostrar();
                break;
        }
    }
}
