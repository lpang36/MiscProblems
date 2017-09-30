#include<iostream>
#include<string>
using namespace std;
string round (string a, int i) {
	char b = a.at(i);
	string s = a.substr(0,i)+'a'+a.substr(i+1,a.length()-i);
	if (b>='a'&&b<='m')
		return s;
	else {
		if (i==0)
			return 'a'+s;
		else if (a.at(i-1)=='z') 
			return round(s,i-1);
		else
			return s.substr(0,i-1)+(char)(a.at(i-1)+1)+s.substr(i,a.length()-i+1);
	}
}
int main() {
	string a = "";
	cin >> a; 
	a = round(a,a.length()-1);
	cout << a << endl;
}