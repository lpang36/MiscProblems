#include<iostream>
using namespace std;
//cci 19.1
int main() {
	int a, b;
	cin >> a;
	cin >> b;
	a = a+b;
	b = a-b;
	a = a-b;
	cout << a << " " << b << endl;
}
