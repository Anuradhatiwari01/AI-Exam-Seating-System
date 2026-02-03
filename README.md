# Exam Seating Allocation System (Java Based)

## What this project does
This project automates the process of exam seating for colleges.
It assigns students to seats automatically instead of doing it manually.

The main goal is to reduce cheating by making sure students from the same branch
are not seated next to each other.
In colleges, exam seating is usually done manually and takes a lot of time.
It is also easy to make mistakes.
I built this project to understand how logic and rules can be used to automate
a real college process.

## Main features
- Automatically assigns students to exam rooms
- Ensures students from the same branch do not sit next to each other
- Uses simple rules to improve seating step by step
- Stores student, room, and seating data in a database
- Simple web interface to view results

## How the system works
The system first creates an initial seating arrangement.
It then checks for problems, such as students from the same branch sitting together.
If a problem is found, the system swaps students and keeps the change only if the seating improves.
This process repeats until a better arrangement is found.

## Tech used
- Backend: Core Java
- Database: MySQL
- Database Connectivity: JDBC
- Frontend: HTML, CSS, JavaScript

## What I learned
- How to write clean logic using Core Java
- How to connect Java applications with databases using JDBC
- How to handle data safely using transactions
- How to solve real-world problems using simple rules

## Future improvements
- Add login for teachers and admins
- Export seating arrangement as a PDF
- Improve seating rules for larger exam halls
