
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree2 {
	Tree2(){}
	private TreeNode2 root2;
	public void root(TreeNode2 node){//根节点
		   this.root2 = node;
	}
	public boolean Add(TreeNode2 father, TreeNode2 child, Boolean left) {
		boolean success;
		if (left==true) {
			if(father.left==null) {
			father.left=child;
			success=true;}
			else {success=false;}
		}
		else {if(father.right==null) {
			father.right=child;
			success=true;}
			else {success=false;}
	}
		return success;
		}
	public boolean Add(TreeNode2 father, TreeNode2 child) {//重载方法add
		boolean success=true;
		if (father.left==null) {
			father.left=child;
		}
		else if(father.right==null){
			father.right=child;
		}
		else {success=false;}
		return success;
		}
	public String TraversalInOrder() {
		return TraversalInOrder(root2);
		}
	public String TraversalInOrder(TreeNode2 node) {
		String order="";
		if(node.left!=null) {
			order=order+TraversalInOrder(node.left);
		}
		order=order+node.val+" ";
		if(node.right!=null) {
			order =order+TraversalInOrder(node.right);
		}
		return order;
	}
	public String TraversalPreOrder() {
		return TraversalPreOrder(root2);
		}
    public String TraversalPreOrder(TreeNode2 node) {
		String order = "";
		order=order+node.val+" ";
		if(node.left!=null) {
			order =order+TraversalPreOrder(node.left);
		}
		if(node.right!=null) {
			order =order+TraversalPreOrder(node.right);
		}
		return order;
		}
    public String TraversalPostOrder() {
			return TraversalPreOrder(root2);
			}
	public String TraversalPostOrder(TreeNode2 node) {
			String order = "";
			if(node.left!=null) {
				order =order+TraversalPostOrder(node.left);
			}
			if(node.right!=null) {
				order =order+TraversalPostOrder(node.right);
			}
			order=order+node.val+" ";
			return order;
			}
	public String TraversalLevelOrder() {
		return TraversalPreOrder(root2);
		}
    public String TraversalLevelOrder(TreeNode2 node) {
		String order = "";
		Queue<TreeNode2> que = new LinkedList<TreeNode2>();
		que.offer(node);
		while(!que.isEmpty()) {
			TreeNode2 here=que.peek();
			order=order+here.val+" ";
			que.poll();
			if(here.left!=null) {
				que.offer(here.left);
			}
			if(here.right!=null) {
				que.offer(here.right);
			}
		}
		return order;
		}
    public int GetDepth() {
    	return GetDepth(root2);
    }
    public int GetDepth(TreeNode2 node) {
    	int deep=0;
    	if(node.left!=null||node.right!=null) {
    		if(node.left==null) {
    			deep=deep+1+GetDepth(node.right);
    		}
    		else if(node.right==null) {
    			deep=deep+1+GetDepth(node.left);
    		}
    		else {
    			int deep1=deep+1+GetDepth(node.right);
    			int deep2=deep+1+GetDepth(node.left);
    			if(deep1>deep2) {
    				deep=deep1;
    			}
    			else {deep=deep2;}
    		}
    	}
    	return deep;
    }
    public void Print() {
        if(root2==null) {}//树不存在
    	else if(GetDepth(root2)==0) {
    		System.out.println(root2.val);//只有根节点
    	}
    	else {
    	int lastnumber=1;
    	TreeNode2 nullnode=new TreeNode2(-111);
		lastnumber=(int)Math.pow(2,GetDepth(root2));
		int [][]valnumber=new int[GetDepth(root2)+1][lastnumber];
		//因为数字最多为两位数，先把树用-111补全为完全二叉树，所有数字按levelorder提出来.
    	Queue<TreeNode2> que = new LinkedList<TreeNode2>();
    	que.offer(root2);
    	for(int i=0;i<GetDepth(root2)+1;i++) {
    		for(int k=0;k<Math.pow(2, i);k++){
    			if(que.peek()!=null) {
    			valnumber[i][k]=que.peek().val;}
    			else {valnumber[i][k]=-111;}
    			if(que.peek().left!=null) {
    			que.offer(que.peek().left);}
    			else {que.offer(nullnode);}
    			if(que.peek().right!=null) {
    			que.offer(que.peek().right);}
    			else {que.offer(nullnode);}
    	    	que.poll();
    		}
    	}
    	String [][]all=new String[GetDepth(root2)+1][(int)Math.pow(2,GetDepth(root2)+1)];
    	String [][]connect=new String[GetDepth(root2)][(int)Math.pow(2,GetDepth(root2)+1)];
    	//all里面每个元素是一行包括空格和数字的String;connect里面每个元素是一行对应的/\的String。
    	for(int i=0;i<all.length;i++) {
    		for(int k=0;k<all[0].length;k=k+1){
    			all[i][k]=" ";
    			if(i<connect.length) {
    			connect[i][k]=" ";}
    			}}
    	for(int i=GetDepth(root2);i>=0;i--) {
    		//按照最下面一行每个数字空一格的格式往上写，每行数字间的空格多出2^(n-1).
    		int before=(int)Math.pow(2,GetDepth(root2)-i)-1;
    		int space=0;
    		int middle=(int)Math.pow(2,GetDepth(root2)-i+1)/4;
    		for(int k=0;k<Math.pow(2, i);k=k+2){
    			String left= ""+valnumber[i][k];
    			String left2="/";
    			if(Integer.valueOf(valnumber[i][k])>9) {
  			      left2=" /";	
  			}
    			String right=""+ valnumber[i][k+1];
    			String right2="\\";
    			if(Integer.valueOf(valnumber[i][k+1])>9) {
    				//如果数字是两位数则多出一个空格
  			      right2="\\ ";	
  			}
    			if(valnumber[i][k]==-111) {
    				//补全的地方变成空格
    				left=" ";
    				left2=" ";
    			}
    			if(valnumber[i][k+1]==-111) {
    				right=" ";
    				right2=" ";
    			}
    			all[i][before+space]=left;
    			if(i!=0) {
    				connect[i-1][before+space+middle]=left2;
    			}
    			space+=(int)Math.pow(2,GetDepth(root2)-i+1);
    			if(i!=0) {
    			all[i][before+space]=right;
    			if(i!=0) {
    				connect[i-1][before+space-middle]=right2;
    			}
    			space+=(int)Math.pow(2,GetDepth(root2)-i+1);
    			}
    		}
    	}
    	//打印
    	for(int i=0;i<all.length;i++) {
    		for(int k=0;k<all[0].length;k++) {
    			System.out.print(all[i][k]);
    			}
    		
    		System.out.print("\n");
			if(i<connect.length) {
				for(int k=0;k<all[0].length;k++) {
			System.out.print(connect[i][k]);
				}
			}
			System.out.print("\n");
    	}
    } }
}
