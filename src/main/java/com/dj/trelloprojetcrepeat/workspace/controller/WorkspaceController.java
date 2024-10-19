package com.dj.trelloprojetcrepeat.workspace.controller;

import com.dj.trelloprojetcrepeat.auth.entity.AuthUser;
import com.dj.trelloprojetcrepeat.common.reponse.ApiResponse;
import com.dj.trelloprojetcrepeat.workspace.request.WorkspaceSaveRequest;
import com.dj.trelloprojetcrepeat.workspace.response.WorkspaceSaveResponse;
import com.dj.trelloprojetcrepeat.workspace.service.WorkspaceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workspaces")
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    @PostMapping
    public ResponseEntity<ApiResponse<WorkspaceSaveResponse>> createWrokspace(
            @AuthenticationPrincipal AuthUser authUser,
            @Valid @RequestBody WorkspaceSaveRequest workspaceSaveRequest){
        return ResponseEntity.ok(workspaceService.createWorkspace(authUser, workspaceSaveRequest));
    }
}
