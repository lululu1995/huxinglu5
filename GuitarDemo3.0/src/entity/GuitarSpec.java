package entity;

import java.util.Iterator;

public class GuitarSpec {

	private String builder;
	private String model;
	private String type;
	private String wood;

	public GuitarSpec(String builder, String model, String type, String wood) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.wood = wood;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setWood(String wood) {
		this.wood = wood;
	}


	public String getBuilder() {
		return builder;
	}

	public String getModel() {
		return model;
	}

	public String getType() {
		return type;
	}

	public String getWood() {
		return wood;
	}


	public boolean matches(GuitarSpec otherSpec) {

		if (!builder.equals(otherSpec.builder))
			return false;
		if (!model.equals(otherSpec.model))
			return false;

		if (!type.equals(otherSpec.type))
			return false;

		if (!wood.equals(otherSpec.wood))
			return false;

		System.out.println("true");
		return true;
	}
}