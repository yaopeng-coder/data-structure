/**
 * @program: data-structure
 * @author: yaopeng
 * @create: 2019-12-19 18:45
 **/
public class Student {

    private String name;
    private int scores;

    public Student(String name, int scores) {
        this.name = name;
        this.scores = scores;
    }


    @Override
    public String toString() {

        return String.format("{student name : %s, student scores: %d}",name,scores);

    }

    public static void main(String[] args){


        Array<Student> array = new Array<>();

        Student s1 = new Student("小红",60);

        array.addLast(s1);
        array.addLast(new Student("小明",90));
        array.addLast(new Student("小刚",80));
        System.out.println(array);

        System.out.println(array.contains(s1));

        array.removeElement(s1);
        System.out.println(array);

    }
}
