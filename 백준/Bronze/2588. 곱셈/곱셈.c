#include <stdio.h>
int main(void){

int a,b;
int c,d,e,f,g;

scanf("%d",&a);
scanf("%d",&b);

c=b%100%10;//일의자리
d=b%100/10;//십의자리
e=b/100;//백의자리  


printf("%d\n",a*c); 
printf("%d\n",a*d);
printf("%d\n",a*e);
printf("%d\n",a*b);
	return 0;
}