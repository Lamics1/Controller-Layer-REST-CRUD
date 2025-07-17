package com.example.controllerlayerrestcrud.Controller;

import com.example.controllerlayerrestcrud.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Task> getAllTsak() {
        return tasks;
    }

    @PostMapping("/add")
    public String addTsak(@RequestBody Task task) {
        tasks.add(task);
        return "Task added successfully";
    }

    @PutMapping("/update/{index}")
    public String updateTask(@PathVariable int index, @RequestBody Task task) {
        tasks.set(index, task);
        return"Task update successfully" ;
    }

    @DeleteMapping("/delete/{index}")
    public String deleteTask(@PathVariable int index) {
        tasks.remove(index);
        return "Task deleted successfully";
    }

    @PutMapping("/status/{index}")
    public String changeTaskStatus(@PathVariable int index) {
        if (tasks.get(index).equals(true)) {
            tasks.get(index).setStatus(false);
        } else {
            tasks.get(index).setStatus(true);
        }
        return "change Task Status successfully";
    }

    @GetMapping("/search")
    public ArrayList<Task> searchTaskByTitle(@RequestParam String title) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                result.add(task);
            }
        }
        return result;
    }
}