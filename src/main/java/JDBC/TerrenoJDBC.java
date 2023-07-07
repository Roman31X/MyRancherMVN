package JDBC;

import DAO.TerrenoDAO;
import DTO.TerrenoDTO;
import static MySql.Conexion.*;
import java.sql.*;
import java.sql.SQLException;
import java.util.*;

public class TerrenoJDBC implements TerrenoDAO{
    
    private Connection conexionTrasaccional;
    //sentencias
    private static final String SQL_SELECT = "SELECT idterreno, idusuario, propietario, ubicacion, hectarea, estado FROM terreno";
    private static final String SQL_INSERT = "INSERT INTO terreno(idusuario,propietario, ubicacion, hectarea, estado) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE terreno SET idusuario = ?,propietario = ?,ubicacion = ?,hectarea = ?,estado = ? WHERE idterreno  = ?";
    private static final String SQL_DELETE = "DELETE FROM terreno WHERE idterreno = ?";
    
    //constrcutor vacio
    public TerrenoJDBC() {
    }
    
    public TerrenoJDBC(Connection conexionTrasaccional) {
        this.conexionTrasaccional = conexionTrasaccional;
    }

    @Override
    public List<TerrenoDTO> seleccionar() throws SQLException {
        Connection conector = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        TerrenoDTO terreno = null;
        List<TerrenoDTO> listaTerreno = new ArrayList<>();
        try {
            conector = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conector.prepareStatement(SQL_SELECT);
            result = stmt.executeQuery();
            while (result.next()) {
                int idterreno = result.getInt("idterreno");
                int idusuario = result.getInt("idusuario");
                String propietario = result.getString("propietario");
                String ubicacion = result.getString("ubicacion");
                String hectarea = result.getString("hectarea");
                String estadoTerreno = result.getString("estado");
                terreno = new TerrenoDTO(idterreno,idusuario,propietario,ubicacion,hectarea,estadoTerreno);
                listaTerreno.add(terreno);
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
        return listaTerreno; 
    }

    @Override
    public int insertar(TerrenoDTO terreno) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt  = conectar.prepareStatement(SQL_INSERT);
            stmt.setInt(1,terreno.getIdPersona());
            stmt.setString(2,terreno.getPropietario());
            stmt.setString(3,terreno.getUbicacion());
            stmt.setString(4,terreno.getHectarea());
            stmt.setString(5,terreno.getEstadoTerreno());
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
    public int actualizar(TerrenoDTO terreno) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
                               
            stmt = conectar.prepareStatement(SQL_UPDATE);
            stmt.setInt(1,terreno.getIdterreno());
            stmt.setString(2,terreno.getPropietario());
            stmt.setString(3,terreno.getUbicacion());
            stmt.setString(4,terreno.getHectarea());
            stmt.setString(5,terreno.getEstadoTerreno());
            stmt.setInt(7,terreno.getIdterreno());
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
    public int eliminar(TerrenoDTO terreno) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conectar.prepareStatement(SQL_DELETE);
            stmt.setInt(1,terreno.getIdterreno());
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
