import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lab1.fileList;

public class tag {
	
	public static void main(String[] args) throws Exception {
		String a="昼出";
		String b="耘田";	
		char []aa=a.toCharArray();
		char[] bb=b.toCharArray();
		ArrayList<Map> bie=search_words(aa,bb);//改每个tag的方法可打印出来
		for(int i=0;i<bie.size();i++) {
    		System.out.printf("%d %s ",i,bie.get(i).get(0));
    		System.out.println(bie.get(i).get(1));
    		System.out.println(bie.get(i).get(2));	
    	}
	}
	
	
	static ArrayList<ArrayList<Map>> allfiles=new ArrayList<ArrayList<Map>>();
	
	
	public static ArrayList<Map> bye () throws Exception {//送别诗
		ArrayList<Map> poet= search_words('别','离');
	return poet;
	}
	public static ArrayList<Map> china () throws Exception {//爱国诗
		ArrayList<Map> poet= search_words('国','志');
	return poet;
	}
	public static ArrayList<Map> home () throws Exception {//思乡诗
		ArrayList<Map> poet= search_words('乡','归');
	return poet;
	}
	public static ArrayList<Map> side () throws Exception {//边塞诗
		ArrayList<Map> poet= search_words('塞','漠');
	return poet;
	}
	public static ArrayList<Map> field () throws Exception {//田园诗
		ArrayList<Map> poet= search_words('农','田');
	return poet;
	}
	public static ArrayList<Map> war () throws Exception {//战争诗
		ArrayList<Map> poet= search_words('战','争');
	return poet;
	}
	public static ArrayList<Map> lv () throws Exception {//律诗
		ArrayList<Map> search_poet= new ArrayList<Map>();
		allfiles = createAll("E:\\dsaa\\chinese-poetry-zhCN-master\\chinese-poetry-zhCN-master\\poetry");
		for(int i=0;i<allfiles.size();i++) {
	    	ArrayList<Map> poet=allfiles.get(i);
	    	for(int j=0;j<poet.size();j++) {
	    		char[] body=(poet.get(j).get(2).toString()).toCharArray();
	    		int comma=0;
	    		for(int k=0;k<body.length;k++) {
	    			if(body[k]=='，') {
	    				comma++;
	    			}
	    		}
	    		if(comma==4) {
	    			search_poet.add(poet.get(j));
	    		}
	    	}}
	return search_poet;
	}
	public static ArrayList<Map> jue () throws Exception {//绝句
		ArrayList<Map> search_poet= new ArrayList<Map>();
		allfiles = createAll("E:\\dsaa\\chinese-poetry-zhCN-master\\chinese-poetry-zhCN-master\\poetry");
		for(int i=0;i<allfiles.size();i++) {
	    	ArrayList<Map> poet=allfiles.get(i);
	    	for(int j=0;j<poet.size();j++) {
	    		char[] body=(poet.get(j).get(2).toString()).toCharArray();
	    		int comma=0;
	    		for(int k=0;k<body.length;k++) {
	    			if(body[k]=='，') {
	    				comma++;
	    			}
	    		}
	    		if(comma==2) {
	    			search_poet.add(poet.get(j));
	    		}
	    	}}
	return search_poet;
	}
	
   
//单独搜索两个字符
 public static ArrayList<Map> search_words(char word,char word2) throws Exception {
    	ArrayList<Map> searched= new ArrayList<Map>();
    	allfiles = createAll("E:\\dsaa\\chinese-poetry-zhCN-master\\chinese-poetry-zhCN-master\\poetry");
    	for(int i=0;i<allfiles.size();i++) {
    	ArrayList<Map> poet=allfiles.get(i);
    	for(int j=0;j<poet.size();j++) {
    		char[] body=(poet.get(j).get(2).toString()).toCharArray();
    		for(int k=0;k<body.length;k++) {
    			if(body[k]==word) {
    				for(int m=0;m<body.length;m++) {
    					if(word2==body[m]) {
    						searched.add(poet.get(j));
    						break;
    					}}}}}}
    return searched;}
 
//搜索两个string、
//要用string.toCharArray改成char array 
public static ArrayList<Map> search_words (char[]word,char[] word2) throws Exception {
	ArrayList<Map> searched= new ArrayList<Map>();
	allfiles = createAll("E:\\dsaa\\chinese-poetry-zhCN-master\\chinese-poetry-zhCN-master\\poetry");
	for(int i=0;i<allfiles.size();i++) {
	ArrayList<Map> poet=allfiles.get(i);
	for(int j=0;j<poet.size();j++) {
		char[] body=(poet.get(j).get(2).toString()).toCharArray();
		for(int k=0;k<body.length;k++) {
			for(int m=0;m<word.length;m++) {
		if(word[m]==body[k]) {
			if(k<body.length-1) {k++;}
			else {break;}
		    if(m==word.length-1) {
		    	for(int kk=0;kk<body.length;kk++) {
					for(int mm=0;mm<word2.length;mm++)
				if(word2[mm]==body[kk]) {
					if(kk<body.length-1) {kk++;}
					else {break;}
				    if(mm==word2.length-1) {
			searched.add(poet.get(j));
		}}
				else{kk=kk-mm;
			     break;}
				}
		    	}
		}
		else{k=k-m;
		     break;
			}
		}
	}
}}
return searched;
}
public static ArrayList<ArrayList<Map>> createAll(String Folder) throws Exception{ 
    File file = new File(Folder);//中间填入要打开的文件名
    fileList fl  = new fileList();//直接写一个类里了，方便 
    fl.Dir(file); 
    ArrayList<ArrayList<Map>> files=new ArrayList<ArrayList<Map>>();
    //底下这个过程比较久
    for(String s:fl.fStrArr) {
    	String filename=s;
		ArrayList<Map> poet=create(filename);
		files.add(poet);
    }
    return files;
    /*for(int i=0;i<files.size();i++) {
    	ArrayList<Map> poet=files.get(i);
		for(int j=0;j<poet.size();j++) {
    		System.out.printf("%d %s ",j,poet.get(j).get(0));
    		System.out.println(poet.get(j).get(1));
    		System.out.println(poet.get(j).get(2));
    	}
    }	*/
}

private static ArrayList<Map> create(String filename) {
	ArrayList<Map> poet= new ArrayList<Map>();
    try {
        File jsonFile = new File(filename);
        FileReader fileReader = new FileReader(jsonFile);
        Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
        int ch = 0;
        StringBuffer sb = new StringBuffer();
        int last_ch=0;
        ch = reader.read();
        last_ch=ch;
        //两个循坏，大循坏是把一个文件读完结束，小循环是读完一首诗结束
        while((ch = reader.read())!=-1) {
        Map m1 = new HashMap(); 
        Boolean a_poet_end=false;
        while ((ch = reader.read())!=-1&&a_poet_end==false) {
        	//存作者，map的key为0
        	if((char)ch=='r'&&(char)last_ch=='o') {
        		ch = reader.read();ch = reader.read();ch = reader.read();ch = reader.read();
        		 while((char)(ch = reader.read())!='"') {
        			 sb.append((char) ch);
        		 }
        		 String author=sb.toString();
        		 m1.put(0, author);
        		 sb.delete(0,sb.length());
        		 last_ch=ch;
        		 ch = reader.read();
        	}
        	//存诗，map的key为2
        	if((char)ch=='s'&&(char)last_ch=='h') {
        		Boolean end=false;
        		while(end==false&&(char)(ch = reader.read())!=']') {
        		while(end==false&&(char)(ch = reader.read())!='"') {if((char)ch==']') {end=true;}}
        		while(end==false&&(char)(ch = reader.read())!='"') {
        			if((char)ch==']') {end=true;}
        			sb.append((char) ch);
        		}
        		}	
        		String body=sb.toString();
        		m1.put(2, body);
        		sb.delete(0,sb.length());
        		 last_ch=ch;
        		 ch = reader.read();
        	}
        	//存标题，map的key为1
        	if((char)ch=='e'&&(char)last_ch=='l') {
        		ch = reader.read();ch = reader.read();ch = reader.read();ch = reader.read();
        		 while((char)(ch = reader.read())!='"') {
        			 sb.append((char) ch);
        		 }
        		 String title=sb.toString();
        		 m1.put(1, title);
        		 poet.add(m1);
        		 sb.delete(0,sb.length());
        		 last_ch=ch;
        		 ch = reader.read();
        		 a_poet_end=true;
        	}
        last_ch=ch;
        }
        }
        fileReader.close();
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    //poet是array list,每个元素是map
    return poet;
}
}

