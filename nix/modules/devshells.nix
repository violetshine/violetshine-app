{
  perSystem =
    {
      pkgs,
      ...
    }:
    {
      devShells.default =
        let
          java = pkgs.temurin-bin-25;
          gradle = pkgs.gradle_9.override { inherit java; };
          kotlin = pkgs.kotlin.override { jre = java; };
        in
        pkgs.mkShell {
          nativeBuildInputs = [
            java
            gradle
            kotlin
          ];

          shellHook = ''
            export GRADLE_USER_HOME=$(pwd)/.gradle
            alias update-deps='nix build .#default.mitmCache.updateScript -o ./update-deps.sh && ./update-deps.sh'
          '';
        };
    };
}
