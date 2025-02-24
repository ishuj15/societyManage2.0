package com.presentarion.resident.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.Model.User;
import com.controller.MasterController;
import com.controller.UserController;
import com.util.Helper;
import com.util.str;

public class UserManagementMenu {
	private final MasterController masterController;
	private Scanner scanner;

	public UserManagementMenu() {

		this.masterController = new MasterController();
		this.scanner = new Scanner(System.in);
	}

	public boolean displayMenu(User user) throws SQLException, ClassNotFoundException {
		
		while (true) {
		
			Helper.printFunction(str.manageAccount);

				int choice= Helper.choiceInput(6);

			switch (choice) {
			case 1: {
				UserController.deleteUser(user);
				return false;

			}
			case 2: {
				masterController.userController.updateUser(user);
				break;
			}
			case 3: {
				masterController.userController.viewUser(user.getUserName());
				break;
			}
			case 4:
				return true;
			case 5: {

				return false;
			}
			case 6: {
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
