package commonUtils;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class JavaUtilis {
	
	public static String randomNumebr() {
		Random random = new Random();
		int randomNumber = random.nextInt(1000);
		String id = Integer.toString(randomNumber);
		return id;
	}
	
	public static String randomStrig() {
		String randomSTring = RandomStringUtils.randomAlphabetic(8);
		return randomSTring;
	}
}
