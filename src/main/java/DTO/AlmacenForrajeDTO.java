package DTO;

public class AlmacenForrajeDTO extends TerrenoDTO{
    //Atributos
    private int idalmacenforraje;
    private String forraje;
    private String muestra1;
    private String muestra2;
    private String dimencion;
    private String pesogenerado;
    
    //Constructor
    public AlmacenForrajeDTO() {
    }

    public AlmacenForrajeDTO(int idalmacenforraje) {
        this.idalmacenforraje = idalmacenforraje;
    }

    public AlmacenForrajeDTO(int idterreno, int idPersona, String forraje, String muestra1, String muestra2, String dimencion, String pesogenerado) {
        super(idterreno, idPersona);
        this.forraje = forraje;
        this.muestra1 = muestra1;
        this.muestra2 = muestra2;
        this.dimencion = dimencion;
        this.pesogenerado = pesogenerado;
    }
    
    public AlmacenForrajeDTO(int idalmacenforraje, int idterreno, int idPersona, String forraje, String muestra1, String muestra2, String dimencion, String pesogenerado) {
        super(idterreno, idPersona);
        this.idalmacenforraje = idalmacenforraje;
        this.forraje = forraje;
        this.muestra1 = muestra1;
        this.muestra2 = muestra2;
        this.dimencion = dimencion;
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
    public String getDimencion() {
        return dimencion;
    }
    public void setDimencion(String dimencion) {
        this.dimencion = dimencion;
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
        return idalmacenforraje +"||"+super.idterreno+"||"+super.getIdPersona()+"||"+ forraje+"||"+ muestra1+"||"+ muestra2+"||"+ dimencion+"||"+ pesogenerado;
    }
    
    
}
