package eca.student.session1.Homework2;

import eca.hidden.SimpleFileReader;

import java.io.IOException;

/**
 * Created by anmcghee on 9/19/16.
 */
public class SpecificFileReader extends SimpleFileReader {
//YOU MUST EXTEND CONSTRUCTOR - INTELLIJ SHOULD DO THIS
        public SpecificFileReader(String filename) throws IOException
        {
            super(filename);
        }

        @java.lang.Override
        public String readLine() throws IOException {

            String line;

            //if i call you, ask the other guy to read the line
            while (null != (line = super.readLine())) {
                if (line.isEmpty() || line.startsWith("#"))
                {
                    continue;
                }
                break;
            }
            return line;
            //One return statement per method because of debugging
        }
    }
