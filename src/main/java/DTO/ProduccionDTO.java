package DTO;

public class ProduccionDTO extends TerrenoDTO{
    //Atributos
    private int idregistrocosecha;
    private String cosecha;
    private String pesocosecha;
    private String precio;
    private String ganacia;
    private String fechaincriccion;
    
    //Constructor
    public ProduccionDTO() {
    }

    public ProduccionDTO(int idregistrocosecha) {
        this.idregistrocosecha = idregistrocosecha;
    }

    public ProduccionDTO(int idterreno, int idPersona, String propietario, String ubicacion, String hectarea, String cosecha, String pesocosecha, String precio, String ganacia, String fechaincriccion) {
        super(idterreno, idPersona, propietario, ubicacion, hectarea);
        this.cosecha = cosecha;
        this.pesocosecha = pesocosecha;
        this.precio = precio;
        this.ganacia = ganacia;
        this.fechaincriccion = fechaincriccion;
    }

    public ProduccionDTO(int idregistrocosecha,int idterreno, int idPersona, String propietario, String ubicacion, String hectarea, String cosecha, String pesocosecha, String precio, String ganacia, String fechaincriccion) {
        super(idterreno, idPersona, propietario, ubicacion, hectarea);
        this.idregistrocosecha = idregistrocosecha;
        this.cosecha = cosecha;
        this.pesocosecha = pesocosecha;
        this.precio = precio;
        this.ganacia = ganacia;
        this.fechaincriccion = fechaincriccion;
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
    
    
    //toString
    @Override
    public String toString() {
        return "ProduccionDTO : " + idregistrocosecha + "||"+super.idterreno+"||" +super.getIdPersona()+"||"+ cosecha + "||" + pesocosecha + "||" + precio + "||" + ganacia + "||" + fechaincriccion;
    }
    
    
}
