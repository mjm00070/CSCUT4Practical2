import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;
import java.lang.Object;

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut
{	
    public static void main(String[] args) throws FileNotFoundException
    {    	
    	boolean isUppercase;
    	File inputFile;
    	Scanner in;
    	PrintWriter out;
    	String tempToken;
    	ArrayList<String> allNumbers = new ArrayList<String>();
    	ArrayList<ArrayList<String>> groupedNames = new ArrayList<ArrayList<String>>();
    	if(args[0].toUpperCase().equals("-u".toUpperCase())) //if "-u" is given as a parameter
    	{
    		isUppercase = true;
    		inputFile = new File(args[1]);
    		out = new PrintWriter(args[2]);
    	}
    	else
    	{
    		isUppercase = false;
        	inputFile = new File(args[0]);
        	in = new Scanner(inputFile);
        	out = new PrintWriter(args[1]);
    	}
    	in = new Scanner(inputFile);
    	
    	int lineCounter = 0;
    	while(in.hasNextLine())
    	{
    		tempToken = in.next();
    		groupedNames.add(new ArrayList<String>()); //A new arraylist is added to groupedNames for each line in the input file
    		while(!isNumeric(tempToken)) //Checks every name on the current line
    		{
    			groupedNames.get(lineCounter).add(tempToken); //Adds the name to the arraylist
    			tempToken = in.next();
    		}
    		if(isNumeric(tempToken))
    		{
    			allNumbers.add(tempToken); //Adds the phone number to allNumbers
    		}
    		lineCounter++;
    	}
    	
    	for(int i = 0; i < allNumbers.size(); i++)
    	{
    		if(isUppercase)
    		{
    			if(groupedNames.get(i).size() > 2) //If the person has more than 2 names
    			{
    				out.print(groupedNames.get(i).get(0).toUpperCase() + " " + groupedNames.get(i).get(1).toUpperCase()
    						+ ". " + groupedNames.get(i).get(2).toUpperCase() + " ");
    			}
    			else
    			{
    				out.print(groupedNames.get(i).get(0).toUpperCase() + " " + groupedNames.get(i).get(1).toUpperCase() + " ");
    			}
    		}
    		else
    		{
    			if(groupedNames.get(i).size() > 2) //If the person has more than 2 names
    			{
    				out.print(convertToTitleCaseIteratingChars(groupedNames.get(i).get(0) + " " + groupedNames.get(i).get(1) + ". "
    						+ groupedNames.get(i).get(2)) + " ");
    			}
    			else
    			{
    				out.print(convertToTitleCaseIteratingChars(groupedNames.get(i).get(0) + " " + groupedNames.get(i).get(1)) + " ");
    			}
    		}
    		out.println(allNumbers.get(i));
    	}

    	in.close();
    	out.close();

        System.out.println("Program has been executed");
    } // main

    public static boolean isNumeric(String strNum)
    {
        if (strNum == null)
        {
            return false;
        }
        try
        {
            double d = Double.parseDouble(strNum);
        }
        catch (NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
    
    public static String convertToTitleCaseIteratingChars(String text)
    {
        if (text == null || text.isEmpty())
        {
            return text;
        }

        StringBuilder converted = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray())
        {
            if (Character.isSpaceChar(ch))
            {
                convertNext = true;
            }
            else if (convertNext)
            {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            }
            else
            {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }

        return converted.toString();
    }

} // FilesInOut