/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votacion;

/**
 *
 * @author Carlos
 */
public class Votacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Subject subject = new Subject();
        JFramePrincipal Principal=new JFramePrincipal(subject);
        Principal.setVisible(true);
        
        JFrameMAS MAS=new JFrameMAS(subject);
        MAS.setVisible(true);
        JFrame21F F21=new JFrame21F(subject);
        F21.setVisible(true);
        JFrameCC CC=new JFrameCC(subject);
        CC.setVisible(true);
        // TODO code application logic here
    }
    
}
