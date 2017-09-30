#include<iostream>
using namespace std;
int main() {
	int n,t;
	cin >> n >> t;
	bool orig [n];
	int count = 0;
	for (int i = 0; i<n; i++) {
		char c;
		cin >> c;
		if (c=='|') {
			orig[i] = true;
			count+=3;
		}
		else {
			orig[i] = false;
			count++;
		}
	}
	//cout << count << endl;
	int last = count;
	for (int j = 0; j<t; j++) {
		int x;
		cin >> x;
		orig[x-1] = !orig[x-1];
		if (orig[x-1])
			count = last+2;
		else
			count = last-2;
		if (!orig[0])
			cout << count << endl;
		else
			cout << 1 << endl;
		last = count;
	}
}