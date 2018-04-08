# RZP_quest
Финальное задание для РЗП

# Постановка задачи
> Написать программу "интерпретатор выражения", позволяющую вычислить введенное выражение. Распознание и вычисление выражения организованно без использования готовых библиотек.

# Принцип работы


## Реализованные операции:
- сложение(+), вычитание(-), умножение(*), деление(/), возведение в степень(^)
- sin(), cos()

# Документация
 Программа состоит из 3 модулей:

## compiled
- **CompileException.java**
- **EngineContext.java**
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
![Alt-текст](https://2.downloader.disk.yandex.ru/preview/e5ac31d93b293b2dadbf5b45290e71f597ed2095f66bfec0917dda5332730110/inf/2fSPJ7TzUTY3gHUuUz-Rmikw0CeabwDiZlREM1f6tDTjPzR_SzUHAOSM_1XXe3LbURi8DThum0MgDswzjxvhCw%3D%3D?uid=56578452&filename=sample.png&disposition=inline&hash=&limit=0&content_type=image%2Fpng&tknv=v2&size=1280x636 "Программа")