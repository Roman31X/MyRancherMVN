package Modelo;

public class CalculoSacos {
    private double pesoSaco;
    private int cantidadSaco;

    public CalculoSacos(double pesoSaco, int cantidadSaco) {
        this.pesoSaco = pesoSaco;
        this.cantidadSaco = cantidadSaco;
    }

    public double getPesoSaco() {
        return pesoSaco;
    }

    public void setPesoSaco(double pesoSaco) {
        this.pesoSaco = pesoSaco;
    }

    public int getCantidadSaco() {
        return cantidadSaco;
    }

    public void setCantidadSaco(int cantidadSaco) {
        this.cantidadSaco = cantidadSaco;
    }
    
    public String Total(){
        double total = getPesoSaco()* getCantidadSaco();
        return String.valueOf(Math.round(total * 100d) / 100d);
    }

    @Override
    public String toString() {
        return "CalculoSacos: " + pesoSaco + "||" + cantidadSaco + "||"+Total();
    }
    
    
}
