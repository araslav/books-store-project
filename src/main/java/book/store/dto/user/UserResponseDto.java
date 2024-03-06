package book.store.dto.user;

public record UserResponseDto(
        long id,
        String email,
        String firstName,
        String lastName,
        String shippingAddress
) {
}
