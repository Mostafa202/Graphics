
package line;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


class test extends table{
      
   public int X1 ,Y1,X2,Y2;
   public int check;
   int step;
   
   public static ArrayList <String> data=new ArrayList<>();
    
   
   test(int X1,int Y1,int X2,int Y2,int check)
   {
     
       
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.X1=X1;
        this.Y1=Y1;
        this.X2=X2;
        this.Y2=Y2;
        this.check=check;    
   }
   
     void dda(Graphics g)
       {
        
        int dx=X2-X1,dy=Y2-Y1,steps,k;
        float xinc,yinc,x=X1,y=Y1;
        if(Math.abs(dx)>Math.abs(dy))
        {
            steps=Math.abs(dx);
        }
        else
        {
            steps=Math.abs(dy);
        }
        
        xinc=dx/(float)(steps);
        yinc=dy/(float)(steps);
          
      
          int step=steps;
          data.removeAll(data);
          for (int i = 0; i < steps; i++) {
           
           
            x += xinc;
            y += yinc ;
             data.add(x+"");
            data.add(y+"");
            data.add("("+Math.round(x)+","+Math.round(y)+")");
             g.drawLine(Math.round(x),Math.round(y),Math.round(x), Math.round(y));
                                 
            
        }
        String[][]dt=new String[data.size()/3][3];
        data.toArray(new String[data.size()]);
        
       
      int s=0;
      for(int i=0;i<dt.length;i++)
      {
          for(int j=0;j<3;j++)
          {
              dt[i][j]=data.get(s);
              s++;
          }
           
      }
      
        
         DefaultTableModel m=(DefaultTableModel)tb.getModel();
         m.setDataVector(dt, cols);
    
     
    }
  
   
 
   //------------------------------------------------------------


   @Override
    public void paint(Graphics g) {
        
        super.paint(g);
        if(check==1)
        {
       
        dda(g);
        
        }
        else if(check==2)
            bresenham(g);
        else if(check==3)
            midPointCtrcle(g);
            else
            elipseMidpoint(g);
            
       
    }
   
   
   void bresenham (Graphics g){
        //-----------------
       data.removeAll(data);
       
       //------------------
        int dx =Math.abs(X1-X2),
             dy=Math.abs(Y1-Y2),p=2*dy-dx;
        int twody=2*dy;
        int twodydx=2*(dy-dx);
        int x, y, xend;
       if(X1>X2)
       {
           x=X2;
           y=Y2;
           xend=X1;
       }
       else
       {
           x=X1;
           y=Y1;
           xend=X2;
       }
       data.add(p+"");
       data.add("("+x+","+y+")");
       g.drawLine(x, y, x, y);
       
        while(x<xend)
        {
            x++;
            if(p<0)
                p+=twody;
            else
            {
                y++;
                p+=twodydx;
            }
             data.add(p+"");
             data.add("("+x+","+y+")");
            g.drawLine(x, y, x, y);
        }
        
          String[][]dt=new String[data.size()/2][2];
        data.toArray(new String[data.size()]);
        
       
      int s=0;
      for(int i=0;i<dt.length;i++)
      {
          for(int j=0;j<2;j++)
          {
              dt[i][j]=data.get(s);
              s++;
          }
           
      }
      
        String arr[]={"Pk","Point"};
         DefaultTableModel m=(DefaultTableModel)tb.getModel();
         m.setDataVector(dt,arr);
    
        
        
    }
   
   //---------------------------------------------------------------
   
