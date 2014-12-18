package GUI;
import javax.swing.*;
import Protein.*;
import java.awt.*;
import Exceptions.*;
/**
 *
 * @author Kiro
 */
public class InputProteinForm2 extends javax.swing.JFrame {

    public InputProteinForm2() {
        initComponents();

        //обединяване на радио бутоните за избор на формат на въвеждане
        //в една група
        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(binaryRadioButton);
        bgroup.add(hpRadioButton);
        bgroup.add(alphaRadioButton);

        //обединяване на радио бутоните за избор на решетка в една група
        ButtonGroup bgroup2 = new ButtonGroup();
        bgroup2.add(RadioButton2DRazmernost);
        bgroup2.add(RadioButton3DRazmernost);

        //селектиране на първите радио бутони от всяка група по подразбиране
        binaryRadioButton.setSelected(true);
        RadioButton2DRazmernost.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        clearButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        binaryRadioButton = new javax.swing.JRadioButton();
        hpRadioButton = new javax.swing.JRadioButton();
        alphaRadioButton = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        RadioButton2DRazmernost = new javax.swing.JRadioButton();
        RadioButton3DRazmernost = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("НР модел №: 2");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Статус"));
        jPanel1.setToolTipText("");

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Courier New", 0, 12));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clear.png"))); // NOI18N
        clearButton.setText("Изтрий");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    .addComponent(clearButton))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearButton)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Създаване на .lp файл"));

        jLabel1.setText("Въведете протеина в:");

        binaryRadioButton.setText("бинарен формат");

        hpRadioButton.setText("HP формат");

        alphaRadioButton.setText("обикновен формат");

        createButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/New document.png"))); // NOI18N
        createButton.setText("Създай .lp файл");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Изберете размерността на решетката:");

        RadioButton2DRazmernost.setText("2D решетка");

        RadioButton3DRazmernost.setText("3D решетка");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(RadioButton2DRazmernost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RadioButton3DRazmernost))
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(binaryRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hpRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alphaRadioButton))
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(createButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(259, 259, 259))
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioButton2DRazmernost)
                    .addComponent(RadioButton3DRazmernost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(binaryRadioButton)
                    .addComponent(hpRadioButton)
                    .addComponent(alphaRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createButton))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Визуализация"));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Diagram.png"))); // NOI18N
        jButton3.setText("2D визуализация");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Diagram.png"))); // NOI18N
        jButton4.setText("3D визуализация");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit.png"))); // NOI18N
        exitButton.setText("Изход");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Back.png"))); // NOI18N
        backButton.setText("Назад");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton)
                    .addComponent(backButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
            MainForm MF = new MainForm();

            //затваря текущата форма
            this.dispose();

            // Get the size of the screen
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

            // Determine the new location of the window
            int w = MF.getSize().width;
            int h = MF.getSize().height;
            int x = (dim.width-w)/2;
            int y = (dim.height-h)/2;

            // Move the window
            MF.setLocation(x, y);
            MF.setVisible(true);

            jTextArea1.setEditable(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed

        try{
            if (jTextField1.getText().equals(""))
                throw new EmptyFieldException();

            if ((binaryRadioButton.isSelected()==true) &&
                (RadioButton2DRazmernost.isSelected()==true) &&
                !(jTextField1.getText().equals(""))){

                Protein2 A = new Protein2(jTextField1.getText());
                if (A.isCorrectBinary()){
                    try{
                        String msg = A.WriteFile2D(A.getq() + "_2D_Model2.lp");
                        String txt = jTextArea1.getText();
                        if (txt == null ? "" != null : !txt.equals(""))
                            jTextArea1.setText(txt +
                                "\n-----------------------------------------\n"
                                + msg);
                        else
                            jTextArea1.setText(msg);
                    }

                    catch(java.io.IOException e){
                        e.getStackTrace();
                    }
                }

                else
                    throw new BinaryInputException();
            }

            if ((binaryRadioButton.isSelected()==true) &&
                (RadioButton3DRazmernost.isSelected()==true) &&
                !(jTextField1.getText().equals(""))){

                Protein2 A = new Protein2(jTextField1.getText());
                if (A.isCorrectBinary()){
                    try{
                        String msg = A.WriteFile3D(A.getq() + "_3D_Model2.lp");
                        String txt = jTextArea1.getText();
                        if (txt == null ? "" != null : !txt.equals(""))
                            jTextArea1.setText(txt +
                                "\n-----------------------------------------\n"
                                + msg);
                        else
                            jTextArea1.setText(msg);
                    }

                    catch(java.io.IOException e){
                        e.getStackTrace();
                    }
                }

                else
                    throw new BinaryInputException();
            }

            if ((hpRadioButton.isSelected()==true) &&
                (RadioButton2DRazmernost.isSelected()==true) &&
                !(jTextField1.getText().equals(""))){

                Protein2 A = new Protein2(jTextField1.getText());
                if (A.isCorrectHP()){
                    A.ConvertHPtoBinary();
                    try{
                        String msg = A.WriteFile2D(A.getq() + "_2D_Model2.lp");
                        String txt = jTextArea1.getText();
                        if (txt == null ? "" != null : !txt.equals(""))
                            jTextArea1.setText(txt +
                                "\n-----------------------------------------\n"
                            + msg);
                        else
                            jTextArea1.setText(msg);
                    }

                    catch(java.io.IOException e){
                        e.getStackTrace();
                    }
                }
                else
                    throw new HPInputException();
            }

            if ((hpRadioButton.isSelected()==true) &&
                (RadioButton3DRazmernost.isSelected()==true) &&
                !(jTextField1.getText().equals(""))){

                Protein2 A = new Protein2(jTextField1.getText());
                if (A.isCorrectHP()){
                    A.ConvertHPtoBinary();
                    try{
                        String msg = A.WriteFile3D(A.getq() + "_3D_Model2.lp");
                        String txt = jTextArea1.getText();
                        if (txt == null ? "" != null : !txt.equals(""))
                            jTextArea1.setText(txt +
                                "\n-----------------------------------------\n"
                            + msg);
                        else
                            jTextArea1.setText(msg);
                    }

                    catch(java.io.IOException e){
                        e.getStackTrace();
                    }
                }
                else
                    throw new HPInputException();
            }

            if ((alphaRadioButton.isSelected()==true) &&
                (RadioButton2DRazmernost.isSelected()==true) &&
                !(jTextField1.getText().equals(""))){

                Protein2 A = new Protein2(jTextField1.getText());
                if (A.isCorrect()){
                    A.Convert();
                    try{
                        String msg = A.WriteFile2D(A.getq() + "_2D_Model2.lp");
                        String txt = jTextArea1.getText();
                        if (txt == null ? "" != null : !txt.equals(""))
                            jTextArea1.setText(txt +
                                "\n-----------------------------------------\n"
                            + msg);
                    else
                        jTextArea1.setText(msg);
                    }

                    catch(java.io.IOException e){
                        e.getStackTrace();
                    }
                }
                else
                    throw new AlphaInputException();
            }

            if ((alphaRadioButton.isSelected()==true) &&
                (RadioButton3DRazmernost.isSelected()==true) &&
                !(jTextField1.getText().equals(""))){

                Protein2 A = new Protein2(jTextField1.getText());
                if (A.isCorrect()){
                    A.Convert();
                    try{
                        String msg = A.WriteFile3D(A.getq() + "_3D_Model2.lp");
                        String txt = jTextArea1.getText();
                        if (txt == null ? "" != null : !txt.equals(""))
                            jTextArea1.setText(txt +
                                "\n-----------------------------------------\n"
                            + msg);
                    else
                        jTextArea1.setText(msg);
                    }

                    catch(java.io.IOException e){
                        e.getStackTrace();
                    }
                }
                else
                    throw new AlphaInputException();
            }
        }

        catch (EmptyFieldException e){
        }

        catch (BinaryInputException e){
        }

        catch (HPInputException e){
        }

        catch (AlphaInputException e){
        }
    }//GEN-LAST:event_createButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        jTextArea1.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Plotting2DModel ModelForm = new Plotting2DModel();

            //затваря текущата форма
            this.dispose();

            // Get the size of the screen
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

            // Determine the new location of the window
            int w = ModelForm.getSize().width;
            int h = ModelForm.getSize().height;
            int x = (dim.width-w)/2;
            int y = (dim.height-h)/2;

            // Move the window
            ModelForm.setLocation(x, y);
            ModelForm.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Plotting3DModel ModelForm = new Plotting3DModel();

            //затваря текущата форма
            this.dispose();

            // Get the size of the screen
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

            // Determine the new location of the window
            int w = ModelForm.getSize().width;
            int h = ModelForm.getSize().height;
            int x = (dim.width-w)/2;
            int y = (dim.height-h)/2;

            // Move the window
            ModelForm.setLocation(x, y);
            ModelForm.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void Main() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputProteinForm2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RadioButton2DRazmernost;
    private javax.swing.JRadioButton RadioButton3DRazmernost;
    private javax.swing.JRadioButton alphaRadioButton;
    private javax.swing.JButton backButton;
    private javax.swing.JRadioButton binaryRadioButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton createButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JRadioButton hpRadioButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}