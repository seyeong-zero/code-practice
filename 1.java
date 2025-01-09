import java.time.DayOfWeek;
import java.time.chrono.IsoChronology;
import java.util.Scanner;
import java.time.LocalDate;
public class work05 {


    public static void printCalendar(int year, int month){

        System.out.printf("[%d년 %02d월]", year, month-1);
        System.out.print("                     ");//공백 10
        System.out.printf("[%d년 %02d월]", year, month);
        System.out.print("                     ");//공백 10
        System.out.printf("[%d년 %02d월]", year, month+1);
        System.out.println();
        System.out.print("일   월   화   수   목   금   토");
        System.out.print("     ");//공백 5
        System.out.print("일   월   화   수   목   금   토");
        System.out.print("     ");//공백 5
        System.out.print("일   월   화   수   목   금   토");
        System.out.println();

        LocalDate beforedate = LocalDate.of(year, month-1, 1);//9월
        LocalDate date = LocalDate.of(year, month, 1); //10월
        LocalDate afterdate = LocalDate.of(year, month+1, 1);//11월

        DayOfWeek before_dayOfWeek = beforedate.getDayOfWeek();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        DayOfWeek after_dayOfWeek = afterdate.getDayOfWeek();

        //1일 시작 요일
        // sun =0 , mon=1, tue=2, wed=3, thu=4, fri=5, sat=6
        int before_firstDayOfMonth = before_dayOfWeek.getValue() % 7;
        int firstDayOfMonth = dayOfWeek.getValue() % 7;
        int after_firstDayOfMonth = after_dayOfWeek.getValue() % 7;

        //달의 길이
        int before_lengthOfMonth = beforedate.lengthOfMonth();
        int lengthOfMonth = date.lengthOfMonth();
        int after_lengthOfMonth = afterdate.lengthOfMonth();


        //arrays of 3months

        int[] sep = new int[before_lengthOfMonth];
        int[] oct = new int[lengthOfMonth];
        int[] nov= new int[after_lengthOfMonth];



        for (int a = 0; a <before_lengthOfMonth ; a++) {
            sep[a]= a+1;
        }
        for (int b  = 0; b <lengthOfMonth ; b++) {
            oct[b]= b+1;
        }
        for (int c = 0; c <after_lengthOfMonth ; c++) {
            nov[c]= c+1;
        }


        int j=0;
        int k=0;

        int sep_c = before_firstDayOfMonth;
        int oct_c = firstDayOfMonth;
        int nov_c = after_firstDayOfMonth;

        boolean firstJ= true;
        boolean firstK = true;




        for (int t = 0; t < before_firstDayOfMonth; t++) {
          System.out.print("    ");
        }


        outer:
        for (int i = 0; i < before_lengthOfMonth; i++) {
            System.out.printf("%02d  ",sep[i]);
            sep_c++;
            int spaceCount_sep = 7-sep_c;

            if (i==before_lengthOfMonth-1){

                System.out.print("    ".repeat(spaceCount_sep));
            }

            if(sep_c == 7|| i==before_lengthOfMonth-1){
                sep_c=0;
                System.out.print("     ");

                //2번쨰 달 ,

                while (lengthOfMonth > j){

                    //달력시작 공백 생성
                    if (firstJ) {
                        System.out.print("    ".repeat(firstDayOfMonth));
                        firstJ = false;
                    }

                    //날짜 출력
                    System.out.printf("%02d  ",oct[j]);
                    j++;
                    oct_c++; //요일 ++

                    int spaceCount_oct = 7-oct_c;

                    //다음달로 넘어가기
                    if (oct_c ==7||j==lengthOfMonth-1){
                        oct_c =0;
                        System.out.print("     ");

                        //달의 마지막일떄 다음달로 넘어갈 space 처리
                        if (j==lengthOfMonth-1){
                            System.out.print("    ".repeat(spaceCount_oct));

                        }


                        while(k<after_lengthOfMonth) {

                            if (firstK) {
                                System.out.print("    ".repeat(after_firstDayOfMonth));
                                firstK = false;
                            }

                            nov_c++;
                            System.out.printf("%02d  ",nov[k]);
                            k++;


                            if (nov_c ==7|k==after_lengthOfMonth){
                                nov_c=0;
                                System.out.println();

                                continue outer;

                            }



                        }
                    }

                }
            }





        }

                }













    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
        int year = scanner.nextInt();

        System.out.print("달력의 월을 입력해 주세요.(mm): ");
        int month = scanner.nextInt();


        printCalendar(year,month);



    }

}
