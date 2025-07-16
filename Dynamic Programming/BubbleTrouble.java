import java.util.*;

public class BubbleTrouble {

    static class LogEntry {
        int employeeId;
        String action;
        String location;
        String time;

        LogEntry(int employeeId, String action, String location, String time) {
            this.employeeId = employeeId;
            this.action = action;
            this.location = location;
            this.time = time;
        }
    }

    static class EmployeeWorkTime {
        int employeeId;
        long totalWorkTime;

        EmployeeWorkTime(int employeeId) {
            this.employeeId = employeeId;
            this.totalWorkTime = 0;
        }

        void addWorkTime(long workTime) {
            this.totalWorkTime += workTime;
        }
    }

   public static long timeToMinutes(String time) {
        if (time == null || time.isEmpty()) {
            throw new IllegalArgumentException("Time string cannot be null or empty.");
        }
        String[] timeParts = time.split(":");
        int hour = Integer.parseInt(timeParts[0]); 
        int minute = Integer.parseInt(timeParts[1].substring(0, 2)); 
        
        String period = time.substring(time.length() - 2); 

        if (period.equals("AM") && hour == 12) {
            hour = 0; 
        } else if (period.equals("PM") && hour != 12) {
            hour += 12; 
        }

        return hour * 60 + minute; 
    }


    public static long calculateWorkTime(String entryTime, String exitTime) {
        return timeToMinutes(exitTime) - timeToMinutes(entryTime);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();  
        List<LogEntry> logs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] log = sc.nextLine().split(" ");
            int employeeId = Integer.parseInt(log[0]);
            String action = log[1];
            String location = log[2];
            String time = log[3];
            logs.add(new LogEntry(employeeId, action, location, time));
        }

        int suspectEmployeeId = sc.nextInt();

        Map<Integer, EmployeeWorkTime> workTimes = new HashMap<>();
        Map<Integer, String> lastEnteredLocation = new HashMap<>();
        Map<Integer, String> lastEnteredTime = new HashMap<>();

        for (LogEntry log : logs) {
            int employeeId = log.employeeId;
            String action = log.action;
            String location = log.location;
            String time = log.time;

            if (!workTimes.containsKey(employeeId)) {
                workTimes.put(employeeId, new EmployeeWorkTime(employeeId));
            }

            EmployeeWorkTime employee = workTimes.get(employeeId);

            if (action.equals("enters")) {
                lastEnteredLocation.put(employeeId, location);
                lastEnteredTime.put(employeeId, time);
            } else if (action.equals("exits")) {
                if (location.startsWith("room")) {
                    String entryTime = lastEnteredTime.get(employeeId);
                    long workTime = calculateWorkTime(entryTime, time);
                    employee.addWorkTime(workTime);
                }

                lastEnteredLocation.remove(employeeId);
                lastEnteredTime.remove(employeeId);
            }
        }

        long minWorkTime = Long.MAX_VALUE;
        boolean suspectIsLeast = true;

        for (EmployeeWorkTime employee : workTimes.values()) {
            if (employee.totalWorkTime < minWorkTime) {
                minWorkTime = employee.totalWorkTime;
                suspectIsLeast = (employee.employeeId == suspectEmployeeId);
            } else if (employee.totalWorkTime == minWorkTime) {
                suspectIsLeast = false;
            }
        }

        if (suspectIsLeast) {
            System.out.println("Yes");
        } else if (suspectIsLeast == false && workTimes.containsKey(suspectEmployeeId)) {
            System.out.println("No");
        } else {
            System.out.println("Cannot be determined");
        }
    }
}
