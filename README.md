# Scheduled Commands Runner

## 📌 Problem Statement

Utility to execute one-time and recurring scheduled commands defined in `/tmp/commands.txt`.

## ✅ Supported Formats

### One-time
Minute Hour Day Month Year <command>

### Recurring

*/n <command>
Where `n ∈ {1, 2, 3, 5, 10, 15, 30, 60}`

---

## 🔧 Assumptions

- Commands are either one-time or recurring.
- Commands are Bash-compatible.
- The utility checks every 60 seconds.
- All logs are stored in `sample-output.txt`.

---

## 🏗 Design Principles

- SOLID, DRY, and KISS adhered.
- Factory Pattern for Command Creation.
- Strategy Pattern via polymorphism for execution logic.

---

## ▶️ How to Run

1. Make sure `commands.txt` exists at `/tmp/commands.txt`.
2. Run the Java application (e.g., `Main.java`).
3. Observe `sample-output.txt` for results.

---

## 📄 Sample `/tmp/commands.txt`
30 17 30 6 2025 date && echo "At Amex, We Do What's Right."
*/2 date && echo "Amex was founded in 1850."

## 📄 Output

See `sample-output.txt` in this repo.