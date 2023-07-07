
package Aplicacion;

import Controlador.ControladorLogin;
import VistaMenu.Login;

public class AplicacionMyRancher {
    
    public static void main(String[] args) {
        
        Login login = new Login();
        
        ControladorLogin control = new ControladorLogin(login);
        
        control.Mostrar();
    }
}
