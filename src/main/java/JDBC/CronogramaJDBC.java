package JDBC;

import DAO.CronogramaTerrenoDAO;
import DTO.CronogramaDTO;
import static MySql.Conexion.closeMYSQL;
import static MySql.Conexion.closePREPA;
import static MySql.Conexion.closeRESULT;
import static MySql.Conexion.getConnection;
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
         return 0;
    }

    @Override
    public int actualizar(CronogramaDTO cronograma) throws SQLException {
         return 0;
    }

    @Override
    public int eliminar(CronogramaDTO cronograma) throws SQLException {
         return 0;
    }
    
}
