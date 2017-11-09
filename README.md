Calculator using stack based evaluation of the expression

Evaluation of Infix Expression is done using the following algorithm,

Two stacks are used:
  1. Operand Stack
  2. Operator Stack
  
# Algorithm

Until the end of the expression is reached, get one character and perform only one of the steps (1) through (4):
  1. If the character is an operand, push it onto the operand stack.
  2. If the character is an operator, and the operator stack is empty then push it onto the operator stack.
  3. If the character is an operator and the operator stack is not empty, and the character's precedence is greater than the precedence of      the stack top of operator stack, then push the character onto the operator stack.
  4. If cases (1), (2), (3) and (4) do not apply, then process as explained above.

When there are no more input characters, keep processing until the operator stack becomes empty.  The values left in the operand stack is the final result of the expression.
