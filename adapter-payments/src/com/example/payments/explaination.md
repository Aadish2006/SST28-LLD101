```md
# Adapter Refactoring – Payment Gateways

## Overview
The payment system originally had `OrderService` directly interacting with different SDK clients (`FastPayClient` and `SafeCashClient`).  
Each provider had a different API, which caused tight coupling and duplicated integration logic.

To improve flexibility and maintainability, the **Adapter Design Pattern** was applied.

---

# Problems in the Original Design

1. **Tight Coupling**
   - `OrderService` depended directly on SDK classes.

2. **Different APIs**
   - `FastPayClient` used `payNow(customerId, amount)`
   - `SafeCashClient` used `createPayment()` followed by `confirm()`

3. **Difficult to Extend**
   - Adding a new payment provider would require modifying `OrderService`.

---

# Solution: Adapter Pattern

A common interface called **`PaymentGateway`** was introduced.

```

PaymentGateway
|
+-- FastPayAdapter
|
+-- SafeCashAdapter

````

Both adapters translate the unified `charge()` method into the specific SDK calls.

---

# Key Components

## 1. PaymentGateway (Target Interface)

```java
public interface PaymentGateway {
    String charge(String customerId, int amountCents);
}
````

Provides a **standard payment API** for the application.

---

## 2. FastPayAdapter

Wraps the `FastPayClient` SDK and maps the `charge()` call to `payNow()`.

Example mapping:

```
charge(customerId, amount)
        ↓
FastPayClient.payNow(customerId, amount)
```

---

## 3. SafeCashAdapter

Wraps `SafeCashClient`, which uses a different workflow.

Mapping:

```
charge(customerId, amount)
        ↓
createPayment(amount, customerId)
        ↓
confirm()
```

---

## 4. Gateway Registry

`App` creates a registry of adapters:

```
Map<String, PaymentGateway> gateways
```

Example:

```
fastpay  → FastPayAdapter
safecash → SafeCashAdapter
```

This allows dynamic provider selection.

---

## 5. OrderService Refactor

`OrderService` now depends only on the `PaymentGateway` interface.

```
PaymentGateway gw = gateways.get(provider);
return gw.charge(customerId, amount);
```

It no longer interacts directly with SDK classes.

---

# Benefits

* **Loose coupling** between business logic and SDKs
* **Easy extensibility** (add new adapter without modifying `OrderService`)
* **Cleaner architecture**
* **Unified payment interface**

---

# Result

Running the application prints transaction IDs for both providers:

```
FP#cust-1:1299
SC#pay(cust-2,1299)
```

Both payment systems work through the same interface, confirming the successful use of the **Adapter pattern**.

```

If you'd like, I can also give you a **super short 8-line version** (some professors prefer very minimal explanation files).
```

                 +-------------------+
                 |   OrderService    |
                 +-------------------+
                           |
                           v
                  PaymentGateway (interface)
                    /              \
                   /                \
        FastPayAdapter        SafeCashAdapter
             |                       |
             v                       v
       FastPayClient           SafeCashClient
                                    |
                                    v
                              SafeCashPayment

                              f