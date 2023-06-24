import java.io.*;
import java.util.HashMap;


public class Main
{

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        loopOut:
        while(t --> 0){
            int n = Integer.parseInt(br.readLine());

            Trie trie = new Trie();

            boolean check = false;
            String arr[] = new String[n];
            for(int i=0; i<n; i++){
                String input = br.readLine();

                trie.insert(input);
                arr[i] = input;
            }

            for(String k : arr){
                if(trie.contains(k)) {
                    check = true;
                    break;
                }
            }

            if(check) bw.write("NO\n");
            else bw.write("YES\n");
        }

        bw.close();
    }

}

class Trie{
    private TrieNode rootNode;

    Trie(){
        rootNode = new TrieNode();
    }

    void insert(String word){
        TrieNode thisNode = this.rootNode;

        for(int i=0; i<word.length(); i++)
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());

        thisNode.setIsLastChar(true);

    }

    boolean contains(String word){
        TrieNode thisNode = this.rootNode;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            TrieNode node = thisNode.getChildNodes().get(ch);

            if(node == null) return false;

            thisNode = node;
        }

        if(thisNode.isLastChar()){
            if(thisNode.getChildNodes().isEmpty())
                return false;
        }

        return thisNode.isLastChar();
    }

    void delete(String word){
        delete(this.rootNode, word, 0);
    }

    private void delete(TrieNode thisNode, String word, int index){
        char ch = word.charAt(index);

        if(!thisNode.getChildNodes().containsKey(ch))
            throw new Error("There is no [" + word + "] in this Trie");

        TrieNode childNode = thisNode.getChildNodes().get(ch);
        index ++;

        if(index == word.length()){
            if(!childNode.isLastChar())
                throw new Error("There is no [" + word + "] in this Trie");

            childNode.setIsLastChar(false);

            if(childNode.getChildNodes().isEmpty())
                thisNode.getChildNodes().remove(ch);
            else{
                delete(childNode, word, index);

                if(!childNode.isLastChar() && childNode.getChildNodes().isEmpty())
                    thisNode.getChildNodes().remove(ch);
            }
        }
    }
}


class TrieNode{
    private HashMap<Character, TrieNode> childNodes = new HashMap<>();
    private boolean isLastChar;


    HashMap<Character, TrieNode> getChildNodes(){ return this.childNodes; }
    boolean isLastChar(){return this.isLastChar;}
    void setIsLastChar(boolean isLastChar){this.isLastChar = isLastChar;}

}