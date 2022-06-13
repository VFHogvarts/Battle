import java.util.Arrays;


public class newTask {
    public static String robotank = "☖";
    public static String empty = "_";
    public static String hit = "🎯";
    public static int width = 30;
    public static int height = 10;
    public static String[][] field = new String[height][width];
    public static int[][] bombs = new int[height][width];

    public static void main(String[] args) {

        for (int i = 0; i < field.length; i++) {
            Arrays.fill(field[i], empty);
        }
        //заполняем массив field значением empty

        for (int i = 0; i < field.length; i++) {
            int j = (int) (Math.random() * width);
            field[i][j] = robotank;
        }
        //распологаем robotanks

        int tanks = 10;
        while (tanks > 0) {
            bombs = new int[height][width];
            for (int i = 0; i < bombs.length; i++) {
                int bombCount = 10;
                while (bombCount > 0) {
                    int j = (int) (Math.random() * width);
                    if (bombs[i][j] == 0) {
                        bombs[i][j] = 1;
                        bombCount--;
                    }
                }
            }

            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (bombs[i][j] == 1 && robotank.equals(field[i][j])) {
                        field[i][j] = hit;
                        tanks--;
                    }
                }
            }
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (bombs[i][j] == 1 && robotank.equals(field[i][j])) {
                    field[i][j] = hit;
                }
            }
        }
        //проходимся по массивам и если находим совпадения то значения hit записываются

        for (int i = 0;i< field.length;i++){
            for (int j = 0;j<field[i].length;j++){
                System.out.print(field[i][j]);
            }
            System.out.println();
            //выводим результат
        }
    }
}
