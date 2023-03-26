# ani sdk

Java implementation of Ani SDK.

## Requirements

1. Java JRE/JDK 17.

## Install (macOS)

1. [Download the latest release](https://github.com/ani-lang/java-ani-sdk/releases) `anilang-sdk.jar`.
2. Leave the `anilang-sdk.jar` on a folder. We'll call it `ANI_HOME`.
3. Add in your `.zprofile` or `.bash_profile` the `ANI_HOME` path you chose and an alias:

```
export ANI_HOME=path/to/ani/home/anilang-sdk.jar
alias ani='java -jar $ANI_HOME'
```

4. Restart your terminal or run `source ~/.zprofile` and test in your console `ani -v`. You should 
see the version of the SDK and Ani:
```bash
$ ani -v
Java Ani SDK Version 0.1.0
Anilang Version 0.3.0
```

## Upgrade SDK version

1. [Download the latest release](https://github.com/ani-lang/java-ani-sdk/releases) `anilang-sdk.jar`.
2. Leave the `anilang-sdk.jar` on the `ANI_HOME` folder.
3. Run `$ani -v` to validate the upgraded version.

## Quick start
Run `ani -h` for help.
```bash
usage: Ani
 -c,--compile <file.ani>   Compile an Ani file.
 -h,--help                 Ani SDK usage.
 -r,--run <file.ani>       Run an Ani file.
 -s,--syntax <file.ani>    Verify syntax of an Ani file.
 -v,--version              Version of the SDK and Ani.
 -x,--context <file.ani>   Verify code context consistency.
```

## Contribute

````shell
$ ./mvnw clean package -Pqulice
````
