package com.dj.trelloprojetcrepeat.workspace.entity;

import com.dj.trelloprojetcrepeat.user.entity.User;
import com.dj.trelloprojetcrepeat.workspace.request.WorkspaceSaveRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "workspaces")
public class Workspace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Workspace(WorkspaceSaveRequest workspaceSaveRequest, User user) {
        this.title = workspaceSaveRequest.getTitle();
        this.description = workspaceSaveRequest.getDescription();
        this.user = user;
    }
}
