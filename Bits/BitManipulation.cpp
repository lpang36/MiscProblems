#include<iostream>
#include<math.h>
using namespace std;
//cci 5.1
int setBitSubstring(int n, int m, int i, int j) {
	int t1 = n >> j+1;
	int t2 = t1 << j+1;
	int t3 = n << 32-i;
	int t4 = n >> 32-i;
	int t5 = m << i+1;
	int t6 = t2 | t4 | t5;
	return t6;
}
int numOneBits(int n) {
	int exp = pow(2,31);
	int count = 0;
	int i = 0;
	for(int i = 0; i<32; i++) {
		if (exp<=n) {
			n = n-exp;
			count++;
		}
		exp = pow(2,30-i);
	}
	return count;
}
//cci 5.3
void printEqualOneBits(int n) {
	int t1 = numOneBits(n);
	int t2 = n+1;
	while(true) {
		if(numOneBits(t2)==t1) {
			cout << t2 << endl;
			break;
		}
		t2++;
	}
	int t3 = n-1;
	while(true) {
		if(numOneBits(t3)==t1) {
			cout << t3 << endl;
			break;
		}
		t3--;
	}
}
//cci 5.5
int numBitsToConvert(int a, int b) {
	return numOneBits(a^b);
}
//cci 5.6
int swapOddEven(int a) {
	int t1 = a<<1;
	int t2 = a>>1;
	int t3 = t1&0b10101010101010101010101010101010;
	int t4 = t2&0b01010101010101010101010101010101;
	int t5 = t3|t4;
	return t5;
}
int findNthBit(int n, int i) {
	int exp = pow(2,31);
	int bit = 0;
	for(int j = 0; j<32-i; j++) {
		if (exp<=n) {
			bit = 1;
			n = n-exp;
		}
		else
			bit = 0;
		exp = pow(2,30-j);
	}
	return bit;
}
int findNthBitOfElement(int arr[], int k, int i) {
	return findNthBit(arr[k],i);
}
//cci 5.7
int findMissing(int arr[], int length) {
	length++;
	int sum = 0;
	for (int i = 0; i<32; i++) {
		int bit = findNthBit(length,i);
		int num1=0;
		int mod = pow(2,i+1);
		int r = (length+1)%mod;
		if (pow(2,i)<=length) {
			if (r>pow(2,i)) 
				num1 = (length+1-r)/2+r-pow(2,i);
			else 
				num1 = (length+1-r)/2;
		}
		int count0 = 0;
		int count1 = 0;
		for (int j = 0; j<length; j++) {
			int temp = findNthBitOfElement(arr,j,i);
			if(temp)
				count1++;
		}
		if (count1!=num1) 
			sum+=pow(2,i);
	}
	return sum;
}
void printBinary(int n) {
	int exp = pow(2,31);
	for (int i = 0; i<32; i++) {
		if (exp<=n) {
			cout << 1;
			n = n-exp;
		}
		else 
			cout << 0;
		exp = pow(2,30-i);
	}
	cout << endl;
}
void altPrintBinary(int n) {
	for (int i = 31; i>=0; i--) {
		cout << findNthBit(n,i);
	}
	cout << endl;
}
int main() {
	printBinary(1000);
	altPrintBinary(1000);
	printBinary(setBitSubstring(0b10000000000,0b10101,2,6));
	printEqualOneBits(10);
	cout << numBitsToConvert(7,8) << endl;
	cout << swapOddEven(19) << endl;
	int arr[16] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,16};
	cout << findMissing(arr,15);
	return 0;
}
