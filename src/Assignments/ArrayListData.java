package Assignments;

class person {
	String occ;
	String name;
	String gender;
	int age;
	
	public person(String o, String n, String g, int a) {
		occ = o;
		name = n;
		gender = g;
		age = a;
	}
}

class female extends person {
	
	public female(String o, String n, int a) {
		super(o, n, "f", a);
	}
}

class male extends person {
	
	public male(String o, String n, int a) {
		super(o, n, "m", a);
	}
	
}

public class ArrayListData {
	
	public static void main(String[] args) {
		
	}

}
