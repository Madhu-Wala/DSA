# 1. C++ OOP (40 mins)

If they ask OOP questions, they usually ask:

* What is it?
* Why do we use it?
* Write a small example.

---

# Class Syntax

```cpp
#include <iostream>
using namespace std;

class Student {
public:
    string name;
    int age;

    void display() {
        cout << name << " " << age << endl;
    }
};

int main() {
    Student s;
    s.name = "John";
    s.age = 20;
    s.display();
}
```

Exactly like Java except no `new` required for stack objects.

---

# Constructors

## 1. Default Constructor

No parameters.

Automatically called when object is created.

```cpp
class Student{
public:
    Student(){
        cout<<"Default constructor\n";
    }
};

int main(){
    Student s;
}
```

Output

```
Default constructor
```

Purpose

Initialize objects with default values.

---

## 2. Parameterized Constructor

```cpp
class Student{
public:
    string name;

    Student(string n){
        name=n;
    }
};

int main(){
    Student s("Madhura");
}
```

Used to initialize values during creation.

---

## 3. Copy Constructor

Creates one object from another.

Syntax

```cpp
ClassName(const ClassName &obj)
```

Example

```cpp
class Student{
public:
    int age;

    Student(int a){
        age=a;
    }

    Student(const Student &obj){
        age=obj.age;
    }
};

int main(){
    Student s1(20);
    Student s2=s1;
}
```

Purpose

Copies object safely.

Important in dynamic memory.

---

# Destructor

Automatically called when object dies.

```cpp
class Student{
public:

    ~Student(){
        cout<<"Destructor called";
    }
};

int main(){

    Student s;

}
```

Output after program ends

```
Destructor called
```

Purpose

Release resources.

Especially

* memory
* files
* database connections

Java has Garbage Collection.

C++ uses destructors.

---

# Encapsulation

Wrapping data + functions together.

```cpp
class Student{

private:
    int marks;

public:

    void setMarks(int m){
        marks=m;
    }

    int getMarks(){
        return marks;
    }
};
```

Why?

Protect data.

Only controlled access.

Exactly like private variables in Java.

---

# Inheritance

```cpp
class Animal{

public:

    void eat(){
        cout<<"Eating";
    }

};

class Dog : public Animal{

};

int main(){

    Dog d;

    d.eat();

}
```

Dog inherits Animal.

---

## Public Inheritance

```cpp
class B : public A
```

Public members remain public.

Most common.

---

## Protected Inheritance

```cpp
class B : protected A
```

Public becomes protected.

Outside class cannot access.

---

## Private Inheritance

```cpp
class B : private A
```

Everything becomes private.

Rarely used.

---

### Easy table

| Inheritance | Public members become |
| ----------- | --------------------- |
| public      | public                |
| protected   | protected             |
| private     | private               |

---

# Polymorphism

Means

One interface

Many forms.

---

## Compile-Time Polymorphism

Resolved during compilation.

---

### Function Overloading

Same function

Different parameters.

```cpp
class Math{

public:

    int add(int a,int b){
        return a+b;
    }

    int add(int a,int b,int c){
        return a+b+c;
    }

};
```

Compiler decides.

---

### Operator Overloading

Changing behavior of operators.

Example

```cpp
class Complex{

public:

int real;

Complex operator+(Complex obj){

    Complex temp;

    temp.real=real+obj.real;

    return temp;

}

};
```

Mostly they only ask definition.

Definition:

Allows operators to work with user-defined objects.

---

# Runtime Polymorphism

Decided while program runs.

Needs

* inheritance
* virtual function

---

## Function Overriding

```cpp
class Animal{

public:

    void sound(){

        cout<<"Animal";

    }

};

class Dog:public Animal{

public:

    void sound(){

        cout<<"Dog";

    }

};
```

Dog overrides parent function.

---

## Virtual Function

```cpp
class Animal{

public:

virtual void sound(){

    cout<<"Animal";

}

};

class Dog:public Animal{

public:

void sound(){

    cout<<"Dog";

}

};

int main(){

Animal *a;

Dog d;

a=&d;

a->sound();

}
```

Output

```
Dog
```

Without virtual

Output

```
Animal
```

Virtual enables runtime polymorphism.

---

# Abstraction

Hide implementation.

Show only essential details.

Example

User presses

```
Car.start()
```

Doesn't know engine working.

---

# Pure Virtual Function

```cpp
virtual void display()=0;
```

No implementation.

Must override.

---

# Abstract Class

Contains at least one pure virtual function.

Cannot create object.

```cpp
class Animal{

public:

virtual void sound()=0;

};
```

Cannot do

```cpp
Animal a;
```

---

# Friend Function

Can access private members.

```cpp
class A{

private:

int x=10;

friend void show(A);

};

void show(A obj){

cout<<obj.x;

}
```

Normally functions cannot access private members.

Friend can.

---

# POINTERS ⭐⭐⭐⭐⭐

Most important topic.

---

# Pointer Declaration

```cpp
int *ptr;
```

Pointer stores address.

---

# Address Operator

