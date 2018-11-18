import java.util.*;
import java.util.Random;
public class User{
	private String uName;
	private String phoneNo;
	private int age;
	private String jdate; 
	private String from;
	private String to;
	private int Id;
	private int pNo;
	public int avbl = 1;
	public void setUser(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Name");
		uName = sc.nextLine();
		System.out.println("Enter Your Phone Number");
		phoneNo = sc.nextLine();
		System.out.println("Enter Your Age");
		age = sc.nextInt();
		System.out.println("Enter Junction Name, from");
		from = sc.nextLine();
		from = sc.nextLine();
		System.out.println("Enter Junction Name, To");
		to = sc.nextLine();
		System.out.println("Enter Journey Date");
		jdate = sc.nextLine();
		Random rand = new Random();
		Id = rand.nextInt(50) + 10;
		pNo = rand.nextInt(20) + 10;
		avbl = 1;
	}
	public int getAge()
	{
		return age;
	}
	public String getUserName()
	{
		return uName;
	}
	public String getPhoneNo()
	{
		return phoneNo;
	}
	public int getId()
	{
		return Id;
	}
	public String getDate()
	{
		return jdate;
	}public String getFrom()
	{
		return from;
	}public String getTo()
	{
		return to;
	}
	public int getPNo()
	{
		return pNo;
	}
	public void setAvailable(){
		avbl = 0;
	}
	public int getAvailable(){
		return avbl;
	}
}
