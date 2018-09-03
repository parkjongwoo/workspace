import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestSupervision {
	
	Random random = new Random();
	
	public TestSupervision() {
		int room = getRandom(1,1000000);
		List<Integer> candidates = new ArrayList<Integer>();
		int esuper = getRandom(1,1000000);
		int msuper = getRandom(1,1000000);
		int tot=0;
		StringBuffer sb = new StringBuffer();
		sb.append(room).append('\n');
		int msuperT = 0;
		for(int i=0;i<room;i++) {
			candidates.add(getRandom(1,1000000));
			sb.append(Integer.toString(candidates.get(i))).append(' ');
			System.out.println(candidates.get(i));
			msuperT = candidates.get(i)-esuper;
			tot++;
			if(msuperT>0) {
				tot += (msuperT/msuper	+ (msuperT%msuper==0?1:0));			
			}
		}
		
		sb.append('\n').append(esuper).append(' ').append(msuper).append('\n');
		sb.append(tot);
		System.out.println(sb);
		
	}
	
	private int getRandom(int min, int max) {
		return random.nextInt(max)+1;
	}
	public static void main(String[] args) {
		new TestSupervision();
	}

}
