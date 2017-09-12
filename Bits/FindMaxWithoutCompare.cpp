#include<iostream>
using namespace std;
//cci 19.4
int main() {
	int a, b;
	cin >> a;
	cin >> b;
	cout << ((((a-b)>>31)==-1)*b+(((b-a)>>31)==-1)*a) << endl; //might be implementation dependent
}
