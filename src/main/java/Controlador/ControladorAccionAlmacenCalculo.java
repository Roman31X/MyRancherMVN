package Controlador;

import DTO.GanadoDTO;
import Modelo.*;
import VistaAlmacen.VistaAlmacenAlimentoCalculo;
import java.awt.event.*;
import java.util.*;
import javax.swing.JOptionPane;

public class ControladorAccionAlmacenCalculo implements ActionListener{
    private VistaAlmacenAlimentoCalculo calculo;
    private List<GanadoDTO> listGanado;
    
    String tipo;
            
    public ControladorAccionAlmacenCalculo(VistaAlmacenAlimentoCalculo calculo2, List<GanadoDTO> listGanado2) {
        this.calculo = calculo2;
        this.listGanado = listGanado2;
        
        calculo.Tipo.addActionListener(this);
        calculo.Calcular.addActionListener(this);
        calculo.Limpiar.addActionListener(this);
    }

    public boolean Decimal(String cadena) {

        boolean resultado;

        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    public boolean Entero(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        double edad;
        int contadorAdulto = 0;
        int contadorTernero = 0;
        
        double pesoPromedioAdulto;
        double pesoPromedioTernero;
        int adulto;
        int ternero;
        
        VacaEngordeAdulto engordeAdulto;
        VacaEngordeTernero engordeTernero;
        VacaLecheroAdulto lecheroAdulto;
        VacaLecheroTernero lecheroTernero;
        
        String accion = e.getActionCommand();
        switch(accion){
            case"comboBoxChanged":
                tipo = calculo.Tipo.getSelectedItem().toString();
                switch(tipo){
                    case "-Seleccion-":
                        calculo.CantidadAdulto.setText("");
                        calculo.CantidadTernero.setText("");
                        break;
                    case "Lechero":
                        for (GanadoDTO lista : listGanado) {
                            if(lista.getTipoGanado().equals("Lechero")){
                                edad = Double.parseDouble(lista.getEdad());
                                if(edad >= 1){
                                    contadorAdulto++;
                                }else{
                                    contadorTernero++;
                                }
                            }
                        }
                        calculo.CantidadAdulto.setText(String.valueOf(contadorAdulto));
                        calculo.CantidadTernero.setText(String.valueOf(contadorTernero));
                        break;
                    case "Engorde":
                        for (GanadoDTO lista : listGanado) {
                            if(lista.getTipoGanado().equals("Engorde")){
                                edad = Double.parseDouble(lista.getEdad());
                                if(edad > 1){
                                    contadorAdulto++;
                                }else{
                                    contadorTernero++;
                                }
                            }
                        }
                        calculo.CantidadAdulto.setText(String.valueOf(contadorAdulto));
                        calculo.CantidadTernero.setText(String.valueOf(contadorTernero));
                        break;
                }
                break;
            case"CALCULAR":
                String recuperadoAdulto = calculo.CantidadAdulto.getText();
                String recuperadoTernero = calculo.CantidadTernero.getText();
                String recuperadoPesoAdulto = calculo.PesoPromedioAdulto.getText();
                String recuperadoPesoTernero = calculo.PesoPromedioTernero.getText();
                
                String [] ganado = {recuperadoAdulto,recuperadoTernero,recuperadoPesoAdulto,recuperadoPesoTernero};
                List datos = Arrays.asList(ganado);
                
                if(datos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos\n"+
                                                                   " CANTIDAD Y PESOS PROMEDIO");
                    return;
                }
                
                if(Entero(recuperadoAdulto) == true){
                    if(Entero(recuperadoTernero) == true){
                        if(Decimal(recuperadoPesoAdulto) == true){
                            if(Decimal(recuperadoPesoTernero) == true){
                                adulto = Integer.parseInt(calculo.CantidadAdulto.getText());
                                ternero = Integer.parseInt(calculo.CantidadTernero.getText());
                                pesoPromedioAdulto = Double.parseDouble(calculo.PesoPromedioAdulto.getText());
                                pesoPromedioTernero = Double.parseDouble(calculo.PesoPromedioTernero.getText());
                                switch(tipo){
                                    case "-Seleccion-":
                                        JOptionPane.showMessageDialog(null,"Debe de seleccionar un tipo\n"+
                                                                                       "   del comboBOX GANADO");
                                        break;
                                    case "Lechero":
                                        lecheroAdulto = new VacaLecheroAdulto(adulto,pesoPromedioAdulto);
                                        lecheroTernero = new VacaLecheroTernero(ternero,pesoPromedioTernero);
                                        calculo.ConsumoSecoAdulto.setText(String.valueOf(lecheroAdulto.ConsumoAlimentoSeco())+" Kg.");
                                        calculo.ConsumoVerdeAdulto.setText(String.valueOf(lecheroAdulto.ConsumoAlimentoVerde())+" Kg.");
                                        calculo.ConsumoSecoTernero.setText(String.valueOf(lecheroTernero.ConsumoAlimentoSeco())+" Kg.");
                                        calculo.ConsumoVerdeTernero.setText(String.valueOf(lecheroTernero.ConsumoAlimentoVerde())+" Kg.");
                                        break;
                                    case "Engorde":
                                        engordeAdulto = new VacaEngordeAdulto(adulto,pesoPromedioAdulto);
                                        engordeTernero = new VacaEngordeTernero(ternero,pesoPromedioTernero);
                                        calculo.ConsumoSecoAdulto.setText(String.valueOf(engordeAdulto.ConsumoAlimentoSeco())+" Kg.");
                                        calculo.ConsumoVerdeAdulto.setText(String.valueOf(engordeAdulto.ConsumoAlimentoVerde())+" Kg.");
                                        calculo.ConsumoSecoTernero.setText(String.valueOf(engordeTernero.ConsumoAlimentoSeco())+" Kg.");
                                        calculo.ConsumoVerdeTernero.setText(String.valueOf(engordeTernero.ConsumoAlimentoVerde())+" Kg.");
                                        break;
                                }
                            }else{
                                JOptionPane.showMessageDialog(null,"En el campo Peso Promedio Ternero solo esta permitio ingresa\n"+
                                                                               "   numeros enteros[500] y numero decimales [500.0]");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"En el campo Peso Promedio Adulto solo esta permitio ingresa\n"+
                                                                           "   numeros enteros[500] y numero decimales [500.0]");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"En el campo Cantidad Ternero solo esta permitio\n"+
                                                                       "         ingresa numeros enteros[1]");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"En el campo Cantidad Adulto solo esta permitio\n"+
                                                                   "         ingresa numeros enteros[1]");
                }
                break;
            case"LIMPIAR":
                calculo.CantidadAdulto.setText("");
                calculo.CantidadTernero.setText("");
                calculo.PesoPromedioAdulto.setText("");
                calculo.PesoPromedioTernero.setText("");
                calculo.ConsumoSecoAdulto.setText("");
                calculo.ConsumoVerdeAdulto.setText("");
                calculo.ConsumoSecoTernero.setText("");
                calculo.ConsumoVerdeTernero.setText("");
                break;
        }
    }
}
