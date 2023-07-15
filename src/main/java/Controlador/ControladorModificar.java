package Controlador;

import DTO.UsuarioDTO;
import JDBC.UsuarioJDBC;
import VistaMenu.MenuPrincipal;
import VistaPaneles.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

public class ControladorModificar implements ActionListener{
    //Atributos
    private final MenuPrincipal controlPrincipal;
    private final GestionModificar controlModificar;
    
    //Constructor
    
    public ControladorModificar(MenuPrincipal controlPrincipal1, GestionModificar controlModificar1) {
        this.controlPrincipal = controlPrincipal1;
        this.controlModificar = controlModificar1;
        controlModificar.ModificarDatos.addActionListener(this);
    }
    
    //Accion
    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        UsuarioDTO updateUsuario;
        UsuarioJDBC nuevaData = new UsuarioJDBC();
        switch(accion){
            case"MODIFICAR DATOS":
                int idusuario = Integer.parseInt(controlModificar.Id.getText());
                String nuevoNombre = controlModificar.nuevoNombre.getText();
                String nuevoApellido = controlModificar.nuevoApellido.getText();
                String nuevoUsuario = controlModificar.nuevoUsuario.getText();
                String nuevoEmail = controlModificar.nuevoEmail.getText();
                String nuevaContraseñaUno = controlModificar.nuevaContraseña.getText();
                String nuevaConstraseñaDos = nuevaContraseñaUno;
                
                String [] campos = {nuevoNombre,nuevoApellido,nuevoUsuario,nuevoEmail,nuevaContraseñaUno};
                List datos = Arrays.asList(campos);
                
                if(datos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos");
                    return;
                }
                
                //Enviamos los nuevos datos para actualizar
                updateUsuario = new UsuarioDTO(idusuario,nuevoNombre,nuevoApellido,nuevoUsuario,nuevoEmail,nuevaContraseñaUno,nuevaConstraseñaDos);
                try {
                    nuevaData.actualizar(updateUsuario);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                
                //Actualizar Data Panel Principal
                controlPrincipal.nombre.setText(nuevoNombre);
                controlPrincipal.apellido.setText(nuevoApellido);
                controlPrincipal.correo.setText(nuevoEmail);
                controlPrincipal.usuario.setText(nuevoUsuario);
                
                //Actualizar Panel Modificar
                controlModificar.nombre.setText(nuevoNombre);
                controlModificar.apellido.setText(nuevoApellido);
                controlModificar.usuario.setText(nuevoUsuario);
                controlModificar.email.setText(nuevoEmail);
                controlModificar.contraseña.setText(nuevaContraseñaUno);
                break;

            
        }
    }
}
