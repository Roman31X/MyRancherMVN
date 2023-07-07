package DTO;

public class RegistroProduccionGanadoDTO {
    //Atributos
    protected int idproduccionGanado;
    protected String producto;
    protected String mes;
    protected String Ganancia;
    
    //Constructor

    public RegistroProduccionGanadoDTO() {
    }

    public RegistroProduccionGanadoDTO(int idproduccionGanado) {
        this.idproduccionGanado = idproduccionGanado;
    }

    public RegistroProduccionGanadoDTO(String producto, String mes, String Ganancia) {
        this.producto = producto;
        this.mes = mes;
        this.Ganancia = Ganancia;
    }

    public RegistroProduccionGanadoDTO(int idproduccionGanado, String producto, String mes, String Ganancia) {
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
