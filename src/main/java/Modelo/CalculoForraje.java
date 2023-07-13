package Modelo;

public class CalculoForraje {
    //Atributos
    private double muestraUno;
    private double muestraDos;
    private double hectarea;

    //Costructor
    public CalculoForraje(double muestraUno, double muestraDos, double hectarea) {
        this.muestraUno = muestraUno;
        this.muestraDos = muestraDos;
        this.hectarea = hectarea;
    }
    
    //getter y setter
    public double getMuestraUno() {
        return muestraUno;
    }
    public void setMuestraUno(double muestraUno) {
        this.muestraUno = muestraUno;
    }
    public double getMuestraDos() {
        return muestraDos;
    }
    public void setMuestraDos(double muestraDos) {
        this.muestraDos = muestraDos;
    }
    public double getHectarea() {
        return hectarea;
    }
    public void setHectarea(double hectarea) {
        this.hectarea = hectarea;
    }
    
    public double TotalForraje(){
        double total = ((getMuestraUno()+getMuestraDos()) * 2 * getHectarea())*0.8;
        return Math.round(total * 100d) / 100d;
    }
    
    //toString 
    @Override
    public String toString() {
        return muestraUno + "||" + muestraDos + "||" + hectarea + "||" +TotalForraje();
    }
    
}
