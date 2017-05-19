package employeedetails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IdentifyGratuityService {

/*	public static void main(String[] args) {
		System.out.println(isEligibleForGS("02/05/2012"));
	}
*/
	public static boolean isEligibleForGS(String doj) {
		System.out.println("incoming current date: " + doj);
		boolean flag = false;
		if (yearsSince(doj) >= 5) {
			System.out.println("eligible for Gratuity fund");
			flag = true;
		} else {
			System.out.println("Not eligible for Gratuity fund");
		}
		return flag;
	}

	public static int yearsSince(String incomingDate) {
		Calendar present = Calendar.getInstance();
		Calendar past = Calendar.getInstance();

		Date comingDate = null;
		try {
			comingDate = new SimpleDateFormat("dd/MM/yyyy").parse(incomingDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		past.setTime(comingDate);

		int years = 0;

		while (past.before(present)) {
			past.add(Calendar.YEAR, 1);
			if (past.before(present)) {
				years++;
			}
		}
		return years;
	}

}
