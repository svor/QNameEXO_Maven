package com.exoplatform.testtask.qname;

import java.util.logging.*;
import java.io.*;

public class IllegalNameException extends Exception {
	private static Logger logger = Logger.getLogger("IllegalNameException");
	IllegalNameException(){
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
	IllegalNameException(String msg){
		super(msg);
	}
}
