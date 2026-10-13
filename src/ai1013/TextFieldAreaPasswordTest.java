package ai1013;

import CenterFrame.CenterFrame;

import javax.swing.*;
import java.awt.*;

public class TextFieldAreaPasswordTest extends JFrame {
    public TextFieldAreaPasswordTest() {
        setTitle("ImageIcon설정 컴포넌트");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

//        한 줄 입력
        JTextField textField = new JTextField("",20);
//        여러 줄 입력
        JTextArea textArea = new JTextArea("", 5, 20);
//        비밀번호 입력
        JPasswordField passwordField = new JPasswordField(20);

        add(textField);
        add(textArea);
        add(passwordField);

       int w=350,h=350;
        int[] locations = CenterFrame.getLocation(w, h);
        setBounds(locations[0], locations[1], w, h); //setLocation(x,y) + setSize(w, h)
        setVisible(true);
    }

    public static void main(String[] args) {
        new TextFieldAreaPasswordTest();
    }
}

