package Modelo;

public class VacaLecheroAdulto extends Vaca{

    public VacaLecheroAdulto() {
    }

    public VacaLecheroAdulto(int cantidadGanado, double pesopromedioGanado) {
        super(cantidadGanado, pesopromedioGanado);
    }

    @Override
    public double ConsumoAlimentoSeco() {
        double seco = (super.getCantidadGanado()*super.getPesopromedioGanado()) * 0.2;
        return Math.round(seco * 100d) / 100d;
    }

    @Override
    public double ConsumoAlimentoVerde() {
        double verde = (super.getCantidadGanado()*super.getPesopromedioGanado()) * 0.8;
        return Math.round(verde * 100d) / 100d;
    }
}
