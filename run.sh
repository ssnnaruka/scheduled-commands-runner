#!/bin/bash

# This script builds and runs the Scheduled Commands Runner Java app

echo "🔧 Building project..."
mvn clean package

echo "🚀 Running the scheduler..."
java -jar target/scheduled-commands-runner-1.0-SNAPSHOT-jar-with-dependencies.jar
