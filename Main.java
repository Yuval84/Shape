import javax.swing.*;

/**
 * Created by yuval_edelman on 4/14/2015.
 */
public class Main {
    public static void main(String []args) throws CloneNotSupportedException {
        Paint p=new Paint();
        JFrame frame=new JFrame("paint");
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(p);
    }
}
