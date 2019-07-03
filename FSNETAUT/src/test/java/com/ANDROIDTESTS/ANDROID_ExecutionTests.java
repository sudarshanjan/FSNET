package com.ANDROIDTESTS;

public class ANDROID_ExecutionTests extends ANDROID_Tests {
	
	public static void  Execute() throws Exception
	{
		for(int i=0;i<TestCase_rows;i++)
		{
			String executionStatus=TestCaseSheet.getCell(2,i).getContents();
			if(executionStatus.equals("Y"))
			{
				String TCName=TestCaseSheet.getCell(0,i).getContents();
				
				switch(TCName)
				{
				case "FourDigitPin":
					FourDigitPin();
					break;
				case "Login":
					Login();
					break;
				
					
					
					default : 
						System.out.println("****NO TEST CASE FOUND, PLEASE REVIEW EXCELL TEST CASE ID's ****");
					break;
						
				}
			}
		}
	}

}
