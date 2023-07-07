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
    //Atributo Objeto
    private Login controlLogin;
    private final MenuPrincipal controlMenu;
    private static int id;
    
    private GestionMenu menuMenu;
    private GestionModificar menuModificar;
    private GestionPanel panelGif;
    
    //Contructor
    public ControladorMenuPrincipal(MenuPrincipal controlMenu3,int id2) {
        this.controlMenu = controlMenu3;
        this.id = id2;
        controlMenu.Modificar.addActionListener(this);
        controlMenu.MenuPrincipal.addActionListener(this);
        controlMenu.Salir.addActionListener(this);
    }
    
    //Mostrar
    public void Mostrar(){
        controlMenu.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controlLogin = new Login();
        menuMenu = new GestionMenu();
        menuModificar = new GestionModificar();
        panelGif = new GestionPanel();
        ControladorPanelesMenuPrincipal principalInterfaz;
        String accion = e.getActionCommand();
        
        switch(accion){
            case"MODIFICAR":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlMenu.PanelMenu, menuModificar.PanelModificacion);
                Connection conexion = null;
                 try {
                    conexion = Conexion.getConnection();
                    if(conexion.getAutoCommit()){
                        conexion.setAutoCommit(false);
                    }
                    UsuarioJDBC usuario = new UsuarioJDBC();
                    List<UsuarioDTO> listaUsuario  = usuario.seleccionar();
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
                ControladorModificar modificar = new ControladorModificar(controlMenu,menuModificar);
                break;
            case"MENU PRINCIPAL":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlMenu.PanelMenu, menuMenu.PanelMenu);
                ControladorSubMenu segundoMenu = new ControladorSubMenu(menuMenu,id);
                break;
            case"CERRAR SESION":
                principalInterfaz = new ControladorPanelesMenuPrincipal(controlMenu.PanelMenu, panelGif.PanelGif);
                controlMenu.setVisible(false);
                ControladorLogin contrologin = new ControladorLogin(controlLogin); 
                contrologin.Mostrar();
                break;
        }
    }
    
    
}
