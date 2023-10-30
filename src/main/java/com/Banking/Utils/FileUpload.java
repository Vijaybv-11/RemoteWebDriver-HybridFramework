package com.Banking.Utils;

public class FileUpload implements FrameworkConstants{
	
	
	public void fileUploadThroughAutoIt() {
		
		
	 String Autoitpath = autoItPath;
    
     String uploadFilePath = filUploadPath;
     try {
    	 String title = "Open";
         ProcessBuilder pb = new ProcessBuilder(Autoitpath,
                 uploadFilePath, title);
         pb.start();
    	
	} catch (Exception e) {
		e.printStackTrace();
	}
     
	}
	
	public void fileUploadThroughRobotClass() {
		
		
	}
}
