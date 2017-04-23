
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by yuval_edelman on 4/10/2015.
 */
public class Paint extends JPanel {
    final int MIN=0;   //for the random numbers
    final int MAX=200; //for the random numbers
    private JFrame frame;
    private JPanel panel;

    Random rand=new Random();
    protected ArrayList<MyShape> myShapes=new ArrayList<MyShape>(); //shape array
    protected ArrayList<MyShape> myCloneShapes=new ArrayList<MyShape>(); //shape copy array
    public Paint() throws CloneNotSupportedException {
        MyLine line1=new MyLine(rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN, Color.BLACK); //create the shape
        MyLine line2=new MyLine(rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN, Color.PINK);
        MyOval oval1=new MyOval(rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN, Color.CYAN,true);
        MyOval oval2=new MyOval(rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN, Color.RED,false);
        MyRectangle rec1=new MyRectangle(rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN, Color.YELLOW,true);
        MyRectangle rec2=new MyRectangle(rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN,rand.nextInt((MAX - MIN) ) + MIN, Color.GREEN,false);
        myShapes.add(0,line1);//adding the shapes to the array
        myShapes.add(1,line2);
        myShapes.add(2,oval1);
        myShapes.add(3,oval2);
        myShapes.add(4,rec1);
        myShapes.add(5,rec2);

        MyLine lineClone1 = (MyLine)line1.clone(); //clone the shape
        MyLine lineClone2 = (MyLine)line2.clone();
        MyOval ovalClone1 = (MyOval)oval1.clone();
        MyOval ovalClone2 = (MyOval)oval2.clone();
        MyRectangle recClone1 = (MyRectangle)rec1.clone();
        MyRectangle recClone2 = (MyRectangle)rec2.clone();

        lineClone1.setX1(lineClone1.getX1()+10); //adding 10 to x
        lineClone1.setY1(lineClone1.getY1()+10); //adding 10 to y
        lineClone2.setX1(lineClone2.getX1()+10);
        lineClone2.setY1(lineClone2.getY1()+10);
        ovalClone1.setX1(ovalClone1.getX1()+10);
        ovalClone1.setY1(ovalClone1.getY1()+10);
        ovalClone2.setX1(ovalClone2.getX1()+10);
        ovalClone2.setY1(ovalClone2.getY1()+10);
        recClone1.setX1(recClone1.getX1()+10);
        recClone2.setY1(recClone2.getY1()+10);

        myCloneShapes.add(0,lineClone1); //adding the shape to the clone array
        myCloneShapes.add(1,lineClone2);
        myCloneShapes.add(2,ovalClone1);
        myCloneShapes.add(3,ovalClone2);
        myCloneShapes.add(4,recClone1);
        myCloneShapes.add(5,recClone2);







    }

    public void paintComponent(Graphics g) { //method that painting the shapes
        super.paintComponent(g);
        for (int i=0;i<=myShapes.size()-1;i++){
            g.setColor(myShapes.get(i).getColor());
            if (myShapes.get(i) instanceof MyLine){ //if the shape is line
                g.setColor(myShapes.get(i).getColor());
                g.drawLine(myShapes.get(i).getX1(),myShapes.get(i).getY1(),myShapes.get(i).getX2(),myShapes.get(i).getY2());
                g.setColor(myCloneShapes.get(i).getColor());
                g.drawLine(myCloneShapes.get(i).getX1(),myCloneShapes.get(i).getY1(),myCloneShapes.get(i).getX2(),myCloneShapes.get(i).getY2());
            }
            if (myShapes.get(i) instanceof MyOval){ //if the shape is oval
                if (((MyOval) myShapes.get(i)).full()==true){ //if the shape full
                    g.setColor(myShapes.get(i).getColor());
                    g.fillOval(myShapes.get(i).getX1(), myShapes.get(i).getY1(), myShapes.get(i).getX2(), myShapes.get(i).getY2());
                    g.setColor(myCloneShapes.get(i).getColor());
                    g.drawOval(myCloneShapes.get(i).getX1(), myCloneShapes.get(i).getY1(), myCloneShapes.get(i).getX2(), myCloneShapes.get(i).getY2());
                }else { //if the shape empty
                    g.setColor(myShapes.get(i).getColor());
                    g.drawOval(myShapes.get(i).getX1(),myShapes.get(i).getY1(),myShapes.get(i).getX2(),myShapes.get(i).getY2());
                    g.setColor(myCloneShapes.get(i).getColor());
                    g.fillOval(myCloneShapes.get(i).getX1(), myCloneShapes.get(i).getY1(), myCloneShapes.get(i).getX2(), myCloneShapes.get(i).getY2());
                }
            }else{
                if (myShapes.get(i)instanceof MyRectangle){//if the shape is rectangle
                    if (((MyRectangle) myShapes.get(i)).full()==true){//if the shape full
                        g.setColor(myShapes.get(i).getColor());
                        g.fillRect(myShapes.get(i).getX1(), myShapes.get(i).getY1(), myShapes.get(i).getX2(), myShapes.get(i).getY2());
                        g.setColor(myCloneShapes.get(i).getColor());
                        g.drawRect(myCloneShapes.get(i).getX1(), myCloneShapes.get(i).getY1(), myCloneShapes.get(i).getX2(), myCloneShapes.get(i).getY2());
                    }else{//if the shape empty
                        g.setColor(myShapes.get(i).getColor());
                        g.drawRect(myShapes.get(i).getX1(), myShapes.get(i).getY1(), myShapes.get(i).getX2(), myShapes.get(i).getY2());
                        g.setColor(myCloneShapes.get(i).getColor());
                        g.fillRect(myCloneShapes.get(i).getX1(), myCloneShapes.get(i).getY1(), myCloneShapes.get(i).getX2(), myCloneShapes.get(i).getY2());
                    }
                }
            }

        }
    }
}
