
package JDBC;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import static MySql.Conexion.*;
import java.sql.*;
import java.util.*;

public class UsuarioJDBC implements UsuarioDAO{
    
    private Connection conexionTrasaccional;
    
    //sentencias
    private static final String SQL_SELECT = "SELECT idusuario, nombre, apellido, nombreusuario, email, contraseñauno, contraseñados FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(nombre,apellido, nombreusuario, email, contraseñauno, contraseñados) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET nombre = ?,apellido = ?,nombreusuario = ?,email = ?,contraseñauno = ?,contraseñados = ? WHERE idusuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE idusuario = ?";
    
    //constrcutor vacio
    public UsuarioJDBC() {
    }
    
    public UsuarioJDBC(Connection conexionTrasaccional) {
        this.conexionTrasaccional = conexionTrasaccional;
    }

    @Override
    public List<UsuarioDTO> seleccionar() throws SQLException {
        Connection conector = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        UsuarioDTO usuario = null;
        List<UsuarioDTO> listaPersona = new ArrayList<>();
        try {
            conector = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conector.prepareStatement(SQL_SELECT);
            result = stmt.executeQuery();
            while (result.next()) {
                int idusuario = result.getInt("idusuario");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String nombreusuario = result.getString("nombreusuario");
                String email = result.getString("email");
                String contraseñauno = result.getString("contraseñauno");
                String contraseñados = result.getString("contraseñados");
                usuario = new UsuarioDTO(idusuario, nombre, apellido,nombreusuario, email, contraseñauno,contraseñados);
                listaPersona.add(usuario);
            }
        }finally {
            try {
                closeRESULT(result);
                closePREPA(stmt);
                if(this.conexionTrasaccional == null){
                    closeMYSQL(conector);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return listaPersona;        
    }

    @Override
    public int insertar(UsuarioDTO usuario) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt  = conectar.prepareStatement(SQL_INSERT);
            stmt.setString(1,usuario.getNombre());
            stmt.setString(2,usuario.getApellido());
            stmt.setString(3,usuario.getNombreUsuario());
            stmt.setString(4,usuario.getEmail());
            stmt.setString(5,usuario.getContraseñaUna());
            stmt.setString(6,usuario.getContraseñaDos());
            registro  = stmt.executeUpdate();
        }finally {
            try {
                closePREPA(stmt);
                if(this.conexionTrasaccional == null){
                    closeMYSQL(conectar);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }

    @Override
    public int actualizar(UsuarioDTO usuario) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
                               
            stmt = conectar.prepareStatement(SQL_UPDATE);
            stmt.setString(1,usuario.getNombre());
            stmt.setString(2,usuario.getApellido());
            stmt.setString(3,usuario.getNombreUsuario());
            stmt.setString(4,usuario.getEmail());
            stmt.setString(5,usuario.getContraseñaUna());
            stmt.setString(6,usuario.getContraseñaDos());
            stmt.setInt(7,usuario.getIdPersona());
            registro  = stmt.executeUpdate();
        }finally {
            try {
                closePREPA(stmt);
                if(this.conexionTrasaccional == null){
                    closeMYSQL(conectar);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }

    @Override
    public int eliminar(UsuarioDTO usuario) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conectar.prepareStatement(SQL_DELETE);
            stmt.setInt(1,usuario.getIdPersona());
            registro  = stmt.executeUpdate();
        }finally {
            try {
                closePREPA(stmt);
                if(this.conexionTrasaccional == null){
                    closeMYSQL(conectar);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }
    
}
