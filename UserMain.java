package jdbc_prc_userdb1;

import java.util.Scanner;

public class UserMain {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean exit = true;
		User user = new User();
		UserOperation operation = new UserOperation();
		do {
			System.out.println("Enter the choice \n1.signup \n2.login");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				try {
					System.out.println("Enter id ");
					int id = scanner.nextInt();
					System.out.println("Enter username");
					String username = scanner.next();
					System.out.println("Enter email");
					String email = scanner.next();
					System.out.println("Enter password");
					String password = scanner.next();
					System.out.println("Enter address");
					String address = scanner.next();

					// creating user object to set values

					user.setId(id);
					user.setUsername(username);
					user.setEmail(email);
					user.setPassword(password);
					user.setAddress(address);

					// calling signup metod by creating useroperation obj

					operation.signUpUser(user);
				} catch (Exception e) {
					System.out.println("id already exists");
					System.out.println("Choose different id");
					System.out.println();
				}
			}
				break;
			case 2: {
				System.out.println("Enter email");
				String email = scanner.next();
				System.out.println("Enter password");
				String password = scanner.next();

				user.setEmail(email);
				user.setPassword(password);
				boolean b = operation.loginUser(user);
				if (b == true) {
					System.out.println("logged in succesfully\n");

					System.out.println(
							"enter choice for following \n1:create password \n2:display password \n3:Update password ");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {
						try {
							System.out.println("Enter the id & email to create password");
							int id = scanner.nextInt();
							
							String email1= scanner.next();
							System.out.println("Enter facebook password");
							String fbpassword = scanner.next();
							System.out.println("Enter instagram password");
							String instapassword = scanner.next();
							System.out.println("Enter snapchat password");
							String snappassword = scanner.next();
							System.out.println("Enter whatsapp password");
							String whatsapppassword = scanner.next();
							System.out.println("Enter twitter password");
							String twitterpassword = scanner.next();

							user.setId(id);
							user.setEmail(email1);
							user.setFbpassword(fbpassword);
							user.setInstapassword(instapassword);
							user.setSnappassword(snappassword);
							user.setWhatsapppassword(whatsapppassword);
							user.setTwitterpassword(twitterpassword);

							operation.insertPasswordUser(user);
						} catch (Exception e) {
							System.out.println("Already passwords are created");
							System.out.println();
						}
					}
						break;
					case 2: {
						System.out.println("Enetr id to display");
						int id = scanner.nextInt();
						user.setId(id);
						operation.displayUser(user);

					}
						break;
					case 3: {
						System.out.println();

						System.out.println(
								"Enter choice to update password \n1:facebook \n2:instagram \n3:snapchat \n4:whatsapp \n5:twitter");
						int choice2 = scanner.nextInt();
						switch (choice2) {
						case 1: {

							System.out.println("Enter id to update passwords");
							int id = scanner.nextInt();
							System.out.println("Enter old fbpassword to change");
							String password1 = scanner.next();
							System.out.println("Enter new password to change ");
							String fbpassword = scanner.next();
							user.setId(id);
							user.setFbpassword(fbpassword);
							operation.updateUser(user, choice2, password1);
						}
							break;
						case 2: {
							System.out.println("Enter id to update passwords");
							int id = scanner.nextInt();
							System.out.println("Enter old fbpassword to change");
							String password1 = scanner.next();
							System.out.println("Enter instapassword to change");
							String instapassword = scanner.next();
							user.setId(id);
							user.setInstapassword(instapassword);
							operation.updateUser(user, choice2, password1);
						}
							break;
						case 3: {
							System.out.println("Enter id to update passwords");
							int id = scanner.nextInt();
							System.out.println("Enter old fbpassword to change");
							String password1 = scanner.next();
							System.out.println("Enter snappassword to change");
							String snappassword = scanner.next();
							user.setId(id);
							user.setSnappassword(snappassword);
							operation.updateUser(user, choice2, password1);
						}
							break;
						case 4: {
							System.out.println("Enter id to update passwords");
							int id = scanner.nextInt();
							System.out.println("Enter old fbpassword to change");
							String password1 = scanner.next();
							System.out.println("Enter whatsppassword to change");
							String whatsapppassword = scanner.next();
							user.setId(id);
							user.setWhatsapppassword(whatsapppassword);
							operation.updateUser(user, choice2, password1);
						}
							break;
						case 5: {
							System.out.println("Enter id to update passwords");
							int id = scanner.nextInt();
							System.out.println("Enter old fbpassword to change");
							String password1 = scanner.next();
							System.out.println("Enter Twitterppassword to change");
							String twitterpassword = scanner.next();
							user.setId(id);
							user.setTwitterpassword(twitterpassword);
							operation.updateUser(user, choice2, password1);
						}
						}

					}

					}

				}

				else {
					System.out.println("Invalid credentials\n");
				}
			}
				break;

			}
		} while (exit);
		// close do while loop
	}
}
