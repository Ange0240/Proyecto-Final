package ProyectoFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaUsuario extends javax.swing.JFrame {

    private Vista vistaPrincipal;  // Referencia a VistaPrincipal

    public VistaUsuario(Vista vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;  // Recibimos la referencia de VistaPrincipal
        initComponents();
        inicializarVista();
    }

    private void inicializarVista() {
        BtnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarVistaPrincipal();
            }
        });

        BtnCELULARES.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                irAVistaCelulares();
            }
        });

        BtnTABLETS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                irAVistaTablets();
            }
        });

        BtnTELEVISORES.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                irAVistaTelevisores();
            }
        });

        BtnPC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                irAVistaPC();
            }
        });
        BtnVERCARRITO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCarrito();
            }
        });
    }

    private void mostrarCarrito() {
        System.out.println("Contenido del carrito:");
    }

    // Método para volver a VistaPrincipal
    private void volverVistaPrincipal() {
        Vista vistaPrincipal = new Vista();
        vistaPrincipal.setVisible(true); // Muestra VistaPrincipal
        this.setVisible(false); // Oculta VistaUsuario
    }

    // Método para ir a VistaCelulares
    private void irAVistaCelulares() {
        VistaCelulares vistaCelulares = new VistaCelulares(this);
        vistaCelulares.setVisible(true);
        this.setVisible(false);  // Oculta la VistaUsuario
    }

    // Método para ir a VistaTablets
    private void irAVistaTablets() {
        // Pasamos la referencia de VistaUsuario al constructor de VistaTablets
        VistaTablets vistaTablets = new VistaTablets(this);
        vistaTablets.setVisible(true); // Muestra VistaTablets
        this.setVisible(false); // Oculta VistaUsuario
    }

// Método para ir a VistaTelevisores
    private void irAVistaTelevisores() {
        // Pasamos la referencia de VistaUsuario al constructor de VistaTelevisores
        VistaTelevisores vistaTelevisores = new VistaTelevisores(this);
        vistaTelevisores.setVisible(true); // Muestra VistaTelevisores
        this.setVisible(false); // Oculta VistaUsuario
    }

// Método para ir a VistaPC
    private void irAVistaPC() {
        // Pasamos la referencia de VistaUsuario al constructor de VistaPC
        VistaPc vistaPc = new VistaPc(this);
        vistaPc.setVisible(true); // Muestra VistaPC
        this.setVisible(false); // Oculta VistaUsuario
    }

    // Método para regresar a VistaPrincipal
    private void regresarVistaPrincipal() {
        vistaPrincipal.setVisible(true);  // Mostramos la VistaPrincipal
        vistaPrincipal.actualizarTabla();  // Actualizamos la tabla con los usuarios registrados
        this.setVisible(false);  // Ocultamos la VistaUsuario
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtnCELULARES = new javax.swing.JButton();
        BtnTELEVISORES = new javax.swing.JButton();
        BtnTABLETS = new javax.swing.JButton();
        BtnPC = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        BtnAtras = new javax.swing.JButton();
        BtnVERCARRITO = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Tienda de Angel");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Se encuentra en la sección productos señor@ usuario");

        BtnCELULARES.setText("CELULARES");

        BtnTELEVISORES.setText("TELEVISORES");
        BtnTELEVISORES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTELEVISORESActionPerformed(evt);
            }
        });

        BtnTABLETS.setText("TABLETS");

        BtnPC.setText("PC");

        BtnAtras.setText("Atras");

        BtnVERCARRITO.setText("VER CARRITO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnAtras)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnCELULARES, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnPC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnTELEVISORES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnTABLETS, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnVERCARRITO)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(BtnVERCARRITO))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCELULARES, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnTELEVISORES, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnPC, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnTABLETS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(BtnAtras)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnTELEVISORESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTELEVISORESActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnTELEVISORESActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtras;
    private javax.swing.JButton BtnCELULARES;
    private javax.swing.JButton BtnPC;
    private javax.swing.JButton BtnTABLETS;
    private javax.swing.JButton BtnTELEVISORES;
    private javax.swing.JButton BtnVERCARRITO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
