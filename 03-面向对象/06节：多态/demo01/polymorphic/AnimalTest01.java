package polymorphic;

public class AnimalTest01 {
  public static void main(String[] args){
      Animal a1=new Cat();//首先Animal是Cat的父类，a1就是一个父类的引用，然后指向了Cat子类对象，这个就叫父类引用指向子类对象。
      a1.eat();//为什么打印结果是"猫在吃"?因为动态绑定和静态绑定。
      //Java在编译阶段会把这个eat方法当成Animal里的方法（静态绑定）
      //Java在运行阶段会发现其实a1指定的是Cat对象，所以会输出"猫在吃"（动态绑定）

      System.out.println(a1.num);//打印结果为10，说明成员变量不存在重写。

      //a1.move();
      //直接打印a1.move()会报错，这个时候就需要强制类型转换

      Cat c2=(Cat)a1;//将a1强制转换成Cat类型。（向下转型）
      c2.move();//这时就可以成功打印出Cat类中的move方法了

      Animal a2=new Dog();
//      Cat c3=(Cat)a2;//因为本身a2是指向的Dog对象，如果想把Dog对象强转成Cat对象是不行的所以会报错 error ClassCastException（转型错误）
      //所以Java中为了避免这种错误，可以使用instanceof关键字
      if(a2 instanceof Cat){
          Cat c4=(Cat)a2;
      }else {
          System.out.println("a2不是Cat类型，不能转换");
      }

  }
}
