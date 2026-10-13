package ai1013;

import CenterFrame.CenterFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JLabelJButtonImageTest extends JFrame {

    ImageIcon lblIcon = new ImageIcon("imgs/chiikawa_2.jpg");
    JLabel lbl = new JLabel();
    boolean flag = false;

    public JLabelJButtonImageTest() {
        setTitle("ImageIcon설정 컴포넌트");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon btnIcon = new ImageIcon("imgs/chiikawa.jpg");
        JButton btn = new JButton("Click Here~", btnIcon);
        btn.addActionListener(btnListener);

        add("North",btn);
        add("Center",lbl);

        int w=1000,h=1000;
        int[] locations = CenterFrame.getLocation(w, h);
        setBounds(locations[0], locations[1], w, h); //setLocation(x,y) + setSize(w, h)
        setVisible(true);
    }

    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            if (flag){
                lbl.setIcon(lblIcon);
                flag = false;
            }else{
                lbl.setIcon(new ImageIcon());
                flag = true;
            }

        }
    };

    public static void main(String[] args) {
        new JLabelJButtonImageTest();

    }
}
