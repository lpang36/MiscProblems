//hard coding all these array dimensions lmao

#include<iostream>
using namespace std;

int pathsToSquare(int i, int j, int n) { //set off limits to 0 for follow up
	if (i<0||j<0||i>=n||j>=n)
		return 0;
	if (i==0&&j==0) 
		return 1;
	else return pathsToSquare(i-1,j,n)+pathsToSquare(i,j-1,n);
}

//cci 8.2
int numPaths(int n) {
	int grid[n][n];
	int sum = 0;
	for (int i = 0; i<n; i++) {
		for (int j = 0; j<n; j++) {
			grid[i][j] = pathsToSquare(i,j,n);
			sum+=grid[i][j];
		}
	}
	return sum;
}

void printSubsets(int n[], int m[], int size, int lim, int in) {
	if (lim==size) {
		for (int i = 0; i<in; i++) {
			cout << m[i] << " ";
		}
		cout << endl;
		return;
	}
	printSubsets(n,m,size,lim+1,in);
	m[in] = n[lim];
	printSubsets(n,m,size,lim+1,in+1);
}

//cci 8.3 
void printSubsets(int n[],int size){ //just represent the set as an array of ints
	int m[size];
	printSubsets(n,m,size,0,0);
}

void printPermutations(string s, string r) {
	if (s.length()==0) {
		cout << r << endl;
		return;
	}
	for (int i = 0; i<s.length(); i++) {
		string t = r;
		string u = "";
		for (int j = 0; j<s.length(); j++) {
			if (j!=i)
				u+=s.at(j);
		}
		t+=s.at(i);
		printPermutations(u,t);
	}
}
			 
//cci 8.4
void printPermutations(string s){
	printPermutations(s,"");
}

void printBrackets(int n, int left, int right, string s) {
	if (left==n&&right==n) 
		cout << s << endl;
	else {
		if (left<n)
			printBrackets(n,left+1,right,s+'(');
		if (right<left)
			printBrackets(n,left,right+1,s+')');
	}
}

//cci 8.5
void printBrackets(int n) {
	printBrackets(n,0,0,"");
}

void fillImage(int n[][5], int i, int j, int row, int col, int newColor, int oldColor, bool filled[][5]) {
	n[i][j] = newColor;
	filled[i][j] = true;
	if (i>0&&n[i-1][j]==oldColor&&!filled[i-1][j])
		fillImage(n,i-1,j,row,col,newColor,oldColor,filled);
	if (j>0&&n[i][j-1]==oldColor&&!filled[i][j-1])
		fillImage(n,i,j-1,row,col,newColor,oldColor,filled);
	if (i<row-1&&n[i+1][j]==oldColor&&!filled[i+1][j])
		fillImage(n,i+1,j,row,col,newColor,oldColor,filled);
	if (j<col-1&&n[i][j+1]==oldColor&&!filled[i][j+1])
		fillImage(n,i,j+1,row,col,newColor,oldColor,filled);
}

//cci 8.6
void fillImage(int n[][5], int i, int j, int row, int col, int newColor) {
	bool filled[5][5];
	for (int k = 0; k<row; k++) {
		for (int l = 0; l<col; l++) {
			filled[k][l] = false;
		}
	}
	fillImage(n,i,j,row,col,newColor,n[i][j],filled);
}

int partitionCents(int n,int max) {
	if (n==0)
		return 1;
	int sum = 0;
	if (n>=25&&max>=25) 
		sum+=partitionCents(n-25,25);
	if (n>=10&&max>=10)
		sum+=partitionCents(n-10,10);
	if (n>=5&&max>=5)
		sum+=partitionCents(n-5,5);
	if (n>=1&&max>=1)
		sum+=partitionCents(n-1,1);
	return sum;
}

//cci 8.7
int partitionCents(int n) {
	return partitionCents(n,25);
}
/*
void print2DArray(int[][5] arr, int row, int col) {
	for (int i = 0; i<row; i++) {
		for (int j = 0; j<col; j++) {
			cout << arr[i][j] << " ";
		}
		cout << endl;
	}
}
*/
int main() {
	cout << numPaths(3) << endl;
	int arr[5] = {1,2,3,4,5};
	printSubsets(arr,5);
	printPermutations("asdf");
	printBrackets(3);
	//int arr[5][5] ={{0,0,1,0,0},{0,1,1,1,0},{1,1,1,1,1},{0,1,1,1,0},{0,0,1,0,0}};
	//print2DArray(arr,5,5);
	//fillImage(arr,3,3,5,5,2);
	//print2DArray(arr,5,5);
	cout << partitionCents(27) << endl;
}