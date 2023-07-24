import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<>();
        String tree;
        int totalTreeCnt = 0;
        /*
        do {
            tree= scanner.nextLine().strip();

            map.put(tree, map.getOrDefault(tree, 0) + 1);
            totalTreeCnt++;

        } while (tree != null && !tree.isEmpty());
        */
        while ( (tree=br.readLine()) != null && !tree.isEmpty()){
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            totalTreeCnt++;
        }

        List<String> treeList = new ArrayList<>(map.keySet());
        //treeList.sort(Comparator.naturalOrder());
        Collections.sort(treeList);
        for (String treeName : treeList){
            System.out.printf("%s %.4f\n", treeName,(float)map.get(treeName)/totalTreeCnt*100);
        }
    }
}