package interfaz;

import javax.swing.JPanel;


public class App {

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        Login p = new Login();
        JPanel content  = mf.contentPanel;
        mf.setVisible(true);
        p.setSize(900,600);
        p.setLocation(0,0);
        
        content.removeAll();
        content.add(p);
        content.revalidate();
        content.repaint();

    }
    
}