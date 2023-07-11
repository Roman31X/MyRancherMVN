package JDBC;

import DAO.GanadoDAO;
import DTO.GanadoDTO;
import static MySql.Conexion.*;
import java.sql.*;
import java.util.*;

public class GanadoJDBC implements GanadoDAO{
    
    private Connection conexionTrasaccional;
    
    //sentencias
    private static final String SQL_SELECT = "SELECT idganado, idusuario, fechanacimiento, edad, raza, sexo, tipo, numerocrias FROM ganado";
    private static final String SQL_INSERT = "INSERT INTO ganado(idusuario, fechanacimiento, edad, raza, sexo, tipo, numerocrias) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE ganado SET idusuario = ?, fechanacimiento = ?, edad = ?, raza = ?, sexo = ?, tipo = ?, numerocrias = ?  WHERE idganado = ?";
    private static final String SQL_DELETE = "DELETE FROM ganado WHERE idganado = ?";
    
    //constrcutor vacio
    public GanadoJDBC() {
    }
    
    public GanadoJDBC(Connection conexionTrasaccional) {
        this.conexionTrasaccional = conexionTrasaccional;
    }

    @Override
    public List<GanadoDTO> seleccionar() throws SQLException {
        Connection conector = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        GanadoDTO ganado = null;
        List<GanadoDTO> listaGanado = new ArrayList<>();
        try {
            conector = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conector.prepareStatement(SQL_SELECT);
            result = stmt.executeQuery();
            while (result.next()) {
                int idganado = result.getInt("idganado");
                int idusuario = result.getInt("idusuario");
                String fechanacimiento = result.getString("fechanacimiento");
                String edad = result.getString("edad");
                String raza = result.getString("raza");
                String sexo = result.getString("sexo");
                String tipo = result.getString("tipo");
                String numerocrias = result.getString("numerocrias");
                
                ganado = new GanadoDTO(idganado,idusuario,fechanacimiento, edad, raza, sexo, tipo, numerocrias);
                listaGanado.add(ganado);
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
        return listaGanado;
    }
        

    @Override
    public int insertar(GanadoDTO ganado) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt  = conectar.prepareStatement(SQL_INSERT);
            stmt.setInt(1,ganado.getIdPersona());
            stmt.setString(2,ganado.getFechaNacimiento());
            stmt.setString(3,ganado.getEdad());
            stmt.setString(4,ganado.getRaza());
            stmt.setString(5,ganado.getSexo());
            stmt.setString(6,ganado.getTipoGanado());
            stmt.setString(7,ganado.getNumeroCrias());
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
    public int actualizar(GanadoDTO ganado) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            
            stmt = conectar.prepareStatement(SQL_UPDATE);
            stmt.setInt(1,ganado.getIdPersona());
            stmt.setString(2,ganado.getFechaNacimiento());
            stmt.setString(3,ganado.getEdad());
            stmt.setString(4,ganado.getRaza());
            stmt.setString(5,ganado.getSexo());
            stmt.setString(6,ganado.getTipoGanado());
            stmt.setString(7,ganado.getNumeroCrias());
            stmt.setInt(8,ganado.getIdGanado());
            
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
    public int eliminar(GanadoDTO ganado) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conectar.prepareStatement(SQL_DELETE);
            stmt.setInt(1,ganado.getIdGanado());
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
