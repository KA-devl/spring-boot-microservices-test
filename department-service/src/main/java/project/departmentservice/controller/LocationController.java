package project.departmentservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.departmentservice.dto.LocationDetails;
import project.departmentservice.dto.LocationDto;
import project.departmentservice.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("api/locations")
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    public ResponseEntity<LocationDto> saveLocation(@RequestBody LocationDto locationDto) {
        return ResponseEntity.ok(locationService.saveLocation(locationDto));
    }

    @PatchMapping("/update/{locationId}")
    public ResponseEntity<LocationDto> updateLocation(@PathVariable Long locationId, @RequestBody LocationDto locationDto) {
        locationDto.setId(locationId);
        return ResponseEntity.ok(locationService.updateLocation(locationDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<LocationDetails>> getAllLocationsByDepartmentId(@PathVariable Long id) {
        return ResponseEntity.ok(locationService.getAllLocationsByDepartmentId(id));
    }
}
