package DTO;

public class AlmacenForrajeDTO {
    //Atributos
    private int idalmacenforraje;
    private String forraje;
    private String muestra1;
    private String muestra2;
    private String hectarea;
    private String pesogenerado;
    
    //Constructor
    public AlmacenForrajeDTO() {
    }

    public AlmacenForrajeDTO(int idalmacenforraje) {
        this.idalmacenforraje = idalmacenforraje;
    }

    public AlmacenForrajeDTO(String forraje, String muestra1, String muestra2, String hectarea, String pesogenerado) {
        this.forraje = forraje;
        this.muestra1 = muestra1;
        this.muestra2 = muestra2;
        this.hectarea = hectarea;
        this.pesogenerado = pesogenerado;
    }
    
    public AlmacenForrajeDTO(int idalmacenforraje, String forraje, String muestra1, String muestra2, String hectarea, String pesogenerado) {
        this.idalmacenforraje = idalmacenforraje;
        this.forraje = forraje;
        this.muestra1 = muestra1;
        this.muestra2 = muestra2;
        this.hectarea = hectarea;
        this.pesogenerado = pesogenerado;
    }
    
    //GETTER Y SETTER

    public int getIdalmacenforraje() {
        return idalmacenforraje;
    }
    public void setIdalmacenforraje(int idalmacenforraje) {
        this.idalmacenforraje = idalmacenforraje;
    }
    public String getForraje() {
        return forraje;
    }
    public void setForraje(String forraje) {
        this.forraje = forraje;
    }
    public String getMuestra1() {
        return muestra1;
    }
    public void setMuestra1(String muestra1) {
        this.muestra1 = muestra1;
    }
    public String getMuestra2() {
        return muestra2;
    }
    public void setMuestra2(String muestra2) {
        this.muestra2 = muestra2;
    }
    public String getHectarea() {
        return hectarea;
    }
    public void setHectarea(String hectarea) {
        this.hectarea = hectarea;
    }
    public String getPesogenerado() {
        return pesogenerado;
    }
    public void setPesogenerado(String pesogenerado) {
        this.pesogenerado = pesogenerado;
    }
    
    //ToString

    @Override
    public String toString() {
        return idalmacenforraje + forraje +  muestra1 + muestra2 + hectarea + pesogenerado;
    }
    
    
}
