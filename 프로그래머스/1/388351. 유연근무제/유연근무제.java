
// schedules: 출근 희망 시각을 담은 1차원 정수 배열
// timelogs: 직원들이 일주일 동안 출근한 시각을 담은 2차원 정수 배열
// startday: 이벤트를 시작한 요일을 의미하는 정수

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        EmployeeEntity[] employees = new EmployeeEntity[schedules.length];
        int answer = employees.length;

        for (int i = 0; i < schedules.length; i++) {
            employees[i] = new EmployeeEntity(schedules[i], timelogs[i]);
        }

        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < 7; j++) {
                int currentDay = ((startday - 1 + j) % 7) + 1;

                if (currentDay == 6 || currentDay == 7) {
                    continue;
                }

                if (employees[i].schedule < employees[i].timeLogs[j]) {
                    answer--;
                    break;
                }
            }
        }


        return answer;
    }
}

class EmployeeEntity {
    EmployeeEntity(int schedule, int[] timeLogs) {
        this.schedule = add10Min(schedule);
        this.timeLogs = timeLogs;
    }
    
    private int add10Min(int hhmm) {
        int h = hhmm / 100;
        int m = hhmm % 100;

        int total = h * 60 + m + 10;       

        if (total >= 2400) return 2359;

        int nh = total / 60;
        int nm = total % 60;
        return nh * 100 + nm;
    }

    int schedule;
    int[] timeLogs;
}