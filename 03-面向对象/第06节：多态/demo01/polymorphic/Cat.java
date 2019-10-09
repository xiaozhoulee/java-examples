package polymorphic;
//Cat类继承了Animal类
public class Cat extends Animal {
    //定义的这个num成员变量是和Animal里面的num成员变量重名的
    public int num=20;
    //重写eat方法
    public void eat(){
    System.out.println("猫在吃");
    }
    //Cat独有的方法
    public void move(){
        System.out.println("猫走路很轻盈");
    }

    }
