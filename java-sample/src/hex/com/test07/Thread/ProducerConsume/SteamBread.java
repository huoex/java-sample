package hex.com.test07.Thread.ProducerConsume;
class SteamBread{
	int id;//馒头编号
	SteamBread(int id){
		this.id = id;
	}
	public String toString(){
		return "steamBread:"+id;
	}
}