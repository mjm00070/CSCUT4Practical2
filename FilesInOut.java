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
    	File inputFile = new File("input.txt");
    	Scanner in = new Scanner(inputFile);
    	PrintWriter out = new PrintWriter("output.txt");
    	String tempToken;
    	ArrayList allNames = new ArrayList();

    	while(in.hasNext())
    	{
    		tempToken = in.next();
    		if(!isNumeric(tempToken))
    		{
    			allNames.add(tempToken);
    			//out.println(tempToken.toUpperCase());

    		}
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

} // FilesInOut