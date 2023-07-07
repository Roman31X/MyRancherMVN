package Modelo;

public class VacaLecheraCalculo extends Vaca{

    public VacaLecheraCalculo() {
    }

    public VacaLecheraCalculo(String tipo, double cantidadAdulto, double cantidadTernero, double pesopromedioAdulto, double pesopromedioTernero, double alimentoSeco, double alimentoVerde) {
        super(tipo, cantidadAdulto, cantidadTernero, pesopromedioAdulto, pesopromedioTernero, alimentoSeco, alimentoVerde);
    }

    @Override
    double ConsumoAlimentoSecoAdulto() {
        return (cantidadAdulto*pesopromedioAdulto)*0.2;
    }

    @Override
    double ConsumoAlimentoVerdeAdulto() {
        return (cantidadAdulto*pesopromedioAdulto)*0.8;
    }

    @Override
    double ConsumoAlimentoSecoTernero() {
        return (cantidadAdulto*pesopromedioAdulto)*0.2;
    }

    @Override
    double ConsumoAlimentoVerdeTernero() {
        return (cantidadAdulto*pesopromedioAdulto)*0.8;
    }
    
    @Override
    double ConsumoTotalSecoAdulto(){
        return ConsumoAlimentoSecoAdulto() + ConsumoAlimentoSecoTernero();
    }
    
    @Override
    double ConsumoTotalVerdeTernero(){
        return ConsumoAlimentoSecoTernero() + ConsumoAlimentoVerdeTernero();
    }
}
