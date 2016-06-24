import java.util.Scanner;
import java.io.*;

public class QU
{
	private int[] id;
	private int component;
	public QU(int N)
	{
		component = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
		{
			id[i] = i;
		} 
	}

	// method 
	public int find(int p)
	{
		while(p != id[p]) p = id[p];
		return p;
	}

	public boolean connected(int p, int q)
	{
		return find(p) == find(q); 
	}

	public void union(int p, int q)
	{
		int proot = find(p);
		int qroot = find(q);
		id[proot] = qroot;
		component--; 
	}

	// main
	public static void main(String[] argvs)
	{
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int N = scanner.nextInt();
		int pair = scanner.nextInt();
		QU qu =  new QU(N);

		while (count < pair) 
		{
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			if (qu.connected(p,q)) continue;
			qu.union(p,q);
			count++;
		}

		System.out.println(qu.component + " component(s).");

		while (scanner.hasNextInt())
		{
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			System.out.println("Are "+p+" "+q+" connected ? "+qu.connected(p,q)+'.');
		}
	}
}