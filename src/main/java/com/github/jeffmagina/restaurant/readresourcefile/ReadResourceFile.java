package com.github.jeffmagina.restaurant.readresourcefile;

import java.io.*;
import java.util.ArrayList;

public class ReadResourceFile {

    public ArrayList<String> message = new ArrayList<>();

    public void readFile(String fileName) throws IOException
    {
     FileInputStream inputStream=null;
     
     try {
      // Getting ClassLoader obj
      ClassLoader classLoader = this.getClass().getClassLoader();
      // Getting resource(File) from class loader
      File configFile=new File(classLoader.getResource(fileName).getFile());
     
      inputStream = new FileInputStream(configFile);
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      String line;
      while ((line = reader.readLine()) != null) {
        this.message.add(line);
      }
      reader.close();
     } catch (FileNotFoundException e) {
      e.printStackTrace();
     }catch (IOException e) {
      e.printStackTrace();
     }
     finally {
      inputStream.close();
     }
    }
}