package VocabProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Word {
    private String english;
    private String korean;

    public Word(String english, String korean) {
        this.english = english;
        this.korean = korean;
    }

    public String getEnglish() {
        return english;
    }

    public String getKorean() {
        return korean;
    }
}

public class VocabProgram {
    private ArrayList<Word> wordList;
    private Scanner scanner;
    private Random random;
    private final String FILE_NAME = "src/VocabProject/voca.txt";

    public VocabProgram() {
        wordList = new ArrayList<>();
        scanner = new Scanner(System.in);
        random = new Random();
        loadWordsFromFile();
    }

    public void start() {
        while (true) {
            System.out.println("\n=== TOEIC 영단어장 및 퀴즈 프로그램 ===");
            System.out.println("1. 단어 추가");
            System.out.println("2. 단어장 목록 보기");
            System.out.println("3. 단어 퀴즈 풀기");
            System.out.println("4. 프로그램 종료");
            System.out.print("메뉴를 선택하세요: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addWord();
                    break;
                case "2":
                    showWords();
                    break;
                case "3":
                    takeQuiz();
                    break;
                case "4":
                    System.out.println("프로그램을 종료합니다. 열공하세요!");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 1~4 사이의 숫자를 입력해주세요.");
            }
        }
    }

    private void addWord() {
        System.out.print("영어 단어 입력: ");
        String eng = scanner.nextLine();
        System.out.print("한글 뜻 입력: ");
        String kor = scanner.nextLine();

        wordList.add(new Word(eng, kor));
        saveWordsToFile(); // 리스트에 추가한 뒤 파일에도 덮어쓰기
        System.out.println("단어가 성공적으로 등록 및 저장되었습니다!");
    }

    private void showWords() {
        if (wordList.isEmpty()) {
            System.out.println("등록된 단어가 없습니다. 먼저 단어를 추가해주세요.");
            return;
        }
        System.out.println("\n[단어장 목록]");
        for (int i = 0; i < wordList.size(); i++) {
            Word w = wordList.get(i);
            System.out.println((i + 1) + ". " + w.getEnglish() + " - " + w.getKorean());
        }
    }

    private void takeQuiz() {
        if (wordList.isEmpty()) {
            System.out.println("단어가 등록되어 있지 않아 퀴즈를 진행할 수 없습니다.");
            return;
        }

        int index = random.nextInt(wordList.size());
        Word questionWord = wordList.get(index);

        System.out.println("\n=== 퀴즈 시작! ===");
        System.out.println("문제: 다음 단어의 뜻은? [" + questionWord.getEnglish() + "]");
        System.out.print("정답 입력: ");
        String answer = scanner.nextLine();

        if (answer.trim().equals(questionWord.getKorean())) {
            System.out.println("정답입니다! 훌륭합니다.");
        } else {
            System.out.println("틀렸습니다. 정답은 [" + questionWord.getKorean() + "] 입니다.");
        }
    }

    private void loadWordsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("[알림] 기존 저장된 단어장 파일이 없어 새로 시작합니다.");
            return;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    wordList.add(new Word(parts[0], parts[1]));
                }
            }
            System.out.println("[알림] 기존 단어장 데이터를 성공적으로 불러왔습니다.");
        } catch (FileNotFoundException e) {
            System.out.println("단어장 파일을 읽는 중 오류가 발생했습니다.");
        }
    }

    private void saveWordsToFile() {
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            for (Word w : wordList) {
                fw.write(w.getEnglish() + ":" + w.getKorean() + "\n");
            }
        } catch (IOException e) {
            System.out.println("단어장 저장 중 오류가 발생했습니다.");
        }
    }

    public static void main(String[] args) {
        VocabProgram program = new VocabProgram();
        program.start();
    }
}