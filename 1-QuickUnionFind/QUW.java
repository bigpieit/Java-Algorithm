import java.util.Scanner;
import java.io.*;

public class QUW
{
	private int[] id;
	private int component;
	private int[] size;

	public QUW(int N)
	{
		component = N;
		id = new int[N];
		size = new int[N];
		for (int i = 0; i < N; i++)
		{
			id[i] = i;
			size[i] = 1;
		} 
	}

	// method 
	public int find(int p)
	{	int count = 0;
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
		if (size[proot] <= size[qroot])
		{
			id[proot] = qroot;
			size[qroot] += size[proot];
		}
		else
		{
			id[qroot] = proot;
			size[proot] += size[qroot];
		}
		component--; 
	}

	// main
	public static void main(String[] argvs)
	{
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int N = scanner.nextInt();
		int pair = scanner.nextInt();
		QUW quw =  new QUW(N);

		while (count < pair) 
		{
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			if (quw.connected(p,q)) continue;
			quw.union(p,q);
			count++;
		}

		System.out.println(quw.component + " component(s).");

		while (scanner.hasNextInt())
		{
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			System.out.println("Are "+p+" "+q+" connected ? "+quw.connected(p,q)+'.');
		}

		for (int i = 0 ; i < N; i++){
			System.out.print(" " + quw.find(i));
		}
		System.out.print(" "+ quw.size[0] +" ");
		System.out.print(" "+ quw.size[1] +" ");
		System.out.print(" "+ quw.size[7] +" ");		
	}
}