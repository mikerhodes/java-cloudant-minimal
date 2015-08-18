# Java Cloudant Client - Experiment Harness

This is a minimal app write a document to a Couch or Cloudant database using
the [Cloudant Java client library](https://github.com/cloudant/java-cloudant)
library.

It's main purpose is to demo the library and provide a harness for exploring
the libraries features. It also provides a base for
anyone finding bugs in the library -- it's hopefully easy to add code into
the example which demonstrates a bug to help us (the library devs) to
reproduce the problem and fix it.

## Pre-requisites

1. Java SE v7 or above.

## Getting started

First, make sure you can run the existing code -- this will tease out any
issues in your environment.

1. Open `src/main/java/searchindex/Main.java`.
2. Fix the `CloudantClient` create line with appropriate account and
   credentials.
3. Update the `Database` create line with a database that the provided
   credentials have `admin` access for (as we create a design doc).
4. Save `Main.java` and run using `./gradlew run`.

You should see gradle being downloaded, the app being built and finally a run
of the app. The app will create a search index in the database, which can be
verified with curl or the Cloudant dashboard.


## Reproducing bugs

1. Either
   - fill in your code in `src/main/java/searchindex/Main.java`, or
   - create a new Main.java and update the `mainClassName` in `build.gradle`.
2. Run using `./gradlew run`.
3. Zip up your project and submit it to Cloudant support.
