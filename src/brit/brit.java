package brit;
import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;


import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;


public class brit extends JApplet {
	public void paint (Graphics g){
		super.paint (g);

//синяя основа
		Color newColor = new Color(0, 2, 255);
		g.setColor(newColor);
		g.fillRect(20, 40, 300, 200);
		
		//белая вертикаль \
		int[] arrayX = {20, 60, 320, 320, 280,20};
		int[] arrayY = {40, 40, 220, 240, 240,60};
		g.setColor(Color.WHITE );
		g.fillPolygon(arrayX, arrayY, 6);

//белая вертикаль /
		int[] array1X = {20, 60, 320, 320, 280,20};
		int[] array1Y = { 240, 240,60,40, 40, 220};
		g.setColor(Color.WHITE );
		g.fillPolygon(array1X, array1Y, 6);

//красная вертикаль \
		int[] array3X = {20, 40, 320, 320, 300,20};
		int[] array3Y = {40, 40, 230, 240, 240,50};
		g.setColor(Color.RED );
		g.fillPolygon(array3X, array3Y, 6);

//красная вертикаль /
		int[] array4X = {20, 40, 320, 320, 300,20};
		int[] array4Y = { 240, 240,50,40, 40, 230};
		g.setColor(Color.RED );
		g.fillPolygon(array4X, array4Y, 6);

		
//белая полоса вертикаль
		Color new1Color = new Color(255, 255, 255);
		g.setColor(new1Color);
		g.fillRect(120, 40, 100, 200);

//белая полоса горизонта
		Color new2Color = new Color(255, 255, 255);
		g.setColor(new2Color);
		g.fillRect(20, 100, 300, 80);



//красная полоса горизонта
		Color new3Color = new Color(255, 0, 0);
		g.setColor(new3Color);
		g.fillRect(20, 120, 300, 40);

//красная полоса вертикаль
		Color new4Color = new Color(255, 0, 0);
		g.setColor(new4Color);
		g.fillRect(140, 40, 60, 200);
		
		
	}
}




