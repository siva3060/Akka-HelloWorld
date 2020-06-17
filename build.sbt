name := "akka-HelloWorld"

version := "1.0"

scalaVersion := "2.13.1"

lazy val akkaVersion = "2.6.6"

// AKka library has been added 
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
)
