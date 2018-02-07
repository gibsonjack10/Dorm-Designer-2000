

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
		data.bedImage = data.processing.loadImage("images/bed.png");
		
		for (int i=0; i<6; i++) {
			data.bedPositions[i] = null;
		}
		
		data.backgroundImage = data.processing.loadImage("images/background.png");
//	    data.bedPositions[0] = new float[2];
//		data.bedPositions[0][0] = data.processing.width/2;
//		data.bedPositions[0][1] = data.processing.height/2;
		System.out.println("Press the \"B\" key to create a new bed");
	}

	
	
	
	
	public static void update(Data data) {
        data.processing.background(100,150,250);
		data.processing.image(data.backgroundImage, data.processing.width/2, data.processing.height/2);
//		data.processing.image(data.bedImage, data.bedPositions[0][0], data.bedPositions[0][1]);
		
		for (int i=0; i<6; i++) {
			if (data.bedPositions[i] != null) {
				data.processing.image(data.bedImage, data.bedPositions[i][0], data.bedPositions[i][1]);
			}
		}
	
		
		if (data.dragBedIndex != -1) {
			data.processing.image(data.bedImage, data.processing.mouseX, data.processing.mouseY);
			data.bedPositions[data.dragBedIndex][0] = data.processing.mouseX;
			data.bedPositions[data.dragBedIndex][1] = data.processing.mouseY;
		}	
	}		
			
	
		
	public static void mouseDown(Data data) {
		for (int i=0; i<6; i++) {
			if (data.bedPositions[i] == null) {
				break;
			}
			if (data.processing.mouseX > data.bedPositions[i][0] - data.bedImage.width/2 && 
					data.processing.mouseX < data.bedPositions[i][0] + data.bedImage.width/2 &&
					data.processing.mouseY > data.bedPositions[i][1] - data.bedImage.height/2 &&
					data.processing.mouseY < data.bedPositions[i][1] + data.bedImage.height/2) {
				data.dragBedIndex = i;
				break;
			} 		
		}	
	}
	
	
	
	
	
	public static void mouseUp(Data data) {
		data.dragBedIndex = -1;
	}
	
	
	
	
	
	public static void keyPressed(Data data) {
		if (data.processing.key == 'B' || data.processing.key == 'b') {
			for (int i=0; i<6; i++) {
				if (data.bedPositions[i] == null) {
					data.bedPositions[i] = new float[2];
					data.bedPositions[i][0] = data.processing.width/2;
					data.bedPositions[i][1] = data.processing.height/2;
					break;
				}
			}
		}
	}
	
	
	
	
	
	
}

