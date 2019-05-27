package org.restful.tema2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "wine")
@XmlAccessorType(XmlAccessType.FIELD)
public class Wine {

	private String id;
	private String name;
	private Double price;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Wine() {}
	
	public Wine(String id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
}
