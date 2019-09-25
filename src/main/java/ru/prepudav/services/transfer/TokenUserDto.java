package ru.prepudav.services.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.prepudav.services.models.UserToken;

@Data
@AllArgsConstructor
public class TokenUserDto {
    private String value;

    public static TokenUserDto from(UserToken userToken) {
        return new TokenUserDto(userToken.getValue());
    }
}
