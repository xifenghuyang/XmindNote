package com.yq.weekly;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author admin
 * lc1366 多条件排序--medium
 */
public class Lcweekly1th2 {

    public String rankTeams(String[] votes) {

        Map<Character,int[]> teamRankMap = new HashMap<>();

        for (int i = 0; i < votes.length; i++) {
            String vote = votes[i];
            for (int j = 0; j < vote.length(); j++) {
                Character thisChar = vote.charAt(j);
                int[] rankArr = teamRankMap.getOrDefault(thisChar,new int[26]);
                rankArr[j]++;
                teamRankMap.put(thisChar,rankArr);
            }
        }

        List<Map.Entry<Character,int[]>> teamRankList = new ArrayList<>(teamRankMap.entrySet());
        teamRankList.sort((team1,team2)->{
            int[] ranks1 = team1.getValue();
            int[] ranks2 = team2.getValue();
            for (int i = 0; i < 26; i++) {
                if(ranks2[i]!=ranks1[i]){
                    return ranks2[i]-ranks1[i];
                }
            }
            return team1.getKey() - team2.getKey();
        });
        return teamRankList.stream().map(entry->String.valueOf(entry.getKey())).collect(Collectors.joining());
    }

}
