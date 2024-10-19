package com.dj.trelloprojetcrepeat.member.enums;

/*
    MANAGER : 워크스페이스 생성을 제외한 모든 권한
    BOARD : 워크스페이스 관련 기능을 제외한 모든 기능
    READ_ONLY : 읽기전용으로 생성, 수정, 삭제 불가능
*/

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum MemberRole {

    MANAGER(Authority.MANAGER),
    BOARD(Authority.BOARD),
    READ_ONLY(Authority.READ_ONLY);

    private final String memberRole;

    public static MemberRole of(String memberRole){
        return Arrays.stream(MemberRole.values())
                .filter(r -> r.name().equalsIgnoreCase(memberRole))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 역할입니다"));
    }

    public static class Authority {
        public static final String MANAGER = "ROLE_MANAGER";
        public static final String BOARD = "ROLE_BOARD";
        public static final String READ_ONLY = "ROLE_READ_ONLY";
    }
}
