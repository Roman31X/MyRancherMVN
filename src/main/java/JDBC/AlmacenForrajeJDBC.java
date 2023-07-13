package JDBC;

import DAO.AlmacenForrajeDAO;
import DTO.AlmacenForrajeDTO;
import static MySql.Conexion.*;
import java.sql.*;
import java.util.*;

public class AlmacenForrajeJDBC implements AlmacenForrajeDAO{
    
    private Connection conexionTrasaccional;
    //sentencias
    private static final String SQL_SELECT = "SELECT idalmacenforraje, idterreno, idusuario, forraje, muestrauno, muestrados, hectarea, pesototal FROM almacenforraje";
    private static final String SQL_INSERT = "INSERT INTO almacenforraje(idterreno, idusuario, forraje, muestrauno, muestrados, hectarea, pesototal) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE almacenforraje SET idterreno = ?, idusuario = ?, forraje = ?, muestrauno = ?, muestrados = ?, hectarea = ?, pesototal = ? WHERE idalmacenforraje = ?";
    private static final String SQL_DELETE = "DELETE FROM almacenforraje WHERE idalmacenforraje = ?";
    
    //constrcutor vacio
    public AlmacenForrajeJDBC() {
    }
    
    public AlmacenForrajeJDBC(Connection conexionTrasaccional) {
        this.conexionTrasaccional = conexionTrasaccional;
    }

    @Override
    public List<AlmacenForrajeDTO> seleccionar() throws SQLException {
        Connection conector = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        AlmacenForrajeDTO Almacenforraje = null;
        List<AlmacenForrajeDTO> listaTerreno = new ArrayList<>();
        try {
            conector = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conector.prepareStatement(SQL_SELECT);
            result = stmt.executeQuery();
            while (result.next()) {
                int idalmacenforraje = result.getInt("idalmacenforraje");
                int idterreno = result.getInt("idterreno");
                int idusuario = result.getInt("idusuario");
                String forraje = result.getString("forraje");
                String muestrauno = result.getString("muestrauno");
                String muestrados = result.getString("muestrados");
                String hectarea = result.getString("hectarea");
                String pesototal = result.getString("pesototal");
                Almacenforraje = new AlmacenForrajeDTO(idalmacenforraje,idterreno,idusuario,forraje,muestrauno,muestrados,hectarea,pesototal);
                listaTerreno.add(Almacenforraje);
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
    public int insertar(AlmacenForrajeDTO forraje) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt  = conectar.prepareStatement(SQL_INSERT);
            stmt.setInt(1,forraje.getIdterreno());
            stmt.setInt(2,forraje.getIdPersona());
            stmt.setString(3,forraje.getForraje());
            stmt.setString(4,forraje.getMuestra1());
            stmt.setString(5,forraje.getMuestra2());
            stmt.setString(6,forraje.getDimencion());
            stmt.setString(7,forraje.getPesogenerado());
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
    public int actualizar(AlmacenForrajeDTO forraje) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
                               
            stmt = conectar.prepareStatement(SQL_UPDATE);
            stmt.setInt(1,forraje.getIdterreno());
            stmt.setInt(2,forraje.getIdPersona());
            stmt.setString(3,forraje.getForraje());
            stmt.setString(4,forraje.getMuestra1());
            stmt.setString(5,forraje.getMuestra2());
            stmt.setString(6,forraje.getDimencion());
            stmt.setString(7,forraje.getPesogenerado());
            stmt.setInt(8,forraje.getIdalmacenforraje());
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
    public int eliminar(AlmacenForrajeDTO forraje) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conectar.prepareStatement(SQL_DELETE);
            stmt.setInt(1,forraje.getIdalmacenforraje());
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
