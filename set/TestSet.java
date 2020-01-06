import java.util.ArrayList;

public class TestSet {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            Set<String> set1 = new LinkedListSet<>();
            Set<String> set2 = new BSTSet<>();
            for (String word : words1){
                set1.add(word);
                set2.add(word);
            }

            System.out.println("Total different words: " + set1.getSize());
            System.out.println("Total different words: " + set2.getSize());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("a-tale-of-two-cities.txt", words2)){
            System.out.println("Total words: " + words2.size());

            Set<String> set3 = new LinkedListSet<>();
            Set<String> set4 = new BSTSet<>();
            for(String word: words2){
                set3.add(word);
                set4.add(word);
            }

            System.out.println("Total different words: " + set3.getSize());
            System.out.println("Total different words: " + set4.getSize());
        }



    }

}
