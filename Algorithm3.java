
public class Algorithm3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=512;
		int [] number=new int[N];
		for(int i=0;i<N;i++) {
				number[i]=(int)(Math.random()*100)-50 ;
			//生成随机list
		}
		/*开始方法*/
		int count=0;
		for(int i=0;Math.pow(2, i)<N;i++) {
			count=i;
		}
		count+=1;
		double leng=Math.pow(2, count);
		int len=(int)leng;
		int [] all=new int[len];
		for(int i=0;i<len;i++) {
			if(i<N) {
			all[i]=number[i];
			}
		
		else {
			all[i]=0;
		}//all在number后面补齐零使得其长度为2的幂次，方便二分法。
		}
		int [] max1=new int [len/2];
		int [] abc1=new int [len/2];
		int[][]index1=new int[len/2][2];
		long startTime = System.nanoTime();
		for(int i=0;i<len;i=i+2) {
			int a=all[i];
			int b=all[i+1];
			int c=a+b;
			if(a>=b&a>=c) {
				max1[i/2]=a;
				index1[i/2][0]=i;
				index1[i/2][1]=i;
				abc1[i/2]=0;
			}
			else if(b>a&b>=c) {
				max1[i/2]=b;
				index1[i/2][0]=i+1;
				index1[i/2][1]=i+1;
				abc1[i/2]=1;
			}
			else if(c>a&c>b) {
				max1[i/2]=c;
				index1[i/2][0]=i;
				index1[i/2][1]=i+1;
				abc1[i/2]=2;
			}
			}/*abc是记录两个数字谁最大或者是和最大，index记录序号，max记录最值*/
		for(int i=2;i<=count;i++) {
			double lll=Math.pow(2, i);
			int ll=(int)lll;
			int [] max2=new int [2*len/ll];
			int [] abc2=new int [2*len/ll];
			int[][]index2=new int[2*len/ll][2];
			for (int k=0;k<max2.length;k++) {
				max2[k]=max1[k];
						for(int q=0;q<2;q++) {
							index2[k][q]=index1[k][q];
						}
			}
			for (int k=0;k<max2.length;k++) {
				abc2[k]=abc1[k];}
			max1=new int [len/ll];
			abc1=new int [len/ll];
			index1=new int[len/ll][2];
			
			for (int j=0;j<max2.length;j=j+2) {
				int aa=max2[j];
				int bb=max2[j+1];
				int cc;
						cc=0;
						 for (int r=index2[j][0];r<=index2[j+1][1];r++) {
								cc=cc+all[r];}
						 if(aa>=bb&aa>cc) {
								max1[j/2]=aa;
								index1[j/2][0]=index2[j][0];
								index1[j/2][1]=index2[j][1];
								abc1[j/2]=0;
							}
							else if(bb>aa&bb>cc) {
								max1[j/2]=bb;
								index1[j/2][0]=index2[j+1][0];
								index1[j/2][1]=index2[j+1][1];
								abc1[j/2]=1;
							}
							else if(cc>=aa&cc>=bb) {
								max1[j/2]=cc;
								index1[j/2][0]=index2[j][0];
								index1[j/2][1]=index2[j+1][1];
								abc1[j/2]=2;
						
					}
			
			}//最大值为max1【0】
				}
		long endTime   = System.nanoTime(); //程序结束记录时间
		long TotalTime = endTime - startTime;
		/*System.out.printf("%n %d",MaxSum);*/
		System.out.println(TotalTime);
		System.out.printf("max:%n%d",max1[0]);
		}
		
	}


