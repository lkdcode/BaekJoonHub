import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String firstWorker = bf.readLine();
        String secondWorker = bf.readLine();
        String thirdWorker = bf.readLine();

        String firstTime = workTime(firstWorker);
        String secondTime = workTime(secondWorker);
        String thirdTime = workTime(thirdWorker);

        System.out.println(firstTime);
        System.out.println(secondTime);
        System.out.println(thirdTime);


    }

    private static String workTime(String time) {

        String[] times = time.split(" ");

        int startHours = Integer.parseInt(times[0]);
        int startMinute = Integer.parseInt(times[1]);
        int startSecond = Integer.parseInt(times[2]);

        int endHours = Integer.parseInt(times[3]);
        int endMinute = Integer.parseInt(times[4]);
        int endSecond = Integer.parseInt(times[5]);

        int hours = endHours - startHours;
        int minute = endMinute - startMinute;
        int second = endSecond - startSecond;

        while (true) {
            if (hours >= 0 && minute >= 0 && second >= 0) {
                break;
            }

            if (second < 0) {
                minute--;
                second += 60;
            }

            if (minute < 0) {
                hours--;
                minute += 60;
            }
        }


        return hours + " " + minute + " " + second;
    }
}