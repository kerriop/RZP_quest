# RZP_quest
Финальное задание для РЗП

# Постановка задачи
> Написать программу "интерпретатор выражения", позволяющую вычислить введенное выражение. Распознание и вычисление выражения организованно без использования готовых библиотек.

# Принцип работы
Возьмём, например, выражение **2 + 3 * 4 - 10 + 5**  
Оно будет обработано программой следующим образом:  
1. 

## Реализованные операции:
- сложение(+), вычитание(-), умножение(*), деление(/), возведение в степень(^)
- sin(), cos()

# Документация
 Программа состоит из 3 модулей:

## compiled
- **CompileException.java** - обработка ошибок компиляции пропаршенных лексем
- **EngineContext.java** - 
- **Operation.java**
- **OperationFunction.java**
- **OperationHelper.java**
- **OperationMath.java**
- **OperationNumeric.java**
- **OperationParser.java**
- **OperationPower.java**
- **OperationVariable.java**
____
## parser
- **DynamicLexemParser.java**
- **Lexem.java**
- **LexemDefinition.java**
- **LexemDefinitions.java**
- **LexemKind.java**
- **LexemParser.java**
- **LocationEntity.java**
- **ParserException.java**
- **StaticLexemDefinition.java**
____
## visual
Модуль для визуальной составляющей, реализовано на библиотеке Swing
- **Interprier.java**
____
 
# Работа программы
Вводим выражение в строку - получаем график
____

![Image](sample.png "Example")