package Controlador;

import DTO.UsuarioDTO;
import JDBC.UsuarioJDBC;
import VistaMenu.Login;
import VistaRegistro.RegistroUsuario;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

public class ControladorRegistroUsuario implements ActionListener{
    //Atributos Objetos
    private Login login;
    private final RegistroUsuario registro;
    
    //Constructor
    public ControladorRegistroUsuario(RegistroUsuario registro2) {
        this.registro = registro2;
        
        //Botones
        registro.Registrar.addActionListener(this);
        registro.Limpiar.addActionListener(this);
        registro.Regresar.addActionListener(this); 
    }
    
    //Mostrar
    public void Mostrar(){
        registro.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Identificador
        String accion = e.getActionCommand();
        login = new Login();
        
        UsuarioDTO datosNuevoUsuario;
        UsuarioJDBC insertarNuevoUsuario = new UsuarioJDBC();
        //Funcion
        switch(accion){
            case "REGISTRAR":
                String nombre = registro.nombre.getText();
                String apellido = registro.apellido.getText();
                String nombreUsuario = registro.nombreusuario.getText();
                String correo = registro.correo.getText();
                String contraseñaUno = registro.contraseñauno.getText();
                String contraseñaDos = registro.contraseñados.getText();
                
                String [] nuevoUsuario = {nombre,apellido,correo,nombreUsuario,contraseñaUno,contraseñaDos};
                List datos = Arrays.asList(nuevoUsuario);
                
                if(datos.contains("")){
                    JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos");
                    return;
                }
                
                if(contraseñaUno.equals(contraseñaDos)){
                    
                    //Agregamos al nuevo Usuario
                    datosNuevoUsuario = new UsuarioDTO(nombre,apellido,nombreUsuario,correo,contraseñaUno,contraseñaDos);
                    JOptionPane.showMessageDialog(null," Muy bien su registro fue exitoso\n"+
                                                                   "le damos la Bienvenida a la familia\n"+
                                                                   "                MyRancher\n"+
                                                                   "     ¡YA PUEDE LOGEARSE!");
                    try {
                        insertarNuevoUsuario.insertar(datosNuevoUsuario);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                    registro.setVisible(false);
                    ControladorLogin volverLogin = new ControladorLogin(login);
                    volverLogin.Mostrar();
                }else{
                    JOptionPane.showMessageDialog(null,"La contraseña no coincide");
                }
                break;
            case "LIMPIAR":
                registro.nombre.setText("");
                registro.apellido.setText("");
                registro.nombreusuario.setText("");
                registro.correo.setText("");
                registro.contraseñauno.setText("");
                registro.contraseñados.setText("");
                break;
            case "REGRESAR":
                registro.setVisible(false);
                ControladorLogin volverLogin = new ControladorLogin(login);
                volverLogin.Mostrar();
                break;
        }
    }
    
}
