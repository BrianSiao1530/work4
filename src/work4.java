import java.util.*;
//算成績
//會先問有哪一種考試的成績
public class work4 {
    public static void main(String[] args) {
        begin();//固定的
        int ans = application(1);
        double first = show(ans);
        double firGPA = gpa();
        ans = application(2);
        double second = show(ans);
        double secGPA = gpa();
        report(first, firGPA, second, secGPA);
    }
    //一開始的文字說明
    public static void begin() {
        System.out.println("This program compares two applicants to");
        System.out.println("determine which one seems like the stronger");
        System.out.println("applicant.  For each candidate I will need");
        System.out.println("either SAT or ACT scores plus a weighted GPA.");
        System.out.println();
    }
    //輸入你的第n項申請，請問要選 sat or act，用 1 或 2回答
    public static int application(int num) {
            System.out.println("Information for applicant #" + num);
            System.out.print("  do you have 1) SAT scores or 2) ACT scores? ");
            Scanner answer = new Scanner(System.in);
            int answer1 = answer.nextInt();
            return answer1;
    }
    //印出考別&把科目跟成績回傳出去
    //用在ACT() , SAT()上
    public static int tands(String test, String subject) {
        Scanner answer = new Scanner(System.in);
        System.out.print("  "+test+" "+subject+"? ");
        int grades = answer.nextInt();
        return grades;
    }
    //計算SAT的成績
    public static double SATCOM(double math, double criticalreading, double writing) { //算sat的score
        double score = (2 * math + criticalreading + writing) / 32.0;
        System.out.println("  exam score = " + round1(score));
        return round1(score);
    }
    //計算ACT的成績
    public static double ACTCOM(double Engish, double math, double reading, double science){ //算act的sc
        double score = (Engish + 2 * math + reading + science) / 1.8;
        System.out.println("  exam score = " + round1(score));
        return round1(score);
    }

    public static double show(int answer1) {
        double score;
        if (answer1 == 1) {
          score = SAT();
        }else  {
          score = ACT();
        }
        return score;
    }

    public static double SAT(){
        String name = "SAT";
        int math = tands(name, "math");
        int criticalreading = tands(name, "critical reading");
        int writing = tands(name, "writing");
        return SATCOM(math, criticalreading, writing);
    }
    public static double ACT() {
        String name = "ACT";
        int english = tands(name, "English");
        int matha = tands(name, "math");
        int reading = tands(name, "reading");
        int science = tands(name, "science");
        double act = ACTCOM(english, matha, reading, science);
        return round1(act);

    }
   //輸入Overall & Max GPA & 加成  計算出GPA
    public static double gpa() {
        Scanner answer = new Scanner(System.in);
        System.out.printf("  overall GPA? ");
        double overGPA = answer.nextDouble();
        System.out.printf("  max GPA? ");
        double maxGPA = answer.nextDouble();
        System.out.printf("  Transcript Multiplier? ");
        double multi = answer.nextDouble();
        double GPA = overGPA*100*multi/maxGPA;
        System.out.println("  GPA score = " + round1(GPA));
        System.out.println();
        return round1(GPA);
    }
    //比較哪一份的GPA比較好
    public static void report(double firScore, double firGPA, double secScore, double secGPA){
        System.out.println("First applicant overall score  = " + (firScore+firGPA));
        System.out.println("First applicant overall score  = " + (secScore+secGPA));
        if(firScore+firGPA > secScore+secGPA)
            System.out.println("The first applicant seems to be better");
        else if (firScore+firGPA < secScore+secGPA)
            System.out.println("The second applicant seems to be better");
        else
            System.out.println("The two applicants seem to be equal");
    }
    public static double round1(double n) {
        return Math.round(n * 10.0) / 10.0;
    }
}