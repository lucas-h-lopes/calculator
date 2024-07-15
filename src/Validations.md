# Project error handling 🛠️

In this project, three custom exceptions were created:

__UserInputException__: Handles invalid user input, such as entering a string instead of a number, specifying a nonexistent operation type, or leaving a name field blank.

__CalculatorException__: Ensures that ``number2`` provided by the user is not zero when attempting division.

__UserAnswerException__: Manages the project's repeat loop logic. If the answer is '**Y**', the program runs again. If the answer is '**N**', the program finalizes and prints the calculations made by the user while it was running. If the answer is **any other value**, the program ends without printing the calculations. 

## Exceptions:

### Person fields 

- Blank name: ![blank-name-exception](https://raw.githubusercontent.com/lucas-h-lopes/calculator/main/images/validations/name-cant-be-blank.png)


- Invalid birthdate format: ![birthdate-invalid-format](https://raw.githubusercontent.com/lucas-h-lopes/calculator/main/images/validations/birthdate-invalid-format.png)


- Birthdate over 100 years-old: ![birthdate-higher-than-100](https://raw.githubusercontent.com/lucas-h-lopes/calculator/main/images/validations/birthdate-older-than-100.png)

### Operation type

- Nonexistent operation: ![inexistent-operation](https://raw.githubusercontent.com/lucas-h-lopes/calculator/main/images/validations/operation-invalid-type.png)

### Numbers

- Failed to parse first number: ![failed-parse](https://raw.githubusercontent.com/lucas-h-lopes/calculator/main/images/validations/number1-invalid-input.png)


- Failed to parse second number: ![failed-parse](https://raw.githubusercontent.com/lucas-h-lopes/calculator/main/images/validations/number2-invalid-input.png)


- Second number cannot be zero during __division operation__: ![cant-be-zero](https://raw.githubusercontent.com/lucas-h-lopes/calculator/main/images/validations/divide-secondnumber-zero.png)

### Answer

- Invalid answer: ![invalid-answer](https://raw.githubusercontent.com/lucas-h-lopes/calculator/main/images/validations/answer-invalid-input.png)