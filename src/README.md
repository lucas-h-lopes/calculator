# Project error handling 🛠️

In this project, three custom exceptions were created:

__UserInputException__: Handles invalid user input, such as entering a string instead of a number, specifying a nonexistent operation type, or leaving a name field blank.

__CalculatorException__: Ensures that ``number2`` provided by the user is not zero when attempting division.

__UserAnswerException__: Manages the project's repeat loop logic. If the answer is '**Y**', the program runs again. If the answer is '**N**', the program finalizes and prints the calculations made by the user while it was running. If the answer is **any other value**, the program ends without printing the calculations.

## Exceptions images 📸

### Person fields

Blank name:

<img src="https://raw.githubusercontent.com/lucas-h-lopes/calculator/main/images/validations/name-cant-be-blank.png" alt="blank-name-exception">

Invalid birthdate format:

<img src="https://raw.githubusercontent.com/lucas-h-lopes/calculator/main/images/validations/birthdate-invalid-format.png" alt="birthdate-invalid-format">

Birthdate over 100 years-old:

<img src="https://raw.githubusercontent.com/lucas-h-lopes/calculator/main/images/validations/birthdate-older-than-100.png" alt="birthdate-higher-than-100">

### Operation type

Nonexistent operation:

<img src="https://raw.githubusercontent.com/lucas-h-lopes/calculator/main/images/validations/operation-invalid-type.png" alt="inexistent-operation">

### Numbers

Failed to parse first number:

<img src="https://raw.githubusercontent.com/lucas-h-lopes/calculator/main/images/validations/number1-invalid-input.png" alt="failed-parse">

Failed to parse second number:

<img src="https://raw.githubusercontent.com/lucas-h-lopes/calculator/main/images/validations/number2-invalid-input.png" alt="failed-parse">

Second number cannot be zero during __division operation__:

<img src="https://raw.githubusercontent.com/lucas-h-lopes/calculator/main/images/validations/divide-secondnumber-zero.png" alt="cant-be-zero">

### Answer

Invalid answer:

<img src="https://raw.githubusercontent.com/lucas-h-lopes/calculator/main/images/validations/answer-invalid-input.png" alt="invalid-answer" >
