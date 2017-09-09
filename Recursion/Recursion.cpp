#include<iostream>
using namespace std;

int pathsToSquare(int i, int j, int n, int[][] grid) { //set off limits to 0 for follow up
	if (i<0||j<0||i>=n||j>=n)
		return 0;
	if (i==0&&j==0) 
		return 1;
	else return pathsToSquare(i-1,j,n,grid)+pathsToSquare(i,j-1,n,grid);
}

//cci 8.2
int numPaths(int n) {
	int grid[][] = new int[n][n];
	int sum = 0;
	for (int i = 0; i<n; i++) {
		for (int j = 0; j<n; j++) {
			grid[i][j] = pathsToSquare(i,j,n,grid);
			sum+=grid[i][j];
		}
	}
	return sum;
}

//cci 8.3 
void printSubsets(int[] n,int size){ //just represent the set as an array of ints
	for (int i = 0; i<size; i++) {
		cout << n[i] << " ";
	}
	cout << endl;
	for (int i = 0; i<size; i++) {
		int[] m = new int[size-1];
		for (int j = 0; j<size-1; j++) {
			if (j!=i)
				m[j] = m[i];
		}
		printSubsets(m,size-1);
	}
}

void printPermutations(string s, string r) {
	if (s.length()==0) {
		cout << r;
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



int main() {
}