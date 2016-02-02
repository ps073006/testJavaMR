package FrameMethod;
import static org.junit.Assert.*;
import org.junit.Test;
import Test.MethodCollection2;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.apache.commons.io.*;



public class TestAllMethods {
	private static void generateCSV(String sFileName, MRList[] list){
		try
		{   
			//String sFileName = "c:\\MRtest\\Add_values.csv";
			FileWriter writer = new FileWriter(sFileName,true);
		    File file = new File(sFileName);
		    if ( !file.exists() )
	            file.createNewFile();
		    
		    writer.append("TraditionalMutant");
		    writer.append(',');
		    writer.append("Mutantname");
		    writer.append(',');
		    writer.append("MRName");
		    writer.append(',');
		    writer.append("result");
		    writer.append('\n');

		   for(Object d:list){
			   MRList MRList = (MRList) d;
			    writer.append(MRList.toTraditionalMutant());
			    writer.append(',');
			   	writer.append(MRList.toMutantname());
			    writer.append(',');
			    writer.append(MRList.toMRName());
			    writer.append(',');
			    writer.append(MRList.toresult());
			    writer.append('\n');
		   }
		   //generate whatever data you want
				
		    writer.flush();
		    writer.close();
			
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		}		
	}

	 @Test
		public void  Add_values(){
		 File source =new File("C:\\Users\\ps\\workspace\\testJava\\traditional_mutants\\int_add_values(int)\\");
		 File target =new File("src//test//");
		 String sFileName = "c:\\MRtest\\Add_values.csv";
		 File file = new File(sFileName);
		    if (file.exists())
		    	file.delete();
		// System.out.print(source.listFiles().length);
		 String[] names = source.list();
		 MRList[] list = new MRList[6]; //no of MR used
		 //try {

			// for(String name : names)
			//	 { 
			 	String name = "";
				source = new File(source+"\\"+name);
				//FileUtils.copyDirectory(source, target);
				int[] a = FrameMethod.getIntArray();
				//boolean result = true;
				int sum = 0;
				
				
				sum = MethodCollection2.add_values(a);
				//Addition MR
				list[0] =new MRList(name,"Add_values","Addition", FrameMethod.Addition(a,sum));
				
				//Permutation MR
				list[1] =new MRList(name,"Add_values","Permutation", FrameMethod.Permutation(a, sum));
				//result = FrameMethod.Permutation(a);
				
				//Multiplication MR	
				list[2] =new MRList(name,"Add_values","Multiplication", FrameMethod.Multiplication(a, sum));
						//result = FrameMethod.Multiplication(a);	 				
				
				//Inclusive MR
				list[3] =new MRList(name,"Add_values","Inclusive", FrameMethod.Inclusive(a, sum));
						//result = FrameMethod.Inclusive(a);
				
				//Exclusive MR
				list[4] =new MRList(name,"Add_values","Exclusive", FrameMethod.Exclusive(a, sum));
						//result = FrameMethod.Exclusive(a);
				
				//Inversion MR
				list[5] =new MRList(name,"Add_values","Inversion", FrameMethod.Inversion(a, sum));
						//result = FrameMethod.Inversion(a);
	
				//generateCSV(sFileName,list);
				// source =new File("C:\\Users\\ps\\workspace\\testJava\\traditional_mutants\\int_add_values(int)\\");
				// }
			// } catch (IOException e) {
				 //TODO Auto-generated catch block
			//	e.printStackTrace();
			//}	
	}
}
