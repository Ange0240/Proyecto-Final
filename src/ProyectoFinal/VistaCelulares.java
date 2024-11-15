package ProyectoFinal;

import CELULAR.Celular;
import CELULAR.ControladorCelulares;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaCelulares extends javax.swing.JFrame {

    private Carrito carrito;
    private ControladorCelulares controladorCelulares;

    public VistaCelulares(VistaUsuario vistaUsuario) {
        this.vistaUsuario = vistaUsuario;
        this.carrito = Carrito.getInstancia();
        initComponents();
        inicializarEventos();
        inicializarVista();
    }

    // Método para inicializar la vista
    private void inicializarVista() {
        controladorCelulares = new ControladorCelulares();
        mostrarCelulares();

        BtnVERCARRITO.addActionListener(e -> {
            VistaCarritoDeseo vistaCarrito = new VistaCarritoDeseo(vistaUsuario, carrito);
            vistaCarrito.setVisible(true); // Mostrar la vista del carrito
            this.setVisible(false); // Ocultar la vista actual
        });
        

        BtnCARRITO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarSeleccionDeCelular();
            }
        });

        BtnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarVistaUsuario();
            }
        });

        // Añadir evento de clic para el JTable de celulares
        TblCelulares.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarEspecificacionesCelular();
            }
        });
    }

    private void inicializarEventos() {
        BtnDESEOS.addActionListener(e -> agregarCelularADeseos());
    }

public void agregarCelularAlCarrito(Producto producto) {
    if (producto != null) {
        carrito.agregarProducto(producto);
        JOptionPane.showMessageDialog(this, "Producto añadido al carrito.");
    } else {
        JOptionPane.showMessageDialog(this, "Producto inválido.");
    }
}

    
    private void agregarCelularADeseos() {
        int filaSeleccionada = TblCelulares.getSelectedRow();
        if (filaSeleccionada != -1) {
            String nombre = (String) TblCelulares.getValueAt(filaSeleccionada, 0);
            double precio = (double) TblCelulares.getValueAt(filaSeleccionada, 1);

            Carrito.getInstancia().agregarDeseo(new Producto(nombre, precio));
            JOptionPane.showMessageDialog(this, "Producto añadido a la lista de deseos.");
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para agregar a la lista de deseos.");
        }
    }

    private VistaUsuario vistaUsuario;  // Referencia a VistaUsuario

    // Método para regresar a VistaUsuario
    private void regresarVistaUsuario() {
        vistaUsuario.setVisible(true);  // Mostramos la VistaUsuario
        this.setVisible(false);  // Ocultamos la VistaCelulares
    }

    // Método para mostrar la lista de celulares en el JTable
    private void mostrarCelulares() {
        // Creamos el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Modelo");
        model.addColumn("Precio");

        // Añadimos los datos de los celulares
        List<Celular> celulares = controladorCelulares.getListaCelulares();
        for (Celular celular : celulares) {
            model.addRow(new Object[]{celular.getModelo(), celular.getPrecio()});
        }

        // Asignamos el modelo a la tabla
        TblCelulares.setModel(model);
    }

    private void manejarSeleccionDeCelular() {
        int filaSeleccionada = TblCelulares.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Obtén los valores de la fila seleccionada
            String nombre = (String) TblCelulares.getValueAt(filaSeleccionada, 0);
            double precio = (double) TblCelulares.getValueAt(filaSeleccionada, 1);

            // Crea un producto con esos valores
            Producto celularSeleccionado = new Producto(nombre, precio);

            // Llama al método para agregar al carrito
            agregarCelularAlCarrito(celularSeleccionado);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para agregar al carrito.");
        }
    }

    // Método para mostrar las especificaciones del celular seleccionado en la tabla
    private void mostrarEspecificacionesCelular() {
        int filaSeleccionada = TblCelulares.getSelectedRow();
        if (filaSeleccionada != -1) {
            String modeloCelular = (String) TblCelulares.getValueAt(filaSeleccionada, 0);
            Celular celularSeleccionado = controladorCelulares.getCelularPorModelo(modeloCelular);
            if (celularSeleccionado != null) {
                TxtEspecificacionesCelulares.setText(celularSeleccionado.getEspecificaciones());
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
        TxtEspecificacionesCelulares = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        BtnCARRITO = new javax.swing.JButton();
        BtnAtras = new javax.swing.JButton();
        BtnDESEOS = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        BtnVERCARRITO = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblCelulares = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Tienda de Angel");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Señor@ usuario, se encuentra en la seccion de celulares");

        jLabel3.setText("CELULARES DISPONIBLES:");

        jLabel4.setText("Especificaciones");

        BtnCARRITO.setText("CARRITO");

        BtnAtras.setText("Atras");

        BtnDESEOS.setText("LISTA DE DESEOS");

        jLabel5.setText("Agregar a:");

        BtnVERCARRITO.setText("VER CARRITO");

        TblCelulares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Modelo", "Precio"
            }
        ));
        jScrollPane1.setViewportView(TblCelulares);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnCARRITO)
                                .addGap(61, 61, 61)
                                .addComponent(BtnDESEOS)))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(TxtEspecificacionesCelulares, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(114, 114, 114)))))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(269, 269, 269))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnVERCARRITO)
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(BtnAtras))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(BtnVERCARRITO))
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(TxtEspecificacionesCelulares, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCARRITO)
                    .addComponent(BtnDESEOS))
                .addGap(54, 54, 54)
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
    private javax.swing.JTable TblCelulares;
    private javax.swing.JTextField TxtEspecificacionesCelulares;
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
