package action;

import java.util.Date;

import dao.GoddessDao;
import model.Goddess;

public class GoddessAction {

	public static void main(String[] args) throws Exception {

		GoddessDao g = new GoddessDao();
		Goddess g1 = new Goddess();
//		List<Goddess> gs = g.query();
		
//		for(Goddess goddess : gs) {
//			System.out.println(goddess.getUser_name() + "," + goddess.getAge());
//		}
		g1.setUser_name("Ð¡ÏÄ");
		g1.setAge(21);
		g1.setSex(1);
		g1.setBirthday(new Date());
		g1.setEmail("xiaoxia@imooc.com");
		g1.setMobile("15899666654");
		g1.setCreate_user("htmboy");
		g1.setUpdate_user("admin");
		g1.setIsdel(1);
		g1.setId(3);
//		g.updateGoddess(g1);
//		g.delGoddess(3);
		Goddess g2 = g.query("Ð¡Ïª");
		System.out.println(g2.toString());
//		g.addGoddess(g1);
	}

}
