/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_1;

/**
 *
 * @author vuong
 */
public class NextStep {
    private int mark;
    private String point1;
    private String point2;

    public NextStep() {
    }

    public NextStep(int mark, String point1, String point2) {
        this.mark = mark;
        this.point1 = point1;
        this.point2 = point2;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getPoint1() {
        return point1;
    }

    public void setPoint1(String point1) {
        this.point1 = point1;
    }

    public String getPoint2() {
        return point2;
    }

    public void setPoint2(String point2) {
        this.point2 = point2;
    }

    
}
