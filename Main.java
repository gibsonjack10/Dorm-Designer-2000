///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (Dorm Designer 2000)
// Files:            (N/A)
// Semester:         (CS 300) Spring 2018
//
// Author:           (John Gibson)
// Email:            (jdgibson@wisc.edu)
// Lecturer's Name:  (Gary Dahl)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
//                   CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//                   If pair programming is allowed:
//                   1. Read PAIR-PROGRAMMING policy (in cs302 policy) 
//                   2. choose a partner wisely
//                   3. REGISTER THE TEAM BEFORE YOU WORK TOGETHER 
//                      a. one partner creates the team
//                      b. the other partner must join the team
//                   4. complete this section for each program file.
//
// Pair Partner:     (Bennett Majerowski)
// Email:            (emajerowski@wisc.edu)
// Lecturer's Name:  (Alexi Brooks)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but tutors, roommates, relatives, strangers, etc do.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of 
//                   of any information you find.
//////////////////////////// 80 columns wide ////////////////////////////////// 

/**
 * (This class opens a java window where the user can create beds and place 
 * them around a dorm room to try and design a room to their best liking.)
 *
 * <p>Bugs: (no known bugs)
 *
 * @author (Bennett Majerowski and John Gibson)
 */
public class Main {

	/**
	 * (The main starts the application and runs it from the jar file)
	 */
	public static void main(String[] args) {
		Utility.startApplication();
	}
	
	/**
	 * (Setup creates the initial room along with initializing an array
	 * to store the beds in when they are created)
	 *
	 * @param (Data) (data from within the jar file)
	 */
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

	/**
	 * (Update is constantly checking the room and seeing if it needs to add beds
	 * according to user inputs)
	 *
	 * @param (Data) (data from the jar file)
	 */
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
			
	/**
	 * (Called when the mouse is pressed down and checks to see if the mouse 
	 * has clicked on a bed or not, and if it does it moves the center of the 
	 * bed to the mouses position.)
	 *
	 * @param (Data) (data from the jar file)
	 */	
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
	
	/**
	 * (Called after the mouse button is released and sets the dragBedIndex 
	 * to negative one so the beds stay where they are being placed)
	 *
	 * @param (Data) (data from the jar file)
	 */
	public static void mouseUp(Data data) {
		data.dragBedIndex = -1;
	}
	
	/**
	 * (checks any keys pressed by the user and if it is the "b" key then 
	 * it creates a new bed in the center of the room)
	 *
	 * @param (Data) (data from the jar file)
	 */
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