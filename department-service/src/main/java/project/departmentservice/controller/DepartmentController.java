package project.departmentservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.departmentservice.dto.DepartmentDto;
import project.departmentservice.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.saveDepartment(departmentDto));
    }

    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode (@PathVariable String departmentCode) {
        return ResponseEntity.ok(departmentService.getDepartmentByCode(departmentCode));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments () {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PatchMapping("/update/{departmentCode}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable String departmentCode, @RequestBody DepartmentDto departmentDto) {
        departmentDto.setDepartmentCode(departmentCode);
        return ResponseEntity.ok(departmentService.updateDepartment(departmentDto));
    }
}
