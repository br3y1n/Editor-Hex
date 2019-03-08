package presentacion;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class vista extends javax.swing.JFrame {

    private modelo model;
    private controlador control;

    public vista(modelo get) {
        model = get;
        initComponents();
        CapturarEventos();
    }

    public controlador getControl() {
        if (control == null) {
            control = new controlador(this);
        }
        return control;
    }

    public modelo getModel() {
        return model;
    }

    public JTextArea getRuta() {
        return Ruta;
    }

    public JTable getTable() {
        return Table;
    }

    public JLabel getLabelU8() {
        return UInt8;
    }

    public JLabel getLabelU16() {
        return UInt16;
    }

    public JLabel getLabelU32() {
        return UInt32;
    }

    public JLabel getLabelU64() {
        return UInt64;
    }

    public JLabel getLabelS8() {
        return SInt8;
    }

    public JLabel getLabelS16() {
        return SInt16;
    }

    public JLabel getLabelS32() {
        return SInt32;
    }

    public JLabel getLabelS64() {
        return SInt64;
    }

    public JLabel getLabelF32() {
        return Float32;
    }

    public JLabel getLabelF64() {
        return Float64;
    }

    public JRadioButton getEndian() {
        return Big;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Endian = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Ruta = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Little = new javax.swing.JRadioButton();
        Big = new javax.swing.JRadioButton();
        UInt8 = new javax.swing.JLabel();
        UInt16 = new javax.swing.JLabel();
        UInt32 = new javax.swing.JLabel();
        UInt64 = new javax.swing.JLabel();
        SInt8 = new javax.swing.JLabel();
        SInt16 = new javax.swing.JLabel();
        SInt32 = new javax.swing.JLabel();
        SInt64 = new javax.swing.JLabel();
        Float32 = new javax.swing.JLabel();
        Float64 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMenu1 = new javax.swing.JMenu();
        ButtOpen = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("vista"); // NOI18N
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Estado:");

        Ruta.setEditable(false);
        Ruta.setColumns(20);
        Ruta.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Ruta.setLineWrap(true);
        Ruta.setRows(5);
        Ruta.setText("Seleccione un archivo");
        Ruta.setWrapStyleWord(true);
        Ruta.setAutoscrolls(false);
        Ruta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Ruta.setFocusable(false);
        Ruta.setOpaque(false);
        jScrollPane5.setViewportView(Ruta);

        jScrollPane2.setOpaque(false);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setCellSelectionEnabled(true);
        Table.setName("Table"); // NOI18N
        Table.setSelectionBackground(new java.awt.Color(255, 0, 0));
        Table.setShowHorizontalLines(false);
        Table.setShowVerticalLines(false);
        Table.setTableHeader(null);
        jScrollPane2.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setResizable(false);
            Table.getColumnModel().getColumn(0).setPreferredWidth(200);
            Table.getColumnModel().getColumn(1).setResizable(false);
            Table.getColumnModel().getColumn(1).setPreferredWidth(200);
            Table.getColumnModel().getColumn(2).setResizable(false);
            Table.getColumnModel().getColumn(3).setResizable(false);
            Table.getColumnModel().getColumn(4).setResizable(false);
            Table.getColumnModel().getColumn(5).setResizable(false);
            Table.getColumnModel().getColumn(6).setResizable(false);
            Table.getColumnModel().getColumn(7).setResizable(false);
            Table.getColumnModel().getColumn(8).setResizable(false);
            Table.getColumnModel().getColumn(9).setResizable(false);
            Table.getColumnModel().getColumn(10).setResizable(false);
            Table.getColumnModel().getColumn(11).setResizable(false);
            Table.getColumnModel().getColumn(12).setResizable(false);
            Table.getColumnModel().getColumn(13).setResizable(false);
            Table.getColumnModel().getColumn(14).setResizable(false);
            Table.getColumnModel().getColumn(15).setResizable(false);
            Table.getColumnModel().getColumn(16).setResizable(false);
            Table.getColumnModel().getColumn(17).setResizable(false);
            Table.getColumnModel().getColumn(18).setResizable(false);
            Table.getColumnModel().getColumn(18).setPreferredWidth(200);
            Table.getColumnModel().getColumn(19).setResizable(false);
            Table.getColumnModel().getColumn(20).setResizable(false);
            Table.getColumnModel().getColumn(21).setResizable(false);
            Table.getColumnModel().getColumn(22).setResizable(false);
            Table.getColumnModel().getColumn(23).setResizable(false);
            Table.getColumnModel().getColumn(24).setResizable(false);
            Table.getColumnModel().getColumn(25).setResizable(false);
            Table.getColumnModel().getColumn(26).setResizable(false);
            Table.getColumnModel().getColumn(27).setResizable(false);
            Table.getColumnModel().getColumn(28).setResizable(false);
            Table.getColumnModel().getColumn(29).setResizable(false);
            Table.getColumnModel().getColumn(30).setResizable(false);
            Table.getColumnModel().getColumn(31).setResizable(false);
            Table.getColumnModel().getColumn(32).setResizable(false);
            Table.getColumnModel().getColumn(33).setResizable(false);
            Table.getColumnModel().getColumn(34).setResizable(false);
        }
        Table.getAccessibleContext().setAccessibleName("Table");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Int8 :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Int16 :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Int32 :");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Int64 :");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Unsigned (+)");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Signed (+-)");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Float32 :");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Float64 :");

        Endian.add(Little);
        Little.setText("Little-Endian");
        Little.setName("Little"); // NOI18N

        Endian.add(Big);
        Big.setSelected(true);
        Big.setText("Big-Endian");
        Big.setName("Big"); // NOI18N

        UInt8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        UInt8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UInt8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        UInt16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        UInt16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UInt16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        UInt32.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        UInt32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UInt32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        UInt64.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        UInt64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UInt64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SInt8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        SInt8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SInt8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SInt16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        SInt16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SInt16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SInt32.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        SInt32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SInt32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SInt64.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        SInt64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SInt64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Float32.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Float32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Float32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Float64.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Float64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Float64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(0, 40));

        JMenu1.setText("Archive");
        JMenu1.setName("abrir"); // NOI18N

        ButtOpen.setText("Open...");
        ButtOpen.setName("abrir"); // NOI18N
        ButtOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtOpenActionPerformed(evt);
            }
        });
        JMenu1.add(ButtOpen);

        jMenuBar1.add(JMenu1);
        JMenu1.getAccessibleContext().setAccessibleParent(this);

        jMenu1.setText("Help");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(UInt8, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UInt16, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UInt32, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UInt64, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SInt64, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SInt16, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SInt8, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SInt32, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Float64, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Float32, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addComponent(Big, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Little, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 2880, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(UInt8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UInt16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UInt32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UInt64, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(54, 54, 54)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(SInt8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(SInt16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(SInt32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Float32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Float64, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(Little, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Big, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(18, 18, 18)
                                    .addComponent(SInt64, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Little.getAccessibleContext().setAccessibleName("Little");
        Big.getAccessibleContext().setAccessibleName("Big");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtOpenActionPerformed
    }//GEN-LAST:event_ButtOpenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Big;
    private javax.swing.JMenuItem ButtOpen;
    private javax.swing.ButtonGroup Endian;
    private javax.swing.JLabel Float32;
    private javax.swing.JLabel Float64;
    private javax.swing.JMenu JMenu1;
    private javax.swing.JRadioButton Little;
    private javax.swing.JTextArea Ruta;
    private javax.swing.JLabel SInt16;
    private javax.swing.JLabel SInt32;
    private javax.swing.JLabel SInt64;
    private javax.swing.JLabel SInt8;
    private javax.swing.JTable Table;
    private javax.swing.JLabel UInt16;
    private javax.swing.JLabel UInt32;
    private javax.swing.JLabel UInt64;
    private javax.swing.JLabel UInt8;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables

    private void CapturarEventos() {
        ButtOpen.addActionListener(getControl());
        Table.addMouseListener(getControl());
        Little.addMouseListener(getControl());
        Big.addMouseListener(getControl());
    }
}