import java.util.*;
import java.math.*;
import java.io.*;
public class CCCCircleOfLife {
	/*static class Reader {
			final private int BUFFER_SIZE = 1 << 16;
			private DataInputStream din;
			private byte[] buffer;
			private int bufferPointer, bytesRead;
			public Reader() {
				din = new DataInputStream(System.in);
				buffer = new byte[BUFFER_SIZE];
				bufferPointer = bytesRead = 0;
			}
			public Reader(String file_name) throws IOException {
				din = new DataInputStream(new FileInputStream(file_name));
				buffer = new byte[BUFFER_SIZE];
				bufferPointer = bytesRead = 0;
			}
			public String readLine() throws IOException {
				byte[] buf = new byte[64]; // line length
				int cnt = 0, c;
				while ((c = read()) != -1) {
					if (c == '\n')
						break;
					buf[cnt++] = (byte) c;
				}
				return new String(buf, 0, cnt);
			}
			public int nextInt() throws IOException {
				int ret = 0;
				byte c = read();
				while (c <= ' ')
					c = read();
				boolean neg = (c == '-');
				if (neg)
					c = read();
				do {
					ret = ret * 10 + c - '0';
				} while ((c = read()) >= '0' && c <= '9');
				if (neg)
					return -ret;
				return ret;
			}
			public long nextLong() throws IOException {
				long ret = 0;
				byte c = read();
				while (c <= ' ')
					c = read();
				boolean neg = (c == '-');
				if (neg)
					c = read();
				do {
					ret = ret * 10 + c - '0';
				} while ((c = read()) >= '0' && c <= '9');
				if (neg)
					return -ret;
				return ret;
			}
			public double nextDouble() throws IOException {
				double ret = 0, div = 1;
				byte c = read();
				while (c <= ' ')
					c = read();
				boolean neg = (c == '-');
				if (neg)
					c = read();
				do {
					ret = ret * 10 + c - '0';
				} while ((c = read()) >= '0' && c <= '9');
				if (c == '.') {
					while ((c = read()) >= '0' && c <= '9') {
						ret += (c - '0') / (div *= 10);
					}
				}
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
		}*/
	public static void main(String args[]) throws Exception {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader s = new BufferedReader(new FileReader("*.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("*.out")));
		StringTokenizer st = new StringTokenizer(s.readLine());
		int n = Integer.parseInt(st.nextToken());
		long t = Long.parseLong(st.nextToken());
		int[] a = new int[n];
		String y = s.readLine();
		for(int i = 0; i < y.length(); i++){
			a[i] = Integer.parseInt(y.substring(i, i+1));
		}
		for(int i = 60; i <= 0; i--){
			int[] b = new int[n];
			for(int j = 0; j < n; j++){
				if(j == 0)b[j] = a[j]^a[n-1] ^ a[j]^a[1];
				else if(j == n-1)b[j] = a[j]^a[j-1] ^ a[j]^a[0];
				else b[j] = a[j]^a[j-1] ^ a[j]^a[j+1];
			}
			a = b;
		}
		for(int i = 0; i < n; i++){
			System.out.print(a[i]);
		}
	}
}
