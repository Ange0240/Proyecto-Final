package ProyectoFinal;

import CELULAR.Celular;
import PC.ControladorPC;
import PC.Pc;
import ProyectoFinal.VistaCarritoDeseo;
import ProyectoFinal.VistaUsuario;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VistaPc extends javax.swing.JFrame {

    private Carrito carrito;
    
    private ControladorPC controladorPC;

    public VistaPc(VistaUsuario vistaUsuario) {
        this.vistaUsuario = vistaUsuario;
        this.carrito = Carrito.getInstancia();
        initComponents();
        inicializarVista();
    }

    private void inicializarVista() {
        controladorPC = new ControladorPC();
        carrito = new Carrito();
        mostrarPCs();

        
        
        BtnVERCARRITO.addActionListener(e -> {
            VistaCarritoDeseo vistaCarrito = new VistaCarritoDeseo(vistaUsuario, carrito);
            vistaCarrito.setVisible(true); // Mostrar la vista del carrito
            this.setVisible(false); // Ocultar la vista actual
        });

        BtnCARRITO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = TblPCs.getSelectedRow();
                if (filaSeleccionada != -1) {
                    String modeloTablet = (String) TblPCs.getValueAt(filaSeleccionada, 0);
                    Pc Pcseleccionado = controladorPC.getPCPorModelo(modeloTablet);
                    if (Pcseleccionado != null) {
                        agregarPcAlCarrito(Pcseleccionado);
                    }
                } else {
                    JOptionPane.showMessageDialog(VistaPc.this, "Por favor, selecciona un celular de la lista.");
                }
            }
        });

        BtnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarVistaUsuario();
            }
        });

        TblPCs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarEspecificacionesPC();
            }
        });
    }

    private void agregarPcAlCarrito(Pc Pc) {
        // Agregar el celular al carrito
        carrito.agregarProducto(new Producto(Pc.getModelo(), Pc.getPrecio()));
        JOptionPane.showMessageDialog(this, "Producto agregado al carrito.");
    }

    private VistaUsuario vistaUsuario;

    private void regresarVistaUsuario() {
        vistaUsuario.setVisible(true);
        this.setVisible(false);
    }

    private void mostrarPCs() {
        DefaultTableModel model = (DefaultTableModel) TblPCs.getModel();
        model.setRowCount(0);

        for (Pc pc : controladorPC.getListaPCs()) {
            model.addRow(new Object[]{pc.getModelo(), pc.getPrecio()});
        }
    }

    private void mostrarEspecificacionesPC() {
        // Obtener la fila seleccionada de la tabla
        int filaSeleccionada = TblPCs.getSelectedRow();

        // Si hay una fila seleccionada
        if (filaSeleccionada != -1) {
            // Obtener el modelo de la PC desde la primera columna de la fila seleccionada
            String modeloPC = (String) TblPCs.getValueAt(filaSeleccionada, 0);

            // Buscar la PC por su modelo utilizando el controlador
            Pc pcSeleccionado = controladorPC.getPCPorModelo(modeloPC);

            // Si la PC fue encontrada, mostrar sus especificaciones en el JTextField
            if (pcSeleccionado != null) {
                TxtEspecificacionesPC.setText(pcSeleccionado.getEspecificaciones());
            } else {
                TxtEspecificacionesPC.setText("PC no encontrada.");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        TxtEspecificacionesPC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        BtnCARRITO = new javax.swing.JButton();
        BtnAtras = new javax.swing.JButton();
        BtnDESEOS = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        BtnVERCARRITO = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblPCs = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Tienda de Angel");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Señor@ usuario, se encuentra en la seccion de PC´S");

        jLabel3.setText("PC DISPONIBLES:");

        jLabel4.setText("Especificaciones");

        BtnCARRITO.setText("CARRITO");

        BtnAtras.setText("Atras");

        BtnDESEOS.setText("LISTA DE DESEOS");

        jLabel5.setText("Agregar a:");

        BtnVERCARRITO.setText("VER CARRITO");

        TblPCs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Modelo", "Precio"
            }
        ));
        jScrollPane1.setViewportView(TblPCs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(220, 220, 220))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(237, 237, 237))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnCARRITO)
                                .addGap(88, 88, 88)
                                .addComponent(BtnDESEOS))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnVERCARRITO)))
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(BtnAtras))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtEspecificacionesPC, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
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
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(TxtEspecificacionesPC, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnDESEOS)
                    .addComponent(BtnCARRITO))
                .addGap(16, 16, 16)
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
    private javax.swing.JTable TblPCs;
    private javax.swing.JTextField TxtEspecificacionesPC;
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
