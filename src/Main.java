import java.util.ArrayList;
import java.util.Scanner;

abstract class Ticket {
    private String movieName;
    private int seatRow;
    private int seatCol;
    private int basePrice;

    public Ticket(String movieName, int seatRow, int seatCol, int basePrice) {
        this.movieName = movieName;
        this.seatRow = seatRow;
        this.seatCol = seatCol;
        this.basePrice = basePrice;
    }

    public String getMovieName() { return movieName; }
    public int getSeatRow() { return seatRow; }
    public int getSeatCol() { return seatCol; }
    public int getBasePrice() { return basePrice; }

    public abstract void printTicketInfo();
}

class StandardTicket extends Ticket {
    public StandardTicket(String movieName, int row, int col) {
        super(movieName, row, col, 10000);
    }

    @Override
    public void printTicketInfo() {
        System.out.println("[일반석] " + getMovieName() + " - " + getSeatRow() + "행 " + getSeatCol() + "열 (결제금액: " + getBasePrice() + "원)");
    }
}

class VIPTicket extends Ticket {
    private String[] perks;

    public VIPTicket(String movieName, int row, int col) {
        super(movieName, row, col, 15000);
        perks = new String[]{"팝콘 무료", "음료 제공", "리클라이너"};
    }

    @Override
    public void printTicketInfo() {
        System.out.print("[VIP석] " + getMovieName() + " - " + getSeatRow() + "행 " + getSeatCol() + "열 (결제금액: " + getBasePrice() + "원) | 혜택: ");
        for (int i = 0; i < perks.length; i++) {
            System.out.print(perks[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Ticket> myTickets = new ArrayList<>();

        int[][] seats = new int[5][5]; // 0 = 빈자리, 1 = 예약됨
        String[] movies = {"범죄도시", "인사이드 아웃", "파묘"};

        while (true) {
            System.out.println("\n=== 영화관 좌석 예매 시스템 ===");
            System.out.println("1. 좌석 조회 및 예매하기");
            System.out.println("2. 나의 예매 내역 확인");
            System.out.println("3. 예매 취소하기");
            System.out.println("4. 시스템 종료");
            System.out.print("메뉴 선택: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("\n[현재 좌석 현황] (1~2행: VIP석, 3~5행: 일반석)");
                System.out.println("  1 2 3 4 5 (열)");

                for (int i = 0; i < 5; i++) {
                    System.out.print((i + 1) + "행 ");
                    for (int j = 0; j < 5; j++) {
                        if (seats[i][j] == 0) {
                            System.out.print("□ ");
                        } else {
                            System.out.print("■ ");
                        }
                    }
                    System.out.println();
                }

                System.out.println("\n상영작 목록:");
                for (int i = 0; i < movies.length; i++) {
                    System.out.println((i + 1) + ". " + movies[i]);
                }
                System.out.print("예매할 영화 번호 선택 (1~3): ");
                int movieIdx = Integer.parseInt(scanner.nextLine()) - 1;

                System.out.print("예매할 행 번호 (1~5): ");
                int row = Integer.parseInt(scanner.nextLine()) - 1;
                System.out.print("예매할 열 번호 (1~5): ");
                int col = Integer.parseInt(scanner.nextLine()) - 1;

                if (seats[row][col] == 1) {
                    System.out.println("이미 예매된 좌석입니다. 다른 좌석을 선택해주세요.");
                } else {
                    seats[row][col] = 1;
                    Ticket newTicket;

                    if (row < 2) {
                        newTicket = new VIPTicket(movies[movieIdx], row + 1, col + 1);
                        System.out.println("VIP석이 예매되었습니다.");
                    } else {
                        newTicket = new StandardTicket(movies[movieIdx], row + 1, col + 1);
                        System.out.println("일반석이 예매되었습니다.");
                    }
                    myTickets.add(newTicket);
                }

            } else if (choice.equals("2")) {
                if (myTickets.isEmpty()) {
                    System.out.println("예매 내역이 없습니다.");
                } else {
                    System.out.println("\n[나의 예매 내역]");
                    for (Ticket t : myTickets) {
                        t.printTicketInfo();
                    }
                }
            } else if (choice.equals("3")) {
                if (myTickets.isEmpty()) {
                    System.out.println("취소할 예매 내역이 없습니다.");
                } else {
                    System.out.println("\n[나의 예매 내역] (취소할 번호를 선택하세요, 0은 취소 안함)");
                    for (int i = 0; i < myTickets.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        myTickets.get(i).printTicketInfo();
                    }
                    System.out.print("취소할 번호 입력: ");
                    int cancelIdx = Integer.parseInt(scanner.nextLine()) - 1;

                    if (cancelIdx == -1) {
                        System.out.println("취소를 중단했습니다.");
                    } else if (cancelIdx < 0 || cancelIdx >= myTickets.size()) {
                        System.out.println("잘못된 번호입니다.");
                    } else {
                        Ticket target = myTickets.get(cancelIdx);
                        int r = target.getSeatRow() - 1;
                        int c = target.getSeatCol() - 1;

                        seats[r][c] = 0;
                        myTickets.remove(cancelIdx);

                        System.out.println("예매가 취소되었습니다. (" + target.getMovieName() + " - " + target.getSeatRow() + "행 " + target.getSeatCol() + "열)");
                    }
                }

            } else if (choice.equals("4")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
        scanner.close();
    }
}