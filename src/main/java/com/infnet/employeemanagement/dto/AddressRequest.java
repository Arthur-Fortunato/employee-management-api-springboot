package com.infnet.employeemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    @NotBlank(message = "Street may not be blank")
    private String street;
    @NotBlank(message = "City may not be blank")
    private String city;
    @NotBlank(message = "State may not be blank")
    private String state;
    @NotBlank(message = "zipCode may not be blank")
    private String zipCode;
}
