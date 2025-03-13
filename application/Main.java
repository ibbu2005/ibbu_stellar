import java.util.Scanner;

//initialized 
public class Main {//main class
	//defining Student class to store student data
    static class Patient {//inner class
	        int id;
	        String name;
	        String email;

	        Patient(int id, String name,String email) {//created a conctructor 
	            this.id = id;
	            this.name = name;
	            this.email=email;
	        }

	        @Override
	        public String toString() {
	            return "ID: " + id + ", Name: " + name+", Email: "+email;
	        }
	    }

	    static Patient s[] = new Patient[100]; //we are going to store 100datas
	    static int patientCount = 0;//tracking the count of student

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int choice;//
	        do {
	            System.out.println("\n--- Patient Management System ---");
	            System.out.println("1. Add Patient");
	            System.out.println("2. View Patient");
	            System.out.println("3. Delete Patient");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            sc.nextLine(); 

	            switch (choice) {
	                case 1:
	                    addPatient(sc);//method 
	                    break;
	                case 2:
	                    viewPatient();
	                    break;
	                case 3:
	                    deletePatient(sc);
	                    break;
	                case 4:
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (choice != 4);

	        sc.close();
	    }

	    private static void addPatient(Scanner scanner) {
	        System.out.print("Enter Patient ID: ");
	        int id = scanner.nextInt();
	        scanner.nextLine(); 
	        System.out.print("Enter Patient Name: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter Patient Email: ");
	        String email = scanner.nextLine();
	        s[patientCount++] = new Patient(id, name,email);
	        System.out.println("Patient added successfully.");
	    }

	    private static void viewPatient() {
	        if (patientCount == 0) {
	            System.out.println("No Patient found.");
	        } else {
	            System.out.println("\n--- List of Patient ---");
	            for (int i = 0; i < patientCount; i++) {
	                System.out.println(s[i]);//students[0],students[1],students[2]
	            }
	        }
	    }

	    private static void deletePatient(Scanner scanner) {
	        if (patientCount == 0) {
	            System.out.println("No Patient to delete.");
	            return;
	        }

	        System.out.print("Enter Patient ID to delete: ");
	        int id = scanner.nextInt();
	        boolean found = false;

	        for (int i = 0; i < patientCount; i++) {
	            if (s[i].id == id) {
	                for (int j = i; j < patientCount - 1; j++) {
	                    s[j] = s[j + 1];//students[0]=students[0+1];
	                }
	                s[--patientCount] = null; 
	                found = true;
	                System.out.println("Patient deleted successfully.");
	                break;
	            }
	        }
	        if (!found) {
	            System.out.println("Patient with ID " + id + " not found.");
	        }
	    }
	}