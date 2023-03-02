package pro;

import java.io.*; 
import java.util.*; 
  
public class fileList { 
  // 设置一个数组，来存放文件路径 
  public static ArrayList<String> fStrArr = new ArrayList<String>();
  // 这里是仅仅查询当前路径下的所有文件夹、文件并且存放其路径到文件数组,但不能搜索子文件夹里面的文件 
  public ArrayList<String> Dir(File file) throws Exception { 
    //判断是否空集，报错用的 
    if (file.exists()) { 
      // 直接取出利用listFiles()把当前路径下的所有文件夹、文件存放到一个文件数组 
      File files[] = file.listFiles(); 
      for (File f : files) { 
        // 如果传递过来的参数dirFile是以文件分隔符，也就是/或者\结尾，则如此构造 
    	//separator就是分隔符的意思，不用管他 
        if (file.getPath().endsWith(File.separator)) {
          fStrArr.add(f.getPath() + f.getName()); 
        } else { 
          // 否则，如果没有文件分隔符，则补上一个文件分隔符，再加上文件名，才是路径，其实无所谓的。。。 
          fStrArr.add(file.getPath() + File.separator 
              + f.getName()); 
        } 
      } 
    } 
    return fStrArr; 
  } 
} 
