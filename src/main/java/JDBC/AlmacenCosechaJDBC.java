package JDBC;

import DAO.AlmacenCosechaDAO;
import DTO.AlmacenCosechaDTO;
import static MySql.Conexion.closeMYSQL;
import static MySql.Conexion.closePREPA;
import static MySql.Conexion.closeRESULT;
import static MySql.Conexion.getConnection;
import java.sql.*;
import java.util.*;

public class AlmacenCosechaJDBC implements AlmacenCosechaDAO{
    
     private Connection conexionTrasaccional;
    //sentencias
    private static final String SQL_SELECT = "SELECT idalmacencosecha, idterreno, idusuario, cosecha, peso, hectarea, fecha FROM almacencosecha";
    private static final String SQL_INSERT = "INSERT INTO almacencosecha(idterreno, idusuario, cosecha, peso, hectarea, fecha) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE almacencosecha SET idterreno = ?, idusuario = ?, cosecha = ?, peso = ?, hectarea = ?, fecha = ? WHERE idalmacencosecha = ?";
    private static final String SQL_DELETE = "DELETE FROM almacencosecha WHERE idalmacencosecha = ?";
    
    //constrcutor vacio
    public AlmacenCosechaJDBC() {
    }
    
    public AlmacenCosechaJDBC(Connection conexionTrasaccional) {
        this.conexionTrasaccional = conexionTrasaccional;
    }

    @Override
    public List<AlmacenCosechaDTO> seleccionar() throws SQLException {
        Connection conector = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        AlmacenCosechaDTO almacenCosecha = null;
        List<AlmacenCosechaDTO> listaCosecha = new ArrayList<>();
        try {
            conector = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conector.prepareStatement(SQL_SELECT);
            result = stmt.executeQuery();
            while (result.next()) {
                int idalmacencosecha = result.getInt("idalmacencosecha");
                int idterreno = result.getInt("idterreno");
                int idusuario = result.getInt("idusuario");
                String cosecha = result.getString("cosecha");
                String peso = result.getString("peso");
                String hectarea = result.getString("hectarea");
                String fecha = result.getString("fecha");
                almacenCosecha = new AlmacenCosechaDTO(idalmacencosecha, idterreno, idusuario, cosecha, peso, hectarea, fecha);
                listaCosecha.add(almacenCosecha);
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
        return listaCosecha;
    }

    @Override
    public int insertar(AlmacenCosechaDTO almacencosecha) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt  = conectar.prepareStatement(SQL_INSERT);
            stmt.setInt(1,almacencosecha.getIdterreno());
            stmt.setInt(2,almacencosecha.getIdPersona());
            stmt.setString(3,almacencosecha.getProducto());
            stmt.setString(4,almacencosecha.getPeso());
            stmt.setString(5,almacencosecha.getDimension());
            stmt.setString(6,almacencosecha.getFecha());
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
    public int actualizar(AlmacenCosechaDTO almacencosecha) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
                               
            stmt = conectar.prepareStatement(SQL_UPDATE);
            stmt.setInt(1,almacencosecha.getIdterreno());
            stmt.setInt(2,almacencosecha.getIdPersona());
            stmt.setString(3,almacencosecha.getProducto());
            stmt.setString(4,almacencosecha.getPeso());
            stmt.setString(5,almacencosecha.getDimension());
            stmt.setString(6,almacencosecha.getFecha());
            stmt.setInt(7,almacencosecha.getIdalmacenCosecha());            
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
    public int eliminar(AlmacenCosechaDTO almacencosecha) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conectar.prepareStatement(SQL_DELETE);
            stmt.setInt(1,almacencosecha.getIdalmacenCosecha());
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
