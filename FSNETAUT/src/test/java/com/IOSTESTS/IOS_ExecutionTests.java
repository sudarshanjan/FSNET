package com.IOSTESTS;

public class IOS_ExecutionTests extends IOS_Tests {
	
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
					
				case "Start_Care":
					Start_Care();
					break;
				
				
				case "VerifyNotif":
					VerifyNotif();
					break;
					
					
				default : 
						System.out.println("****NO TEST CASE FOUND, PLEASE REVIEW EXCELL TEST CASE ID's ****");
					break;
						
				}
			}
		}
	}

}