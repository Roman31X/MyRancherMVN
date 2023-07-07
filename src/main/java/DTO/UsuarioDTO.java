package DTO;

public class UsuarioDTO {
    //Atributos
    private int idPersona;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String email;
    private String contraseñaUna;
    private String contraseñaDos;
    //Constructor
    public UsuarioDTO() {
    }
    
    public UsuarioDTO(int idPersona) {
        this.idPersona = idPersona;
    }

    public UsuarioDTO(String nombre, String apellido, String nombreUsuario, String email, String contraseñaUna, String contraseñaDos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contraseñaUna = contraseñaUna;
        this.contraseñaDos = contraseñaDos;
    }

    public UsuarioDTO(int idPersona, String nombre, String apellido, String nombreUsuario, String email, String contraseñaUna, String contraseñaDos) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contraseñaUna = contraseñaUna;
        this.contraseñaDos = contraseñaDos;
    }
    
    //GETTER Y SETTER
    public int getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContraseñaUna() {
        return contraseñaUna;
    }
    public void setContraseñaUna(String contraseñaUna) {
        this.contraseñaUna = contraseñaUna;
    }
    public String getContraseñaDos() {
        return contraseñaDos;
    }
    public void setContraseñaDos(String contraseñaDos) {
        this.contraseñaDos = contraseñaDos;
    }
    
    //Metodo toString

    @Override
    public String toString() {
        return idPersona + nombre + apellido + nombreUsuario +email +contraseñaUna +contraseñaDos;
    }
}
