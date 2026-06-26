# violetshine-app

The app behind personal website (violetshine.net), written in Kotlin and a bit of Java + Tailwind CSS for styling.

## Get started
1. Clone the repository.
2. The Nix flake already has the right environment set up. Run the following command to install the remaining npm dependencies:
```sh
pnpm install
```
3. Start the app by running:
```sh
./gradlew :app:run
```

## Build
```sh
./gradlew :app:war
```
