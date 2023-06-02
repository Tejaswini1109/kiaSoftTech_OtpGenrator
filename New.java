package otpGenrator;

import java.util.Random;
import java.util.Scanner;

public class New {

	private static final int otpLength = 6;
	private static final int time = 5;

	// this method is to generate otp
	public static String generateOTP() {
		Random random = new Random();
		StringBuilder otp = new StringBuilder(otpLength);

		for (int i = 0; i < otpLength; i++) {
			otp.append(random.nextInt(10));
		}

		return otp.toString();
	}

	
	// This is to check weather otp is correct or not
	public static boolean checkOtp(String checkotp, String realOtp) {
		if (checkotp.equals(realOtp)) {
			System.out.println("entered otp is correct");
			return true;
		}

		else {
			System.err.println("Entered otp is wrong");
		}

		System.out.println("Want to genrate new otp yes / no");
		String decision = scanner.next();

		if ((decision.equals("yes")) || (decision.equals("Yes"))) {
			realOtp = generateOTP();
			System.out.println("New OTP : " + realOtp);
		} else if ((decision.equals("no")) || decision.equals("No")) {
			System.out.println("Ok!..Thankyou");
		} else {
			System.out.println("please enter a valid option");
			checkOtp(checkotp, realOtp);
		}
		return false;
	}

	// User decision
	public static void decision(String otp) {
		System.err.println("OTP time has been expired");
		System.out.println("Want to genrate new OTP yes / no");
		String decisions = scanner.next();

		if (decisions.equals("yes")) {
			// Generate a new OTP after expiry
			otp = generateOTP();
			System.out.println("New OTP: " + otp);
			System.out.println("please enter the OTP");
			String checkotp = scanner.next();

			if (checkotp.equals(otp)==true) {
				System.out.println("entred OTP is correct");
			}
			
			else if(checkotp.equals(otp) == false){
				System.out.println("entred OTP is wrong");
			}
		}
		
		else if (decisions.equals("no")) {
			System.out.println("Ok!...Thankyou");
		}
	}
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws InterruptedException {
		String otp = generateOTP();
		System.out.println("OTP: " + otp);

		// check weather the user entered otp is true or not
		System.out.println("please enter the OTP you has been recived");
		boolean answer = checkOtp(scanner.next(), otp);

		// Wait for 30 seconds before expiring
		Thread.sleep(time * 1000);
		decision(otp);

	}
}

