package pshalka;

class Person {
    private final String fio;
    private final String post;
    private final String email;
    private final String tel;
    private final double salary;
    private int age;

    Person(String fio, String post, String email, String tel, double salary, int age) {
        this.fio = fio;
        this.post = post;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        if(age >= 18) {
            this.age = age;
        } else {
            System.out.println("Сотрудник должен быть старше 18 лет");
        }
    }

    int GetAge() {
        return age;
    }

    void Show() {
        System.out.println(fio + " " + post + " " +  email + " " + tel + " " + salary + " " + age);
    }
}



public class Main {

    public static void main(String[] args) {

        Person[] PersonArray = new Person[5];
        PersonArray[0] = new Person("Ivanov Ivan ", "Engineer ", "ivivan@mailbox.com ", "892312312 ", 30000, 30);
        PersonArray[1] = new Person("Ivanov Ivan1", "Engineer1", "ivivan1@mailbox.com", "1892312312", 40000, 40);
        PersonArray[2] = new Person("Ivanov Ivan2", "Engineer2", "ivivan2@mailbox.com", "2892312312", 50000, 50);
        PersonArray[3] = new Person("Ivanov Ivan3", "Engineer3", "ivivan3@mailbox.com", "3892312312", 60000, 60);
        PersonArray[4] = new Person("Ivanov Ivan4", "Engineer4", "ivivan4@mailbox.com", "4892312312", 70000, 70);

        for(Person item : PersonArray) {
            if(item.GetAge() > 40) item.Show();
        }
    }
}