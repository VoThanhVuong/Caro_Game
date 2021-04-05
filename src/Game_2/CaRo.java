package Game_2;

import Game_1.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CaRo extends JFrame implements ActionListener {

    Color background_cl = Color.white;
    Color x_cl = Color.red;
    Color y_cl = Color.blue;
    int row = 20, column = 30, count = 0;
    int xUndo[] = new int[row * column];
    int yUndo[] = new int[row * column];
    boolean tick[][] = new boolean[row + 2][column + 2];
    int Size = 0;
    Container cn;
    JPanel pn, pn2;
    JLabel lb;
    JButton newGame_bt, undo_bt, exit_bt;
    public JButton b[][] = new JButton[row + 2][column + 2];
    List<String> option = new ArrayList<>();

    public CaRo(String s) {
        super(s);
        cn = this.getContentPane();
        pn = new JPanel();
        pn.setLayout(new GridLayout(row, column));
        for (int i = 0; i <= row + 1; i++) {
            for (int j = 0; j <= column + 1; j++) {
                b[i][j] = new JButton(" ");
                b[i][j].setActionCommand(i + " " + j);
                b[i][j].setBackground(background_cl);
                b[i][j].addActionListener(this);
                tick[i][j] = true;
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                pn.add(b[i][j]);
            }
        }
        for (int i = 0; i < column + 2; i++) {
            tick[0][i] = false;
            b[0][i].setText("N");
            tick[row + 1][i] = false;
            b[row + 1][i].setText("N");
        }
        for (int i = 1; i < row + 1; i++) {
            tick[i][0] = false;
            b[i][0].setText("N");
            tick[i][column + 1] = false;
            b[i][column + 1].setText("N");
        }
        lb = new JLabel("X Đánh Trước");
        newGame_bt = new JButton("New Game");
        undo_bt = new JButton("Undo");
        exit_bt = new JButton("Exit");
        newGame_bt.addActionListener(this);
        undo_bt.addActionListener(this);
        exit_bt.addActionListener(this);
        exit_bt.setForeground(x_cl);
        cn.add(pn);
        pn2 = new JPanel();
        pn2.setLayout(new FlowLayout());
        pn2.add(lb);
        pn2.add(newGame_bt);
        pn2.add(undo_bt);
        pn2.add(exit_bt);
        cn.add(pn2, "North");
        this.setVisible(true);
        this.setSize(1400, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        undo_bt.setEnabled(false);
    }

    public void undo() {
        if (Size > 0) {
            b[xUndo[Size - 1]][yUndo[Size - 1]].setText(" ");
            b[xUndo[Size - 1]][yUndo[Size - 1]].setActionCommand(xUndo[Size - 1] + " " + yUndo[Size - 1]);
            b[xUndo[Size - 1]][yUndo[Size - 1]].setBackground(background_cl);
            tick[xUndo[Size - 1]][yUndo[Size - 1]] = true;
            count--;
            if (count % 2 == 0) {
                lb.setText("Lượt Của X");
            } else {
                lb.setText("Lượt Của O");
            }
            Size--;
            if (Size == 0) {
                undo_bt.setEnabled(false);
            }
        }
    }

    public void addPoint(int i, int j) {
        xUndo[Size] = i;
        yUndo[Size] = j;
        Size++;
        if (count % 2 == 0) {
            b[i][j].setText("X");
            b[i][j].setFont(new Font("Dialog", Font.BOLD, 18));
            b[i][j].setForeground(x_cl);
            lb.setText("Lượt Của O");
        } else {
            b[i][j].setText("O");
            b[i][j].setFont(new Font("Dialog", Font.BOLD, 16));
            b[i][j].setForeground(y_cl);
            lb.setText("Lượt Của X");
        }
        tick[i][j] = false;
        count++;
        b[i][j].setBackground(Color.GRAY);
        undo_bt.setEnabled(true);
    }

    public void system(int i, int j) {
        if (CaRoDAO.checkWin(i, j, b)) {
            lb.setBackground(Color.MAGENTA);
            lb.setText(b[i][j].getText() + " WIN");
            for (i = 1; i <= row; i++) {
                for (j = 1; j <= column; j++) {
                    b[i][j].setEnabled(false);
                }
            }
            undo_bt.setEnabled(false);
            newGame_bt.setBackground(Color.YELLOW);
            for (int r = i - 1; r <= i + 1; r++) {
                for (int l = j - 1; l <= j + 1; l++) {
                    if(b[r][l].getText()==" "){
                        option.add(r+" "+l);
                    }
                }
            }
        } else {
//            String nextStep = CaRoDAO.defectStep(i, j, b, stepSystem);
//            boolean check = true;
//            for (String point : stepSystem) {
//                if (point.equals(nextStep)) {
//                    stepSystem.remove(point);
//                    check = false;
//                    break;
//                }
//            }
//            if (check) {
//                stepSystem.add(nextStep);
//            }
//            int k = nextStep.indexOf(32);
//            i = Integer.parseInt(nextStep.substring(0, k));
//            j = Integer.parseInt(nextStep.substring(k + 1, nextStep.length()));
//            if (tick[i][j]) {
//                addPoint(i, j);
//            }
//            if (CaRoDAO.checkWin(i, j, b)) {
//                lb.setBackground(Color.MAGENTA);
//                lb.setText(b[i][j].getText() + " WIN");
//                for (i = 1; i <= row; i++) {
//                    for (j = 1; j <= column; j++) {
//                        b[i][j].setEnabled(false);
//                    }
//                }
//                undo_bt.setEnabled(false);
//                newGame_bt.setBackground(Color.YELLOW);
//            }
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "New Game") {
            new CaRo("CODELEARN - GAME CARO");
            this.dispose();
        } else if (e.getActionCommand() == "Undo") {
            undo();
            undo();
        } else if (e.getActionCommand() == "Exit") {
            System.exit(0);;
        } else {
            String s = e.getActionCommand();
            int k = s.indexOf(32);
            int i = Integer.parseInt(s.substring(0, k));
            int j = Integer.parseInt(s.substring(k + 1, s.length()));
            if (tick[i][j]) {
                addPoint(i, j);
                system(i, j);
            }
        }
    }

    public static void main(String[] args) {
        new CaRo("CODELEARN - GAME CARO");
    }
}
