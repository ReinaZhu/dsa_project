
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree extends Tree2 {
	private TreeNode2 root2;
	BinarySearchTree(){super();}
	BinarySearchTree(int[] a){
		if(a.length==0) {}//防止数组为空
		else {
		this.root2=new TreeNode2(a[0]); 
		TreeNode2 []number=new TreeNode2[a.length];//数组每个元素为node，加到树里
		for(int i=0;i<a.length;i++) {
			number[i]=new TreeNode2(a[i]);
		}
		for(int i=0;i<a.length;i++) {
		TreeNode2 where = root2;
		int left =0;//在这个Node的左边为2，右边为1
		if(a[i]<root2.val) {
			if(root2.left==null) {
				root2.left=number[i];
				continue;
			}
			else {
				where=root2.left;
				if(a[i]<where.val) {
				left=2;
			}else if(a[i]>where.val){
				left=1;
			}
			else {continue;}
			}
		}
		else if(a[i]>root2.val) {
			if(root2.right==null) {
				root2.right=number[i];
				continue;
			}
			else {
				where=root2.right;
				if(a[i]<where.val) {
					left=2;
				}else if(a[i]>where.val){
					left=1;
				}
				else {continue;}
			}
		}
		else {continue;}//相等就不加
		while((where.right!=null&&left==1)||(where.left!=null&&left==2)) {
		if (a[i]>where.val) {
			where=where.right;
			if(a[i]<where.val) {
				left=2;
			}else if(a[i]>where.val){
				left=1;
			}
			else {continue;}
		}
		else if(a[i]<where.val) {
			where=where.left;
			if(a[i]<where.val) {
				left=2;
			}else if(a[i]>where.val){
				left=1;
			}
			else {continue;}
		}
		else {continue;}
		}
			if(left==1) {
				where.right=number[i];
			}
			if(left==2) {
				where.left=number[i];
			}
		}}}
	public boolean insert(int a) {
		boolean success=true;
		TreeNode2 here = new TreeNode2(a);
			TreeNode2 where = root2;
			int left =0;
			int finish=0;
			if(a<root2.val) {
				if(root2.left==null) {
					root2.left=here;
					finish=1;
				}
				else {
					where=root2.left;
					if(a<where.val) {left=2;}
					else if(a>where.val){left=1;}
				    else {success=false;
					      finish=1;}
					}
			}
			else if(a>root2.val) {
				if(root2.right==null) {
					root2.right=here;
					finish=1;
				}
				else {
					where=root2.right;
					if(a<where.val) {
						left=2;
					}else if(a>where.val){
						left=1;
					}
					else {
						success=false;
						finish=1;
					}
				}
			}
			else {success=false;
			finish=1;}
			while(finish==0&&(where.right!=null&&left==1)||(where.left!=null&&left==2)) {
			if (a>where.val) {
				where=where.right;
				if(a<where.val) {
					left=2;
				}else if(a>where.val){
					left=1;
				}
				else {
					success=false;
					finish=1;
				}
			}
			else if(a<where.val) {
				where=where.left;
				if(a<where.val) {
					left=2;
				}else if(a>where.val){
					left=1;
				}
				else {
					success=false;
					finish=1;
					}
			}
			else {
				success=false;
				finish=1;
				}
			}//循环结束，找到该加的地方where
				if(finish==0&&left==1) {
					where.right=here;
				}
				if(finish==0&&left==2) {
					where.left=here;
				}
			
			return success;
		}
    public Boolean delete(int a) {
    	Boolean success;
    	success=isExist(a,root2);//树里是否有这个数字
    	if(a==root2.val) {//当删除根时
    		if(root2.left!=null) {
    			TreeNode2 max=Findmax(root2.left);//先考虑左枝的最大值
    			int val=max.val;
    			delete(val);
    			root2.val=val;
    		}
    		else if(root2.right!=null) {//如果左边是null，找右边max
    			TreeNode2 min=Findmin(root2.right);
    			int valm=min.val;
    			delete(valm);
    			root2.val=valm;
    		}
    		else {root2=null;}
    	}
    	else {//删除非根节点
    	if(success==true) {
    		TreeNode2 item=FindNode(a);
    		TreeNode2 fitem=FindFather(a);
    		if(item.left!=null) {
    			TreeNode2 max=Findmax(item.left);
    			int val=max.val;
    			delete(val);
    			item.val=val;
    		}
    		
    		else if(item.right!=null) {
    			TreeNode2 min=Findmin(item.right);
    			int valm=min.val;
    			delete(valm);
    			item.val=valm;
    		}
    		else {
    			if(fitem.right==null||fitem.right.val!=a) {//判断该点是它father的左边还是右边
    				fitem.left=null;
    			}
    			else {fitem.right=null;}
    		}
    	}}
    	return success;
    }
	 
	public TreeNode2 Findmax(TreeNode2 a) {
		TreeNode2 max=a;
		while(max.right!=null) {
			max=max.right;
		}
		return max;
	}
	public TreeNode2 Findmin(TreeNode2 a) {
		TreeNode2 min=a;
		while(min.left!=null) {
			min=min.left;
		}
		return min;
	}
	public TreeNode2 FindFather(int a) {
		TreeNode2 item=root2;
		TreeNode2 fitem=root2;
		int left=2;
		while(a!=item.val) {
			if(a<item.val) {
				fitem=item;
				item=item.left;
				left=1;
			}
			else {
				fitem=item;
				item=item.right;
				left=0;
			}
		}
		
		return fitem;
	}
	public TreeNode2 FindNode(int a) {
		TreeNode2 item=root2;
		while(a!=item.val) {
			if(a<item.val) {
				item=item.left;
			}
			else {item=item.right;}
		}
		
		return item;
	}
	
	public Boolean isExist(int x,TreeNode2 a){
		Boolean is=false;
		String number=TraversalInOrder(a);
		String num[]=number.split(" ");
		for(int i=0;i<num.length;i++) {
			if(x==Integer.valueOf(num[i])) {
				is=true;
				break;
			}
		}
		return is;
	}
	public String TraversalInOrder() {
		return TraversalInOrder(this.root2);
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
	    	if(GetDepth(root2)==0) {
	    		System.out.println(root2.val);
	    	}
	    	else {
	    	int lastnumber=1;
	    	TreeNode2 nullnode=new TreeNode2(-1);
			lastnumber=(int)Math.pow(2,GetDepth(root2));
			int [][]valnumber=new int[GetDepth(root2)+1][lastnumber];
	    	Queue<TreeNode2> que = new LinkedList<TreeNode2>();
	    	que.offer(root2);
	    	for(int i=0;i<GetDepth(root2)+1;i++) {
	    		for(int k=0;k<Math.pow(2, i);k++){
	    			if(que.peek()!=null) {
	    			valnumber[i][k]=que.peek().val;}
	    			else {valnumber[i][k]=-1;}
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
	    	for(int i=0;i<all.length;i++) {
	    		for(int k=0;k<all[0].length;k=k+1){
	    			all[i][k]=" ";
	    			if(i<connect.length) {
	    			connect[i][k]=" ";}
	    			}}
	    	for(int i=GetDepth(root2);i>=0;i--) {
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
	    			      right2="\\ ";	
	    			}
	    			if(valnumber[i][k]==-1) {
	    				left=" ";
	    				left2=" ";
	    			}
	    			if(valnumber[i][k+1]==-1) {
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
	    }}
}
