import java.util.*;
import java.math.*;
import java.io.*;
public class CCCWaterPark {
	static class Reader {
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
		}
	private static class Node {
		int id;
		ArrayList<Node> adj = new ArrayList<>();
		public Node(int i){
			id = i;
		}
	}
	static int[] dist;
	public static void main(String args[]) throws Exception {
		//BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		Reader s= new Reader();
		int n = s.nextInt();
		Node[] a = new Node[n];
		dist = new int[n];
		Arrays.fill(dist, -1);
		for(int i = 0; i < n; i++){
			a[i] = new Node(i);
		}
		while(true){
			int x = s.nextInt();
			int y = s.nextInt();
			if(x == 0 && y == 0)break;
			a[x-1].adj.add(a[y-1]);
		}
		System.out.println(dfs(0, n-1, a));
	}
	public static int dfs(int start, int end, Node[] a){
		if(start == end){
			return 1;
		}
		int sum = 0;
		for(Node n : a[start].adj){
			if(dist[n.id] != -1){
				sum += dist[n.id];
			} else {
				int c = dfs(n.id, end, a);
				dist[n.id] = c;
				sum+= dist[n.id];
			}
		}
		return sum;
	}
}
