Para poder correr la aplicacion:

Clonar Repositorio

```sh
$ cd ipTracker
$ mvn clean package
$ docker build -t iptracker:1.0.0 . 
$ docker run -d -p 8080:8080 -t iptracker:1.0.0
```