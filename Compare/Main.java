import java.util.*;

class Checker implements Comparator<com.bootcamp.Player> {
    public int compare(com.bootcamp.Player first, com.bootcamp.Player second) {
        if (Integer.compare(second.score, first.score) == 0) {
            return first.name.compareTo(second.name);
        }
        else return Integer.compare(second.score, first.score);
    }
}

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        com.bootcamp.Player[] player = new com.bootcamp.Player[n];
        com.bootcamp.Checker checker = new com.bootcamp.Checker();

        for(int i = 0; i < n; i++){
            player[i] = new com.bootcamp.Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
