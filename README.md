# 💊 Pharmacy Management System  
*Ain Shams University - Faculty of Engineering*  
*CSE 231s: Advanced Computer Programming Project*  

![Java](https://img.shields.io/badge/Java-17-%23ED8B00.svg?logo=openjdk)
![OOP](https://img.shields.io/badge/OOP-Design-%2300C4CC.svg?logo=oop)
![License](https://img.shields.io/badge/License-MIT-%233DA639.svg)

## 📌 Project Context  
Developed as part of **Ain Shams University's** engineering curriculum, this system models a real-world pharmacy using rigorous object-oriented design. It serves as a practical application of theoretical CS concepts in a healthcare management scenario.

---

## 🎯 Learning Objectives  
1. **Master Core OOP Principles**  
   - Implement inheritance, polymorphism, and abstraction.  
   - Design robust class hierarchies for real-world entities.  
2. **Advanced Java Techniques**  
   - Generic sorting with `Comparable`/`Comparator`.  
   - Custom exception handling.  
3. **Software Engineering Practices**  
   - Modular design for maintainability.  
   - Documentation-driven development.  

---

## 🧩 OOP Principles Applied  

### 1. **Inheritance**
  - Abstract `Item` superclass
  - `Medicine` and `PersonalCare` subclasses
  - Multi-level hierarchy (`Paracetamol` → `Medicine` → `Item`)

### 2. **Polymorphism**
  - Method overriding (`describe()`)
  - Interface implementation (`Dosable`, `Payable`)

### 3. **Abstraction**
  - Abstract methods (`isPrescriptionRequired()`)
  - Interfaces (`getDosageInstructions()`)

### 4. **Encapsulation**
  - Private fields with getters/setters
  - Immutable `ID` field

### 5. **Composition**
  - `Order` contains `List<Item>`
  - `Stock` manages `ArrayList<Item>`

### 6. **Generics**
  - Type-safe collections (`List<Medicine>`)
  - `Comparable<Item>` for sorting
