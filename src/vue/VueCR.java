/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.CtrlAbstrait;
import controleur.CtrlCR;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author btssio
 */
public class VueCR extends VueAbstraite{

    /**
     * Creates new form JFrameCR
     */
    public VueCR(CtrlAbstrait ctrl) {
        super(ctrl);
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

        jLabelRV = new javax.swing.JLabel();
        jLabelNum = new javax.swing.JLabel();
        jLabelPraticien = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabelMotif = new javax.swing.JLabel();
        jLabelBilan = new javax.swing.JLabel();
        jTextFieldNum = new javax.swing.JTextField();
        jTextFieldDate = new javax.swing.JTextField();
        jTextFieldMotif = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaBilan = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEchantillon = new javax.swing.JTable();
        jLabelEchantillon = new javax.swing.JLabel();
        jButtonPrecedent = new javax.swing.JButton();
        jButtonSuivant = new javax.swing.JButton();
        jButtonNouveau = new javax.swing.JButton();
        jButtonRetour = new javax.swing.JButton();
        jComboBoxPraticien = new javax.swing.JComboBox();
        jButtonDetails = new javax.swing.JButton();
        jButtonEnregistrer = new javax.swing.JButton();
        jButtonFermer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelRV.setText("RAPPORTS DE VISITE");

        jLabelNum.setText("Numéro Rapport");

        jLabelPraticien.setText("Praticien");

        jLabelDate.setText("Date Rapport");

        jLabelMotif.setText("Motif visite");

        jLabelBilan.setText("BILAN");

        jTextAreaBilan.setColumns(20);
        jTextAreaBilan.setRows(5);
        jScrollPane1.setViewportView(jTextAreaBilan);

        jTableEchantillon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Médicament", "NB Echantillon"
            }
        ));
        jScrollPane2.setViewportView(jTableEchantillon);

        jLabelEchantillon.setText("Offre d'échantillons");

        jButtonPrecedent.setText("Précédent");

        jButtonSuivant.setText("Suivant");

        jButtonNouveau.setText("Nouveau");

        jButtonRetour.setText("Retour");
        jButtonRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetourActionPerformed(evt);
            }
        });

        jComboBoxPraticien.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonDetails.setText("Détails");

        jButtonEnregistrer.setText("Enregistrer");

        jButtonFermer.setText("Fermer");
        jButtonFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFermerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDate, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelMotif, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelPraticien))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxPraticien, 0, 179, Short.MAX_VALUE)
                                    .addComponent(jTextFieldDate)
                                    .addComponent(jTextFieldMotif))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDetails))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabelBilan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonPrecedent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSuivant, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonNouveau))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelEchantillon)
                                .addContainerGap())
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jButtonEnregistrer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonRetour))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(jButtonFermer)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelRV)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabelRV)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNum)
                    .addComponent(jTextFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPraticien)
                    .addComponent(jComboBoxPraticien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDetails))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDate)
                    .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMotif)
                    .addComponent(jTextFieldMotif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelBilan)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelEchantillon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonPrecedent)
                            .addComponent(jButtonSuivant)
                            .addComponent(jButtonNouveau)
                            .addComponent(jButtonRetour)
                            .addComponent(jButtonEnregistrer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jButtonFermer)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetourActionPerformed
       
    }//GEN-LAST:event_jButtonRetourActionPerformed

    private void jButtonFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFermerActionPerformed
         try {
            ((CtrlCR)controleur).quitter();
        } catch (Exception ex) {
            Logger.getLogger(VueCR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonFermerActionPerformed

    public JButton getjButtonDetails() {
        return jButtonDetails;
    }

    public void setjButtonDetails(JButton jButtonDetails) {
        this.jButtonDetails = jButtonDetails;
    }

    public JButton getjButtonEnregistrer() {
        return jButtonEnregistrer;
    }

    public void setjButtonEnregistrer(JButton jButtonEnregistrer) {
        this.jButtonEnregistrer = jButtonEnregistrer;
    }

    public JButton getjButtonFermer() {
        return jButtonFermer;
    }

    public void setjButtonFermer(JButton jButtonFermer) {
        this.jButtonFermer = jButtonFermer;
    }

    public JButton getjButtonRetour() {
        return jButtonRetour;
    }

    public void setjButtonRetour(JButton jButtonFermerNouveau) {
        this.jButtonRetour = jButtonFermerNouveau;
    }

    public JButton getjButtonNouveau() {
        return jButtonNouveau;
    }

    public void setjButtonNouveau(JButton jButtonNouveau) {
        this.jButtonNouveau = jButtonNouveau;
    }

    public JButton getjButtonPrecedent() {
        return jButtonPrecedent;
    }

    public void setjButtonPrecedent(JButton jButtonPrecedent) {
        this.jButtonPrecedent = jButtonPrecedent;
    }

    public JButton getjButtonSuivant() {
        return jButtonSuivant;
    }

    public void setjButtonSuivant(JButton jButtonSuivant) {
        this.jButtonSuivant = jButtonSuivant;
    }

    public JComboBox getjComboBoxPraticien() {
        return jComboBoxPraticien;
    }

    public void setjComboBoxPraticien(JComboBox jComboBoxPraticien) {
        this.jComboBoxPraticien = jComboBoxPraticien;
    }

    public JTable getjTableEchantillon() {
        return jTableEchantillon;
    }

    public void setjTableEchantillon(JTable jTableEchantillon) {
        this.jTableEchantillon = jTableEchantillon;
    }

    public JTextArea getjTextAreaBilan() {
        return jTextAreaBilan;
    }

    public void setjTextAreaBilan(JTextArea jTextAreaBilan) {
        this.jTextAreaBilan = jTextAreaBilan;
    }

    public JTextField getjTextFieldDate() {
        return jTextFieldDate;
    }

    public void setjTextFieldDate(JTextField jTextFieldDate) {
        this.jTextFieldDate = jTextFieldDate;
    }

    public JTextField getjTextFieldMotif() {
        return jTextFieldMotif;
    }

    public void setjTextFieldMotif(JTextField jTextFieldMotif) {
        this.jTextFieldMotif = jTextFieldMotif;
    }

    public JTextField getjTextFieldNum() {
        return jTextFieldNum;
    }

    public void setjTextFieldNum(JTextField jTextFieldNum) {
        this.jTextFieldNum = jTextFieldNum;
    }

    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDetails;
    private javax.swing.JButton jButtonEnregistrer;
    private javax.swing.JButton jButtonFermer;
    private javax.swing.JButton jButtonNouveau;
    private javax.swing.JButton jButtonPrecedent;
    private javax.swing.JButton jButtonRetour;
    private javax.swing.JButton jButtonSuivant;
    private javax.swing.JComboBox jComboBoxPraticien;
    private javax.swing.JLabel jLabelBilan;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelEchantillon;
    private javax.swing.JLabel jLabelMotif;
    private javax.swing.JLabel jLabelNum;
    private javax.swing.JLabel jLabelPraticien;
    private javax.swing.JLabel jLabelRV;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEchantillon;
    private javax.swing.JTextArea jTextAreaBilan;
    private javax.swing.JTextField jTextFieldDate;
    private javax.swing.JTextField jTextFieldMotif;
    private javax.swing.JTextField jTextFieldNum;
    // End of variables declaration//GEN-END:variables
}
