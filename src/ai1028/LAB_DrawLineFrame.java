package ai1028;

import CenterFrame.SetFrame;

import javax.swing.*;

public class LAB_DrawLineFrame extends JFrame {
    LAB_ColorPaper colorPaper;

    public LAB_DrawLineFrame(){
        colorPaper = new LAB_ColorPaper();
        add(colorPaper);

        addMouseListener();

        SetFrame.setFrame(this, "마우스로 선 그리기", 500, 500);
    }

    private void addMouseListener() {
    }

    public static void main(String[] args) {
        new LAB_DrawLineFrame();
    }
}
