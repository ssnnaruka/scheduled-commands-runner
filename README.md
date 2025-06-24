# 🕒 Scheduled Commands Runner (Java)

Welcome! This is a Java-based utility that runs scheduled commands based on a simple schedule format. Think of it as a lightweight CRON-like scheduler built with clarity, maintainability, and testability in mind.

---

## ✨ What It Does

This tool reads a set of commands from a file (`/tmp/commands.txt`) and executes them either:

### ✅ One-Time at a Specific Time
```
Format:   minute hour day month year <command>
Example:  30 10 30 6 2025 echo "Run once on June 30 at 10:30"
```

### 🔁 Or Recurring at Fixed Intervals
```
Format:   */n <command>   // n = 1, 2, 5, 10, 15, 30, 60
Example:  */5 echo "Runs every 5 minutes"
```

All outputs are written to a file named `sample-output.txt`.

---

## 📂 Project Structure

```bash
scheduled-commands-runner/
├── pom.xml
├── run.sh
├── README.md
├── sample-output.txt
├── src/
│   ├── main/java/
│   │   ├── Main.java
│   │   ├── com/schedular/
│   │   │   ├── model/
│   │   │   ├── service/
│   │   │   ├── factory/
│   │   │   └── util/
│   └── test/java/
│   │   ├── com/schedular/
│   │   │   ├── model/
│   │   │   ├── service/
│   │   │   ├── factory/
│   │   │   └── util/
```

---

## 🧪 How to Run It

### 1. ✅ Requirements

- Java 8 or later
- Maven 3+
- A Unix-like OS (for bash support)

### 2. 🛠 Build the Project

```bash
mvn clean package
```

### 3. 🚀 Run It

To run continuously:

```bash
java -jar target/scheduled-commands-runner-1.0-SNAPSHOT-jar-with-dependencies.jar
```

Or run just once for testing:

```bash
./run.sh
```

---

## 📥 Input: `/tmp/commands.txt`

Put your scheduled commands here:

```txt
*/2 echo "Recurring every 2 minutes"
30 10 30 6 2025 echo "Run once on June 30, 2025 at 10:30"
```

---

## 📤 Output: `sample-output.txt`

All execution results are saved with timestamps:

```txt
[2025-06-30T10:30:00] Run once on June 30, 2025 at 10:30
[2025-06-30T10:32:00] Recurring every 2 minutes
```

---

## 🧠 What Makes It Great

| ✅ Principle      | Applied In                      |
|------------------|----------------------------------|
| SOLID Design     | Each class does one job well     |
| DRY Codebase     | No repetition, shared logic used |
| KISS Simplicity  | Short, clean, readable methods   |
| Design Patterns  | Strategy + Factory used smartly  |
| Unit Tested      | JUnit 5 + JaCoCo >90% coverage   |
| Dev-Ready        | Easily extendable and testable   |

---

## 🧪 Testing & Coverage

To run all tests:

```bash
mvn test
```

To generate a coverage report:

```bash
mvn verify
open target/site/jacoco/index.html
```

---

## 🔍 Test Summary

- ✅ Positive & negative tests for parsing, command types, and factory
- ✅ Real command execution tested with output validation
- ✅ File I/O tests for `sample-output.txt` generation
- ✅ Refactored service methods for testability

More details in `test-summary.md`.

---

## 🔐 Assumptions

- `/tmp/commands.txt` is present and writable
- Commands are shell-executable
- Execution time is checked against system time (in minutes)

---

## 👨‍💻 Author

**Saurabh Naruka**  
_Solution Architect | Java Engineer | System Design Enthusiast | Problem Solver_  
[GitHub Profile](https://github.com/ssnnaruka)

---

## 📎 License

MIT License — Feel free to use, modify, and share!
