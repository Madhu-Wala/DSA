Welcome to C++! Since you already know Java, you're going to pick this up incredibly fast. The Standard Template Library (STL) in C++ maps almost perfectly to the Java Collections Framework.

Let's dive straight into `std::vector`, your new `ArrayList`.

---

## Importing and Using `std::vector`

In Java, you use `import java.util.ArrayList;`. In C++, you **include** the header file.

Here is the exact mapping of how to import, initialize, and use basic operations:

### 1. The Blueprint: Java vs. C++

| Operation | Java (`ArrayList`) | C++ (`std::vector`) |
| --- | --- | --- |
| **Import / Include** | `import java.util.ArrayList;` | `#include <vector>` |
| **Declaration** | `ArrayList<Integer> list = new ArrayList<>();` | `std::vector<int> vec;` |
| **Add Element** | `list.add(10);` | `vec.push_back(10);` or `vec.emplace_back(10);` |
| **Access Element** | `list.get(0);` | `vec[0];` or `vec.at(0);` |
| **Update Element** | `list.set(0, 20);` | `vec[0] = 20;` |
| **Size** | `list.size();` | `vec.size();` |

---

### 2. Live Code Example

Here is a complete, runnable C++ program that mirrors how you would typically use an `ArrayList` in Java.

```cpp
#include <iostream> // For std::cout (like System.out.println)
#include <vector>   // For std::vector (like ArrayList)

int main() {
    // 1. Initialization (No 'new' keyword needed! Created on the stack)
    std::vector<int> numbers;

    // 2. Adding elements (Java's list.add())
    numbers.push_back(10);
    numbers.push_back(20);
    numbers.push_back(30);

    // 3. Getting the size (Java's list.size())
    std::cout << "Size of vector: " << numbers.size() << std::endl;

    // 4. Accessing elements (Java's list.get(index))
    std::cout << "Element at index 1: " << numbers[1] << std::endl;

    // 5. Updating elements (Java's list.set(index, value))
    numbers[1] = 99;
    std::cout << "Updated element at index 1: " << numbers[1] << std::endl;

    // 6. Iterating (Like a Java for-each loop)
    std::cout << "All elements: ";
    for (int num : numbers) {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    return 0;
}

```

---

## 💡 Key Conceptual Differences for a Java Dev

* **No `new` Keyword for Objects:** In Java, objects live on the heap and you need `new`. In C++, writing `std::vector<int> vec;` immediately creates the object on the stack. It's ready to use.
* **Memory Management:** When `vec` goes out of scope (e.g., the function ends), C++ automatically cleans up its memory. No Garbage Collector required!
* **Bracket Notation:** Instead of `.get(i)`, you can just use `[i]`. *Note: `[i]` doesn't check for out-of-bounds errors for speed reasons. If you want safety like Java, use `vec.at(i)`, which throws an exception if you go out of bounds.*

---

## Part 2: `HashMap` (Java) vs `std::unordered_map` (C++)

Just like Java's `HashMap`, C++'s `std::unordered_map` uses a hash table behind the scenes, offering average $O(1)$ time complexity for insertions, lookups, and deletions.

### 1. The Blueprint

To use it, you include `<unordered_map>`.

| Operation | Java (`HashMap`) | C++ (`std::unordered_map`) |
| --- | --- | --- |
| **Import / Include** | `import java.util.HashMap;` | `#include <unordered_map>` |
| **Declaration** | `HashMap<String, Integer> map = new HashMap<>();` | `std::unordered_map<std::string, int> map;` |
| **Put / Insert** | `map.put("Apple", 5);` | `map["Apple"] = 5;` or `map.insert({"Apple", 5});` |
| **Get / Access** | `map.get("Apple");` | `map["Apple"];` or `map.at("Apple");` |
| **Check Key Exists** | `map.containsKey("Apple");` | `map.count("Apple")` (returns 1 or 0) |
| **Remove** | `map.remove("Apple");` | `map.erase("Apple");` |

---

### 2. Quick Code Example

Here is how you handle standard map operations in C++:

```cpp
#include <iostream>
#include <unordered_map>
#include <string>

int main() {
    // 1. Declaration
    std::unordered_map<std::string, int> inventory;

    // 2. Inserting elements (Square brackets make this incredibly clean)
    inventory["Apples"] = 50;
    inventory["Bananas"] = 30;

    // 3. Checking if a key exists (Java's containsKey)
    // .count() returns 1 if found, 0 if not
    if (inventory.count("Apples")) {
        std::cout << "Apples are in stock! Count: " << inventory["Apples"] << std::endl;
    }

    // 4. Removing an element
    inventory.erase("Bananas");

    // 5. Iterating through a map
    // In C++, map elements are stored as 'std::pair'. 
    // .first is the Key, .second is the Value.
    for (const auto& pair : inventory) {
        std::cout << pair.first << " -> " << pair.second << std::endl;
    }

    return 0;
}

```

