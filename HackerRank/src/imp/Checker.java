package imp;

import java.util.Comparator;

public class Checker implements Comparator<Player>{

	@Override
	public int compare(Player a, Player b) {
		// TODO Auto-generated method stub
		if(a.score > b.score){
            return -1;
        } else if(a.score < b.score){
            return 1;
        } else { //Players have the same score, sort those players alphabetically ascending by name
            if(a.name.compareTo(b.name) < 0){ 
                return -1;
            } else {
                return 1;
            }
        }
	}
}
