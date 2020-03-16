// adds reStart and reStop
addSbtPlugin("io.spray"               % "sbt-revolver"   % "0.9.1")

// adds scalafmt
addSbtPlugin("org.scalameta"           % "sbt-scalafmt"   % "2.3.2")

// Enable several package formats, especially docker.
// sbt> docker:publishLocal
// sbt> docker:publish
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.6.2")

// adds dependencyCheck
addSbtPlugin("net.vonbuchholtz" % "sbt-dependency-check" % "2.0.0")