package day7;

import java.util.Scanner;

public class CommandPattern {
	
	static E_Seva eseva;
	
	static {
		Police police =new Police();
		Hospital hospital=new Hospital();
		Corporation corp=new Corporation();
		FoodSafety foodsafety=new FoodSafety();
		eseva=new E_Seva();
		
		//Loading Commands into E_seva
		
		eseva.setCommands(new HotelOpenCommand(police, hospital, corp, foodsafety), 0);
		eseva.setCommands( new ForeignDeathCommand(police, hospital, corp, foodsafety), 1);
		eseva.setCommands(new MedicalCommand(police, hospital, corp, foodsafety), 2);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose \n 0: Hotel Open \n 1: ForeignDeath Command\n 2:MedicalCommand");
		eseva.execute(sc.nextInt());
		sc.close();

	}

}


class E_Seva{
	
	Command commands[]=new Command[5];
	
	E_Seva() {
		for(int i=0;i<5;i++)
			commands[i]=new Dummy();
	}
	
	
	public void execute(int slot) {
		this.commands[slot].execute();
	}



	public void setCommands(Command command, int slot) {
		this.commands[slot] = command;
	}



	class Dummy extends Command{

		@Override
		public void execute() {
			System.out.println("No Command Found..Yet to be Updated");
			
		}
		
	}
}


abstract class Command{
	Police police;
	Hospital hospital;
	Corporation corp;
	FoodSafety foodsafety;
	public Command() {
		
	}
	
	public Command(Police police, Hospital hospital, Corporation corp, FoodSafety foodsafety) {
		this.police = police;
		this.hospital = hospital;
		this.corp = corp;
		this.foodsafety = foodsafety;
	}

	public abstract void execute();
	
}

class HotelOpenCommand extends Command{
	
	public HotelOpenCommand(Police police, Hospital hospital, Corporation corp, FoodSafety foodsafety) {
		super(police, hospital, corp, foodsafety);
	}

	@Override
	public void execute() {
		System.out.println("Hotel Opening Process starts");
		police.doInvestigation();
		police.issueCertificate();
		foodsafety.doFoodInvestigation();
		foodsafety.issueFoodCertificate();
		System.out.println("Hospital Opening Successfull");
		
	}
	
}

class ForeignDeathCommand extends Command{
	
	public ForeignDeathCommand(Police police, Hospital hospital, Corporation corp, FoodSafety foodsafety) {
		super(police, hospital, corp, foodsafety);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Foreign Death Command Process starts");
		police.doInvestigation();
		police.issueCertificate();
		hospital.doPostMortem();
		hospital.issueCertificate();
		corp.giveDeathCertificate();
		System.out.println("Death Certificate issues");
		
		
	}
	
}

class MedicalCommand extends Command{
	
	public MedicalCommand(Police police, Hospital hospital, Corporation corp, FoodSafety foodsafety) {
		super(police, hospital, corp, foodsafety);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Medical Certification Processs Starts");
		police.doInvestigation();
		police.issueCertificate();
		hospital.issueCertificate();
		System.out.println("Medical Certification Processs Ended!!");
	}
	
}


class Police{
	
	public void doInvestigation() {
		System.out.println("Investigation Process Initiated by Police Dept..");
	}
	
	public void issueCertificate() {
		System.out.println("Certificate issued after investigation");
	}
	
}

class Hospital{
	
	public void doPostMortem() {
		System.out.println("PostMortem Process Initiated by hospital Dept..");
	}
	
	public void issueCertificate() {
		System.out.println("Medical certificate issued after analysis");
	}
	
}

class FoodSafety{
	
	public void doFoodInvestigation() {
		System.out.println("Investigation Process Initiated by Food Dept..");
	}
	
	public void issueFoodCertificate() {
		System.out.println("Food Certificate issued after investigation");
	}
	
}

class Corporation{
	
	public void giveDeathCertificate() {
		System.out.println("Death certificate issued by corporation Dept..");
	}
	
	public void issueABCCertificate() {
		System.out.println("ABC certificate issued after analysis");
	}
	
	
}
