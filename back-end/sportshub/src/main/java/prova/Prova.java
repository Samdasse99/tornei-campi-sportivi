package prova;

import util.JpaUtil;

public class Prova {

	public static void main(String[] args) {
		var em = JpaUtil.getInstance().getEntityManager();
	}

}
