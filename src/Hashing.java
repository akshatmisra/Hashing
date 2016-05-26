import java.util.*;

public class Hashing {
	int [] arr;
	
	Hashing(int n)
	{
		arr= new int[n];
	}
	
	public boolean findFirstRepeated()
	{
		boolean [] b = new boolean[256];
		
		for(int i = 0; i<arr.length; i++)
		{
			if(b[arr[i]] == false)
				b[arr[i]] = true;
			else
				return true;
		}
		
		return false;
	}
	
	public int[] removeDuplicates()
	{
		//HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		Set s = new HashSet();
		
		for(int i = 0; i<arr.length;i++)
		{
			s.add(arr[i]);
		}
		int count = 0;
		Iterator itr = s.iterator();
		while(itr.hasNext())
		{
			arr[count++] = (int)itr.next();
		}
		
		return Arrays.copyOf(arr, count);
	}
	
	///Check if two sets have the same set of numbers
	public boolean CompareArraySet(int [] a, int []b)
	{
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		
		for(int i : a)
		{
			if(hmap.containsKey(i))
			{
				int count = hmap.get(i);
				hmap.put(i,++count);
			}
			else
				hmap.put(i, 1);
		}
		
		for(int i :b)
		{
			if(!hmap.containsKey(i))
				return false;
			else
			{
				int count = hmap.get(i);
				hmap.put(i,--count);
			}
		}
		
		for(Map.Entry me : hmap.entrySet())
		{
			if((int)me.getValue()!=0)
				return false;
		}
		
		return true;
	}
	
	
	public static void main(String args[])
	{
//		Scanner sc = new Scanner(System.in);
//		
//		int numbers = sc.nextInt();
		Hashing h = new Hashing(5);
//		//Initialize array
//		for(int i = 0; i<numbers; i++)
//		{
//			h.arr[i] = sc.nextInt();
//		}
//		System.out.println("Array has repeated elements?"+h.findFirstRepeated());
//		
//		h.arr = h.removeDuplicates();
//		
//		for(int i = 0; i<h.arr.length;i++)
//		{
//			System.out.print(h.arr[i]);
//			System.out.print(" ");
//		}
		int [] a = {2,2};//{2,5,6,8,10,2,2};
		int [] b = {2};//{2,5,5,8,10,5,6};
		System.out.println("Are the set same?"+h.CompareArraySet(a,b));
		//sc.close();
		
	}
}
