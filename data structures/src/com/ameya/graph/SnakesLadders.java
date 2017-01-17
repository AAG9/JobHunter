package com.ameya.graph;

import java.util.*;

/**
 * Created by chiko on 1/16/2017.
 */
public class SnakesLadders {

    static Map<Integer, Integer> ladders;
    static Map<Integer, Integer> snakes;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        while(tests-->0){
            int l = in.nextInt();
            ladders = new HashMap<Integer, Integer>();
            for (int i = 0; i < l; i++) {
                ladders.put(in.nextInt(), in.nextInt());
            }
            int s = in.nextInt();
            snakes = new HashMap<Integer, Integer>();
            for (int i = 0; i < s; i++) {
                snakes.put(in.nextInt(), in.nextInt());
            }
            System.out.println(getMinCount(snakes,ladders));
            snakes.clear();
            ladders.clear();
        }
    }


    public static int getMinCount(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[101];
        q.add(1);
        q.add(-1);
        int count = 1;
        while(!q.isEmpty()){
            int temp = q.poll();
            if(temp != -1){
                for(int i=1; i<=6 && i+temp <= 100; i++){
                    int temp2 = temp + i;
                    if(snakes.containsKey(temp2)){
                        temp2 = snakes.get(temp2);
                    }
                    if(ladders.containsKey(temp2)){
                        temp2 = ladders.get(temp2);
                    }
                    if(temp2 == 100)
                        return count;
                    if(!visited[temp2]){
                        visited[temp2] = true;
                        q.add(temp2);
                    }
                }
            }else{
                count++;
                if(!q.isEmpty())q.add(-1);
            }
        }
        return -1;
    }
}