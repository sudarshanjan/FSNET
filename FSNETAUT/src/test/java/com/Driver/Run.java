package com.Driver;

import com.ANDROIDTESTS.ANDROID_ExecutionTests;
import com.GenericFunctions.GenericFunctions;
import com.IOSTESTS.IOS_ExecutionTests;
import com.Initilisation.Initilisation;
import com.WEBTESTS.WEB_ExecutionTests;


public class Run extends GenericFunctions{

	public static void main(String[] args) throws Exception {
		
		Initilisation.init();
		
		if(Config.getProperty("TypeofApplication").equals("WEB"))
		{
			WEB_ExecutionTests.Execute();
		}
		else if(Config.getProperty("TypeofApplication").equals("ANDROID"))
		{
			ANDROID_ExecutionTests.Execute();
		}
		else if(Config.getProperty("TypeofApplication").equals("IOS"))
		{
			IOS_ExecutionTests.Execute();
		}
		
		extent.flush();
	}

}