/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendascc;

import agendascc.UI.MainViewTest;
import agendascc.UI.Tries;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.Font;
import javax.swing.UIManager;

/**
 *
 * @author JTF
 */
public class AgendaSCC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /* try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        
                try 
        { 
            UIManager.setLookAndFeel(new WindowsLookAndFeel()); 
            UIManager.put("Button.font",new Font("Verdana", Font.PLAIN, 14));
        } 
        catch(Exception e){    }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tries().setVisible(true);
            }
        });
        // TODO code application logic here
    }
    
}
