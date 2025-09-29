# Interactive Todo List Application

This is a complete interactive Todo List application built with Spring Boot that allows users to:
- Add new tasks with titles, descriptions, and priorities
- Mark tasks as complete/incomplete using checkboxes
- Delete tasks
- View task statistics (Total, Pending, Completed)
- Professional UI with Bootstrap styling

## How to Run in Eclipse

### Method 1: Import as Maven Project
1. Open Eclipse IDE
2. Go to **File > Import**
3. Select **Existing Maven Projects** 
4. Browse to: `C:\Users\austi\Downloads\todo-list-project`
5. Click **Finish**
6. Wait for Maven to download dependencies
7. Right-click on `TodoListApplication.java` 
8. Select **Run As > Java Application**

### Method 2: Manual Setup
1. Open Eclipse IDE
2. Create a new Java Project called "TodoList"
3. Copy all files from `src/main/java` to your project's `src` folder
4. Copy all files from `src/main/resources` to your project's resources
5. Add these libraries to your project (download JAR files):
   - Spring Boot Starter Web
   - Spring Boot Starter Thymeleaf  
   - Spring Boot Starter Data JPA
   - H2 Database
6. Run `TodoListApplication.java` as Java Application

## Features

### Interactive Functionality:
- **Add Tasks**: Form at the top to add new tasks with title, description, and priority
- **Mark Complete**: Click checkboxes next to tasks to mark them as complete/incomplete
- **Delete Tasks**: Hover over tasks to see delete button (with confirmation)
- **Real-time Statistics**: See total, pending, and completed task counts
- **Professional UI**: Bootstrap styling with gradients and animations

### Database:
- Uses H2 in-memory database (data resets on restart)
- Automatic table creation via JPA/Hibernate
- All CRUD operations supported

## URLs after starting:
- Main Todo List: http://localhost:8080/
- H2 Database Console: http://localhost:8080/h2-console (for debugging)
  - JDBC URL: jdbc:h2:mem:todolist
  - Username: sa
  - Password: (empty)

## Project Structure:
```
src/main/java/com/todolist/
├── TodoListApplication.java      # Main Spring Boot application
├── controller/TodoController.java # Web controller (handles URLs)
├── entity/Todo.java              # Database entity
├── repository/TodoRepository.java # Database operations
└── service/TodoService.java      # Business logic

src/main/resources/
├── application.properties        # Database configuration
└── templates/todolist.html      # Interactive web page
```

## Troubleshooting:
1. If port 8080 is busy, change it in `application.properties`: `server.port=8081`
2. If dependencies are missing, ensure Maven is configured in Eclipse
3. Make sure Java 17+ is being used
4. Check Eclipse console for any error messages

The application will start and you can access it at http://localhost:8080/