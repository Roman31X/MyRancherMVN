package DAO;

import DTO.RegistroGanadoDTO;
import java.sql.SQLException;
import java.util.List;

public interface GanadoDAO {
    
    public List<RegistroGanadoDTO> seleccionar() throws SQLException;

    public int insertar(RegistroGanadoDTO ganado) throws SQLException;

    public int actualizar(RegistroGanadoDTO ganado) throws SQLException;

    public int eliminar(RegistroGanadoDTO ganado) throws SQLException;
    
}
