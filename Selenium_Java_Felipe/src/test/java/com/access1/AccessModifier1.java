package com.access1;

public class AccessModifier1 {
	
	public void helloWorldPublic() {
		System.out.println("Hello World -> Public");
		helloWorldPrivate();
	}
	
	protected void helloWorldProtected() {
		System.out.println("Hello World -> Protected");
	}
	
	void helloWorldNoModifier() {
		System.out.println("Hello World -> No Modifier");
	}
	
	private void helloWorldPrivate() {
		System.out.println("Hello World -> Private");
	}
}
