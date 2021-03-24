package simplilearn.Virtualkey_For_Your_Repositories;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class App {
	Scanner scan = new Scanner(System.in);
	private static String directory;
    static File folderName;

    public App() {
        directory = System.getProperty("user.dir");
        folderName = new File(directory+"/files");
        if (!folderName.exists())
            folderName.mkdirs();
        System.out.println("CURRENT DIRECTORY : "+ folderName.getAbsolutePath());
    }

	private void showMenu() {
			 	try {
					int option = getOption();

						switch (option){
					
							case 1 :
								showFiles();
								break;
							case 2 : 
								showBusinessLevelOperations();
								break;
							case 3 :
								System.out.println("-------------- Thank You --------------");
								System.exit(0);
							default: 
								System.out.println("Please enter any of these options: 1, 2 or 3");
					            
						}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					showMenu();
				}
			 	showMenu();

	}

	private void showFiles() {
		if (folderName.list().length==0)
            System.out.println("The folder is empty");

        else {
            String[] fileList = folderName.list();
            System.out.println("The files in "+ folderName +" are :");
            Arrays.sort(fileList);
            for (String st:fileList) {
                System.out.println(st);
            }
        }
		
	}

	private void showBusinessLevelOperations() {
            try {
				int choice = getOperationChoice();   
				BusinessLevelOperations op = new Operations();
				switch (choice){
				    case 1 :{
				        System.out.print(" Adding a file. Please Enter a File Name : ");
				        String filename = scan.next().trim().toLowerCase();
				        File filepath = new File(folderName +"/"+filename);
				        op.addAFile(filename, filepath);
				        break;}
				    case 2 :{
				        System.out.print(" Deleting a file. Please Enter a File Name : ");
				        String filename = scan.next().trim();
				        File filepath = new File(folderName +"/"+filename);
				        op.deleteAFile(filename,filepath);
				        break;}
				    case 3 :{
				        System.out.print(" Searching a file. Please Enter a File Name : ");
				        String filename = scan.next().trim();
				        op.searchAFile(filename);
				        break;}
				    case 4 :
				        System.out.println("Going Back to MAIN MENU");
				        showMenu();
				        break;
				    default : 
				    	System.out.println("Please enter any of these options: 1, 2, 3 or 4");
				    	showBusinessLevelOperations();
				    	break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
		    	showBusinessLevelOperations();
			} 
            showBusinessLevelOperations();
	}

	private int getOperationChoice() {
		System.out.println("   \nSelect your choice: \n"+"  1. Add a file\n"+"  2. Delete a file\n"+"  3. Search a file\n"+"  4. GoBack");
		return scan.nextInt();
		
	}

	private int getOption() {
		System.out.println("\nEnter your choice: \n"+"1. List all the files in current directory(ascending order)\n"+"2. Business level Operations\n"
				+"3. Exit Application");
        return scan.nextInt();
		
	}

	private static String welcomeMessage() {
		String developer = "Ushasri Mavuri";
		String company = "TEKsystems Global Services Private Limited";
		return "Developer\t"+developer+"\n"+"Company \t"+company;
	}
	
	public static void main(String[] args) {
		System.out.println("****************  Welcome to LockedMe.com  ***************\n");
		System.out.println("------------------------------\n");
		System.out.println(welcomeMessage());
		System.out.println("\n------------------------------");
        App app = new App();
        app.showMenu();
	}

}
