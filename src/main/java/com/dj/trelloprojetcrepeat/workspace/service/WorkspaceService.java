package com.dj.trelloprojetcrepeat.workspace.service;

import com.dj.trelloprojetcrepeat.auth.entity.AuthUser;
import com.dj.trelloprojetcrepeat.common.exception.CustomException;
import com.dj.trelloprojetcrepeat.common.exception.ErrorCode;
import com.dj.trelloprojetcrepeat.common.reponse.ApiResponse;
import com.dj.trelloprojetcrepeat.user.entity.User;
import com.dj.trelloprojetcrepeat.user.enums.UserRole;
import com.dj.trelloprojetcrepeat.user.repository.UserRepository;
import com.dj.trelloprojetcrepeat.workspace.entity.Workspace;
import com.dj.trelloprojetcrepeat.workspace.repository.WorkspaceRepository;
import com.dj.trelloprojetcrepeat.workspace.request.WorkspaceSaveRequest;
import com.dj.trelloprojetcrepeat.workspace.response.WorkspaceSaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WorkspaceService {

    private final WorkspaceRepository workspaceRepository;
    private final UserRepository userRepository;

    @Secured(UserRole.Authority.ADMIN)
    @Transactional
    public ApiResponse<WorkspaceSaveResponse> createWorkspace(AuthUser authUser, WorkspaceSaveRequest workspaceSaveRequest) {

        User user = userRepository.findById(authUser.getId())
                .orElseThrow(() -> new CustomException(ErrorCode.AUTH_USER_NOT_FOUND));

        Workspace workspace = workspaceRepository.save(new Workspace(workspaceSaveRequest, user));

        WorkspaceSaveResponse response = new WorkspaceSaveResponse(
                workspace.getId(),
                workspace.getTitle()
        );
        String message = "워크스페이스가 성공적으로 생성됐습니다.";

        return new ApiResponse<>(response, message);
    }
}
