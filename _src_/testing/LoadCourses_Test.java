package test_harness;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

import data_parser.*;
import password_guesser.*;

public class LoadCourses_Test {

	public static void main(String [] args) {
		System.out.println("Beginning test with 3 passwords per user. (cleartext)");
		
		JSONObject jsonObject = new JSONObject();
		Parser p = new Parser("../data/num_pswds/03/ct_ct_ct.json");
		password_guesser.Password passwordAlg = new password_guesser.Password("", "");
		int guessCount = 0, total = 0;
		try {

			HashMap<Integer, PasswordGroup> dict = p.getAllGroups();
			for (Integer key : dict.keySet()) {
				List<data_parser.Password> pswdList = (dict.get(key)).getPasswordList();
				if (pswdList.size() == 3) {
					total += 3;
					String firstString = pswdList.get(0).getValue();
					String secondString = pswdList.get(1).getValue();
					String thirdString = pswdList.get(2).getValue();
					
					passwordAlg.setInputAndTarget(firstString, secondString);
					if (passwordAlg.checkPassword()) {
						guessCount++;
					}

					passwordAlg.setInputAndTarget(secondString, thirdString);
					if (passwordAlg.checkPassword()) {
						guessCount++;
					}

					passwordAlg.setInputAndTarget(firstString, thirdString);
					if (passwordAlg.checkPassword()) {
						guessCount++;
					}

					if (total % 99 == 0) {
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
			System.out.println("Caught exception in main()...");
		}

		return;
	}
	
}
