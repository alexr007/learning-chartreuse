Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "learning-chartreuse",
    libraryDependencies ++= Seq(
      "org.creativescala" %% "chartreuse-core" % "0.1-cefd1cf-20231015T123107Z-SNAPSHOT",
      "org.scalatest"              %% "scalatest"                 % "3.2.16",
      "org.scalacheck"             %% "scalacheck"                % "1.17.0",
      "org.scalatestplus"          %% "scalacheck-1-17"           % "3.2.16.0",
      "com.lihaoyi"                %% "pprint"                    % "0.8.1",
    )
  )
