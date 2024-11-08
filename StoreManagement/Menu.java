pacckage storeManagement;

public class Menu{
    static public void OutMenu() {
        System.out.print("---- Menu ---- \n");
        System.out.print("0. Exit\n");
        System.out.print("1. Employee\n");
        System.out.print("2. Customer\n");
        System.out.print("3. Product\n");
        System.out.print("-----------------\n");
        System.out.print("Your choice: ");
    }

    static public void showEmployeeOptions() {
        System.out.print("---- Employee Options ---- \n");
        System.out.print("1. Add new employee\n");
        System.out.print("2. Remove employee\n");
        System.out.print("3. Show employees\n");
        System.out.print("4. Find employee\n");
        System.out.print("-------------------------\n");
        System.out.print("Your choice: ");
    }

    static public void showCustomerOptions() {
        System.out.print("---- Customer Options ---- \n");
        System.out.print("1. Add new customer\n");
        System.out.print("2. Remove customer\n");
        System.out.print("3. Show customers\n");
        System.out.print("4. Find customer\n");
        System.out.print("-------------------------\n");
        System.out.print("Your choice: ");
    }

    static public void showProductOptions() {
        System.out.print("---- Product Options ---- \n");
        System.out.print("1. Add new product\n");
        System.out.print("2. Remove product\n");
        System.out.print("3. Show products\n");
        System.out.print("3. Find product\n");
        System.out.print("-------------------------\n");
        System.out.print("Your choice: ");
    }
}


/*    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            OutMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showEmployeeOptions();
                    break;
                case 2:
                    showCustomerOptions();
                    break;
                case 3:
                    showProductOptions();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // Handle sub-menu choices here (for employee, customer, product)
            if (choice >= 1 && choice <= 3) {
                int subChoice = scanner.nextInt();
                switch (choice) {
                    case 1: // Employee
                        handleEmployeeChoice(subChoice);
                        break;
                    case 2: // Customer
                        handleCustomerChoice(subChoice);
                        break;
                    case 3: // Product
                        handleProductChoice(subChoice);
                        break;
                }
            }

        } while (choice != 0);
        
        scanner.close();
    }

    private static void handleEmployeeChoice(int subChoice) {
        switch (subChoice) {
            case 1:
                System.out.println("Adding new employee...");
                break;
            case 2:
                System.out.println("Removing employee...");
                break;
            case 3:
                System.out.println("Showing employees...");
                break;
            default:
                System.out.println("Invalid choice for employee options.");
        }
    }

    private static void handleCustomerChoice(int subChoice) {
        switch (subChoice) {
            case 1:
                System.out.println("Adding new customer...");
                break;
            case 2:
                System.out.println("Removing customer...");
                break;
            case 3:
                System.out.println("Showing customers...");
                break;
            default:
                System.out.println("Invalid choice for customer options.");
        }
    }

    private static void handleProductChoice(int subChoice) {
        switch (subChoice) {
            case 1:
                System.out.println("Adding new product...");
                break;
            case 2:
                System.out.println("Removing product...");
                break;
            case 3:
                System.out.println("Showing products...");
                break;
            default:
                System.out.println("Invalid choice for product options.");
        }
    }
} */