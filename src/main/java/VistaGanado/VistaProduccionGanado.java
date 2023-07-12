package VistaGanado;

public class VistaProduccionGanado extends javax.swing.JFrame {

    /** Creates new form VistaProduccionGanado */
    public VistaProduccionGanado() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelProduccion = new javax.swing.JPanel();
        Modificar = new javax.swing.JButton();
        Agregar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Graficar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProduccion = new javax.swing.JTable();
        PanelGrafica = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PanelProduccion.setBackground(new java.awt.Color(255, 255, 255));
        PanelProduccion.setMaximumSize(new java.awt.Dimension(710, 453));
        PanelProduccion.setMinimumSize(new java.awt.Dimension(710, 453));
        PanelProduccion.setPreferredSize(new java.awt.Dimension(710, 453));

        Modificar.setBackground(new java.awt.Color(0, 102, 102));
        Modificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Modificar.setForeground(new java.awt.Color(255, 255, 255));
        Modificar.setText("MODIFICAR");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        Agregar.setBackground(new java.awt.Color(0, 102, 102));
        Agregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Agregar.setForeground(new java.awt.Color(255, 255, 255));
        Agregar.setText("AGREGAR");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Eliminar.setBackground(new java.awt.Color(0, 102, 102));
        Eliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        Eliminar.setText("ELIMINAR");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Graficar.setBackground(new java.awt.Color(0, 102, 102));
        Graficar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Graficar.setForeground(new java.awt.Color(255, 255, 255));
        Graficar.setText("GRAFICAR");
        Graficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraficarActionPerformed(evt);
            }
        });

        TablaProduccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Mes", "Ganancia"
            }
        ));
        jScrollPane1.setViewportView(TablaProduccion);

        PanelGrafica.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout PanelGraficaLayout = new javax.swing.GroupLayout(PanelGrafica);
        PanelGrafica.setLayout(PanelGraficaLayout);
        PanelGraficaLayout.setHorizontalGroup(
            PanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );
        PanelGraficaLayout.setVerticalGroup(
            PanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelProduccionLayout = new javax.swing.GroupLayout(PanelProduccion);
        PanelProduccion.setLayout(PanelProduccionLayout);
        PanelProduccionLayout.setHorizontalGroup(
            PanelProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProduccionLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(Agregar)
                .addGap(70, 70, 70)
                .addComponent(Modificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Eliminar)
                .addGap(60, 60, 60)
                .addComponent(Graficar)
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProduccionLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(PanelGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelProduccionLayout.setVerticalGroup(
            PanelProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProduccionLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(PanelProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Graficar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelProduccionLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProduccionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgregarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminarActionPerformed

    private void GraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraficarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GraficarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModificarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Agregar;
    public javax.swing.JButton Eliminar;
    public javax.swing.JButton Graficar;
    private javax.swing.JButton Modificar;
    public javax.swing.JPanel PanelGrafica;
    public javax.swing.JPanel PanelProduccion;
    public javax.swing.JTable TablaProduccion;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
