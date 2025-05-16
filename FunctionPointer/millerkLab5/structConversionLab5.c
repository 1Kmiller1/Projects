#include <stdio.h>
#include <stdlib.h>

struct Person{ 
   char name[BUFSIZ]; 
   char ssn[BUFSIZ]; 
   int age; 
   float height; 
   float weight; 
};

struct Person readData(){
   struct Person p1;
	   char buff[BUFSIZ];
	   fgets(p1.name,BUFSIZ,stdin);
      fgets(p1.ssn,BUFSIZ,stdin);
         fgets(buff,BUFSIZ,stdin);
	   p1.age = atoi(buff);
         fgets(buff,BUFSIZ,stdin);
	   p1.height = atof(buff);
         fgets(buff,BUFSIZ,stdin);;
      p1.weight = atof(buff);
   return p1;
}


void printData(struct Person p){
   

	printf("%s\n%s\nAge = %d\nHeight(cm) = %g\nWeight(kg) = %g\n", p.name, p.ssn, p.age, p.height, p.weight);

}


int main(){
    printf("Reading data ......\n");
    struct Person p = readData();
    printf("\n");
    printf("Printing data ....\n");
    printData(p);

	 return 0;
}
