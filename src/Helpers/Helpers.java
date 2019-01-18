package Helpers;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import TestBaseClass.Device;
import TestBaseClass.TestBaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class Helpers {

	//public static final  String[] Languages={"United States","Deutsch","Nederlands","Русский","(France)","Italiano","(Espa","Polski","(Brasil)","한국어","简体"};
	//public static final  String[] Languages={"繁體"};
	//public static String CurrentLanguage="Japanese";
	public static TouchAction Tap;
	static Random rnd;
	public static String currentNoteOrientation="";
	
	public static int allNotesCount=0;
	public static int currentNotesCount=0;
			
	public static int getDeviceWidth=0;
	public static int getDeviceHeight=0;
	
	public static int drawingStartX=0;
	public static int drawingStartY=0;
	public static int drawingEndX=0;
	public static int drawingEndY=0;
	public static TouchAction swipe;
	
	
	public static void PressAndHold(int X, int Y) throws IOException, InterruptedException
	{
		swipe=new TouchAction(Device.Driver);
		if(Device.DriverName.equals("Android"))
		{
			Thread.sleep(2000);
			Runtime.getRuntime().exec("/Users/nenko/Documents/android-sdk-macosx/adb shell input touchscreen swipe "+Integer.toString(X)+" "+Integer.toString(Y)+" "+Integer.toString(X)+" "+Integer.toString(Y)+" 2000");
			Thread.sleep(2000);
		}
		else
		{
			Thread.sleep(2000);
			Device.Driver.swipe(X, Y, X, Y, 2333);
			//swipe.longPress(X,Y).release().perform();
			Thread.sleep(2000);
		}
	}
	
	public static void pressAndMove(int startX, int startY, int endX, int endY) throws InterruptedException, IOException
	{
		swipe=new TouchAction(Device.Driver);
		Thread.sleep(2000);
		swipe.press(startX, startY).moveTo(endX,endY).release().perform();
		Thread.sleep(2000);
	}
	
	public static void DriverSwipeOperation(int StartX, int StartY, int EndX, int EndY, int Duration)
	{
			Device.Driver.swipe(StartX, StartY, EndX, EndY, Duration);
	}
	
	public static void TapAction(int X, int Y)
	{
		Tap=new TouchAction(Device.Driver);
		Tap.tap(X, Y).perform();
	}
	
	public static void DragAndDrop() throws IOException, InterruptedException
	{
		Tap=new TouchAction(Device.Driver);
		Tap.tap(300,800).waitAction(2000).moveTo(500,900).waitAction(3000).perform().waitAction(5000).release();
		//Runtime.getRuntime().exec("/Users/nenko/Documents/android-sdk-macosx/platform-tools/adb shell sh /sdcard/getevent_input.sh").getInputStream();
		Thread.sleep(18000);
	}
	
	
	
	public static void LongPressByCoordinates(int startX, int startY) throws InterruptedException
	{
		Tap=new TouchAction(Device.Driver);
		Tap.longPress(startX, startY).release().perform();
		Thread.sleep(1000);
	}
	
	public static void LongPressByElement(MobileElement element) throws InterruptedException
	{
		Tap=new TouchAction(Device.Driver);
		Tap.longPress(element, 2000).release().perform();
		Thread.sleep(1000);
	}
	
	
	
	public static void CreateScreenshot(String ScreenshotName) throws IOException
	{
		if(Device.DriverName.equals("Android"))
		{
			File CreateNewFile=((TakesScreenshot)Device.Driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(CreateNewFile,new File( "/Users/nenko/Documents/WacomProjectScreenshots/BambooSparkFunctionalTests/Android/"+ScreenshotName+".png"));
		}else
		{
			File CreateNewFile=((TakesScreenshot)Device.Driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(CreateNewFile,new File( "/Users/nenko/Documents/WacomProjectScreenshots/BambooSparkFunctionalTests/iOS/"+ScreenshotName+".png"));
		}
	}
	
	public static String getScreenshot(String screenshotName)
	{
		if(Device.DriverName.equals("Android"))
		{
			return  "/Users/nenko/Documents/WacomProjectScreenshots/BambooSparkFunctionalTests/Android/"+screenshotName+".png";
		}else
		{
			return "/Users/nenko/Documents/WacomProjectScreenshots/BambooSparkFunctionalTests/iOS/"+screenshotName+".png";
		}
	}
	
	
	public static int setAndGetRandomStartXBasedOnTheDeviceWidth()
	{
		int deviceX=Device.Driver.manage().window().getSize().getWidth();
		System.out.println(deviceX);
		rnd=new Random();
		
		if(Device.DriverName.equals("Android"))
			{
			if(deviceX<=1000)
			{
				drawingStartX=deviceX-200-rnd.nextInt(200);
			}else if(deviceX>1000 && deviceX<=6000)
			{
				drawingStartX=deviceX-200-rnd.nextInt(600);
			}else if(deviceX>6000)
			{
				drawingStartX=deviceX-200-rnd.nextInt(2200);
			}
			
		}else
			{
			drawingStartX=100;
			}
		System.out.println(drawingStartX);
		return drawingStartX;
	}

	
	public static int setAndGetRandomStartYBasedOnTheDeviceHeight()
	{
		int deviceY=	Device.Driver.manage().window().getSize().getHeight();
		rnd=new Random();
		if(Device.DriverName.equals("Android"))
		{
			
			if(deviceY<=1500)
			{
				drawingStartY=300+rnd.nextInt(400);
			}else if(deviceY<=3000)
			{
				drawingStartY=700+rnd.nextInt(1000);
			}else if(deviceY>1500 && deviceY<=6000)
			{
				drawingStartY=1000+rnd.nextInt(2200);
			}else if(deviceY>6000)
			{
				drawingStartY=1000+rnd.nextInt(3200);
			}
			
			
			
		}else
		{
			drawingStartY=122;
		}
		System.out.println(drawingStartY);
			return drawingStartY;
	}
	

	
	public static int setAndGetEndXBasedOnTheDeviceWidth()
	{
		if(Device.DriverName.equals("Android"))
		{
		drawingEndX=drawingStartX-150;
		}else
		{
			drawingEndX=drawingStartX+10;
		}
		System.out.println(drawingEndX);
		return drawingEndX;
	}
	
	public static int setAndGetEndYBasedOnTheDeviceHeight()
	{
		if(Device.DriverName.equals("Android"))
		{
			drawingEndY=drawingStartY-100;
		}else
		{
			drawingEndY=drawingEndY+11;
		}
		System.out.println(drawingEndY);
		return drawingEndY;
	}
	
	
	
	public static boolean CompareTwoImages(String firstNote, String secondNote)
	{
		boolean screensAreEqual=false;
		 //String firstImage, String secondImage
		String file1 =firstNote;
		String file2 = secondNote;
		boolean NotesAreEqual=false;
		 
		Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
		Image image2 = Toolkit.getDefaultToolkit().getImage(file2);
		 
		try {
		 
		PixelGrabber grab1 =new PixelGrabber(image1, 0, 0, -1, -1, false);
		PixelGrabber grab2 =new PixelGrabber(image2, 0, 0, -1, -1, false);
		 
		int[] data1 = null;
		 
		if (grab1.grabPixels()) {
		int width = grab1.getWidth();
		int height = grab1.getHeight();
		data1 = new int[width * height];
		data1 = (int[]) grab1.getPixels();
		}
		 
		int[] data2 = null;
		 
		if (grab2.grabPixels()) {
		int width = grab2.getWidth();
		int height = grab2.getHeight();
		data2 = new int[width * height];
		data2 = (int[]) grab2.getPixels();
		}
		NotesAreEqual=java.util.Arrays.equals(data1, data2);
		System.out.println("Pixels equal: " + java.util.Arrays.equals(data1, data2));
		}
		catch (InterruptedException e1) {
		e1.printStackTrace();
		}
		return NotesAreEqual;
	}
	

	public static String CheckOrientation(String filePath)
			{ 
					
				BufferedImage image;
				int width;
				int height;
			    int counterBlackColor=0;  
				try {
				         File input = new File(filePath);
				         image = ImageIO.read(input);
				         width = image.getWidth();
				         height = image.getHeight();
				         
				    
				         int count = 0;
				         if(GetScreenshotOrientation(filePath)=="Portrait"){
				         for(int i=0; i<height; i++){
				               count++;
				               Color c = new Color(image.getRGB(1, i));
				               System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());  
				               if(c.getRed()==0 && c.getBlue()==0 && c.getGreen()==0){
				            	   for(int j=i+1; j<height; j++){
				            		   Color c1 = new Color(image.getRGB(1, j));
				                    //   count++;
				                       counterBlackColor++;
				            		   System.out.println("S.No: " + j + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
				            		   if(c1.getRed()==255 && c1.getBlue()==255 && c1.getGreen()==255)
				            		   {
				            			   counterBlackColor--;
				            			   break;
				            		   }
				            	   }
				            	  if(counterBlackColor!=0){
				            		  break;
				            	  }
				               }
				             
				         }
				         }else
				         {
				        	 
				        	 for(int i=0; i<width; i++){
					               count++;
					               Color c = new Color(image.getRGB(i, 1));
					               System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());  
					               if(c.getRed()==0 && c.getBlue()==0 && c.getGreen()==0){
					            	   for(int j=i+1; j<width; j++){
					            		   Color c1 = new Color(image.getRGB(j, 1));
					                    //   count++;
					                       counterBlackColor++;
					            		   System.out.println("S.No: " + j + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
					            		   if(c1.getRed()==255 && c1.getBlue()==255 && c1.getGreen()==255)
					            		   {
					            			   counterBlackColor--;
					            			   break;
					            		   }
					            	   }
					            	  if(counterBlackColor!=0){
					            		  break;
					            	  }
					               }
					             
					         }
				        	 
				         }

				      } catch (Exception e) {}
				
				System.out.println(counterBlackColor);
				
				if(Device.DriverName.equals("Android"))
			{
				if(counterBlackColor>150)
				{
					return "Landscape";
				}
				else
				{
				return "Portrait";
				}
			}else
			{
				if(counterBlackColor>550)
				{
					return "Portrait";
				}
				else
				{
					return "Landscape";
				}
			}
			}
	
	public static String	GetScreenshotOrientation(String ScreenshotPath)
	{
		   String ScreenshotOrientation = "";
		      ImageIcon image = new ImageIcon(ScreenshotPath);
		      int width=image.getIconWidth();
		    	int getIconHeight=image.getIconHeight();
		      if (image.getIconWidth() > image.getIconHeight()) {
		    	  ScreenshotOrientation = "Landscape";
		      } else {
		    	  ScreenshotOrientation = "Portrait";
		      }
		      image = null;
		      return ScreenshotOrientation;
	}
	

	
	
}
