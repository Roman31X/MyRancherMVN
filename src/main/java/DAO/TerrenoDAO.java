package DAO;

import DTO.TerrenoDTO;
import java.sql.SQLException;
import java.util.List;

public interface TerrenoDAO {
    
    public List<TerrenoDTO> seleccionar() throws SQLException;

    public int insertar(TerrenoDTO terreno) throws SQLException;

    public int actualizar(TerrenoDTO terreno) throws SQLException;

    public int eliminar(TerrenoDTO terreno) throws SQLException;
    
}
