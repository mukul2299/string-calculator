# String Calculator TDD Kata

## Project Overview

This project implements a String Calculator using Test-Driven Development (TDD) practices. The calculator accepts a string of numbers separated by delimiters (default is a comma and newline) and returns their sum. It also supports custom delimiters, throws exceptions for negative numbers, and adheres to other specified requirements.

This implementation is done step-by-step following TDD principles, where each feature is developed by writing tests first and then writing the implementation.

## Features

1. **Empty Input:** Returns `0` for an empty string.
2. **Single Number Input:** Returns the number itself.
3. **Multiple Numbers:** Returns the sum of comma-separated or newline-separated numbers.
4. **Custom Delimiters:** Supports custom delimiters specified at the beginning of the string (e.g., `"//;\n1;2"` uses `;` as the delimiter).
5. **Exception Handling for Negative Numbers:** Throws an exception if any negative numbers are passed, listing all of the negative numbers in the exception message.
6. **Handles New Lines:** New lines between numbers are treated as valid delimiters along with commas.

## Requirements

- **Java** (JDK 8 or later)
- **JUnit 5** for running the test cases

## Getting Started

### 1. Clone the Repository
git clone https://github.com/mukul2299/string-calculator.git Then,
cd string-calculator
