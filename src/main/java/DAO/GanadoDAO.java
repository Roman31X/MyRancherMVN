package DAO;

import DTO.GanadoDTO;
import java.sql.SQLException;
import java.util.List;

public interface GanadoDAO {
    
    public List<GanadoDTO> seleccionar() throws SQLException;

    public int insertar(GanadoDTO ganado) throws SQLException;

    public int actualizar(GanadoDTO ganado) throws SQLException;

    public int eliminar(GanadoDTO ganado) throws SQLException;
    
}
