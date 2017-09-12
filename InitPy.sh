#!/bin/bash
if [ "$#" -eq 2 ]; then
    cd $1
    echo "" >> $2.py
    notepadqq $2.py
    cd ..
fi
if [ "$#" -eq 1 ]; then
    #do stuff
    echo "" >> $1.py
    notepadqq $1.py
fi
