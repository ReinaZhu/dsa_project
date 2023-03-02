package pro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Search {
	
	static ArrayList<ArrayList<Map>> searchfiles=new ArrayList<ArrayList<Map>>();
	
	public static void SearchAuthor(String name) throws Exception {
		searchfiles = ReadIn.createAll("potery");
		ArrayList<String> titlelist = new ArrayList<String>();
		for(int i=0;i<searchfiles.size();i++) {
	    	ArrayList<Map> poet=searchfiles.get(i);
			for(int j=0;j<poet.size();j++) {
	    		if(name.equals((String)poet.get(j).get(0))) {
	    			titlelist.add((String) poet.get(j).get(1));
	    		}
	    	}
	    }
		for(int i=0;i<titlelist.size();i++) {
			System.out.println(titlelist.get(i));
		}
	}

	public static void SearchKeyAuthor(String name) throws Exception {
		searchfiles = ReadIn.createAllAuthor("author");
		ArrayList<String> titlelist = new ArrayList<String>();
		for(int i=0;i<searchfiles.size();i++) {
	    	ArrayList<Map> poet=searchfiles.get(i);
			for(int j=0;j<poet.size();j++) {
	    		if(KMP.KMPSearchTimes((String)poet.get(j).get(0),name)>0) {
	    			titlelist.add((String) poet.get(j).get(0));
	    		}
	    	}
	    }
	/*	for(int i=0;i<titlelist.size();i++) {
			System.out.println(titlelist.get(i));
		}*/
		ToCompare pairs[]=new ToCompare[titlelist.size()];
		for(int i=0;i<titlelist.size();i++) {
			pairs[i]= new ToCompare(KMP.KMPSearchTimes(titlelist.get(i),name),KMP.KMPFindLocations(titlelist.get(i),name),titlelist.get(i));
		}
		Arrays.sort(pairs,new ToComparator());
		for(int i=0;i<pairs.length;i++) {
			System.out.println(pairs[i].content);
		}
	}
	
	public static void SearchKeyPoetry(String name) throws Exception{
		searchfiles = ReadIn.createAll("poetry");
		ArrayList<String> titlelist = new ArrayList<String>();
		for(int i=0;i<searchfiles.size();i++) {
	    	ArrayList<Map> poet=searchfiles.get(i);
			for(int j=0;j<poet.size();j++) {
	    		if(KMP.KMPSearchTimes((String)poet.get(j).get(2),name)>0) {
	    			titlelist.add((String) poet.get(j).get(2));
	    		}
	    	}
	    }
		ToCompare pairs[]=new ToCompare[titlelist.size()];
		for(int i=0;i<titlelist.size();i++) {
			pairs[i]= new ToCompare(KMP.KMPSearchTimes(titlelist.get(i),name),KMP.KMPFindLocations(titlelist.get(i),name),titlelist.get(i));
		}
		Arrays.sort(pairs,new ToComparator());
		for(int i=0;i<pairs.length;i++) {
			System.out.println(pairs[i].content);
			System.out.println();
		}
	}
	
	public static void SearchKeyTitle(String name) throws Exception{
		searchfiles = ReadIn.createAll("poetry");
		ArrayList<String> titlelist = new ArrayList<String>();
		for(int i=0;i<searchfiles.size();i++) {
	    	ArrayList<Map> poet=searchfiles.get(i);
			for(int j=0;j<poet.size();j++) {
	    		if(KMP.KMPSearchTimes((String)poet.get(j).get(1),name)>0) {
	    			titlelist.add((String) poet.get(j).get(1));
	    		}
	    	}
	    }
		ToCompare pairs[]=new ToCompare[titlelist.size()];
		for(int i=0;i<titlelist.size();i++) {
			pairs[i]= new ToCompare(KMP.KMPSearchTimes(titlelist.get(i),name),KMP.KMPFindLocations(titlelist.get(i),name),titlelist.get(i));
		}
		Arrays.sort(pairs,new ToComparator());
		for(int i=0;i<pairs.length;i++) {
			System.out.println(pairs[i].content);
			System.out.println();
		}
	}
	
	
	public static ArrayList<Map> and_or(String strinput) {
		//map0表示关系，与为&，或为|,1是搜索的词,0为第一个词
		ArrayList<Map> searchkey=new ArrayList<Map>();
		char[] input=strinput.toCharArray();
		int countstr=0;
		int countchar=0;
		for(int i=0;i<input.length;i++) {
			if(input[i]=='&'||input[i]=='|') {
				 Map m1 = new HashMap(); 
				 if(countstr==0) {
					 m1.put(0,0);
				 }
				 else {
				 m1.put(0,input[countchar-1]);}
				 String key="";
				for(int j=countchar;j<i;j++) {				
					key+=input[j];
				}
				m1.put(1, key);
				searchkey.add(m1);
					countstr++;
					countchar=i+1;
			}
		}
		Map m1 = new HashMap(); 
		m1.put(0,input[countchar-1]);
		String key="";
		for(int j=countchar;j<input.length;j++) {				
			key+=input[j];
		}
		m1.put(1, key);
		searchkey.add(m1);
		return searchkey;
	}
	
	
}





