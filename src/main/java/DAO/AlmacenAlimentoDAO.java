package DAO;

import DTO.AlmacenAlimentoDTO;
import java.sql.SQLException;
import java.util.List;

public interface AlmacenAlimentoDAO {
    
    public List<AlmacenAlimentoDTO> seleccionar() throws SQLException;

    public int insertar(AlmacenAlimentoDTO almacenalimento) throws SQLException;

    public int actualizar(AlmacenAlimentoDTO almacenalimento) throws SQLException;

    public int eliminar(AlmacenAlimentoDTO almacenalimento) throws SQLException;
    
}
