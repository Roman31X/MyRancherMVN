package DAO;

import DTO.AlmacenForrajeDTO;
import java.sql.SQLException;
import java.util.List;

public interface AlmacenForrajeDAO {
    
    public List<AlmacenForrajeDTO> seleccionar() throws SQLException;

    public int insertar(AlmacenForrajeDTO forraje) throws SQLException;

    public int actualizar(AlmacenForrajeDTO forraje) throws SQLException;

    public int eliminar(AlmacenForrajeDTO forraje) throws SQLException;
    
}
