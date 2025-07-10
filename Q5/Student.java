public class Student {
    private String name;
    private int age;

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) { // Validation logic
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Abhayjit");
        s.setAge(22);

        System.out.println("Name: " + s.getName());
        System.out.println("Age: " + s.getAge());
    }
}
