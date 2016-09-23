package eca.student.session1.Homework2;

import eca.hidden.BooleanBitArray;

import java.io.IOException;

/**
 * Created by anmcghee on 9/18/16.
 */

//setting up to mark valid hotels as TRUE at the index that corresponds with the hotel ID - other indexes are false
public class SimpleValidator implements Validator
{

    private BooleanBitArray m_bitArray;
    //CONSTRUCTOR
    public SimpleValidator(int count)
    {
        m_bitArray = new BooleanBitArray(count);
    }

    @Override
    public int getMin()
    {
        return 0;
    }

    @Override
    public int getMax()
    {
        return (int) m_bitArray.getBitCount();
    }

    @Override
    public void setValid(int index)
    {
        setValid(index, true);
    }

    @Override
    public void setValid(int index, boolean isValid)
    {
        if (m_bitArray.getBitCount() > index)
        {
            m_bitArray.set(index, isValid);
        }
    }

    @Override
    public boolean isValid(int index)
    {
        if (m_bitArray.getBitCount() > index)
        {
            return m_bitArray.get(index);
        }
        else
        {
            return false;
        }
    }

    @Override
    public int getValidCount()
    {
        return (int) m_bitArray.getSetCount();
    }
}


//OLD SOLUTION - not a boolean array :(
//public class AttributeValidator {
//
//    public static int[] getValidAttributes() throws IOException {
//        String		attrFile	= "out/production/Java103/data/AttributeDesc.txt";
//        SpecificFileReader attrReader = new SpecificFileReader(attrFile);
//
//        String attrLine;
//
//        int[] attrList = new int[0];
//        while (null != (attrLine = attrReader.readLine())) {
//            if ('#' != attrLine.charAt(0)) {
//                String[] attrDesc = attrLine.split("\\s+");
//                String attrString = attrDesc[0];
//                int attrId = Integer.parseInt(attrString);
//                attrList = Accumulator.addId(attrList, attrId);
//            }
//        }
//        return attrList;
//    }
//}
