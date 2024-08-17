import java.util.*;

class Solution {
    List<List<Integer>> candidates = new ArrayList<>();
    String[][] relation;
    int numCols;
    int numRows;
    
    public int solution(String[][] relation) {
        this.relation = relation;
        this.numCols = relation[0].length;
        this.numRows = relation.length;

        // 조합 생성 및 후보키 검증
        for (int i = 1; i <= numCols; i++) {
            generateCombinations(new ArrayList<>(), 0, i);
        }

        // 최소성 검사
        List<List<Integer>> candidateKeys = new ArrayList<>();
        for (List<Integer> candidate : candidates) {
            boolean isMinimal = true;
            for (List<Integer> key : candidateKeys) {
                if (candidate.containsAll(key)) {
                    isMinimal = false;
                    break;
                }
            }
            if (isMinimal) {
                candidateKeys.add(candidate);
            }
        }

        return candidateKeys.size();
    }
    
    private void generateCombinations(List<Integer> combination, int start, int length) {
        if (combination.size() == length) {
            if (isUnique(combination)) {
                candidates.add(new ArrayList<>(combination));
            }
            return;
        }
        
        for (int i = start; i < numCols; i++) {
            combination.add(i);
            generateCombinations(combination, i + 1, length);
            combination.remove(combination.size() - 1);
        }
    }

    private boolean isUnique(List<Integer> combination) {
        Set<String> uniqueSet = new HashSet<>();
        
        for (int i = 0; i < numRows; i++) {
            StringBuilder sb = new StringBuilder();
            for (int col : combination) {
                sb.append(relation[i][col]).append(",");
            }
            if (!uniqueSet.add(sb.toString())) {
                return false;
            }
        }        
        return true;
    }
}