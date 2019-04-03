//============================================================================
// Name        : CPP.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <sstream>
#include <array>
#include <vector>
using namespace std;

struct Product {
	int weight;
	double price;
	double total;
	Product(int w, int p)
		:weight(w), price(p) {
		total = weight * price;
	}
};


int main() {
	string str("000110");
	int len = 2;
	cout << str.find("1") << endl;
	for (int i = 0; i <= str.size() - len; i++) {
		string curr = str.substr(i, len);
		cout << curr << endl;
	}
}

