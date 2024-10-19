package com.dj.trelloprojetcrepeat.member.entity;

import com.dj.trelloprojetcrepeat.member.enums.MemberRole;
import com.dj.trelloprojetcrepeat.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members")
public class Member {


    @EmbeddedId
    private MemeberId id; // 복합 키

    @ManyToOne
    @MapsId("userId")
    private User user;

/*    @ManyToOne
    @MapsId("workspaceId")
    private WorkSpace workSpace;*/

    private MemberRole memberRole;
}
