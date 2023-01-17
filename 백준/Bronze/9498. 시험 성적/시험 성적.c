#include <stdio.h>
int main()
{
	
int number;

scanf("%d",&number);

if(90<=number&&number<=100){
 printf("A\n");}
else if(80<=number&&number<90){
 printf("B\n");}
else if(70<=number&&number<80) {
printf("C\n");}
else if(60<=number&&number<70) {
printf("D\n");}
else{
 printf("F\n");}

	return 0;
}