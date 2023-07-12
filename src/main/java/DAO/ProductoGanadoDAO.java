package DAO;

import DTO.ProductoGanadoDTO;
import java.sql.SQLException;
import java.util.List;

public interface ProductoGanadoDAO {
    
    public List<ProductoGanadoDTO> seleccionar() throws SQLException;

    public int insertar(ProductoGanadoDTO ganado) throws SQLException;

    public int actualizar(ProductoGanadoDTO ganado) throws SQLException;

    public int eliminar(ProductoGanadoDTO ganado) throws SQLException;
    
}
