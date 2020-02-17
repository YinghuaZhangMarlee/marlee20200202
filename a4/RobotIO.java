package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author lhm
 */
public class RobotIO {
    
    
    //这里有一个问题是，传参的第二个参数是否一定要String，还是要File类型，都可以，写法会不一样
    private void Save(Robot robot, String pathName){
        try (FileWriter fr = new FileWriter(pathName);) {
             //参考课上老师的代码，把robot.format 返回的字符串 写进去 指定的文件名中
        } catch (IOException e) {

        }
    }
    
    //提供一个Save的File写法,区别于1，传参进来的时候，需要提前写一句File fRobot = new File("Robot.txt"); 
    //然后才可以RobotIO rIO = new RobotIO(); rIO.Save(robot, fRobot);
    private void Save(Robot robot, File fRobot){
        try {   
            fRobot.createNewFile();
            FileWriter writer = new FileWriter(fRobot);
            writer.write(robot.format()); 
            //这里可以继续完善，例如你知道传进来的可以是TransportRobot把？TransportRobot也是一个Robot，你做完所有了来考虑这里
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void load(String pathName){
        try (FileReader fr = new FileReader(pathName);) {
            int num = 0;
            char[] buf = new char[1024]; 
            while ((num = fr.read(buf)) != -1) {  	
                System.out.println(new String(buf,0,num));
            }
            //这里打出来文件内容之后，根据你保存进去文件的robot格式，及robot.format进行字符分割，参考下面链接
            //https://www.w3cschool.cn/java/java-string-split.html
            //这里没有意外你会得到6个数据每行，也就是你存进去的一行能分为六个属性，然后这里可以存进去Robot类，即new Robot(你的参数)
            
            //上一步是实例化Robot，实例化TransportRobot怎么办？TransportRobot有9个参数，只读到了6个？
            //你可以看看Transport的构造函数有没有合适的就好

        } catch (IOException e) {

        }
        
    }
    
}
