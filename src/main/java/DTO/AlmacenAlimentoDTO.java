package DTO;

public class AlmacenAlimentoDTO extends UsuarioDTO{
    //Atributo
    private int idalmacenAlimento;
    private String tipoalimento;
    private String pesoSaco;
    private String cantidadSaco;
    private String pesoTotal;
    private String fechaEntrega;
    
    //Constructor
    public AlmacenAlimentoDTO() {
    }

    public AlmacenAlimentoDTO(int idalmacenAlimento) {
        this.idalmacenAlimento = idalmacenAlimento;
    }

    public AlmacenAlimentoDTO(int idPersona, String tipoalimento, String pesoSaco, String cantidadSaco, String pesoTotal, String fechaEntrega) {
        super(idPersona);
        this.tipoalimento = tipoalimento;
        this.pesoSaco = pesoSaco;
        this.cantidadSaco = cantidadSaco;
        this.pesoTotal = pesoTotal;
        this.fechaEntrega = fechaEntrega;
    }

    public AlmacenAlimentoDTO(int idalmacenAlimento, int idPersona, String tipoalimento, String pesoSaco, String cantidadSaco, String pesoTotal, String fechaEntrega) {
        super(idPersona);
        this.idalmacenAlimento = idalmacenAlimento;
        this.tipoalimento = tipoalimento;
        this.pesoSaco = pesoSaco;
        this.cantidadSaco = cantidadSaco;
        this.pesoTotal = pesoTotal;
        this.fechaEntrega = fechaEntrega;
    }

    
    //GETTER Y SETTER
    public int getIdalmacenAlimento() {
        return idalmacenAlimento;
    }
    public void setIdalmacenAlimento(int idalmacenAlimento) {
        this.idalmacenAlimento = idalmacenAlimento;
    }
    public String getTipoalimento() {
        return tipoalimento;
    }
    public void setTipoalimento(String tipoalimento) {
        this.tipoalimento = tipoalimento;
    }
    public String getPesoSaco() {
        return pesoSaco;
    }
    public void setPesoSaco(String pesoSaco) {
        this.pesoSaco = pesoSaco;
    }
    public String getCantidadSaco() {
        return cantidadSaco;
    }
    public void setCantidadSaco(String cantidadSaco) {
        this.cantidadSaco = cantidadSaco;
    }
    public String getPesoTotal() {
        return pesoTotal;
    }
    public void setPesoTotal(String pesoTotal) {
        this.pesoTotal = pesoTotal;
    }
    public String getFechaEntrega() {
        return fechaEntrega;
    }
    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
    //ToString

    @Override
    public String toString() {
        return idalmacenAlimento  + tipoalimento + pesoSaco  + cantidadSaco +  pesoTotal  + fechaEntrega;
    }
    
    
    
}
