import panels.GamePanel;

import javax.swing.*;

public class Spacewar extends JFrame{

    public Spacewar(){
        add(new GamePanel());
        setResizable(false);
        pack();

        setTitle("Space War");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args){
        JFrame frame = new Spacewar();
        frame.setVisible(true);
    }
}
