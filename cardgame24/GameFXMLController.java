/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame24;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Stack;

/**
 * FXML Controller class
 *
 * @author christophersisa
 */
public class GameFXMLController implements Initializable {

    private String[] CardName = new String[52];
    private int[] deltCardsIndex = new int[4];
    private double[] deltCardsValue = new double[4];
    private double[] arr = new double[0];
    private boolean flipXY = false;
    String equasion;
    String equasion2;
    String operation = "";
    double factorX;
    double factorY;

    @FXML
    private TextField solutionTF;

    @FXML
    private TextField expressionTF;

    @FXML
    private ImageView card1;

    @FXML
    private ImageView card2;

    @FXML
    private ImageView card3;

    @FXML
    private ImageView card4;
    
    
    
    
    
    
    
    
            /*------------------------------------------------- handleFindSolution -----
         |  Function handleFindSolution
         |
         |  Purpose:  prints solution to text field
         |
         *-------------------------------------------------------------------*/
    @FXML
    void handleFindSolution(ActionEvent event) {
        setDeltCardValue();
        double check;

        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);

        if (judgePoint24(deltCardsValue)) {

            check = evaluate(arr[9], arr[10], arr[11]);
            if (arr[4] == check) {
                if (flipXY) {
                    equasion = "(" + format.format(arr[11]) + operation + format.format(arr[10]) + ")";
                } else {
                    equasion = "(" + format.format(arr[10]) + operation + format.format(arr[11]) + ")";
                }
                check = evaluate(arr[3], arr[4], arr[5]);
                if (check == arr[1]) {
                    if (flipXY) {
                        equasion2 = "(" + format.format(arr[5]) + findOperation(arr[3]) + equasion + ")";

                    } else {
                        equasion2 = "(" + equasion + findOperation(arr[3]) + format.format(arr[5]) + ")";
                    }
                    findOperation(arr[0]);
                    if (flipXY) {
                        equasion = format.format(arr[2]) + findOperation(arr[0]) + equasion2;
                    } else {
                        equasion = equasion2 + findOperation(arr[0]) + format.format(arr[2]);
                    }
                } else if (check == arr[2]) {
                    if (flipXY) {
                        equasion2 = "(" + format.format(arr[5]) + findOperation(arr[3]) + equasion + ")";

                    } else {
                        equasion2 = "(" + equasion + findOperation(arr[3]) + format.format(arr[5]) + ")";
                    }
                    findOperation(arr[0]);
                    if (flipXY) {
                        equasion = equasion2 + findOperation(arr[0]) + format.format(arr[1]);
                    } else {
                        equasion = format.format(arr[1]) + findOperation(arr[0]) + equasion2;
                    }
                }
            } else if (arr[5] == check) {
                if (flipXY) {
                    equasion = "(" + format.format(arr[11]) + operation + format.format(arr[10]) + ")";
                } else {
                    equasion = "(" + format.format(arr[10]) + operation + format.format(arr[11]) + ")";
                }
                check = evaluate(arr[3], arr[4], arr[5]);
                if (check == arr[1]) {
                    if (flipXY) {
                        equasion2 = "(" + equasion + findOperation(arr[3]) + format.format(arr[4]) + ")";
                    } else {
                        equasion2 = "(" + format.format(arr[4]) + findOperation(arr[3]) + equasion + ")";
                    }
                    findOperation(arr[0]);
                    if (flipXY) {
                        equasion = format.format(arr[2]) + findOperation(arr[0]) + equasion2;
                    }
                    equasion = equasion2 + findOperation(arr[0]) + format.format(arr[2]);
                } else if (check == arr[2]) {
                    if (flipXY) {
                        equasion2 = "(" + equasion + findOperation(arr[3]) + format.format(arr[4]) + ")";
                    } else {
                        equasion2 = "(" + format.format(arr[4]) + findOperation(arr[3]) + equasion + ")";
                    }
                    findOperation(arr[0]);
                    if (flipXY) {
                        equasion = equasion2 + findOperation(arr[0]) + format.format(arr[1]);
                    }
                    equasion = format.format(arr[1]) + findOperation(arr[0]) + equasion2;
                }
            } else if (arr[1] == check) {
                if (flipXY) {
                    equasion = "(" + format.format(arr[11]) + operation + format.format(arr[10]) + ")";// + findOperation(arr[0]) + format.format(arr[2]);
                } else {
                    equasion = "(" + format.format(arr[10]) + operation + format.format(arr[11]) + ")"; //+ findOperation(arr[0]) ;//+ format.format(arr[2]);
                }
                check = evaluate(arr[3], arr[4], arr[5]);
                if (check == arr[2]) {
                    if (flipXY) {
                        equasion2 = format.format(arr[5]) + findOperation(arr[3]) + format.format(arr[4]);
                    } else {
                        equasion2 = format.format(arr[4]) + findOperation(arr[3]) + format.format(arr[5]);
                    }
                    findOperation(arr[0]);
                    if (flipXY) {
                        equasion = "(" + equasion2 + ")" + findOperation(arr[0]) + equasion;
                    } else {
                        equasion = equasion + findOperation(arr[0]) + "(" + equasion2 + ")";
                    }
                }
            } else if (arr[2] == check) {
                if (flipXY) {
                    equasion = "(" + format.format(arr[11]) + operation + format.format(arr[10]) + ")";// + findOperation(arr[0]) + format.format(arr[2]);
                } else {
                    equasion = "(" + format.format(arr[10]) + operation + format.format(arr[11]) + ")"; //+ findOperation(arr[0]) ;//+ format.format(arr[2]);
                }
                check = evaluate(arr[3], arr[4], arr[5]);
                if (check == arr[1]) {
                    if (flipXY) {
                        equasion2 = format.format(arr[5]) + findOperation(arr[3]) + format.format(arr[4]);

                    } else {
                        equasion2 = format.format(arr[4]) + findOperation(arr[3]) + format.format(arr[5]);
                    }
                    findOperation(arr[0]);
                    if (flipXY) {
                        equasion = equasion + findOperation(arr[0]) + "(" + equasion2 + ")";

                    } else {
                        equasion = "(" + equasion2 + ")" + findOperation(arr[0]) + equasion;
                    }

                }
            }

            solutionTF.setText(equasion);
        } else {
            solutionTF.setText("solution not found");
        }

    }

    
            /*------------------------------------------------- Evaluate -----
         |  Function evaluate
         |
         |  Purpose:  takes a string and returns the solution to the expresion
         |
         |  Parameters:
         |      string expression
         |  Returns:  int 
         *-------------------------------------------------------------------*/
    public static int evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        // Stack for numbers: 'values'
        Stack<Integer> values = new Stack<Integer>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {

            // Current token is a 
            // whitespace, skip it
            if (tokens[i] == ' ') {
                continue;
            }

            // Current token is a number, 
            // push it to stack for numbers
            if (tokens[i] >= '0'
                    && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();

                // There may be more than one 
                // digits in number
                while (i < tokens.length
                        && tokens[i] >= '0'
                        && tokens[i] <= '9') {
                    sbuf.append(tokens[i++]);
                }
                values.push(Integer.parseInt(sbuf.
                        toString()));

                // right now the i points to 
                // the character next to the digit,
                // since the for loop also increases 
                // the i, we would skip one 
                //  token position; we need to 
                // decrease the value of i by 1 to
                // correct the offset.
                i--;
            } // Current token is an opening brace, 
            // push it to 'ops'
            else if (tokens[i] == '(') {
                ops.push(tokens[i]);
            } // Closing brace encountered, 
            // solve entire brace
            else if (tokens[i] == ')') {
                while (ops.peek() != '(') {
                    values.push(applyOp(ops.pop(),
                            values.pop(),
                            values.pop()));
                }
                ops.pop();
            } // Current token is an operator.
            else if (tokens[i] == '+'
                    || tokens[i] == '-'
                    || tokens[i] == '*'
                    || tokens[i] == '/') {
                // While top of 'ops' has same 
                // or greater precedence to current
                // token, which is an operator.
                // Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty()
                        && hasPrecedence(tokens[i],
                                ops.peek())) {
                    values.push(applyOp(ops.pop(),
                            values.pop(),
                            values.pop()));
                }

                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }

        // Entire expression has been 
        // parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty()) {
            values.push(applyOp(ops.pop(),
                    values.pop(),
                    values.pop()));
        }

        // Top of 'values' contains 
        // result, return it
        return values.pop();
    }

    // Returns true if 'op2' has higher 
    // or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(
            char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/')
                && (op2 == '+' || op2 == '-')) {
            return false;
        } else {
            return true;
        }
    }

    // A utility method to apply an 
    // operator 'op' on operands 'a' 
    // and 'b'. Return the result.
    public static int applyOp(char op,
            int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException(
                            "Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }
        /*------------------------------------------------- findOperation -----
         |  Function FUNCTION_NAME
         |
         |  Purpose:  returns operation of the numbers being evaluated (number in array indicates which operation to use)

         |  Returns: String or operation
         *-------------------------------------------------------------------*/
    private String findOperation(double operatorNum) {
        if (operatorNum == 1) {
            flipXY = false;
            return "+";

        } else if (operatorNum == 2) {
            flipXY = false;
            return "-";
        } else if (operatorNum == 3) {
            flipXY = true;
            return "-";
        } else if (operatorNum == 4) {
            flipXY = false;
            return "*";
        } else if (operatorNum == 5) {
            flipXY = false;
            return "/";
        } else if (operatorNum == 6) {
            flipXY = true;
            return "/";
        } else {
            flipXY = false;
        }
        return "";
    }

    private double evaluate(double operatorNum, double numx, double numy) {
        if (operatorNum == 1) {
            operation = "+";
            flipXY = false;
            return numx + numy;
        } else if (operatorNum == 2) {
            operation = "-";
            flipXY = false;
            return numx - numy;
        } else if (operatorNum == 3) {
            operation = "-";
            flipXY = true;
            return numy - numx;
        } else if (operatorNum == 4) {
            operation = "*";
            flipXY = false;
            return numx * numy;
        } else if (operatorNum == 5) {
            operation = "/";
            flipXY = false;
            return numx / numy;
        } else if (operatorNum == 6) {
            operation = "/";
            flipXY = true;
            return numy / numx;
        } else {
            flipXY = false;
        }
        return -100;
    }

    public double[] getDeltCardsValue() {
        return this.deltCardsValue;
    }

    public boolean judgePoint24(double[] nums) {
        double[] a = new double[]{nums[0], nums[1], nums[2], nums[3]};
        return helper(a);
    }

    
            /*------------------------------------------------- helper-----
         |  Function helper
         |
         |  Purpose:  returns factors of cards delt
         |  Parameters:array of card numbers

         *-------------------------------------------------------------------*/
    private boolean helper(double[] a) {

        //check to see if expression is 24
        if (a.length == 1) {
            return Math.abs(a[0] - 24) < 0.0001;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                double[] d = new double[a.length - 1];
                for (int k = 0, index = 0; k < a.length; k++) {
                    if (k != i && k != j) {
                        d[index++] = a[k];
                    }
                }
                int counter = 0;
                for (double num : compute(a[i], a[j])) {
                    counter++;
                    d[d.length - 1] = num;

                    if (helper(d)) {
                        arr = Arrays.copyOf(arr, arr.length + 1);
                        arr[arr.length - 1] = counter;

                        arr = Arrays.copyOf(arr, arr.length + 1);
                        arr[arr.length - 1] = a[i];
                        arr = Arrays.copyOf(arr, arr.length + 1);
                        arr[arr.length - 1] = a[j];

                        factorX = a[i];
                        factorY = a[j];

                    }
                    if (helper(d)) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    private double[] compute(double x, double y) {
        return new double[]{x + y, x - y, y - x, x * y, x / y, y / x};

    }

            /*------------------------------------------------- setDeltCardValue-----
         |  Function setDeltCardValue
         |
         |  Purpose:  populates deltCardsIndex array with the value of the cards delt
         |

         *-------------------------------------------------------------------*/
    private void setDeltCardValue() {

        if (CardName[deltCardsIndex[0]].contains("ace_")) {
            deltCardsValue[0] = 1;
        } else if (CardName[deltCardsIndex[0]].contains("2_")) {
            deltCardsValue[0] = 2;
        } else if (CardName[deltCardsIndex[0]].contains("3_")) {
            deltCardsValue[0] = 3;
        } else if (CardName[deltCardsIndex[0]].contains("4_")) {
            deltCardsValue[0] = 4;
        } else if (CardName[deltCardsIndex[0]].contains("5_")) {
            deltCardsValue[0] = 5;
        } else if (CardName[deltCardsIndex[0]].contains("6_")) {
            deltCardsValue[0] = 6;
        } else if (CardName[deltCardsIndex[0]].contains("7_")) {
            deltCardsValue[0] = 7;
        } else if (CardName[deltCardsIndex[0]].contains("8_")) {
            deltCardsValue[0] = 8;
        } else if (CardName[deltCardsIndex[0]].contains("9_")) {
            deltCardsValue[0] = 9;
        } else if (CardName[deltCardsIndex[0]].contains("10_")) {
            deltCardsValue[0] = 10;
        } else if (CardName[deltCardsIndex[0]].contains("jack_")) {
            deltCardsValue[0] = 11;
        } else if (CardName[deltCardsIndex[0]].contains("queen_")) {
            deltCardsValue[0] = 12;
        } else if (CardName[deltCardsIndex[0]].contains("king")) {
            deltCardsValue[0] = 13;
        } else {
            System.out.println("error");
        }

        if (CardName[deltCardsIndex[1]].contains("ace_")) {
            deltCardsValue[1] = 1;
        } else if (CardName[deltCardsIndex[1]].contains("2_")) {
            deltCardsValue[1] = 2;
        } else if (CardName[deltCardsIndex[1]].contains("3_")) {
            deltCardsValue[1] = 3;
        } else if (CardName[deltCardsIndex[1]].contains("4_")) {
            deltCardsValue[1] = 4;
        } else if (CardName[deltCardsIndex[1]].contains("5_")) {
            deltCardsValue[1] = 5;
        } else if (CardName[deltCardsIndex[1]].contains("6_")) {
            deltCardsValue[1] = 6;
        } else if (CardName[deltCardsIndex[1]].contains("7_")) {
            deltCardsValue[1] = 7;
        } else if (CardName[deltCardsIndex[1]].contains("8_")) {
            deltCardsValue[1] = 8;
        } else if (CardName[deltCardsIndex[1]].contains("9_")) {
            deltCardsValue[1] = 9;
        } else if (CardName[deltCardsIndex[1]].contains("10_")) {
            deltCardsValue[1] = 10;
        } else if (CardName[deltCardsIndex[1]].contains("jack_")) {
            deltCardsValue[1] = 11;
        } else if (CardName[deltCardsIndex[1]].contains("queen_")) {
            deltCardsValue[1] = 12;
        } else if (CardName[deltCardsIndex[1]].contains("king")) {
            deltCardsValue[1] = 13;
        } else {
            System.out.println("error");
        }

        if (CardName[deltCardsIndex[2]].contains("ace_")) {
            deltCardsValue[2] = 1;
        } else if (CardName[deltCardsIndex[2]].contains("2_")) {
            deltCardsValue[2] = 2;
        } else if (CardName[deltCardsIndex[2]].contains("3_")) {
            deltCardsValue[2] = 3;
        } else if (CardName[deltCardsIndex[2]].contains("4_")) {
            deltCardsValue[2] = 4;
        } else if (CardName[deltCardsIndex[2]].contains("5_")) {
            deltCardsValue[2] = 5;
        } else if (CardName[deltCardsIndex[2]].contains("6_")) {
            deltCardsValue[2] = 6;
        } else if (CardName[deltCardsIndex[2]].contains("7_")) {
            deltCardsValue[2] = 7;
        } else if (CardName[deltCardsIndex[2]].contains("8_")) {
            deltCardsValue[2] = 8;
        } else if (CardName[deltCardsIndex[2]].contains("9_")) {
            deltCardsValue[2] = 9;
        } else if (CardName[deltCardsIndex[2]].contains("10_")) {
            deltCardsValue[2] = 10;
        } else if (CardName[deltCardsIndex[2]].contains("jack_")) {
            deltCardsValue[2] = 11;
        } else if (CardName[deltCardsIndex[2]].contains("queen_")) {
            deltCardsValue[2] = 12;
        } else if (CardName[deltCardsIndex[2]].contains("king")) {
            deltCardsValue[2] = 13;
        } else {
            System.out.println("error");
        }

        if (CardName[deltCardsIndex[3]].contains("ace_")) {
            deltCardsValue[3] = 1;
        } else if (CardName[deltCardsIndex[3]].contains("2_")) {
            deltCardsValue[3] = 2;
        } else if (CardName[deltCardsIndex[3]].contains("3_")) {
            deltCardsValue[3] = 3;
        } else if (CardName[deltCardsIndex[3]].contains("4_")) {
            deltCardsValue[3] = 4;
        } else if (CardName[deltCardsIndex[3]].contains("5_")) {
            deltCardsValue[3] = 5;
        } else if (CardName[deltCardsIndex[3]].contains("6_")) {
            deltCardsValue[3] = 6;
        } else if (CardName[deltCardsIndex[3]].contains("7_")) {
            deltCardsValue[3] = 7;
        } else if (CardName[deltCardsIndex[3]].contains("8_")) {
            deltCardsValue[3] = 8;
        } else if (CardName[deltCardsIndex[3]].contains("9_")) {
            deltCardsValue[3] = 9;
        } else if (CardName[deltCardsIndex[3]].contains("10_")) {
            deltCardsValue[3] = 10;
        } else if (CardName[deltCardsIndex[3]].contains("jack_")) {
            deltCardsValue[3] = 11;
        } else if (CardName[deltCardsIndex[3]].contains("queen_")) {
            deltCardsValue[3] = 12;
        } else if (CardName[deltCardsIndex[3]].contains("king")) {
            deltCardsValue[3] = 13;
        } else {
            System.out.println("error");
        }

    }


    
            /*------------------------------------------------- handleRefresh -----
         |  Function handleRefresh
         |
         |  Purpose:  deals new cards and resets text fields
         |

         *-------------------------------------------------------------------*/
    @FXML
    void handleRefresh(ActionEvent event) {
        solutionTF.clear();
        expressionTF.clear();
        equasion = "";
        equasion2 = "";
        arr = Arrays.copyOf(arr, 0);

        flipXY = false;
        Random rand = new Random();
        int maxNumber = 51;

        for (int i = 0; i < 4; i++) {
            deltCardsIndex[i] = -1;
        }

        int randomNumber;
        randomNumber = rand.nextInt(maxNumber);
        deltCardsIndex[0] = randomNumber;
        Image image = new Image(getClass().getResourceAsStream("/png/" + CardName[randomNumber] + ".png"));
        card1.setImage(image);

        randomNumber = rand.nextInt(maxNumber);
        while (randomNumber == deltCardsIndex[0]) {
            randomNumber = rand.nextInt(maxNumber);
        }
        deltCardsIndex[1] = randomNumber;
        image = new Image(getClass().getResourceAsStream("/png/" + CardName[randomNumber] + ".png"));
        card2.setImage(image);

        randomNumber = rand.nextInt(maxNumber);
        while (randomNumber == deltCardsIndex[0] || randomNumber == deltCardsIndex[1]) {
            randomNumber = rand.nextInt(maxNumber);
        }
        deltCardsIndex[2] = randomNumber;
        image = new Image(getClass().getResourceAsStream("/png/" + CardName[randomNumber] + ".png"));
        card3.setImage(image);

        randomNumber = rand.nextInt(maxNumber);
        while (randomNumber == deltCardsIndex[0] || randomNumber == deltCardsIndex[1] || randomNumber == deltCardsIndex[2]) {
            randomNumber = rand.nextInt(maxNumber);
        }
        deltCardsIndex[3] = randomNumber;
        image = new Image(getClass().getResourceAsStream("/png/" + CardName[randomNumber] + ".png"));
        card4.setImage(image);
    }

    @FXML
    void handleVerify(ActionEvent event) {
        String userEx = expressionTF.getText();

        if (expressionTF.getText().isEmpty() || expressionTF.getText().matches(".*[a-z].*")) {
            expressionTF.setText("Input expression, ex: (3*2)*(10-6)");
        } else {
            int answer = evaluate(userEx);
            boolean valid = false;
            String card = "";
            DecimalFormat format = new DecimalFormat();
            format.setDecimalSeparatorAlwaysShown(false);

            if (answer == 24) {
                for (int i = 0; i < deltCardsValue.length; i++) {
                    card = format.format(deltCardsValue[i]);
                    System.out.println(card);
                    if (!userEx.contains(card)) {
                        valid = false;
                        break;
                    } else {
                        valid = true;
                    }
                }
            }
            if (valid) {
                expressionTF.setText("Correct Answer!!");
            } else {
                expressionTF.setText("Incorrect Answer");
            }
        }

    }

    
            /*------------------------------------------------- FUNCTION_NAME -----
         |  Function FUNCTION_NAME
         |
         |  Purpose:   creates string array with the names of every card in a deck
         |

         *-------------------------------------------------------------------*/

    private void createDeck() {

        CardName[0] = "ace_of_clubs";
        CardName[1] = "2_of_clubs";
        CardName[2] = "3_of_clubs";
        CardName[3] = "4_of_clubs";
        CardName[4] = "5_of_clubs";
        CardName[5] = "6_of_clubs";
        CardName[6] = "7_of_clubs";
        CardName[7] = "8_of_clubs";
        CardName[8] = "9_of_clubs";
        CardName[9] = "10_of_clubs";
        CardName[10] = "jack_of_clubs";
        CardName[11] = "queen_of_clubs";
        CardName[12] = "king_of_clubs";
        CardName[13] = "ace_of_hearts";
        CardName[14] = "2_of_hearts";
        CardName[15] = "3_of_hearts";
        CardName[16] = "4_of_hearts";
        CardName[17] = "5_of_hearts";
        CardName[18] = "6_of_hearts";
        CardName[19] = "7_of_hearts";
        CardName[20] = "8_of_hearts";
        CardName[21] = "9_of_hearts";
        CardName[22] = "10_of_hearts";
        CardName[23] = "jack_of_hearts";
        CardName[24] = "queen_of_hearts";
        CardName[25] = "king_of_hearts";
        CardName[26] = "ace_of_spades";
        CardName[27] = "2_of_spades";
        CardName[28] = "3_of_spades";
        CardName[29] = "4_of_spades";
        CardName[30] = "5_of_spades";
        CardName[31] = "6_of_spades";
        CardName[32] = "7_of_spades";
        CardName[33] = "8_of_spades";
        CardName[34] = "9_of_spades";
        CardName[35] = "10_of_spades";
        CardName[36] = "jack_of_spades";
        CardName[37] = "queen_of_spades";
        CardName[38] = "king_of_spades";
        CardName[39] = "ace_of_diamonds";
        CardName[40] = "2_of_diamonds";
        CardName[41] = "3_of_diamonds";
        CardName[42] = "4_of_diamonds";
        CardName[43] = "5_of_diamonds";
        CardName[44] = "6_of_diamonds";
        CardName[45] = "7_of_diamonds";
        CardName[46] = "8_of_diamonds";
        CardName[47] = "9_of_diamonds";
        CardName[48] = "10_of_diamonds";
        CardName[49] = "jack_of_diamonds";
        CardName[50] = "queen_of_diamonds";
        CardName[51] = "king_of_diamonds";

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createDeck();
        Random rand = new Random();
        int maxNumber = 51;

        int randomNumber;

        randomNumber = rand.nextInt(maxNumber);
        deltCardsIndex[0] = randomNumber;
        Image image = new Image(getClass().getResourceAsStream("/png/" + CardName[randomNumber] + ".png"));
        card1.setImage(image);

        randomNumber = rand.nextInt(maxNumber);
        while (randomNumber == deltCardsIndex[0]) {
            randomNumber = rand.nextInt(maxNumber);
        }
        deltCardsIndex[1] = randomNumber;
        image = new Image(getClass().getResourceAsStream("/png/" + CardName[randomNumber] + ".png"));
        card2.setImage(image);

        randomNumber = rand.nextInt(maxNumber);
        while (randomNumber == deltCardsIndex[0] || randomNumber == deltCardsIndex[1]) {
            randomNumber = rand.nextInt(maxNumber);
        }
        deltCardsIndex[2] = randomNumber;
        image = new Image(getClass().getResourceAsStream("/png/" + CardName[randomNumber] + ".png"));
        card3.setImage(image);

        randomNumber = rand.nextInt(maxNumber);
        while (randomNumber == deltCardsIndex[0] || randomNumber == deltCardsIndex[1] || randomNumber == deltCardsIndex[2]) {
            randomNumber = rand.nextInt(maxNumber);
        }
        deltCardsIndex[3] = randomNumber;
        image = new Image(getClass().getResourceAsStream("/png/" + CardName[randomNumber] + ".png"));
        card4.setImage(image);
    }

}
