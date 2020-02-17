package test;

import java.util.ArrayList;

/**
 *
 * @author lhm
 */
public class TransportRobot extends Robot {
    
    private int height;
    private int width;
    private int length;
    
    public TransportRobot(){
        super();
        this.height = 1;
        this.width = 2;
        this.length = 3;
    }
    
    public TransportRobot(int height, int width, int length){
        super();
        //super(1, 2, 3, 4, 5, 6);  这里super用这一行还是上一行，取决于，你想不想调用robot的无参构造函数，还是自己定义；其他TransportRobot的构造函数同理
        this.height = height;
        this.width = width;
        this.length = length;
    }
    
    public TransportRobot(int a, int b, int c, int d, int e, int f, int height, int width, int length){
        super(a, b, c, d, e, f);
        this.height = height;
        this.width = width;
        this.length = length;
    }
    
    private int cargoArea(){
        return this.height * this.width * this.length;
    }  
    
    public String printFormat(){
        //调用父类的方法，然后用自己形式接上新添加的参数
        return super().format() + this.cargoArea();
    }
    
    public static void main(String args[]){
        TransportRobot ts1 = new TransportRobot();
        TransportRobot ts2 = new TransportRobot();
        TransportRobot ts3 = new TransportRobot();
        TransportRobot ts4 = new TransportRobot();
        TransportRobot ts5 = new TransportRobot();
        
        ArrayList<TransportRobot> tsList = new ArrayList();
        tsList.add(ts1);
        //自己添加完毕，然后接下来可以循环调用printFormat显示
        
    }
    
}
