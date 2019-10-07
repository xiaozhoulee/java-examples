package Super;

public class Dog extends Animal {
    public String name="旺财";
    public void eat(){
        System.out.println("吃狗粮");
    }
    public void m1(){
        super.eat();
        this.eat();
        System.out.println(super.name);
        System.out.println(this.name);
    }
}
