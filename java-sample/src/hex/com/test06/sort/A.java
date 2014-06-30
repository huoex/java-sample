package hex.com.test06.sort;
class A implements Comparable<A>{
	private String name;
	private Integer order;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "name is "+name+" order is "+order;
	}
	@Override
	public int compareTo(A a) {
		return this.order.compareTo(a.getOrder());
	}
	
}