```cpp
int a=10;

cout<<&a;
```

Gets address.

---

# Dereference

```cpp
int a=10;

int *ptr=&a;

cout<<*ptr;
```

Output

```
10
```

---

Diagram

```
a=10

Address 100

ptr

stores

100

*ptr

means value at 100

10
```

---

# nullptr

Modern NULL.

```cpp
int *ptr=nullptr;
```

Means

Pointer points nowhere.

---

# new

Dynamic allocation.

```cpp
int *ptr=new int(5);

cout<<*ptr;
```

Memory from heap.

---

# delete

```cpp
delete ptr;
```

Frees heap memory.

Otherwise memory leak.

---

# Pass by Pointer

```cpp
void change(int *x){

*x=20;

}

int main(){

int a=10;

change(&a);

}
```

---

# Pass by Reference

```cpp
void change(int &x){

x=20;

}
```

Cleaner than pointer.

---

# Pointer vs Reference

| Pointer           | Reference |
| ----------------- | --------- |
| Stores address    | Alias     |
| Can be nullptr    | Cannot    |
| Can change target | Cannot    |
| Need *            | No        |

Interview favorite.

---

# STL ⭐⭐⭐⭐⭐

---

# vector

Dynamic array.

```cpp
vector<int> v;
```

---

push_back

```cpp
v.push_back(10);

v.push_back(20);
```

---

size

```cpp
cout<<v.size();
```

---

begin

```cpp
v.begin()
```

Iterator to first.

---

end

```cpp
v.end()
```

Iterator after last.

---

Loop

```cpp
for(int x:v)

cout<<x;
```

---

# unordered_map

HashMap in Java.

```cpp
unordered_map<string,int> mp;
```

Insert

```cpp
mp["A"]=10;

mp.insert({"B",20});
```

Count

```cpp
mp.count("A")
```

Returns

0 or 1.

---

Find

```cpp
mp.find("A")
```

Returns iterator.

---

Access

```cpp
cout<<mp["A"];
```

---

# map

Same as TreeMap.

Sorted.

Uses Red Black Tree.

O(log n)

---

Difference

| unordered_map | map      |
| ------------- | -------- |
| Hash Table    | Tree     |
| O(1)          | O(log n) |
| No order      | Sorted   |

Very common interview question.

---

# unordered_set

Stores unique values.

```cpp
unordered_set<int> s;

s.insert(10);

s.insert(20);
```

---

# Queue

FIFO

```cpp
queue<int> q;

q.push(10);

q.push(20);

q.front();

q.pop();
```

---

# Stack

LIFO

```cpp
stack<int> st;

st.push(5);

st.top();

st.pop();
```

---

# Priority Queue

Default

Max Heap

```cpp
priority_queue<int> pq;

pq.push(5);

pq.push(10);

cout<<pq.top();
```

Output

```
10
```

---

Min Heap

```cpp
priority_queue<int, vector<int>, greater<int>> pq;
```

---

# pair

```cpp
pair<int,string> p;

p={1,"John"};

cout<<p.first;

cout<<p.second;
```

---

# sort()

```cpp
vector<int> v={5,2,9,1};

sort(v.begin(),v.end());
```

Descending

```cpp
sort(v.begin(),v.end(),greater<int>());
```

---

# Custom Comparator (Basic Idea)

Used when default sorting isn't enough.

Example: sort by second value of a pair.

```cpp
bool cmp(pair<int,int> a, pair<int,int> b) {
    return a.second < b.second;
}

int main() {
    vector<pair<int,int>> v = {{1,5},{2,2},{3,8}};
    sort(v.begin(), v.end(), cmp);
}
```

The comparator returns `true` if `a` should come before `b`. This lets you define your own sorting logic.

---

# Rapid Revision

* Constructor → Initializes object.
* Destructor → Frees resources automatically.
* Copy constructor → Creates an object from another object.
* Encapsulation → Hide data using `private`.
* Inheritance → Reuse parent class.
* Function overloading → Same function, different parameters.
* Function overriding → Child provides new implementation of parent function.
* Virtual function → Enables runtime polymorphism.
* Pure virtual function (`=0`) → Makes a class abstract.
* Friend function → Can access private members.
* Pointer → Stores an address.
* `&` → Address-of operator.
* `*` → Dereference operator (or pointer declaration depending on context).
* `new` → Allocate memory on the heap.
* `delete` → Free heap memory.
* Reference (`&`) → Alias for an existing variable; cannot be null.
* `vector` → Dynamic array.
* `unordered_map` → Hash table, average `O(1)` lookup.
* `map` → Sorted tree, `O(log n)` lookup.
* `unordered_set` → Unique elements using hashing.
* `queue` → FIFO (`front()`).
* `stack` → LIFO (`top()`).
* `priority_queue` → Max heap by default; use `greater<int>` for a min heap.
* `pair` → Stores two related values.
* `sort()` → Sorts a range; accepts an optional custom comparator.

If you can confidently write these snippets on paper and explain *why* each feature exists, you'll be well prepared for a typical C++ P2P round.
