#!/bin/bash
classesfolder=$(pwd)/bin/classes
if [[ $@ = *'--clean'* ]]; then
    rm -rf $classesfolder
    mkdir $classesfolder
    echo "Clean successfully finished."
elif [ -d $classesfolder ]; then
    echo "Build not done. Using cache."
    exit 0
else
    mkdir $classesfolder
fi
CLASSPATH=$(./get-classpath.sh)
javaclasses=$(find src/main/java -name "*.java")
javaclasses=${javaclasses//$EOL/$EOL$(pwd)/}
javac -d $classesfolder -cp $CLASSPATH -target 8 -source 8 -nowarn $javaclasses
echo "Build successfully finished. Classes in: $classesfolder"