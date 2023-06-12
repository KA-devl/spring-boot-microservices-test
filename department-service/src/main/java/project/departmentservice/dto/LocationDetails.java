package project.departmentservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LocationDetails {

    private String city;
    private String country;
    private Integer houseNumber;
    private String street;

}
