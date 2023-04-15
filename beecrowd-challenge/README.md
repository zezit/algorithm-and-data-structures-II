# Repository of BeeCrowd Solutions

This repository contains two solutions to problems from the BeeCrowd platform. Each problem has its own Java class with a main method.

## Chaves.java

Gabriel, a software engineer, has lost his keys from home and needs help to find them. He will provide you with a list of offices he visited in the last week and a list of offices he visited in the last two days. Your task is to tell him in which offices it is possible to find the keys.

### Input

The first line contains two integers `Q` (1 ≤ Q ≤ 1*10³) and `E` (1 ≤ E ≤ Q), representing respectively the number of offices he visited in the last week and the number of offices he visited in the last two days.

The second line contains `E` integers `Si` (1 ≤ Si ≤ 1000) containing the identification number of each office he visited in the last two days.

The next line contains `Q` integers `Ci` (1 ≤ Ci ≤ 1000) containing the identification number of each office he visited in the last week.

### Output

For each office that he visited in the last week, your program should return "0" if he has already visited that office while looking for the keys. Otherwise, your program should return "1" if he hasn't visited that office yet while he was looking for the keys.

### Sample Input
```
10 5
1 15 5 998 27
1
88
15
88
99
5
100
7
27
998
```

### Sample Output
```
0
1
0
0
1
0
1
1
0
0
```

## Ordenacao.java

Read three integers and sort them in ascending order. Then, print these values in ascending order, followed by a blank line, and then the values in the sequence as they were read.

### Input

The input contains three integer numbers.

### Output

Present the output as requested above.

### Sample Input/Output
```
7 21 -14
```
```
-14
7
21

7
21
-14
```

### Sample Input/Output

```
-14 21 7
```
```
-14
7
21

-14
21
7
```


## Running the Programs

To run the programs, you need to have Java installed on your computer. Then, you can use any IDE or text editor to open the files, compile them, and run them.

### Compiling and Running with Command Line

To compile and run the programs with command line, you can use the following commands:

```
$ javac Chaves.java
$ java Chaves
```
```
$ javac Chaves.java
$ java Chaves
```
