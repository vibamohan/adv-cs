import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Company> companies = new ArrayList<>();
        Company microsoft = new Company("Microsoft", 110.47);
        Company google = new Company("Google", 1172.10);
        Company apple = new Company("Apple", 219.89);

        companies.add(microsoft);
        companies.add(google);
        companies.add(apple);

        ArrayList<Pair<Employee, Company>> employees = new ArrayList<>();
        employees.add(new Pair<>(new Employee("John"), microsoft));
        employees.add(new Pair<>(new Employee("Jose"), google));
        employees.add(new Pair<>(new Employee("Jennifer"), google));
        employees.add(new Pair<>(new Employee("Heather"), apple));
        employees.add(new Pair<>(new Employee("Maria"), apple));

        OUTER:
        while (true) {
            printMenu();
            int choice = readInt(scanner, "Choose an option: ");
            switch (choice) {
                case 1 -> displayEmployees(employees);
                case 2 -> updateCompanyStock(scanner, companies);
                case 3 -> addCompany(scanner, companies);
                case 4 -> changeEmployeeCompany(scanner, employees, companies);
                case 5 -> {
                    System.out.println("Goodbye!");
                    break OUTER;
                }
                default -> System.out.println("Invalid option.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("1. Display employees and companies");
        System.out.println("2. Update a company's stock price");
        System.out.println("3. Add a new company");
        System.out.println("4. Change an employee's company");
        System.out.println("5. Quit");
    }

    private static void displayEmployees(ArrayList<Pair<Employee, Company>> employees) {
        for (Pair<Employee, Company> employeeCompany : employees) {
            System.out.println(employeeCompany);
        }
    }

    private static void updateCompanyStock(Scanner scanner, ArrayList<Company> companies) {
        System.out.print("Company name: ");
        String companyName = scanner.nextLine();
        Company company = findCompany(companies, companyName);

        if (company == null) {
            System.out.println("Company not found.");
            return;
        }

        double stockPrice = readDouble(scanner, "New stock price: ");
        company.updateStockPrice(stockPrice);
        System.out.println("Stock price updated.");
    }

    private static void addCompany(Scanner scanner, ArrayList<Company> companies) {
        System.out.print("New company name: ");
        String companyName = scanner.nextLine();

        if (findCompany(companies, companyName) != null) {
            System.out.println("That company already exists.");
            return;
        }

        double stockPrice = readDouble(scanner, "Stock price: ");
        companies.add(new Company(companyName, stockPrice));
        System.out.println("Company added.");
    }

    private static void changeEmployeeCompany(
            Scanner scanner,
            ArrayList<Pair<Employee, Company>> employees,
            ArrayList<Company> companies) {
        System.out.print("Employee name: ");
        String employeeName = scanner.nextLine();
        Pair<Employee, Company> employeeCompany = findEmployeePair(employees, employeeName);

        if (employeeCompany == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("New company name: ");
        String companyName = scanner.nextLine();
        Company company = findCompany(companies, companyName);

        if (company == null) {
            System.out.println("Company not found.");
            return;
        }

        employeeCompany.setValue(company);
        System.out.println("Employee company updated.");
    }

    private static Company findCompany(ArrayList<Company> companies, String name) {
        for (Company company : companies) {
            if (company.getName().equalsIgnoreCase(name)) {
                return company;
            }
        }

        return null;
    }

    private static Pair<Employee, Company> findEmployeePair(
            ArrayList<Pair<Employee, Company>> employees,
            String name) {
        for (Pair<Employee, Company> employeeCompany : employees) {
            if (employeeCompany.getKey().getName().equalsIgnoreCase(name)) {
                return employeeCompany;
            }
        }

        return null;
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }

            System.out.println("Please enter a whole number.");
            scanner.nextLine();
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            }

            System.out.println("Please enter a number.");
            scanner.nextLine();
        }
    }
}
