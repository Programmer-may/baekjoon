import java.util.*;

class Solution {
    class File implements Comparable<File> {
        String name;
        String head;
        int num;
        int order;

        File(String fileName, int order) {
            Map<String, Object> map = process(fileName);
            this.name = fileName;
            this.head = (String) map.get("head");
            this.num = (int) map.get("num");
            this.order = order;
        }

        @Override
        public int compareTo(File f) {
            if (this.head.equals(f.head)) {
                if (this.num == f.num) {
                    return this.order - f.order;
                }
                return this.num - f.num;
            }
            return this.head.compareTo(f.head);
        }

        private Map<String, Object> process(String fileName) {
            Map<String, Object> map = new HashMap<>();
            char[] arr = fileName.toCharArray();
            String head = "";
            int num = 0;
            loop:
            for (int i = 0; i < arr.length; i++) {
                if (Character.isDigit(arr[i])) {
                    head = fileName.substring(0, i).toLowerCase();
                    StringBuilder sb = new StringBuilder();
                    for (int j = i; j < arr.length; j++) {
                        if (Character.isDigit(arr[j])) sb.append(arr[j]);
                        else {
                            num = Integer.parseInt(sb.toString());
                            break loop;
                        }
                    }
                    num = Integer.parseInt(sb.toString());
                    break;
                }
            }
            map.put("head", head);
            map.put("num", num);
            return map;
        }
    }
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        PriorityQueue<File> pq = new PriorityQueue<>();
        int order = 1;
        for (String file : files) {
            pq.add(new File(file, order++));
        }
        int idx = 0;
        while (!pq.isEmpty()) {
            answer[idx++] = pq.poll().name;
        }
        return answer;
    }
}