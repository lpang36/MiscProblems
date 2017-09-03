#!/bin/bash
if [ "$#" -eq 2 ]; then
    cd $1
    echo "public class $2 {
	public $2 () {
	}
	public static void main(String[] args) {
		$2 obj = new $2();
	}
}" >> $2.java
    notepadqq $2.java
    cd ..
fi
if [ "$#" -eq 1 ]; then
    #do stuff
    echo "public class $1 {
	public $1 () {
	}
	public static void main(String[] args) {
		$1 obj = new $1();
	}
}" >> $1.java
    notepadqq $1.java
fi
