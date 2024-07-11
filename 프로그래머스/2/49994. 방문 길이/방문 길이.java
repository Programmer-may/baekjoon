import java.util.*;

class Solution {
    class Road {
        int currX;
        int currY;
        int nextX;
        int nextY;

        Road(int currX, int currY, int nextX, int nextY) {
            this.currX = currX;
            this.currY = currY;
            this.nextX = nextX;
            this.nextY = nextY;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Road))
                return false;
            Road road = (Road) o;
            return (currX == road.currX && currY == road.currY && nextX == road.nextX && nextY == road.nextY)
                    || (currX == road.nextX && currY == road.nextY && nextX == road.currX && nextY == road.currY);
        }

        @Override
        public int hashCode() {
            int[] sortedX = new int[]{currX, nextX};
            int[] sortedY = new int[]{currY, nextY};
            Arrays.sort(sortedX);
            Arrays.sort(sortedY);
            return Objects.hash(sortedX[0], sortedY[0], sortedX[1], sortedY[1]);
        }
    }

    public int solution(String dirs) {
        Set<Road> answer = new HashSet<>();
        int x = 0;
        int y = 0;
        for (char cmd : dirs.toCharArray()) {
            int newX = x, newY = y;
            if (cmd == 'U' && y + 1 <= 5) {
                newY = y + 1;
            } else if (cmd == 'D' && y - 1 >= -5) {
                newY = y - 1;
            } else if (cmd == 'L' && x - 1 >= -5) {
                newX = x - 1;
            } else if (cmd == 'R' && x + 1 <= 5) {
                newX = x + 1;
            }
            if (newX != x || newY != y) {
                answer.add(new Road(x, y, newX, newY));
                x = newX;
                y = newY;
            }
        }
        return answer.size();
    }
}