---

## ⚠️ One Crucial Trap for Java Devs: The `[]` Operator

In Java, if you do `map.get("MissingKey")`, it safely returns `null`.

In C++, if you use the square brackets `map["MissingKey"]` to look up a key that doesn't exist, **C++ will automatically create that key** and give it a default value (like `0` for integers or an empty string)!

> **Rule of Thumb:** If you just want to *look up* an item safely without accidentally creating it, use `inventory.at("Key")` (which throws an error if missing) or check with `inventory.count("Key")` first.

---

## Part 3: `HashSet` (Java) vs `std::unordered_set` (C++)

Just like Java's `HashSet`, `std::unordered_set` stores **unique keys** in no particular order. Under the hood, it uses a hash table, making insertions, lookups, and deletions an average of $O(1)$ time complexity.

### 1. The Blueprint

To use it, include `<unordered_set>`.

| Operation | Java (`HashSet`) | C++ (`std::unordered_set`) |
| --- | --- | --- |
| **Import / Include** | `import java.util.HashSet;` | `#include <unordered_set>` |
| **Declaration** | `HashSet<Integer> set = new HashSet<>();` | `std::unordered_set<int> mySet;` |
| **Add / Insert** | `set.add(10);` | `mySet.insert(10);` |
| **Check Existence** | `set.contains(10);` | `mySet.count(10)` or `mySet.contains(10)` *(C++20+)* |
| **Remove / Erase** | `set.remove(10);` | `mySet.erase(10);` |
| **Size** | `set.size();` | `mySet.size();` |

---

### 2. Quick Code Example

Here is how you use it in C++:

```cpp
#include <iostream>
#include <unordered_set>

int main() {
    std::unordered_set<int> uniqueNumbers;

    // 1. Inserting elements
    uniqueNumbers.insert(5);
    uniqueNumbers.insert(10);
    uniqueNumbers.insert(5); // Duplicate! Will be ignored silently.

    // 2. Checking size (Should be 2, not 3)
    std::cout << "Set size: " << uniqueNumbers.size() << std::endl;

    // 3. Checking if an element exists
    if (uniqueNumbers.contains(10)) { // Or: uniqueNumbers.count(10)
        std::cout << "10 is in the set!" << std::endl;
    }

    // 4. Erasing an element
    uniqueNumbers.erase(5);

    // 5. Iterating through the set
    for (int num : uniqueNumbers) {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    return 0;
}

```

---

## 💡 A Quick Note on Set Elements

