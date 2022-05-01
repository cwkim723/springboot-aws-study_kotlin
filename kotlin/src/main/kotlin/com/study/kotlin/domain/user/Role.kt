package com.study.kotlin.domain.user

import lombok.Getter
import lombok.RequiredArgsConstructor

@Getter
@RequiredArgsConstructor
enum class Role (
    val key: String,
    val title: String,
){
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자")
}