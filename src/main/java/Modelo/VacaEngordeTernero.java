package Modelo;

public class VacaEngordeTernero extends Vaca{

    public VacaEngordeTernero() {
    }

    public VacaEngordeTernero(int cantidadGanado, double pesopromedioGanado) {
        super(cantidadGanado, pesopromedioGanado);
    }

    
    @Override
    public double ConsumoAlimentoSeco() {
        double seco = (super.getCantidadGanado()*super.getPesopromedioGanado()) * 0.7;
        return Math.round(seco * 100d) / 100d;
    }

    @Override
    public double ConsumoAlimentoVerde() {
        double verde = (super.getCantidadGanado()*super.getPesopromedioGanado()) * 0.3;
        return Math.round(verde * 100d) / 100d;
    }
    
}
