class Bus1
{
	int id;
	int totalStudents;
	static int count = 1;
	boolean flag ;
	static int countStudents=0;
	static double avgWT;
	 int checkOpt;
	Bus1(int id, int totalStudents) throws InterruptedException
	{
		this.id = id;
		this.totalStudents = totalStudents;
		flag = false;
		checkOpt = 0;
		avgWT=0;
	}
	public void runBus() throws InterruptedException
	{
		flag=false;
		int rnd = (int) (Math.random() * ((30-20)+1))+20;
		int rndTime = (int) (Math.random() * ((3000-0)+1))+0;
		avgWT += rndTime;
		if(rndTime>100 && count<totalStudents+1)
		{
			System.out.println("---------------------------------------------------------------------");
			System.out.println("\nBus is arriving wait a few seconds...");
			Thread.sleep(rndTime);
		}
		if(count<totalStudents+1)
		{
			for(int i = 1 ; i<=rnd ; i++)
			{
				if(count<totalStudents+1)
				{
					flag = true;
					if(i == 1)
					{
						System.out.println("\nBus " + id + " is Arrived at Bus Point\n");
						System.out.println("---------------------------------------------------------------------");
					}
					new Student1(count);
					count++;
					countStudents++;
					
				}
				else
				{
					flag = false;
				}
			}
			System.out.println("---------------------------------------------------------------------");
		}
		else
		{
			System.out.println("\nBus " + id + " is Arrived at Bus Point But left because of no students...");
			checkOpt++;
		}
	}
	
}

class Student1
{
	int id;
	Student1(int id) throws InterruptedException
	{
		this.id = id;
		System.out.println("Student " + id + " has ride the Bus...");
	}
}
class Controller1
{
	int totalBusses;
	static int counter = 0;
	static int countController = 0;
	static int studentsRemianing;
	static int studentsTotalAll=0;
	static double valueForGUI;
	static double avgWT;
	
	int totalStudents;
	Controller1(int totalBusses,int totalStudents) throws InterruptedException
	{
		this.totalBusses = totalBusses;
		this.totalStudents = totalStudents;
		countController++;
		studentsTotalAll += totalStudents;
		avgWT=0;
		for(int i = 1; i<=totalBusses ; i++)
		{
			Bus1 b = new Bus1(i,totalStudents);
			b.runBus();
			counter += b.checkOpt;
			if(i==totalBusses)
			{
				b.count = 1;
			}

			studentsRemianing = studentsTotalAll - b.countStudents;
			avgWT = b.avgWT/1000;

		}
		
		
	}
	public static void checkOptimization()
	{
		double res = (double)counter/(double)countController;
		valueForGUI = res;
		
		if(studentsRemianing>0)
		{
			System.out.println("Busses are not enough for students as "+ studentsRemianing +" are left out...");
			System.out.println("\n---------------------------------------------------------------------");
		}
		else
		{
			System.out.println("\n---------------------------------------------------------------------");
			System.out.println("\nThe average wastage of Busses is : " + res);
			System.out.println("\n---------------------------------------------------------------------");
			
			
		}
		
		
	}
	
}
public class RunProject
{
	public static void main(String [] args) throws InterruptedException
	{
		Controller1 c1 = new Controller1(5,20);
		//Controller c2 = new Controller(5,100);		
		Controller1.checkOptimization();
		System.out.println("The Average Waiting time of students for each Bus : "+c1.avgWT);
	}
}