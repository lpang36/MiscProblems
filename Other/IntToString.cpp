#include<iostream>
using namespace std;
//cci 19.6
string mapOnes(int x) {
	if (x==1)
		return "One";
	if (x==2)
		return "Two";
	if (x==3)
		return "Three";
	if (x==4)
		return "Four";
	if (x==5)
		return "Five";
	if (x==6)
		return "Six";
	if (x==7)
		return "Seven";
	if (x==8)
		return "Eight";
	if (x==9)
		return "Nine";
	return "";
}
string mapTeens(int x) {
	if (x==10)
		return "Ten";
	if (x==11)
		return "Eleven";
	if (x==12)
		return "Twelve";
	if (x==13)
		return "Thirteen";
	if (x==14)
		return "Fourteen";
	if (x==15)
		return "Fifteen";
	if (x==16)
		return "Sixteen";
	if (x==17)
		return "Seventeen";
	if (x==18)
		return "Eighteen";
	if (x==19)
		return "Nineteen";
	return "";
}
string mapTens(int x) {
	if (x==2)
		return "Twenty";
	if (x==3)
		return "Thirty";
	if (x==4)
		return "Forty";
	if (x==5)
		return "Fifty";
	if (x==6)
		return "Sixty";
	if (x==7)
		return "Seventy";
	if (x==8)
		return "Eighty";
	if (x==9)
		return "Ninety";
	return "";
}
string getHundreds(int x) {
	string s="";
	if (x>=100) 
		s+=mapOnes(x/100)+" Hundred";
	if (x%100!=0&&x>=100)
		s+=" and ";
	if (x%100>=20) 
		s+=mapTens((x%100)/10)+" "+mapOnes(x%10);
	else if (x%100>=10)
		s+=mapTeens(x%100);
	else if (x>0)
		s+=mapOnes(x%100);
	return s;
}
int main() {
	int a;
	cin >> a;
	if (a==0) {
		cout << "Zero" << endl;
	}
	else {
		string s="";
		if (a>=1000)
			s+=getHundreds(a/1000)+" Thousand ";
		s+=getHundreds(a%1000);
		cout << s << endl;
	}
}
