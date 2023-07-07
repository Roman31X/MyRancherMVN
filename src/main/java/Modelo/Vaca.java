package Modelo;

public abstract class Vaca {
    //Atributos
    protected String tipo;
    protected double cantidadAdulto;
    protected double cantidadTernero;
    protected double pesopromedioAdulto;
    protected double pesopromedioTernero;
    protected double alimentoSeco;
    protected double alimentoVerde;
    
    //Contructor
    
    public Vaca() {
    }

    public Vaca(String tipo, double cantidadAdulto, double cantidadTernero, double pesopromedioAdulto, double pesopromedioTernero, double alimentoSeco, double alimentoVerde) {
        this.tipo = tipo;
        this.cantidadAdulto = cantidadAdulto;
        this.cantidadTernero = cantidadTernero;
        this.pesopromedioAdulto = pesopromedioAdulto;
        this.pesopromedioTernero = pesopromedioTernero;
        this.alimentoSeco = alimentoSeco;
        this.alimentoVerde = alimentoVerde;
    }
    
    
    //GETTER Y SETTER
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getCantidadAdulto() {
        return cantidadAdulto;
    }
    public void setCantidadAdulto(double cantidadAdulto) {
        this.cantidadAdulto = cantidadAdulto;
    }
    public double getCantidadTernero() {
        return cantidadTernero;
    }
    public void setCantidadTernero(double cantidadTernero) {
        this.cantidadTernero = cantidadTernero;
    }
    public double getAlimentoSeco() {
        return alimentoSeco;
    }
    public void setAlimentoSeco(double alimentoSeco) {
        this.alimentoSeco = alimentoSeco;
    }
    public double getAlimentoVerde() {
        return alimentoVerde;
    }
    public void setAlimentoVerde(double alimentoVerde) {
        this.alimentoVerde = alimentoVerde;
    }
    public double getPesopromedioAdulto() {
        return pesopromedioAdulto;
    }
    public void setPesopromedioAdulto(double pesopromedioAdulto) {
        this.pesopromedioAdulto = pesopromedioAdulto;
    }
    public double getPesopromedioTernero() {
        return pesopromedioTernero;
    }
    public void setPesopromedioTernero(double pesopromedioTernero) {
        this.pesopromedioTernero = pesopromedioTernero;
    }
    
    
    //METODOS ABSTRACTOS
    abstract double ConsumoAlimentoSecoAdulto();
    abstract double ConsumoAlimentoVerdeAdulto();
    abstract double ConsumoAlimentoSecoTernero();
    abstract double ConsumoAlimentoVerdeTernero();
    abstract double ConsumoTotalSecoAdulto();
    abstract double ConsumoTotalVerdeTernero();
}
