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
    	/*File inputFile = new File("input.txt");
    	Scanner in = new Scanner(inputFile);
    	PrintWriter out = new PrintWriter("output.txt");
    	String tempToken;
    	ArrayList allNames = new ArrayList();
    	ArrayList allNumbers = new ArrayList();
    	boolean isUppercase = false;*/
    	boolean isUppercase;
    	File inputFile;
    	Scanner in;
    	PrintWriter out;
    	String tempToken;
    	ArrayList allNames = new ArrayList();
    	ArrayList allNumbers = new ArrayList();
    	if(args[0].toUpperCase().equals("-u".toUpperCase()))
    	{
    		isUppercase = true;
    		inputFile = new File(args[1]);
    		out = new PrintWriter(args[2]);
    	}
    	else
    	{
        	inputFile = new File(args[0]);
        	in = new Scanner(inputFile);
        	out = new PrintWriter(args[1]);
        	isUppercase = false;

    	}
    	in = new Scanner(inputFile);

    	while(in.hasNext())
    	{
    		tempToken = in.next();
    		if(!isNumeric(tempToken))
    		{
    			allNames.add(tempToken);
    		}
    		else
    		{
    			allNumbers.add(tempToken);
    		}
    	}
    	
    	int numberCounter = 0;
    	
    	for(int i = 0; i < allNames.size(); i += 2)
    	{
    		if(isUppercase)
    		{
        		out.print(allNames.get(i).toString().toUpperCase() + " " + allNames.get(i+1).toString().toUpperCase() + " ");
    		}
    		else
    		{
    			out.print(convertToTitleCaseIteratingChars(allNames.get(i).toString() + " " + allNames.get(i + 1)) + " ");
    		}
    		out.println(allNumbers.get(numberCounter));
    		numberCounter++;
    	}
    	in.close();
    	out.close();
        // Finally, add code to read the filenames as arguments from the command line.

        System.out.println("hello mate");
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