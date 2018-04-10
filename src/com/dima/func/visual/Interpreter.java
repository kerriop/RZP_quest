package com.dima.func.visual;

import com.dima.func.compiled.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Визуализация работы программы
 */
public class Interpreter extends JFrame {
	private JTextField textField1;
	private JButton buildButton;
	private JPanel rootPanel;
	private JTextField xBegin;
	private JTextField xEnd;
	private JTextField yBegin;
	private JTextField yEnd;
	private JCheckBox graphCheckBox;
	
	/**
	 * Компонент отрисовки графика
	 */
	class MathGraphComponent extends JPanel {
		private static final int GRAPH_OFFSET_X = 20;
		private static final int GRAPH_OFFSET_Y = 20;

		private Operation function;
		private final float startX;
		private final float endX;
		private final float startY;
		private final float endY;
		
		public MathGraphComponent(Operation function, float startX, float endX, float startY, float endY) {
			this.function = function;
			this.startX = startX;
			this.endX = endX;
			this.startY = startY;
			this.endY = endY;
		}
		
		@Override
		protected void paintComponent(Graphics graphics) {
			Graphics2D graphics2D = (Graphics2D) graphics;
			
			//Две системы измерения:
			//screenX = 320px
			//graph = endY - startY
			
			//Оси
			int screenX = getWidth() - 2 * GRAPH_OFFSET_X;
			int screenY = getHeight() - 2 * GRAPH_OFFSET_Y;
			int maxScreenY = getHeight();
			//int MAX_Y = (int) (screenX + 40);
			
			//Данные
			EngineContext context = new EngineContext();
			float graphX = endX - startX; //100
			float graphY = endY - startY; //100
			
			int zeroXScreen = (int) ((0 - startX) / graphX * screenX);
			int zeroYScreen = (int) ((0 - startY) / graphY * screenY);
			
			//horizontal
			graphics2D.drawLine(
					GRAPH_OFFSET_X + zeroXScreen, maxScreenY - (GRAPH_OFFSET_Y + zeroYScreen),
					GRAPH_OFFSET_X + screenX, maxScreenY - (GRAPH_OFFSET_Y + zeroYScreen)
			);
			//vertical
			graphics2D.drawLine(
					GRAPH_OFFSET_X + zeroXScreen, maxScreenY - (GRAPH_OFFSET_Y + zeroYScreen),
					GRAPH_OFFSET_X + zeroXScreen, maxScreenY - (GRAPH_OFFSET_Y + screenY)
			);
			
			float xPixelToGraph = graphX / screenX;
			float xGraphToPixel = screenX / graphX;
			float yGraphToPixel = screenY / graphY;
			
			int n = screenX;
			
			float x = startX;
			int[] xs = new int[n];
			int[] ys = new int[n];
			
			for (int i = 0; i < n; i++) {
				context.set("x", x);
				//Количество Х за пиксель
				x += xPixelToGraph;
				float val = OperationHelper.floatVal(function, context);
				xs[i] = (int) (GRAPH_OFFSET_X + i);
				ys[i] = maxScreenY - (int) (GRAPH_OFFSET_Y + ((val - startY) * yGraphToPixel));
			}
			
			graphics2D.drawPolyline(xs, ys, n);
		}
	}
	
	public Interpreter() {
		setTitle("Interpreter");
		
		setContentPane(rootPanel);
		
		pack();
		setSize(600,130);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setVisible(true);
		
		buildButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JFrame frame = new JFrame("Result");
				JPanel jcp = new JPanel(new BorderLayout());
				
				if (graphCheckBox.isSelected()) {
					try {
						float startX = Float.parseFloat(xBegin.getText());
						float endX = Float.parseFloat(xEnd.getText());
						float startY = Float.parseFloat(yBegin.getText());
						float endY = Float.parseFloat(yEnd.getText());
						jcp.add(
							new MathGraphComponent(
									OperationParser.parse(Interpreter.this.textField1.getText()),
									startX,
									endX,
									startY,
									endY
							),
							BorderLayout.CENTER
						);
						jcp.setBackground(Color.gray);
						frame.setSize(500, 500);
					} catch (CompileException e) {
						e.printStackTrace();
					} catch (NumberFormatException nfe) {
						//поругать юзера
						nfe.printStackTrace();
					}
				} else {
					try {
						Operation operation = OperationParser.parse(Interpreter.this.textField1.getText());
						EngineContext context = new EngineContext();
						context.set("x", 0);
						
						jcp.add(new Label("Результат: "),
								BorderLayout.LINE_START);
						jcp.add(new Label(operation.execute(context).toString()),
								BorderLayout.AFTER_LINE_ENDS);
						jcp.setBackground(Color.white);
						frame.setSize(250, 100);
						
					} catch (CompileException e) {
						e.printStackTrace();
					}
				}
				
//				jcp.setBackground(Color.gray);
				
				frame.setContentPane(jcp);
				frame.setLocationByPlatform(true);
//				frame.setSize(500, 400);
				frame.setVisible(true);
			}
		});
		
		//graph = static checkbox
		/*graphCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
			}
		});*/
	}
	
}
