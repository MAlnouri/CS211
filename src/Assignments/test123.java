package Assignments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class test123 {

	
	
	
	public static void main(String[] args) {
		
		String s = " ";
		Set<String> kim=new HashSet<String>();Set<String> lee=new HashSet<String>();kim.add("cs211");kim.add("cs210");lee.add("cs211");lee.add("cs212");Set<String> kimANDlee= new HashSet<>(kim);kimANDlee.retainAll(lee);s = s + kimANDlee;s = s + "";System.out.println(s);
		System.out.println(kimANDlee);
		kimANDlee = (kim);
		System.out.println(kimANDlee);
	}
}