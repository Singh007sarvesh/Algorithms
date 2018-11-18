import java.util.*;
public class BookTicket{
	public static int count = 0;
	public final int maxTicket = 300;
	public static List<User> list = new ArrayList<>();
	public static void main(String[] args)
	{
		int n = 1;
		Scanner sc = new Scanner(System.in);
		BookTicket bookTicket = new BookTicket();
		while(n>0){
			System.out.println("============================================================================================================");
			System.out.println("1-> Book Ticket\t"+"2-> Cancel Ticket\t"+"3-> Display UnBook Ticket\t"+"4-> Disp Prepared Chart\t"+"5-> Exit");
			System.out.println("============================================================================================================");
			int select = 0;
			try{
				select = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				n  = 0;
			}
			switch(select)
			{
				case 1:
					bookTicket.setBookTicket();
					break;
				case 2:
					bookTicket.cancelTicket();
					break;
				case 3:
					bookTicket.dispUnBookTicket();
					break;
				case 4:
					bookTicket.preparedChart();
					break;
				case 5:
					System.exit(0);
					break;
				default :
					System.out.println("=======================");
					System.out.println("Plz Select Valid Option");
					System.out.println("=======================");
			}
		}
	} 
	public void setBookTicket(){
			User user = new User();
			if( count<=maxTicket){
				user.setUser();
				list.add(user);
			}
			else{
				System.out.println("========================");
				System.out.println("Ticket Are Not Available");
				System.out.println("========================");
			}
			count++;
		}
	public void cancelTicket(){
		System.out.println("==============");
		System.out.println("Enter Phone No");
		System.out.println("==============");
		Scanner sc = new Scanner(System.in);
		String phone = sc.next();
		int c=0;
		for(User i : list){
			if( i.getPhoneNo().equals(phone))
			{
				i.setAvailable();
				count--;
				c =1;
			}
		}
		if ( c == 0){
			System.out.println("=============================================");
			System.out.println("Enter Valid Phone No");
			System.out.println("=============================================");
		}
	}
	public void dispUnBookTicket(){
		System.out.println("=============================================");
		if(maxTicket>=count)
			System.out.println(maxTicket-count);
		else
			System.out.println("Ticket Is Not Available");
		System.out.println("=============================================");
	}
	public void preparedChart(){
		int c = count;
		System.out.println("=============================================");
		for(User i : list){
			if(i.getAvailable()==1){
				System.out.print(i.getUserName()+" "+"Seat No ");
				System.out.println(count-c+1);
			}
			c--;
		}
		System.out.println("=============================================");
	}
}
