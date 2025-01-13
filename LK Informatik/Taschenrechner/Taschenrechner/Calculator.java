class Calculator {
    
  // Attribute
  private char operation;
  private int operand1, operand2;
  private int state; // zustand
  private static String digits = "0123456789";
  private static String ops = "+-\u00B7:=";
  //private static String equals = "=";

  public Calculator() {
    operation = '.';
    state = 0;
    
  }
  
  public void eingeben(char c) {
    if (c == 'C') {
      state = 0;
      operation = '.';
    } 
    
    switch (state) {
      case  0: 
        if (digits.indexOf(c) > -1) {
          operand1 = Integer.parseInt(""+c);   // Trick: So wird aus c ein String
          state = 1; 
        }
        break;
      case  1: 
        if (digits.indexOf(c) > -1) {
          operand1 = operand1*10 + Integer.parseInt(""+c);         
        } 
        if (ops.indexOf(c) > -1) {
          operation = c;
          if (operation == '*') operation = '\u00B7';
          if (operation == '/') operation = ':';
          state = 2;
        }
        break;
      case 2:
        if (digits.indexOf(c) > -1) {
          operand2 = Integer.parseInt(""+c);         
          state = 3;
        } 
        if (ops.indexOf(c) > -1) {
          operation = c;
        }
        break;
      case 3:
        if (ops.indexOf(c) > -1) {
          operation = c;
          if (operation == '*') {

            operation = '\u00B7';
          }
          if (operation == '/') operation = ':';
          state = 2;
        }
        if (digits.indexOf(c) > -1) {
          operand2 = operand2*10 + Integer.parseInt(""+c);
        }


    }
    }
            
  public String getAusgabe() {
    String ausgabe = "";
    switch (state) {
      case 3 : ausgabe = operand2+ausgabe;
      case 2 : ausgabe = operation+ausgabe;
      case 1 : ausgabe = operand1+ausgabe;
    } 
    return ausgabe;
  }
}