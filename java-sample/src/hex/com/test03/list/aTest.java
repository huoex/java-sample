package hex.com.test03.list;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class aTest {

	@Test
	public void test() {

		a pro = new a();
		List<dto> ls = new ArrayList<dto>();
		ls.add(setData("CC001","KK001","GG001"));
		ls.add(setData("CC001","KK002","GG001"));
		ls.add(setData("CC002","KK003","GG001"));
		ls.add(setData("CC002","KK004","GG001"));
		ls.add(setData("CC003","KK005","GG001"));
		ls.add(setData("CC003","KK006","GG001"));
		
		pro.setLs(ls);
		dto1 dd = pro.aa();
		System.out.println(dd);
//		fail("Not yet implemented");
	}
	
	dto setData(String p1,String p2,String p3){
		dto data = new dto();
		data.setChCntNo(p1);
		data.setChCrdNo(p2);
		data.setChIngtCstNo(p3);
		return data;
	}

}
