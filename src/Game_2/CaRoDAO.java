/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_2;

import javax.swing.JButton;

/**
 *
 * @author vuong
 */
public class CaRoDAO {
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
}
