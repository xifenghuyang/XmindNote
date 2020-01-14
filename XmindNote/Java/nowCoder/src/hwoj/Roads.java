package hwoj;


import com.sun.scenario.effect.impl.state.LinearConvolveKernel;

import java.util.LinkedList;

/**
 * @author y
 */
public class Roads {

    public static int backTace(int[][] roads, int x0, int y0, int x1, int y1) {
        LinkedList<Integer,Integer> track = new LinkedList<>();
        int count = 1;
        backTaceHelp(roads,x0,y0,x1,y1,track,count);
        if(track.isEmpty()){
            return -1;
        }else {
            return track.size()-1;
        }
    }

    private static void backTaceHelp(int[][] roads, int x0, int y0, int x1, int y1,LinkedList track,int count){


        if(isNextStepOk(roads,x0+1,y0,x1,y1,count)){
            track.add(x0+1,y0);
            backTaceHelp(roads,x0+1,y0,x1,y1,track,count-roads[x0+1][y0]);
        }
    }

}
