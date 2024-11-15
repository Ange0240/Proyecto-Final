package ProyectoFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaCarritoDeseo extends javax.swing.JFrame {

    private DefaultTableModel modeloCarrito;
    private DefaultTableModel modeloDeseos;
    private Carrito carrito;
    private VistaUsuario vistaUsuario;

    public VistaCarritoDeseo(VistaUsuario vistaUsuario, Carrito carrito) {
        this.vistaUsuario = vistaUsuario;
        this.carrito = carrito;
        initComponents();
        inicializarVista();
    }

    private void inicializarVista() {
        // Configurar el modelo para la tabla del carrito (jTable1)
        modeloCarrito = new DefaultTableModel();
        modeloCarrito.addColumn("Producto");
        modeloCarrito.addColumn("Precio");
        TblCarrito.setModel(modeloCarrito);
        BtnELIMINARDESEO.addActionListener(e -> eliminarProductoDeDeseos());
        BtnELIMINARPRODUCTO.addActionListener(e -> eliminarProductoDelCarrito());
        BtnCOMPRAR.addActionListener(e -> realizarCompra());

        // Configurar el modelo para la tabla de deseos (TblDeseos)
        modeloDeseos = new DefaultTableModel();
        modeloDeseos.addColumn("Producto");
        modeloDeseos.addColumn("Precio");
        TblDeseos.setModel(modeloDeseos);

        // Cargar datos iniciales
        cargarCarrito();
        cargarDeseos();

        // Evento para regresar a VistaUsuario
        BtnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarVistaUsuario();
            }
        });

        // Evento para comprar los productos del carrito
        BtnCOMPRAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarCompra();
            }
        });

        // Evento para eliminar un producto de la lista de deseos
        BtnELIMINARDESEO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProductoDeDeseos();
            }
        });
    }

private void cargarCarrito() {
    DefaultTableModel model = (DefaultTableModel) TblCarrito.getModel();
    model.setRowCount(0); // Limpia la tabla

    for (Producto producto : Carrito.getInstancia().obtenerProductos()) {
        model.addRow(new Object[]{producto.getNombre(), producto.getPrecio()});
    }
}

private void cargarDeseos() {
    DefaultTableModel model = (DefaultTableModel) TblDeseos.getModel();
    model.setRowCount(0); // Limpia la tabla

    for (Producto producto : Carrito.getInstancia().obtenerListaDeseos()) {
        model.addRow(new Object[]{producto.getNombre(), producto.getPrecio()});
    }
}

    private void regresarVistaUsuario() {
        vistaUsuario.setVisible(true);
        dispose(); // Cerrar esta vista
    }

    private void eliminarProductoDelCarrito() {
        int filaSeleccionada = TblCarrito.getSelectedRow(); //
        if (filaSeleccionada != -1) {
            String nombreProducto = (String) TblCarrito.getValueAt(filaSeleccionada, 0);

            int confirmacion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Está seguro que desea eliminar este producto del carrito?",
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                carrito.eliminarProductoPorNombre(nombreProducto); // Necesitamos agregar este método
                JOptionPane.showMessageDialog(this, "Producto eliminado del carrito.");
                cargarCarrito(); // Actualiza la tabla del carrito
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar.");
        }
    }

    private void eliminarProductoDeDeseos() {
        int filaSeleccionada = TblDeseos.getSelectedRow();
        if (filaSeleccionada != -1) {
            String nombreProducto = (String) TblDeseos.getValueAt(filaSeleccionada, 0);

            int confirmacion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Está seguro que desea eliminar este producto de los deseos?",
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                carrito.eliminarDeseoPorNombre(nombreProducto);
                JOptionPane.showMessageDialog(this, "Producto eliminado de la lista de deseos.");
                cargarDeseos(); // Actualiza la tabla de deseos
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar.");
        }
    }

    private void realizarCompra() {
        double total = carrito.calcularTotal();

        if (total == 0) {
            JOptionPane.showMessageDialog(this, "El carrito está vacío.");
            return;
        }

        String input = JOptionPane.showInputDialog(
                this,
                "El total de la compra es $" + total + ". Ingrese el monto a pagar:"
        );

        if (input != null) {
            try {
                double montoIngresado = Double.parseDouble(input);

                if (montoIngresado >= total) {
                    double cambio = montoIngresado - total;
                    JOptionPane.showMessageDialog(this, "Compra realizada con éxito. Su cambio es $" + cambio);
                    carrito.vaciarCarrito();
                    cargarCarrito(); // Actualiza la tabla del carrito
                } else {
                    JOptionPane.showMessageDialog(this, "Monto insuficiente. El total es $" + total);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblCarrito = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblDeseos = new javax.swing.JTable();
        BtnCOMPRAR = new javax.swing.JButton();
        BtnELIMINARPRODUCTO = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BtnAtras = new javax.swing.JButton();
        BtnELIMINARDESEO = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Tienda de Angel");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Aqui podrá ver su Carrito y su lista de deseos");

        TblCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Costo"
            }
        ));
        jScrollPane1.setViewportView(TblCarrito);

        TblDeseos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Costro"
            }
        ));
        jScrollPane2.setViewportView(TblDeseos);

        BtnCOMPRAR.setText("COMPRAR");

        BtnELIMINARPRODUCTO.setText("ELIMINAR");

        jLabel3.setText("SU CARRITO");

        jLabel5.setText("SUS DESEOS");

        BtnAtras.setText("Atras");

        BtnELIMINARDESEO.setText("ELIMINAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(281, 281, 281))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BtnAtras)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(BtnCOMPRAR)
                                .addComponent(BtnELIMINARPRODUCTO))
                            .addGap(62, 62, 62)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                            .addComponent(BtnELIMINARDESEO)
                            .addGap(21, 21, 21))))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(306, 306, 306)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(17, 17, 17)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnELIMINARPRODUCTO)
                                .addGap(101, 101, 101)
                                .addComponent(BtnCOMPRAR))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnELIMINARDESEO))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(BtnAtras)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtras;
    private javax.swing.JButton BtnCOMPRAR;
    private javax.swing.JButton BtnELIMINARDESEO;
    private javax.swing.JButton BtnELIMINARPRODUCTO;
    private javax.swing.JTable TblCarrito;
    private javax.swing.JTable TblDeseos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
