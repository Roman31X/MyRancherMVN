package DTO;

public class RegistroCosechaDTO extends TerrenoDTO{
    //Atributos
    protected int idregistrocosecha;
    protected String cosecha;
    protected String pesocosecha;
    protected String precio;
    protected String ganacia;
    protected String fechaincriccion;
    
    //Constructor
    public RegistroCosechaDTO() {
    }

    public RegistroCosechaDTO(int idregistrocosecha) {
        this.idregistrocosecha = idregistrocosecha;
    }
    
    
    //GETTER Y SETTER
    public int getIdregistrocosecha() {
        return idregistrocosecha;
    }

    public void setIdregistrocosecha(int idregistrocosecha) {
        this.idregistrocosecha = idregistrocosecha;
    }

    public String getCosecha() {
        return cosecha;
    }

    public void setCosecha(String cosecha) {
        this.cosecha = cosecha;
    }

    public String getPesocosecha() {
        return pesocosecha;
    }

    public void setPesocosecha(String pesocosecha) {
        this.pesocosecha = pesocosecha;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getGanacia() {
        return ganacia;
    }

    public void setGanacia(String ganacia) {
        this.ganacia = ganacia;
    }

    public String getFechaincriccion() {
        return fechaincriccion;
    }

    public void setFechaincriccion(String fechaincriccion) {
        this.fechaincriccion = fechaincriccion;
    }
    
    
    
}
