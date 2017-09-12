#include<iostream>
using namespace std;
//cci 19.3
int main() {
	int x;
	cin >> x;
	int sum = 0;
	int q = 5;
	while(q<x) {
		sum+=x/q;
		q*=5;
	}
	cout << sum << endl;
}
