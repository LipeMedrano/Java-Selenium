package com.access1;

import com.access2.AccessModifier2;

public class Main {

	public static void main(String[] args) {
		
		AccessModifier1 access = new AccessModifier1();
		access.helloWorldPublic();
		
		AccessModifier2 access2 = new AccessModifier2();
		access2.helloWorldProtected();
		
		access.helloWorldNoModifier();
		
//		access.helloWorldPrivate();

	}

}
