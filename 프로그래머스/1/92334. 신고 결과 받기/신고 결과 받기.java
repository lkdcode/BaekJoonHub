import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
          Map<String, Set<String>> userReportList = new HashMap<>();
        Map<String, Integer> reportPoint = new HashMap<>();

        Set<String> blockedUserList = new HashSet<>();

        for (String user : id_list) {
            userReportList.put(user, new HashSet<>());
        }

        for (String information : report) {
            String[] info = information.split(" ");
            String user = info[0];
            String target = info[1];

            Set<String> reportList = userReportList.get(user);
            if (!reportList.contains(target)) {
                reportList.add(target);
                reportPoint.put(target, (reportPoint.getOrDefault(target, 0) + 1));
            }
        }

        for (String user : reportPoint.keySet()) {
            if (reportPoint.get(user) >= k) {
                blockedUserList.add(user);
            }
        }
        Map<String, Integer> resultList = new HashMap<>();

        for (String user : userReportList.keySet()) {
            Set<String> reportTargetList = userReportList.get(user);

            for (String target : reportTargetList) {
                if (blockedUserList.contains(target)) {
                    resultList.put(user, resultList.getOrDefault(user, 0) + 1);
                }
            }
        }
        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = resultList.getOrDefault(id_list[i], 0);
        }
       
        return answer;
    }
}