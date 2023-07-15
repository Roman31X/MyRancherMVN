package Modelo;

public abstract class Vaca {
    //Atributos
    private int cantidadGanado;
    private double pesopromedioGanado;
    
    //Contructor
    public Vaca() {
    }   

    public Vaca(int cantidadGanado,double pesopromedioGanado) {
        this.cantidadGanado = cantidadGanado;
        this.pesopromedioGanado = pesopromedioGanado;
    }
    
    //GETTER Y SETTER
    public int getCantidadGanado() {    
        return cantidadGanado;
    }
    public void setCantidadGanado(int cantidadGanado) {
        this.cantidadGanado = cantidadGanado;
    }
    public double getPesopromedioGanado() {
        return pesopromedioGanado;
    }
    public void setPesopromedioGanado(double pesopromedioGanado) {    
        this.pesopromedioGanado = pesopromedioGanado;
    }

    //METODOS ABSTRACTOS
    abstract double ConsumoAlimentoSeco();
    abstract double ConsumoAlimentoVerde();
}
