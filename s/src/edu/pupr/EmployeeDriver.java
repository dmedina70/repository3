package edu.pupr;


public class EmployeeDriver {
    private static EmployeeFrame frame;

    public static void main(String[] args) {
        frame = new EmployeeFrame();
        frame.setVisible(true);
    }

    public static void closeFrame() {
        frame.dispose();
    }
}