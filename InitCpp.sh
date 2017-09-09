#!/bin/bash
if [ "$#" -eq 2 ]; then
    cd $1
    echo "#include<iostream>
using namespace std;
int main() {
}" >> $2.cpp
    notepadqq $2.cpp
    cd ..
fi
if [ "$#" -eq 1 ]; then
    #do stuff
    echo "#include<iostream>
using namespace std;
int main() {
}" >> $1.cpp
    notepadqq $1.cpp
fi
