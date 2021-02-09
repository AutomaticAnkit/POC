package AVSeleniumPractice.WebAppAutomation;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.poi.util.SystemOutLogger;

public class javaPracto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//String s= "MADAM";
//String t="";
//for(int i =s.length()-1;i>=0;i--) {
//	System.out.print(s.charAt(i));
//	t=t+s.charAt(i);			
//}
//System.out.println("new string is  " + t);
//if(t.equals(s)) {
//	System.out.println("Strings are pallindrome");
//}
//else
//{
//	System.out.println("String are not pallindrome");
//}

//Print below sequence 
		/*
		 * 1.) 1 2 3 4 5 6 7 8 9 10
		 */

//Awnser Below
//		int k=1;
//		for(int i=0; i<4; i++) {
//			for(int j=1;j<=4-i;j++) {
//				System.out.print(k);//1234
//				System.out.print("\t");
//				k++;//2
//				
//			}
//			System.out.println(" ");
//		}

		// Print below sequence
		/*
		 * 1.) 1 2 3 4 5 6 7 8 9 10
		 */

		// Awnser Below
//		int k =1;
//		for(int i=1;i<5;i++) {
//			for(int j=1;j<=i;j++) {
//				System.out.println(k);
//				System.out.print("\t");
//				k++;
//			}
//			System.out.println("");
//		}
//		
//		for (int i=1; i<=5;i++) {
//			for(int j =1;j<=i;j++) {
//				System.out.print(j);
//				System.out.print("\t");
//			}
//		}System.out.print(" ");

//		String a[]= {"a","b","c"};
//		ArrayList<String> l = new ArrayList<String>();
//		HashMap hs=new HashMap();
//	
//		
//		
//		for(int i=0;i<a.length;i++) {
//			hs.put(i, a[i]);
//			
//			
////		l.add(a[i].toUpperCase());
//		
//			
//}
//	System.out.println(hs);
//	Iterator<String> it=l.iterator();
//	System.out.println(it.next());
//		int k=0;
//		int a[]= {1,2,2,3,5,5,6};
//		System.out.println(a.length);
//		ArrayList<Integer> al=new ArrayList<Integer>();
//		for(int i=0;i<=a.length;i++) {
//			if(!al.contains(a[i])) {
//				al.add(a[i]);
//			}
//			System.out.println(al);
//				
//		}
//	}
//	

//	for (int i=0;i<=5;i++) {
//		for(int j=1;j<=i;j++) {
//			System.out.print("*");
//			System.out.print("\t");
//		}System.out.println("");
//	}

		// Fibonacci Series
//		int a =0;
//		int b=1;
//		int c;
//		int count =10;
//		
//		System.out.println(a+" "+b);
//		for(int i=2;i<count;i++) {
//			c=a+b;
//			System.out.println(c+ " ");
//			a=b;
//			b=c;
//		}

		// Reverse a string
//		String s[]={"Ankit"," is", "a", "good" , "man"};
//		
//	 
//		
//		ArrayList<String> sa= new ArrayList<String>();
//		for (int i=s.length-1;i>=0;i--) {
//			String B=s[i];
//			sa.add(B);
//		}
//		
//		System.out.println(sa);
		// Find the larget value of given Array
//		
//		int[] a= {2,45,3,5,67,7};
//		int maxval=a[0];
//		
//		for(int i=1;i<=a.length-1;i++) {
//			if(a[i]>maxval) {
//				maxval=a[i];
//			}
//		}System.out.println(maxval);

		// Prime Number
//	int num=0;
//	String primeNumbers = "";
//	for(int i=0;i<=100;i++) {
//		int counter =0;
//		for(num=i;i>=1;num--) {
//			if(i%num==0) {
//				counter=counter+1;
//			}
//			if(counter==2) {
//				primeNumbers=primeNumbers+i+" ";
//			}
//		} System.out.println("Prime numbers from 1 to 100 are :");
//	       System.out.println(primeNumbers);
//	}

		// Duplicate Number from the Array using Array List and Has set.
//		int a[]= {1,2,3,3,4,5,5,6};
//		ArrayList<Integer> ak=new ArrayList<Integer>();
//		for(int i=0;i<a.length;i++) {
//			ak.add(a[i]);
//		}System.out.println("List of all the Numbers is "+ak);
//		HashSet  hs= new HashSet();
//		HashSet  he= new HashSet();
//		for(int j : ak) {
//			if(!hs.add(j)) {
//				he.add(j);
//			}
//			
//		}
//		System.out.println("The Duplicate Numbers are "+he);

		// Sorting in List of Insensitive of Case
//		String[] il = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
//				"aug", "Sep", "Oct", "nov", "Dec" };
//		
//		ArrayList<String> ak=new ArrayList<String>();
//		for(int i=0;i<il.length;i++) {
//			ak.add(il[i]);
//		}
//		Collections.sort(ak, String.CASE_INSENSITIVE_ORDER);
//		System.out.println(ak);

	}

}
