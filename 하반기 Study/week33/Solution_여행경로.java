import java.util.*;
class Solution {
    static List<String> list;
    static boolean[] visited;
    static String[] ans ={};
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        list = new ArrayList<>();
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, (o1,o2) -> {
            if(o1[0].equals(o2[0])) {
               return o1[1].compareTo(o2[1]);
           } else {
               return o1[0].compareTo(o2[0]);
           }
        });
        
        list.add("ICN");
        dfs("ICN", 0, tickets);
        answer = ans;
        return answer;
    }
    
    public void dfs(String now, int depth, String[][] tickets){
        if(ans.length > 0) return;
        if(depth == visited.length){
            ans = new String[list.size()];
            for(int i = 0 ; i < list.size(); i++){
                ans[i] = list.get(i);
            }
            return;
        }
        
        for(int i = 0 ; i < tickets.length; i++){
            if(visited[i]) continue;
            if(tickets[i][0].equals(now)){
                visited[i] = true;
                list.add(tickets[i][1]);
                dfs(tickets[i][1], depth+1, tickets);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
        return;
    }
}