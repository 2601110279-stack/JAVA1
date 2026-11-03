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
    String[] iconFileName = {"new", "open", "close"};
    Color[] colorNames = {Color.WHITE, Color.BLUE, Color.MAGENTA};
    JButton[] btns = new JButton[6];

    public MenuTest() {
        frame = this;
        // 1. 스크롤바 정책 순서 수정 완료 (수직 -> 수평)
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane);

        JToolBar toolBar = new JToolBar();
        add("North", toolBar);

        // 2. ArrayIndexOutOfBoundsException 해결: 파일 버튼 3개와 색상 버튼 3개를 나누어 생성
        // 파일 버튼 3개 (이미지 아이콘 적용)
        for (int i = 0; i < 3; i++) {
            btns[i] = new JButton(new ImageIcon("toolbar/" + iconFileName[i] + ".png"));
            btns[i].addActionListener(btnListener);
            toolBar.add(btns[i]);
        }

        // 색상 버튼 3개 (텍스트 이름 적용)
        String[] colorBtnNames = {"White", "Blue", "Magenta"};
        for (int i = 0; i < 3; i++) {
            btns[i + 3] = new JButton(colorBtnNames[i]);
            btns[i + 3].addActionListener(btnListener);
            toolBar.add(btns[i + 3]);
        }

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem closeMenuItem = new JMenuItem("Close");
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
                    // 3. 파일 메뉴에서 '열기'를 누를 때 취소 예외 처리 방지
                    int returnVal = fileChooser.showOpenDialog(frame);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        selectedFile = fileChooser.getSelectedFile();
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

    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton eBtn = (JButton) e.getSource();
            File selectedFile;
            if (eBtn == btns[0]){
                textArea.setText("");
            }else if (eBtn == btns[1]){
                // 4. 툴바에서 '열기'를 누를 때 취소 예외 처리 방지 (권장 방식 적용)
                int returnVal = fileChooser.showOpenDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    textArea.setText(readFile(selectedFile));
                }
            }else if (eBtn == btns[2]){
                System.exit(0);
            }

            for (int i = 0; i < colorNames.length; i++) {
                if (eBtn == btns[i + 3]){
                    textArea.setBackground(colorNames[i]);
                }
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
            br.close(); // 메모리 누수 방지를 위해 스트림 닫기 추가
            fr.close();
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