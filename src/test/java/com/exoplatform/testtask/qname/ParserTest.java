package com.exoplatform.testtask.qname;

import static org.junit.Assert.*;

import org.junit.Test;

/** Description of ParserTest 
*The ParserTest class  
* @author Valeriy Svydenko
* @version 1.0 Build April 8, 2012.
*/
public class ParserTest {
	/**
	 * 
	 *tester is object to parse the name 
	 */
	Parser tester = new Parser();

	/**
	 * Check a input name.
	 * @result the name is a pattern
	 */
	@Test
	public void testIsNameVersion1() {
		assertTrue(tester.isName("name"));
		assertTrue(tester.isName("prefix:name"));
		assertTrue(tester.isName("prefix:na me"));
	}

	/**
	 * Check a input name.
	 * @result the name is a pattern
	 */
	@Test
	public void testIsNameVersion2() {
		assertTrue(tester.isName("n:uyuh6768hiu"));
		assertTrue(tester.isName("pref_1x:naїїїьу"));
	}
	
	/**
	 * Check a input name.
	 * @result the name is not a pattern
	 */
	@Test
	public void testIsNameVersion3() {
		assertFalse(tester.isName(""));
		assertFalse(tester.isName(":name"));
		assertFalse(tester.isName("."));
		assertFalse(tester.isName(".."));
		assertFalse(tester.isName("prefix:"));
		
	}
	
	/**
	 * Check a input name.
	 * @result the name is not a pattern
	 */
	@Test
	public void testIsNameVersion4() {
		assertFalse(tester.isName(" name"));
		assertFalse(tester.isName(" prefix:name"));
		assertFalse(tester.isName("prefix:name "));
		assertFalse(tester.isName("pre fix:name"));
		assertFalse(tester.isName("name/name"));
		assertFalse(tester.isName("name[name"));
		assertFalse(tester.isName("prefix:name:name"));
		assertFalse(tester.isName("1nїme:name"));
		
	}

}
