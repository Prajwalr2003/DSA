public class CopyConstructor {
    public static void main(String[] args)
    {
        Student s1 = new Student("Prajwal");
        System.out.println(s1.name);
    }
}

class Student
{
    String name;
    int rollNo;

    Student(String name){
        // System.out.println("Constructors is called....");
        this.name = name;
    }
}