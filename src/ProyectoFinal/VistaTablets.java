package ProyectoFinal;

import TABLETS.ControladorTablets;
import TABLETS.Tablets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaTablets extends javax.swing.JFrame {

    private Carrito carrito;
    private ControladorTablets controladorTablets;

    public VistaTablets(VistaUsuario vistaUsuario) {
        this.vistaUsuario = vistaUsuario;
        initComponents();
        inicializarVista();
    }

    // Método para inicializar la vista
    private void inicializarVista() {
        controladorTablets = new ControladorTablets();
        mostrarTablets();
        carrito = new Carrito();

        BtnVERCARRITO.addActionListener(e -> {
            VistaCarritoDeseo vistaCarrito = new VistaCarritoDeseo(vistaUsuario, carrito);
            vistaCarrito.setVisible(true); // Mostrar la vista del carrito
            this.setVisible(false); // Ocultar la vista actual
        });

        BtnCARRITO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = TblTablets.getSelectedRow();
                if (filaSeleccionada != -1) {
                    String modeloTablet = (String) TblTablets.getValueAt(filaSeleccionada, 0);
                    Tablets TabletSeleccionada = controladorTablets.getTabletPorModelo(modeloTablet);
                    if (TabletSeleccionada != null) {
                        agregarTabletAlCarrito(TabletSeleccionada);
                    }
                } else {
                    JOptionPane.showMessageDialog(VistaTablets.this, "Por favor, selecciona un celular de la lista.");
                }
            }
        });

        BtnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarVistaUsuario();
            }
        });

        TblTablets.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarEspecificacionesTablet();
            }
        });
    }

    private void agregarTabletAlCarrito(Tablets tablet) {
        // Agregar el celular al carrito
        carrito.agregarProducto(new Producto(tablet.getModelo(), tablet.getPrecio()));
        JOptionPane.showMessageDialog(this, "Producto agregado al carrito.");
    }

    private VistaUsuario vistaUsuario;  // Referencia a VistaUsuario

    // Método para regresar a VistaUsuario
    private void regresarVistaUsuario() {
        vistaUsuario.setVisible(true);  // Mostramos la VistaUsuario
        this.setVisible(false);  // Ocultamos la VistaTablets
    }

    // Método para mostrar la lista de tablets en la JTable
    private void mostrarTablets() {
        DefaultTableModel model = (DefaultTableModel) TblTablets.getModel();
        model.setRowCount(0); // Limpiar la tabla

        for (Tablets tablet : controladorTablets.getListaTablets()) {
            model.addRow(new Object[]{tablet.getModelo(), tablet.getPrecio()});
        }
    }

    private void mostrarEspecificacionesTablet() {
        // Obtener la fila seleccionada de la tabla
        int filaSeleccionada = TblTablets.getSelectedRow();

        // Si hay una fila seleccionada
        if (filaSeleccionada != -1) {
            // Obtener el modelo de la tablet desde la primera columna de la fila seleccionada
            String modeloTablet = (String) TblTablets.getValueAt(filaSeleccionada, 0);

            // Buscar la tablet por su modelo utilizando el controlador
            Tablets tabletSeleccionado = controladorTablets.getTabletPorModelo(modeloTablet);

            // Si la tablet fue encontrada, mostrar sus especificaciones en el JTextField
            if (tabletSeleccionado != null) {
                TxtEspecificacionesTablets.setText(tabletSeleccionado.getEspecificaciones());
            } else {
                TxtEspecificacionesTablets.setText("Tablet no encontrada.");
            }
        }
    }

    // Método para agregar una tablet al carrito
    private void agregarTabletAlCarrito() {
        int selectedRow = TblTablets.getSelectedRow();
        if (selectedRow != -1) {
            String modelo = (String) TblTablets.getValueAt(selectedRow, 0);
            double precio = (double) TblTablets.getValueAt(selectedRow, 1);
            Producto producto = new Producto(modelo, precio);
            carrito.agregarProducto(producto);
            System.out.println("Producto añadido: " + producto);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        TxtEspecificacionesTablets = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        BtnCARRITO = new javax.swing.JButton();
        BtnAtras = new javax.swing.JButton();
        BtnDESEOS = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        BtnVERCARRITO = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblTablets = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Tienda de Angel");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Señor@ usuario, se encuentra en la seccion de Tablets");

        jLabel3.setText("TABLETS DISPONIBLES:");

        jLabel4.setText("Especificaciones");

        BtnCARRITO.setText("CARRITO");
        BtnCARRITO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCARRITOActionPerformed(evt);
            }
        });

        BtnAtras.setText("Atras");
        BtnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtrasActionPerformed(evt);
            }
        });

        BtnDESEOS.setText("LISTA DE DESEOS");
        BtnDESEOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDESEOSActionPerformed(evt);
            }
        });

        jLabel5.setText("Agregar a:");

        BtnVERCARRITO.setText("VER CARRITO");

        TblTablets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Modelo", "Precio"
            }
        ));
        jScrollPane1.setViewportView(TblTablets);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(148, 148, 148))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnCARRITO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnDESEOS)
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(299, 299, 299))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnVERCARRITO)
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparator2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                                .addComponent(TxtEspecificacionesTablets, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BtnAtras))))
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(BtnVERCARRITO))
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtEspecificacionesTablets, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnAtras)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnCARRITO)
                            .addComponent(BtnDESEOS))
                        .addGap(67, 67, 67))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnDESEOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDESEOSActionPerformed

    }//GEN-LAST:event_BtnDESEOSActionPerformed

    private void BtnCARRITOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCARRITOActionPerformed

    }//GEN-LAST:event_BtnCARRITOActionPerformed

    private void BtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtrasActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BtnAtrasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtras;
    private javax.swing.JButton BtnCARRITO;
    private javax.swing.JButton BtnDESEOS;
    private javax.swing.JButton BtnVERCARRITO;
    private javax.swing.JTable TblTablets;
    private javax.swing.JTextField TxtEspecificacionesTablets;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
