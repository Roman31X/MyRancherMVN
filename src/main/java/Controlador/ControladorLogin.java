package Controlador;

import DTO.UsuarioDTO;
import JDBC.UsuarioJDBC;
import MySql.Conexion;
import VistaMenu.*;
import VistaRegistro.RegistroUsuario;
import java.awt.event.*;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorLogin implements ActionListener{
    
    private final Login controLogin;
    private RegistroUsuario registroLogin;
    private MenuPrincipal menuLogin;
    static int intentos = 5;
    private int id;
    
    private UsuarioJDBC usuario;
    private List<UsuarioDTO> listaUsuario;
    boolean busqueda=false;
    
        
    public ControladorLogin(Login controLogin1) {
        this.controLogin = controLogin1;
        
        
        controLogin.Ingresar.addActionListener(this);
        controLogin.Registrar.addActionListener(this);
        controLogin.Salir.addActionListener(this);
    }
    
    
    public void Mostrar(){
        controLogin.setVisible(true);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {  
        
        registroLogin = new RegistroUsuario ();
        menuLogin = new MenuPrincipal();
        
        
        Connection conexion = null; 
        
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            usuario = new UsuarioJDBC();
            listaUsuario  = usuario.seleccionar();
            conexion.commit();
        } catch (SQLException ep) {
            ep.printStackTrace(System.out);
            System.out.println("Sucedio un error al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        
        String accion = e.getActionCommand();
        
        switch(accion){
            case "INGRESAR": 
                    for(UsuarioDTO lista : listaUsuario){
                        if(lista.getNombreUsuario().equals(controLogin.usuario.getText()) && lista.getContraseñaUna().equals(controLogin.contraseña.getText())){
                            id = lista.getIdPersona();
                            menuLogin.nombre.setText(lista.getNombre());
                            menuLogin.apellido.setText(lista.getApellido());
                            menuLogin.correo.setText(lista.getEmail());
                            menuLogin.usuario.setText(lista.getNombreUsuario());
                            ControladorMenuPrincipal menuPrincipal = new ControladorMenuPrincipal(menuLogin,id);
                            controLogin.setVisible(false);
                            menuPrincipal.Mostrar();
                            busqueda=true;
                            intentos = 5;
                            break;
                        }
                    }
                    if(busqueda != true) {
                        intentos--;
                        switch(intentos){
                            case 0:
                                System.exit(0);
                                break;
                            case 1:
                                controLogin.Logologin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenLogin/MyRancher4.png")));
                                break;
                            case 2:
                                controLogin.Logologin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenLogin/MyRancher3.png")));
                                break;
                            case 3:
                                controLogin.Logologin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenLogin/MyRancher2.png")));
                                break;
                            case 4:
                                controLogin.Logologin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenLogin/MyRancher1.png")));
                                break;
                        }
                        JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrecta \nvuelva a intentar TE QUEDAN ["+intentos+"]\n intentos permitidos [4]");
                    }
                break;
            case "REGISTRAR":
                intentos = 5;
                ControladorRegistroUsuario registro = new ControladorRegistroUsuario(registroLogin);
                controLogin.setVisible(false);
                registro.Mostrar();                
                break;
            case "SALIR":
                System.exit(0);
                break;
                
        }
    }
    
}
