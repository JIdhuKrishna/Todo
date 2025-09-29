# QUICK FIX - Run Interactive Todo List

## Problem: Internal Server Error 500

The error occurred because of complex Thymeleaf expressions in the template. Here's the simple solution:

## Eclipse Instructions:

### Step 1: Stop Current Application
In Eclipse console, press **Ctrl+C** or click the red **Terminate** button

### Step 2: Run the Simple Version
1. In Eclipse, go to your project
2. Navigate to: `src/main/java/com/todolist/controller/SimpleController.java`
3. Right-click on `SimpleController.java` 
4. **Run As > Java Application** (choose the main method if prompted)

OR run the main application:
1. Right-click on `TodoListApplication.java`
2. **Run As > Java Application**

### Step 3: Test the Simple Version
Open browser and go to:
```
http://localhost:8080/simple
```

## What You Should See:
✅ **Add Task Form** - Enter title, description, priority
✅ **Task Statistics** - Total, Pending, Completed counts  
✅ **Interactive Checkboxes** - Click to mark complete/incomplete
✅ **Delete Buttons** - Remove tasks with confirmation
✅ **Professional UI** - Bootstrap styling

## If Still Getting Errors:
1. **Check Eclipse Console** for error messages
2. **Clean Project**: Project menu > Clean > Select your project
3. **Refresh Project**: Right-click project > Refresh (F5)
4. **Check Port**: Make sure port 8080 is free

## Alternative URLs to Try:
- Main app: `http://localhost:8080/`
- Simple version: `http://localhost:8080/simple`
- Test endpoint: `http://localhost:8080/api/test`

The simple version uses in-memory storage and should work without any database issues!