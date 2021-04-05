/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_1;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author vuong
 */
public class CaroDAO_2 {

    public static boolean checkWin(int i, int j, JButton b[][]) {
        int cou = 0, row = i, col = j;
        // kiểm tra hàng
        while (b[row][j].getText() == b[i][j].getText()) {
            cou++;
            row++;
        }
        row = i - 1;
        while (b[row][j].getText() == b[i][j].getText()) {
            cou++;
            row--;
        }
        if (cou > 4) {
            return true;
        }
        cou = 0;
        // kiểm tra cột
        while (b[i][col].getText() == b[i][j].getText()) {
            cou++;
            col++;
        }
        col = j - 1;
        while (b[i][col].getText() == b[i][j].getText()) {
            cou++;
            col--;
        }
        if (cou > 4) {
            return true;
        }
        // kiểm tra đường chéo 1
        col = j;
        row = i;
        cou = 0;
        while (b[i][j].getText() == b[row][col].getText()) {
            cou++;
            col++;
            row++;
        }
        col = j - 1;
        row = i - 1;
        while (b[i][j].getText() == b[row][col].getText()) {
            cou++;
            col--;
            row--;
        }
        if (cou > 4) {
            return true;
        }
        // kiểm tra đường chéo 2
        col = j;
        row = i;
        cou = 0;
        while (b[i][j].getText() == b[row][col].getText()) {
            cou++;
            col++;
            row--;
        }
        col = j - 1;
        row = i + 1;
        while (b[i][j].getText() == b[row][col].getText()) {
            cou++;
            col--;
            row++;
        }
        if (cou > 4) {
            return true;
        }
        // nếu không đương chéo nào thỏa mãn thì trả về false.
        return false;
    }

    public static NextStep column(int i, int j, JButton b[][], String turn) {
        int row = i + 1, mark, x = -1, y = -1;
        if (turn == "X") {
            mark = 2;
        } else {
            mark = -1;
        }
        // kiểm tra hàng
        while (b[row][j].getText() == turn) {
            row++;
            mark *= 2;
        }
        if (b[row][j].getText() != " ") {
            if (mark > 0) {
                mark -= 1;
            } else {
                mark += 1;
            }
        } else {
            x = row;
            y = j;
            row++;
            while (b[row][j].getText() == turn) {
                row++;
                mark *= 2;
            }
            if(row!=x+1){
                
            }
        }
        row = i - 1;
        while (b[row][j].getText() == turn) {
            row--;
            mark *= 2;
        }
        if (b[row][j].getText() != " " && x == -1 && y == -1) {
            mark = 0;
            return new NextStep(mark, " ", " ");
        } else if (b[row][j].getText() != " ") {
            if (mark > 0) {
                mark -= 1;
            } else {
                mark += 1;
            }
            return new NextStep(mark, x + " " + y, " ");
        } else if (x == -1 && y == -1) {
            return new NextStep(mark, row + " " + j, " ");
        }
        return new NextStep(mark, x + " " + y, row + " " + j);
    }

    public static NextStep row(int i, int j, JButton b[][], String turn) {
        int col = j + 1, mark, x = -1, y = -1;
        if (turn == "X") {
            mark = 2;
        } else {
            mark = -1;
        }
        while (b[i][col].getText() == turn) {
            col++;
            mark *= 2;
        }
        if (b[i][col].getText() != " ") {
            if (mark > 0) {
                mark -= 1;
            } else {
                mark += 1;
            }
        } else {
            x = i;
            y = col;
        }
        col = j - 1;
        while (b[i][col].getText() == turn) {
            col--;
            mark *= 2;
        }
        if (b[i][col].getText() != " " && x == -1 && y == -1) {
            mark = 0;
            return new NextStep(mark, " ", " ");
        } else if (b[i][col].getText() != " ") {
            if (mark > 0) {
                mark -= 1;
            } else {
                mark += 1;
            }
            return new NextStep(mark, x + " " + y, " ");
        } else if (x == -1 && y == -1) {
            return new NextStep(mark, i + " " + col, " ");
        }
        return new NextStep(mark, x + " " + y, i + " " + col);
    }

    public static NextStep diagonal_1(int i, int j, JButton b[][], String turn) {
        int row = i + 1, col = j + 1, mark, x = -1, y = -1;
        if (turn == "X") {
            mark = 2;
        } else {
            mark = -1;
        }
        // kiểm tra đường chéo 1
        while (turn == b[row][col].getText()) {
            col++;
            row++;
            mark *= 2;
        }
        if (b[row][col].getText() != " ") {
            if (mark > 0) {
                mark -= 1;
            } else {
                mark += 1;
            }
        } else {
            x = row;
            y = col;
        }
        col = j - 1;
        row = i - 1;
        while (turn == b[row][col].getText()) {
            col--;
            row--;
            mark *= 2;
        }
        if (b[row][col].getText() != " " && x == -1 && y == -1) {
            mark = 0;
            return new NextStep(mark, " ", " ");
        } else if (b[row][col].getText() != " ") {
            if (mark > 0) {
                mark -= 1;
            } else {
                mark += 1;
            }
            return new NextStep(mark, x + " " + y, " ");
        } else if (x == -1 && y == -1) {
            return new NextStep(mark, row + " " + col, " ");
        }
        return new NextStep(mark, x + " " + y, row + " " + col);
    }

