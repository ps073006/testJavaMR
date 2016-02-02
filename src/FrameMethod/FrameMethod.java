package FrameMethod;

import java.util.Arrays;
import java.util.Random;

import Test.MethodCollection2;

public class FrameMethod {
	
	public static Random rand = new Random();
	public static int Const_INT = getInt();
	public static final	int MAX = 100;
	
	//common methods
	public static int getInt(){
		return rand.nextInt(MAX) + 1;
	}
    
	public static int[] getIntArray(){
		int size = rand.nextInt(8) + 4;
		
		return getIntArray(size);
	}
	public static int[] getIntArray(int size){	
		return rand.ints(size, 1, MAX).toArray();
	}
	
	//Addition MR methods
	public static int[] AddIntArray(int[] Initial){
		int[] Followup = new int[Initial.length];
		for(int i=0;i<Followup.length;i++){
			 //add Const_INT with each element
			Followup[i]= Followup[i] + Const_INT;	
		 }
		return Followup;	
	}
	
	public static boolean Addtest(int InitTest, int FollowupTest){
		
		return InitTest <= FollowupTest;
		
	}
	
	//Permutation MR methods
	  public static int[] PermIntArray(int[] original) {
	        int temp, index;
	        int[] permuted = Arrays.copyOf(original, original.length);
	        Random r = new Random();
	        for (int i = original.length - 1; i > 0; i--) {
	            index = r.nextInt(i+1);
	            temp = permuted[i];
	            permuted[i] = permuted[index];
	            permuted[index] = temp;
	        }
	        return permuted;
	    }
	  
	  public static boolean PermTest(int o, int n) {
	        return (o == n);
	    }
	  
	  //Multiplication MR methods
	  public static int[] MulIntArray(int[] original) {
	        int[] multiplied = new int[original.length];
	        for (int i = 0; i < original.length; i++) {
	            multiplied[i] = original[i] * Const_INT;
	        }
	        return multiplied;
	    }
	  
	  public static boolean multTest(int o, int n) { return Addtest(o, n); }
	  
	//Inclusive MR methods
	  public static int[] IncIntArray(int[] original) {
	        int[] included = new int[original.length + 1];
	        for (int i = 0; i < original.length; i++) {
	            included[i] = original[i];
	        }
	        included[original.length] = getInt(); //new final element
	        return included;
	    }
	  public static boolean incTest(int o, int n) { return Addtest(o, n); }
	//Exclusive MR methods 
	  public static int[] ExcIntArray(int[] original) {
	        int[] excluded = new int[original.length - 1];
	        for (int i = 0; i < excluded.length; i++) { //output excludes final element
	            excluded[i] = original[i];
	        }
	        return excluded;
	    }
	  public static boolean excTest(int pre, int post) {
	        return (post <= pre);
	    }
	//Inversion MR methods  
	  public static int[] InvIntArray(int[] original) {
	        int[] inverse = new int[original.length];
	        for (int i = 0; i < original.length; i++) {
	            inverse[i] = 1 / original[i]; //Integer arithmetic. Problem?
	        }
	        return inverse;
	    }
	  public static boolean invTest(int o, int n) { return excTest(o, n); }
	  
	  //MR initial and followup test case
	  //Addition
	  public static boolean Addition(int[] Original, int sum){
		  boolean result = true;		 
		  //follow up test case
		  //Addition MR
		  int sum1 = MethodCollection2.add_values(AddIntArray(Original));
		  result = FrameMethod.Addtest(sum, sum1);
		  return result;
	  }
	//Permutation
	  public static boolean Permutation(int[] Original, int sum){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Permutation MR
		  int sum1 = MethodCollection2.add_values(PermIntArray(Original));
		  result = PermTest(sum, sum1);
		  return result;
	  }
	  
	//Multiplication
	  public static boolean Multiplication(int[] Original, int sum){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Multiplication MR
		  int sum1 = MethodCollection2.add_values(MulIntArray(Original));
		  result = multTest(sum, sum1);
		  return result;
	  }
	//Inclusive
	  public static boolean Inclusive(int[] Original , int sum){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inclusive MR
		  int sum1 = MethodCollection2.add_values(IncIntArray(Original));
		  result = incTest(sum, sum1);
		  return result;
	  }
	//Exclusive
	  public static boolean Exclusive(int[] Original, int sum){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Exclusive MR
		  int sum1 = MethodCollection2.add_values(ExcIntArray(Original));
		  result = excTest(sum, sum1);
		  return result;
	  }
	//Inversion
	  public static boolean Inversion(int[] Original, int sum){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inversion MR
		  int sum1 = MethodCollection2.add_values(InvIntArray(Original));
		  result = invTest(sum, sum1);
		  return result;
	  } 
}
