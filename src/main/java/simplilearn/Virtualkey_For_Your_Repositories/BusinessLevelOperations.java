package simplilearn.Virtualkey_For_Your_Repositories;

import java.io.File;
import java.io.IOException;

public interface BusinessLevelOperations {
	void addAFile(String filename, File filepath) throws IOException;
	void deleteAFile(String filename, File filepath);
	void searchAFile(String filename);
}
