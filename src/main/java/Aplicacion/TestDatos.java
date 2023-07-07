
package Aplicacion;

import DTO.CronogramaDTO;
import JDBC.CronogramaJDBC;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import MySql.Conexion;


public class TestDatos {
    public static void main(String[] args) {
        Connection conexion = null;
//        String usuario1 = "Roman31X";
//        String contraseña1 = "1234";
//        String nombre;
//        String apellido;

        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            CronogramaJDBC terreno = new CronogramaJDBC();
            List<CronogramaDTO> listaUsuario  = terreno.seleccionar();
            for(CronogramaDTO lista : listaUsuario){
                System.out.println("objeto = " + lista);
            }
            conexion.commit();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Sucedio un error al realback");
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        /*
        if(lista.getNombreUsuario()=="Roman31X"){
                    panel.nombre.setText(lista.getNombre());
                panel.apellido.setText(lista.getApellido());
                panel.correo.setText(lista.getEmail());
                panel.usuario.setText(lista.getNombreUsuario());
                }*/
//        JOptionPane.showMessageDialog(null,"Su terreno a sido regitrado\n"+
//                                                                   "            Exitosamente");
    }
    
}
