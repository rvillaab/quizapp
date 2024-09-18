DELETE FROM quiz_questions;
DELETE FROM quiz;
DELETE FROM question;
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
VALUES
('Which Java keyword is used to create a subclass?', 'class', 'interface', 'extends', 'implements', 'extends', 'Easy', 'Java'),
('What is the output of the following Java code snippet?\nint x = 5;\nSystem.out.println(x++);', '4', '5', '6', 'Compile error', '5', 'Easy', 'Java'),
('Which loop in Java allows the code to be executed at least once?', 'for loop', 'while loop', 'do-while loop', 'switch loop', 'do-while loop', 'Easy', 'Java'),
('What is the purpose of the break statement in Java?', 'To terminate a loop or switch statement and transfer control to the next statement.', 'To skip the rest of the code in a loop and move to the next iteration.', 'To define a label for a loop or switch statement.', 'To check a condition and execute a block of code repeatedly.', 'To terminate a loop or switch statement and transfer control to the next statement.', 'Easy', 'Java'),
('In Python, which data type is mutable?', 'int', 'float', 'str', 'list', 'list', 'Easy', 'Python'),
('Which Python module is used for working with dates and times?', 'datetime', 'math', 'os', 'sys', 'datetime', 'Easy', 'Python'),
('Which Java operator is used to concatenate two strings?', '+', '-', '*', '/', '+', 'Easy', 'Java'),
('In Java, which collection class provides an implementation of a dynamic array?', 'HashMap', 'ArrayList', 'LinkedList', 'HashSet', 'ArrayList', 'Easy', 'Java'),
('What is the correct way to declare a constant variable in Java?', 'constant int x = 5;', 'final int x = 5;', 'static int x = 5;', 'readonly int x = 5;', 'final int x = 5;', 'Easy', 'Java'),
('What is the purpose of the range() function in Python?', 'To generate a random number within a given range.', 'To iterate over a sequence of numbers.', 'To sort a list in ascending order.', 'To calculate the length of a string.', 'To iterate over a sequence of numbers.', 'Easy', 'Python');