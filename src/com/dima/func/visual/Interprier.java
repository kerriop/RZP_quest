package com.dima.func.visual;

import com.dima.func.compiled.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Визуализация работы программы
 */
public class Interprier extends JFrame {
	private JTextField textField1;
	private JButton buildButton;
	private JPanel rootPanel;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JCheckBox graphCheckBox;
	
	/**
	 * Компонент отрисовки графика
	 */
	class MathGraphComponent extends JPanel {
		private static final int GRAPH_OFFSET_X = 20;
		private static final int GRAPH_OFFSET_Y = 20;

		private Operation function;
		private float start, end, step;
		
		public MathGraphComponent(Operation function, float start, float end, float step) {
			this.function = function;
			this.start = start;
			this.end = end;
			this.step = step;
		}
		
		@Override
		protected void paintComponent(Graphics graphics) {
			Graphics2D graphics2D = (Graphics2D) graphics;
			
			//Оси
			float screenLength = 320;
			int MAX_Y = (int) (screenLength + 40);
			
			graphics2D.drawLine(
					GRAPH_OFFSET_X, MAX_Y - (int) (GRAPH_OFFSET_Y + screenLength),
					GRAPH_OFFSET_X, MAX_Y - GRAPH_OFFSET_Y
			);
			graphics2D.drawLine(
					GRAPH_OFFSET_X, MAX_Y - GRAPH_OFFSET_Y,
					(int) (GRAPH_OFFSET_X + screenLength), MAX_Y - GRAPH_OFFSET_Y
			);
			
			//Данные
			EngineContext context = new EngineContext();
			float graphLength = end - start;
			int n = (int) (graphLength / step);
			
			float x = start;
			int[] xs = new int[n];
			int[] ys = new int[n];
			
			for (int i = 0; i < n; i++) {
				context.set("x", x);
				x += step;
				float val = OperationHelper.floatVal(function, context);
				xs[i] = (int) (GRAPH_OFFSET_X + (x / graphLength * screenLength));
				ys[i] = MAX_Y - (int) (GRAPH_OFFSET_Y + (val / graphLength * screenLength));
			}
			
			graphics2D.drawPolyline(xs, ys, n);
		}
	}
	
	public Interprier() {
		setTitle("Interprier");
		
		setContentPane(rootPanel);
		
		pack();
		setSize(600,130);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setVisible(true);
		
		buildButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JFrame frame = new JFrame("Graphic");
				
				JPanel jcp = new JPanel(new BorderLayout());
				try {
					jcp.add(
							new MathGraphComponent(
									OperationParser.parse(Interprier.this.textField1.getText()),
									0,
									(float) (Math.PI * 10),
									(float) (Math.PI / 15)
							),
							BorderLayout.CENTER
					);
					
				} catch (CompileException e) {
					e.printStackTrace();
				}
				jcp.setBackground(Color.gray);
				
				frame.setContentPane(jcp);
				frame.setLocationByPlatform(true);
				frame.setSize(500, 400);
				frame.setVisible(true);
			}
		});
		
	}
	
}