In C++, elements inside an `unordered_set` are **constant (read-only)**. You cannot modify an element directly while it is inside the set (e.g., you can't grab `5` and change it to `6`), because changing its value would corrupt the hash table's internal structuring. If you want to change an element, you must `erase()` the old one and `insert()` the new one.

---

## Part 4 & 5: Queue & Stack

### 1. The Blueprint

To use these, include `<queue>` and `<stack>`.

| Operation | Java (`Queue` / `Stack`) | C++ (`std::queue` / `std::stack`) |
| --- | --- | --- |
| **Include** | `import java.util.LinkedList;` / `Stack;` | `#include <queue>` / `#include <stack>` |
| **Declaration** | `Queue<Integer> q = new LinkedList<>(); Stack<Integer> st = new Stack<>();` | `std::queue<int> q;  std::stack<int> st;` |
| **Add Element** | `q.add(10);` or `q.offer(10); st.push(10);` | `q.push(10);  st.push(10);` |
| **Examine Top/Front** | `q.peek();` (returns front) `st.peek();` (returns top) | **`q.front();`** (returns front) **`st.top();`** (returns top) |
| **Remove Element** | `q.poll();` or `q.remove();` `st.pop();` (returns value) | **`q.pop();`** (void - returns nothing) **`st.pop();`** (void - returns nothing) |
| **Check Empty** | `q.isEmpty();` | `q.empty();` |

---

### 2. Live Code Example

Look closely at how elements are inspected and removed in C++. It's a two-step process because **`.pop()` in C++ returns `void**`.

```cpp
#include <iostream>
#include <queue>
#include <stack>

int main() {
    // ---- QUEUE (FIFO: First In, First Out) ----
    std::queue<int> myQueue;
    myQueue.push(10);
    myQueue.push(20);

    // In C++, .pop() deletes the item but does NOT return it.
    // You must read it first using .front(), then pop it.
    std::cout << "Queue Front: " << myQueue.front() << std::endl; // 10
    myQueue.pop(); // Removes 10
    std::cout << "Next Front: " << myQueue.front() << std::endl;  // 20


    // ---- STACK (LIFO: Last In, First Out) ----
    std::stack<int> myStack;
    myStack.push(100);
    myStack.push(200);

    // Same rule: read with .top(), then use .pop() to remove.
    std::cout << "Stack Top: " << myStack.top() << std::endl;     // 200
    myStack.pop(); // Removes 200
    std::cout << "Next Top: " << myStack.top() << std::endl;       // 100

    return 0;
}

```

---

## ⚠️ The Trap for Java Devs

In Java, you are used to writing `int value = stack.pop();`.
If you try to do `int value = myStack.pop();` in C++, **your code will not compile**.

You must always do:

```cpp
int value = myStack.top(); // Get the value
myStack.pop();             // Remove it

```

---

## Part 6: Priority Queue

### 1. The Blueprint

To use it, include `<queue>`.

| Operation | Java (`PriorityQueue`) | C++ (`std::priority_queue`) |
| --- | --- | --- |
| **Default Order** | **Min-Heap** (Smallest first) | **Max-Heap** (Largest first) ⚠️ |
| **Declaration (Max-Heap)** | *Requires custom comparator* | `std::priority_queue<int> pq;` |
| **Declaration (Min-Heap)** | `PriorityQueue<Integer> pq = new PriorityQueue<>();` | `std::priority_queue<int, std::vector<int>, std::greater<int>> pq;` |
| **Add Element** | `pq.add(10);` | `pq.push(10);` |
| **Examine Top** | `pq.peek();` | **`pq.top();`** |
| **Remove Top** | `pq.poll();` | **`pq.pop();`** (returns void) |

> ⚠️ **Major Java vs C++ Alert:** In Java, a blank `new PriorityQueue<>()` gives you a **Min-Heap** (1, 2, 3...). In C++, a blank `std::priority_queue<int>` gives you a **Max-Heap** (3, 2, 1...).

---

### 2. Live Code Example

Let's look at how to build both a Max-Heap and a Min-Heap in C++:

```cpp
#include <iostream>
#include <queue>
#include <vector>

int main() {
    // 1. DEFAULT: Max-Heap (Largest element on top)
    std::priority_queue<int> maxHeap;
    
    maxHeap.push(10);
    maxHeap.push(30);
    maxHeap.push(20);
    
    std::cout << "Max-Heap Top: " << maxHeap.top() << std::endl; // Outputs: 30
    maxHeap.pop();
    std::cout << "Max-Heap Next Top: " << maxHeap.top() << std::endl; // Outputs: 20


    // 2. MIN-HEAP (Smallest element on top - Matches Java's default)
    // Syntax looks a bit heavy: Type, Underlying Container, Comparator
    std::priority_queue<int, std::vector<int>, std::greater<int>> minHeap;
    
    minHeap.push(10);
    minHeap.push(30);
    minHeap.push(20);
    
    std::cout << "Min-Heap Top: " << minHeap.top() << std::endl; // Outputs: 10
    
    return 0;
}

```

---

## Part 7: Final Utility Methods on your List

Let's quickly check off the remaining helper methods from your sheet to finish strong!

### `Collections.sort()` vs `std::sort()`

In Java, you sort a list with `Collections.sort(list)`.
In C++, you include `<algorithm>` and pass it the starting and ending iterators of your vector.

```cpp
#include <algorithm>
#include <vector>

std::vector<int> vec = {4, 1, 3, 2};
std::sort(vec.begin(), vec.end()); // Vector is now {1, 2, 3, 4}

```

### `arr.length` vs `vec.size()`

As you noted in your list, while Java arrays use `.length`, all STL containers in C++ (vectors, maps, sets, queues) use the **`.size()`** method consistently.

### `System.out.println()` & `Scanner` vs `cout` & `cin`

You've already been using these flawlessly in your practice scripts!

* `cin >> x;` reads input.
* `cout << x << endl;` prints output.

---

Here are the absolute must-know **"quality of life" functions** in C++ that every Java developer wishes they knew on day one. These will save you from writing unnecessary loops.

All of these live inside the **`<algorithm>`** or **`<numeric>`** headers.

---

## 1. Finding Elements (Like `list.contains()` or `list.indexOf()`)

In Java, you have `.contains()`. In C++ vectors, you use `std::find()`. It returns an iterator. If it reaches the `.end()`, the item wasn't found.

```cpp
#include <iostream>
#include <vector>
#include <algorithm> // Required for std::find

int main() {
    std::vector<int> vec = {10, 20, 30, 40};

    // Find the number 30
    auto it = std::find(vec.begin(), vec.end(), 30);

    if (it != vec.end()) {
        // To get the actual index, subtract vec.begin() from the iterator!
        int index = it - vec.begin(); 
        std::cout << "Found 30 at index: " << index << std::endl;
    } else {
        std::cout << "Not found" << std::endl;
    }
}

```

---

## 2. Reversing a Container (Like `Collections.reverse()`)

Instead of writing a manual loop to reverse an array or vector backward, C++ has a highly optimized `std::reverse()`.

```cpp
#include <algorithm>
#include <vector>

std::vector<int> vec = {1, 2, 3, 4};
std::reverse(vec.begin(), vec.end()); 
// vec is now {4, 3, 2, 1}

```

---

## 3. Quick Max, Min, and Sum (Like Java Streams)

In Java, you might use Streams (`.stream().mapToInt().sum()`) to aggregate collections. C++ has lightweight, ultra-fast functions for this.

```cpp
#include <iostream>
#include <vector>
#include <algorithm> // For min/max element
#include <numeric>   // For accumulate (sum)

int main() {
    std::vector<int> vec = {5, 2, 9, 1, 7};

    // 1. Find Max element (returns an iterator, so use * to dereference it)
    int maxVal = *std::max_element(vec.begin(), vec.end()); // 9

    // 2. Find Min element
    int minVal = *std::min_element(vec.begin(), vec.end()); // 1

    // 3. Summing all elements (0 is the initial starting sum value)
    int totalSum = std::accumulate(vec.begin(), vec.end(), 0); // 24
}

```

---

## 4. `std::string` Helpers (String Tokenization / Substrings)

Manipulating strings is a huge part of coding. Here is how Java string methods translate:

| Java | C++ | Notes |
| --- | --- | --- |
| `str.substring(start, end)` | `str.substr(start, length)` | ⚠️ **Warning:** C++ takes *length*, not the ending index! |
| `str.toLowerCase()` | `std::transform(s.begin(), s.end(), s.begin(), ::tolower);` | Modifies the string in place. |
| `str.charAt(i)` | `str[i]` or `str.at(i)` | Identical to vector access. |

Example of `substr`:

```cpp
std::string text = "Hello World";
std::string sub = text.substr(0, 5); // Starts at 0, takes 5 characters -> "Hello"

```

---

## 5. Filling a Container (Like `Arrays.fill()`)

If you want to reset a vector or array back to a specific default value quickly:

```cpp
#include <algorithm>
#include <vector>

std::vector<int> vec(5); // Creates a vector of size 5: {0, 0, 0, 0, 0}
std::fill(vec.begin(), vec.end(), -1); 
// vec is now {-1, -1, -1, -1, -1}

```

## Mathematical functions

They are pure, global functions that live in the **`<algorithm>`** and **`<cmath>`** headers.

---

### 1. `Math.max()` and `Math.min()` $\rightarrow$ `std::max()` and `std::min()`

These live in `<algorithm>`. Unlike Java, you can use them on two numbers *or* pass a whole initializer list `{}` to find the max/min of multiple numbers at once!

```cpp
#include <iostream>
#include <algorithm> // Required for max and min

int main() {
    int a = 10;
    int b = 20;

    // Two arguments
    int maximum = std::max(a, b); // 20
    int minimum = std::min(a, b); // 10

    // Multiple arguments (Using curly braces {})
    int maxOfMany = std::max({3, 9, 1, 14, 5}); // 14
    int minOfMany = std::min({3, 9, 1, 14, 5}); // 1
}

```

---

### 2. `Math.abs()` $\rightarrow$ `std::abs()`

This lives in `<cmath>`. It works for integers, floats, and doubles automatically.

```cpp
#include <iostream>
#include <cmath> // Required for abs, pow, sqrt, etc.

int main() {
    int negativeInt = -5;
    double negativeDouble = -9.81;

    std::cout << std::abs(negativeInt) << std::endl;    // Outputs: 5
    std::cout << std::abs(negativeDouble) << std::endl; // Outputs: 9.81
}

```

---

### 3. Other Core `Math` Functions

Since you'll inevitably need them, here is how the rest of Java's `Math` utilities match up inside `<cmath>`:

| Java | C++ | Description |
| --- | --- | --- |
| `Math.pow(base, exp)` | `std::pow(base, exp)` | Power function ($x^y$) |
| `Math.sqrt(x)` | `std::sqrt(x)` | Square root |
| `Math.ceil(x)` | `std::ceil(x)` | Round up |
| `Math.floor(x)` | `std::floor(x)` | Round down |
| `Math.round(x)` | `std::round(x)` | Rounds to nearest whole number |

### 💡 Pro-Tip

Because you have `using namespace std;` at the top of your practice files, you don't even need to type `std::`. You can just write `max(a, b)`, `abs(x)`, or `pow(2, 3)` directly!
