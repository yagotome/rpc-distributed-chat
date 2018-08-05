rmiregistry-port = 9925
CLASSPATH=$(shell bash get-classpath.sh)
build:
	bash compile.sh
run-rmiregistry: build
	rmiregistry -J-Djava.class.path=$(CLASSPATH) $(rmiregistry-port) &
run-server: build
	java -cp $(CLASSPATH) rmigroupchat.rmi.MessageServer
run-client: build
	java -cp $(CLASSPATH) rmigroupchat.ui.ChatClient
clean-build:
	bash compile.sh --clean