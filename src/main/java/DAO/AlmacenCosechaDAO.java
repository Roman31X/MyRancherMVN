package DAO;

import DTO.AlmacenCosechaDTO;
import java.sql.SQLException;
import java.util.List;

public interface AlmacenCosechaDAO {
    
    public List<AlmacenCosechaDTO> seleccionar() throws SQLException;

    public int insertar(AlmacenCosechaDTO almacencosecha) throws SQLException;

    public int actualizar(AlmacenCosechaDTO almacencosecha) throws SQLException;

    public int eliminar(AlmacenCosechaDTO almacencosecha) throws SQLException;
    
}
