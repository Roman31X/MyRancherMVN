package Modelo;

public class VacaEngordeCalculo extends Vaca{
    
    public VacaEngordeCalculo() {
    }

    //Constructor
    public VacaEngordeCalculo(String tipo, double cantidadAdulto, double cantidadTernero, double pesopromedioAdulto, double pesopromedioTernero, double alimentoSeco, double alimentoVerde) {    
        super(tipo, cantidadAdulto, cantidadTernero, pesopromedioAdulto, pesopromedioTernero, alimentoSeco, alimentoVerde);
    }

    @Override
    double ConsumoAlimentoSecoAdulto() {
        return (cantidadAdulto*pesopromedioAdulto)*0.7;
    }

    @Override
    double ConsumoAlimentoVerdeAdulto() {
        return (cantidadAdulto*pesopromedioAdulto)*0.3;
    }

    @Override
    double ConsumoAlimentoSecoTernero() {
        return (cantidadTernero*pesopromedioAdulto)*0.7;
    }

    @Override
    double ConsumoAlimentoVerdeTernero() {
        return (cantidadTernero*pesopromedioAdulto)*0.7;
    }

    @Override
    double ConsumoTotalSecoAdulto() {
        return ConsumoAlimentoSecoAdulto() + ConsumoAlimentoSecoTernero();
    }

    @Override
    double ConsumoTotalVerdeTernero() {
        return ConsumoAlimentoVerdeAdulto() + ConsumoAlimentoVerdeTernero();
    }

    
    
    
}
