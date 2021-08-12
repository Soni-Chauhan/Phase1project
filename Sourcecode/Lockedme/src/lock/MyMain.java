package lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyMain 
{	
	//folder path 
	static final String folderpath="C:\\Users\\hi\\Desktop\\fsdproject\\LockerFiles";
	public static void main(String[] args) 
	{
		int proceed=1;
		
		do
		{
			int ch;
			
			ch=displayMenu();
			
			switch(ch)
			{
				case 1 : getAllFiles();
							break;
				case 2 : createFile();
							break;
				case 3 : deleteFile();
							break;
				case 4 : searchFile();
							break;
				case 5 : System.exit(0);
							break;
				default : System.out.println("Invalid Option");
							break;
			}
			
		}
		while(proceed>0);
	}
	
	//display method to display options
	public static int displayMenu()
	{
		Scanner obj = new Scanner(System.in);
		int ch;
		System.out.println("====================================================");
		System.out.println("**************LockedMe Project**********************");
		System.out.println("====================================================");
		System.out.println("1. Display all Files");
		System.out.println("2. Create new File");
		System.out.println("3. Delete a File");
		System.out.println("4. Search a File");
		System.out.println("5. Exit");
		System.out.println("====================================================");
		System.out.println("Enter your choice:");
		ch=Integer.parseInt(obj.nextLine());
		
		
		return ch;
		
		
	}
	
	//get method()  to get all files which are present
	public static void getAllFiles()
	{
		List<String> fileName = MainManager.getAllFiles(folderpath);
		
		for(String f:fileName)
			System.out.println(f);
	}
	
	//method to create files
	public static void createFile()
	{
		Scanner obj = new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String> content = new ArrayList<String>();
		
		System.out.println("Enter File Name:");
		fileName=obj.nextLine();
		
		System.out.println("Enter number of lines in file:");
		linesCount=Integer.parseInt(obj.nextLine());
		
		for(int i=1;i<=linesCount;i++)
		{
			System.out.println("Enter data "+i+":");
			content.add(obj.nextLine());
		}
		
		boolean isSaved = MainManager.createFile(folderpath, fileName, content);
		
		if(isSaved)
			System.out.println("File and data saved");
		else
			System.out.println("Error occured");
		
		
	}
	
	//method to delete the file
	public static void deleteFile()
	{
		String fileName;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter file name to be deleted:");
		fileName=obj.nextLine();
		
		boolean isDeleted = MainManager.deleteFile(folderpath, fileName);
		
		if(isDeleted)
			System.out.println("File is deleted");
		else
			System.out.println("File not found or Some issue occured");
		
	}
	
	//method to search file 
	public static void searchFile()
	{
		String fileName;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter file name to be searched:");
		fileName=obj.nextLine();
		
		boolean isSearched = MainManager.searchFile(folderpath, fileName);
		
		if(isSearched)
			System.out.println("File is present");
		else
			System.out.println("File not found or Some issue occured");
		
		
	}
	
}
