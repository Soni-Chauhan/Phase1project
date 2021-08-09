package lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyMain 
{
	static final String folderpath="C:\\Users\\hi\\Desktop\\fsdproject\\LockerFiles";
	public static void main(String[] args) 
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
		
		obj.close();
	}

}