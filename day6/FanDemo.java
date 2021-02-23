package day6;

import java.util.Scanner;

public class FanDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//State one is OFF
		Fan fan=FanContainer.getFan("day6.State_One");
		fan.run();
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
			scanner.nextInt();
			fan=FanContainer.getFan(fan.state.nextState);
			fan.run();
		}

	}
}

abstract class State{
	static String nextState="day6.State_One";
	
}

class State_One extends State{
	
	public State_One() {
		// TODO Auto-generated constructor stub
		nextState="day6.State_Two";
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Fan Running in State_1";
	}
	
}

class State_Two extends State{
	
	public State_Two() {
		// TODO Auto-generated constructor stub
		nextState="day6.State_Three";
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "Fan Running in State_2";
	}
	
}

class State_Three extends State{
	
	public State_Three() {
		// TODO Auto-generated constructor stub
		nextState="day6.State_One";
	}
	
	public String toString() {
		// TODO Auto-generated method stub

		return "Fan Running in State_3";
	}
	
}

class Fan{
	State state;
	public void run() {
		System.out.println(state.toString());
		
	}
	
}


class FanContainer{
	public static Fan getFan(String classname) throws Exception {
		Fan fan=new Fan();
		State state=(State)Class.forName(classname).newInstance();
		fan.state=state;
		return fan;
	}
}