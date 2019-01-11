# image-pixelator

To run the process `gradle run` or `./gradlew run`
The output is in `/tmp/output.csv`

JVM is limited to 512mb in the `run` task: `jvmArgs =  ['-Xms256m', '-Xmx512m']`
