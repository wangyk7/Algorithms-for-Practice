public class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            set.add(t.charAt(i));
        }
        String res = "";
        // get the first string meeting the requirement
        // in order to get the initial window size j-i
        int i = 0, j = 0, n = s.length();
        while(j < n && map.size() < set.size()){
            char c = s.charAt(j);
            if(!set.contains(c)) {
                j++;
                continue;
            }
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
            j++;
        }
        if(map.size() < set.size()) return "";
        while(i < j){
            char c = s.charAt(i);
            if(!set.contains(c)){
                i++;
                continue;
            }
            if(map.get(c) > 1){
                map.put(c, map.get(c)-1);
                i++;
            }
            if(map.get(c) == 1){
                break;
            }
        }
        res = s.substring(i, j);
        i++;
        j++;
        // slide the window
        while(j < n){
            // update the map
            char a = s.charAt(i-1);
            char b = s.charAt(j);
            if(set.contains(a)){
                if(map.containsKey(a)){
                    if(map.get(a) > 1){
                        map.put(a, map.get(a)-1);
                    }else if(map.get(a) == 1){
                        map.remove(a);
                    }
                }
            }
            if(set.contains(b)){
                if(map.containsKey(b)){
                    map.put(b, map.get(b)+1);
                }else{
                    map.put(b, 1);
                }
            }
            // if map.size() < set.size(), slide to next
            // if not, updata the minimum string
            if(map.size() < set.size()){
                i++;
                j++;
                continue;
            }else{
                while(i < j){
                    char e = s.charAt(i);
                    if(!set.contains(e)){
                        i++;
                        continue;
                    }
                    if(map.get(e) > 1){
                        map.put(e, map.get(e)-1);
                        i++;
                    }
                    if(map.get(e) == 1){
                        break;
                    }
                }
                while(i < j){
                    char e = s.charAt(i);
                    if(!set.contains(e)){
                        j--;
                        continue;
                    }
                    if(map.get(e) > 1){
                        map.put(e, map.get(e)-1);
                        j--;
                    }
                    if(map.get(e) == 1){
                        break;
                    }
                }
                res = s.substring(i, j+1);
                i++;
                j++;
            }
        }
        return res;
    }
}
