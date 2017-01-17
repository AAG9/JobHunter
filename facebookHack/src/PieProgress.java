import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by chiko on 1/14/2017.
 */
public class PieProgress {

    public int getCost(List<List<Integer>> wrapList, int M, int N){
        int cost=0, avg=0;
        int totalCost = 0;
        int i=0, j=0;
        while (i<N && j<M){
            if(wrapList.get(i).get(j))
        }

        System.out.println(wrapList);
        return 0;
    }

    public static void main(String[] args) throws IOException {

        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        PieProgress pieProgress = new PieProgress();

        int totalTestCases = in.nextInt();
        for(int i=1; i<totalTestCases+1;i++) {
            int N = in.nextInt(), M = in.nextInt();
            List<List<Integer>> wrapList = new ArrayList<>();
            List<Integer> subList;
            for(int j=0;j<N;j++){
                subList = new ArrayList<>();
                for(int k=0; k<M;k++){
                    subList.add(in.nextInt());
                }
                Collections.sort(subList);
                wrapList.add(subList);
                Collections.sort(wrapList, new Comparator<List<Integer>>() {
                    @Override
                    public int compare(List<Integer> o1, List<Integer> o2) {
                        return o1.get(0) - o2.get(0);
                    }
                });
            }
            out.print("Case #"+i+": "+pieProgress.getCost(wrapList,M,N)+"");
            out.println();
        }

        out.flush();
        out.close();
        in.close();
    }

    private static class Reader {
        final private int BUFFER_SIZE = 1 << 16;

        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = c == '-';
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
                c = read();
            } while (c >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}
