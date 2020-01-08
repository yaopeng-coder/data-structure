import java.util.ArrayList;

public class TestMap {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            Map<String,Integer> linkedListMap = new LinkedListMap<>();
            Map<String,Integer> bstMap = new BSTMap<>();
            for (String word : words1){
               if(linkedListMap.contains(word)){
                   linkedListMap.add(word,linkedListMap.get(word)+1);
                   bstMap.add(word,bstMap.get(word)+1);
               }else {
                   linkedListMap.add(word,1);
                   bstMap.add(word,1);
               }
            }

            System.out.println("Total different words: " + linkedListMap.getSize());
            System.out.println("Total different words: " + bstMap.getSize());
            System.out.println("the prejudice words number: " + linkedListMap.get("prejudice"));
            System.out.println("the prejudice words number: " + bstMap.get("prejudice"));
        }

        System.out.println();





    }

}
