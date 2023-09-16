### CS211_9342_MixAndMatch

# Prelim Group Project
A group programming project for the course CS 211 - DATA STRUCTURES (AY 2023-2024).
Prelims.

## Authors and Acknowledgment
** Group Mix and Match**
1. **COLOMA**, Stephen M.
2. **GUZMAN**, Sanchie Earl M.
3. **NONATO**, Marius Glenn M.
4. **RAGUDOS**, Hannah T.
5. **RAMOS**, Jerwin Kyle R.
6. **ROQUE**, Rey Daniel L.
7. **SANTOS**, Lourdene Eira C.

# Group Project: Comparative Analysis of Sorting Algorithms
This project aims to perform a comparative analysis of three sorting algorithms: Bubble Sort, Insertion Sort,
and Selection Sort. The analysis will focus on the efficiency of these algorithms in terms of the number
of statements executed during sorting. The algorithms will be tested with varying data sizes and scenarios,
including best-case, worst-case, and average-case scenarios.

## Sorting Util Classes

### Project1.BubbleSort.java
The `Project1.BubbleSort` class contains the implementation of the Bubble Sort algorithm. This classic sorting algorithm
repeatedly steps through the list to be sorted, compares adjacent elements, and swaps them if they are in
the wrong order. The process is repeated until no more swaps are needed, indicating that the list is sorted.

### Project1.InsertionSort.java

The `Project1.InsertionSort` class holds the implementation of the Insertion Sort algorithm. This algorithm builds the final
sorted array one item at a time by repeatedly taking an element from the unsorted part of the list and inserting
it into its correct position within the sorted part of the list.

### Project1.SelectionSort.java

In the `Project1.SelectionSort` class, you'll find the implementation of the Selection Sort algorithm. This algorithm divides
the input list into two parts: the sublist of items already sorted and the sublist that needs to be sorted.
The algorithm repeatedly selects the smallest (or largest, depending on the order) element from the unsorted
sublist and moves it to the end of the sorted sublist.


## Getting Started

To use our sorting algorithm analysis, follow these steps:

1. Clone the project repository using the following command:
   ```
   git clone <repository-link>
   ```

2. Navigate to the appropriate directory where the sorting algorithm classes are located.

3. Compile the Java programs for each sorting algorithm:
   ```
   javac Project1.BubbleSort.java
   javac Project1.InsertionSort.java
   javac Project1.SelectionSort.java
   ```

4. Run the Java programs for each sorting algorithm with different data sizes and scenarios:
   ```
   java Project1.BubbleSort
   java Project1.InsertionSort
   java Project1.SelectionSort
   ```

5. Observe the output, which will display the number of statements executed during sorting for each algorithm and scenario.


## Technical Report, Data Files, and More

For a comprehensive understanding of our project's findings, methodology, results, and analysis,
please refer to our detailed [MixAndMAtchPrelimGroupProjectOnAlgorithmAnalysis](https://docs.google.com/document/d/1gKtJAHLXlthI0EKCrLfHiYVjrzdE2HUzpNh-_AHTRSQ/edit).

Additionally, we provide data files for different data sizes and scenarios in the `Project1.dataset` directory.
These files serve as inputs for the sorting programs.

## Troubleshooting
If you have any questions or need further assistance related to the project, please don't hesitate to contact our project team:

- **Stephen M. COLOMA**
- **Sanchie Earl M. GUZMAN**
- **Marius Glenn M. NONATO**
- **Hannah T. RAGUDOS**
- **Jerwin Kyle R. RAMOS**
- **Rey Daniel L. ROQUE**
- **Lourdene Eira C. SANTOS**

Feel free to explore and learn from our comparative analysis of sorting algorithms

## General Instructions
To work with the source code, please follow these steps:

1. Open your terminal and clone the project using this command:
   ```
   git clone <paste-the-project-link>
   ```

2. In the terminal, create a feature branch for your work using:
   ```
   git checkout -b <Branch-Name>
   ```

3. Now, you can start making edits to the source code.

4. Once you're done editing, it's time to commit your changes. 

5. Push your feature branch to the remote repository with this command:
   ```
   git push origin <Branch-Name>
   ```

6. Next, navigate to the GitLab website and create a merge request by clicking the "Create Merge Request" button.

7. In the merge request, select "Stephen Coloma" as the assignee.

8. Complete the merge request creation process.

9. I'll be responsible for merging your changes into the main branch of the source code.

**Important Note:** Please remember not to directly merge your changes into the main branch.
Use the feature branch and the merge request process for maintaining the codebase.
Feel free to ask if you have any questions or need further assistance.

