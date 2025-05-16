#include <stdio.h>
int(*pFcn)(int, int);
int Add(int a, int b);
int Subtract(int a, int b);
int Multiply(int a , int b);
int Divide(int a , int b);

int main(){
   int X, Y, operation; 
   printf("Enter a number: ");
   scanf(" %d", &X);
   printf("Enter another number: ");
   scanf(" %d", &Y);
   printf("Enter an operation (0=add, 1=subtract, 2=multiply, 3 = Divide ): ");
   scanf(" %d", &operation);
   switch (operation) {
      case 0: pFcn = Add; break;
      case 1: pFcn = Subtract; break;
      case 2: pFcn = Multiply; break; 
      case 3: pFcn = Divide; break;
   }
   printf("The answer is : %d\n", pFcn(X,Y)); 
   return 0;
}

int Add(int a, int b){
   return a+b;
}

int Subtract(int a, int b){
   return a-b;
}

int Multiply(int a, int b){
   return a*b;
}

int Divide(int a, int b){
   return a/b;
}
