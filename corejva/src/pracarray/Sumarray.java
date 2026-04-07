package pracarray;

public class Sumarray {
	 public static void main (String[] args) {
		 
	 
int[] arr =new int[10];
arr[0]=5;
arr[1]=1;
arr[2]=1;
arr[3]=4;
arr[4]=1;

int sum =0;
for(int i=0;i<arr.length;i++) {
	sum=sum+arr[i];
	
}
System.out.println("Sum is:"+sum);

}
}
