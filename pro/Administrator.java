package pro;

import java.util.ArrayList;
import java.util.Map;

public class Administrator {
		
	static ArrayList<User> AllUser= new ArrayList<User>();
	static int now=0;
	
	public static void AddUser(String username,int learn,int review,String waytolearn) {
		User newone=new User(username,learn,review,waytolearn);
		AllUser.add(newone);
	}
	public static void DeleteUser(String username) {
		for(int i=0;i<AllUser.size();i++) {
			if(AllUser.get(i).UserName.toString().equals(username)) {
				AllUser.remove(i);
			}
		}
	}
	public static void AddDate() {
      now++;
	}
	public static void ShowUsers() {
		if(AllUser.isEmpty()) {System.out.println("no user");}
		else{for(int i=0;i<AllUser.size();i++) {
			System.out.println(AllUser.get(i).UserName);
		}
		}
	}


}
