package DTO;

public class RegistroGanadoDTO {
    //Atributos
    protected int idGanado;
    protected String fechaNacimiento;
    protected String edad;
    protected String raza;
    protected String sexo;
    protected String tipoGanado;
    protected String numeroCrias;
    
    //Constructor
    public RegistroGanadoDTO() {
    }

    public RegistroGanadoDTO(int idGanado) {
        this.idGanado = idGanado;
    }

    public RegistroGanadoDTO(String fechaNacimiento, String edad, String raza, String sexo, String tipoGanado, String numeroCrias) {
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.raza = raza;
        this.sexo = sexo;
        this.tipoGanado = tipoGanado;
        this.numeroCrias = numeroCrias;
    }
    
    public RegistroGanadoDTO(int idGanado, String fechaNacimiento, String edad, String raza, String sexo, String tipoGanado, String numeroCrias) {
        this.idGanado = idGanado;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.raza = raza;
        this.sexo = sexo;
        this.tipoGanado = tipoGanado;
        this.numeroCrias = numeroCrias;
    }
    
    //toString
    @Override
    public String toString() {
        return idGanado  + fechaNacimiento + edad + raza + sexo + tipoGanado + numeroCrias;
    }
    
}
