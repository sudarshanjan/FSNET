package com.WEBTESTS;

public class WEB_ExecutionTests extends WEB_Tests {
	
	
	public static void  Execute() throws InterruptedException
	{
		for(int i=0;i<TestCase_rows;i++)
		{
			String executionStatus=TestCaseSheet.getCell(2,i).getContents();
			if(executionStatus.equals("Y"))
			{
				String TCName=TestCaseSheet.getCell(0,i).getContents();
				
				switch(TCName)
				{
				case "Login":
					Login();
					break;
				case "CreateFund":
					CreateFund();
					break;
				case "TC_03":
					TC_03();
					break;
					default : 
						System.out.println("****NO TEST CASE FOUND, PLEASE REVIEW EXCELL TEST CASE ID's ****");
						break;
						
				}
			}
		}
		
	}

}
