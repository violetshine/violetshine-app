{
  lib,
  stdenv,
  toolchain,
  gitignore,
}:
let
  inherit (gitignore.lib) gitignoreSource;
  name = "violetshine-app";
  src = gitignoreSource ../.;
in
{
  package = stdenv.mkDerivation (finalAttrs: {
    pname = name;
    version = "0.1.0";

    inherit src;

    propagatedBuildInputs = with toolchain; [ java-jre ];

    nativeBuildInputs = with toolchain; [
      java-jdk
      gradle
      kotlin
    ];

    mitmCache = toolchain.gradle.fetchDeps {
      pkg = finalAttrs.finalPackage;
      data = ../deps.json;
    };

    # this is required for using mitm-cache on Darwin
    __darwinAllowLocalNetworking = true;

    JDK_HOME = "${toolchain.java-jdk.home}";

    gradleBuildTask = "installDist";

    installPhase = ''
      runHook preInstall
      mkdir -p $out
      cp -r app/build/install/app/* $out
      runHook postInstall
    '';

    meta.mainProgram = "app";

    meta.sourceProvenance = with lib.sourceTypes; [
      fromSource
      binaryBytecode # mitm cache
    ];
  });
}
