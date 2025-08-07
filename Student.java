class Student
 {
    String name;
    int roll;
    Address adr;
 
    Student(int roll,String name,Address adr)
    {
        this.roll=roll;
        this.name=name;
        this.adr=adr;
    }
 
    public void displayStudent()
        {
            System.out.println("Name of the student"+name);
            System.out.println("Roll"+roll);
        }
 
 }
 
