ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.7"

lazy val root = (project in file("."))
  .settings(
    name := "scala"
  )

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-api" % "2.0.13",
  "ch.qos.logback" % "logback-classic" % "1.5.6"
)
