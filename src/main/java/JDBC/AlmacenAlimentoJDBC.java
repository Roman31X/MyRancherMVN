package JDBC;

import DAO.AlmacenAlimentoDAO;
import DTO.AlmacenAlimentoDTO;
import static MySql.Conexion.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlmacenAlimentoJDBC implements AlmacenAlimentoDAO{
    
    private Connection conexionTrasaccional;
    //sentencias
    private static final String SQL_SELECT = "SELECT idalmacenalimento, idusuario, tipo, pesounidad, cantidad, pesototal, fecha FROM almacenalimento";
    private static final String SQL_INSERT = "INSERT INTO almacenalimento(idusuario, tipo, pesounidad, cantidad, pesototal, fecha) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE almacenalimento SET idusuario = ?, tipo = ?, pesounidad = ?, cantidad = ?, pesototal = ?, fecha = ? WHERE idalmacenalimento = ?";
    private static final String SQL_DELETE = "DELETE FROM almacenalimento WHERE idalmacenalimento = ?";
    
    //constrcutor vacio
    public AlmacenAlimentoJDBC() {
    }
    
    public AlmacenAlimentoJDBC(Connection conexionTrasaccional) {
        this.conexionTrasaccional = conexionTrasaccional;
    }

    @Override
    public List<AlmacenAlimentoDTO> seleccionar() throws SQLException {
        Connection conector = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        AlmacenAlimentoDTO almacenAlimento = null;
        List<AlmacenAlimentoDTO> listaAlimento = new ArrayList<>();
        try {
            conector = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conector.prepareStatement(SQL_SELECT);
            result = stmt.executeQuery();
            while (result.next()) {
                int idalmacenalimento = result.getInt("idalmacenalimento");
                int idusuario = result.getInt("idusuario");
                String tipo = result.getString("tipo");
                String pesounidad = result.getString("pesounidad");
                String cantidad = result.getNString("cantidad");
                String pesototal = result.getString("pesototal");
                String fecha = result.getString("fecha");
                almacenAlimento = new AlmacenAlimentoDTO(idalmacenalimento, idusuario, tipo, pesounidad,cantidad, pesototal, fecha);
                listaAlimento.add(almacenAlimento);
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
        return listaAlimento;
    }

    @Override
    public int insertar(AlmacenAlimentoDTO almacenalimento) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt  = conectar.prepareStatement(SQL_INSERT);
            stmt.setInt(1,almacenalimento.getIdPersona());
            stmt.setString(2,almacenalimento.getTipoalimento());
            stmt.setString(3,almacenalimento.getPesoSaco());
            stmt.setString(4,almacenalimento.getCantidadSaco());
            stmt.setString(5,almacenalimento.getPesoTotal());
            stmt.setString(6,almacenalimento.getFechaEntrega());
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
    public int actualizar(AlmacenAlimentoDTO almacenalimento) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
                               
            stmt = conectar.prepareStatement(SQL_UPDATE);
            stmt.setInt(1,almacenalimento.getIdPersona());
            stmt.setString(2,almacenalimento.getTipoalimento());
            stmt.setString(3,almacenalimento.getPesoSaco());
            stmt.setString(4,almacenalimento.getCantidadSaco());
            stmt.setString(5,almacenalimento.getPesoTotal());
            stmt.setString(6,almacenalimento.getFechaEntrega());
            stmt.setInt(7,almacenalimento.getIdalmacenAlimento());            
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
    public int eliminar(AlmacenAlimentoDTO almacenalimento) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conectar.prepareStatement(SQL_DELETE);
            stmt.setInt(1,almacenalimento.getIdalmacenAlimento());
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
