package com.dj.trelloprojetcrepeat.member.entity;

import com.dj.trelloprojetcrepeat.member.enums.MemberRole;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MemeberId implements Serializable {
    private Long userId;
    private Long worksapceId;
    private MemberRole memberRole;
}




