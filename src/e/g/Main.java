package e.g;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.roundface.generator.MybatisGenerator;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID());
		// TODO Auto-generated method stub
		try {
			MybatisGenerator mg = new MybatisGenerator();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			mg.AUTHOR="lipeng";
			//mg.PROJECT_NAME="上海科匠信息科技有限公司 2015";
			//mg.TITLE="发现";
			mg.DATE=formatter.format(new Date());
			//mg.PACKAGE="discover";
			String[] table = new String[] {
					"system_role_authority"
			};
			mg.gener(table);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
