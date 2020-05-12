import java.util.*;
class BFS
{
	public final int MAX = 100;
	public final int initial = 1;
	public final int waiting = 2;
	public final int visited = 3;
	Scanner sc = new Scanner(System.in);
	int n; 		
	int[][] adj = new int[MAX][MAX];		
	int[] state = new int[MAX]; 		
	int[] queue = new int[MAX];
	int front = -1;
	int rear = -1;
	void createGraph()
	{
		int i, maxEdges, origin, destin;
		System.out.println("Enter the number of vertices: ");
		n = sc.nextInt();
		maxEdges = n * (n-1);		
		for(i = 1; i <= maxEdges; i++)
		{
			System.out.println("Enter edge "+i+" (-1 -1) to quit");
			origin = sc.nextInt();
			destin = sc.nextInt();
			if(origin == -1 && destin == -1)
				break;
			if(origin >= n || destin >= n || origin < 0 || destin < 0)
			{
				System.out.println("Invalid edge!!");
				i--;
			}
			else
				adj[origin][destin] = 1;
		}
	}
	void BFSTraversal()
	{
		int v;
		for(v = 0; v < n; v++)
		{
			state[v] = initial;			
		}
		System.out.print("Enter starting vertex for Breadth First Search: ");
		System.out.println();
		v = sc.nextInt();
		BFS(v);
	}
	void BFS(int v)
	{
		int i;
		insertQueue(v);
		state[v] = waiting;
		while(!isEmptyQueue())
		{
			v = deleteQueue();
			System.out.println(v);
			state[v] = visited;
			for(i = 0; i < n; i++)
			{
				if(adj[v][i] == 1 && state[i] == initial)
				{
					insertQueue(i);
					state[i] = waiting;
				}
			}
		}
		System.out.println();
	}
	void insertQueue(int vertex)
	{
		if(rear == MAX-1)
			System.out.println("Queue Overflow!!");
		else
		{
			if(front == -1)			
				front = 0;
			rear = rear+1;
			queue[rear] = vertex;
		}
	}
	int deleteQueue()
	{
		int item;
		if(front == -1 || front > rear)
		{
			System.out.println("Queue Underflow!!");
			return 0;
		}
		item = queue[front];
		front = front+1;
		return item;
	}
	boolean isEmptyQueue()
	{
		if(front == -1 || front > rear)
			return true;
		else
			return false;
	}
	public static void main(String[] args)
	{
		BFS traverse = new BFS();
		traverse.createGraph();
		traverse.BFSTraversal();
	}
}