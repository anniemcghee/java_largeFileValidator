package eca.student.session1.Homework2;

import java.io.IOException;

/**
 * Created by anmcghee on 9/18/16.
 */
public class Accumulator
{
    private long		m_sum;
    private int			m_count;

    public Accumulator()
    {
        reset();
    }
    public void reset()
    {
        m_sum = 0;
        m_count = 0;
    }

    //this method keeps track of instances of hotelId with valid attributes so average can be calculated
    public void accumulate(int value)
    {
        m_sum += value;
        m_count++;
    }

    public int getCount()
    {
        return m_count;
    }
    // multiplying by 1.0 ensures you're working with a double
    public double getAverage()
    {
        return m_sum * 1.0 / m_count;
    }

    @Override
    public String toString()
    {
        return String.format("%,d/%,d = %.3f", m_sum, m_count, getAverage());
    }
}

//OLD SOLUTION using int array not boolean array
//    public static int[] addId(int [] list, int newId) throws IOException {
//
//        int[] newSeries = new int[list.length + 1];
//
//        for (int i = 0; i < list.length; i++) {
//            newSeries[i] = list[i];
//        }
//
//        newSeries[newSeries.length - 1] = newId;
//
//        return newSeries;
//    }