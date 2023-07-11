package JDBC;

import DAO.CronogramaTerrenoDAO;
import DTO.CronogramaDTO;
import static MySql.Conexion.*;
import java.sql.*;
import java.util.*;

public class CronogramaJDBC implements CronogramaTerrenoDAO{
    
    private Connection conexionTrasaccional;
    //sentencias
    private static final String SQL_SELECT = "SELECT idcronograma, idterreno, idusuario, propietario, ubicacion, hectarea, fecha, actividad, cultivo, estado FROM cronograma";
    private static final String SQL_INSERT = "INSERT INTO cronograma(idterreno, idusuario, propietario, ubicacion, hectarea, fecha, actividad, cultivo, estado) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE cronograma SET idterreno = ?, idusuario = ?,propietario = ?,ubicacion = ?,hectarea = ?,fecha = ?, actividad = ?, cultivo = ?, estado= ? WHERE idcronograma  = ?";
    private static final String SQL_DELETE = "DELETE FROM cronograma WHERE idcronograma = ?";
    
    //constrcutor vacio
    public CronogramaJDBC() {
    }
    
    public CronogramaJDBC(Connection conexionTrasaccional) {
        this.conexionTrasaccional = conexionTrasaccional;
    }

    @Override
    public List<CronogramaDTO> seleccionar() throws SQLException {
        Connection conector = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        CronogramaDTO cronograma = null;
        List<CronogramaDTO> listaCronograma = new ArrayList<>();
        try {
            conector = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conector.prepareStatement(SQL_SELECT);
            result = stmt.executeQuery();
            while (result.next()) {
                int idcronograma = result.getInt("idcronograma");
                int idterreno = result.getInt("idterreno");
                int idusuario = result.getInt("idusuario");
                String propietario = result.getString("propietario");
                String ubicacion = result.getString("ubicacion");
                String hectarea = result.getString("hectarea");
                String fecha = result.getString("fecha");
                String actividad = result.getString("actividad");
                String cultivo = result.getString("cultivo");
                String estado = result.getString("estado");
                cronograma = new CronogramaDTO(idcronograma, idterreno, idusuario, propietario, ubicacion, hectarea, fecha, actividad, cultivo, estado);
                listaCronograma.add(cronograma);
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
        return listaCronograma; 
    }

    @Override
    public int insertar(CronogramaDTO cronograma) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt  = conectar.prepareStatement(SQL_INSERT);
            stmt.setInt(1,cronograma.getIdterreno());
            stmt.setInt(2,cronograma.getIdPersona());
            stmt.setString(3,cronograma.getPropietario());
            stmt.setString(4,cronograma.getUbicacion());
            stmt.setString(5,cronograma.getHectarea());
            stmt.setString(6,cronograma.getFechactividad());
            stmt.setString(7,cronograma.getActividad());
            stmt.setString(8,cronograma.getCultivo());
            stmt.setString(9,cronograma.getEstadoCronograma());
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
    public int actualizar(CronogramaDTO cronograma) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
                               
            stmt = conectar.prepareStatement(SQL_UPDATE);
            stmt.setInt(1,cronograma.getIdterreno());
            stmt.setInt(2,cronograma.getIdPersona());
            stmt.setString(3,cronograma.getPropietario());
            stmt.setString(4,cronograma.getUbicacion());
            stmt.setString(5,cronograma.getHectarea());
            stmt.setString(6,cronograma.getFechactividad());
            stmt.setString(7,cronograma.getActividad());
            stmt.setString(8,cronograma.getCultivo());
            stmt.setString(9,cronograma.getEstadoCronograma());
            stmt.setInt(10,cronograma.getIdcronograma());
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
    public int eliminar(CronogramaDTO cronograma) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conectar.prepareStatement(SQL_DELETE);
            stmt.setInt(1,cronograma.getIdcronograma());
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
