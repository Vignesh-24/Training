package minherpack;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity(name="car")
@DiscriminatorValue(value="car")
public class Car extends Automobile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String carfeatures;
	
	public String getCarfeatures() {
		return carfeatures;
	}
	public void setCarfeatures(String carfeatures) {
		this.carfeatures = carfeatures;
	}
	public String toString() {
		return "Car:"+super.toString();
	}
	public void handle() {
		new VisitorImpl().process(this);
	}
}
