package ProyectoFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;


public class VistaAdministrador extends javax.swing.JFrame {
    DefaultTableModel model = new DefaultTableModel() {
    @Override
    public boolean isCellEditable(int row, int column) {
        // Permitir edición solo en columnas de tipo de usuario
        return column != 1;  // La columna 1 (Número de Identificación) no es editable
    }
    
};
    private ArrayList<Usuario> listaUsuarios; // Lista que almacenará los usuarios
    private Vista vistaPrincipal; // Referencia a la VistaPrincipal

    public VistaAdministrador(Vista vistaPrincipal, ArrayList<Usuario> listaUsuarios) {
        initComponents();
        this.listaUsuarios = listaUsuarios;
        this.vistaPrincipal = vistaPrincipal;

        inicializarVista();
    }

private void inicializarVista() {
    // Inicializamos el modelo de la tabla
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            // Permitir edición solo en columnas de tipo de usuario y nombre
            return column != 1; // La columna 1 (Número de Identificación) no es editable
        }
    };
    model.addColumn("Nombre");
    model.addColumn("Número de Identificación");
    model.addColumn("Tipo de Usuario");

    TblTablaRegisto.setModel(model); // Asignamos el modelo a la tabla

    // Llenamos la tabla con los datos de los usuarios
    for (Usuario usuario : listaUsuarios) {
        model.addRow(new Object[]{usuario.getNombre(), usuario.getNroIdentificacion(), usuario.getTipoUsuario()});
    }

    
    BtnELIMINAR.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = TblTablaRegisto.getSelectedRow(); // Obtener fila seleccionada

        if (selectedRow >= 0) {
            // Confirmar la eliminación
            int confirm = JOptionPane.showConfirmDialog(
                null,
                "¿Estás seguro de que deseas eliminar este usuario?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                // Eliminar de la lista y del modelo
                listaUsuarios.remove(selectedRow);
                ((DefaultTableModel) TblTablaRegisto.getModel()).removeRow(selectedRow);

                JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un usuario para eliminar.");
        }
    }
});
    
            BtnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarAVistaPrincipal();
            }
        });
    
    BtnCONTRASEÑA.addActionListener(new ActionListener() { // jButton1 es BtnCONTRASEÑA
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = TblTablaRegisto.getSelectedRow(); // Obtener fila seleccionada

        if (selectedRow >= 0) {
            // Obtener el usuario correspondiente de la lista
            Usuario usuario = listaUsuarios.get(selectedRow);
            String mensaje = String.format("La contraseña del usuario %s es: %s",
                usuario.getNombre(), usuario.getContraseña());

            JOptionPane.showMessageDialog(null, mensaje, "Contraseña del Usuario", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un usuario para ver su contraseña.");
        }
    }
});
    
    
    
    // Listener para detectar cambios en la tabla y actualizar la lista
    model.addTableModelListener(new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent e) {
            int row = e.getFirstRow(); // Fila donde ocurrió el cambio
            int column = e.getColumn(); // Columna donde ocurrió el cambio

            if (row >= 0 && column >= 0) {
                // Obtenemos el nuevo valor de la celda
                String newValue = model.getValueAt(row, column).toString();

                // Actualizamos la lista de usuarios según la columna editada
                Usuario usuario = listaUsuarios.get(row); // Usuario correspondiente a la fila
                if (column == 0) { // Columna 0: Nombre
                    usuario.setNombre(newValue);
                } else if (column == 2) { // Columna 2: Tipo de Usuario
                    usuario.setTipoUsuario(newValue);
                }
            }
        }
    });
}

    private void regresarAVistaPrincipal() {
        this.setVisible(false); // Oculta VistaAdministrador
        vistaPrincipal.setVisible(true); // Muestra la VistaPrincipal
        vistaPrincipal.actualizarTabla(); // Actualiza la tabla en la VistaPrincipal
    }


    // Método para actualizar la tabla con la lista de usuarios
    public void actualizarTabla() {
        // Limpiar la tabla antes de agregar las filas nuevas
        model.setRowCount(0);

        // Agregar usuarios a la tabla
        for (Usuario usuario : listaUsuarios) {
            model.addRow(new Object[]{
                usuario.getNombre(),
                usuario.getNroIdentificacion(),
                usuario.getTipoUsuario()
            });
        }
    }

    // Método para eliminar un usuario de la tabla
    private void eliminarUsuario() {
        int selectedRow = TblTablaRegisto.getSelectedRow();
        if (selectedRow != -1) {
            // Eliminar el usuario de la lista
            listaUsuarios.remove(selectedRow);
            // Actualizar la tabla
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un usuario para eliminar.");
        }
    }

    // Método para ver el historial de compras de un usuario
    private void verHistorialCompras() {
        int selectedRow = TblTablaRegisto.getSelectedRow();
        if (selectedRow != -1) {
            // Obtener el nombre del usuario seleccionado
            String nombreUsuario = (String) model.getValueAt(selectedRow, 0);
            // Aquí debes implementar la lógica para obtener y mostrar el historial de compras
            JOptionPane.showMessageDialog(this, "Historial de compras de " + nombreUsuario);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un usuario para ver su historial de compras.");
        }
    }

    // Método para regresar a la VistaPrincipal
    private void irAVistaPrincipal() {
        // Cierra la ventana actual
        this.setVisible(false);
        // Regresa a la VistaPrincipal (deberías tener la clase VistaPrincipal ya creada)
        Vista vistaPrincipal = new Vista();
        vistaPrincipal.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        BtnAtras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblTablaRegisto = new javax.swing.JTable();
        BtnHISTORIALCOMPRAS = new javax.swing.JButton();
        BtnELIMINAR = new javax.swing.JButton();
        BtnCONTRASEÑA = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Tienda de Angel");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Administrador, verá lo que ve un usuario, usted puede editar");

        BtnAtras.setText("Atras");

        TblTablaRegisto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuarios", "Identificacion", "Productos Comprados"
            }
        ));
        jScrollPane1.setViewportView(TblTablaRegisto);

        BtnHISTORIALCOMPRAS.setText("HISTORIAL DE COMPRAS");

        BtnELIMINAR.setText("ELIMINAR USUARIO");

        BtnCONTRASEÑA.setText("VER CONTRASEÑA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(267, 267, 267)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BtnAtras)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(48, 48, 48)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(BtnCONTRASEÑA)
                                        .addComponent(BtnHISTORIALCOMPRAS)
                                        .addComponent(BtnELIMINAR)))))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(BtnCONTRASEÑA))
                            .addComponent(BtnHISTORIALCOMPRAS, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(BtnELIMINAR)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(BtnAtras)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtras;
    private javax.swing.JButton BtnCONTRASEÑA;
    private javax.swing.JButton BtnELIMINAR;
    private javax.swing.JButton BtnHISTORIALCOMPRAS;
    private javax.swing.JTable TblTablaRegisto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
