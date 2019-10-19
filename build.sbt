name := "scala-start"
scalaVersion := "2.13.1"
version := "1.0"

val akkaVersion     = "2.5.25"
val akkaHttpVersion = "10.1.10"

libraryDependencies ++= Seq(
  "com.typesafe.akka"          %% "akka-actor"           % akkaVersion,
  "com.typesafe.akka"          %% "akka-stream"          % akkaVersion,
  "com.typesafe.akka"          %% "akka-cluster"         % akkaVersion,
  "com.typesafe.akka"          %% "akka-cluster-tools"   % akkaVersion,
  "com.typesafe.akka"          %% "akka-cluster-metrics" % akkaVersion,
  "com.typesafe.akka"          %% "akka-persistence"     % akkaVersion,
  "com.typesafe.akka"          %% "akka-contrib"         % akkaVersion,
  "com.typesafe.akka"          %% "akka-http"            % akkaHttpVersion,
  "com.typesafe.akka"          %% "akka-testkit"         % akkaVersion % Test,
  "com.typesafe.akka"          %% "akka-http-testkit"    % akkaHttpVersion % Test,
  "de.heikoseeberger"          %% "akka-http-json4s"     % "1.29.1",
  "org.json4s"                 %% "json4s-native"        % "3.6.7",
  "org.scalatest"              %% "scalatest"            % "3.0.8" % Test,
  "org.mockito"                %% "mockito-scala"        % "1.6.2" % Test,
  "com.typesafe.slick"         %% "slick"                % "3.3.2",
  "com.typesafe.slick"         %% "slick-hikaricp"       % "3.3.2",
  "com.typesafe.play"          %% "play-json"            % "2.7.4",
  "org.postgresql"             % "postgresql"            % "42.2.8",
  "com.chuusai"                %% "shapeless"            % "2.3.3",
  "io.underscore"              %% "slickless"            % "0.3.6",
  "org.scala-lang.modules"     %% "scala-java8-compat"   % "0.9.0",
  "com.typesafe.scala-logging" %% "scala-logging"        % "3.9.2",
  "ch.qos.logback"             % "logback-classic"       % "1.2.3",
  "org.slf4j"                  % "slf4j-simple"          % "1.7.28"
)

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-language:_",
  "-target:jvm-1.8",
  "-encoding",
  "UTF-8",
  "-Xfatal-warnings",
  "-Ywarn-numeric-widen",
  "-Ywarn-dead-code",
  "-Xlint",
  "-Ywarn-unused:-implicits", // some false positives
  "-Ywarn-value-discard",
  "-Ywarn-macros:after"
)

javacOptions ++= Seq(
  "-source",
  "1.8",
  "-target",
  "1.8"
)
