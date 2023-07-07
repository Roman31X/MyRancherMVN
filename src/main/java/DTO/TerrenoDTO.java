package DTO;

public class TerrenoDTO extends UsuarioDTO{
    //Atributo
    protected int idterreno;
    protected String propietario;
    protected String ubicacion;
    protected String hectarea;
    protected String estadoTerreno;
    
    //Constructor
    public TerrenoDTO() {
    }

    public TerrenoDTO(int idterreno) {
        this.idterreno = idterreno;
    }

    public TerrenoDTO(int idPersona, String propietario, String ubicacion, String hectarea, String estadoTerreno) {
        super(idPersona);
        this.propietario = propietario;
        this.ubicacion = ubicacion;
        this.hectarea = hectarea;
        this.estadoTerreno = estadoTerreno;
    }

    public TerrenoDTO(int idterreno, int idPersona, String propietario, String ubicacion, String hectarea) {
        super(idPersona);
        this.idterreno = idterreno;
        this.propietario = propietario;
        this.ubicacion = ubicacion;
        this.hectarea = hectarea;
    }
    
    
    public TerrenoDTO(int idterreno, int idPersona, String propietario, String ubicacion, String hectarea, String estadoTerreno) {
        super(idPersona);
        this.idterreno = idterreno;
        this.propietario = propietario;
        this.ubicacion = ubicacion;
        this.hectarea = hectarea;
        this.estadoTerreno = estadoTerreno;
    }
    
    //GETTER Y SETTER
    public int getIdterreno() {
        return idterreno;
    }
    public void setIdterreno(int idterreno) {
        this.idterreno = idterreno;
    }
    public String getPropietario() {
        return propietario;
    }
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getHectarea() {
        return hectarea;
    }
    public void setHectarea(String hectarea) {
        this.hectarea = hectarea;
    }
    public String getEstadoTerreno() {
        return estadoTerreno;
    }
    public void setEstadoTerreno(String estadoTerreno) {
        this.estadoTerreno = estadoTerreno;
    }
    
    //ToString para tabla Terreno

    @Override
    public String toString() {
        return idterreno + ""+super.getIdPersona() + propietario +  ubicacion +  hectarea + estadoTerreno;
    }
}
