package com.bna.booksapp.dtos;

public record SignUpDto(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
