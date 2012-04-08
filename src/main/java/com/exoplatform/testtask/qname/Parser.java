package com.exoplatform.testtask.qname;
/** Description of Parser 
*
* @author Valeriy Svydenko
* @version 1.0 Build April 8, 2012.
*/
public class Parser {
	/**
     * Regular expressions for nonspace names  
     */ 
	private final String NONSPACE_REGULAR_EXPRESSION = "[[\\w\\W]&&[^\\s/:*'\"|\\[\\]]]{1}";
	/**
     * Regular expressions for string names  
     */ 
	private final String STRING_REGULAR_EXPRESSION = "[[\\w\\W]&&[^/:*'\"|\\[\\]]]+";
	/**
     * Regular expressions for prefix names  
     */ 
	private final String PREFIX_REGULAR_EXPRESSION = "[_:A-Za-z][-._:A-Za-z0-9]*";
	/**
     * Regular expressions for one char simple names  
     */ 
	private final String ONECHARSN_REGULAR_EXPRESSION = "[[\\w\\W]&&[^\\s/:.*'\"|\\[\\]]]{1}";
	

	/**
	 * Creates and returns the new QName object
	 * @param   name   the name to be parsed
	 * @return  new QName() object
	 * @exception  IllegalNameException  if the user's input is not in valid name format.
	 */
	public QName parse (String name) throws IllegalNameException {
		if (isName(name)){
			return new QName(name);
		}
		else
			throw new IllegalNameException();
	}
	
	/**
	 * Checks if the name is nonspace 
	 * @param   nonspace  
	 * @return  true if input string is nonspace.  
	*/
	private boolean isNonspace(String nonspace){
		return nonspace.matches(NONSPACE_REGULAR_EXPRESSION);
	}
	
	/**
	 * Checks if the name is char 
	 * @param   ch  
	 * @return  true if input string is char.  
	*/
	private boolean isChar(String ch){
		return (isNonspace(ch) || ch.matches("[ ]{1}"));
	}
	
	/**
	 * Checks if the name is string 
	 * @param   str  
	 * @return  true if input string is string.  
	*/
	private boolean isString(String str) {
		return str.matches(STRING_REGULAR_EXPRESSION);
	}
	
	/**
	 * Checks if the name is prefix 
	 * @param   prefix  
	 * @return  true if input string is prefix.  
	*/
	private boolean isPrefix(String prefix){
		return prefix.matches(PREFIX_REGULAR_EXPRESSION);
	}
	
	/**
	 * Checks if the name is ThreeOrMoreCharName 
	 * @param   threeOrMore  
	 * @return  true if input string is ThreeOrMoreCharName.  
	*/
	private boolean isThreeOrMoreCharName(String threeOrMore){
		String first, last, middle ;
		
		first = threeOrMore.substring(0, 1);
		last = threeOrMore.substring(threeOrMore.length()-1, threeOrMore.length());
		middle = threeOrMore.substring(1, threeOrMore.length()-1);
		
		return (isNonspace(first) && isNonspace(last) && isString(middle));
	}
	
	/**
	 * Checks if the name is TwoCharLocalName 
	 * @param   twoCharLocalName  
	 * @return  true if input string is TwoCharLocalName.  
	*/
	private boolean isTwoCharLocalName (String twoCharLocalName) {
		return (isNonspace(twoCharLocalName.substring(0, 1)) && isNonspace(twoCharLocalName.substring(1, 2)));		
	}
	
	/**
	 * Checks if the name is OneCharLocalName 
	 * @param   oneCharLocalName  
	 * @return  true if input string is OneCharLocalName.  
	*/
	private boolean isOneCharLocalName (String oneCharLocalName){
		return isNonspace(oneCharLocalName);
	}
	
	/**
	 * Checks if the name is OneCharSimpleName 
	 * @param   oneCharSimpleName  
	 * @return  true if input string is OneCharSimpleName.  
	*/
	private boolean isOneCharSimpleName(String oneCharSimpleName){
		return (oneCharSimpleName.matches(ONECHARSN_REGULAR_EXPRESSION));
	}
	
	/**
	 * Checks if the name is TwoCharSimpleName 
	 * @param   twoChareSimpleName  
	 * @return  true if input string is TwoCharSimpleName.  
	*/
	private boolean isTwoCharSimpleName(String twoChareSimpleName){
		String first, last;
		first = twoChareSimpleName.substring(0, 1);
		last = twoChareSimpleName.substring(1, 2);
		
		if( isOneCharSimpleName(first) && isOneCharSimpleName(last))
			return true;
		else if (isOneCharSimpleName(first) && last.equals(".") )
			return true;
		else if (first.equals(".") && isOneCharSimpleName(last) )
			return true;
		else
			return false;
	}
	
	/**
	 * Checks if the name is LocalName 
	 * @param   localName  
	 * @return  true if input string is LocalName.  
	*/
	private boolean isLocalName(String localName) {
		int lengthLocalName = localName.length();
		if (lengthLocalName == 0)
			return false;
		else if (lengthLocalName == 1)
			return isOneCharLocalName(localName);
		else if (lengthLocalName == 2)
			return isTwoCharLocalName(localName);
		else
			return isThreeOrMoreCharName(localName);
	}
	
	/**
	 * Checks if the name is PrefixedName 
	 * @param   prefixedName  
	 * @return  true if input string is PrefixedName.  
	*/
	private boolean isPrefixedName(String prefixedName){
		//the XML's name does not symbol ':'
		int indexTwoDot;
		String prefix, localName;
		indexTwoDot = prefixedName.indexOf(':');
		if (indexTwoDot == -1)
			return false;
		prefix = prefixedName.substring(0, indexTwoDot);
		localName = prefixedName.substring(indexTwoDot + 1, prefixedName.length());
		return (isPrefix(prefix) && isLocalName(localName));
	}
	
	/**
	 * Checks if the name is SimpleName 
	 * @param   simpleName  
	 * @return  true if input string is SimpleName.  
	*/
	private boolean isSimpleName(String simpleName) {
		int lengthLocalName = simpleName.length();
		if (lengthLocalName == 0)
			return false;
		else if (lengthLocalName == 1)
			return isOneCharSimpleName(simpleName);
		else if (lengthLocalName == 2)
			return isTwoCharSimpleName(simpleName);
		else
			return isThreeOrMoreCharName(simpleName);
	}
	
	/**
	 * Checks if the name is SimpleName or PrefixedName 
	 * @param   name  
	 * @return  true if input string is SimpleName or PrefixedName.  
	*/
	public boolean isName(String name){
		return (isSimpleName(name) || isPrefixedName(name));
	}
}
