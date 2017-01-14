
public class ReturnVal {

	private int length=0;
	private String str="";

	public ReturnVal(int length, String str) {
		this.length = length;
		this.str = str;
	}

	public int getIntValue() { 
		return this.length; 
	}
	public String getStrValue() { 
		return this.str; 
	}
	
	public void setIntValue(int length) { 
		this.length = length;
	}
	public void setStrValue(String str) { 
		this.str = str;
	}
	
	public ReturnVal max(ReturnVal rtv){
		if (rtv.getIntValue()<this.getIntValue())
			return this;
		else
			return rtv;
	}

}
