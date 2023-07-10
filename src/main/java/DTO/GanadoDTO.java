package DTO;

public class GanadoDTO extends UsuarioDTO{
    //Atributos
    private int idGanado;
    private String fechaNacimiento;
    private String edad;
    private String raza;
    private String sexo;
    private String tipoGanado;
    private String numeroCrias;
    
    //Constructor
    public GanadoDTO() {
    }

    public GanadoDTO(int idGanado) {
        this.idGanado = idGanado;
    }
    
    public GanadoDTO(int idPersona, String fechaNacimiento, String edad, String raza, String sexo, String tipoGanado, String numeroCrias) {
        super(idPersona);
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.raza = raza;
        this.sexo = sexo;
        this.tipoGanado = tipoGanado;
        this.numeroCrias = numeroCrias;
    }

    public GanadoDTO(int idGanado, int idPersona, String fechaNacimiento, String edad, String raza, String sexo, String tipoGanado, String numeroCrias) {
        super(idPersona);
        this.idGanado = idGanado;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.raza = raza;
        this.sexo = sexo;
        this.tipoGanado = tipoGanado;
        this.numeroCrias = numeroCrias;
    }
    
    //getter y setter
    public int getIdGanado() {
        return idGanado;
    }
    public void setIdGanado(int idGanado) {
        this.idGanado = idGanado;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getTipoGanado() {
        return tipoGanado;
    }
    public void setTipoGanado(String tipoGanado) {
        this.tipoGanado = tipoGanado;
    }
    public String getNumeroCrias() {
        return numeroCrias;
    }
    public void setNumeroCrias(String numeroCrias) {
        this.numeroCrias = numeroCrias;
    }
    
    //toString
    @Override
    public String toString() {
        return "RegistroGanadoDTO: "+ idGanado + "||" + super.getIdPersona()+"||"+ fechaNacimiento + "||" + edad + "||" + raza + "||" + sexo + "||" + tipoGanado + "||" + numeroCrias;
    }
    
    
}
