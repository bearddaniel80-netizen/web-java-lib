# web-java-lib

## Description
A shared kernal / library for aql web projects.

## How it works
From a Dockerfile:

```text
RUN git clone -b <BRANCH> <THIS GITHUB REPO>
```

### Branch

- common
    - Caddyfile
    - Application.java
    - config / WebConfig.java # BFF and FastApi
    - web / ApiExceptionHandler.java # BFF and FastApi

- build
    - build.gradle

- BFF
    - resources / application.yml
    - service / FastApiClient.java

- FastApi
    - config / MinioConfig.java
    - dto / UploadUrlRequest.java
    - resources / application.yml
    - security / InternalKeyVerifier.java
    - security / Secrets.java
    - service / ProcessRunner.java

- Frontend
    - resources / application.yml