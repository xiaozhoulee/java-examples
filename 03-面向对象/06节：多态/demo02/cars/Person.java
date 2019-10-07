package cars;

public class Person {
 /*
    public void drive(Benz bc){
        bc.run();
    }
    奔驰汽车坏了，再重新创建一个开宝马汽车的方法
    public void drive(BMW bm){
        bm.run();
    }
    */

    //上面代码扩展性太差，每新增加一种品牌的汽车就需要再写一个方法
    //将参数修改为Car类型，这样不论增加什么样的品牌汽车，都可以调用这个方法
      public void drive(Car c){
          c.run();
       }
}
