#!/bin/bash
EOL=$'\n'
deps=$(find bin/dependencies -name "*.jar")
deps=$(pwd)/${deps//$EOL/:$(pwd)/}
classesfolder=$(pwd)/bin/classes
CLASSPATH=$classesfolder:$deps
echo $CLASSPATH