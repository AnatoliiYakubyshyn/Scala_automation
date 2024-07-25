import sbt.Keys.libraryDependencies

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaAutomation",
    libraryDependencies += "org.scalatestplus" %% "selenium-4-17" % "3.2.18.0" ,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18",

  )
