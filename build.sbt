name := """PlayGroc"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,
  "com.h2database" % "h2" % "1.4.181",
  "junit" % "junit" % "4.12" % "test",
  "org.springframework" % "spring-orm" % "4.2.6.RELEASE",
  "org.springframework" % "spring-aop" % "4.2.6.RELEASE",
  "org.springframework" % "spring-context" % "4.2.6.RELEASE",
  "org.springframework" % "spring-test" % "4.2.6.RELEASE" % "test",
  "net.sourceforge.htmlunit" % "htmlunit" % "2.14" % "test",
  "org.aspectj" % "aspectjrt" % "1.8.9",
  "org.aspectj" % "aspectjweaver" % "1.8.9",
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",
  "mysql" % "mysql-connector-java" % "5.1.39",
  "org.webjars" % "jquery" % "2.2.4",
  "org.webjars" % "bootstrap" % "4.0.0-alpha.2"
)
