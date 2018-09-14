import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Solution {
	public Solution() {
		System.out.println("FRANCE, french : "+solution("FRANCE", "french"));
		System.out.println("handshake, shake hands : "+solution("handshake", "shake hands"));
		System.out.println("aa1+aa2, AAAA12 : "+solution("aa1+aa2", "AAAA12"));
		System.out.println("E=M*C^2, e=m*c^2 : "+solution("E=M*C^2", "e=m*c^2"));
	}
	public int solution(String str1, String str2) {
		int answer = 0;
		Map<String, Integer> m1 = getStringMap(str1);
		Map<String, Integer> m2 = getStringMap(str2);
		Map<String, Integer> sm = null;
		Map<String, Integer> lm = null;
		Map<String, Integer> intersection = new HashMap<String,Integer>();
		Map<String, Integer> union = new HashMap<String,Integer>();
		if(m1.size()>m2.size()) {
			sm = m2;
			lm = m1;
		}else {
			sm = m1;
			lm = m2;			
		}
		
		for(Entry<String, Integer> e : sm.entrySet()) {
			if(lm.containsKey(e.getKey())) {
				intersection.put(e.getKey(), Math.min(e.getValue(),lm.get(e.getKey())));
				union.put(e.getKey(), Math.max(e.getValue(),lm.get(e.getKey())));				
				lm.remove(e.getKey());
			}else {
				union.put(e.getKey(), e.getValue());
			}
		}
		
		for(Entry<String, Integer> e : lm.entrySet()) {
			union.put(e.getKey(), e.getValue());
		}
		System.out.println("intersection.size():"+intersection.size());
		System.out.println("union.size():"+union.size());
		if(union.size()==0) {
			return 65536;
		}
		answer = (int)(((double)intersection.size() / union.size())*65536);
		
		return answer;
	}

	private Map<String, Integer> getStringMap(String s) {
		s = s.toLowerCase();
		String temp = null;
		int t = s.length();
		Map<String, Integer> map = new HashMap<String,Integer>();
		for (int i = 0; i < t - 1; i++) {
			temp = s.substring(i, i + 2);
			if (temp.charAt(0) >= 97 && temp.charAt(0) <= 122 && temp.charAt(1) >= 97 && temp.charAt(1) <= 122) {
				if (map.get(temp) == null) {
					map.put(temp, 1);
				} else {
					map.put(temp, map.get(temp) + 1);
				}
			}
		}
		return map;
	}

	public static void main(String[] args) {
		new Solution();
	}

}
