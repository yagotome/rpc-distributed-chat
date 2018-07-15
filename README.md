# RMI Group Chat

Este projeto irá implementar um chat de grupo com java RMI e sockets.

## Instruções

O projeto foi feito em Java 10 com Maven.

Para rodar o projeto, siga os seguintes passos:

1. Buildar o projeto:
```
$ mvn clean install
```
2. Setar classpath para o JAR gerado pelo maven em target:
```
$ export CLASSPATH=target/rmi-group-chat-1.0-SNAPSHOT.jar
```
3. Startar rmiregistry (9925 é a porta que está no arquivo config.json):
```
$ rmiregistry 9925 &
```
4. Rodar servidor:
```
$ java rmigroupchat.rmi.MessageServer
```
5. Rodar o cliente (em outro terminal, lembrar de setar o classpath):
```
$ java rmigroupchat.rmi.MessageClient
```