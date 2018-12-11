package com.oranfish;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception{
        String keyword = args[0];
        System.out.println("param keyword " + keyword);
        String directory = new File("").getCanonicalPath();
        File inputDirectory = new File(directory + File.separator + "input");
        File outputFile = new File(directory + File.separator + "output.txt");
        if(outputFile.exists()){
            outputFile.delete();
        }
        outputFile.createNewFile();
        PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
        File[] inputFiles = inputDirectory.listFiles();
        for(File file : inputFiles){
            System.out.println("reading file " + file.getCanonicalPath());
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line  = null;
            while((line = reader.readLine()) != null){
                if(line.indexOf(keyword) != -1){
                    writer.println(line);
                }
            }
            writer.flush();
            reader.close();
        }
        writer.close();
        System.out.println("done");
    }
}
