//
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class work06 {
    

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("총 진행할 투표수를 입력해 주세요.");
        int vote_count = scanner.nextInt();

        System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요.");
        int candidate = scanner.nextInt();

        String[] candidate_arry = new String[candidate];

        for (int i = 0; i < candidate; i++) {
            System.out.print((i + 1) + "번째 후보자이름을 입력해 주세요.");
            String name = scanner.next();
            candidate_arry[i] = "[기호:" + (i + 1) + "] " + name;
        }


        double percent = 0;
        double indi_vote_percent = 0;
        int indi_vote_count = 0;

        int[] vote_num_arr = new int[candidate];
        double[] percent_arr = new double[candidate];


        for (int i = 1; i < vote_count + 1; i++) {

            percent = ((double) i / (double) vote_count) * 100;
            Random random = new Random();
            int random_number = random.nextInt(candidate) + 1;
            int win = random_number - 1;

            System.out.printf("[투표진행률]: %.2f%%, %d명 투표 =>", percent, i);
            System.out.println(candidate_arry[win]);

            for (int j = 0; j < candidate; j++) {

                if (win == j) {
                    vote_num_arr[j] += 1;
                    percent_arr[j] += ((double) 1 / (double) vote_count) * 100;
                }

                System.out.print(candidate_arry[j] + ":    ");
                System.out.printf("%.2f%%  (투표수: %d)", percent_arr[j], vote_num_arr[j]);
                System.out.println();


            }
        }


    }
}
