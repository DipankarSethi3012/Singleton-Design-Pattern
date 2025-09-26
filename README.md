# Singleton Design Pattern

## Overview

The Singleton Design Pattern is a creational design pattern that ensures a class has only one instance and provides a global point of access to it. This pattern is widely used when exactly one object is needed to coordinate actions across a system, such as configuration managers, logging, caching, or driver objects.

### Why Singleton?
- **Controlled access to sole instance**: Only one instance exists, ensuring controlled resource usage.
- **Global access point**: Makes it easy to access the instance from anywhere in the application.
- **Lazy initialization**: The instance is created only when needed, optimizing resource usage.
- **Prevents accidental instantiation**: Restricts the instantiation of the class to one object.

---

## Implementation Strategies

This repository demonstrates multiple ways to implement the Singleton pattern in Java:

### 1. Eager Loading Singleton

The instance is created at the time of class loading. It is thread-safe but might create the instance even if it's not needed.

```java
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    private EagerSingleton() {}
    public static EagerSingleton getInstance() {
        return instance;
    }
}
```

- **Pros**: Simple, thread-safe by default.
- **Cons**: Instance created even if not used.

---

### 2. Lazy Loading Singleton

The instance is created only when requested for the first time.

#### a. Simple Lazy Loading (Not Thread-Safe)

```java
public class SimpleLazySingleton {
    private static SimpleLazySingleton instance;
    private SimpleLazySingleton() {}
    public static SimpleLazySingleton getInstance() {
        if (instance == null) {
            instance = new SimpleLazySingleton();
        }
        return instance;
    }
}
```

- **Cons**: Not thread-safe; multiple instances may be created in multithreaded environments.

#### b. Synchronized Method (Thread-Safe but Slow)

```java
public class SyncLazySingleton {
    private static SyncLazySingleton instance;
    private SyncLazySingleton() {}
    public static synchronized SyncLazySingleton getInstance() {
        if (instance == null) {
            instance = new SyncLazySingleton();
        }
        return instance;
    }
}
```

- **Pros**: Thread-safe.
- **Cons**: Synchronized method reduces performance.

#### c. Double-Checked Locking (Efficient Thread-Safety)

```java
public class DoubleLockSingleton {
    private static volatile DoubleLockSingleton instance;
    private DoubleLockSingleton() {}
    public static DoubleLockSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleLockSingleton.class) {
                if (instance == null) {
                    instance = new DoubleLockSingleton();
                }
            }
        }
        return instance;
    }
}
```

- **Pros**: Efficient, thread-safe.
- **Cons**: Slightly complex implementation.

#### d. Bill Pugh Singleton (Best Practice)

Utilizes a static inner helper class to handle lazy initialization, which is thread-safe and efficient.

```java
public class BillPughSingleton {
    private BillPughSingleton() {}
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
```

- **Pros**: Lazy loaded, thread-safe, high performance.
- **Cons**: Slightly less intuitive for beginners.

---

## How to Use Singleton in Production

- **Use Bill Pugh or Double-Checked Locking for thread safety and lazy loading.**
- **Avoid simple lazy initialization in multi-threaded environments.**
- **Singletons are best for shared resources (configuration, logger, cache, etc).**
- **Make constructors private and provide a static method for instance access.**
- **Be careful with serialization and reflection (can break singleton guarantees).**

---

## Example Use Case

Suppose you need a logger class in your application:

```java
public class Logger {
    private Logger() {}
    private static class LoggerHelper {
        private static final Logger INSTANCE = new Logger();
    }
    public static Logger getInstance() {
        return LoggerHelper.INSTANCE;
    }
    public void log(String message) {
        System.out.println(message);
    }
}
```

Usage:

```java
Logger logger = Logger.getInstance();
logger.log("Singleton Pattern in Action!");
```

---

## References

- [Oracle Docs: Singleton Pattern](https://docs.oracle.com/javase/tutorial/java/concepts/singleton.html)
- [Design Patterns: Elements of Reusable Object-Oriented Software](https://en.wikipedia.org/wiki/Design_Patterns)

---

## License

This repository is licensed under the MIT License.
