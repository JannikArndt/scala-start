lazy val root = (project in file("."))
  .settings(
    name := "scala-start",
    organization := "my-organization",
    version := "1.0.0",
    scalaVersion := "2.13.1",
    scalacOptions := scalaCompilerOptions,
    libraryDependencies ++= akkaDependencies ++ databaseDependencies ++ testDependencies ++ loggingDependencies ++ otherDependencies,
  ).enablePlugins(JavaAppPackaging, DockerPlugin)

Global / onChangedBuildSource := ReloadOnSourceChanges
ThisBuild / turbo := true

val akkaVersion     = "2.6.8"
val akkaHttpVersion = "10.2.0"

lazy val akkaDependencies = Seq(
  "com.typesafe.akka" %% "akka-actor"           % akkaVersion,
  "com.typesafe.akka" %% "akka-stream"          % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster"         % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-tools"   % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
  "com.typesafe.akka" %% "akka-persistence"     % akkaVersion,
  "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-testkit"         % akkaVersion % Test,
  "com.typesafe.akka" %% "akka-http-testkit"    % akkaHttpVersion % Test,
  "de.heikoseeberger" %% "akka-http-json4s"     % "1.35.0",
)
lazy val databaseDependencies = Seq(
  "com.typesafe.slick" %% "slick"          % "3.3.2",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.2",
  "com.typesafe.play"  %% "play-json"      % "2.9.0",
  "org.postgresql"     % "postgresql"      % "42.2.14",
  "com.chuusai"        %% "shapeless"      % "2.3.3",
  "io.underscore"      %% "slickless"      % "0.3.6",
)

lazy val testDependencies = Seq(
  "org.json4s"    %% "json4s-native" % "3.6.8",
  "org.scalatest" %% "scalatest"     % "3.2.1" % Test,
  "org.mockito"   %% "mockito-scala" % "1.14.8" % Test,
)

lazy val loggingDependencies = Seq(
  "com.typesafe.scala-logging" %% "scala-logging"  % "3.9.2",
  "ch.qos.logback"             % "logback-classic" % "1.2.3",
  "org.slf4j"                  % "slf4j-simple"    % "1.7.30"
)

lazy val otherDependencies = Seq(
  "org.scala-lang.modules" %% "scala-java8-compat" % "0.9.1",
)

lazy val scalaCompilerOptions = Seq(
  "-target:8",
  "-deprecation",                      // Emit warning and location for usages of deprecated APIs.
  "-encoding", "utf-8",                // Specify character encoding used by source files.
  "-explaintypes",                     // Explain type errors in more detail.
  "-feature",                          // Emit warning and location for usages of features that should be imported explicitly.
  "-language:existentials",            // Existential types (besides wildcard types) can be written and inferred
  "-language:experimental.macros",     // Allow macro definition (besides implementation and application)
  "-language:higherKinds",             // Allow higher-kinded types
  "-language:implicitConversions",     // Allow definition of implicit functions called views
  "-unchecked",                        // Enable additional warnings where generated code depends on assumptions.
  "-Xcheckinit",                       // Wrap field accessors to throw an exception on uninitialized access.
  "-Xfatal-warnings",                  // Fail the compilation if there are any warnings.
  "-Xlint:adapted-args",               // Warn if an argument list is modified to match the receiver.
  "-Xlint:constant",                   // Evaluation of a constant arithmetic expression results in an error.
  "-Xlint:delayedinit-select",         // Selecting member of DelayedInit.
  "-Xlint:doc-detached",               // A Scaladoc comment appears to be detached from its element.
  "-Xlint:inaccessible",               // Warn about inaccessible types in method signatures.
  "-Xlint:infer-any",                  // Warn when a type argument is inferred to be `Any`.
  "-Xlint:missing-interpolator",       // A string literal appears to be missing an interpolator id.
  "-Xlint:nullary-override",           // Warn when non-nullary `def f()' overrides nullary `def f'.
  "-Xlint:nullary-unit",               // Warn when nullary methods return Unit.
  "-Xlint:option-implicit",            // Option.apply used implicit view.
  "-Xlint:package-object-classes",     // Class or object defined in package object.
  "-Xlint:poly-implicit-overload",     // Parameterized overloaded implicit methods are not visible as view bounds.
  "-Xlint:private-shadow",             // A private field (or class parameter) shadows a superclass field.
  "-Xlint:stars-align",                // Pattern sequence wildcard must align with sequence component.
  "-Xlint:type-parameter-shadow",      // A local type parameter shadows a type already in scope.
  "-Ywarn-dead-code",                  // Warn when dead code is identified.
  "-Ywarn-extra-implicit",             // Warn when more than one implicit parameter section is defined.
  "-Ywarn-numeric-widen",              // Warn when numerics are widened.
  "-Ywarn-unused:implicits",           // Warn if an implicit parameter is unused.
  "-Ywarn-unused:imports",             // Warn if an import selector is not referenced.
  "-Ywarn-unused:locals",              // Warn if a local definition is unused.
  "-Ywarn-unused:params",              // Warn if a value parameter is unused.
  "-Ywarn-unused:patvars",             // Warn if a variable bound in a pattern is unused.
  "-Ywarn-unused:privates",            // Warn if a private member is unused.
  "-Ywarn-value-discard"               // Warn when non-Unit expression results are unused.
)

