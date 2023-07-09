package JDBC;

import DAO.ProduccionDAO;
import DTO.ProduccionDTO;
import static MySql.Conexion.*;
import java.sql.*;
import java.util.*;

public class ProduccionJDBC implements ProduccionDAO{
    
    private Connection conexionTrasaccional;
    //sentencias
    private static final String SQL_SELECT = "SELECT idproduccion,idterreno, idusuario, propietario, ubicacion, hectarea, cosecha, pesototal, precio, ganancia, fecha FROM produccion";
    private static final String SQL_INSERT = "INSERT INTO produccion(idterreno, idusuario, propietario, ubicacion, hectarea, cosecha, pesototal, precio, ganancia, fecha) VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE produccion SET idterreno = ?, idusuario = ?, propietario = ?, ubicacion = ?, hectarea = ?, cosecha = ?, pesototal = ?, precio = ?, ganancia = ?, fecha = ? WHERE idproduccion  = ?";
    private static final String SQL_DELETE = "DELETE FROM produccion WHERE idproduccion = ?";
    
    //constrcutor vacio
    public ProduccionJDBC() {
    }
    
    public ProduccionJDBC(Connection conexionTrasaccional) {
        this.conexionTrasaccional = conexionTrasaccional;
    }

    @Override
    public List<ProduccionDTO> seleccionar() throws SQLException {
        Connection conector = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        ProduccionDTO produccion = null;
        List<ProduccionDTO> listaProduccion = new ArrayList<>();
        try {
            conector = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conector.prepareStatement(SQL_SELECT);
            result = stmt.executeQuery();
            while (result.next()) {
                int idproduccion = result.getInt("idproduccion");
                int idterreno = result.getInt("idterreno");
                int idusuario = result.getInt("idusuario");
                String propietario = result.getString("propietario");
                String ubicacion = result.getString("ubicacion");
                String hectarea = result.getString("hectarea");
                String cosecha = result.getString("cosecha");
                String pesoCosecha = result.getString("pesototal");
                String precio = result.getString("precio");
                String ganancia = result.getString("ganancia");
                String fecha = result.getString("fecha");
                produccion = new ProduccionDTO(idproduccion,idterreno,idusuario,propietario,ubicacion,hectarea,cosecha, pesoCosecha, precio, ganancia, fecha);
                listaProduccion.add(produccion);
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
        return listaProduccion;
    }

    @Override
    public int insertar(ProduccionDTO produccion) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt  = conectar.prepareStatement(SQL_INSERT);
            stmt.setInt(1,produccion.getIdterreno());
            stmt.setInt(2,produccion.getIdPersona());
            stmt.setString(3,produccion.getPropietario());
            stmt.setString(4,produccion.getUbicacion());
            stmt.setString(5,produccion.getHectarea());
            stmt.setString(6,produccion.getCosecha());
            stmt.setString(7,produccion.getPesocosecha());
            stmt.setString(8,produccion.getPrecio());
            stmt.setString(9,produccion.getGanacia());
            stmt.setString(10,produccion.getFechaincriccion());
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
    public int actualizar(ProduccionDTO produccion) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
                               
            stmt = conectar.prepareStatement(SQL_UPDATE);
            stmt.setInt(1,produccion.getIdterreno());
            stmt.setInt(2,produccion.getIdPersona());
            stmt.setString(3,produccion.getPropietario());
            stmt.setString(4,produccion.getUbicacion());
            stmt.setString(5,produccion.getHectarea());
            stmt.setString(6,produccion.getCosecha());
            stmt.setString(7,produccion.getPesocosecha());
            stmt.setString(8,produccion.getPrecio());
            stmt.setString(9,produccion.getGanacia());
            stmt.setString(10,produccion.getFechaincriccion());
            stmt.setInt(11,produccion.getIdregistrocosecha());
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
    public int eliminar(ProduccionDTO produccion) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conectar.prepareStatement(SQL_DELETE);
            stmt.setInt(1,produccion.getIdregistrocosecha());
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
