package ai1028;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;     // 추가됨: MouseEvent 임포트
import java.awt.event.MouseListener;

public class LAB_ColorPaper extends JPanel {
    int x1, y1, x2, y2;

    public LAB_ColorPaper() {
        setBackground(Color.YELLOW);
        addMouseListener(panelLinster);
    }

    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        g.drawLine(x1, y1, x2, y2);
    }

    MouseListener panelLinster = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY(); // 수정됨: e.getX() -> e.getY()
        }

        @Override
        public void mouseReleased(MouseEvent e) { // 수정됨: mousePressed -> mouseReleased
            x2 = e.getX();
            y2 = e.getY(); // 수정됨: e.getX() -> e.getY()
            repaint();
        }
    };
}