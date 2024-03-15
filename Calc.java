import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.InputMismatchException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Calc extends JFrame implements ActionListener{
	private JPanel panel;
	private JTextArea opField, ansField;
	private JButton one, two, three, four, five, six, seven, eight, nine, zero, dot, plusMinus, percent, mod, clear, plus, minus;
	private JButton multiply, divide, squareRoot, square, cube, equals, sin, tan, cos, asin, atan, acos, sinh, tanh, cosh;
	private JButton oneOverN, log, ln, tenRoot, exit;
	private double num1, num2 = 0;
	private String op = "";

		public Calc() {
			setTitle("Calculator");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new GridLayout(1, 1));
			getContentPane().setBackground(Color.white);

			panel = new JPanel();
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel.setBackground(Color.white);
			panel.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.fill = GridBagConstraints.BOTH;
			add(panel);
			
			opField = new JTextArea();
			Border border = BorderFactory.createLineBorder(Color.BLACK);
			opField.setBorder(border);
			gbc.gridy = 0;
			gbc.gridwidth = 4;
			panel.add(opField, gbc);
			
			ansField = new JTextArea();
			ansField.setBorder(border);
			gbc.gridy = 1;
			gbc.gridheight = 2;
			gbc.gridwidth = 4;
			panel.add(ansField, gbc);
			
			gbc.gridheight = 1;
			gbc.gridwidth = 1;
			
			one = new JButton("1");
			one.setBackground(Color.white);
			one.setForeground(Color.blue);
			gbc.gridx = 0;
			gbc.gridy = 3;
			panel.add(one, gbc);
			one.addActionListener(this);
			
			two = new JButton("2");
			gbc.gridx = 1;
			gbc.gridy = 3;
			two.setBackground(Color.white);
			two.setForeground(Color.blue);
			panel.add(two, gbc);
			two.addActionListener(this);
			
			three = new JButton("3");
			three.setBackground(Color.white);
			three.setForeground(Color.blue);
			gbc.gridx = 2;
			gbc.gridy = 3;
			panel.add(three, gbc);
			three.addActionListener(this);
			
			four = new JButton("4");
			four.setBackground(Color.white);
			four.setForeground(Color.blue);
			gbc.gridx = 0;
			gbc.gridy = 4;
			panel.add(four, gbc);
			four.addActionListener(this);
			
			five = new JButton("5");
			five.setBackground(Color.white);
			five.setForeground(Color.blue);
			gbc.gridx = 1;
			gbc.gridy = 4;
			panel.add(five, gbc);
			five.addActionListener(this);
			
			six = new JButton("6");
			six.setBackground(Color.white);
			six.setForeground(Color.blue);
			gbc.gridx = 2;
			gbc.gridy = 4;
			panel.add(six, gbc);
			six.addActionListener(this);
			
			seven = new JButton("7");
			seven.setBackground(Color.white);
			seven.setForeground(Color.blue);
			gbc.gridx = 0;
			gbc.gridy = 5;
			panel.add(seven, gbc);
			seven.addActionListener(this);
			
			eight = new JButton("8");
			eight.setBackground(Color.white);
			eight.setForeground(Color.blue);
			gbc.gridx = 1;
			gbc.gridy = 5;
			panel.add(eight, gbc);
			eight.addActionListener(this);
			
			nine = new JButton("9");
			nine.setBackground(Color.white);
			nine.setForeground(Color.blue);
			gbc.gridx = 2;
			gbc.gridy = 5;
			panel.add(nine, gbc);
			nine.addActionListener(this);
			
			zero = new JButton("0");
			zero.setBackground(Color.white);
			zero.setForeground(Color.blue);
			gbc.gridx = 1;
			gbc.gridy = 6;
			panel.add(zero, gbc);
			zero.addActionListener(this);
			
			dot = new JButton(".");
			dot.setBackground(Color.white);
			dot.setForeground(Color.blue);
			gbc.gridx = 0;
			gbc.gridy = 6;
			panel.add(dot, gbc);
			dot.addActionListener(this);
			
			plusMinus = new JButton("±");
			plusMinus.setBackground(Color.white);
			plusMinus.setForeground(Color.blue);
			gbc.gridy = 6;
			gbc.gridx = 2;
			panel.add(plusMinus, gbc);
			plusMinus.addActionListener(this);
			
			clear = new JButton("C");
			clear.setBackground(Color.orange);
			clear.setForeground(Color.black);
			gbc.gridx = 3;
			gbc.gridy = 3;
			panel.add(clear, gbc);
			clear.addActionListener(this);
			
			plus = new JButton("+");
			plus.setBackground(Color.white);
			plus.setForeground(Color.blue);
			gbc.gridx = 3;
			gbc.gridy = 4;
			panel.add(plus, gbc);
			plus.addActionListener(this);
			
			minus = new JButton("-");
			minus.setBackground(Color.white);
			minus.setForeground(Color.blue);
			gbc.gridx = 3;
			gbc.gridy = 5;
			gbc.gridwidth = 2;
			panel.add(minus, gbc);
			minus.addActionListener(this);
			
			multiply = new JButton("x");
			multiply.setBackground(Color.white);
			multiply.setForeground(Color.blue);
			gbc.gridx = 3;
			gbc.gridy = 6;
			gbc.gridwidth = 2;
			panel.add(multiply, gbc);
			multiply.addActionListener(this);
			
			gbc.gridwidth = 1;
		
			percent = new JButton("%");
			percent.setBackground(Color.white);
			percent.setForeground(Color.blue);
			gbc.gridx = 0;
			gbc.gridy = 7;
			panel.add(percent, gbc);
			percent.addActionListener(this);
			
			squareRoot = new JButton("√");
			squareRoot.setBackground(Color.white);
			squareRoot.setForeground(Color.blue);
			gbc.gridx = 1;
			gbc.gridy = 7;
			panel.add(squareRoot, gbc);
			squareRoot.addActionListener(this);
			
			square = new JButton("x²");
			square.setBackground(Color.white);
			square.setForeground(Color.blue);
			gbc.gridx = 2;
			gbc.gridy = 7;
			panel.add(square, gbc);
			square.addActionListener(this);
			
			divide = new JButton("/");
			divide.setBackground(Color.white);
			divide.setForeground(Color.blue);
			gbc.gridx = 3;
			gbc.gridy = 7;
			panel.add(divide, gbc);
			divide.addActionListener(this);
			
			mod = new JButton("mod");
			mod.setBackground(Color.white);
			mod.setForeground(Color.blue);
			gbc.gridx = 0;
			gbc.gridy = 8;
			panel.add(mod, gbc);
			mod.addActionListener(this);
			
			cube = new JButton("x³");
			cube.setBackground(Color.white);
			cube.setForeground(Color.blue);
			gbc.gridx = 1;
			gbc.gridy = 8;
			panel.add(cube, gbc);
			cube.addActionListener(this);
			
			equals = new JButton("=");
			equals.setBackground(Color.green);
			equals.setForeground(Color.black);
			gbc.gridx = 2;
			gbc.gridy = 8;
			gbc.gridwidth = 2;
			panel.add(equals, gbc);
			equals.addActionListener(this);
		
			gbc.gridwidth = 1;
			
			sin = new JButton("sin");
			sin.setBackground(Color.white);
			sin.setForeground(Color.blue);
			gbc.gridx = 0;
			gbc.gridy = 9;
			panel.add(sin, gbc);
			sin.addActionListener(this);
			
			tan = new JButton("tan");
			tan.setBackground(Color.white);
			tan.setForeground(Color.blue);
			gbc.gridx = 1;
			gbc.gridy = 9;
			panel.add(tan, gbc);
			tan.addActionListener(this);
			
			cos = new JButton("cos");
			cos.setBackground(Color.white);
			cos.setForeground(Color.blue);
			gbc.gridx = 2;
			gbc.gridy = 9;
			panel.add(cos, gbc);
			cos.addActionListener(this);
			
			log = new JButton("log");
			log.setBackground(Color.white);
			log.setForeground(Color.blue);
			gbc.gridx = 3;
			gbc.gridy = 9;
			panel.add(log, gbc);
			log.addActionListener(this);
			
			ln = new JButton("ln");
			ln.setBackground(Color.white);
			ln.setForeground(Color.blue);
			gbc.gridx = 0;
			gbc.gridy = 10;
			panel.add(ln, gbc);
			ln.addActionListener(this);
			
			asin = new JButton("asin");
			asin.setBackground(Color.white);
			asin.setForeground(Color.blue);
			gbc.gridx = 1;
			gbc.gridy = 10;
			panel.add(asin, gbc);
			asin.addActionListener(this);
			
			atan = new JButton("atan");
			atan.setBackground(Color.white);
			atan.setForeground(Color.blue);
			gbc.gridx = 2;
			gbc.gridy = 10;
			panel.add(atan, gbc);
			atan.addActionListener(this);
			
			acos = new JButton("acos");
			acos.setBackground(Color.white);
			acos.setForeground(Color.blue);
			gbc.gridx = 3;
			gbc.gridy = 10;
			panel.add(acos, gbc);
			acos.addActionListener(this);
			
			tenRoot = new JButton("10^n");
			tenRoot.setBackground(Color.white);
			tenRoot.setForeground(Color.blue);
			gbc.gridx = 0;
			gbc.gridy = 11;
			panel.add(tenRoot, gbc);
			tenRoot.addActionListener(this);
			
			oneOverN = new JButton("1/n");
			oneOverN.setBackground(Color.white);
			oneOverN.setForeground(Color.blue);
			gbc.gridx = 1;
			gbc.gridy = 11;
			panel.add(oneOverN, gbc);
			oneOverN.addActionListener(this);
			
			sinh = new JButton("sinh");
			sinh.setBackground(Color.white);
			sinh.setForeground(Color.blue);
			gbc.gridx = 2;
			gbc.gridy = 11;
			panel.add(sinh, gbc);
			sinh.addActionListener(this);
			
			tanh = new JButton("tanh");
			tanh.setBackground(Color.white);
			tanh.setForeground(Color.blue);
			gbc.gridx = 3;
			gbc.gridy = 11;
			panel.add(tanh, gbc);
			tanh.addActionListener(this);
			
			cosh = new JButton("cosh");
			cosh.setBackground(Color.white);
			cosh.setForeground(Color.blue);
			gbc.gridx = 0;
			gbc.gridy = 12;
			panel.add(cosh, gbc);
			cosh.addActionListener(this);
			
			exit = new JButton("EXIT");
			exit.setBackground(Color.RED);
			exit.setForeground(Color.black);
			gbc.gridx = 1;
			gbc.gridy = 12;
			gbc.gridwidth = 3;
			panel.add(exit, gbc);
			exit.addActionListener(this);
			
			gbc.gridwidth = 1;
			
			setSize(400, 450);
			setVisible(true);
	    }

        @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = ((JButton)e.getSource()).getText();
			
        switch (buttonText) {
            case "1":
                opField.append("1");
                ansField.setText("");
                break;
            case "2":
                opField.append("2");
                ansField.setText("");
                break;
            case "3":
                opField.append("3");
                ansField.setText("");
                break;
            case "4":
                opField.append("4");
                ansField.setText("");
                break;
            case "5":
                opField.append("5");
                ansField.setText("");
                break;
            case "6":
                opField.append("6");
                ansField.setText("");
                break;
            case "7":
                opField.append("7");
                ansField.setText("");
                break;
            case "8":
                opField.append("8");
                ansField.setText("");
                break;
            case "9":
                opField.append("9");
                ansField.setText("");
                break;
            case "0":
                opField.append("0");
                ansField.setText("");
                break;
            case ".":
                opField.append(".");
                ansField.setText("");
                break;
            case "C":
                opField.setText("");
                ansField.setText("");
                break;
            case "+":
                op = "+";
                try {
                    num1 = Double.parseDouble(opField.getText());
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error");
                }
                catch (Exception exc) {
                    ansField.setText("Syntax error");
                }
                opField.setText("");
                break;
            case "-":
                op = "-";
                try {
                    num1 = Double.parseDouble(opField.getText());
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error");
                }
                catch (Exception exc) {
                    ansField.setText("Syntax error");
                }
                opField.setText("");
                break;
            case "x":
                op = "*";
                try {
                    num1 = Double.parseDouble(opField.getText());
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Syntax error");
                }
                catch (Exception exc) {
                    ansField.setText("Syntax error");
                }
                opField.setText("");
                break;
            case "/":
                op = "/";
                try {
                    num1 = Double.parseDouble(opField.getText());
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error");
                }
                catch (Exception exc) {
                    ansField.setText("Syntax error");
                }
                opField.setText("");
                break;
            case "=":
                try {
                    num2 = Double.parseDouble(opField.getText());
                    if (op.equals("+")) {
                        ansField.setText(Double.toString(num1 + num2));
                    }
                    else if (op.equals("-")){
                        ansField.setText(Double.toString(num1 - num2));
                    }
                    else if (op.equals("*")){
                        ansField.setText(Double.toString(num1 * num2));
                    }
                    else if (op.equals("/")){
                        ansField.setText(Double.toString(num1 / num2));
                    }
                    else if (op.equals("mod")){
                        ansField.setText(Double.toString(num1 % num2));
                    }
                }
                catch(InputMismatchException exc) {
                    ansField.setText("Error");
                }
                catch(ArithmeticException exc) {
                    ansField.setText("Error");
                }
                catch(Exception exc){
                    ansField.setText("Syntax error");
                }
                opField.setText("");
                break;
            case "x²":
                try {
                    num1 = Double.parseDouble(opField.getText());
                    ansField.setText(Double.toString(Math.pow(num1, 2)));
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error. Input only numbers");
                }
                catch (Exception except) {
                    ansField.setText("Error");
                }
                finally {
                    opField.setText("");
                }
                break;
            
            case "%":
                try {
                    num1 = Double.parseDouble(opField.getText());
                    ansField.setText(Double.toString(num1 * 100) + "%");
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error. Numbers only");
                }
                catch (Exception exc) {
                    ansField.setText("Error");
                }
                finally {
                    opField.setText("");
                }
                break;
            case "x³":
                try {
                    num1 = Double.parseDouble(opField.getText());
                    ansField.setText(Double.toString(Math.pow(num1, 3)));
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error. Input numbers only");
                }
                catch (Exception exc) {
                    ansField.setText("Error");
                }
                finally {
                    opField.setText("");
                }
                break;
            case "sin":
                try {
                    num1 = Double.parseDouble(opField.getText());
                    ansField.setText(Double.toString(Math.sin(num1)));
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error. Numbers only");
                }
                catch (Exception exc) {
                    ansField.setText("Error");
                }
                finally {
                    opField.setText("");
                }
                break;
            case "√":
                try {
                    num1 = Double.parseDouble(opField.getText());
                    ansField.setText(Double.toString(Math.sqrt(num1)));
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error. Numbers only");
                }
                catch (Exception exc) {
                    ansField.setText("Error");
                }
                finally {
                    opField.setText("");
                }
                break;
            case "tan":
                try {
                    num1 = Double.parseDouble(opField.getText());
                    ansField.setText(Double.toString(Math.tan(num1)));
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error. Numbers only");
                }
                catch (Exception exc) {
                    ansField.setText("Error");
                }
                finally {
                    opField.setText("");
                }
                break;
            case "mod":
                op = "mod";
                try {
                    num1 = Double.parseDouble(opField.getText());
                }
                catch (InputMismatchException except) {
                     ansField.setText("Error. Numbers only");
                }
                catch (Exception except) {
                    ansField.setText("Error");
                }
                finally {
                    opField.setText("");
                }
                break;
            case "cos":
                try {
                    num1 = Double.parseDouble(opField.getText());
                    ansField.setText(Double.toString(Math.cos(num1)));
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error. Numbers only");
                }
                catch (Exception exc) {
                    ansField.setText("Error");
                }
                finally {
                    opField.setText("");
                }
                break;
            case "asin":
                try {
                    num1 = Double.parseDouble(opField.getText());
                    ansField.setText(Double.toString(Math.asin(num1)));
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error. Numbers only");
                }
                catch (Exception exc) {
                    ansField.setText("Error");
                }
                finally {
                    opField.setText("");
                }
                break;
            case "atan":
                try {
                    num1 = Double.parseDouble(opField.getText());
                    ansField.setText(Double.toString(Math.atan(num1)));
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error. Numbers only");
                }
                catch (Exception exc) {
                    ansField.setText("Error");
                }
                finally {
                    opField.setText("");
                }
                break;
            case "acos":
                try {
                    num1 = Double.parseDouble(opField.getText());
                    ansField.setText(Double.toString(Math.acos(num1)));
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error. Numbers only");
                }
                catch (Exception exc) {
                    ansField.setText("Error");
                }
                finally {
                    opField.setText("");
                }
                break;
            case "sinh":
                try {
                    num1 = Double.parseDouble(opField.getText());
                    ansField.setText(Double.toString(Math.sinh(num1)));
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error. Numbers only");
                }
                catch (Exception exc) {
                    ansField.setText("Error");
                }
                finally {
                    opField.setText("");
                }
                break;
            case "tanh":
                try {
                    num1 = Double.parseDouble(opField.getText());
                    ansField.setText(Double.toString(Math.tanh(num1)));
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error. Numbers only");
                }
                catch (Exception exc) {
                    ansField.setText("Error");
                }
                finally {
                    opField.setText("");
                }
                break;
            case "cosh":
                try {
                    num1 = Double.parseDouble(opField.getText());
                    ansField.setText(Double.toString(Math.cosh(num1)));
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error. Numbers only");
                }
                catch (Exception exc) {
                    ansField.setText("Error");
                }
                finally {
                    opField.setText("");
                }
                break;
            case "log":
                try {
                    num1 = Double.parseDouble(opField.getText());
                    ansField.setText(Double.toString(Math.log10(num1)));
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error. Numbers only");
                }
                catch (Exception exc) {
                    opField.setText("Error");
                }
                finally {
                    opField.setText("");
                }
                break;
            case "ln":
                try {
                    num1 = Double.parseDouble(opField.getText());
                    ansField.setText(Double.toString(Math.log(num1)));
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error. Numbers only");
                }
                catch (Exception exc) {
                    ansField.setText("Error");
                }
                finally {
                    opField.setText("");
                }
                break;
            case "10^n":
                try {
                    num1 = Double.parseDouble(opField.getText());
                    ansField.setText(Double.toString(Math.pow(10, num1)));
                }
                catch (InputMismatchException exc) {
                    ansField.setText("Error. Numbers only");
                }
                catch (Exception exc) {
                    ansField.setText("Error");
                }
                finally {
                    opField.setText("");
                }
                break;
            case "1/n":
                try {
                    num1 = Double.parseDouble(opField.getText());
                    ansField.setText(Double.toString(1 / num1));
                }
                catch (InputMismatchException except) {
                    ansField.setText("Error. Numbers only");
                }
                catch (ArithmeticException except) {
                    ansField.setText("Error. Can't divide by zero");						
                }
                finally {
                    opField.setText("");
                }
                break;
            case "EXIT":
                dispose();
                break;
        }
    }
}


    


