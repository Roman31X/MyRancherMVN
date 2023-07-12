package DTO;

public class ProductoGanadoDTO extends UsuarioDTO{
    //Atributos
    private int idproduccionGanado;
    private String producto;
    private String mes;
    private String Ganancia;
    
    //Constructor
    public ProductoGanadoDTO() {
    }

    public ProductoGanadoDTO(int idproduccionGanado) {
        this.idproduccionGanado = idproduccionGanado;
    }

    public ProductoGanadoDTO(int idPersona, String producto, String mes, String Ganancia) {
        super(idPersona);
        this.producto = producto;
        this.mes = mes;
        this.Ganancia = Ganancia;
    }
    
    public ProductoGanadoDTO(int idproduccionGanado, int idPersona, String producto, String mes, String Ganancia) {
        super(idPersona);
        this.idproduccionGanado = idproduccionGanado;
        this.producto = producto;
        this.mes = mes;
        this.Ganancia = Ganancia;
    }
    
    //Getter y setter
    public int getIdproduccionGanado() {
        return idproduccionGanado;
    }

    public void setIdproduccionGanado(int idproduccionGanado) {
        this.idproduccionGanado = idproduccionGanado;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getGanancia() {
        return Ganancia;
    }

    public void setGanancia(String Ganancia) {
        this.Ganancia = Ganancia;
    }
    
    //toString
    @Override
    public String toString() {
        return "ProductoGanadoDTO: " +idproduccionGanado + "||"+super.getIdPersona()+"||" + producto + "||" + mes + "||" + Ganancia;
    }
    

    
}
