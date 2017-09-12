#!/bin/bash
if [ "$#" -eq 2 ]; then
    cd $1
    python $2.py
    cd ..
fi
if [ "$#" -eq 1 ]; then
    python $1.py
fi