    public void midPointCtrcle ( Graphics g){
        int r=Y1;
        int x = r , y = 0;
        int p = 1-r;
        int xcenter = X1;
        int ycenter=X2;
        //----------------------------
    
      
        data.removeAll(data);
        
        
        //-------------------------------
        
        while(x>y){
            if (p < 0){
                p += 2*( y + 1)+ 1;
                data.add(p+"");
            } else {
                p += 2 * (y + 1)-2 * (x + 1) + 1;
                data.add(p+"");
                x--;
            }
            
            y++;
            data.add("("+x+","+y+")");
            data.add(2*x+"");
            data.add(2*y+"");
            g.drawLine(x+xcenter, y+ycenter, x+xcenter, y+ycenter);
            g.drawLine(y+xcenter, x+ycenter, y+xcenter, x+ycenter);
            g.drawLine(y+xcenter, -x+ycenter, y+xcenter, -x+ycenter);
            g.drawLine(x+xcenter, -y+ycenter, x+xcenter, -y+ycenter);
            g.drawLine(-y+xcenter, -x+ycenter, -y+xcenter, -x+ycenter);
            g.drawLine(-x+xcenter, -y+ycenter, -x+xcenter, -y+ycenter);
            g.drawLine(-y+xcenter, x+ycenter, -y+xcenter, x+ycenter);
            g.drawLine(-x+xcenter, y+ycenter, -x+xcenter, y+ycenter);
        }
        //--------------
    String[][]dt=new String[data.size()/4][4];
    data.toArray(new String[data.size()]);
        
      int s=0;
      for(int i=0;i<dt.length;i++)
      {
          for(int j=0;j<4;j++)
          {
              dt[i][j]=data.get(s);
              s++;
          }
           
      }
          DefaultTableModel m=(DefaultTableModel)tb.getModel();
          String arr[]={"Pk","Point","2Xk+1","2Yk+1"};
         m.setDataVector(dt, arr);
        
        
        //---------------
        
        
    }
    public void elipseMidpoint ( Graphics g){
        int xCenter=X1;
        int yCenter=Y1;
        int Rx=X2;
        int Ry=Y2;
        
        int Rx2 = Rx*Rx;
        int Ry2 = Ry*Ry;
        int twoRx2 = 2*Rx2 ;
        int twoRy2 = 2*Ry2 ;
        int p , x=0 , y = Ry ,px = twoRy2*x,py = twoRx2 * y;
        //--------------
        data.removeAll(data);
        
        
        //----------------
        plotoint(xCenter, yCenter, x, y, g);
        //
        
        p = (int) Math.round(Ry2 - (Rx2*Ry) + (0.25 * Rx2) );
        while ( px < py ) {            
            x++;
            px = twoRy2*x;
            if (p < 0)
                p+=Ry2 + px;
            else{
                y--;
                py = twoRx2*y;
                p +=Ry2 + px - py;
            }
            data.add(p+"");
            data.add("("+x+","+y+")");
            data.add(py+"");
            data.add(px+"");
            plotoint(xCenter, yCenter, x, y, g);
            
        }
        
        p = (int) Math.round((y-1)*Rx2*(y-1) +Ry2 * (x+.5)*(x+.5) - Rx2*Ry2  );
        while (y >0 ) {            
            y--;
            py =twoRx2 * y;
            if(p>0){
                p+=Rx2-py;
            }else{
                x++;
                px =twoRy2*x;
                p+=Rx2 -py +px;
            }
            data.add(p+"");
            data.add("("+x+","+y+")");
            data.add(px+"");
            data.add(py+"");
            plotoint(xCenter, yCenter, x, y, g);
            
        }
         String[][]dt=new String[data.size()/4][4];
         data.toArray(new String[data.size()]);
        
      int s=0;
      for(int i=0;i<dt.length;i++)
      {
          for(int j=0;j<4;j++)
          {
              dt[i][j]=data.get(s);
              s++;
          }
           
      }
         DefaultTableModel m=(DefaultTableModel)tb.getModel();
          String arr[]={"Pk","Point","2RY2*X","2RX2*Y"};
         m.setDataVector(dt, arr);
        
    }
    public void plotoint(int xC ,int yC ,int x ,int y , Graphics g ){
        g.drawLine(xC +x ,yC +y , xC +x ,yC +y);
        g.drawLine(xC -x ,yC +y , xC -x ,yC +y);
        g.drawLine(xC -x ,yC -y , xC -x ,yC -y);
        g.drawLine(xC +x ,yC -y , xC +x ,yC -y);
    }
   
}

//-----------------------------------------------
public class Line {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        new draw().setVisible(true);
     
        
    }
    
}
