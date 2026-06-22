{ pkgs }:
let
  jdk = pkgs.temurin-bin-25;
  jre = pkgs.temurin-jre-bin-25;
in
{
  # Java 25
  java-jdk = jdk;
  java-jre = jre;

  # Gradle 9
  gradle = pkgs.gradle_9.override { java = jdk; };

  # Kotlin
  kotlin = pkgs.kotlin.override { jre = jdk; };
}
