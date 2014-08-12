package hex.com.test12.IO3;

import java.io.Serializable;

public class person  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "person [name=" + name + "]";
	}

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
