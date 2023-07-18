package Controlador;

import DTO.UsuarioDTO;
import JDBC.UsuarioJDBC;
import MySql.Conexion;
import VistaMenu.*;
import VistaPaneles.*;
import java.awt.event.*;
import java.sql.*;
import java.util.List;

public class ControladorMenuPrincipal implements ActionListener{
    
    private Login controlLogin;
    private final MenuPrincipal controlMenu;
    private static int id;
    
    private GestionMenu menuMenu;
    private GestionModificar menuModificar;
    private GestionPanel panelGif;
    
    private UsuarioJDBC usuario;
    private List<UsuarioDTO> listaUsuario;
    
    private ControladorPanelesMenuPrincipal principalInterfaz;
    private ControladorModificar modificar;
    private ControladorSubMenu segundoMenu;
    private ControladorLogin contrologin;
 
    public ControladorMenuPrincipal(MenuPrincipal controlMenu3,int id2) {
        this.controlMenu = controlMenu3;
        this.id = id2;
        controlMenu.Modificar.addActionListener(this);
        controlMenu.MenuPrincipal.addActionListener(this);
        controlMenu.Salir.addActionListener(this);
    }
    
    
    public void Mostrar(){
        controlMenu.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        controlLogin = new Login();
        menuMenu = new GestionMenu();
        menuModificar = new GestionModificar();
        panelGif = new GestionPanel();
        
        Connection conexion = null;
        try {
        conexion = Conexion.getConnection();
        if(conexion.getAutoCommit()){
            conexion.setAutoCommit(false);
        }
        usuario = new UsuarioJDBC();
        listaUsuario  = usuario.seleccionar();
        conexion.commit();
        } catch (SQLException p) {
            p.printStackTrace(System.out);
            System.out.println("Sucedio un error al realback");
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        String accion = e.getActionCommand();
        switch(accion){
            case"MODIFICAR":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlMenu.PanelMenu, menuModificar.PanelModificacion);
                for(UsuarioDTO lista : listaUsuario){
                    if(lista.getNombreUsuario().equals(controlMenu.usuario.getText())){
                        menuModificar.Id.setText(Integer.toString(lista.getIdPersona()));
                        menuModificar.nombre.setText(lista.getNombre());
                        menuModificar.apellido.setText(lista.getApellido());
                        menuModificar.usuario.setText(lista.getNombreUsuario());
                        menuModificar.email.setText(lista.getEmail());
                        menuModificar.contraseña.setText(lista.getContraseñaUna());

                        menuModificar.nuevoNombre.setText(lista.getNombre());
                        menuModificar.nuevoApellido.setText(lista.getApellido());
                        menuModificar.nuevoUsuario.setText(lista.getNombreUsuario());
                        menuModificar.nuevoEmail.setText(lista.getEmail());
                        menuModificar.nuevaContraseña.setText(lista.getContraseñaUna());
                        break;
                    }
                }
                modificar = new ControladorModificar(controlMenu,menuModificar);
                break;
            case"MENU PRINCIPAL":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlMenu.PanelMenu, menuMenu.PanelMenu);
                segundoMenu = new ControladorSubMenu(menuMenu,id);
                break;
            case"CERRAR SESION":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlMenu.PanelMenu, panelGif.PanelGif);
                controlMenu.setVisible(false);
                contrologin = new ControladorLogin(controlLogin); 
                contrologin.Mostrar();
                break;
        }
    }
    
    
}
