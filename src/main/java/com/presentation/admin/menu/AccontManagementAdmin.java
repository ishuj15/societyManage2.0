package com.presentation.admin.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.Model.User;
import com.controller.UserController;
import com.util.Helper;
import com.util.str;

public class AccontManagementAdmin {
	private Scanner scanner;
	private UserController userController;

	public AccontManagementAdmin() {
		this.userController = new UserController();
		this.scanner = new Scanner(System.in);
	}

	public boolean displayMenu(User user) throws SQLException, ClassNotFoundException {

		while (true) {

			Helper.printFunction(str.accountManagementAdmin);

				int choice= Helper.choiceInput(8);
			switch (choice) {
			case 1: {
				UserController.createUser();
				break;
			}
			case 2: {
				User user2 = userController.getUserByadmin();
				userController.deleteUser(user2);
				break;
			}
			case 3: {
				userController.listUsers();
				break;
			}
			case 4: {
				Helper.printFunction(str.enterUserName);
				String userName = scanner.nextLine();
				userController.viewUser(userName);
				break;
			}
			case 5: {
				User user2 = userController.getUserByadmin();
				userController.updateUser(user2);
				break;
			}
			case 6:
				return true;
			case 7:
				return false;
			case 8: {
				scanner.close();
				System.exit(0);
				return false;
			}
			default:
				 Helper.printFunction(str.invalidInput);
			}
		}
	}
}
