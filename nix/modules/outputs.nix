{ inputs, ... }:
{
  perSystem =
    {
      config,
      pkgs,
      ...
    }:
    let
      toolchain = pkgs.callPackages ../toolchain.nix { };
      outputs = pkgs.callPackages ../package.nix {
        gitignore = inputs.gitignore;
        inherit toolchain;
      };
      inherit (outputs) package;
    in
    {
      packages.default = config.packages.violetshine-app;
      packages.violetshine-app = package;
    };
}
