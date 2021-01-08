package imp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class GridlandMetro {

	
	// Complete the gridlandMetro function below.
    static int gridlandMetro(int n, int m, int k, int[][] tracks) {
        int lampposts = 0;
        int tracksTotalLength = 0;
        
		if (k > 0) {
			MetroTrack[] tracksList = new MetroTrack[tracks.length];

			for (int i = 0; i < tracks.length; i++) {
				int startCol = tracks[i][1] <= tracks[i][2] ? tracks[i][1] : tracks[i][2];
				int endCol = tracks[i][1] <= tracks[i][2] ? tracks[i][2] : tracks[i][1];

				MetroTrack metroTrack = new MetroTrack(tracks[i][0], startCol, endCol);

				tracksList[i] = metroTrack;
			}

			Arrays.sort(tracksList, new Comparator<MetroTrack>() {
				@Override
				public int compare(MetroTrack t1, MetroTrack t2) {
					// TODO Auto-generated method stub
					if (t1.row != t2.row) {
						return t1.row - t2.row;
					} else {
						return t1.startCol - t2.startCol;
					}
				}
			});

			Stack<MetroTrack> stack = new Stack<MetroTrack>();

			stack.push(tracksList[0]);

			for (int i = 1; i < tracksList.length; i++) {
				MetroTrack top = stack.peek();
				MetroTrack currentTrack = tracksList[i];

				if (currentTrack.row != top.row
						|| (currentTrack.row == top.row && top.endCol < currentTrack.startCol)) {
					stack.push(currentTrack);
				} else if (top.endCol < currentTrack.endCol) {
					top.endCol = currentTrack.endCol;
					stack.pop();
					stack.push(top);
				}
			}
			// Print contents of stack
			while (!stack.isEmpty()) {
				MetroTrack t = stack.pop();
				tracksTotalLength += t.endCol - t.startCol + 1;
			}
		}
        
        return lampposts = n*m - tracksTotalLength;
    }
    
    static int gridlandMetro2(int n, int m, int k, int[][] tracks) {
    	int lampposts = 0;
    	
    	int[][] gridLandMap = new int[n][m];
    	
    	for(int i = 0; i < tracks.length; i++) {
    		int r = tracks[i][0] - 1;
    		int col1 = tracks[i][1];
    		int col2 = tracks[i][2];
    		
    		for(int j = Math.min(col1, col2) - 1; j < Math.max(col1, col2); j++) {
    			gridLandMap[r][j] = 1;
    		}
    	}
    	
    	for(int i = 0; i < gridLandMap.length; i++) {
    		for(int j = 0; j < gridLandMap[i].length; j++) {
    			if(gridLandMap[i][j] == 0)lampposts++;
    		}
    	}
    	
    	return lampposts;
    }
    
    public static void main(String args[]) { 
        int[][] tracks = {{2, 2, 3}, {3, 1, 4}, {4, 4, 4}, {4,1,4}};
        
        int sol = gridlandMetro2(4 , 4, 3, tracks);
        
        System.out.println("Solution : " + sol);
    } 
}

class MetroTrack 
{ 
    int row, startCol, endCol; 
    MetroTrack(int row, int startCol, int endCol) 
    {
    	this.row = row;
    	this.startCol = startCol;
    	this.endCol	= endCol; 
    } 
}
