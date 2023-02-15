# quarkus-ghost-resource


Related to https://github.com/quarkusio/quarkus/issues/31173#issuecomment-1430998534.

## How to reproduce the issue

```shell
> mvn clean install # builds a dummy extension and an app
> cd reproducer
> mvn quarkus:dev
```

In another terminal

```shell
> curl -v http://localhost:8080/delete # 405 expected, but get 404
```

## Why?

Because there is a web jar as a dependency of the deployment module of the custom extension.
The classpath element associated with this webjar is considered as _runtime_, while it should not.

Because of this, Quarkus believes there are static resources (while it's not the case), and introduce the catch-all static route (which lead to the 404 instead of 405).
