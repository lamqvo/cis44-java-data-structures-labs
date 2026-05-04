Capstone Project - Phase 1: Requirements & Design

Topic: Real-World Applications of Data Structures

Format: Application Development & Analysis

1. Project Overview: For this capstone project, you will move beyond theoretical exercises to build a functional software module that solves a real-world problem. Data structures are "the silent, invisible backbone of today's digital world." Your goal is to select one specific application domain as a project track, analyze the requirements, and implement an efficient solution in Java.

2. Select a Project Track: Choose ONE of the following four tracks.

Option A: The Network Navigator (Graphs)

*  Real-World Context: Navigation systems (Google Maps), Social Networks (LinkedIn), or Utility Grids.
*  The Problem: Modeling complex relationships between objects to find connections or optimal paths.
*  Key Challenge: How does a system find the fastest route or the "critical path" in a network?
*  Required Structures: Adjacency List or Matrix, Weighted Edges.

Option B: The Smart Scheduler (Priority Queues & Heaps)

*  Real-World Context: Operating System job scheduling, Emergency Room triage, or Banking loan processing.
*  The Problem: Managing a stream of incoming requests where some tasks are more urgent than others.
*  Key Challenge: How does a system ensure high-priority tasks (like a VIP loan application) are processed before earlier, low-priority ones?
*  Required Structures: Min-Heap or Max-Heap.

Option C: The Intelligent Cache (Hash Tables & Lists)

*  Real-World Context: Web browser caches, "Recent Chats" history, or Fraud Detection systems.
*  The Problem: Providing instant access to frequently used data while managing limited memory.
*  Key Challenge: How do you store millions of records to allow for $O(1)$ instant retrieval?
*  Required Structures: HashMap combined with a Doubly Linked List (LRU Cache pattern) or Dynamic Arrays.

Option D: The Decision Engine (Trees)

Real-World Context: Loan approval systems, File Systems, or Game rendering.
The Problem: Organizing hierarchical data or executing complex logic rules.
Key Challenge: How does a bank automatically classify a loan applicant as "Approved" or "Rejected" based on attributes like income and credit score?
Required Structures: Binary Search Trees, Decision Trees, or Scene Graphs.

3. The Development Phases

Complete your project following these four phases of the Software Development Life Cycle (SDLC).

  *  Phase 1: Requirements & Design (15%) - Due Date: 5/4
    *  Goal: Analyze the problem and select the right tool.
    *  Action: Write a brief Design Document as .md file on your GitHub explaining your choice.
      *  Example: If you chose Option C, discuss the trade-off of using an Array (fast access) versus a Linked List (fast insertion).
    *  Deliverable: A UML diagram and a short paragraph justifying your Big-O expectations.

  *  Phase 2: Implementation (25%) - Due Date: 5/8
    * Goal: Build the "backbone" of the application.
    * Action: Write the Java classes for your data structures. Your application may include one or more of the following:
      * Graphs: Implement Node and Edge classes to represent connections.
      * Queues: Ensure your implementation strictly follows Priority Logic (bubbling up/down) for heaps.
      * Trees: Implement the Node structure where each node contains data and references to children.
    * Code Standard: Use proper Java syntax, including Access Modifiers (private/public) and Signatures as required.

  *  Phase 3: Algorithms (25%) - Due Date: 5/12
    *  Goal: Make the data structure do something useful.
    * Action: Implement the core logic method.
      *  Search/Traverse (Graph): Implement BFS or DFS to find if a path exists between two nodes.
      *  Sorting/Ordering (Heap): Implement the poll() or dequeue() logic that correctly removes the highest priority element.
      *  Calculation (Tree/Cache): Implement the lookup logic that returns the correct data or decision result.

  *  Phase 4: Testing & Validation (15%) - Due Date: 5/13
    * Goal: Ensure reliability and handle edge cases using industry-standard verification practices.
    * Action: Verify that your data structure functions correctly using the following two methods:
      * Write a Main.java driver class that runs specific scenarios and prints "PASS" or "FAIL" to the console.
      * Write a JUnit Test Class (e.g., GraphTest.java) using assertions (assertEquals, assertTrue) to validate your methods.
    * Boundary Tests: What happens if the list/graph is empty?
    * Logic Validation: Does the priority queue, for example, actually put the highest number first?
    * Edge Case: Handling collisions, ties in priority, or invalid inputs.

  * Presentation (20%) - After the Final Exam (Exam 3) 5/13
