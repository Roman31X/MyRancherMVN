package Controlador;

import javax.swing.JPanel;

public class ControladorPanelesMenuPrincipal {
   
    public JPanel contenedor;
    public JPanel contenido;

    
    public ControladorPanelesMenuPrincipal(JPanel contenedor3, JPanel contenido3) {
        this.contenedor = contenedor3;
        this.contenido = contenido3;
        
        
        contenedor.removeAll();
        contenedor.add(this.contenido);
        contenedor.revalidate();
        contenedor.repaint();
    }
    
}
