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
    //Atributos objetos
    private final Login controLogin;
    private RegistroUsuario registroLogin;
    private MenuPrincipal menuLogin;
    static int intentos = 5;
    int id;
    
    //Constructor     
    public ControladorLogin(Login controLogin1) {
        this.controLogin = controLogin1;
        
        //funciones
        controLogin.Ingresar.addActionListener(this);
        controLogin.Registrar.addActionListener(this);
        controLogin.Salir.addActionListener(this);
    }
    
    //Mostrar
    public void Mostrar(){
        controLogin.setVisible(true);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {        
        //Atributos
        String accion = e.getActionCommand();
        Connection conexion = null; 
        registroLogin = new RegistroUsuario ();
        menuLogin = new MenuPrincipal();
        
        UsuarioJDBC usuario;
        List<UsuarioDTO> listaUsuario;
        boolean busqueda=false;
        
        //Opcion y funcionalidad
        switch(accion){
            case "INGRESAR": 
                try {
                    conexion = Conexion.getConnection();
                    if(conexion.getAutoCommit()){
                        conexion.setAutoCommit(false);
                    }
                    usuario = new UsuarioJDBC();
                    listaUsuario  = usuario.seleccionar();
                    conexion.commit();
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
                    
                } catch (SQLException ep) {
                    ep.printStackTrace(System.out);
                    System.out.println("Sucedio un error al rollback");
                    try {
                        conexion.rollback();
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                }
                break;
            case "REGISTRAR":
                controLogin.Logologin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenLogin/MyRancher1.png")));
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