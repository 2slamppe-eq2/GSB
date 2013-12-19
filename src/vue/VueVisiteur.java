/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.CtrlAbstrait;
import controleur.CtrlVisiteur;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author btssio
 */
public class VueVisiteur extends VueAbstraite {
    
    DefaultComboBoxModel modelJComboBoxChercher;
    DefaultComboBoxModel modelJComboBoxLabo;
    DefaultComboBoxModel modelJComboBoxSecteur;
    

    /**
     * Creates new form JFramePraticien
     */
    public VueVisiteur(CtrlAbstrait ctrl) {
        super(ctrl);
        initComponents();
        modelJComboBoxChercher = new DefaultComboBoxModel();
        modelJComboBoxLabo = new DefaultComboBoxModel();
        modelJComboBoxSecteur = new DefaultComboBoxModel();
        jComboBoxChercher.setModel(modelJComboBoxChercher);
        jComboBoxLabo.setModel(modelJComboBoxLabo);
        jComboBoxSecteur.setModel(modelJComboBoxSecteur);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelVisiteurs = new javax.swing.JLabel();
        jComboBoxChercher = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldNom = new javax.swing.JTextField();
        jTextFieldPrenom = new javax.swing.JTextField();
        jTextFieldAdresse = new javax.swing.JTextField();
        jTextFieldCP = new javax.swing.JTextField();
        jLabelNom = new javax.swing.JLabel();
        jLabelPrenom = new javax.swing.JLabel();
        jLabelAdresse = new javax.swing.JLabel();
        jLabelVille = new javax.swing.JLabel();
        jLabelSecteur = new javax.swing.JLabel();
        jLabelLabo = new javax.swing.JLabel();
        jLabelChercher = new javax.swing.JLabel();
        jComboBoxLabo = new javax.swing.JComboBox();
        jComboBoxSecteur = new javax.swing.JComboBox();
        jTextFieldVille = new javax.swing.JTextField();
        jButtonPrecedent = new javax.swing.JButton();
        jButtonNouveau = new javax.swing.JButton();
        jButtonFermer = new javax.swing.JButton();
        jButtonOK = new javax.swing.JButton();
        Suivant = new javax.swing.JButton();
        jTextFieldMatricule = new javax.swing.JTextField();
        jLabelMatricule = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelVisiteurs.setText("VISITEURS");

        jComboBoxChercher.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextFieldCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCPActionPerformed(evt);
            }
        });

        jLabelNom.setText("Nom :");

        jLabelPrenom.setText("Prenom : ");

        jLabelAdresse.setText("Adresse : ");

        jLabelVille.setText("Ville : ");

        jLabelSecteur.setText("Secteur : ");

        jLabelLabo.setText("Labo : ");

        jLabelChercher.setText("Chercher");

        jComboBoxLabo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxSecteur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonPrecedent.setText("Précédent");

        jButtonNouveau.setText("Nouveau");

        jButtonFermer.setText("Fermer");
        jButtonFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFermerActionPerformed(evt);
            }
        });

        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        Suivant.setText("Suivant");
        Suivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuivantActionPerformed(evt);
            }
        });

        jLabelMatricule.setText("Matricule :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonNouveau)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFermer)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelVisiteurs))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabelChercher)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxChercher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOK)
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNom)
                    .addComponent(jLabelAdresse)
                    .addComponent(jLabelVille)
                    .addComponent(jLabelSecteur)
                    .addComponent(jLabelLabo)
                    .addComponent(jLabelPrenom)
                    .addComponent(jLabelMatricule))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldNom, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAdresse, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSecteur, javax.swing.GroupLayout.Alignment.LEADING, 0, 195, Short.MAX_VALUE)
                            .addComponent(jComboBoxLabo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldPrenom, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonPrecedent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Suivant, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(179, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldCP, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldVille, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelVisiteurs)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxChercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelChercher)
                    .addComponent(jButtonOK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMatricule))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrenom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAdresse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelVille))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSecteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSecteur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxLabo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLabo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Suivant)
                    .addComponent(jButtonPrecedent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFermer)
                    .addComponent(jButtonNouveau))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFermerActionPerformed
        try {
            ((CtrlVisiteur)controleur).quitter();
        } catch (Exception ex) {
            Logger.getLogger(VueVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonFermerActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        ((CtrlVisiteur)controleur).choixVisiteur();
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jTextFieldCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCPActionPerformed

    private void SuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuivantActionPerformed
        try {
            ((CtrlVisiteur)controleur).suivant();
        } catch (Exception ex) {
            Logger.getLogger(VueVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SuivantActionPerformed

    public JComboBox getjComboBoxChercher() {
        return jComboBoxChercher;
    }

    public DefaultComboBoxModel getModelJComboBoxChercher() {
        return modelJComboBoxChercher;
    }

    public void setModelJComboBoxChercher(DefaultComboBoxModel modelJComboBoxChercher) {
        this.modelJComboBoxChercher = modelJComboBoxChercher;
    }

    public DefaultComboBoxModel getModelJComboBoxLabo() {
        return modelJComboBoxLabo;
    }

    public void setModelJComboBoxLabo(DefaultComboBoxModel modelJComboBoxLabo) {
        this.modelJComboBoxLabo = modelJComboBoxLabo;
    }

    public DefaultComboBoxModel getModelJComboBoxSecteur() {
        return modelJComboBoxSecteur;
    }

    public void setModelJComboBoxSecteur(DefaultComboBoxModel modelJComboBoxSecteur) {
        this.modelJComboBoxSecteur = modelJComboBoxSecteur;
    }

    public JButton getjButtonPrecedent() {
        return jButtonPrecedent;
    }

    public void setjButtonPrecedent(JButton jButtonPrecedent) {
        this.jButtonPrecedent = jButtonPrecedent;
    }

    public JTextField getjTextFieldMatricule() {
        return jTextFieldMatricule;
    }

    public JComboBox getjComboBoxLabo() {
        return jComboBoxLabo;
    }

    public void setjComboBoxLabo(JComboBox jComboBoxLabo) {
        this.jComboBoxLabo = jComboBoxLabo;
    }

    public JComboBox getjComboBoxSecteur() {
        return jComboBoxSecteur;
    }

    public void setjComboBoxSecteur(JComboBox jComboBoxSecteur) {
        this.jComboBoxSecteur = jComboBoxSecteur;
    }

    public JTextField getjTextFieldAdresse() {
        return jTextFieldAdresse;
    }

    public void setjTextFieldAdresse(JTextField jTextFieldAdresse) {
        this.jTextFieldAdresse = jTextFieldAdresse;
    }

    public JTextField getjTextFieldCP() {
        return jTextFieldCP;
    }

    public void setjTextFieldCP(JTextField jTextFieldCP) {
        this.jTextFieldCP = jTextFieldCP;
    }

    public JTextField getjTextFieldNom() {
        return jTextFieldNom;
    }

    public void setjTextFieldNom(JTextField jTextFieldNom) {
        this.jTextFieldNom = jTextFieldNom;
    }

    public JTextField getjTextFieldPrenom() {
        return jTextFieldPrenom;
    }

    public void setjTextFieldPrenom(JTextField jTextFieldPrenom) {
        this.jTextFieldPrenom = jTextFieldPrenom;
    }

    public JTextField getjTextFieldVille() {
        return jTextFieldVille;
    }

    public void setjTextFieldVille(JTextField jTextFieldVille) {
        this.jTextFieldVille = jTextFieldVille;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Suivant;
    private javax.swing.JButton jButtonFermer;
    private javax.swing.JButton jButtonNouveau;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JButton jButtonPrecedent;
    private javax.swing.JComboBox jComboBoxChercher;
    private javax.swing.JComboBox jComboBoxLabo;
    private javax.swing.JComboBox jComboBoxSecteur;
    private javax.swing.JLabel jLabelAdresse;
    private javax.swing.JLabel jLabelChercher;
    private javax.swing.JLabel jLabelLabo;
    private javax.swing.JLabel jLabelMatricule;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelPrenom;
    private javax.swing.JLabel jLabelSecteur;
    private javax.swing.JLabel jLabelVille;
    private javax.swing.JLabel jLabelVisiteurs;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldAdresse;
    private javax.swing.JTextField jTextFieldCP;
    private javax.swing.JTextField jTextFieldMatricule;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldPrenom;
    private javax.swing.JTextField jTextFieldVille;
    // End of variables declaration//GEN-END:variables
}
