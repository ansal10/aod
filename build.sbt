name := """aod"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "com.google.code.gson" % "gson" % "2.2",
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
  "javax.mail" % "mail" % "1.4.3",
  "javax.activation" % "activation" % "1.1.1",
  filters
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
