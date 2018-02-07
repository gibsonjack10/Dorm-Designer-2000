import java.util.Scanner;

//
//
//
//
//
//
//
//
//
//
//
//
// class is pattern for objects
// 

public class Main {

	public static void main(String[] args) {
		Utility.startApplication();
	}
	
	
	
	
	
	public static void setup(Data data) {
		data.bedPositions = new float[6][2];
		data.dragBedIndex = -1;
//		for (int i=0; i<6; i++) {
//			data.bedPositions[i][0] = -1;
//			data.bedPositions[i][1] = -1;
//		}
		for (int i=0; i<6; i++) {
			data.bedPositions[i] = null;
		}
		data.backgroundImage = data.processing.loadImage("images/background.png");
	    data.bedPositions[0] = new float[2];
		data.bedPositions[0][0] = data.processing.width/2;
		data.bedPositions[0][1] = data.processing.height/2;
		System.out.println("Press the \"B\" key to create a new bed");
	}

	
	
	
	
	public static void update(Data data) {
        data.processing.background(100,150,250);
		data.processing.image(data.backgroundImage, data.processing.width/2, data.processing.height/2);
		PImage bedImage = data.processing.loadImage("images/bed.png");
		data.processing.image(bedImage, data.bedPositions[0][0], data.bedPositions[0][1]);
				
		if (data.dragBedIndex != -1) {
			data.processing.image(bedImage, data.processing.mouseX, data.processing.mouseY);
			data.bedPositions[data.dragBedIndex][0] = data.processing.mouseX;
			data.bedPositions[data.dragBedIndex][1] = data.processing.mouseY;
		} 
	}		
			
	
	
	
	
	
///////
/////// Ask about using data.bedImage.width and .height
/////// Ask about null in float array
///////
	
	
	
	
	
	
	public static void mouseDown(Data data) {
		for (int i=0; i<1; i++) {
			if (data.processing.mouseX > data.bedPositions[i][0] - 20 && //need to substitute data.bedImage.width and .height for the 20
					data.processing.mouseX < data.bedPositions[i][0] + 20 &&
					data.processing.mouseY > data.bedPositions[i][1] - 20 &&
					data.processing.mouseY < data.bedPositions[i][1] + 20) {
				data.dragBedIndex = i;
				System.out.println(i);
				break;
			} 		
		}	
	}
	
	
	
	
	
	public static void mouseUp(Data data) {
		data.dragBedIndex = -1;
	}
	
	
	
	
	
	public static void keyPressed(Data data) {
		Scanner scnr = new Scanner(System.in);
		
		int counter = 0;
		System.out.println("Press the \"B\" key to create a new bed.");
		if (scnr.nextLine().charAt(0) == 'B' || scnr.nextLine().charAt(0) == 'b') {
			data.bedPositions[counter] = new float[2];
			data.bedPositions[counter][0] = data.processing.width/2;
			data.bedPositions[counter][1] = data.processing.height/2;
			
			counter++;
		}
		scnr.close();
	}
	
	
	
}

