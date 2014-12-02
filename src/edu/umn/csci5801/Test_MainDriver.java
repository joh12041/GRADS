/*package test_harness;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

import data_parser.*;
import password_guesser.*;*/

//import edu.umn.csci5801;
import src.edu.umn.csci5801.GRADSIntf;

public class Test_MainDriver {

	public static void main(String [] args) {
		GRADSIntf grIntf = new GRADSIntf();
		System.out.println("Hello World");
		
		/*JSONObject jsonObject = new JSONObject();
		Parser p = new Parser("../data/num_pswds/02/ct_ct.json");
		password_guesser.Password passwordAlg = new password_guesser.Password("", "");
		int guessCount = 0, total = 0;
		try {

			HashMap<Integer, PasswordGroup> dict = p.getAllGroups();
			for (Integer key : dict.keySet()) {
				List<data_parser.Password> pswdList = (dict.get(key)).getPasswordList();
				if (pswdList.size() == 2) {
					total++;
					String firstString = pswdList.get(0).getValue();
					String secondString = pswdList.get(1).getValue();
					passwordAlg.setInputAndTarget(firstString, secondString);
					if (passwordAlg.checkPassword()) {
						guessCount++;
					}

					if (total % 100 == 0) {
						System.out.print(".");
					}
				}
			}
			System.out.println();
			System.out.println("Finished trial!");
			System.out.println("Success rate: " + guessCount + "/" + total);
			System.out.println("Total checks: " + passwordAlg.getCheckCount());
			System.out.println();

		} catch (IOException ioex) {
			System.out.println("Caught exception in test_ct_ct()");
		}*/
		return;
	}
	
}
