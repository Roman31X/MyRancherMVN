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
        String accion = e.getActionCommand();
        System.out.println("accion = " + accion);
        switch(accion){
            case"comboBoxChanged":
                
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
