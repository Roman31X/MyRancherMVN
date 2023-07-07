package DTO;

public class CronogramaDTO extends TerrenoDTO{
    //Atributos
    private int idcronograma;
    private String fechactividad;
    private String actividad;
    private String cultivo;
    private String estadoCronograma;
    
    //Constructor
    public CronogramaDTO() {
    }

    public CronogramaDTO(int idcronograma) {
        this.idcronograma = idcronograma;
    }
    
    public CronogramaDTO(int idterreno, int idPersona, String propietario, String ubicacion, String hectarea, String fechactividad, String actividad, String cultivo, String estadoCronograma) {
        super(idterreno, idPersona, propietario, ubicacion, hectarea);
        this.fechactividad = fechactividad;
        this.actividad = actividad;
        this.cultivo = cultivo;
        this.estadoCronograma = estadoCronograma;
    }

    public CronogramaDTO(int idcronograma, int idterreno, int idPersona, String propietario, String ubicacion, String hectarea, String fechactividad, String actividad, String cultivo, String estadoCronograma) {
        super(idterreno, idPersona, propietario, ubicacion, hectarea);
        this.idcronograma = idcronograma;
        this.fechactividad = fechactividad;
        this.actividad = actividad;
        this.cultivo = cultivo;
        this.estadoCronograma = estadoCronograma;
    }
    
    //GETTER Y SETTER
    public int getIdcronograma() {
        return idcronograma;
    }

    public void setIdcronograma(int idcronograma) {
        this.idcronograma = idcronograma;
    }

    public String getFechactividad() {
        return fechactividad;
    }

    public void setFechactividad(String fechactividad) {
        this.fechactividad = fechactividad;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getCultivo() {
        return cultivo;
    }

    public void setCultivo(String cultivo) {
        this.cultivo = cultivo;
    }

    public String getEstadoCronograma() {
        return estadoCronograma;
    }

    public void setEstadoCronograma(String estadoCronograma) {
        this.estadoCronograma = estadoCronograma;
    }
    
    //ToString 

    @Override
    public String toString() {
        return idcronograma + " "+super.getIdterreno()+" "+super.getIdPersona()+" " + fechactividad +  actividad + cultivo +  estadoCronograma;
    }
    
    
}
