package JDBC;

import DAO.ProductoGanadoDAO;
import DTO.ProductoGanadoDTO;
import static MySql.Conexion.closeMYSQL;
import static MySql.Conexion.closePREPA;
import static MySql.Conexion.closeRESULT;
import static MySql.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoGanadoJDBC implements ProductoGanadoDAO{
    
    private Connection conexionTrasaccional;
    
    //sentencias
    private static final String SQL_SELECT = "SELECT idusuario, producto, mes, ganancia FROM productoganado";
    private static final String SQL_INSERT = "INSERT INTO productoganado(idusuario, producto, mes, ganancia) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE productoganado SET idusuario = ?, producto = ?, mes = ?, ganancia = ? WHERE iproductoganado = ?";
    private static final String SQL_DELETE = "DELETE FROM productoganado WHERE idproductoganado = ?";
    
    //constrcutor vacio
    public ProductoGanadoJDBC() {
    }
    
    public ProductoGanadoJDBC(Connection conexionTrasaccional) {
        this.conexionTrasaccional = conexionTrasaccional;
    }


    @Override
    public List<ProductoGanadoDTO> seleccionar() throws SQLException {
        Connection conector = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        ProductoGanadoDTO productoGanado = null;
        List<ProductoGanadoDTO> listaProducto = new ArrayList<>();
        try {
            conector = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conector.prepareStatement(SQL_SELECT);
            result = stmt.executeQuery();
            while (result.next()) {
                int idproductoganado = result.getInt("idusuario");
                int idusuario = result.getInt("idusuario");
                String producto = result.getString("producto");
                String mes = result.getString("mes");
                String ganancia = result.getString("ganancia");
                productoGanado = new ProductoGanadoDTO(idproductoganado,idusuario, mes,producto,ganancia);
                listaProducto.add(productoGanado);
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
        return listaProducto; 
    }

    @Override
    public int insertar(ProductoGanadoDTO ganado) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt  = conectar.prepareStatement(SQL_INSERT);
            stmt.setInt(1,ganado.getIdPersona());
            stmt.setString(2,ganado.getProducto());
            stmt.setString(3,ganado.getMes());
            stmt.setString(4,ganado.getGanancia());
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
    public int actualizar(ProductoGanadoDTO ganado) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
                               
            stmt = conectar.prepareStatement(SQL_UPDATE);
            stmt.setInt(1,ganado.getIdPersona());
            stmt.setString(2,ganado.getProducto());
            stmt.setString(3,ganado.getMes());
            stmt.setString(4,ganado.getGanancia());
            stmt.setInt(5,ganado.getIdproduccionGanado());
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
    public int eliminar(ProductoGanadoDTO ganado) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conectar.prepareStatement(SQL_DELETE);
            stmt.setInt(1,ganado.getIdproduccionGanado());
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
