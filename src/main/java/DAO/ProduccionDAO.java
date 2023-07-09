package DAO;

import DTO.ProduccionDTO;
import java.sql.SQLException;
import java.util.List;

public interface ProduccionDAO {
    
    public List<ProduccionDTO> seleccionar() throws SQLException;

    public int insertar(ProduccionDTO produccion) throws SQLException;

    public int actualizar(ProduccionDTO produccion) throws SQLException;

    public int eliminar(ProduccionDTO produccion) throws SQLException;
    
}
