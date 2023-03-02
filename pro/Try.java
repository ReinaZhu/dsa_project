package pro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import cn.itcase.pojo.Poet;

public class Try {

	public static void main(String[] args) {
		filefold("zhu");
		filefold("zh");
		filefold("z");
		
		
		
		
	}
	public static void filefold(String username) {
    	try{
    		// TODO Auto-generated method stub
    		String u="User\\"+username+"\\"+"user.txt";
    		String p="User\\"+username+"\\"+"poet.txt";
    		File file = new File(u);
    		File file2 = new File(p);
    		File fileParent = file.getParentFile();
    		if (!fileParent.exists()) {
                                    		fileParent.mkdirs();
    		}
    		file.createNewFile();
    		file2.createNewFile();}
    		catch(IOException e){
        		e.printStackTrace();
        	}
    }
	
	
	
	
	
}
