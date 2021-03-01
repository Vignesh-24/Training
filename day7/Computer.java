package day7;

public class Computer {
	
	private String HDD;
	private String RAM;
	//optional
	private String graphics;
	private String wifi;
	
	public Computer(ComputerBuilder builder) {
		this.HDD=builder.HDD;
		this.RAM=builder.RAM;
		this.wifi=builder.getWifi();
		this.graphics=builder.getGraphics();
		
	}
	
	
	@Override
	public String toString() {
		return "Computer [HDD=" + HDD + ", RAM=" + RAM + ", graphics=" + graphics + ", wifi=" + wifi + "]";
	}


	public final String getHDD() {
		return HDD;
	}
	public final void setHDD(String hDD) {
		HDD = hDD;
	}
	public final String getRAM() {
		return RAM;
	}
	public final void setRAM(String rAM) {
		RAM = rAM;
	}
	public final String getGraphics() {
		return graphics;
	}
	public final void setGraphics(String graphics) {
		this.graphics = graphics;
	}
	public final String getWifi() {
		return wifi;
	}
	public final void setWifi(String wifi) {
		this.wifi = wifi;
	}
	
	
	
	//Static Inner Class
	public static class ComputerBuilder{
		
		private String HDD;
		private String RAM;
		//optional
		private String graphics;
		private String wifi;
		
		ComputerBuilder(String HDD, String RAM){
			this.HDD=HDD;
			this.RAM=RAM;
		}
		
		public final Computer build() {
			return new Computer(this);
			
		}

		public final String getGraphics() {
			return graphics;
		}

		public final ComputerBuilder setGraphics(String graphics) {
			this.graphics = graphics;
			return this;
		}

		public final String getWifi() {
			return wifi;
		}

		public final ComputerBuilder setWifi(String wifi) {
			this.wifi = wifi;
			return this;
		}
		
	}
	
	

}
