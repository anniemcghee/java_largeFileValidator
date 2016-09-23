package eca.student.session1.Homework2;

import com.sun.deploy.util.StringUtils;
import eca.hidden.SimpleFileReader;

import java.io.IOException;

/**
 * Created by anmcghee on 9/18/16.
 */
public class HWMain {

    private static final String FOLDER_NAME = "data";
    private static final String HOTEL_FILENAME = "HotelName.txt";
    private static final String ATTR_FILENAME = "AttributeDesc.txt";
    private static final String MAPPING_FILENAME = "SKUGroupAttribute.txt";

    public static void main(String[] args) throws IOException
    {
        Validator htlValidator = new SimpleValidator(Integer.parseInt("15,500,000".replace(",", "")));
        Validator attrValidator = new SimpleValidator(6300);

        loadValidator(HOTEL_FILENAME, 0, htlValidator);
        loadValidator(ATTR_FILENAME, 0, attrValidator);

        for (int i = 0; i < 5; i++)
        {
            evaluateAccumulator(htlValidator, attrValidator);
        }
    }

    //loadValidator to read each file and column with the validator passed as third param
    //this method is the setup
    private static void loadValidator(String filename, int column, Validator validator) throws IOException
    {
        SimpleFileReader reader	= new SpecificFileReader(FOLDER_NAME + "/" + filename);

        String					line;
        while (null != (line = reader.readLine()))
        {
            String[]		parts		= line.split("\t");
            int				index		= Integer.parseInt(parts[column]);
            validator.setValid(index);
        }
        reader.close();
    }

    //this method is the worker
    private static void evaluateAccumulator(Validator htlValidator, Validator attribValidator) throws IOException
    {
        Accumulator	accumulator	= new Accumulator();

        //get the mapping file ready to compare
        SimpleFileReader reader	= new SpecificFileReader(FOLDER_NAME + "/" + MAPPING_FILENAME);

        String line;
        //initialize the hotel and attribute count
        int	hotel = 0;
        int	count = 0;

        //read that longass file
        while (null != (line = reader.readLine()))
        {
            //set up the line so it is an array of columns
            String[] lineArray = line.split("\\s+");

            //get the ID of the hotel and make sure it is an int
            int	hotelId = Integer.parseInt(lineArray[0]);

            if (!htlValidator.isValid(hotelId))
            {
                continue;
            }
            //get the id of the attribute from the next column and set it to an int
            int	attr = Integer.parseInt(lineArray[1]);
            if (!attribValidator.isValid(attr))
            {
                continue;
            }

            //if the hotel ID is unique and hasn't been seen before in this file
            if (hotel != hotelId)
            {
                // and if the count hasn't just been reset to 0, we start a new hotel
                if (0 != count)
                {
                    // Count only hotels with at least one attribute
                    accumulator.accumulate(count);
                }
                //preserve the hotel as the current id so next one can be checked for uniqueness
                hotel = hotelId;
                count = 1;
            }
            else
            {
                //this hotel is a repeat so let's increment the attribute count by 1
                count++;
            }
        }
        // Include the last hotel
        accumulator.accumulate(count);

        System.out.print(accumulator.toString());
    }

}
    //all file names as static strings - including MAPPING FILE
    //main calls evaluateAccumulator


    //evaluateAccumulator method take htlValidator, attrValidator
    //instantiates simple accumulator (sum / count) and new filtered file reader that takes SKU group

    // two ints - hotel id and count
    //read line in SKU group - is it valid? if not skip line withe conitnue
    //hotelTemp is stored - if it made it through validators

    //if hotel != hotelTemp
        //if 0 != count
        //accumulate (count) store the old
        //hotel = hotelTemp
        //count = 0

    //offset validator handles high indexes
    //ListValidator sets validator ranges in
    //Linear answer -> O of n

    //OLD SOLUTION
//    public static void main(String[] args) throws IOException
//    {
//        int[] hotelList = HotelValidator.getValidHotels();
//        int[] attrList = AttributeValidator.getValidAttributes();
//
//        String		groupFile	= "out/production/Java103/data/SKUGroupAttribute.txt";
//        SpecificFileReader groupReader = new SpecificFileReader(groupFile);
//
//        String line;
//        int[] groupList = new int[0];
//
//        //index of array is hotel ID -
//        //zip arrays into arraylist
//        //if hotel id is matched, count it
//        //  count number of times it exists in arraylist[i][1] WITH valid attr as [1]
//        //  store number of attr in another array
//        //  AVERAGE = anotherArray.length / hotelId count
//    }
//}