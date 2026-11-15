ThisBuild / organization := "com.example"
ThisBuild / version      := "0.0.1"

val springBootVersion = "3.5.7"
val lombokVersion     = "1.18.34"
val minioVersion      = "8.5.17"

lazy val root = (project in file("."))
  .settings(
    name := "my-app", // set to your project name

    // Pure Java project: no Scala library, no _2.13 suffix on artifacts
    autoScalaLibrary := false,
    crossPaths       := false,

    javacOptions ++= Seq("--release", "21"),

    libraryDependencies ++= Seq(
      "org.springframework.boot" % "spring-boot-starter-web"        % springBootVersion,
      "org.springframework.boot" % "spring-boot-starter-validation" % springBootVersion,
      "io.minio"                 % "minio"                          % minioVersion,

      // compileOnly + annotationProcessor
      "org.projectlombok" % "lombok" % lombokVersion % Provided,

      "org.springframework.boot" % "spring-boot-starter-test" % springBootVersion % Test,

      // JUnit 5 runner (equivalent of useJUnitPlatform())
      "com.github.sbt.junit" % "jupiter-interface" % JupiterKeys.jupiterVersion.value % Test
    )
  )