    public static NextStep diagonal_2(int i, int j, JButton b[][], String turn) {
        int row = i - 1, col = j + 1, mark, x = -1, y = -1;
        if (turn == "X") {
            mark = 2;
        } else {
            mark = -1;
        }
        // kiểm tra đường chéo 1
        while (turn == b[row][col].getText()) {
            col++;
            row--;
            mark *= 2;
        }
        if (b[row][col].getText() != " ") {
            if (mark > 0) {
                mark -= 1;
            } else {
                mark += 1;
            }
        } else {
            x = row;
            y = col;
        }
        col = j - 1;
        row = i + 1;
        while (turn == b[row][col].getText()) {
            col--;
            row++;
            mark *= 2;
        }
        if (b[row][col].getText() != " " && x == -1 && y == -1) {
            mark = 0;
            return new NextStep(mark, " ", " ");
        } else if (b[row][col].getText() != " ") {
            if (mark > 0) {
                mark -= 1;
            } else {
                mark += 1;
            }
            return new NextStep(mark, x + " " + y, " ");
        } else if (x == -1 && y == -1) {
            return new NextStep(mark, row + " " + col, " ");
        }
        return new NextStep(mark, x + " " + y, row + " " + col);
    }

    public static int mark(int i, int j, JButton b[][], String turn) {
        NextStep columnStep = column(i, j, b, turn);
        NextStep rowStep = row(i, j, b, turn);
        NextStep diagonal_1Step = diagonal_1(i, j, b, turn);
        NextStep diagonal_2Step = diagonal_2(i, j, b, turn);
        return columnStep.getMark() + rowStep.getMark() + diagonal_1Step.getMark() + diagonal_2Step.getMark();
    }

    public static int checkMax(JButton b[][], String point, int pointMax, int max) {
        String result = "";
        int k = point.indexOf(32);
        int ii = Integer.parseInt(point.substring(0, k));
        int jj = Integer.parseInt(point.substring(k + 1, point.length()));
        int mark = mark(ii, jj, b, "O");
        if (max > mark - pointMax) {
            max = mark - pointMax;
        }
        return max;
    }

    public static NextStep defectStep(int i, int j, JButton b[][], List<String> stepSystem) {
        List<NextStep> list = new ArrayList<>();
        list.add(column(i, j, b, "X"));
        list.add(row(i, j, b, "X"));
        list.add(diagonal_1(i, j, b, "X"));
        list.add(diagonal_2(i, j, b, "X"));
        String result = "";
        int max = 0;
        for (NextStep step : list) {
            if (!step.getPoint1().equals(" ")) {
                if (max != checkMax(b, step.getPoint1(), step.getMark(), max)) {
                    max = checkMax(b, step.getPoint1(), step.getMark(), max);
                    result = step.getPoint1();
                }
                if (!step.getPoint2().equals(" ")) {
                    if (max != checkMax(b, step.getPoint2(), step.getMark(), max)) {
                        max = checkMax(b, step.getPoint1(), step.getMark(), max);
                        result = step.getPoint2();
                    }
                }
            }
        }
        NextStep atk = attackStep(b, stepSystem);

        if (atk != null) {
            System.out.println(atk.getPoint1() + ":" + atk.getMark());
            System.out.println(result + ":" + max);
            if (max < atk.getMark()) {
                return new NextStep(max, result, "");
            } else {
                return new NextStep(atk.getMark(), result, atk.getPoint1());
            }
        }
        return new NextStep(max, result, "");
    }

    public static NextStep attackStep(JButton b[][], List<String> stepSystem) {
        if (!stepSystem.isEmpty()) {
            int min = 0;
            String result1 = "";
            for (String point : stepSystem) {
                if (min != checkMax(b, point, 0, min)) {
                    min = checkMax(b, point, 0, min);
                    result1 = point;
                }
            }
            int k = result1.indexOf(32);
            int i = Integer.parseInt(result1.substring(0, k));
            int j = Integer.parseInt(result1.substring(k + 1, result1.length()));
            List<NextStep> list = new ArrayList<>();
            list.add(column(i, j, b, "O"));
            list.add(row(i, j, b, "O"));
            list.add(diagonal_1(i, j, b, "O"));
            list.add(diagonal_2(i, j, b, "O"));
            String result2 = "";
            int max = 0;
            for (NextStep step : list) {
                if (!step.getPoint1().equals(" ")) {
                    if (max != checkMax(b, step.getPoint1(), 0, max)) {
                        max = checkMax(b, step.getPoint1(), 0, max);
                        result2 = step.getPoint1();
                    }
                    if (!step.getPoint2().equals(" ")) {
                        if (max != checkMax(b, step.getPoint2(), 0, max)) {
                            max = checkMax(b, step.getPoint1(), 0, max);
                            result2 = step.getPoint2();
                        }
                    }
                }
            }
            return new NextStep(max, result2, "");
        }
        return null;
    }
}
