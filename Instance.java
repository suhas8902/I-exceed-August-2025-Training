class Instance
 {
 
    {
        System.out.println("Instance block is called");
    }

    {
        System.out.println("HI");
    }

    static{
        System.out.println("inside static block");
    }
 
    Instance() // constructor
    {
        System.out.println("Inside constructor");
    }
 
     public static void main(String[] args) {
       // new demoBlock();
        System.out.println("Inside main mathod");
     }
 }