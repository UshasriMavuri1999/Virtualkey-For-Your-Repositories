package simplilearn.Virtualkey_For_Your_Repositories;

import java.io.File;
import java.io.IOException;

public class Operations implements BusinessLevelOperations{

	@Override
	public void addAFile(String filename, File filepath) throws IOException {
		String[] lst = App.folderName.list();
        for (String file: lst) {
            if (filename.equalsIgnoreCase(file)) {
                System.out.println("File " + filename + " already exists at " + App.folderName);
                return;
            }
        }
        filepath.createNewFile();
        System.out.println("File "+filename+" added to "+ App.folderName);
		
	}

	@Override
	public void deleteAFile(String filename, File filepath) {
        String[] lst = App.folderName.list();
        for (String file: lst) {
            if (filename.equals(file) && filepath.delete()) {
                System.out.println("File " + filename + " deleted from " + App.folderName);
                return;
            }
        }
        System.out.println("Delete Operation failed. FILE NOT FOUND");
		
	}

	@Override
	public void searchAFile(String filename) {
		String[] lst = App.folderName.list();
        for (String file: lst) {
            if (filename.equals(file)) {
                System.out.println("FOUND : File " + filename + " exists at " + App.folderName);
                return;
            }
        }
        System.out.println("Search Operation failed. File NOT found");
		
	}	
	
}
