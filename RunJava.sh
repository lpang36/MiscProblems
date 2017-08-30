#!/bin/bash
if [ "$#" -eq 2 ]; then
    cd $1
    javac $2.java
    java $2
    cd ..
fi
if [ "$#" -eq 1 ]; then
    javac $1.java
    java $1
fi
