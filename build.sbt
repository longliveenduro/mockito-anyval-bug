name := "CurrSpecs2"

version := "0.1"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "4.8.3" % "test")
libraryDependencies += "org.mockito" %% "mockito-scala-specs2" % "1.14.2" % "test"
libraryDependencies += "org.hamcrest" % "hamcrest" % "2.2" % Test

scalacOptions in Test ++= Seq("-Yrangepos")
