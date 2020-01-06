import java.util.Set;
import java.util.TreeSet;

/**
 * leetcode 804号问题
 * @program: data-structure
 * @author: yaopeng
 * @create: 2020-01-06 21:55
 **/
public class UniqueMorseRepresentations {

    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new TreeSet<>();
        for(String word : words){
            StringBuilder res = new StringBuilder();
            for(int i = 0; i < word.length(); i ++)
                res.append(codes[word.charAt(i) - 'a']);
            set.add(res.toString());
        }
        return set.size();

    }
}
