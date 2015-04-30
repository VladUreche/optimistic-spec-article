scalaVersion in ThisBuild := "2.11.4"

scalacOptions in ThisBuild ++= Seq("-deprecation", "-feature", "-unchecked", "-optimize")

lazy val root = project.
  in(file(".")).
  enablePlugins(BenchmarkPlugin)

lazy val attempt1 = project.
  in(file("attempt1")).
  enablePlugins(BenchmarkPlugin)

lazy val attempt2 = project.
  in(file("attempt2")).
  enablePlugins(BenchmarkPlugin)

lazy val attempt3 = project.
  in(file("attempt3")).
  enablePlugins(BenchmarkPlugin)

lazy val attempt4 = project.
  in(file("attempt4")).
  enablePlugins(BenchmarkPlugin)

lazy val attempt5 = project.
  in(file("attempt5")).
  enablePlugins(BenchmarkPlugin)

lazy val attempt6 = project.
  in(file("attempt6")).
  enablePlugins(BenchmarkPlugin).
  settings(
    //resolvers += Resolver.sonatypeRepo("snapshots"),
    //libraryDependencies += "org.scala-miniboxing.plugins" %% "miniboxing-runtime" % "0.4-SNAPSHOT" from "file:///home/sun/workspace/dev/miniboxing-plugin/components/runtime/target/scala-2.11/miniboxing-runtime_2.11-0.4-SNAPSHOT.jar" changing(),
    // addCompilerPlugin("org.scala-miniboxing.plugins" %% "miniboxing-plugin" % "0.4-SNAPSHOT" from "file:///home/sun/workspace/dev/miniboxing-plugin/components/plugin/target/scala-2.11/miniboxing-plugin_2.11-0.4-SNAPSHOT.jar" changing()),
    scalacOptions += "-Xplugin:/mnt/data1/Work/Workspace/dev/miniboxing-plugin/components/plugin/target/scala-2.11/miniboxing-plugin_2.11-0.4-SNAPSHOT.jar",
    unmanagedJars in Compile += file("/home/sun/workspace/dev/miniboxing-plugin/components/runtime/target/scala-2.11/miniboxing-runtime_2.11-0.4-SNAPSHOT.jar")
  )
