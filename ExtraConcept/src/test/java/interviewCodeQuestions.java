import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.stream.events.Characters;

public class interviewCodeQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Want to print below string separately
String ss= "Java, Selenium, testNG, Maven";
String[] new1=ss.split(" ");
String[] new2=ss.split(","); //split return array
for(int i=0;i<4;i++)
{
	System.out.println(new1[i]);
	System.out.println(new2[i]);

}

//2. concatinate String
String s1="ABC";
String s2="XYZ";
String s3="PQR";
String com=s1+s2+s3;
System.out.println(com);
String com1=s1.concat(s2);
String com2=com1.concat(s3);
System.out.println(com2);
//suppose we dont want to use 2 seperate variable , want it in single line

String com3=s1.concat(s2).concat(s3);
System.out.println(com3);

//3. find vowel,consonant from a String
String s11="WelcOme";
boolean flag=false;
int count = 0;
//s11.contains('A'||'a');// :The operator || is undefined for the argument type(s) char, char
for(int i=0;i<s11.length();i++)
{
	char ch=s11.charAt(i);
	
	if(ch=='A' || ch=='a' || ch=='E' || ch=='e' || ch=='I' || ch=='i' || ch=='O' || ch=='o' || ch=='U' || ch=='u')
	{ 
	count++;
		flag=true;
		
	}
}
System.out.println("Vowel count is " + count);
	if(flag==true)
	{
		System.out.println("Vowel is present");
	}
	else
	{
		System.out.println("Vowel is not present");
	}
//4. find odd,even number from array
int a[]= {1,14,12,3,4};

int count1 = 0;
int count2 = 0;
for(int i=0;i<a.length;i++)
{
	if(a[i]%2==0)
	{
		
		count1++;
	}
	else
	{
		count2++;
	}
}
System.out.println("even count is " + count1);
System.out.println("odd count is " + count2);

//5. compare two string; equals method use krenge ya compareTo method
//6. reverse the string

String sa="Welcome";
StringBuilder sb=new StringBuilder(sa);
System.out.println(sb.reverse()); 
 //without reverse method
String emp="";
for(int i=sa.length()-1;i>=0;i--)
{
	emp=emp+sa.charAt(i);
	System.out.println(emp);
}
System.out.println(emp);


//Note: does list contains sort method: Yes , does array contains sort method: Yes

int[] aa1= {1,2,2,3,4,4,3,5};
Arrays.sort(aa1);
System.out.println(aa1);
for (int num : aa1) 
{
    System.out.print(num + " ");
}
//7. Remove duplicates from string : for this, we need a set
String sa1="Welcome";
char[] char11=sa1.toCharArray();
Set<Character> set2=new HashSet<>();
for(char char12:char11)
{
	set2.add(char12);
}
System.out.println(set2);

//7. Remove duplicates from array : for this, we need a set
Set<Integer> set1=new HashSet<>();
for(int arr12:aa1)
{
	set1.add(arr12);
}
System.out.println(set1);		
	}

}
