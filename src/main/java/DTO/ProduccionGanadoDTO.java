package DTO;

public class ProduccionGanadoDTO {
    //Atributos
    protected int idproduccionGanado;
    protected String producto;
    protected String mes;
    protected String Ganancia;
    
    //Constructor

    public ProduccionGanadoDTO() {
    }

    public ProduccionGanadoDTO(int idproduccionGanado) {
        this.idproduccionGanado = idproduccionGanado;
    }

    public ProduccionGanadoDTO(String producto, String mes, String Ganancia) {
        this.producto = producto;
        this.mes = mes;
        this.Ganancia = Ganancia;
    }

    public ProduccionGanadoDTO(int idproduccionGanado, String producto, String mes, String Ganancia) {
        this.idproduccionGanado = idproduccionGanado;
        this.producto = producto;
        this.mes = mes;
        this.Ganancia = Ganancia;
    }
    
    //toString

    @Override
    public String toString() {
        return idproduccionGanado + producto + mes + Ganancia;
    }
    
}
