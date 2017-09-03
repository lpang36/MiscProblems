#!/bin/bash
if [ "$#" -eq 2 ]; then
    cd $1
    #do stuff
    cd ..
fi
if [ "$#" -eq 1 ]; then
    #do stuff
fi
