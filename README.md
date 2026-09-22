# Picture Point Password — instructor edition

A Java Swing classroom demonstration of graphical authentication. Users select ordered points on an image and then attempt to repeat them. The exercise includes a local brute-force demonstration.

## Run

Install a JDK (17 or newer recommended), open a terminal in this repository, and use an image you have permission to use:

```sh
javac -d out src/*.java
java -cp out Main "path/to/your-image.jpg"
```

Select points, close the setup window, then repeat them in the verification window. The image is supplied by you; no machine-specific image path is required. A graphical desktop is necessary.

## Teaching scope

This is intentionally a **demonstration, not production authentication**. It uses Java `String.hashCode`, stores points in memory, prints diagnostic information, and has no secure password KDF, rate limiting, or account protection. The brute-force exercise can be slow and verbose. Do not use real passwords or sensitive images.

The original student and instructor repositories are preserved separately to keep existing classroom links working. This cleanup does not claim that their code currently differs or that the student edition contains blanks.

[Student repository](https://github.com/markj2104/PicturePointPasswordStudent)
