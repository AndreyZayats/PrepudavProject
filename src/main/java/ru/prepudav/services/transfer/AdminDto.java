package ru.prepudav.services.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.prepudav.services.models.Admin;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminDto {
    private Long id;
    private String login;

    public static AdminDto from(Admin admin) {
        return AdminDto.builder()
                .id(admin.getId())
                .login(admin.getLogin())
                .build();
    }

    public static List<AdminDto> from(List<Admin> admins) {
        return admins.stream().map(AdminDto::from).collect(Collectors.toList());
    }
}
