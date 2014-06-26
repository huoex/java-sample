package hex.com.test03.list;

import java.util.ArrayList;
import java.util.List;

public class a {
	List<dto> ls;
	List<dto2> ls2;
	List<dto3> ls3;

	public List<dto> getLs() {
		return ls;
	}

	public void setLs(List<dto> ls) {
		this.ls = ls;
	}

	public dto1 aa() {
		String tmpCntNo = null;
		String tmpCstNo = null;
		dto1 dd = new dto1();
		ls2 = new ArrayList<dto2>();
		dto2 dd2 = new dto2();
		dto3 dd3 = new dto3();

		// ls3 = new ArrayList<dto3>();
		for (int i = 0; i < ls.size(); i++) {

			// Break CstNo
			if (!ls.get(i).getChIngtCstNo().equals(tmpCstNo)) {
				tmpCstNo = ls.get(i).getChIngtCstNo();
				dd.setChIngtCstNo(ls.get(i).getChIngtCstNo());
			}

			// Break CntNo

			if (!ls.get(i).chCntNo.equals(tmpCntNo)) {
				if (i != 0) {
					dd2.setLschCrdNo(ls3);
					ls2.add(dd2);
				}
				tmpCntNo = ls.get(i).chCntNo;
				dd2 = new dto2();
				dd3 = new dto3();
				ls3 = new ArrayList<dto3>();
				dd2.setChCntNo(ls.get(i).getChCntNo());
				dd3.setChCrdNo(ls.get(i).getChCrdNo());
				ls3.add(dd3);
				// The same chCntno
			} else {
				dd3 = new dto3();
				dd3.setChCrdNo(ls.get(i).getChCrdNo());
				ls3.add(dd3);
			}

			if (i == ls.size() - 1) {
				dd2.setLschCrdNo(ls3);
				ls2.add(dd2);
			}

		}
		dd.setLschCntNo(ls2);
		return dd;
	}
}
