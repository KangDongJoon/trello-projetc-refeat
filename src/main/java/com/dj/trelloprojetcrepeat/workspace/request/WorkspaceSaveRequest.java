package com.dj.trelloprojetcrepeat.workspace.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WorkspaceSaveRequest {
    @NotBlank(message = "워크스페이스 제목은 반드시 입력해야합니다.")
    private String title;
    private String description;
}
