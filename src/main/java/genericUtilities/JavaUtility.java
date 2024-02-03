package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class contains reusable methods to perform java related operations
 * @author KRISHNAVENI
 */
public class JavaUtility {
	/**
	 * This method fetches current date and time in specified format
	 * @return
	 */
	public String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_mm_yy_hh_mm_ss");
		return sdf.format(date);
	}

}
