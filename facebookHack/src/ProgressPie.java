import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by chiko on 1/7/2017.
 */
public class ProgressPie {

    private double percentageToAngle(int P){
        return (double)P*3.6;
    }

    public boolean isWhite(int P, int x, int y){
        if((x-50)*(x-50) + (y-50)*(y-50) > 2500) return true;

        double sliceAngle = percentageToAngle(P);
        double angle1 = Math.toDegrees(Math.atan2(50, 0));
        double angle2 = Math.toDegrees(Math.atan2(y - 50, x - 50));

        angle1 = (angle1 > 0) ? angle1+360:angle1;
        angle2 = (angle2 > 0) ? angle2+360:angle1;

        double diffAngle = angle2 - angle1;
        diffAngle = (diffAngle > 0) ? diffAngle+360:diffAngle;

        if(diffAngle > sliceAngle){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        ProgressPie progressPie = new ProgressPie();

        int totalTestCases = in.nextInt();
        for(int i=1; i<totalTestCases+1;i++) {
            int P = in.nextInt(), x = in.nextInt(), y = in.nextInt();
            boolean isWhite = progressPie.isWhite(P,x,y);
            String color;
            if(isWhite){
                color = "white";
            }else{
                color = "black";
            }
            out.print("Case #"+i+": "+color+"");
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








