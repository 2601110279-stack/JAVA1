package ai1103;

import CenterFrame.SetFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MenuTest extends JFrame {
    JTextArea textArea = new JTextArea();
    JFileChooser fileChooser = new JFileChooser();
    JFrame frame;

    public MenuTest() {
        frame = this;
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        JMenuItem newMenuItem = new JMenuItem("New");//textArea의 문자열을 초기화
        JMenuItem openMenuItem = new JMenuItem("Open");//JFileChooser(showOpenDialog())
        JMenuItem closeMenuItem = new JMenuItem("Close");//System.EXIT
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(closeMenuItem);

        newMenuItem.addActionListener(fileListener);
        openMenuItem.addActionListener(fileListener);
        closeMenuItem.addActionListener(fileListener);

        JMenuItem whiteMenuItem = new JMenuItem("White");
        JMenuItem blueMenuItem = new JMenuItem("Blue");
        JMenuItem magentaMenuItem = new JMenuItem("Magenta");
        editMenu.add(whiteMenuItem);
        editMenu.add(blueMenuItem);
        editMenu.add(magentaMenuItem);

        whiteMenuItem.addActionListener(actionListener);
        blueMenuItem.addActionListener(actionListener);
        magentaMenuItem.addActionListener(actionListener);

        SetFrame.setFrame(this, "메뉴만들기", 500, 500);
    }

    ActionListener fileListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            File selectedFile;
            switch (e.getActionCommand()) {
                case "New":
                    textArea.setText("");
                    break;
                case "Open":
                    // 사용자가 파일 선택 창에서 '열기'를 눌렀을 때만 동작하도록 조건문 추가
                    int returnVal = fileChooser.showOpenDialog(frame);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        selectedFile = fileChooser.getSelectedFile();

                        // 하단에 정의한 readFile 메서드를 호출하여 텍스트를 읽어옴
                        String fileContent = readFile(selectedFile);
                        textArea.setText(fileContent);
                    }
                    break;
                case "Close":
                    System.exit(0);
                    break;
            }
        }
    };

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            Color color = null;
            switch (e.getActionCommand()){
                case "White":
                    color = Color.WHITE;
                    break;
                case "Blue":
                    color = Color.BLUE;
                    break;
                case "Magenta":
                    color = Color.MAGENTA;
                    break;
            }
            textArea.setBackground(color);
        }
    };

    public String readFile(File selectedFile){
        String totalLines = "";
        try {
            String line = "";
            FileReader fr = new FileReader(selectedFile);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null){
                totalLines += line + "\n";
            }
        }catch (FileNotFoundException e){
            textArea.setText("file not found");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return totalLines;
    }

    public static void main(String[] args) {
        new MenuTest();
    }
}