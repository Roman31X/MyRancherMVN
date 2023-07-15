package DTO;

public class AlmacenCosechaDTO extends TerrenoDTO{
    //Atributo
    private int idalmacenCosecha;
    private String producto;
    private String peso;
    private String dimension;
    private String fecha;

    //Constructor
    public AlmacenCosechaDTO() {
    }

    public AlmacenCosechaDTO(int idalmacenCosecha) {
        this.idalmacenCosecha = idalmacenCosecha;
    }

    public AlmacenCosechaDTO(int idterreno, int idPersona, String producto, String peso, String dimension, String fecha) {
        super(idterreno, idPersona);
        this.producto = producto;
        this.peso = peso;
        this.dimension = dimension;
        this.fecha = fecha;
    }
    
    public AlmacenCosechaDTO(int idalmacenCosecha, int idterreno, int idPersona, String producto, String peso, String dimension, String fecha) {
        super(idterreno, idPersona);
        this.idalmacenCosecha = idalmacenCosecha;
        this.producto = producto;
        this.peso = peso;
        this.dimension = dimension;
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
    public String getDimension() {
        return dimension;
    }
    public void setDimension(String dimension) {
        this.dimension = dimension;
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
        return idalmacenCosecha + super.idterreno + super.getIdPersona()+ producto + peso  + hectarea + fecha;
    }
       
}
