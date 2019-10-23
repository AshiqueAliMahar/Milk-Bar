/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milkbar;

import java.io.IOException;
import milkbar.UI.Login;

/**
 *
 * @author ali.ashique
 */
public class MilkBar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MilkBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new Login().setVisible(true);
    }
    
}
