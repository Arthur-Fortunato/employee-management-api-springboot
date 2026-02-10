package com.infnet.employeemanagement.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    @NotBlank(message = "Name may not be blank")
    private String firstName;
    @NotBlank(message = "Last name may not be blank")
    private String lastName;
    @Valid
    @NotNull
    private AddressRequest address;
}
