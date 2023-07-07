package DAO;

import DTO.CronogramaDTO;
import java.sql.SQLException;
import java.util.List;

public interface CronogramaTerrenoDAO {
    
    public List<CronogramaDTO> seleccionar() throws SQLException;

    public int insertar(CronogramaDTO cronograma) throws SQLException;

    public int actualizar(CronogramaDTO cronograma) throws SQLException;

    public int eliminar(CronogramaDTO cronograma) throws SQLException;
    
}
