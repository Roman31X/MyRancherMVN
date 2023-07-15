package Controlador;

import DTO.GanadoDTO;
import VistaAlmacen.VistaAlmacenAlimentoCalculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorAccionAlmacenCalculo implements ActionListener{
    private VistaAlmacenAlimentoCalculo calculo;
    private List<GanadoDTO> listGanado;
    
    
    public ControladorAccionAlmacenCalculo(VistaAlmacenAlimentoCalculo calculo2, List<GanadoDTO> listGanado2) {
        this.calculo = calculo2;
        this.listGanado = listGanado2;
        
        calculo.Tipo.addActionListener(this);
        calculo.Calcular.addActionListener(this);
        calculo.Limpiar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double edad;
        int contadorAdulto = 0;
        int contadorTernero = 0;
        
        String accion = e.getActionCommand();
        System.out.println("accion = " + accion);
        switch(accion){
            case"comboBoxChanged":
                String tipo = calculo.Tipo.getSelectedItem().toString();
                System.out.println("tipo = " + tipo);
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
