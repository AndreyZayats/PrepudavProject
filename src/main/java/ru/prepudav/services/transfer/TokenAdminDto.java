package ru.prepudav.services.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.prepudav.services.models.AdminToken;

@Data
@AllArgsConstructor
public class TokenAdminDto {
    private String value;

    public static TokenAdminDto from(AdminToken adminToken) {
        return new TokenAdminDto(adminToken.getValue());
    }
}
