package com.exoplatform.testtask.qname;

/** Description of QName. 
* 
* @author Valeriy Svydenko
* @version 1.0 Build April 8, 2012.
*/
public class QName {
	/**
     *Full input name
     */ 
	private String name;
	/**
     *Prefix for input name
     */ 
	private String prefix;
	/**
     *Local name for input name
     */ 
	private String localName;
	
	/** Description of MyClass() 
	 * 
	 */
	QName(){
		this.name = "";
		this.prefix = "";
		this.localName = "";
	}
	/** Description of MyClass() 
	 * 
	 * @param s input name
	 */
	QName(String s){
		this.name = s;
		initLocalAndPrefix();
	}
	
	/**
	 * 
	 * Parses the name of prefix and localName
	 */
	private void initLocalAndPrefix(){
		int indexTwoDot = name.indexOf(":");
		if(indexTwoDot != -1){
			prefix = name.substring(0,indexTwoDot);
			localName = name.substring(indexTwoDot+1,name.length());
		}
		else {
			prefix = "";
			localName = name;
		}
	}
	
	/**
	 * 
	 * @return localName
	 */
	public String getLocalName(){
		return localName;
	}
	
	/**
	 * 
	 * @return prefix
	 */
	public String getPrefix(){
		return prefix;
	}
	
	/**
	 * 
	 * @return full name
	 */
	public  String getAsString(){
		return name;
	}
	
}
