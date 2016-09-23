/**
 * Copyright 2016 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package eca.student.session1.Homework2;

import eca.hidden.SimpleFileReader;

import java.io.File;
import java.io.IOException;

public class LineCounter
{
	public static void main(String[] args) throws IOException
	{
		String		folderName	= "out/production/Java103/data";
		File		folder		= new File(folderName);
		File[]		fileList	= folder.listFiles();
		if (null == fileList)
		{
			System.out.println("No file found.");
			return;
		}
		System.out.println(String.format("File count found: %,2d", fileList.length));

		for(int i = 0; i < fileList.length; i++) {
			File file = fileList[i];
			String fileName = file.getName();
			int lineCount = countLines(folderName, fileName);
			System.out.println(lineCount);
		}
	}

	private static int countLines(String folderName, String filename) throws IOException
	{
		SimpleFileReader		reader		= new SimpleFileReader(folderName + "/" + filename);
		int						count		= 0;

		String line;
		while (null != (line = reader.readLine())) {
		//use line
		//optimizing for debugging
		count++;
	}

		reader.close();

		return count;
	}
}

//public class Homework2 has the main

//extend simple file reader
//overwrite readline() to filter out blank lines and lines that start with #

//create a new class read file HotelName.txt to find valid hotel ID using string.parse and string.split - int.parseInt -> string to number
//method - check for valid hotel id - if it's the list set it to true
//use array and bool

//create another class that finds valid attributes (AttrValidator)
//use set<Integer>

//someone opens the SKUGroupAttribute

//Accumulator class / Average class /

//create a class that manages the average

//create another class to evaluate valid hotel vs valid attirbute
//find the average
//check for valid hotels - if not move on, if so see how many attributes there are and check for validity and return number of valid
//use continue if they're not valid
//check for valid attributes