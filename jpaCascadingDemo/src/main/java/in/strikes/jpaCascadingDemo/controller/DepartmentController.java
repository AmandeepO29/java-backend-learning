package in.strikes.jpaCascadingDemo.controller;

import in.strikes.jpaCascadingDemo.model.Department;
import in.strikes.jpaCascadingDemo.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody Department department){
        departmentService.createDepartment(department);
        return ResponseEntity.ok("DONE");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeDepartment(@PathVariable Long id){
        departmentService.removeDepartment(id);
        return ResponseEntity.ok("DONE");
    }
}
