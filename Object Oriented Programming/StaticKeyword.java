public class StaticKeyword {
    public static void main(String[] args)
    {
        Student std1 = new Student();
        std1.schoolName = "GECA";
        std1.name = "Prajwal";
        
        std1.percentage = 83;

        std1.rate();

        Student std2 = new Student();
        System.out.println(std2.schoolName);

        Student std3 = new Student();
        System.out.println(std3.schoolName);
        std3.rate();

    }
}

class Student{
    String name;
    int roll;
    static int percentage;

    void rate(){
        if(percentage >= 90 && percentage<100){
            System.out.println("Excellent");
        }
        else if(percentage >= 80 && percentage<90){
            System.out.println("Very good");
        }
        else{
            System.out.println("Good");
        }
    }

    static String schoolName;

    void setName(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }
}