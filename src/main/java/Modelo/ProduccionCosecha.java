package Modelo;

public class ProduccionCosecha {
    private double pesoTotal;
    private double precioKilo;

    public ProduccionCosecha() {
    }
    
    public ProduccionCosecha(double pesoTotal, double precioKilo) {
        this.pesoTotal = pesoTotal;
        this.precioKilo = precioKilo;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }
    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }
    public double getPrecioKilo() {
        return precioKilo;
    }
    public void setPrecioKilo(double precioKilo) {
        this.precioKilo = precioKilo;
    }
    
    public double Ganancia(){
        double total = getPesoTotal() * getPrecioKilo();
        return Math.round(total * 100d) / 100d;
    }
    
    public String GananciaTotal(){
        return String.valueOf(Ganancia());
    }
    
    @Override
    public String toString() {
        return "ProduccionCosecha : " + "||" + pesoTotal + "||" + precioKilo+"||"+Ganancia()+"||"+GananciaTotal();
    }
}
