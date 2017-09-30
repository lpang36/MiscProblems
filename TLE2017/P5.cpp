#include<iostream>
using namespace std;
int main() {
	int r,c;
	cin >> r >> c;
	int rl [r];
	int rr [r];
	int cl [c];
	int cr [c];
	for (int i = 0; i<r; i++) {
		cin >> rl[i] >> rr[i];
	}
	for (int i = 0; i<c; i++) {
		cin >> cl[i] >> cr[i];
	}
	for (int i = 0; i<c; i++) {
		for (int j = cl[i]; j<=cr[i]; j++) {
			if (i+1<rl[j-1]||i+1>rr[j-1]) {
				cout << "nonsense\n" << j << " " << i+1 << endl;
				return 0;
			}
		}
	}
	for (int i = 0; i<r; i++) {
		for (int j = rl[i]; j<=rr[i]; j++) {
			if (i+1<cl[j-1]||i+1>cr[j-1]) {
				cout << "nonsense\n" << i+1 << " " << j << endl;
				return 0;
			}
		}
	}
	bool dir;
	if (r!=1) {
		dir = (cl[0]<cl[1]);
		if (dir) {
			int lastr = cr[0];
			for (int i = 0; i<c; i++) {
				if (lastr<cl[i]) {
					cout << "nonsense\nunconnected" << endl;
					return 0;
				}
				lastr = cr[i];
			}
		}
		else {
			int lastl = cl[0];
			for (int i = 0; i<c; i++) {
				if (lastl>cr[i]) {
					cout << "nonsense\nunconnected" << endl;
					return 0;
				}
				lastl = cl[i];
			}
		}
	}
	cout << "sense" << endl;
}