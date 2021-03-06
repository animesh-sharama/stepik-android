package org.stepik.android.domain.auth.model

enum class LoginFailType {
    CONNECTION_PROBLEM,
    TOO_MANY_ATTEMPTS,
    EMAIL_ALREADY_USED,
    EMAIL_PASSWORD_INVALID,

    EMAIL_NOT_PROVIDED_BY_SOCIAL,
    UNKNOWN_ERROR
}