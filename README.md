# JBang Examples

This is a collection of example apps to create CLI apps with Java using JBang.

## Install OpenJDK

Install from [https://jdk.java.net/](https://jdk.java.net/)

On MacOS, a file like the following will be downloaded:

`openjdk-20.0.2_macos-aarch64_bin.tar.gz`

Opening this will result in a directory `jdk-20.0.2.jdk`.

Move this to `$HOME/openjdk`.

```
% cat > .zshrc

export JAVA_HOME=$HOME/openjdk/jdk-20.0.2.jdk/Contents/Home

export PATH=$JAVA_HOME/bin:$PATH
```

Run Java to verify it's working:

```
% java --version
openjdk 20.0.2 2023-07-18
OpenJDK Runtime Environment (build 20.0.2+9-78)
OpenJDK 64-Bit Server VM (build 20.0.2+9-78, mixed mode, sharing)
```

Also consider placing this in `/usr/local`.

See more: [https://www.codejava.net/java-se/install-openjdk-18-on-macos](https://www.codejava.net/java-se/install-openjdk-18-on-macos)

## Install JBang

`% curl -Ls https://sh.jbang.dev | bash -s - app setup`

or

`% brew install jbangdev/tap/jbang`

See more: [https://www.jbang.dev/documentation/guide/latest/installation.html](https://www.jbang.dev/documentation/guide/latest/installation.html)

## Hello World

`% jbang helloworld.java`

or

```
% chmod +x helloworld.java
% ./helloworld.java jbang!
```

See more: [https://www.jbang.dev/documentation/guide/latest/usage.html](https://www.jbang.dev/documentation/guide/latest/usage.html)

## Dependencies

See more: [https://www.jbang.dev/documentation/guide/latest/dependencies.html](https://www.jbang.dev/documentation/guide/latest/dependencies.html)