import java.util.Scanner;
import java.io.*;

public class QF 
{
	private int[] id;
	private int component;
	public QF(int n)
	{
		component = n;
		id = new int[n];

		for (int i = 0; i < n; i++)
		{
			id[i] = i; 
		}
	}

	// method
	public int find(int p)
	{
		return id[p];
	}

	public boolean connected(int p, int q)
	{
		return find(p) == find(q);
	}

	public void union(int p, int q)
	{
		int pid = id[p];
		int qid = id[q];
		int len = id.length;
		for (int i = 0; i < len; i++)
		{
			if (id[i] == pid) id[i]=qid;
		}
		component--;
	}

	// main
	public static void main(String[] args) throws FileNotFoundException
	{
		//String path = "./qf.txt";
		//File f = new File(path);		
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int N = scanner.nextInt();
		int pair = scanner.nextInt();
		QF qf =  new QF(N);

		while (count < pair) 
		{
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			if (qf.connected(p,q)) continue;
			qf.union(p,q);
			count++;
		}

		System.out.println(qf.component+" scomponents.");

		while (scanner.hasNextInt())
		{
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			System.out.println("Are "+p+" "+q+" connected ? "+qf.connected(p,q)+'.');
		}

	}
}