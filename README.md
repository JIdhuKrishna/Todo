# TODO List Project

A simple Spring Boot TODO list application that displays tasks in a web interface.

## How to Run in Eclipse

1. **Import Project:**
   - File → Import → Existing Maven Projects
   - Browse to: `c:\Users\austi\Downloads\todo-list-project`
   - Click Finish

2. **Run Application:**
   - Right-click `TodoListApplication.java`
   - Run As → Java Application

3. **View TODO List:**
   - Open browser: `http://localhost:8080`

## Features

- ✅ Clean, professional web interface
- ✅ Task priority levels (HIGH, MEDIUM, LOW)
- ✅ Completion status tracking
- ✅ Statistics dashboard
- ✅ Responsive design
- ✅ Bootstrap styling

## Project Structure

```
todo-list-project/
├── src/main/java/com/todolist/
│   ├── TodoListApplication.java          (Main class)
│   └── controller/TodoController.java    (Web controller)
├── src/main/resources/
│   ├── application.properties           (Config)
│   └── templates/todolist.html         (Web page)
└── pom.xml                             (Dependencies)
```

## TODO Items Included

1. ✅ Enhance Login Page UI/UX (COMPLETED)
2. ❌ Add Login Error Handling (HIGH PRIORITY)
3. ❌ Implement Remember Me Feature (MEDIUM PRIORITY)
4. ❌ Add Password Reset Functionality (MEDIUM PRIORITY)
5. ❌ Enhance User Registration Validation (HIGH PRIORITY)
6. ❌ Implement User Profile Management (MEDIUM PRIORITY)
7. ❌ Add Session Management (MEDIUM PRIORITY)
8. ❌ Create Login Activity Logging (LOW PRIORITY)
9. ❌ Implement Role-Based Redirects (HIGH PRIORITY)
10. ❌ Add CSRF Protection Enhancement (HIGH PRIORITY)
11. ❌ Create Login Page Testing (MEDIUM PRIORITY)
12. ❌ Add Multi-Factor Authentication (LOW PRIORITY)

This is a standalone project with no dependencies or connections to other projects.