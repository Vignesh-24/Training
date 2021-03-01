package day7;

public class Builder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer dell_5410=new Computer.ComputerBuilder("HDD-1000GB", "16GB RAM")
							.setGraphics("RADEON Enabled")
							.build();
		
		Computer dell_7400=new Computer.ComputerBuilder("HDD-512GB", "8GB RAM")
							.setGraphics("NVIDIA Enabled")
							.setWifi("WIFI 802.11 Enabled")
							.build();
		
		System.out.println(dell_5410);
		System.out.println(dell_7400);

	}

}
