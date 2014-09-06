package org.osito.mindstorms.gripper.body;

public class Body {

	private Head head;
	private RightTire rightTire;
	private LeftTire leftTire;
	private Hands hands;
	
	public Head head() {
		if (head == null) {
			head = new Head();
		}
		return head;
	}
	
	public RightTire rightTire() {
		if (rightTire == null) {
			rightTire = new RightTire();
		}
		return rightTire;
	}
	
	public LeftTire leftTire() {
		if (leftTire == null) {
			leftTire = new LeftTire();
		}
		return leftTire;
	}

	public Hands hands() {
		if (hands == null) {
			hands = new Hands();
		}
		return hands;
	}

	public void moveForward() {
		leftTire().moveForward();
		rightTire().moveForward();
	}

}
