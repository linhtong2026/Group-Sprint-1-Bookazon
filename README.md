# 📚 Bookazon — Sprint 1 (Group 4)

> A tiny bookstore app that we used to practice **SOLID**, clean refactoring, and agile habits.  
> Come for the books, stay for the design improvements.

---

## ✨ What is this?

**Bookazon** started as a simple Java console app and grew into a small but well-structured codebase that demonstrates:
- Applying **SOLID** principles to an existing project
- Hunting down **code smells** and refactoring safely
- Writing small, focused **services** instead of a single “God class”
- Adding features without breaking existing behavior

---

## 🗺️ Quick Tour

```
src/
├── Address.java / AddressBook.java
├── media/
│   ├── Media.java
│   ├── Book.java  (CoverType.PAPERBACK|HARDCOVER)
│   ├── Audiobook.java (AudioFormat)
│   ├── DVD.java       (VideoFormat)
│   └── Ebook.java     (EbookFormat)
├── cart/
│   ├── Cart.java
│   └── CartItem.java  (correct equals/hashCode)
├── order/
│   ├── Order.java
│   └── OrderHistory.java
├── pricing/
│   └── DiscountService.java  (clean tier lookup)
├── services/
│   ├── CatalogService.java
│   ├── UserService.java
│   └── CheckoutService.java
└── Bookazon.java (thin demo / CLI entrypoint)
```

---

## 🧠 What we changed (highlights)

- **Split the monolith**: replaced the “God-class” `Bookazon` with `CatalogService`, `UserService`, and `CheckoutService` and kept `main` thin.
- **Address value object**: replaced 12 duplicated address fields + long parameter lists with `Address` + `AddressBook`.
- **Discounts**: refactored hard-coded if/else tier checks to a clean lookup via `DiscountService`.
- **Equality & snapshots**: fixed `CartItem.equals/hashCode` and made `Order` store a **snapshot** of items at checkout.
- **Types over booleans**: introduced `CoverType` enum for `Book` (retired `isPaperback`); removed legacy boolean helpers.
- **Media abstraction**: added `Media` hierarchy and support for **Audiobooks**, **DVDs**, and **E-books**.
- **Optional CLI**: add a book from the command line without changing default behavior.

---

## 🧪 Run it

```bash
# compile
javac *.java

# run (baseline demo)
java Bookazon
```

### Optional CLI: add a book at runtime
```bash
java Bookazon --addBook "Clean Code" "Robert C. Martin" 2008 29.99 paperback
```

- If provided, the book is inserted **before** the normal demo.
- If omitted, everything runs exactly as before.

---

## 🔍 Before → After (Design)

| Area | Before | After |
|---|---|---|
| Responsibilities | `Bookazon` did everything | Dedicated services: Catalog / User / Checkout |
| Discounts | Chained if/else with string tiers | Single lookup in `DiscountService` |
| Book cover type | `boolean isPaperback` | `CoverType` enum (`PAPERBACK`/`HARDCOVER`) |
| Addresses | 6-param setters sprinkled around | `Address` object + `AddressBook` |
| Order items | Live view of `Cart` items | Snapshot at checkout |
| Collections | Mutable lists exposed | Defensive/unmodifiable access in key paths |
| Printing | Intermixed with domain | Concentrated in demo + toString helpers |

---

## 🧩 Notable PRs (themes)

- **God-class → Services**: Broke `Bookazon` into `CatalogService`, `UserService`, `CheckoutService`.
- **Discounts cleanup**: Replaced string comparisons & nested conditionals with a `HashMap` rate lookup.
- **Correct equality**: Implemented `equals(Object)`/`hashCode()` for `CartItem`; orders no longer mutate when carts change.
- **CoverType enum**: Migrated from `isPaperback` to `CoverType`; removed legacy boolean helpers.
- **Address refactor**: Swapped long parameter lists for an `Address` value object used consistently.
- **Order printout**: Clear pricing breakdown (subtotal, tier/rate, discount amount, final total).
- **CLI extension**: `--addBook` for quick runtime additions (keeps backward compatibility).

---

## 🧼 Code smells we hunted

SRP violations, OCP (hard-coded discount branches), LSP risk (type flag), DIP gaps (no pricing abstraction), Leaky encapsulation, Exposed mutable lists, Long parameter lists / data clumps (addresses), Primitive obsession (strings for tiers, doubles for money), Domain printing, Anemic models.

---

## 🧯 Sample output (CLI flow)

```
$ java Bookazon --addBook "Clean Code" "Robert C. Martin" 2008 29.99 paperback
[CLI] Added book: Clean Code (PAPERBACK)
=== All Media Items ===
... (seeded items) ...
Title: Clean Code
Author: Robert C. Martin
Year Published: 2008
Price: $29.99
Cover: PAPERBACK
...
Pricing Breakdown:
Subtotal: $37.97
Subscription: Normal (No discount)
Discount Amount: $0.00
Final Total: $37.97
```

---

## 🚀 Ideas for future sprints

- Promo codes (Strategy), search/sort filters, inventory/stock, CSV export of receipts, and money type (`BigDecimal`) for accurate pricing.

---

## 👥 Team

**Group 4** — Anh Nguyen, Chinh Nguyen, Linh Tong  
We pair-reviewed changes, tracked issues, and kept each PR focused and reversible. (See the “Pull requests” tab for detailed “What/Why/How” narratives.)

---

## 📎 Appendix

- Sprint 1 report (methods, diagrams, and issue list) — see `/docs` or project files.
