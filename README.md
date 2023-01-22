# cache-test-app-one

If this error occurs:

```
/bin/sh not found
```

run the following command on git bash to fix it:

```shell
git config --global core.autocrlf false
```

To start the app run:

```shell
docker-compose up --build
```

The app can be accessed on:

```
http://localhost:8080
```

to stop the app run:

```shell
docker-compose down
```
