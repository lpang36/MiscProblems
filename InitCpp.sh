#!/bin/bash
if [ "$#" -eq 2 ]; then
    cd $1
    echo "#include<iostream>
using namespace std;
int main() {
}" >> $2.java
    notepadqq $2.java
    cd ..
fi
if [ "$#" -eq 1 ]; then
    #do stuff
    echo "#include<iostream>
using namespace std;
int main() {
}" >> $1.java
    notepadqq $1.java
fi
