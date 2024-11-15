package ProyectoFinal;

import TELEVISORES.ControladorTelevisores;
import TELEVISORES.Televisores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaTelevisores extends javax.swing.JFrame {

    private Carrito carrito;
    private ControladorTelevisores controladorTelevisores;

    public VistaTelevisores(VistaUsuario vistaUsuario) {
        this.vistaUsuario = vistaUsuario;
        initComponents();
        inicializarVista();
    }

    private void inicializarVista() {
        controladorTelevisores = new ControladorTelevisores();
        mostrarTelevisores();
        carrito = new Carrito();

        BtnVERCARRITO.addActionListener(e -> {
            VistaCarritoDeseo vistaCarrito = new VistaCarritoDeseo(vistaUsuario, carrito);
            vistaCarrito.setVisible(true); // Mostrar la vista del carrito
            this.setVisible(false); // Ocultar la vista actual
        });

        BtnCARRITO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = TblTelevisores.getSelectedRow();
                if (filaSeleccionada != -1) {
                    String modeloTelevisor = (String) TblTelevisores.getValueAt(filaSeleccionada, 0);
                    Televisores TelevisorSeleccionado = controladorTelevisores.getTelevisorPorModelo(modeloTelevisor);
                    if (TelevisorSeleccionado != null) {
                        agregarTelevisorAlCarrito(TelevisorSeleccionado);
                    }
                } else {
                    JOptionPane.showMessageDialog(VistaTelevisores.this, "Por favor, selecciona un celular de la lista.");
                }
            }
        });
        BtnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarVistaUsuario();
            }
        });

        TblTelevisores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarEspecificacionesTelevisor();
            }
        });
    }

    private void agregarTelevisorAlCarrito(Televisores televisor) {
        // Agregar el celular al carrito
        carrito.agregarProducto(new Producto(televisor.getModelo(), televisor.getPrecio()));
        JOptionPane.showMessageDialog(this, "Producto agregado al carrito.");
    }

    private VistaUsuario vistaUsuario;

    private void regresarVistaUsuario() {
        vistaUsuario.setVisible(true);
        this.setVisible(false);
    }

    private void mostrarTelevisores() {
        DefaultTableModel model = (DefaultTableModel) TblTelevisores.getModel();
        model.setRowCount(0);

        for (Televisores televisor : controladorTelevisores.getListaTelevisores()) {
            model.addRow(new Object[]{televisor.getModelo(), televisor.getPrecio()});
        }
    }

    private void mostrarEspecificacionesTelevisor() {
        // Obtener la fila seleccionada de la tabla
        int filaSeleccionada = TblTelevisores.getSelectedRow();

        // Si hay una fila seleccionada
        if (filaSeleccionada != -1) {
            // Obtener el modelo del televisor desde la primera columna de la fila seleccionada
            String modeloTelevisor = (String) TblTelevisores.getValueAt(filaSeleccionada, 0);

            // Buscar el televisor por su modelo utilizando el controlador
            Televisores televisorSeleccionado = controladorTelevisores.getTelevisorPorModelo(modeloTelevisor);

            // Si el televisor fue encontrado, mostrar sus especificaciones en el JTextField
            if (televisorSeleccionado != null) {
                TxtEspecificacionesTelevisores.setText(televisorSeleccionado.getEspecificaciones());
            } else {
                TxtEspecificacionesTelevisores.setText("Televisor no encontrado.");
            }
        }
    }

    private void agregarTelevisorAlCarrito() {
        int selectedRow = TblTelevisores.getSelectedRow();
        if (selectedRow != -1) {
            String modelo = (String) TblTelevisores.getValueAt(selectedRow, 0);
            double precio = (double) TblTelevisores.getValueAt(selectedRow, 1);
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
        TxtEspecificacionesTelevisores = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        BtnCARRITO = new javax.swing.JButton();
        BtnAtras = new javax.swing.JButton();
        BtnDESEOS = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        BtnVERCARRITO = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblTelevisores = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Tienda de Angel");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Señor@ usuario, se encuentra en la seccion de Televisores");

        jLabel3.setText("TELEVISORES DISPONIBLES:");

        jLabel4.setText("Especificaciones");

        BtnCARRITO.setText("CARRITO");

        BtnAtras.setText("Atras");

        BtnDESEOS.setText("LISTA DE DESEOS");

        jLabel5.setText("Agregar a:");

        BtnVERCARRITO.setText("VER CARRITO");

        TblTelevisores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Modelo", "Precio"
            }
        ));
        jScrollPane1.setViewportView(TblTelevisores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnAtras)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TxtEspecificacionesTelevisores, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BtnCARRITO)
                                        .addGap(91, 91, 91)
                                        .addComponent(BtnDESEOS)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnVERCARRITO)
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(183, 183, 183))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(381, 381, 381))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(BtnVERCARRITO))
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtEspecificacionesTelevisores, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCARRITO)
                    .addComponent(BtnDESEOS))
                .addComponent(BtnAtras)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtras;
    private javax.swing.JButton BtnCARRITO;
    private javax.swing.JButton BtnDESEOS;
    private javax.swing.JButton BtnVERCARRITO;
    private javax.swing.JTable TblTelevisores;
    private javax.swing.JTextField TxtEspecificacionesTelevisores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
