# User List App — Full-Stack Assessment (York Solutions)

A simple full-stack application built with **Spring Boot 3 (Java 21)** and **React (Vite)**.  
It demonstrates an end-to-end setup where a UI fetches and displays users from an in-memory database,  
including client-side sorting, loading, and error handling.

## Prerequisites

Before you begin, make sure you have the following installed **(in this order):**

1. **Java 21** — required for running the Spring Boot backend  
   Verify installation:
   ```bash
   java -version

Expected output example: `openjdk 21.x.x`

2. **Maven** — required to build and run the API
   Verify installation:

   ```bash
   mvn -v
   ```

   Expected output example: `Apache Maven 3.x.x`

3. **Node.js (v18 or higher)** and **npm** — required for the React frontend
   Verify installation:

   ```bash
   node -v
   npm -v
   ```

   Expected output example: `v18.x` and `9.x`

⚠️ **Install Java first**, then Maven, then Node.js — in that order — to avoid path or environment conflicts.

## How to Set Up the Project Locally

1. **Clone the repository**

   ```bash
   git clone https://github.com/<your-username>/user-list-app.git
   cd user-list-app
   ```

2. Confirm that both folders exist:

   ```
   /api   → Spring Boot backend
   /ui    → React frontend
   ```

3. Continue with the next section to run each project.

## How to Run Both Projects

### Backend (API)

**Requirements:** Java 21 and Maven

**Steps:**

```bash
cd api
./mvnw spring-boot:run
```

**Base URL:** `http://localhost:8080/api/v1/users`
**H2 Console:** `http://localhost:8080/h2-console`

**H2 Credentials**

* JDBC URL: `jdbc:h2:mem:testdb`
* Username: `sa`
* Password: *(leave blank)*

**Seed Data:**
10 sample users are inserted automatically at startup via a `CommandLineRunner`.

### Frontend (UI)

**Requirements:** Node 18+ and npm

**Steps:**

```bash
cd ui
npm install
npm run dev
```

**Runs on:** `http://localhost:5173`

**Environment Configuration**

Create a `.env` file in `/ui` containing:

```
VITE_API_BASE_URL=http://localhost:8080/api/v1
```

The frontend fetches users from this backend API when the page loads.

## Tech Choices

| Layer     | Technology                                        |
| --------- | ------------------------------------------------- |
| Backend   | Java 21, Spring Boot 3.2, Maven, H2 Database, JPA |
| Frontend  | React 18 (Vite), Fetch API                        |
| Dev Tools | Git, VS Code, GitHub                              |

## How to Test Sorting & UX States

### Sorting

1. Start both backend and frontend.
2. Visit `http://localhost:5173`.
3. Click the **Last Name** column header to sort ascending (A → Z).
4. Click again to toggle descending (Z → A) — the ▲/▼ indicator updates.

### Loading State

When the frontend initially fetches data, it briefly displays
`Loading users...` before rendering the table.

### Error State

Stop the backend (`Ctrl +C` in its terminal) and refresh the frontend.
The UI displays:
`Error: Failed to fetch`
 This confirms proper error handling.

## Assumptions / Trade-Offs

* Used **CommandLineRunner** instead of `data.sql` for easy seed management.
* Kept styling minimal (default Vite CSS) for simplicity and focus on functionality.
* No pagination or search — only client-side sorting as required.
* No Lombok — all getters/setters are explicit for clarity.
* CORS enabled globally for `http://localhost:*` to support local dev.

## Author

**Ashoor Doushow**
Junior Software Engineer
[LinkedIn](https://linkedin.com/in/ashoordoushow)
