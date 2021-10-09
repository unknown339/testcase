/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.io.Serial;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 *
 * @author Shaliah Ashaib
 */
public class Window extends JFrame {
    @Serial
    private static final long serialVersionUID = -2542001418764869760L;
    public static ArrayList<ArrayList<DataOfSquare>> Grid;
    public static int width = 20;
    public static int height = 20;
    public Window(){
		
    // Creates the arraylist that'll contain the threads
    Grid = new ArrayList<>();
    ArrayList<DataOfSquare> data;
		
    // Create Threads and its data and adds it to the arrayList
    for(int i=0;i<width;i++){
	data= new ArrayList<>();
	for(int j=0;j<height;j++){
            DataOfSquare c = new DataOfSquare(2);
            data.add(c);
	}
        Grid.add(data);
		}
		
	// Setting up the layout of the panel
	getContentPane().setLayout(new GridLayout(20,20,0,0));
		
            // Start & pauses all threads, then adds every square of each thread to the panel
            for(int i=0;i<width;i++){
		for(int j=0;j<height;j++){
                    getContentPane().add(Grid.get(i).get(j).square);
                    }
            }
		
	// initial position of the snake
	Tuple position = new Tuple(10,10);
	// passing this value to the controller
	ThreadsController c = new ThreadsController(position);
	//Let's start the game now
	c.start();

	// Links the window to the keyboard listener
	this.addKeyListener((KeyListener) new KeyboardListener());


	//To do : handle multiplayer's The above works, test it and see what happens

    }

}
