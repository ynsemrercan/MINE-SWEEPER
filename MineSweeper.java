import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    private int adetSatir;
    private int adetSutun;
    private char[][] mineMap;
    private char[][] board;
    private int sayac = 0;
    private int satirNo;
    private int sutunNo;
    private boolean win;
    private boolean gameOver;

    public MineSweeper(int adetSatir, int adetSutun) {
        this.adetSatir = adetSatir;
        this.adetSutun = adetSutun;
        this.mineMap = new char[adetSatir][adetSutun];
        this.board = new char[adetSatir][adetSutun];
        fill(mineMap, '-');
        fill(board, '-');
    }

    public void randomSayi() {
        Random rdn = new Random();
        this.satirNo = rdn.nextInt(this.adetSatir);

        Random rdn2 = new Random();
        this.sutunNo = rdn2.nextInt(this.adetSutun);
    }
    // fill(mineMap, '-'); ifadesi, mineMap adlı iki boyutlu dizinin tüm elemanlarına "-" karakterini atar.
    // Aynı şekilde, fill(board, '-'); ifadesi de board adlı iki boyutlu dizinin tüm elemanlarına "-" karakterini atar.
    public void fill(char[][] dizi, char value) {
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[i].length; j++) {
                dizi[i][j] = value;
            }
        }
    }

    public boolean isMine(char[][] arr, int row, int col) {
        return arr[row][col] == '*';
    }

    public void placeMines(int mayinSayisi) {
        while (sayac < mayinSayisi) {
            randomSayi();
            if (!isMine(mineMap, satirNo, sutunNo)) {
                mineMap[satirNo][sutunNo] = '*';
                sayac++;
            }
        }
    }

    public void run() {
        int mayinSayisi = adetSatir * adetSutun / 4;
        placeMines(mayinSayisi);
        printMineMap();
        printBoard();
        while (!gameOver) {
            koordinatGir();
            if (win) {
                System.out.println("KAZANDINIZ !!!");
                break;
            }
        }
    }

    public void koordinatGir() {
        System.out.println("Satır Giriniz: ");
        int satir = getValidInput(0, adetSatir - 1);

        System.out.println("Sütun Giriniz: ");
        int sutun = getValidInput(0, adetSutun - 1);

        if (isMine(mineMap, satir, sutun)) {
            System.out.println("Kaybettiniz! Mayına bastınız!");
            printMineMap();
            gameOver = true;
            return;
        }

        int sayac = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int yeniSatir = satir + i;
                int yeniSutun = sutun + j;
                if (yeniSatir >= 0 && yeniSatir < adetSatir && yeniSutun >= 0 && yeniSutun < adetSutun) {
                    if (isMine(mineMap, yeniSatir, yeniSutun)) {
                        sayac++;
                    }
                }
            }
        }

        board[satir][sutun] = (char) (sayac + '0');

        if (sayac == 0) {
            openEmptyCells(satir, sutun);
        }

        if (checkWin()) {
            win = true;
        }

        printBoard();
    }

    public int getValidInput(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int input = scanner.nextInt();
            if (input >= min && input <= max) {
                return input;
            } else {
                System.out.println("Hatalı giriş! Tekrar giriniz:");
            }
        }
    }

    public void openEmptyCells(int row, int col) {
        if (row < 0 || row >= adetSatir || col < 0 || col >= adetSutun || board[row][col] != '-') {
            return;
        }

        int sayac = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int yeniSatir = row + i;
                int yeniSutun = col + j;
                if (yeniSatir >= 0 && yeniSatir < adetSatir && yeniSutun >= 0 && yeniSutun < adetSutun) {
                    if (isMine(mineMap, yeniSatir, yeniSutun)) {
                        sayac++;
                    }
                }
            }
        }

        board[row][col] = (char) (sayac + '0');

        if (sayac == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int yeniSatir = row + i;
                    int yeniSutun = col + j;
                    openEmptyCells(yeniSatir, yeniSutun);
                }
            }
        }
    }

    public boolean checkWin() {
        int cellsWithoutMine = adetSatir * adetSutun - sayac;
        int revealedCells = 0;
        for (int i = 0; i < adetSatir; i++) {
            for (int j = 0; j < adetSutun; j++) {
                if (board[i][j] != '-') {
                    revealedCells++;
                }
            }
        }
        return revealedCells == cellsWithoutMine;
    }

    public void printMineMap() {
        System.out.println("Mayın Haritası:");
        for (int i = 0; i < adetSatir; i++) {
            for (int j = 0; j < adetSutun; j++) {
                System.out.print(" " + mineMap[i][j]);
            }
            System.out.println();
        }
    }

    public void printBoard() {
        System.out.println("Oyun Tahtası:");
        for (int i = 0; i < adetSatir; i++) {
            for (int j = 0; j < adetSutun; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


}
