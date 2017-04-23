import java.awt.*;

/**
 * Created by yuval_edelman on 4/10/2015.
 */
public class MyOval extends MyBoundedShape {

    public MyOval (){
        super();
    }

    public MyOval(MyOval other){
        super(other);
    }

    public MyOval( int x1,int y1,int x2,int y2,Color color,boolean full){
        super(x1,y1,x2,y2,color,full);
    }




    @Override
    public void paint(Graphics g) {
        g.setColor(this.getColor());
        if (this.full()){
            g.fillOval(this.getX1(),this.getY1(),this.getX2(),this.getY2());
        }else{
            g.drawOval(this.getX1(),this.getY1(),this.getX2(),this.getY2());
        }
    }

}
