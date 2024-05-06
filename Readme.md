# Java Template

[![License: AGPL v3](https://img.shields.io/badge/License-AGPL_v3-blue.svg)](https://www.gnu.org/licenses/agpl-3.0)
Contains strict PMD linting and pre-commit settings, can be used as a starting
template for a Java project.

## Usage

Please ensure the prerequisites are satisfied before proceeding.
In Java, you can first compile the main code, and then run it with CLI arguments.

```sh
clear && ./gradlew build shadowJar && \
java -jar build/libs/template-java-project-all.jar
```

Or, after building:

```sh
java -jar fat.jar
```

## Testing

Put your unit test files (with extension .bats) in folder: `/test/`

```sh
./gradlew test
```

Then, in browser open:
`build/reports/tests/test/classes/com.doctestbot.TestCommandLineParser.html`
and browse to related section.

### Run Single Test File

To run 1 test file specifically, for example the
`/test/java/com/doctestbot/cli/TestLogArg.java` test file:

```sh
clear && ./gradlew test --tests com.doctestbot.TestSourceDirArg
```

Note that the `/cli` drops out.

## Prerequisites

(Re)-install the Java with:

```sh
sudo apt install openjdk-21-jdk-headless
sudo curl -s "https://get.sdkman.io" | bash
source ~/.sdkman/bin/sdkman-init.sh
sdk --version
sdk install gradle
sdk install java 19.0.2-open
```

Install:

```sh
# Java hooks require docker
sudo apt install docker.io
# Ensure docker can be ran without sudo.
sudo groupadd docker
sudo gpasswd -a $USER docker
newgrp docker

# Install pre-commit
pre-commit install
pre-commit autoupdate
```

### Update gradle.build

Auto update of `gradle.build` file is not a standard practice. Instead, get
the list of latest versions of the things that can be updated:

```sh
./gradlew dependencyUpdates
```

and manually apply the updates.

## Pre-commit

Run pre-commit with:

```sh
pre-commit run --all
```

### Documentation

To generate the documentation, run:

```sh
./gradlew javadoc
```

That produces the documentation in `build/docs/javadoc/index.html`,

### Code coverage

Still has to be implemented.
