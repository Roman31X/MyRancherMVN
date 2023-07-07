package VistaAlmacen;

public class VistaAlmacenAlimento extends javax.swing.JFrame {

    /**
     * Creates new form VistaAlmacenAlimento
     */
    public VistaAlmacenAlimento() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelAlimento = new javax.swing.JPanel();
        ListarAlimento = new javax.swing.JButton();
        CalcularAlimento = new javax.swing.JButton();
        PanelLista = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PanelAlimento.setBackground(new java.awt.Color(255, 255, 255));
        PanelAlimento.setMaximumSize(new java.awt.Dimension(710, 466));
        PanelAlimento.setMinimumSize(new java.awt.Dimension(710, 466));
        PanelAlimento.setPreferredSize(new java.awt.Dimension(710, 466));
        PanelAlimento.setRequestFocusEnabled(false);

        ListarAlimento.setBackground(new java.awt.Color(0, 102, 102));
        ListarAlimento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ListarAlimento.setForeground(new java.awt.Color(255, 255, 255));
        ListarAlimento.setText("LISTAR ALIMENTO");
        ListarAlimento.setPreferredSize(new java.awt.Dimension(140, 25));
        ListarAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarAlimentoActionPerformed(evt);
            }
        });

        CalcularAlimento.setBackground(new java.awt.Color(0, 102, 102));
        CalcularAlimento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CalcularAlimento.setForeground(new java.awt.Color(255, 255, 255));
        CalcularAlimento.setText("CALCULAR CONSUMO");
        CalcularAlimento.setPreferredSize(new java.awt.Dimension(140, 25));
        CalcularAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularAlimentoActionPerformed(evt);
            }
        });

        PanelLista.setBackground(new java.awt.Color(0, 102, 102));
        PanelLista.setPreferredSize(new java.awt.Dimension(698, 398));

        javax.swing.GroupLayout PanelListaLayout = new javax.swing.GroupLayout(PanelLista);
        PanelLista.setLayout(PanelListaLayout);
        PanelListaLayout.setHorizontalGroup(
            PanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        PanelListaLayout.setVerticalGroup(
            PanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelAlimentoLayout = new javax.swing.GroupLayout(PanelAlimento);
        PanelAlimento.setLayout(PanelAlimentoLayout);
        PanelAlimentoLayout.setHorizontalGroup(
            PanelAlimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAlimentoLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(ListarAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CalcularAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(PanelAlimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelAlimentoLayout.setVerticalGroup(
            PanelAlimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAlimentoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelAlimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ListarAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CalcularAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListarAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarAlimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListarAlimentoActionPerformed

    private void CalcularAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularAlimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CalcularAlimentoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton CalcularAlimento;
    public javax.swing.JButton ListarAlimento;
    public javax.swing.JPanel PanelAlimento;
    public javax.swing.JPanel PanelLista;
    // End of variables declaration//GEN-END:variables
}