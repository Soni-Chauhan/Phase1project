package lock;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class MainManager 
{
	/**
	 * This method will return file name 
	 * @param folderpath
	 * @return list<String>
	 */
	public static List<String> getAllFiles(String folderpath)
	{
		File fl = new File(folderpath);
		
		File[] listofFiles = fl.listFiles();
		
		List<String> fileNames = new ArrayList<String>();
		
		for(File f:listofFiles)
			fileNames.add(f.getName());
		
		return fileNames;
	}
	
	/**
	 * This method will create file and content in it
	 * @param folderpath
	 * @param filename
	 * @param content
	 * @return boolean
	 */
	public static boolean createFile(String folderpath,String filename, List<String> content)
	{
		try
		{
			File fl = new File(folderpath, filename);
			FileWriter fw = new FileWriter(fl);
			
			for(String s:content)
			{
				fw.write(s+"\n");
			}
			fw.close();
			return true;
				
		}
		catch(Exception Ex)
		{
			return false;
		}
	}

}
