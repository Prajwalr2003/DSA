public class Constructors {
    public static void main(String[] args)
    {
        Student s1 = new Student();
        s1.name = "Prajwal";
        s1.rollNo = 57;
        s1.password = "abcd";
        s1.marks[0] = 90;
        s1.marks[1] = 100;
        s1.marks[2] = 80;

        Student s2 = new Student(s1);
        s2.password = "wxyz";

        s1.marks[1] = 85;

        // s2 is changes after s1.marks[1]=85 changes because first we 
        // created the array and s2 only refers to the array which is 
        // created in array s1 so if s1 is changes it will 
        // reflect to the s2.

        System.out.println(s2.name +" "+ s2.rollNo+" " + s2.password);

        for(int i=0;i<3;i++)
        {
            System.out.println(s2.marks[i]);
        }
        
    }
}

class Student
{
    String name;
    int rollNo;
    String password;
    int marks[];

    // shallow copy constructor
    // Student(Student s1){
    //     marks = new int[3];
    //     this.name = s1.name;
    //     this.rollNo = s1.rollNo;
    //     this.marks = s1.marks;
    // }

    //deep copy constructor
    Student(Student s1){
        marks = new int[3];
        this.name = s1.name;
        this.rollNo = s1.rollNo;
        for(int i=0;i<marks.length;i++){
            this.marks[i] = s1.marks[i];
        }
    }

    Student(){
        marks = new int[3];
        System.out.println("Constructor is called....");
    }

    Student(String name){
        marks = new int[3];
        this.name = name;
    }

    Student(int rollNo){
        marks = new int[3];
        this.rollNo = rollNo;
    }
}
