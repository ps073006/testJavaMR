package FrameMethod;

public class MRList{
	private String TraditionalMutant;
	private String Mutantname;
	private String MRName;
	private boolean result;
	public MRList(String TraditionalMutant, String Mutantname, String MRName, boolean result) {
		this.TraditionalMutant = TraditionalMutant;
		this.Mutantname = Mutantname;
	    this.MRName = MRName;
	    this.result = result;
	}
	public String toTraditionalMutant() {
        return this.TraditionalMutant;//,this.MRName,this.result;
    }

	 public String toMutantname() {
	        return this.Mutantname;//,this.MRName,this.result;
	    }
	
	public String toMRName() {
        return this.MRName;//,this.MRName,this.result;
    }
	public String toresult() {
        return String.valueOf(this.result);//,this.MRName,this.result;
    }
}