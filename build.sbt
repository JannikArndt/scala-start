lazy val root = project
  .in(file("."))
  .settings(
    name := "scala-start",
    organization := "my-organization",
    version := "1.0.0",
    scalaVersion := "3.0.0",
    scalacOptions := scalaCompilerOptions,
    libraryDependencies ++= akkaDependencies ++
      circeDependencies ++
//      databaseDependencies ++
      testDependencies ++ loggingDependencies
  )
  .enablePlugins(JavaAppPackaging, DockerPlugin)

Global / onChangedBuildSource := ReloadOnSourceChanges
ThisBuild / turbo := true

val akkaVersion     = "2.6.14"
val akkaHttpVersion = "10.2.4"

lazy val akkaDependencies = Seq(
  "com.typesafe.akka" %% "akka-actor"               % akkaVersion,
  "com.typesafe.akka" %% "akka-actor-typed"         % akkaVersion,
  "com.typesafe.akka" %% "akka-stream"              % akkaVersion,
  "com.typesafe.akka" %% "akka-http"                % akkaHttpVersion,
  "ch.megard"         %% "akka-http-cors"           % "1.1.1",
  "com.typesafe.akka" %% "akka-testkit"             % akkaVersion     % Test,
  "com.typesafe.akka" %% "akka-http-testkit"        % akkaHttpVersion % Test,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion     % Test
//  "de.heikoseeberger" %% "akka-http-json4s"  % "1.36.0"
).map(_.cross(CrossVersion.for3Use2_13))

lazy val circeDependencies = Seq(
  "de.heikoseeberger" %% "akka-http-circe"      % "1.36.0",
  "io.circe"          %% "circe-core"           % "0.13.0",
  "io.circe"          %% "circe-generic"        % "0.13.0",
  "io.circe"          %% "circe-generic-extras" % "0.13.0",
  "io.circe"          %% "circe-parser"         % "0.13.0"
).map(_.cross(CrossVersion.for3Use2_13))

//lazy val databaseDependencies = Seq(
//  "com.typesafe.slick" %% "slick"          % "3.3.3",
//  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3",
//  "com.typesafe.play"  %% "play-json"      % "2.9.2",
//  "org.postgresql"      % "postgresql"     % "42.2.19",
//  "com.chuusai"        %% "shapeless"      % "2.3.3",
//  "io.underscore"      %% "slickless"      % "0.3.6"
//).map(_.cross(CrossVersion.for3Use2_13))

lazy val testDependencies = Seq(
  "org.json4s"    %% "json4s-native" % "3.6.11",
  "org.scalatest" %% "scalatest"     % "3.2.6"   % Test,
  "org.mockito"   %% "mockito-scala" % "1.16.32" % Test
).map(_.cross(CrossVersion.for3Use2_13))

lazy val loggingDependencies = Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"
//  "ch.qos.logback"              % "logback-classic" % "1.2.3",
//  "org.slf4j"                   % "slf4j-simple"    % "1.7.30"
).map(_.cross(CrossVersion.for3Use2_13))

lazy val scalaCompilerOptions = Seq(
//  "-source:3.0-migration", // reuse 2.13 language contracts
  // from /usr/local/Cellar/dotty/3.0.0/bin/scalac -help
  "-release:11",    // Compile code with classes specific to the given version of the Java platform available on the classpath and emit bytecode for this version. Choices: 8, 9, 10, 11, 12, 13, 14, 15.
  "-deprecation",   // emit warning and location for usages of deprecated APIs
  "-explain",       // explain errors in more detail
  "-explain-types", // explain type errors in more detail
  "-feature",       // emit warning and location for usages of features that should be imported explicitly
// "-new-syntax",   // require `then` and `do` in control expressions.
// "-no-indent"     // Require classical {...} syntax, indentation is not significant.
  "-print-lines",     // show source code line numbers.
  "-unchecked",       // enable additional warnings where generated code depends on assumptions
  "-Xfatal-warnings", // fail the compilation if there are any warnings
  "-Xmigration"       // warn about constructs whose behavior may have changed since version
)
