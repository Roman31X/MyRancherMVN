package DTO;

public class AlmacenCosechaDTO {
    //Atributo
    private int idalmacenCosecha;
    private String producto;
    private String peso;
    private String hectarea;
    private String fecha;

    //Constructor
    public AlmacenCosechaDTO() {
    }

    public AlmacenCosechaDTO(int idalmacenCosecha) {
        this.idalmacenCosecha = idalmacenCosecha;
    }

    public AlmacenCosechaDTO(String producto, String peso, String hectarea, String fecha) {
        this.producto = producto;
        this.peso = peso;
        this.hectarea = hectarea;
        this.fecha = fecha;
    }
    
    public AlmacenCosechaDTO(int idalmacenCosecha, String producto, String peso, String hectarea, String fecha) {
        this.idalmacenCosecha = idalmacenCosecha;
        this.producto = producto;
        this.peso = peso;
        this.hectarea = hectarea;
        this.fecha = fecha;
    }
    
    //GETTER Y SETTER
    public int getIdalmacenCosecha() {
        return idalmacenCosecha;
    }
    public void setIdalmacenCosecha(int idalmacenCosecha) {
        this.idalmacenCosecha = idalmacenCosecha;
    }
    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }
    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
    public String getHectarea() {
        return hectarea;
    }
    public void setHectarea(String hectarea) {
        this.hectarea = hectarea;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    //ToString

    @Override
    public String toString() {
        return idalmacenCosecha + producto + peso  + hectarea + fecha;
    }
       
}
