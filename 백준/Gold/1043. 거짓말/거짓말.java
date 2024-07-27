import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parent;

    public static void main(String[] args) throws IOException {
        String[] info = br.readLine().split(" ");
        int totalPeople = Integer.parseInt(info[0]);
        int totalParty = Integer.parseInt(info[1]);

        String[] knownPeople = br.readLine().split(" ");
        int totalKnownPeople = Integer.parseInt(knownPeople[0]);
        if (totalKnownPeople == 0) {
            System.out.println(totalParty);
            return;
        }
        parent = new int[totalPeople + 1];
        for (int i = 1; i <= totalPeople; i++) {
            parent[i] = i;
        }
        List<int[]> parties = new ArrayList<>();

        for (int i = 0; i < totalParty; i++) {
            String[] partyInfo = br.readLine().split(" ");
            int partyPeopleNum = Integer.parseInt(partyInfo[0]);
            int[] party = new int[partyPeopleNum];
            for (int j = 0; j < partyPeopleNum; j++) {
                party[j] = Integer.parseInt(partyInfo[j + 1]);
            }
            parties.add(party);
            for (int j = 1; j < partyPeopleNum; j++) {
                union(party[0], party[j]);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= totalKnownPeople; i++) {
            set.add(find(Integer.parseInt(knownPeople[i])));
        }
        int answer = 0;
        for (int[] party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (set.contains(find(person))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static int find(int num) {
        if (num == parent[num]) return num;
        else return parent[num] = find(parent[num]);
    }

    private static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);
        if (findA != findB) parent[findA] = findB;
    }
}
