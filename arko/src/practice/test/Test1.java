package practice.test;
class A{
	 static int i = 0 ;
	 static{
		 System.out.println("static");
	 }
	public A() {
		System.out.println("constructor");
	}
	 
}
class B{
	void func(A a){
		a.i = 10 ;
	}
}
public class Test1 {
	static{
		 System.out.println("test");
	 }
	public static void main(String[] args) {
		System.out.println("adss");
      A a = new A();
     
	  B b = new B();
	 b.func(a);
	  A a1 = new A();
	  System.out.println(a.i);
	  System.out.println(a1.i);
	  Test test = new Test();
	  Test test2 = new Test();
	}
}

