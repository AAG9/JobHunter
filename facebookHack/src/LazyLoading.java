import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by chiko on 1/7/2017.
 */
public class LazyLoading {
    public int getMaxCount(int[] weightArr, int length){
        int start = 0;
        int end = length - 1;
        int count = 0;
        while (start <= end){
            int weight = weightArr[end];
            int n = (50 % weight == 0)? 50/weight:((50/weight)+1);
            if((end - start+1)*weightArr[end]>=50) count++;
            end--;
            start+=(n-1);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        LazyLoading lazyLoading = new LazyLoading();

        int[] weightArr;
        int totalTestCases = in.nextInt();
        for(int i=1; i<totalTestCases+1;i++) {
            int N = in.nextInt();
             weightArr = new int[N];
            for(int j=0;j<N;j++){
                weightArr[j] = in.nextInt();
            }
            Arrays.sort(weightArr);
            out.print("Case #"+i+": "+lazyLoading.getMaxCount(weightArr,N)+"");
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
