package week1.day1;

public class PrintPrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int i =0;
//		int num =0;
//		String primeNUmber = "";
//		for (i=1;i<=100;i++) {
//			
//			int counter=0;
//			for(num=i;num>=1;num--) {
//				
//				if(i%num==0) {
//					counter = counter +1;
//				}
//			}
//			
//			if(counter==2) {
//				primeNUmber=primeNUmber +i + ",";
//				
//			}
//		}
//		
//		System.out.println(primeNUmber);
//		
//	}
		
		




int i,m=0,flag=0;      
int n=3;//it is the number to be checked    
m=n/2;      
if(n==0||n==1){  
 System.out.println(n+" is not prime number");      
}else{  
 for(i=2;i<=m;i++){      
  if(n%i==0){      
   System.out.println(n+" is not prime number");      
   flag=1;      
   break;      
  }      
 }      
 if(flag==0)  { System.out.println(n+" is prime number"); }  
}//end of else 
}}

	