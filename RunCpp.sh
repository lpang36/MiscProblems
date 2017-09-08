#!/bin/bash
if [ "$#" -eq 2 ]; then
    cd $1
    g++ $2.cpp -w
    ./a.out
    cd ..
fi
if [ "$#" -eq 1 ]; then
    g++ $1.cpp -w
    ./a.out
fi
