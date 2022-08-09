# RDF Toolkit

## Running in development

Run the commands below in two separate terminals and leave them open.

Build on changes:

```
./gradlew -t build
```

Reload on changes:

```
./gradlew run -Pdevelopment=true
```

## Deployment

Log in to fly.io

```
fly auth login
```

Deploy app

```
fly deploy
```